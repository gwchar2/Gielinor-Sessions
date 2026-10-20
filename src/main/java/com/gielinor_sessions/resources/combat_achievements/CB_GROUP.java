
package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.gameval.VarbitID;

@Getter
@RequiredArgsConstructor
public enum CB_GROUP
{
	GROUP_EASY(
	    "Easy Combat Achievement",
	    1,
	    3981,
	    VarbitID.CA_TIER_STATUS_EASY),

	GROUP_MEDIUM(
	    "Medium Combat Achievement",
	    2,
	    3982,
	    VarbitID.CA_TIER_STATUS_MEDIUM),

	GROUP_HARD(
	    "Hard Combat Achievement",
	    3,
	    3983,
	    VarbitID.CA_TIER_STATUS_HARD),

	GROUP_ELITE(
	    "Elite Combat Achievement",
	    4,
	    3984,
	    VarbitID.CA_TIER_STATUS_ELITE),

	GROUP_MASTER(
	    "Master Combat Achievement",
	    5,
	    3985,
	    VarbitID.CA_TIER_STATUS_MASTER),

	GROUP_GRANDMASTER(
	    "Grandmaster Combat Achievement",
	    6,
	    3986,
	    VarbitID.CA_TIER_STATUS_GRANDMASTER);

	private final String name;
	private final int pointsPerTask;
	private final int enumId;
	private final int completionVarbit;
}
