package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;

import com.gielinor_sessions.resources.achievement_diaries.requirements.AD_REQUIREMENT;

public interface AD_TASK
{
	// Technically we have all of these with @Getter but we need a way to make all
	// the diary enums the same type.
	String getDescription();

	AD_GROUP getGroup();

	Boolean getCompletionStatus();

	List<AD_REQUIREMENT> getRequirements();
}