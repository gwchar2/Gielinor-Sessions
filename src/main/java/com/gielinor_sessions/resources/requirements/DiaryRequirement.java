package com.gielinor_sessions.resources.requirements;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Client;

import com.google.common.collect.ImmutableList;

@Getter
public class DiaryRequirement implements IRequirement
{
	private final String task;
	private final int varbitID;
	public final List<IRequirement> requirements;

	DiaryRequirement(String _task, int _varbitID, IRequirement[] _requirements)
	{
		this.task = _task;
		this.varbitID = _varbitID;

		if (_requirements != null && _requirements.length != 0)
		{
			this.requirements = ImmutableList.copyOf(_requirements);
		}
		else
		{
			this.requirements = List.of();
		}
	}

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		for (IRequirement requirement : requirements)
		{
			if (requirement.satisfiesRequirement(client))
			{
				continue;
			}
			else
			{
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isCompleted(Client client)
	{
		return client.getVarbitValue(varbitID) == IRequirement.COMPLETED;
	}

	@Override
	public String toString(Client client)
	{
		return "NOTIMPLEMENTED!";
	}
}
