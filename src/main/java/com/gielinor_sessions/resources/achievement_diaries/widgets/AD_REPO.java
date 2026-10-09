package com.gielinor_sessions.resources.achievement_diaries.widgets;

import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class AD_REPO
{
	private static final int SCHEMA_VERSION = 1;

	private static final Path DATA_DIRECTORY = Paths.get(
	    System.getProperty("user.home"),
	    ".runelite",
	    "geilinor-sessions");

	private final Gson gson = new GsonBuilder()
	    .setPrettyPrinting()
	    .create();

	public Map<AD_TASK, Boolean> load(
	    String accountName,
	    Collection<AD_TASK> tasks)
	{
		Map<AD_TASK, Boolean> result = new HashMap<>();
		Path file = getAccountFile(accountName);

		if (!Files.exists(file))
		{
			log.info("No saved achievement diary data for {}", accountName);
			return result;
		}

		try
		{
			JsonObject root = readExistingFile(file, accountName);
			JsonObject savedTasks = root.getAsJsonObject("achievementDiaries");

			if (savedTasks == null)
			{
				throw new IllegalStateException("Missing achievementDiaries field");
			}

			for (AD_TASK task : tasks)
			{
				JsonElement value = savedTasks.get(getTaskKey(task));

				if (value != null && value.isJsonPrimitive()
				    && value.getAsJsonPrimitive().isBoolean())
				{
					result.put(task, value.getAsBoolean());
				}
			}

			long completed = result.values().stream()
			    .filter(Boolean.TRUE::equals)
			    .count();

			log.info("[DIARY LOAD] Account: {}, File: {}, Known: {}, Completed: {}, Incomplete: {}",
			    accountName, file.toAbsolutePath(), result.size(), completed,
			    result.size() - completed);
		}
		catch (IOException | RuntimeException e)
		{
			log.warn("Failed to load achievement diary data for {} from {}",
			    accountName, file, e);
			result.clear();
		}

		return result;
	}

	// Merge ONLY newly observed tasks; never remove tasks from other diary regions.
	public void save(String accountName, Map<AD_TASK, Boolean> observed)
	{
		if (observed.isEmpty())
		{
			return;
		}

		Path file = getAccountFile(accountName);
		Path temporaryFile = null;

		try
		{
			Files.createDirectories(DATA_DIRECTORY);

			// If existing JSON cannot be read, abort instead of overwriting it.
			JsonObject root = Files.exists(file)
			    ? readExistingFile(file, accountName)
			    : new JsonObject();

			JsonObject savedTasks = root.getAsJsonObject("achievementDiaries");
			if (savedTasks == null)
			{
				if (Files.exists(file))
				{
					throw new IllegalStateException("Missing achievementDiaries field");
				}
				savedTasks = new JsonObject();
				root.add("achievementDiaries", savedTasks);
			}

			root.addProperty("schemaVersion", SCHEMA_VERSION);
			root.addProperty("accountName", accountName);

			int updated = 0;
			for (Map.Entry<AD_TASK, Boolean> entry : observed.entrySet())
			{
				if (entry.getValue() != null)
				{
					savedTasks.addProperty(getTaskKey(entry.getKey()), entry.getValue());
					updated++;
				}
			}

			temporaryFile = Files.createTempFile(DATA_DIRECTORY, "diaries-", ".tmp");

			try (Writer writer = Files.newBufferedWriter(
			    temporaryFile, StandardCharsets.UTF_8))
			{
				gson.toJson(root, writer);
			}

			try
			{
				Files.move(temporaryFile, file,
				    StandardCopyOption.ATOMIC_MOVE,
				    StandardCopyOption.REPLACE_EXISTING);
			}
			catch (AtomicMoveNotSupportedException e)
			{
				Files.move(temporaryFile, file,
				    StandardCopyOption.REPLACE_EXISTING);
			}

			log.info("[DIARY SAVE] Account: {}, Updated: {}, Total stored: {}, File: {}",
			    accountName, updated, savedTasks.size(), file.toAbsolutePath());
		}
		catch (IOException | RuntimeException e)
		{
			log.error("Failed to save achievement diary data for {}", accountName, e);
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
					log.warn("Failed to delete temporary diary file {}", temporaryFile, e);
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
				throw new IllegalStateException("Unsupported achievement diary schema version");
			}

			if (!root.has("accountName")
			    || !accountName.equals(root.get("accountName").getAsString()))
			{
				throw new IllegalStateException("Achievement diary file belongs to another account");
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

		String safeName = accountName.trim()
		    .replaceAll("[^a-zA-Z0-9 _-]", "_");

		return DATA_DIRECTORY.resolve(safeName + "_data.json");
	}

	private String getTaskKey(AD_TASK task)
	{
		Enum<?> constant = (Enum<?>) task;
		return constant.getDeclaringClass().getSimpleName() + "." + constant.name();
	}
}
