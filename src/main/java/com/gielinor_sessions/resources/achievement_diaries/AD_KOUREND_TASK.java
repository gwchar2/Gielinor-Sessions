
package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_KOUREND_TASK implements AD_TASK
{
    // EASY
	MINE_MOUNT_KARUULM_IRON(
	    "Mine some Iron at the Mount Karuulm mine.",
	    AD_GROUP.KOUREND_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 15)),
	KILL_SANDCRAB(
	    "Kill a sandcrab.",
	    AD_GROUP.KOUREND_EASY),
	HAND_IN_ARCEUUS_LIBRARY_BOOK(
	    "Hand in a book at the Arceuus Library.",
	    AD_GROUP.KOUREND_EASY),
	STEAL_HOSIDIUS_FOOD_STALL(
	    "Steal from a Hosidius Food Stall.",
	    AD_GROUP.KOUREND_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 25)),
	BROWSE_WARRENS_GENERAL_STORE(
	    "Browse the Warrens General Store.",
	    AD_GROUP.KOUREND_EASY),
	TAKE_BOAT_LANDS_END(
	    "Take a boat to Land's End.",
	    AD_GROUP.KOUREND_EASY),
	PRAY_KOUREND_CASTLE_ALTAR(
	    "Pray at the altar in Kourend Castle.",
	    AD_GROUP.KOUREND_EASY),
	DIG_SALTPETRE(
	    "Dig up some saltpetre.",
	    AD_GROUP.KOUREND_EASY),
	ENTER_HOSIDIUS_POH(
	    "Enter your Player Owned House from Hosidius.",
	    AD_GROUP.KOUREND_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 25)),
	COMPLETE_SHAYZIEN_AGILITY(
	    "Do a lap of either tier of the Shayzien agility course.",
	    AD_GROUP.KOUREND_EASY),
	CREATE_STRENGTH_POTION(
	    "Create a Strength potion in the Lovakengj Pub.",
	    AD_GROUP.KOUREND_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 12)),
	FISH_RIVER_MOLCH_TROUT(
	    "Fish a Trout from the River Molch.",
	    AD_GROUP.KOUREND_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 20)),

    // MEDIUM
	TRAVEL_MOUNT_KARUULM_FAIRY_RING(
	    "Travel to the Fairy Ring south of Mount Karuulm.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS)),
	KILL_LIZARDMAN(
	    "Kill a lizardman.",
	    AD_GROUP.KOUREND_MEDIUM),
	TELEPORT_FIVE_KOUREND_CITIES(
	    "Use Kharedst's memoirs to teleport to all five cities in Great Kourend.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.THE_DEPTHS_OF_DESPAIR, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.THE_QUEEN_OF_THIEVES, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.TALE_OF_THE_RIGHTEOUS, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FORSAKEN_TOWER, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.THE_ASCENT_OF_ARCEUUS, QuestState.FINISHED)),
	MINE_VOLCANIC_SULPHUR(
	    "Mine some Volcanic sulphur.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 42)),
	ENTER_FARMING_GUILD(
	    "Enter the Farming Guild.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 45)),
	SWITCH_NECROMANCY_SPELLBOOK(
	    "Switch to the Necromancy spellbook at Tyss.",
	    AD_GROUP.KOUREND_MEDIUM),
	REPAIR_PISCARILIUS_CRANE(
	    "Repair a Piscarilius crane.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 30),
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 30)),
	DELIVER_INTELLIGENCE_CAPTAIN_GINEA(
	    "Deliver some intelligence to Captain Ginea.",
	    AD_GROUP.KOUREND_MEDIUM),
	CATCH_MOLCH_BLUEGILL(
	    "Catch a Bluegill on Molch Island.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 43),
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 35)),
	USE_ARCEUUS_BOULDER_LEAP(
	    "Use the boulder leap in the Arceuus essence mine.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 49)),
	SUBDUE_WINTERTODT(
	    "Subdue the Wintertodt.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 50)),
	CATCH_KOUREND_CHINCHOMPA(
	    "Catch a Chinchompa in the Kourend Woodland.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 53),
	    new AD_QUEST_REQUIREMENT(Quest.EAGLES_PEAK, QuestState.FINISHED)),
	CHOP_FARMING_GUILD_MAHOGANY(
	    "Chop some Mahogany logs north of the Farming Guild.",
	    AD_GROUP.KOUREND_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 50)),

    // HARD
	ENTER_WOODCUTTING_GUILD(
	    "Enter the Woodcutting Guild.",
	    AD_GROUP.KOUREND_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 60)),
	SMELT_FORSAKEN_TOWER_ADAMANTITE(
	    "Smelt an Adamantite bar in The Forsaken Tower.",
	    AD_GROUP.KOUREND_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 70),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FORSAKEN_TOWER, QuestState.IN_PROGRESS)),
	KILL_LIZARDMAN_SHAMAN(
	    "Kill a Lizardman Shaman in the Lizardman Temple.",
	    AD_GROUP.KOUREND_HARD),
	MINE_LOVAKITE(
	    "Mine some Lovakite.",
	    AD_GROUP.KOUREND_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 65)),
	PLANT_LOGAVANO_SEEDS(
	    "Plant some Logavano seeds at the Tithe Farm.",
	    AD_GROUP.KOUREND_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 74)),
	KILL_SHAYZIEN_CRYPTS_ZOMBIE(
	    "Kill a zombie in the Shayzien Crypts.",
	    AD_GROUP.KOUREND_HARD),
	TELEPORT_XERICS_HEART(
	    "Teleport to Xeric's Heart using Xeric's Talisman.",
	    AD_GROUP.KOUREND_HARD),
	DELIVER_CAPTAIN_KHALED_ARTEFACT(
	    "Deliver an artefact to Captain Khaled.",
	    AD_GROUP.KOUREND_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 49)),
	KILL_KARUULM_WYRM(
	    "Kill a Wyrm in the Karuulm Slayer Dungeon.",
	    AD_GROUP.KOUREND_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 62)),
	CAST_MONSTER_EXAMINE_TROLL(
	    "Cast Monster Examine on a Troll south of Mount Quidamortem.",
	    AD_GROUP.KOUREND_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 66),
	    new AD_QUEST_REQUIREMENT(Quest.DREAM_MENTOR, QuestState.FINISHED)),

    // ELITE
	CRAFT_BLOOD_RUNES(
	    "Craft one or more Blood runes from Dark essence fragments.",
	    AD_GROUP.KOUREND_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 77),
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 38),
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 38)),
	CHOP_REDWOOD_LOGS(
	    "Chop some Redwood logs.",
	    AD_GROUP.KOUREND_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 90)),
	DEFEAT_SKOTIZO(
	    "Defeat Skotizo in the Catacombs of Kourend.",
	    AD_GROUP.KOUREND_ELITE),
	CATCH_COOK_ANGLERFISH(
	    "Catch an Anglerfish and cook it whilst in Great Kourend.",
	    AD_GROUP.KOUREND_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 82),
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 84)),
	KILL_KARUULM_HYDRA(
	    "Kill a Hydra in the Karuulm Slayer Dungeon.",
	    AD_GROUP.KOUREND_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 95)),
	CREATE_APE_ATOLL_TELEPORT_TABLET(
	    "Create an Ape Atoll teleport tablet.",
	    AD_GROUP.KOUREND_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 90),
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 38),
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 38)),
	COMPLETE_CHAMBERS_OF_XERIC_RAID(
	    "Complete a raid in the Chambers of Xeric.",
	    AD_GROUP.KOUREND_ELITE),
	CREATE_FARMING_GUILD_BATTLESTAFF(
	    "Create your own Battlestaff from scratch within the Farming Guild.",
	    AD_GROUP.KOUREND_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 85),
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 40));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_KOUREND_TASK(
	    String _description,
	    AD_GROUP _group,
	    AD_REQUIREMENT... _requirements)
	{
		this.description = _description;
		this.group = _group;
		this.completionStatus = null;
		this.requirements = List.of(_requirements);
	}
}
