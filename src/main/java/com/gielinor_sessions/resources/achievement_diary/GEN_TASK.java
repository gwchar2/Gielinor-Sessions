package com.gielinor_sessions.resources.achievement_diary;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.Client;

import com.gielinor_sessions.resources.requirements.IRequirement;

@Getter
public abstract class GEN_TASK
{
	@Getter
	private final Set<AD_TASK> tasks = new HashSet<>();
	private AD_GROUP group;

	protected void add(String _task, int _varbitID, IRequirement... _requirements)
	{
		AD_TASK task = new AD_TASK(_task, _varbitID, _requirements);
		this.tasks.add(task);
	}

	protected void setGroup(AD_GROUP _group)
	{
		this.group = _group;
	}

	public boolean isCompleted(Client client)
	{
		return group.isCompleted(client);
	}

}