package com.gielinor_sessions.resources.requirements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;

@RequiredArgsConstructor
@Getter
public class CombatLevelRequirement implements IRequirement
{
	private final int level;

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		return client.getLocalPlayer().getCombatLevel() >= level;
	}

	@Override
	public boolean isCompleted(Client client)
	{
		return client.getLocalPlayer().getCombatLevel() >= level;
	}

	@Override
	public String toString(Client client)
	{
		return "Combat level required: " + level;
	}

}
