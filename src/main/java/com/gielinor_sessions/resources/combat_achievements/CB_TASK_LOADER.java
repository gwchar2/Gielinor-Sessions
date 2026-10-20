package com.gielinor_sessions.resources.combat_achievements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;
import net.runelite.api.Client;
import net.runelite.api.EnumComposition;
import net.runelite.api.StructComposition;

/** Call on the RuneLite client thread after the player is logged in. */
@Singleton
public final class CB_TASK_LOADER
{
	private static final int TASK_ID_PARAM = 1306;
	private static final int NAME_PARAM = 1308;
	private static final int DESCRIPTION_PARAM = 1309;
	private static final int TYPE_PARAM = 1311;
	private static final int BOSS_PARAM = 1312;
	private static final int BOSS_ENUM_ID = 3971;

	private final Client client;

	@Inject
	public CB_TASK_LOADER(Client client)
	{
		this.client = client;
	}

	public List<CB_TASK> load()
	{
		List<CB_TASK> tasks = new ArrayList<>();
		Set<Integer> seenIds = new HashSet<>();
		EnumComposition bossEnum = client.getEnum(BOSS_ENUM_ID);

		for (CB_GROUP group : CB_GROUP.values())
		{
			EnumComposition tier = client.getEnum(group.getEnumId());
			if (tier == null)
			{
				throw new IllegalStateException("Missing CA tier enum " + group.getEnumId());
			}
			for (int structId : tier.getIntVals())
			{
				StructComposition struct = client.getStructComposition(structId);
				if (struct == null)
				{
					throw new IllegalStateException("Missing CA struct " + structId);
				}
				int id = struct.getIntValue(TASK_ID_PARAM);
				if (!seenIds.add(id))
				{
					throw new IllegalStateException("Duplicate CA task ID " + id);
				}
				int bossId = struct.getIntValue(BOSS_PARAM);
				tasks.add(new CB_TASK(
				    id,
				    struct.getStringValue(NAME_PARAM),
				    struct.getStringValue(DESCRIPTION_PARAM),
				    group,
				    CB_TASK_TYPE.fromId(struct.getIntValue(TYPE_PARAM)),
				    bossId,
				    bossEnum == null ? "Unknown" : bossEnum.getStringValue(bossId)));
			}
		}
		if (tasks.isEmpty())
		{
			throw new IllegalStateException("Combat achievement catalogue is empty");
		}
		return Collections.unmodifiableList(tasks);
	}
}
