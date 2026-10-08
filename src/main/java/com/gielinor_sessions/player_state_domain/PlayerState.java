package com.gielinor_sessions.player_state_domain;

import java.util.*;
import lombok.Getter;
import lombok.Setter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.Client;

import com.gielinor_sessions.resources.combat_achievements.*;

@RequiredArgsConstructor
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

	Set<CB_TASK> incompleteCombatAchievements = new HashSet<CB_TASK>();
	// Set<GEN_TASK> incompleteAchievementDiaries = new HashSet<GEN_TASK>();

	private Map<String, Integer> bossKillCounts;

}
