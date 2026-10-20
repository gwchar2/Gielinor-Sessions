
package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public final class CB_TASK
{
	private final int id;
	private final String name;
	private final String description;
	private final CB_GROUP group;
	private final CB_TASK_TYPE type;
	private final int bossId;
	private final String bossName;
}