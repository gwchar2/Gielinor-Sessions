package com.gielinor_sessions.resources.combat_achievements;

import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.gameval.VarPlayerID;

@Singleton
public final class CB_COMPLETION_READER
{
	private static final int[] VARP_IDS = {
	    VarPlayerID.CA_TASK_COMPLETED_0,
	    VarPlayerID.CA_TASK_COMPLETED_1,
	    VarPlayerID.CA_TASK_COMPLETED_2,
	    VarPlayerID.CA_TASK_COMPLETED_3,
	    VarPlayerID.CA_TASK_COMPLETED_4,
	    VarPlayerID.CA_TASK_COMPLETED_5,
	    VarPlayerID.CA_TASK_COMPLETED_6,
	    VarPlayerID.CA_TASK_COMPLETED_7,
	    VarPlayerID.CA_TASK_COMPLETED_8,
	    VarPlayerID.CA_TASK_COMPLETED_9,
	    VarPlayerID.CA_TASK_COMPLETED_10,
	    VarPlayerID.CA_TASK_COMPLETED_11,
	    VarPlayerID.CA_TASK_COMPLETED_12,
	    VarPlayerID.CA_TASK_COMPLETED_13,
	    VarPlayerID.CA_TASK_COMPLETED_14,
	    VarPlayerID.CA_TASK_COMPLETED_15,
	    VarPlayerID.CA_TASK_COMPLETED_16,
	    VarPlayerID.CA_TASK_COMPLETED_17,
	    VarPlayerID.CA_TASK_COMPLETED_18,
	    VarPlayerID.CA_TASK_COMPLETED_19,
	    VarPlayerID.CA_TASK_COMPLETED_20
	};

	private final Client client;

	@Inject
	public CB_COMPLETION_READER(Client client)
	{
		this.client = client;
	}

	public int bucketForTask(CB_TASK task)
	{
		int id = task.getId();
		if (id < 0 || id >= VARP_IDS.length * Integer.SIZE)
		{
			throw new IllegalStateException("Unsupported combat achievement ID " + id
			    + "; extend CA_TASK_COMPLETED varps before using it");
		}
		return id / Integer.SIZE;
	}

	public int bucketForVarp(int varpId)
	{
		for (int i = 0; i < VARP_IDS.length; i++)
		{
			if (VARP_IDS[i] == varpId)
			{
				return i;
			}
		}
		return -1;
	}

	public boolean isCompleted(CB_TASK task)
	{
		int bucket = bucketForTask(task);
		int bit = task.getId() % Integer.SIZE;
		int value = client.getVarpValue(VARP_IDS[bucket]);
		return (value & (1 << bit)) != 0;
	}
}
