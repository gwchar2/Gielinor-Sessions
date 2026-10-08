package com.gielinor_sessions.resources.requirements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Skill;

@RequiredArgsConstructor
@Getter
public class SkillRequirement implements IRequirement
{
	private final Skill skill;
	private final int level;

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		return client.getRealSkillLevel(skill) >= level;
	}

	@Override
	public String toString(Client client)
	{
		return level + " " + skill.getName();
	}

}
