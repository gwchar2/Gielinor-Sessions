
package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CB_TASK_TYPE
{
	STAMINA(1, "Stamina"),
	PERFECTION(2, "Perfection"),
	KILL_COUNT(3, "Kill Count"),
	MECHANICAL(4, "Mechanical"),
	RESTRICTION(5, "Restriction"),
	SPEED(6, "Speed"),
	;

	private final int id;
	private final String type;

	public static CB_TASK_TYPE fromId(int id)
	{
		for (CB_TASK_TYPE taskType : values())
		{
			if (taskType.id == id)
			{
				return taskType;
			}
		}

		throw new IllegalArgumentException(
		    "Unknown Combat Achievement type ID: " + id);
	}
}
