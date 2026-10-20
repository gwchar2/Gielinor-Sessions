package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.VarbitID;

/**
 * Easy combat achievements.
 * Names/descriptions: Wiki-derived 41-entry catalogue (see README).
 * Unresolved completion varbits are explicitly -1, NOT guessed.
 */
@Getter
@RequiredArgsConstructor
public enum CB_EASY implements CB_TASK
{
	CA_TASK_ABBERANT_SPECTRE_KILLCOUNT_1(
	    "Noxious Foe",
	    "Kill an Aberrant Spectre.",
	    CB_TASK_TYPE.KILL_COUNT,
	    VarbitID.CA_TASK_ABBERANT_SPECTRE_KILLCOUNT_1_COMPLETED);

	private final String name;
	private final String description;
	private final CB_TASK_TYPE type;
	private final int completionVarbit;

	@Override
	public CB_GROUP getGroup()
	{
		return CB_GROUP.GROUP_EASY;
	}

	public boolean hasKnownCompletionVarbit()
	{
		return completionVarbit >= 0;
	}
}
