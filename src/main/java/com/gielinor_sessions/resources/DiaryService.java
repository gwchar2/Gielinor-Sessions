package com.gielinor_sessions.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.gielinor_sessions.player_state_domain.PlayerState;

import com.gielinor_sessions.resources.achievement_diaries.AD_ARDOUGNE_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_DESERT_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_FALADOR_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_FREMENNIK_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_GROUP;
import com.gielinor_sessions.resources.achievement_diaries.AD_KANDARIN_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_KARAMJA_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_KOUREND_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_LUMBRIDGE_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_MORYTANIA_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_VARROCK_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_WESTERN_TASK;
import com.gielinor_sessions.resources.achievement_diaries.AD_WILDERNESS_TASK;
import com.gielinor_sessions.resources.achievement_diaries.requirements.AD_REQUIREMENT;

import com.gielinor_sessions.resources.combat_achievements.CB_TASK;
import com.gielinor_sessions.resources.combat_achievements.CB_GROUP;

import net.runelite.api.Client;

public final class DiaryService
{
	private final Client client;

	private static final List<AD_TASK> ALL_ACHIEVEMENT_DIARIES = Arrays.stream(new AD_TASK[][] {
	    AD_ARDOUGNE_TASK.values(),
	    AD_DESERT_TASK.values(),
	    AD_FALADOR_TASK.values(),
	    AD_FREMENNIK_TASK.values(),
	    AD_KANDARIN_TASK.values(),
	    AD_KARAMJA_TASK.values(),
	    AD_KOUREND_TASK.values(),
	    AD_LUMBRIDGE_TASK.values(),
	    AD_MORYTANIA_TASK.values(),
	    AD_VARROCK_TASK.values(),
	    AD_WESTERN_TASK.values(),
	    AD_WILDERNESS_TASK.values()
	})
	    .flatMap(Arrays::stream)
	    .collect(Collectors.toList());

	private static final List<CB_TASK> ALL_COMBAT_ACHIEVEMENTS = Arrays.asList(CB_TASK.values());

	@Inject
	public DiaryService(Client client)
	{
		this.client = client;
	}

	public void populateIncompleteTasks(PlayerState playerState)
	{
		populateIncompleteAchievementDiaries(playerState);
		populateIncompleteCombatAchievements(playerState);
	}

	public void populateIncompleteAchievementDiaries(PlayerState playerState)
	{
		playerState.getIncompleteAchievementDiaries().clear();

		for (AD_TASK task : ALL_ACHIEVEMENT_DIARIES)
		{
			if (!isTaskCompleted(task))
			{
				playerState.getIncompleteAchievementDiaries().add(task);
			}
		}
	}

	public void populateIncompleteCombatAchievements(PlayerState playerState)
	{
		playerState.getIncompleteCombatAchievements().clear();

		for (CB_TASK task : ALL_COMBAT_ACHIEVEMENTS)
		{
			if (!isTaskCompleted(task))
			{
				playerState.getIncompleteCombatAchievements().add(task);
			}
		}
	}

	public boolean isTaskCompleted(AD_TASK task)
	{
		/*
		 * If the entire diary group is already completed,
		 * every task belonging to that group is completed.
		 */
		if (isGroupCompleted(task.getGroup()))
		{
			return true;
		}

		return client.getVarbitValue(task.getCompletionVarbit()) == 1;
	}

	public boolean isTaskCompleted(CB_TASK task)
	{
		return client.getVarbitValue(task.getCompletionVarbit()) == 1;
	}

	public boolean isGroupCompleted(AD_GROUP group)
	{
		return client.getVarbitValue(group.getCompletionVarbit()) == 1;
	}

	public boolean isEligible(
	    AD_TASK task,
	    PlayerState playerState)
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

	public void removeTask(
	    PlayerState playerState,
	    AD_TASK task)
	{
		playerState.getIncompleteAchievementDiaries().remove(task);
	}

	public void removeTask(
	    PlayerState playerState,
	    CB_TASK task)
	{
		playerState.getIncompleteCombatAchievements().remove(task);
	}
}