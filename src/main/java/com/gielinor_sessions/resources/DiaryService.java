package com.gielinor_sessions.resources;

import com.gielinor_sessions.player_state_domain.PlayerState;
import com.gielinor_sessions.resources.achievement_diaries.AD_GROUP;
import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import com.gielinor_sessions.resources.achievement_diaries.requirements.AD_REQUIREMENT;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AchievementDiaryParser;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AD_WIDGET_IDS;
import com.gielinor_sessions.resources.combat_achievements.CB_TASK;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Singleton;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;

@Slf4j
@Singleton
public final class DiaryService
{
	private static final List<CB_TASK> ALL_COMBAT_ACHIEVEMENTS = Arrays.asList(CB_TASK.values());

	private final Client client;
	private final AchievementDiaryParser parser;

	@Inject
	public DiaryService(Client client, AchievementDiaryParser parser)
	{
		this.client = client;
		this.parser = parser;
	}

	public void populateIncompleteTasks(PlayerState playerState)
	{
		populateIncompleteCombatAchievements(playerState);
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

	// COMPLETION STATUS
	public boolean isTaskCompleted(AD_TASK task, PlayerState playerState)
	{
		if (isGroupCompleted(task.getGroup()))
		{
			return true;
		}
		return Boolean.TRUE.equals(playerState.getAchievementDiaryStatus().get(task));
	}

	public boolean isTaskCompleted(CB_TASK task)
	{
		return client.getVarbitValue(task.getCompletionVarbit()) == 1;
	}

	public boolean isGroupCompleted(AD_GROUP group)
	{
		return client.getVarbitValue(group.getCompletionVarbit()) == 1;
	}

	// ELIGIBILITY
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

	// REMOVAL
	public void removeTask(PlayerState playerState, AD_TASK task)
	{
		playerState.getIncompleteAchievementDiaries().remove(task);
	}

	public void removeTask(PlayerState playerState, CB_TASK task)
	{
		playerState.getIncompleteCombatAchievements().remove(task);
	}

	// Diary widgets update only the live PlayerState. Persistence runs at account
	// exit.
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
			log.info("[DIARY] Observed {} diary statuses in memory, total of {} in player state", observed.size(),
			    playerState.getAchievementDiaryStatus().size());
		}
	}
}
