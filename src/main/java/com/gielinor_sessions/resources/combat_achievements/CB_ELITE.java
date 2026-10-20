package com.gielinor_sessions.resources.combat_achievements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CB_ELITE implements CB_TASK
{

	private final String name;
	private final String description;
	private final CB_TASK_TYPE type;
	private final int completionVarbit;

	@Override
	public CB_GROUP getGroup()
	{
		return CB_GROUP.GROUP_ELITE;
	}
}