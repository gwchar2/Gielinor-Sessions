package com.gielinor_sessions.resources.achievement_diaries.requirements;

import com.gielinor_sessions.player_state_domain.PlayerState;
import lombok.Getter;

@Getter
public final class AD_COMBAT_LEVEL_REQUIREMENT implements AD_REQUIREMENT
{
	private final int level;

	public AD_COMBAT_LEVEL_REQUIREMENT(int level)
	{
		this.level = level;
	}

	@Override
	public boolean isSatisfied(PlayerState playerState)
	{
		return playerState.getCombatLevel() >= level;
	}
}