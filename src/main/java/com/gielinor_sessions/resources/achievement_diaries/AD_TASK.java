package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;

import com.gielinor_sessions.resources.achievement_diaries.requirements.AD_REQUIREMENT;

public interface AD_TASK
{
	String getName();

	AD_GROUP getGroup();

	List<AD_REQUIREMENT> getRequirements();
}