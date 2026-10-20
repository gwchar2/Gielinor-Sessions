package com.gielinor_sessions.persistence;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.util.Filepath;

@Slf4j
@Singleton
public final class PersistenceCoordinator
{
	private static final long SAVE_DEBOUNCE_MS = 1500;
	private final JsonFileRepository repository;
	private final ClientThread clientThread;
	private ScheduledExecutorService worker;
	private ScheduledFuture<?> pendingSave;
	private boolean active;

	@Inject
	public PersistenceCoordinator(JsonFileRepository repository, ClientThread clientThread)
	{
		this.repository = repository;
		this.clientThread = clientThread;
	}

	public void start(Filepath directory)
	{
		worker = Executors.newSingleThreadScheduledExecutor(r -> {
			Thread thread = new Thread(r, "gielinor-persistence");
			thread.setDaemon(true);
			return thread;
		});
		active = true;
		worker.execute(() -> repository.setDirectory(directory));
	}

	public void load(String account, BiConsumer<String, DiarySnapshot> callback)
	{
		if (!active)
			return;
		worker.execute(() -> {
			DiarySnapshot snapshot;
			try
			{
				snapshot = repository.load(account);
			}
			catch (IOException | RuntimeException e)
			{
				log.error("[PLAYER LOAD] Account={}", account, e);
				snapshot = null;
			}
			final DiarySnapshot result = snapshot;
			clientThread.invoke(() -> callback.accept(account, result));
		});
	}

	public void saveSoon(String account, DiarySnapshot snapshot)
	{
		if (!active)
			return;
		if (pendingSave != null)
			pendingSave.cancel(false);
		pendingSave = worker.schedule(() -> write(account, snapshot), SAVE_DEBOUNCE_MS, TimeUnit.MILLISECONDS);
	}

	public void saveNow(String account, DiarySnapshot snapshot)
	{
		if (!active)
			return;
		if (pendingSave != null)
			pendingSave.cancel(false);
		try
		{
			worker.execute(() -> write(account, snapshot));
		}
		catch (RejectedExecutionException e)
		{
			log.debug("Persistence worker already stopped");
		}
	}

	private void write(String account, DiarySnapshot snapshot)
	{
		try
		{
			repository.save(account, snapshot);
		}
		catch (IOException | RuntimeException e)
		{
			log.error("[PLAYER SAVE] Account={}", account, e);
		}
	}

	public void stop()
	{
		active = false;
		if (pendingSave != null)
			pendingSave.cancel(false);
		if (worker != null)
			worker.shutdownNow();
		worker = null;
		pendingSave = null;
	}
}
