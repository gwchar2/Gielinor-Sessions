package com.gielinor_sessions.resources.achievement_diaries.requirements;

import com.gielinor_sessions.player_state_domain.PlayerState;
import lombok.Getter;
import net.runelite.api.Skill;

@Getter
public final class AD_SKILL_REQUIREMENT implements AD_REQUIREMENT
{
	private final Skill skill;
	private final int level;

	public AD_SKILL_REQUIREMENT(Skill skill, int level)
	{
		this.skill = skill;
		this.level = level;
	}

	@Override
	public boolean isSatisfied(PlayerState playerState)
	{
		return playerState.getLevels().getOrDefault(skill, 1) >= level;
	}
}