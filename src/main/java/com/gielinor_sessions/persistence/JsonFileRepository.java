package com.gielinor_sessions.persistence;

import com.gielinor_sessions.player_state_domain.PlayerState;
import com.gielinor_sessions.resources.achievement_diaries.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

/** Persists selected PlayerState fields; no game-client or widget access. */
@Slf4j
@Singleton
public final class JsonFileRepository
{
	private static final int SCHEMA_VERSION = 1;
	private static final String DIARIES_KEY = "achievementDiaries";
	private static final Path DATA_DIRECTORY = Paths.get(
	    System.getProperty("user.home"), ".runelite", "geilinor-sessions");

	private static final Map<String, AD_TASK> TASK_BY_KEY = buildTaskKeys();
	private final Gson gson;

	@Inject
	public JsonFileRepository(Gson gson)
	{
		this.gson = gson.newBuilder().setPrettyPrinting().create();
	}

	/** Returns false on corrupted, unsupported, or inaccessible existing files. */
	public boolean load(String accountName, PlayerState state)
	{
		Path file = getAccountFile(accountName);
		if (!Files.exists(file))
		{
			log.info("[PLAYER LOAD] No saved data for {}", accountName);
			return true;
		}

		try
		{
			JsonObject root = readExistingFile(file, accountName);
			JsonObject diaryData = root.getAsJsonObject(DIARIES_KEY);
			if (diaryData == null)
			{
				throw new IllegalStateException("Missing achievementDiaries section");
			}

			Map<AD_TASK, Boolean> restored = new HashMap<>();
			for (Map.Entry<String, JsonElement> entry : diaryData.entrySet())
			{
				AD_TASK task = TASK_BY_KEY.get(entry.getKey());
				JsonElement value = entry.getValue();
				if (task != null && value.isJsonPrimitive()
				    && value.getAsJsonPrimitive().isBoolean())
				{
					restored.put(task, value.getAsBoolean());
				}
			}

			state.getAchievementDiaryStatus().clear();
			state.getAchievementDiaryStatus().putAll(restored);
			state.rebuildIncompleteAchievementDiaries();
			log.info("[PLAYER LOAD] Account={}, diary statuses={}", accountName, restored.size());
			return true;
		}
		catch (IOException | RuntimeException e)
		{
			log.error("[PLAYER LOAD] Failed for {}. Saving is disabled for this session.", accountName, e);
			return false;
		}
	}

	/**
	 * One snapshot at logout/shutdown; preserves other JSON sections and unknown
	 * keys.
	 */
	public boolean save(String accountName, PlayerState state)
	{
		Path file = getAccountFile(accountName);
		Path temporaryFile = null;
		try
		{
			Files.createDirectories(DATA_DIRECTORY);
			JsonObject root = Files.exists(file)
			    ? readExistingFile(file, accountName)
			    : new JsonObject();
			JsonObject diaries = root.getAsJsonObject(DIARIES_KEY);
			if (diaries == null)
			{
				if (Files.exists(file))
				{
					throw new IllegalStateException("Missing achievementDiaries section");
				}
				diaries = new JsonObject();
				root.add(DIARIES_KEY, diaries);
			}

			for (Map.Entry<AD_TASK, Boolean> entry : state.getAchievementDiaryStatus().entrySet())
			{
				if (entry.getKey() != null && entry.getValue() != null)
				{
					diaries.addProperty(getTaskKey(entry.getKey()), entry.getValue());
				}
			}
			root.addProperty("schemaVersion", SCHEMA_VERSION);
			root.addProperty("accountName", accountName);

			temporaryFile = Files.createTempFile(DATA_DIRECTORY, "player-", ".tmp");
			try (Writer writer = Files.newBufferedWriter(temporaryFile, StandardCharsets.UTF_8))
			{
				gson.toJson(root, writer);
			}
			try
			{
				Files.move(temporaryFile, file,
				    StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
			}
			catch (AtomicMoveNotSupportedException e)
			{
				Files.move(temporaryFile, file, StandardCopyOption.REPLACE_EXISTING);
			}
			log.info("[PLAYER SAVE] Account={}, diary statuses={}, file={}",
			    accountName, diaries.size(), file.toAbsolutePath());
			return true;
		}
		catch (IOException | RuntimeException e)
		{
			log.error("[PLAYER SAVE] Failed for {}", accountName, e);
			return false;
		}
		finally
		{
			if (temporaryFile != null)
			{
				try
				{
					Files.deleteIfExists(temporaryFile);
				}
				catch (IOException e)
				{
					log.warn("Failed to remove temporary file {}", temporaryFile, e);
				}
			}
		}
	}

	private JsonObject readExistingFile(Path file, String accountName) throws IOException
	{
		try (Reader reader = Files.newBufferedReader(file, StandardCharsets.UTF_8))
		{
			JsonObject root = new JsonParser().parse(reader).getAsJsonObject();
			if (!root.has("schemaVersion")
			    || root.get("schemaVersion").getAsInt() != SCHEMA_VERSION)
			{
				throw new IllegalStateException("Unsupported player data schema version");
			}
			if (!root.has("accountName")
			    || !accountName.equals(root.get("accountName").getAsString()))
			{
				throw new IllegalStateException("Player data belongs to another account");
			}
			return root;
		}
	}

	private Path getAccountFile(String accountName)
	{
		if (accountName == null || accountName.trim().isEmpty())
		{
			throw new IllegalArgumentException("Account name is unavailable");
		}
		String safeName = accountName.trim().replaceAll("[^a-zA-Z0-9 _-]", "_");
		return DATA_DIRECTORY.resolve(safeName + "_data.json");
	}

	private static String getTaskKey(AD_TASK task)
	{
		Enum<?> constant = (Enum<?>) task;
		return constant.getDeclaringClass().getSimpleName() + "." + constant.name();
	}

	private static Map<String, AD_TASK> buildTaskKeys()
	{
		Map<String, AD_TASK> result = new HashMap<>();
		AD_TASK[][] catalogues = {
		    AD_ARDOUGNE_TASK.values(), AD_DESERT_TASK.values(), AD_FALADOR_TASK.values(),
		    AD_FREMENNIK_TASK.values(), AD_KANDARIN_TASK.values(), AD_KARAMJA_TASK.values(),
		    AD_KOUREND_TASK.values(), AD_LUMBRIDGE_TASK.values(), AD_MORYTANIA_TASK.values(),
		    AD_VARROCK_TASK.values(), AD_WESTERN_TASK.values(), AD_WILDERNESS_TASK.values()
		};
		for (AD_TASK[] catalogue : catalogues)
		{
			for (AD_TASK task : catalogue)
			{
				result.put(getTaskKey(task), task);
			}
		}
		return result;
	}
}
