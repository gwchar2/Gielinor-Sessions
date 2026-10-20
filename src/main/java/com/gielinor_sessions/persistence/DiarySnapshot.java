package com.gielinor_sessions.persistence;

import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class DiarySnapshot
{
	private final Map<AD_TASK, Boolean> statuses;

	public DiarySnapshot(Map<AD_TASK, Boolean> statuses)
	{
		this.statuses = Collections.unmodifiableMap(new HashMap<>(statuses));
	}

	public Map<AD_TASK, Boolean> getStatuses()
	{
		return statuses;
	}
}
