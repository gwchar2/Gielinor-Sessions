package com.gielinor_sessions.resources.requirements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarPlayerID;

@RequiredArgsConstructor
@Getter
public class QuestPointRequirement implements IRequirement
{
	private final int qp;

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		return client.getVarpValue(VarPlayerID.QP) >= qp;
	}

	@Override
	public String toString(Client client)
	{
		return qp + " Quest Points";
	}

}
