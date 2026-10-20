package com.gielinor_sessions.player_state_domain;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.gielinor_sessions.resources.DiaryService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;
import net.runelite.api.Skill;
import net.runelite.api.gameval.VarPlayerID;

@Slf4j
@Singleton
@Getter
public class PlayerStateService
{
	private PlayerState playerState = new PlayerState();
	private final Client client;
	private final DiaryService diaryService;

	@Inject
	public PlayerStateService(Client client, DiaryService diaryService)
	{
		this.client = client;
		this.diaryService = diaryService;
	}

	public void init()
	{
		playerState = new PlayerState();
		snapshotLevels();
		snapshotQuests();
		diaryService.populateIncompleteTasks(playerState);
	}

	public void refreshCombatAchievements()
	{
		diaryService.populateIncompleteCombatAchievements(playerState);
	}

	public void updateCombatAchievements(int varpId)
	{
		diaryService.updateCombatAchievements(playerState, varpId);
	}

	public boolean isCombatCompletionVarp(int varpId)
	{
		return diaryService.isCombatCompletionVarp(varpId);
	}

	private void snapshotLevels()
	{
		playerState.getLevels().clear();
		playerState.getExperience().clear();
		for (Skill skill : Skill.values())
		{
			playerState.getLevels().put(skill, client.getRealSkillLevel(skill));
			playerState.getExperience().put(skill, client.getSkillExperience(skill));
		}
		playerState.setCombatLevel(client.getLocalPlayer().getCombatLevel());
	}

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
		playerState.setQuestPoints(client.getVarpValue(VarPlayerID.QP));
	}

	public void updateAchievementDiaries()
	{
		diaryService.updateAchievementDiaries(playerState);
	}
}
