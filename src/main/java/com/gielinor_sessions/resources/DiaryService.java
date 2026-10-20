package com.gielinor_sessions.resources;

import com.gielinor_sessions.player_state_domain.PlayerState;
import com.gielinor_sessions.resources.achievement_diaries.AD_GROUP;
import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import com.gielinor_sessions.resources.achievement_diaries.requirements.AD_REQUIREMENT;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AchievementDiaryParser;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AD_WIDGET_IDS;
import com.gielinor_sessions.resources.combat_achievements.CB_COMPLETION_READER;
import com.gielinor_sessions.resources.combat_achievements.CB_TASK;
import com.gielinor_sessions.resources.combat_achievements.CB_TASK_LOADER;
import java.util.*;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;

@Slf4j
@Singleton
public final class DiaryService
{
	private final Client client;
	private final AchievementDiaryParser parser;
	private final CB_TASK_LOADER taskLoader;
	private final CB_COMPLETION_READER completionReader;
	private List<CB_TASK> combatCatalogue;
	private Map<Integer, List<CB_TASK>> tasksByCompletionBucket = new HashMap<>();

	@Inject
	public DiaryService(Client client, AchievementDiaryParser parser,
	    CB_TASK_LOADER taskLoader, CB_COMPLETION_READER completionReader)
	{
		this.client = client;
		this.parser = parser;
		this.taskLoader = taskLoader;
		this.completionReader = completionReader;
	}

	public void populateIncompleteTasks(PlayerState playerState)
	{
		populateIncompleteCombatAchievements(playerState);
	}

	public void populateIncompleteCombatAchievements(PlayerState playerState)
	{
		loadCatalogueIfNeeded();
		Set<CB_TASK> incomplete = new HashSet<>();
		for (CB_TASK task : combatCatalogue)
		{
			if (!completionReader.isCompleted(task))
			{
				incomplete.add(task);
				log.debug(
				    "[COMBAT ACHIEVEMENTS] Added incomplete task: ID={}, Name={}, Description={}, Tier={}, Type={}, Boss={}",
				    task.getId(),
				    task.getName(),
				    task.getDescription(),
				    task.getGroup().getName(),
				    task.getType().getType(),
				    task.getBossName());
			}
		}
		playerState.getIncompleteCombatAchievements().clear();
		playerState.getIncompleteCombatAchievements().addAll(incomplete);
		log.info("[COMBAT ACHIEVEMENTS] Incomplete {}/{}", incomplete.size(), combatCatalogue.size());
	}

	private void loadCatalogueIfNeeded()
	{
		if (combatCatalogue != null)
		{
			return;
		}
		List<CB_TASK> loaded = taskLoader.load();
		Map<Integer, List<CB_TASK>> byBucket = new HashMap<>();
		for (CB_TASK task : loaded)
		{
			int bucket = completionReader.bucketForTask(task);
			byBucket.computeIfAbsent(bucket, ignored -> new ArrayList<>()).add(task);
		}
		tasksByCompletionBucket = byBucket;
		combatCatalogue = loaded;
	}

	public boolean isCombatCompletionVarp(int varpId)
	{
		return completionReader.bucketForVarp(varpId) >= 0;
	}

	public void updateCombatAchievements(PlayerState playerState, int varpId)
	{
		if (combatCatalogue == null)
		{
			return;
		}
		int bucket = completionReader.bucketForVarp(varpId);
		if (bucket < 0)
		{
			return;
		}
		for (CB_TASK task : tasksByCompletionBucket.getOrDefault(bucket, Collections.emptyList()))
		{
			if (completionReader.isCompleted(task))
			{
				playerState.getIncompleteCombatAchievements().remove(task);
			}
			else
			{
				playerState.getIncompleteCombatAchievements().add(task);
			}
		}
	}

	public boolean isTaskCompleted(AD_TASK task, PlayerState playerState)
	{
		return isGroupCompleted(task.getGroup())
		    || Boolean.TRUE.equals(playerState.getAchievementDiaryStatus().get(task));
	}

	public boolean isTaskCompleted(CB_TASK task)
	{
		return completionReader.isCompleted(task);
	}

	public boolean isGroupCompleted(AD_GROUP group)
	{
		return client.getVarbitValue(group.getCompletionVarbit()) == 1;
	}

	public boolean isEligible(AD_TASK task, PlayerState playerState)
	{
		for (AD_REQUIREMENT requirement : task.getRequirements())
		{
			if (!requirement.isSatisfied(playerState))
			{
				return false;
			}
		}
		return true;
	}

	public void removeTask(PlayerState playerState, AD_TASK task)
	{
		playerState.getIncompleteAchievementDiaries().remove(task);
	}

	public void removeTask(PlayerState playerState, CB_TASK task)
	{
		playerState.getIncompleteCombatAchievements().remove(task);
	}

	public void updateAchievementDiaries(PlayerState playerState)
	{
		Map<AD_TASK, Boolean> observed = parser.parse(
		    client.getWidget(AD_WIDGET_IDS.TITLE),
		    client.getWidget(AD_WIDGET_IDS.TEXT));

		for (Map.Entry<AD_TASK, Boolean> entry : observed.entrySet())
		{
			AD_TASK task = entry.getKey();
			boolean completed = entry.getValue();
			playerState.getAchievementDiaryStatus().put(task, completed);
			if (completed)
			{
				playerState.getIncompleteAchievementDiaries().remove(task);
			}
			else
			{
				playerState.getIncompleteAchievementDiaries().add(task);
			}
		}
		if (!observed.isEmpty())
		{
			log.info("[DIARY] Observed {} statuses; {} total stored",
			    observed.size(), playerState.getAchievementDiaryStatus().size());
		}
	}
}
