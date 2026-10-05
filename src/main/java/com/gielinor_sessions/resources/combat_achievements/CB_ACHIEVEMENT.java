package com.gielinor_sessions.resources.combat_achievements;

import com.gielinor_sessions.resources.requirements.IRequirement;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarbitID;

@Getter
public enum CB_ACHIEVEMENT implements IRequirement
{
	CA_TASK_ABBERANT_SPECTRE_KILLCOUNT_1(
	    "Aberrant Spectre",
	    "Kill X amount of Aberrant Spectres",
	    CB_GROUP.GROUP_EASY,
	    CB_TASK_TYPE.KILL_COUNT,
	    VarbitID.CA_TASK_ABBERANT_SPECTRE_KILLCOUNT_1_COMPLETED);

	private final String name;
	private final String description;
	private final CB_GROUP group;
	private final CB_TASK_TYPE type;
	private final int completionVarbitId;

	CB_ACHIEVEMENT(
	    String _name,
	    String _description,
	    CB_GROUP _group,
	    CB_TASK_TYPE _type,
	    int _completionVarbitId)
	{
		this.name = _name;
		this.description = _description;
		this.group = _group;
		this.type = _type;
		this.completionVarbitId = _completionVarbitId;
	}

	@Override
	public boolean isCompleted(Client client)
	{
		// TODO: (4) Might not be != 0!
		return client.getVarbitValue(completionVarbitId) != 0;
	}

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		// TODO: (4) Might not be != 0!
		return client.getVarbitValue(completionVarbitId) != 0;
	}

	@Override
	public String toString(Client client)
	{
		StringBuilder description = new StringBuilder();
		description.append(group.toString() + "\n");
		description.append(type.toString() + "\n");
		description.append(description);

		return description.toString();
	}
}