package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_WESTERN_TASK implements AD_TASK
{
    // EASY
	CATCH_COPPER_LONGTAIL(
	    "Catch a Copper Longtail.",
	    AD_GROUP.WESTERN_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 9)),
	COMPLETE_NOVICE_PEST_CONTROL(
	    "Complete a novice game of Pest Control.",
	    AD_GROUP.WESTERN_EASY,
	    new AD_COMBAT_LEVEL_REQUIREMENT(40)),
	MINE_PISCATORIS_IRON(
	    "Mine some Iron Ore near Piscatoris.",
	    AD_GROUP.WESTERN_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 15)),
	CLAIM_CHOMPY_BIRD_HAT(
	    "Claim any Chompy bird hat from Rantz.",
	    AD_GROUP.WESTERN_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
	TELEPORT_ESSENCE_MINE_BRIMSTAIL(
	    "Have Brimstail teleport you to the Essence Mine.",
	    AD_GROUP.WESTERN_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.RUNE_MYSTERIES, QuestState.FINISHED)),
	FLETCH_OAK_SHORTBOW(
	    "Fletch an Oak Shortbow in the Gnome Stronghold.",
	    AD_GROUP.WESTERN_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 20)),

    // MEDIUM
	GRAND_TREE_AGILITY_SHORTCUT(
	    "Take the agility shortcut from the Grand Tree to Otto's Grotto.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 37),
	    new AD_QUEST_REQUIREMENT(Quest.TREE_GNOME_VILLAGE, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.THE_GRAND_TREE, QuestState.FINISHED)),
	TRAVEL_GNOME_STRONGHOLD_SPIRIT_TREE(
	    "Travel to the Gnome Stronghold by Spirit Tree.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.TREE_GNOME_VILLAGE, QuestState.FINISHED)),
	TRAP_SPINED_LARUPIA(
	    "Trap a Spined Larupia.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 31)),
	FISH_APE_ATOLL_BASS(
	    "Fish some Bass on Ape Atoll.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 46),
	    new AD_QUEST_REQUIREMENT(Quest.MONKEY_MADNESS_I, QuestState.IN_PROGRESS)),
	CHOP_BURN_APE_ATOLL_TEAK(
	    "Chop and burn some teak logs on Ape Atoll.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 35),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 35),
	    new AD_QUEST_REQUIREMENT(Quest.MONKEY_MADNESS_I, QuestState.IN_PROGRESS)),
	COMPLETE_INTERMEDIATE_PEST_CONTROL(
	    "Complete an intermediate game of Pest Control.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_COMBAT_LEVEL_REQUIREMENT(70)),
	TRAVEL_FELDIP_HILLS_GNOME_GLIDER(
	    "Travel to the Feldip Hills by Gnome Glider.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.ONE_SMALL_FAVOUR, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.THE_GRAND_TREE, QuestState.FINISHED)),
	CLAIM_125_CHOMPY_HAT(
	    "Claim a Chompy bird hat from Rantz after registering at least 125 kills.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
	TRAVEL_FELDIP_HILLS_EAGLE(
	    "Travel from Eagles' Peak to the Feldip Hills by Eagle.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.EAGLES_PEAK, QuestState.FINISHED)),
	MAKE_CHOCOLATE_BOMB(
	    "Make a Chocolate Bomb at the Grand Tree.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 42)),
	COMPLETE_GNOME_RESTAURANT_DELIVERY(
	    "Complete a delivery for the Gnome Restaurant.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 29)),
	CREATE_CRYSTAL_SAW(
	    "Turn your small crystal seed into a Crystal saw.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.THE_EYES_OF_GLOUPHRIE, QuestState.FINISHED)),
	MINE_GRAND_TREE_GOLD(
	    "Mine some Gold ore underneath the Grand Tree.",
	    AD_GROUP.WESTERN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 40),
	    new AD_QUEST_REQUIREMENT(Quest.THE_GRAND_TREE, QuestState.FINISHED)),

    // HARD
	KILL_ELF_CRYSTAL_BOW(
	    "Kill an Elf with a Crystal bow.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 70),
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 56),
	    new AD_QUEST_REQUIREMENT(Quest.ROVING_ELVES, QuestState.FINISHED)),
	CATCH_COOK_MONKFISH(
	    "Catch and cook a Monkfish in Piscatoris.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 62),
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 62),
	    new AD_QUEST_REQUIREMENT(Quest.SWAN_SONG, QuestState.FINISHED)),
	COMPLETE_VETERAN_PEST_CONTROL(
	    "Complete a Veteran game of Pest Control.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_COMBAT_LEVEL_REQUIREMENT(100)),
	CATCH_DASHING_KEBBIT(
	    "Catch a Dashing Kebbit.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 69)),
	COMPLETE_APE_ATOLL_AGILITY(
	    "Complete a lap of the Ape Atoll agility course.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 48),
	    new AD_QUEST_REQUIREMENT(Quest.MONKEY_MADNESS_I, QuestState.FINISHED)),
	CHOP_BURN_APE_ATOLL_MAHOGANY(
	    "Chop and burn some Mahogany logs on Ape Atoll.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 50),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 50),
	    new AD_QUEST_REQUIREMENT(Quest.MONKEY_MADNESS_I, QuestState.FINISHED)),
	MINE_TIRANNWN_ADAMANTITE(
	    "Mine some Adamantite ore in Tirannwn.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 70),
	    new AD_QUEST_REQUIREMENT(Quest.REGICIDE, QuestState.FINISHED)),
	CHECK_LLETYA_PALM_TREE(
	    "Check the health of your Palm tree in Lletya.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 68),
	    new AD_QUEST_REQUIREMENT(Quest.MOURNINGS_END_PART_I, QuestState.IN_PROGRESS)),
	CLAIM_300_CHOMPY_HAT(
	    "Claim a Chompy bird hat from Rantz after registering at least 300 kills.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
	BUILD_ISAFDAR_PAINTING(
	    "Build an Isafdar painting in your POH Quest hall.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 65),
	    new AD_QUEST_REQUIREMENT(Quest.ROVING_ELVES, QuestState.FINISHED)),
	KILL_ZULRAH(
	    "Kill Zulrah.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.REGICIDE, QuestState.IN_PROGRESS)),
	TELEPORT_APE_ATOLL(
	    "Teleport to Ape Atoll.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 64),
	    new AD_QUEST_REQUIREMENT(Quest.RECIPE_FOR_DISASTER, QuestState.IN_PROGRESS)),
	PICKPOCKET_GNOME(
	    "Pickpocket a Gnome.",
	    AD_GROUP.WESTERN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 75)),

    // ELITE
	FLETCH_TIRANNWN_MAGIC_LONGBOW(
	    "Fletch a Magic Longbow in Tirannwn.",
	    AD_GROUP.WESTERN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 85),
	    new AD_QUEST_REQUIREMENT(Quest.MOURNINGS_END_PART_I, QuestState.FINISHED)),
	KILL_THERMONUCLEAR_SMOKE_DEVIL(
	    "Kill the Thermonuclear Smoke devil (Does not require task).",
	    AD_GROUP.WESTERN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 93)),
	PROTECT_MAGIC_TREE(
	    "Have Prissy Scilla protect your Magic tree.",
	    AD_GROUP.WESTERN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 75)),
	USE_ELVEN_CLIFFSIDE_SHORTCUT(
	    "Use the Elven overpass advanced cliffside shortcut.",
	    AD_GROUP.WESTERN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 85),
	    new AD_QUEST_REQUIREMENT(Quest.UNDERGROUND_PASS, QuestState.FINISHED)),
	CLAIM_1000_CHOMPY_HAT(
	    "Claim a Chompy bird hat from Rantz after registering at least 1000 kills.",
	    AD_GROUP.WESTERN_ELITE,
	    new AD_QUEST_REQUIREMENT(Quest.BIG_CHOMPY_BIRD_HUNTING, QuestState.FINISHED)),
	PICKPOCKET_ELF(
	    "Pickpocket an Elf.",
	    AD_GROUP.WESTERN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 85),
	    new AD_QUEST_REQUIREMENT(Quest.MOURNINGS_END_PART_I, QuestState.IN_PROGRESS));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_WESTERN_TASK(
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