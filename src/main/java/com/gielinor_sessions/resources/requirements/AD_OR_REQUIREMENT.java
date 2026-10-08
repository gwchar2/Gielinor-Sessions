package com.gielinor_sessions.resources.requirements;

import com.gielinor_sessions.player_state_domain.PlayerState;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public final class AD_OR_REQUIREMENT implements AD_REQUIREMENT
{
	private final List<AD_REQUIREMENT> requirements;

	public AD_OR_REQUIREMENT(AD_REQUIREMENT... requirements)
	{
		List<AD_REQUIREMENT> copy = new ArrayList<>();
		Collections.addAll(copy, requirements);
		this.requirements = Collections.unmodifiableList(copy);
	}

	@Override
	public boolean isSatisfied(PlayerState playerState)
	{
		for (AD_REQUIREMENT requirement : requirements)
		{
			if (requirement.isSatisfied(playerState))
			{
				return true;
			}
		}

		return false;
	}
}