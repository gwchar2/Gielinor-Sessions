package com.gielinor_sessions.resources.combat_achievements;

import com.gielinor_sessions.resources.requirements.IRequirement;

import net.runelite.api.Client;

public enum CB_TASK_TYPE implements IRequirement
{
	KILL_COUNT("Kill Count"),
	MECHANICAL("Mechanical"),
	PERFECTION("Perfection"),
	RESTRICTION("Restriction"),
	SPEED("Speed"),
	STAMINA("Stamina"),
	;

	private String type;

	CB_TASK_TYPE(String _type)
	{
		this.type = _type;
	}

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		// Stub
		return false;
	}

	@Override
	public boolean isCompleted(Client client)
	{
		// Stub
		return false;
	}

	@Override
	public String toString(Client client)
	{
		return "Type" + type;
	}
}