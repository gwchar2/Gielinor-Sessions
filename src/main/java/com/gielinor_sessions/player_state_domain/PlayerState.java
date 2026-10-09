
package com.gielinor_sessions.player_state_domain;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.Skill;

import com.gielinor_sessions.resources.achievement_diaries.AD_TASK;
import com.gielinor_sessions.resources.combat_achievements.CB_TASK;

@Getter
@Setter
public class PlayerState
{
	// TODO: In the future, split state by feature.

	private Client client;

	private int combatLevel;

	private Map<Skill, Integer> levels = new HashMap<>();
	private Map<Skill, Integer> experience = new HashMap<>();

	private int questPoints;

	private Set<Quest> completedQuestSet = new HashSet<>();
	private Set<Quest> notStartedQuestSet = new HashSet<>();
	private Set<Quest> inProgressQuestSet = new HashSet<>();

	private Set<CB_TASK> incompleteCombatAchievements = new HashSet<>();
	private Set<AD_TASK> incompleteAchievementDiaries = new HashSet<>();

	/*
	 * Achievement diary completion status:
	 *
	 * Absent/null = Unknown
	 * false = Confirmed incomplete
	 * true = Confirmed completed
	 *
	 * Only tasks observed through the journal are updated.
	 */
	private Map<AD_TASK, Boolean> achievementDiaryStatus = new HashMap<>();

	private Map<String, Integer> bossKillCounts;
}
