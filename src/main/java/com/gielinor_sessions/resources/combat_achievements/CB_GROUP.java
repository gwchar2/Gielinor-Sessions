package com.gielinor_sessions.resources.combat_achievements;

import com.gielinor_sessions.resources.requirements.IRequirement;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.VarbitID;
import net.runelite.api.Client;

@RequiredArgsConstructor
@Getter
public enum CB_GROUP
{
	GROUP_EASY(
	    "Easy Combat Achievement",
	    1,
	    VarbitID.CA_TIER_STATUS_EASY),
	GROUP_MEDIUM(
	    "Medium Combat Achievement",
	    2,
	    VarbitID.CA_TIER_STATUS_MEDIUM),
	GROUP_HARD(
	    "Hard Combat Achievement",
	    3,
	    VarbitID.CA_TIER_STATUS_HARD),
	GROUP_ELITE(
	    "Elite Combat Achievement",
	    4,
	    VarbitID.CA_TIER_STATUS_ELITE),
	GROUP_MASTER(
	    "Master Combat Achievement",
	    5,
	    VarbitID.CA_TIER_STATUS_MASTER),
	GROUP_GRANDMASTER(
	    "Grandmaster Combat Achievement",
	    6,
	    VarbitID.CA_TIER_STATUS_GRANDMASTER);

	private final String name;
	private final int pointsPerTask;
	private final int statusVarbitId;

	public boolean satisfiesRequirement(Client client)
	{
		return client.getVarbitValue(statusVarbitId) == IRequirement.COMPLETED;
	}

}