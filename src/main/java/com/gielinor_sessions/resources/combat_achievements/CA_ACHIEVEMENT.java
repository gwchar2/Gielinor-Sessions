package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarbitID;

@Getter
public enum CA_ACHIEVEMENT
{
	CA_TASK_ABBERANT_SPECTRE_KILLCOUNT_1(
	    "Aberrant Spectre",
	    CA_GROUP.GROUP_EASY,
	    CA_TASK_TYPE.KILL_COUNT,
	    VarbitID.CA_TASK_ABBERANT_SPECTRE_KILLCOUNT_1_COMPLETED);

	private final String name;
	private final CA_GROUP group;
	private final CA_TASK_TYPE type;
	private final int completionVarbitId;

	CA_ACHIEVEMENT(
	    String _name,
	    CA_GROUP _group,
	    CA_TASK_TYPE _type,
	    int _completionVarbitId)
	{
		this.name = _name;
		this.group = _group;
		this.type = _type;
		this.completionVarbitId = _completionVarbitId;
	}

	public boolean isCompleted(Client client)
	{
		return client.getVarbitValue(completionVarbitId) != 0;
	}
}