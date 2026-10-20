package com.gielinor_sessions;

import com.gielinor_sessions.persistence.DiarySnapshot;
import com.gielinor_sessions.persistence.PersistenceCoordinator;
import com.gielinor_sessions.player_state_domain.PlayerStateService;
import com.gielinor_sessions.player_state_domain.PlayerStatePersistenceSupport;
import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AD_WIDGET_IDS;
import com.google.inject.Provides;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(name = "Gielinor Sessions", internalName = "gielinor-sessions", legacyDataDirectory = "geilinor-sessions")
public class GielinorSessionsPlugin extends Plugin
{
	@Inject
	private Client client;
	@Inject
	private ClientThread clientThread;
	@Inject
	private PlayerStateService playerService;
	@Inject
	private PersistenceCoordinator persistence;

	private boolean initializePlayerState;
	private boolean playerStateInitialized;
	private boolean persistenceReady;
	private String activeAccountName;
	private long accountGeneration;
	private final Map<AD_TASK, Boolean> observedSinceLogin = new HashMap<>();

	@Override
	protected void startUp() throws IOException
	{
		initializePlayerState = false;
		playerStateInitialized = false;
		persistenceReady = false;
		persistence.start(getPluginDirectory());
		log.debug("Gielinor Sessions started");
	}

	@Override
	protected void shutDown()
	{
		saveActivePlayer();
		clearActivePlayer();
		persistence.stop();
		log.debug("Gielinor Sessions stopped");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			initializePlayerState = true;
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			saveActivePlayer();
			clearActivePlayer();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!initializePlayerState || client.getGameState() != GameState.LOGGED_IN
		    || client.getLocalPlayer() == null || client.getLocalPlayer().getName() == null)
		{
			return;
		}

		String accountName = client.getLocalPlayer().getName();
		if (playerStateInitialized)
		{
			if (accountName != null && accountName.equals(activeAccountName))
			{
				initializePlayerState = false;
				return;
			}
			saveActivePlayer();
			clearActivePlayer();
		}

		playerService.init();
		activeAccountName = accountName;
		playerStateInitialized = true;
		initializePlayerState = false;
		final long generation = ++accountGeneration;
		persistence.load(accountName, (loadedAccount, snapshot) -> {
			if (generation != accountGeneration || !playerStateInitialized
			    || !loadedAccount.equals(activeAccountName))
			{
				return;
			}
			if (snapshot == null)
			{
				log.warn("[PLAYER LOAD] Failed; saving disabled for this account session");
				persistenceReady = false;
				return;
			}
			PlayerStatePersistenceSupport.mergeLoadedDiaries(
			    playerService.getPlayerState(), snapshot, observedSinceLogin);
			persistenceReady = true;
			if (!observedSinceLogin.isEmpty())
			{
				persistence.saveSoon(activeAccountName,
				    new DiarySnapshot(playerService.getPlayerState().getAchievementDiaryStatus()));
			}
		});
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != AD_WIDGET_IDS.GROUP)
			return;
		clientThread.invokeLater(() -> {
			if (!playerStateInitialized || client.getGameState() != GameState.LOGGED_IN)
				return;
			Map<AD_TASK, Boolean> before = new HashMap<>(
			    playerService.getPlayerState().getAchievementDiaryStatus());
			playerService.updateAchievementDiaries();
			Map<AD_TASK, Boolean> after = playerService.getPlayerState().getAchievementDiaryStatus();
			if (!before.equals(after))
			{
				for (Map.Entry<AD_TASK, Boolean> item : after.entrySet())
				{
					if (!item.getValue().equals(before.get(item.getKey())))
					{
						observedSinceLogin.put(item.getKey(), item.getValue());
					}
				}
				if (persistenceReady)
				{
					persistence.saveSoon(activeAccountName, new DiarySnapshot(after));
				}
			}
		});
	}

	private void saveActivePlayer()
	{
		if (playerStateInitialized && persistenceReady && activeAccountName != null)
		{
			persistence.saveNow(activeAccountName,
			    new DiarySnapshot(playerService.getPlayerState().getAchievementDiaryStatus()));
		}
	}

	private void clearActivePlayer()
	{
		accountGeneration++;
		initializePlayerState = false;
		playerStateInitialized = false;
		persistenceReady = false;
		activeAccountName = null;
		observedSinceLogin.clear();
	}

	@Provides
	GielinorSessionsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GielinorSessionsConfig.class);
	}
}
