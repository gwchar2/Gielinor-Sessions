package com.gielinor_sessions.resources.combat_achievements;

interface CB_TASK
{
	String getName();

	String getDescription();

	CB_GROUP getGroup();

	CB_TASK_TYPE getType();

	int getCompletionVarbit();
}