
package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_KARAMJA_TASK implements AD_TASK
{
    // EASY
	PICK_BANANAS(
	    "Pick 5 bananas from the plantation located east of the volcano.",
	    AD_GROUP.KARAMJA_EASY),
	USE_MOSS_GIANT_ROPE_SWING(
	    "Use the rope swing to travel to the small island north-west of Karamja, where the moss giants are.",
	    AD_GROUP.KARAMJA_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 10)),
	MINE_KARAMJA_GOLD(
	    "Mine some gold from the rocks on the north-west peninsula of Karamja.",
	    AD_GROUP.KARAMJA_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 40)),
	TRAVEL_PORT_SARIM(
	    "Travel to Port Sarim via the dock, east of Musa Point.",
	    AD_GROUP.KARAMJA_EASY),
	TRAVEL_ARDOUGNE(
	    "Travel to Ardougne via the port near Brimhaven.",
	    AD_GROUP.KARAMJA_EASY),
	EXPLORE_CAIRN_ISLAND(
	    "Explore Cairn Island to the west of Karamja.",
	    AD_GROUP.KARAMJA_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 15)),
	USE_BANANA_PLANTATION_FISHING_SPOTS(
	    "Use the fishing spots north of the banana plantation.",
	    AD_GROUP.KARAMJA_EASY),
	COLLECT_SEAWEED(
	    "Collect 5 seaweed from anywhere on Karamja.",
	    AD_GROUP.KARAMJA_EASY),
	ATTEMPT_TZHAAR_FIGHT_PITS_OR_CAVE(
	    "Attempt the TzHaar Fight Pits or Fight Cave.",
	    AD_GROUP.KARAMJA_EASY),
	KILL_JOGRE(
	    "Kill a Jogre in the Pothole Dungeon.",
	    AD_GROUP.KARAMJA_EASY),

    // MEDIUM
	CLAIM_AGILITY_ARENA_TICKET(
	    "Claim a ticket from the Agility Arena in Brimhaven.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 30)),
	DISCOVER_VOLCANO_HIDDEN_WALL(
	    "Discover hidden wall in the dungeon below the volcano.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.DRAGON_SLAYER_I, QuestState.IN_PROGRESS)),
	VISIT_CRANDOR(
	    "Visit the Isle of Crandor via the dungeon below the volcano.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.DRAGON_SLAYER_I, QuestState.IN_PROGRESS)),
	USE_SHILO_CART_SERVICE(
	    "Use Vigroy and Hajedy's cart service.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.SHILO_VILLAGE, QuestState.FINISHED)),
	EARN_TAI_BWO_WANNAI_FAVOUR(
	    "Earn 100% favour in the village of Tai Bwo Wannai.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 10),
	    new AD_QUEST_REQUIREMENT(Quest.JUNGLE_POTION, QuestState.FINISHED)),
	COOK_SPIDER_ON_STICK(
	    "Cook a spider on a stick.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 16)),
	CHARTER_LADY_OF_THE_WAVES(
	    "Charter the Lady of the Waves from Cairn Isle to Port Khazard.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.SHILO_VILLAGE, QuestState.FINISHED)),
	CHOP_TEAK_LOG(
	    "Cut a log from a teak tree.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 35),
	    new AD_QUEST_REQUIREMENT(Quest.JUNGLE_POTION, QuestState.FINISHED)),
	CHOP_MAHOGANY_LOG(
	    "Cut a log from a mahogany tree.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 50),
	    new AD_QUEST_REQUIREMENT(Quest.JUNGLE_POTION, QuestState.FINISHED)),
	CATCH_KARAMBWAN(
	    "Catch a karambwan.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 65),
	    new AD_QUEST_REQUIREMENT(Quest.TAI_BWO_WANNAI_TRIO, QuestState.IN_PROGRESS)),
	EXCHANGE_GEMS_FOR_MACHETE(
	    "Exchange gems for a machete.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.JUNGLE_POTION, QuestState.FINISHED)),
	USE_KARAMJA_GNOME_GLIDER(
	    "Use the gnome glider to travel to Karamja.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.THE_GRAND_TREE, QuestState.FINISHED)),
	GROW_BRIMHAVEN_FRUIT_TREE(
	    "Grow a healthy fruit tree in the patch near Brimhaven.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 27)),
	TRAP_HORNED_GRAAHK(
	    "Trap a horned graahk.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 41)),
	CHOP_BRIMHAVEN_DUNGEON_VINES(
	    "Chop the vines to gain deeper access to Brimhaven Dungeon.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 10)),
	CROSS_BRIMHAVEN_LAVA(
	    "Cross the lava using the stepping stones within Brimhaven Dungeon.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 12)),
	CLIMB_BRIMHAVEN_DUNGEON_STAIRS(
	    "Climb the stairs within Brimhaven Dungeon.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 10)),
	CHARTER_SHIPYARD_SHIP(
	    "Charter a ship from the shipyard in the far east of Karamja.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.THE_GRAND_TREE, QuestState.FINISHED)),
	MINE_RED_TOPAZ(
	    "Mine a red topaz from a gem rock.",
	    AD_GROUP.KARAMJA_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 40),
	    new AD_OR_REQUIREMENT(
	        new AD_QUEST_REQUIREMENT(Quest.SHILO_VILLAGE, QuestState.FINISHED),
	        new AD_QUEST_REQUIREMENT(Quest.JUNGLE_POTION, QuestState.FINISHED))),

    // HARD
	BECOME_FIGHT_PITS_CHAMPION(
	    "Become the champion of the Fight Pits.",
	    AD_GROUP.KARAMJA_HARD),
	KILL_KET_ZEK(
	    "Successfully kill a Ket-Zek in the Fight Caves.",
	    AD_GROUP.KARAMJA_HARD),
	EAT_OOMLIE_WRAP(
	    "Eat an Oomlie wrap.",
	    AD_GROUP.KARAMJA_HARD),
	CRAFT_NATURE_RUNES(
	    "Craft some nature runes from Essence.",
	    AD_GROUP.KARAMJA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 44)),
	COOK_KARAMBWAN(
	    "Cook a karambwan thoroughly.",
	    AD_GROUP.KARAMJA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 30),
	    new AD_QUEST_REQUIREMENT(Quest.TAI_BWO_WANNAI_TRIO, QuestState.FINISHED)),
	KILL_DEATHWING(
	    "Kill a deathwing in the dungeon under the Kharazi Jungle.",
	    AD_GROUP.KARAMJA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 15),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 50),
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 50),
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 50),
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 52),
	    new AD_QUEST_REQUIREMENT(Quest.LEGENDS_QUEST, QuestState.FINISHED)),
	USE_VOLCANO_CROSSBOW_SHORTCUT(
	    "Use the crossbow shortcut south of the volcano.",
	    AD_GROUP.KARAMJA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 53),
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 42),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 21)),
	COLLECT_PALM_LEAVES(
	    "Collect 5 palm leaves.",
	    AD_GROUP.KARAMJA_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 15),
	    new AD_QUEST_REQUIREMENT(Quest.LEGENDS_QUEST, QuestState.FINISHED)),
	GET_SHILO_SLAYER_TASK(
	    "Be assigned a Slayer task by the Slayer Master in Shilo Village.",
	    AD_GROUP.KARAMJA_HARD,
	    new AD_COMBAT_LEVEL_REQUIREMENT(100),
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 50),
	    new AD_QUEST_REQUIREMENT(Quest.SHILO_VILLAGE, QuestState.FINISHED)),
	KILL_BRIMHAVEN_METAL_DRAGON(
	    "Kill a metal dragon in Brimhaven Dungeon.",
	    AD_GROUP.KARAMJA_HARD),

    // ELITE
	CRAFT_56_NATURE_RUNES(
	    "Craft 56 Nature runes simultaneously from Essence without the use of Extracts.",
	    AD_GROUP.KARAMJA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 91)),
	EQUIP_FIRE_OR_INFERNAL_CAPE(
	    "Equip a fire cape or infernal cape in Mor Ul Rek.",
	    AD_GROUP.KARAMJA_ELITE),
	CHECK_BRIMHAVEN_PALM_TREE(
	    "Check the health of a palm tree in Brimhaven.",
	    AD_GROUP.KARAMJA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 68)),
	CREATE_ANTIVENOM(
	    "Create an antivenom potion whilst standing in the horse shoe mine.",
	    AD_GROUP.KARAMJA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 87)),
	CHECK_CALQUAT_TREE(
	    "Check the health of your Calquat tree patch.",
	    AD_GROUP.KARAMJA_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 72));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_KARAMJA_TASK(
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
