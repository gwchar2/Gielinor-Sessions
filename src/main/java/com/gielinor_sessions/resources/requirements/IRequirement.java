package com.gielinor_sessions.resources.requirements;

import net.runelite.api.Client;

public interface IRequirement
{
	public final int COMPLETED = 2;

	boolean satisfiesRequirement(Client client);

	String toString(Client client);
}