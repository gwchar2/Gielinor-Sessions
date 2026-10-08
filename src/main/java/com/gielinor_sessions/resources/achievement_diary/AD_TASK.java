package com.gielinor_sessions.resources.achievement_diary;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Client;

import com.gielinor_sessions.resources.requirements.IRequirement;
import com.google.common.collect.ImmutableList;

@Getter
public class AD_TASK
{
	private final String task;
	private final int varbitID;
	public final List<IRequirement> requirements;

	AD_TASK(String _task, int _varbitID, IRequirement[] _requirements)
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

	public boolean isCompleted(Client client)
	{
		return client.getVarbitValue(varbitID) == IRequirement.COMPLETED;
	}

}
