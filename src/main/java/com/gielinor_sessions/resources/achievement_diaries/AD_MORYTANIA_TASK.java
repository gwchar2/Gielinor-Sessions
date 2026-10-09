package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_MORYTANIA_TASK implements AD_TASK
{
    // EASY
	CRAFT_SNELM(
	    "Craft any Snelm from scratch in Morytania.",
	    AD_GROUP.MORYTANIA_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 15)),
	COOK_THIN_SNAIL(
	    "Cook a thin Snail on the Port Phasmatys range.",
	    AD_GROUP.MORYTANIA_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 12)),
	GET_CANIFIS_SLAYER_TASK(
	    "Get a slayer task from the Slayer Master in Canifis.",
	    AD_GROUP.MORYTANIA_EASY,
	    new AD_COMBAT_LEVEL_REQUIREMENT(20)),
	KILL_BANSHEE(
	    "Kill a Banshee in the Slayer Tower.",
	    AD_GROUP.MORYTANIA_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 15)),
	PLACE_MORYTANIA_SCARECROW(
	    "Place a Scarecrow in the Morytania flower patch.",
	    AD_GROUP.MORYTANIA_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 23)),
	KILL_WEREWOLF_WOLFBANE(
	    "Kill a werewolf in its human form using the Wolfbane Dagger.",
	    AD_GROUP.MORYTANIA_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.PRIEST_IN_PERIL, QuestState.FINISHED)),
	RESTORE_PRAYER_NATURE_ALTAR(
	    "Restore your prayer points at the nature altar.",
	    AD_GROUP.MORYTANIA_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.NATURE_SPIRIT, QuestState.FINISHED)),

    // MEDIUM
	CATCH_SWAMP_LIZARD(
	    "Catch a swamp lizard.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 29)),
	COMPLETE_CANIFIS_AGILITY(
	    "Complete a lap of the Canifis agility course.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 40)),
	OBTAIN_HOLLOW_TREE_BARK(
	    "Obtain some Bark from a Hollow tree.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 45)),
	KILL_TERROR_DOG(
	    "Kill a Terror Dog.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 40),
	    new AD_QUEST_REQUIREMENT(Quest.LAIR_OF_TARN_RAZORLOR, QuestState.FINISHED)),
	COMPLETE_TROUBLE_BREWING(
	    "Complete a game of trouble brewing.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 40),
	    new AD_QUEST_REQUIREMENT(Quest.CABIN_FEVER, QuestState.FINISHED)),
	MAKE_PORT_PHASMATYS_CANNONBALLS(
	    "Make a batch of cannonballs at the Port Phasmatys furnace.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 35),
	    new AD_QUEST_REQUIREMENT(Quest.DWARF_CANNON, QuestState.FINISHED)),
	KILL_FEVER_SPIDER(
	    "Kill a Fever Spider on Braindeath Island.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 42),
	    new AD_QUEST_REQUIREMENT(Quest.RUM_DEAL, QuestState.FINISHED)),
	USE_ECTOPHIAL(
	    "Use an ectophial to return to Port Phasmatys.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.GHOSTS_AHOY, QuestState.FINISHED)),
	MIX_GUTHIX_BALANCE(
	    "Mix a Guthix Balance potion while in Morytania.",
	    AD_GROUP.MORYTANIA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 22),
	    new AD_QUEST_REQUIREMENT(Quest.IN_AID_OF_THE_MYREQUE, QuestState.IN_PROGRESS)),

    // HARD
	ENTER_KHARYRLL_PORTAL(
	    "Enter the Kharyrll portal in your POH.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 66),
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 50),
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.FINISHED)),
	CLIMB_SLAYER_TOWER_SPIKE_CHAIN(
	    "Climb the advanced spike chain within Slayer Tower.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 71)),
	HARVEST_HARMONY_WATERMELON(
	    "Harvest some Watermelon from the Allotment patch on Harmony Island.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 47),
	    new AD_QUEST_REQUIREMENT(Quest.THE_GREAT_BRAIN_ROBBERY, QuestState.IN_PROGRESS)),
	CHOP_BURN_MAHOGANY_LOGS(
	    "Chop and burn some mahogany logs on Mos Le'Harmless.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 50),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 50),
	    new AD_QUEST_REQUIREMENT(Quest.CABIN_FEVER, QuestState.FINISHED)),
	COMPLETE_HARD_TEMPLE_TREK(
	    "Complete a temple trek with a hard companion.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.IN_AID_OF_THE_MYREQUE, QuestState.FINISHED)),
	KILL_CAVE_HORROR(
	    "Kill a Cave Horror.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 58),
	    new AD_QUEST_REQUIREMENT(Quest.CABIN_FEVER, QuestState.FINISHED)),
	HARVEST_BITTERCAP_MUSHROOMS(
	    "Harvest some Bittercap Mushrooms from the patch in Canifis.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 53)),
	PRAY_NATURE_ALTAR_PIETY(
	    "Pray at the Altar of Nature with Piety activated.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.PRAYER, 70),
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 70),
	    new AD_QUEST_REQUIREMENT(Quest.NATURE_SPIRIT, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.KINGS_RANSOM, QuestState.FINISHED)),
	USE_SALVE_BRIDGE_SHORTCUT(
	    "Use the shortcut to get to the bridge over the Salve.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 65)),
	MINE_ABANDONED_MINE_MITHRIL(
	    "Mine some Mithril ore in the Abandoned Mine.",
	    AD_GROUP.MORYTANIA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 55),
	    new AD_QUEST_REQUIREMENT(Quest.HAUNTED_MINE, QuestState.FINISHED)),

    // ELITE
	BAREHAND_BURGH_DE_ROTT_SHARK(
	    "Catch a shark in Burgh de Rott with your bare hands.",
	    AD_GROUP.MORYTANIA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 96),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 76),
	    new AD_QUEST_REQUIREMENT(Quest.IN_AID_OF_THE_MYREQUE, QuestState.FINISHED)),
	CREMATE_SHADE_REMAINS(
	    "Cremate any Shade remains on a Magic or Redwood pyre.",
	    AD_GROUP.MORYTANIA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 80),
	    new AD_QUEST_REQUIREMENT(Quest.SHADES_OF_MORTTON, QuestState.FINISHED)),
	FERTILIZE_MORYTANIA_HERB_PATCH(
	    "Fertilize the Morytania herb patch using Lunar Magic.",
	    AD_GROUP.MORYTANIA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 83),
	    new AD_QUEST_REQUIREMENT(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED)),
	CRAFT_BLACK_DRAGONHIDE_BODY(
	    "Craft a Black dragonhide body in Canifis bank.",
	    AD_GROUP.MORYTANIA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 84)),
	KILL_ABYSSAL_DEMON(
	    "Kill an Abyssal demon in the Slayer Tower.",
	    AD_GROUP.MORYTANIA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 85)),
	LOOT_BARROWS_CHEST(
	    "Loot the Barrows chest while wearing any complete barrows set.",
	    AD_GROUP.MORYTANIA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 70),
	    new AD_OR_REQUIREMENT(
	        new AD_SKILL_REQUIREMENT(Skill.ATTACK, 70),
	        new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 70),
	        new AD_SKILL_REQUIREMENT(Skill.RANGED, 70),
	        new AD_SKILL_REQUIREMENT(Skill.MAGIC, 70)));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_MORYTANIA_TASK(
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