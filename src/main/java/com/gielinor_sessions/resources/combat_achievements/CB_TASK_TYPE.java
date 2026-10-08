package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;

@Getter
public enum CB_TASK_TYPE
{
	KILL_COUNT("Kill Count"),
	MECHANICAL("Mechanical"),
	PERFECTION("Perfection"),
	RESTRICTION("Restriction"),
	SPEED("Speed"),
	STAMINA("Stamina"),
	;

	private String type;

	CB_TASK_TYPE(String _type)
	{
		this.type = _type;
	}

}