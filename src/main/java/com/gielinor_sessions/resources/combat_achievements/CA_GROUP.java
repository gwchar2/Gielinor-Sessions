package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarbitID;

@Getter
public enum CA_GROUP
{
	GROUP_EASY(
	    "Easy Combat Achievements",
	    1,
	    VarbitID.CA_TIER_STATUS_EASY),
	GROUP_MEDIUM(
	    "Medium Combat Achievements",
	    2,
	    VarbitID.CA_TIER_STATUS_MEDIUM),
	GROUP_HARD(
	    "Hard Combat Achievements",
	    3,
	    VarbitID.CA_TIER_STATUS_HARD),
	GROUP_ELITE(
	    "Elite Combat Achievements",
	    4,
	    VarbitID.CA_TIER_STATUS_ELITE),
	GROUP_MASTER(
	    "Master Combat Achievements",
	    5,
	    VarbitID.CA_TIER_STATUS_MASTER),
	GROUP_GRANDMASTER(
	    "Grandmaster Combat Achievements",
	    6,
	    VarbitID.CA_TIER_STATUS_GRANDMASTER);

	private final String name;
	private final int pointsPerTask;
	private final int statusVarbitId;

	CA_GROUP(String _name, int _pointsPerTask, int _statusVarbitId)
	{
		this.name = _name;
		this.pointsPerTask = _pointsPerTask;
		this.statusVarbitId = _statusVarbitId;
	}

	public boolean isCompleted(Client client)
	{
		return client.getVarbitValue(statusVarbitId) == 2;
	}
}