package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_FREMENNIK_TASK implements AD_TASK
{
    // EASY
	CATCH_CERULEAN_TWITCH(
	    "Catch a Cerulean twitch.",
	    AD_GROUP.FREMENNIK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 11)),
	CHANGE_BOOTS_YRSA(
	    "Change your boots at Yrsa's Shoe Store.",
	    AD_GROUP.FREMENNIK_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
	CRAFT_TIARA_RELLEKKA(
	    "Craft a tiara from scratch in Rellekka.",
	    AD_GROUP.FREMENNIK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 23),
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 20),
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 20),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
	BROWSE_STONEMASONS_SHOP(
	    "Browse the Stonemasons shop.",
	    AD_GROUP.FREMENNIK_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS)),
	STEAL_KELDAGRIM_STALL(
	    "Steal from the Keldagrim crafting or baker's stall.",
	    AD_GROUP.FREMENNIK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 5),
	    new AD_QUEST_REQUIREMENT(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS)),
	ENTER_TROLL_STRONGHOLD(
	    "Enter the Troll Stronghold.",
	    AD_GROUP.FREMENNIK_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.DEATH_PLATEAU, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.TROLL_STRONGHOLD, QuestState.IN_PROGRESS)),
	CHOP_BURN_OAK_LOGS(
	    "Chop and burn some oak logs in the Fremennik Province.",
	    AD_GROUP.FREMENNIK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 15),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 15)),

    // MEDIUM
	SLAY_BRINE_RAT(
	    "Slay a Brine rat.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 47),
	    new AD_QUEST_REQUIREMENT(Quest.OLAFS_QUEST, QuestState.IN_PROGRESS)),
	TRAVEL_SNOWY_HUNTER_EAGLE(
	    "Travel to the Snowy Hunter Area via Eagle.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.EAGLES_PEAK, QuestState.FINISHED)),
	MINE_COAL_RELLEKKA(
	    "Mine some coal in Rellekka.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 30),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
	STEAL_RELLEKKA_FISH_STALL(
	    "Steal from the Rellekka Fish stalls.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 42),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
	TRAVEL_MISCELLANIA_FAIRY_RING(
	    "Travel to Miscellania by Fairy ring.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS)),
	CATCH_SNOWY_KNIGHT(
	    "Catch a Snowy knight.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 35)),
	PICK_UP_PET_ROCK(
	    "Pick up your Pet Rock from your POH Menagerie.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 37),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_TRIALS, QuestState.FINISHED)),
	VISIT_LIGHTHOUSE_WATERBIRTH(
	    "Visit the Lighthouse from Waterbirth island.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.HORROR_FROM_THE_DEEP, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_TRIALS, QuestState.IN_PROGRESS)),
	MINE_ARZINIAN_GOLD(
	    "Mine some gold at the Arzinian mine.",
	    AD_GROUP.FREMENNIK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 40),
	    new AD_QUEST_REQUIREMENT(Quest.BETWEEN_A_ROCK, QuestState.IN_PROGRESS)),

    // HARD
	TELEPORT_TROLLHEIM(
	    "Teleport to Trollheim.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 61),
	    new AD_QUEST_REQUIREMENT(Quest.EADGARS_RUSE, QuestState.FINISHED)),
	CATCH_SABRE_TOOTHED_KYATT(
	    "Catch a Sabre-toothed Kyatt.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 55)),
	MIX_SUPER_DEFENCE(
	    "Mix a super defence potion in the Fremennik province.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 66)),
	STEAL_KELDAGRIM_GEM_STALL(
	    "Steal from the Keldagrim Gem Stall.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 75),
	    new AD_QUEST_REQUIREMENT(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS)),
	CRAFT_FREMENNIK_SHIELD(
	    "Craft a Fremennik shield on Neitiznot.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 56),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_ISLES, QuestState.FINISHED)),
	MINE_ADAMANTITE_JATIZSO(
	    "Mine 5 Adamantite ores on Jatizso.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 70),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_ISLES, QuestState.FINISHED)),
	OBTAIN_KINGDOM_SUPPORT(
	    "Obtain 100% support from your kingdom subjects.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.THRONE_OF_MISCELLANIA, QuestState.FINISHED)),
	TELEPORT_WATERBIRTH(
	    "Teleport to Waterbirth Island.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 72),
	    new AD_QUEST_REQUIREMENT(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
	BLAST_FURNACE_PERMISSION(
	    "Obtain the Blast Furnace Foreman's permission to use the Blast Furnace for free.",
	    AD_GROUP.FREMENNIK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 60),
	    new AD_QUEST_REQUIREMENT(Quest.THE_GIANT_DWARF, QuestState.IN_PROGRESS)),

    // ELITE
	CRAFT_56_ASTRAL_RUNES(
	    "Craft 56 astral runes simultaneously from Essence without the use of Extracts.",
	    AD_GROUP.FREMENNIK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 82),
	    new AD_QUEST_REQUIREMENT(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
	CRAFT_DRAGONSTONE_AMULET(
	    "Create a dragonstone amulet in the Neitiznot furnace.",
	    AD_GROUP.FREMENNIK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 80),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FREMENNIK_ISLES, QuestState.IN_PROGRESS)),
	COMPLETE_RELLEKKA_AGILITY(
	    "Complete a lap of the Rellekka agility course.",
	    AD_GROUP.FREMENNIK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 80)),
	KILL_GOD_WARS_GENERALS(
	    "Kill the generals of Armadyl, Bandos, Saradomin and Zamorak in the God Wars Dungeon.",
	    AD_GROUP.FREMENNIK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 70),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 70),
	    new AD_SKILL_REQUIREMENT(Skill.HITPOINTS, 70),
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 70),
	    new AD_QUEST_REQUIREMENT(Quest.TROLL_STRONGHOLD, QuestState.FINISHED)),
	SLAY_SPIRITUAL_MAGE(
	    "Slay a Spiritual mage within the Godwars Dungeon.",
	    AD_GROUP.FREMENNIK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 83),
	    new AD_QUEST_REQUIREMENT(Quest.TROLL_STRONGHOLD, QuestState.FINISHED));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_FREMENNIK_TASK(
	    String _description,
	    AD_GROUP _group,
	    AD_REQUIREMENT... _requirements)
	{
		this.description = _description;
		this.group = _group;
		this.completionStatus = null; // Null on buildup, true/false after widget is open
		this.requirements = List.of(_requirements);
	}
}