package com.gielinor_sessions.resources.requirements;

import com.gielinor_sessions.player_state_domain.PlayerState;
import lombok.Getter;
import net.runelite.api.Quest;

@Getter
public final class AD_QUEST_REQUIREMENT implements AD_REQUIREMENT
{
	public enum RequiredState
	{
		STARTED,
		COMPLETED
	}

	private final Quest quest;
	private final RequiredState requiredState;

	public AD_QUEST_REQUIREMENT(Quest quest)
	{
		this(quest, RequiredState.COMPLETED);
	}

	public AD_QUEST_REQUIREMENT(
	    Quest quest,
	    RequiredState requiredState)
	{
		this.quest = quest;
		this.requiredState = requiredState;
	}

	@Override
	public boolean isSatisfied(PlayerState playerState)
	{
		switch (requiredState)
		{
			case STARTED:
				return playerState.getInProgressQuestSet().contains(quest)
				    || playerState.getCompletedQuestSet().contains(quest);

			case COMPLETED:
				return playerState.getCompletedQuestSet().contains(quest);

			default:
				return false;
		}
	}
}