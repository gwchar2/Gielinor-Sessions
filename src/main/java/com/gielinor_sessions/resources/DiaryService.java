package com.gielinor_sessions.resources;

import com.gielinor_sessions.player_state_domain.PlayerState;
import com.gielinor_sessions.resources.achievement_diary.AD_TASK;
import com.gielinor_sessions.resources.requirements.AD_REQUIREMENT;

public final class DiaryService
{
	public boolean isEligible(
	    AD_TASK task,
	    PlayerState playerState)
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
}