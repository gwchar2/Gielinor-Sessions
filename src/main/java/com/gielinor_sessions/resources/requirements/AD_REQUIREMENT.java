package com.gielinor_sessions.resources.requirements;

import com.gielinor_sessions.player_state_domain.PlayerState;

public interface AD_REQUIREMENT
{
	boolean isSatisfied(PlayerState playerState);
}