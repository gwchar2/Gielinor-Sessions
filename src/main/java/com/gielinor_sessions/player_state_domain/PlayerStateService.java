package com.gielinor_sessions.player_state_domain;

import com.gielinor_sessions.resources.combat_achievements.CB_ACHIEVEMENT;
import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.gameval.VarPlayerID;

@Getter
public class PlayerStateService
{
	private PlayerState playerState = new PlayerState();
	private Client client;

	public void Init(Client _client)
	{
		client = _client;
		snapshotLevels(playerState);
		snapshotQuests(playerState);
		snapshotCombatAcheivements(playerState);
		// completedAchievementsIds = ;
		// incompletedAchievementsIds = ;
		// bossKillCounts = ;
	}

	/*
	 * Stores a snapshot of current levels.
	 */
	private void snapshotLevels(PlayerState playerState)
	{
		for (Skill skill : Skill.values())
		{
			playerState.getLevels().put(skill, client.getRealSkillLevel(skill));
			playerState.getExperience().put(skill, client.getSkillExperience(skill));
		}

		playerState.setCombatLevel(client.getLocalPlayer().getCombatLevel());
	}

	/*
	 * Stores a snapshot of currently finished/in progress/not started quests.
	 */
	void snapshotQuests(PlayerState playerState)
	{
		for (Quest qst : Quest.values())
		{
			QuestState state = qst.getState(client);
			switch (state)
			{
				case FINISHED:
					playerState.getCompletedQuestSet().add(qst);
					break;
				case NOT_STARTED:
					playerState.getCompletedQuestSet().add(qst);
					break;
				case IN_PROGRESS:
					playerState.getCompletedQuestSet().add(qst);
					break;
				default:
					break;
			}
		}

		playerState.setQuestPoints(client.getVarpValue(VarPlayerID.QP));

	}

	/*
	 * Stores a snapshot of combat achievements
	 */
	void snapshotCombatAcheivements(PlayerState playerState)
	{
		for (CB_ACHIEVEMENT ca : CB_ACHIEVEMENT.values())
		{
			if (ca.isCompleted(client))
			{
				continue;
			}

			// TODO: (3) Fix this.
			if (ca.getGroup().isCompleted(client))
			{
				continue;
			}

			playerState.getIncompleteCombatAchievements().add(ca);
		}
	}
}
