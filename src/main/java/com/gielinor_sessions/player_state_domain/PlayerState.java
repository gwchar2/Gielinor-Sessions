package com.gielinor_sessions.player_state_domain;

import java.util.*;
import lombok.Getter;
import lombok.Setter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.Client;

import com.gielinor_sessions.resources.achievement_diary.GEN_TASK;
import com.gielinor_sessions.resources.combat_achievements.*;

@Getter
@Setter
public class PlayerState
{
	// TODO: IN THE FUTURE, SPLIT CLASS TO 'STATE' PER FEATURE

	// TODO: (1) Implement achievement diaries -> LumbridgeDiaryRequirement extends
	// GenericDiaryRequirement and use the add() and setGroup()
	// TODO: (2) Redesign combat achievements to maybe match achievement diary?

	private Client client;
	private int combatLevel;
	private Map<Skill, Integer> levels = new HashMap<Skill, Integer>();
	private Map<Skill, Integer> experience = new HashMap<Skill, Integer>();

	private int questPoints;
	private Set<Quest> completedQuestSet = new HashSet<Quest>();
	private Set<Quest> notStartedQuestSet = new HashSet<Quest>();
	private Set<Quest> inProgressQuestSet = new HashSet<Quest>();

	Set<CB_ACHIEVEMENT> incompleteCombatAchievements = new HashSet<CB_ACHIEVEMENT>();
	Set<GEN_TASK> incompleteAchievementDiaries = new HashSet<GEN_TASK>();

	private Map<String, Integer> bossKillCounts;

}
