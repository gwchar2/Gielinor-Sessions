package com.gielinor_sessions.resources.combat_achievements;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
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

}