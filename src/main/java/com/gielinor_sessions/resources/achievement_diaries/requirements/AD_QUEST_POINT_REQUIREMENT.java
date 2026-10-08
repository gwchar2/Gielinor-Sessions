package com.gielinor_sessions.resources.achievement_diaries.requirements;

import com.gielinor_sessions.player_state_domain.PlayerState;
import lombok.Getter;

@Getter
public final class AD_QUEST_POINT_REQUIREMENT implements AD_REQUIREMENT
{
	private final int points;

	public AD_QUEST_POINT_REQUIREMENT(int points)
	{
		this.points = points;
	}

	@Override
	public boolean isSatisfied(PlayerState playerState)
	{
		return playerState.getQuestPoints() >= points;
	}
}