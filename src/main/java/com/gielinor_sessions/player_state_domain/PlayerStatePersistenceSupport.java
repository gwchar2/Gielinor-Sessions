package com.gielinor_sessions.player_state_domain;

import com.gielinor_sessions.persistence.DiarySnapshot;
import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import java.util.Map;

public final class PlayerStatePersistenceSupport
{
	private PlayerStatePersistenceSupport()
	{
	}

	public static void mergeLoadedDiaries(PlayerState state, DiarySnapshot loaded,
	    Map<AD_TASK, Boolean> observedSinceLogin)
	{
		state.getAchievementDiaryStatus().putAll(loaded.getStatuses());
		state.getAchievementDiaryStatus().putAll(observedSinceLogin);
		state.rebuildIncompleteAchievementDiaries();
	}
}
