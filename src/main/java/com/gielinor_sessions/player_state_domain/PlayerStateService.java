
package com.gielinor_sessions.player_state_domain;

import javax.inject.Inject;

import com.gielinor_sessions.resources.DiaryService;

import lombok.Getter;

import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.gameval.VarPlayerID;

/*
 * TODO: Player State refresh handlers
 *
 * - On skill change
 * - On quest point change
 * - On quest status change
 * - On combat achievement change
 * - On achievement diary change
 */

@Getter
public class PlayerStateService
{
	private PlayerState playerState = new PlayerState();

	private final Client client;
	private final DiaryService diaryService;

	@Inject
	public PlayerStateService(
	    Client client,
	    DiaryService diaryService)
	{
		this.client = client;
		this.diaryService = diaryService;
	}

	// --------------------------------------------------
	// INITIALIZATION
	// --------------------------------------------------

	public void init()
	{
		playerState = new PlayerState();

		snapshotLevels();
		snapshotQuests();

		diaryService.populateIncompleteTasks(playerState);

		// TODO: snapshotBossKillCounts();
	}

	// --------------------------------------------------
	// SKILL SNAPSHOT
	// --------------------------------------------------

	/**
	 * Stores a snapshot of current levels and experience.
	 */
	private void snapshotLevels()
	{
		playerState.getLevels().clear();
		playerState.getExperience().clear();

		for (Skill skill : Skill.values())
		{
			playerState.getLevels().put(
			    skill,
			    client.getRealSkillLevel(skill));

			playerState.getExperience().put(
			    skill,
			    client.getSkillExperience(skill));
		}

		playerState.setCombatLevel(
		    client.getLocalPlayer().getCombatLevel());
	}

	// --------------------------------------------------
	// QUEST SNAPSHOT
	// --------------------------------------------------

	/**
	 * Stores current finished, in-progress and not-started quests.
	 */
	private void snapshotQuests()
	{
		playerState.getCompletedQuestSet().clear();
		playerState.getNotStartedQuestSet().clear();
		playerState.getInProgressQuestSet().clear();

		for (Quest quest : Quest.values())
		{
			QuestState state = quest.getState(client);

			switch (state)
			{
				case FINISHED:
					playerState.getCompletedQuestSet().add(quest);
					break;

				case NOT_STARTED:
					playerState.getNotStartedQuestSet().add(quest);
					break;

				case IN_PROGRESS:
					playerState.getInProgressQuestSet().add(quest);
					break;

				default:
					break;
			}
		}

		playerState.setQuestPoints(
		    client.getVarpValue(VarPlayerID.QP));
	}

	// --------------------------------------------------
	// ACHIEVEMENT DIARIES
	// --------------------------------------------------

	/**
	 * Called when the achievement diary journal is opened.
	 *
	 * Only tasks identified in the journal are updated.
	 */
	public void updateAchievementDiaries()
	{
		diaryService.updateAchievementDiaries(playerState);
	}
}
