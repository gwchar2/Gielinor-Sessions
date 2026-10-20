package com.gielinor_sessions.persistence;

import com.gielinor_sessions.resources.achievement_diaries.*;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.nio.file.AtomicMoveNotSupportedException;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.client.util.Filepath;

@Slf4j
@Singleton
public final class JsonFileRepository
{
	private static final int SCHEMA_VERSION = 1;
	private static final String DIARIES_KEY = "achievementDiaries";
	private static final Map<String, AD_TASK> TASK_BY_KEY = buildTaskKeys();
	private final Gson gson;
	private Filepath directory;

	@Inject
	public JsonFileRepository(Gson gson)
	{
		this.gson = gson.newBuilder().setPrettyPrinting().create();
	}

	public void setDirectory(Filepath directory)
	{
		this.directory = directory;
	}

	public DiarySnapshot load(String accountName) throws IOException
	{
		Filepath file = accountFile(accountName);
		if (!file.exists())
		{
			return new DiarySnapshot(new HashMap<>());
		}
		JsonObject root = readExistingFile(file, accountName);
		JsonObject diaryData = root.getAsJsonObject(DIARIES_KEY);
		if (diaryData == null)
		{
			throw new IOException("Missing achievementDiaries section");
		}
		Map<AD_TASK, Boolean> restored = new HashMap<>();
		for (Map.Entry<String, JsonElement> entry : diaryData.entrySet())
		{
			AD_TASK task = TASK_BY_KEY.get(entry.getKey());
			JsonElement value = entry.getValue();
			if (task != null && value.isJsonPrimitive() && value.getAsJsonPrimitive().isBoolean())
			{
				restored.put(task, value.getAsBoolean());
			}
		}
		log.debug("[PLAYER LOAD] Account={}, statuses={}", accountName, restored.size());
		return new DiarySnapshot(restored);
	}

	public void save(String accountName, DiarySnapshot snapshot) throws IOException
	{
		directory.createDirectories();
		Filepath file = accountFile(accountName);
		JsonObject root = file.exists() ? readExistingFile(file, accountName) : new JsonObject();
		JsonObject diaries = root.getAsJsonObject(DIARIES_KEY);
		if (diaries == null)
		{
			if (file.exists())
			{
				throw new IOException("Missing achievementDiaries section");
			}
			diaries = new JsonObject();
		}
		for (Map.Entry<AD_TASK, Boolean> entry : snapshot.getStatuses().entrySet())
		{
			if (entry.getKey() != null && entry.getValue() != null)
			{
				diaries.addProperty(taskKey(entry.getKey()), entry.getValue());
			}
		}
		root.add(DIARIES_KEY, diaries);
		root.addProperty("schemaVersion", SCHEMA_VERSION);
		root.addProperty("accountName", accountName);

		Filepath temp = directory.createTempFile("player-", ".tmp");
		try
		{
			FilepathAccess.writeContents(temp, gson.toJson(root));
			try
			{
				temp.moveTo(file, StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
			}
			catch (AtomicMoveNotSupportedException e)
			{
				temp.moveTo(file, StandardCopyOption.REPLACE_EXISTING);
			}
			log.debug("[PLAYER SAVE] Account={}, statuses={}", accountName, diaries.size());
		}
		finally
		{
			temp.deleteIfExists();
		}
	}

	private JsonObject readExistingFile(Filepath file, String accountName) throws IOException
	{
		try
		{
			JsonObject root = new JsonParser().parse(FilepathAccess.readContents(file)).getAsJsonObject();
			if (!root.has("schemaVersion") || root.get("schemaVersion").getAsInt() != SCHEMA_VERSION)
			{
				throw new IOException("Unsupported player data schema version");
			}
			if (!root.has("accountName") || !accountName.equals(root.get("accountName").getAsString()))
			{
				throw new IOException("Player data belongs to another account");
			}
			return root;
		}
		catch (RuntimeException e)
		{
			throw new IOException("Invalid player data JSON", e);
		}
	}

	private Filepath accountFile(String accountName)
	{
		if (directory == null)
		{
			throw new IllegalStateException("Repository directory is not initialized");
		}
		if (accountName == null || accountName.trim().isEmpty())
		{
			throw new IllegalArgumentException("Missing account name");
		}
		String safeName = accountName.trim().replaceAll("[^a-zA-Z0-9 _-]", "_");
		return directory.joinSegment(safeName + "_data.json");
	}

	private static String taskKey(AD_TASK task)
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
				result.put(taskKey(task), task);
			}
		}
		return result;
	}
}
