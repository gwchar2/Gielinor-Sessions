package com.gielinor_sessions.resources.achievement_diaries.requirements;

import com.gielinor_sessions.player_state_domain.PlayerState;
import lombok.Getter;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

@Getter
public final class AD_QUEST_REQUIREMENT implements AD_REQUIREMENT
{
	private final Quest quest;
	private final QuestState requiredState;

	public AD_QUEST_REQUIREMENT(Quest quest)
	{
		this(quest, QuestState.FINISHED);
	}

	public AD_QUEST_REQUIREMENT(
	    Quest quest,
	    QuestState requiredState)
	{
		this.quest = quest;
		this.requiredState = requiredState;
	}

	@Override
	public boolean isSatisfied(PlayerState playerState)
	{
		switch (requiredState)
		{
			case IN_PROGRESS:
				return playerState.getInProgressQuestSet().contains(quest)
				    || playerState.getCompletedQuestSet().contains(quest);

			case FINISHED:
				return playerState.getCompletedQuestSet().contains(quest);

			default:
				return false;
		}
	}
}