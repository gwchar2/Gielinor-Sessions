package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarbitID;

@Getter
@RequiredArgsConstructor
public enum CB_TASK implements CB_REQUIREMENT
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

	@Override
	public boolean isSatisfied(Client client)
	{
		return client.getVarbitValue(completionVarbitId) != 0;
	}
}