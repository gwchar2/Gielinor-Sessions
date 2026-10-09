package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_KANDARIN_TASK implements AD_TASK
{
    // EASY
	CATCH_MACKEREL(
	    "Catch a Mackerel at Catherby.",
	    AD_GROUP.KANDARIN_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 16)),
	PLANT_JUTE_SEEDS(
	    "Plant some Jute seeds in the patch north of McGrubor's Wood.",
	    AD_GROUP.KANDARIN_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 13)),
	DEFEAT_ELEMENTALS(
	    "Defeat one of each elemental in the workshop.",
	    AD_GROUP.KANDARIN_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.ELEMENTAL_WORKSHOP_I, QuestState.IN_PROGRESS)),
	CROSS_COAL_TRUCK_LOG(
	    "Cross the Coal truck log shortcut.",
	    AD_GROUP.KANDARIN_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 20)),

    // MEDIUM
	COMPLETE_BARBARIAN_AGILITY(
	    "Complete a lap of the Barbarian agility course.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 35),
	    new AD_QUEST_REQUIREMENT(Quest.ALFRED_GRIMHANDS_BARCRAWL, QuestState.FINISHED)),
	CREATE_SUPER_ANTIPOISON(
	    "Create a Super Antipoison potion from scratch in the Seers/Catherby Area.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 48)),
	ENTER_RANGING_GUILD(
	    "Enter the Ranging guild.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 40)),
	GRAPPLE_WATER_OBELISK(
	    "Use the grapple shortcut to get from the water obelisk to Catherby shore.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 36),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 22),
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 39)),
	CATCH_COOK_BASS(
	    "Catch and cook a Bass in Catherby.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 46),
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 43)),
	TELEPORT_CAMELOT(
	    "Teleport to Camelot.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 45)),
	STRING_MAPLE_SHORTBOW(
	    "String a Maple shortbow in Seers' Village bank.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 50)),
	PICK_LIMPWURT_ROOT(
	    "Pick some Limpwurt root from the farming patch in Catherby.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 26)),
	CREATE_MIND_HELMET(
	    "Create a Mind helmet.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.ELEMENTAL_WORKSHOP_II, QuestState.FINISHED)),
	KILL_FIRE_GIANT(
	    "Kill a Fire Giant inside Baxtorian Waterfall.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.WATERFALL_QUEST, QuestState.IN_PROGRESS)),
	STEAL_HEMENSTER_CHEST(
	    "Steal from the chest in Hemenster.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 47)),
	TRAVEL_MCGRUBORS_WOOD_FAIRY_RING(
	    "Travel to McGrubor's Wood by Fairy Ring.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS)),
	MINE_COAL_TRUCKS(
	    "Mine some coal near the coal trucks.",
	    AD_GROUP.KANDARIN_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 30)),

    // HARD
	CATCH_LEAPING_STURGEON(
	    "Catch a Leaping Sturgeon.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 70),
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 45),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 45)),
	COMPLETE_SEERS_AGILITY(
	    "Complete a lap of the Seers' Village agility course.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 60)),
	CREATE_YEW_LONGBOW(
	    "Create a Yew Longbow from scratch around Seers' Village.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 60),
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 70),
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 10)),
	ENTER_COURTHOUSE_PIETY(
	    "Enter the Seers' Village courthouse with piety turned on.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.PRAYER, 70),
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 70),
	    new AD_QUEST_REQUIREMENT(Quest.KINGS_RANSOM, QuestState.FINISHED)),
	CHARGE_WATER_ORB(
	    "Charge a Water Orb.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 56)),
	BURN_MAPLE_LOGS_BOW(
	    "Burn some Maple logs with a bow in Seers' Village.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 65)),
	KILL_SHADOW_HOUND(
	    "Kill a Shadow Hound in the Shadow dungeon.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 53),
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.IN_PROGRESS)),
	EQUIP_GRANITE_BODY(
	    "Purchase and equip a granite body from Barbarian Assault.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 50),
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 50)),
	DECORATE_HOUSE_FANCY_STONE(
	    "Have the Seers' estate agent decorate your house with Fancy Stone.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 50)),
	SMITH_ADAMANT_SPEAR(
	    "Smith an Adamant spear at Otto's Grotto.",
	    AD_GROUP.KANDARIN_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 75),
	    new AD_QUEST_REQUIREMENT(Quest.TAI_BWO_WANNAI_TRIO, QuestState.FINISHED)),

    // ELITE
	PICK_DWARF_WEED(
	    "Pick some Dwarf weed from the herb patch at Catherby.",
	    AD_GROUP.KANDARIN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 79)),
	FISH_COOK_SHARKS(
	    "Fish and Cook 5 Sharks in Catherby using the Cooking gauntlets.",
	    AD_GROUP.KANDARIN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 76),
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 80),
	    new AD_QUEST_REQUIREMENT(Quest.FAMILY_CREST, QuestState.FINISHED)),
	MIX_STAMINA_MIX(
	    "Mix a Stamina Mix on top of the Seers' Village bank.",
	    AD_GROUP.KANDARIN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 86),
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 60)),
	SMITH_RUNE_HASTA(
	    "Smith a Rune Hasta at Otto's Grotto.",
	    AD_GROUP.KANDARIN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 90)),
	CONSTRUCT_PYRE_SHIP(
	    "Construct a Pyre ship from Magic Logs.(Requires Chewed Bones.)",
	    AD_GROUP.KANDARIN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 85),
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 85)),
	TELEPORT_CATHERBY(
	    "Teleport to Catherby.",
	    AD_GROUP.KANDARIN_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 87),
	    new AD_QUEST_REQUIREMENT(Quest.LUNAR_DIPLOMACY, QuestState.FINISHED));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_KANDARIN_TASK(
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