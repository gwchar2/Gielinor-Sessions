
package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_LUMBRIDGE_TASK implements AD_TASK
{
    // EASY
	COMPLETE_DRAYNOR_AGILITY(
	    "Complete a lap of the Draynor Village agility course.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 10)),
	SLAY_CAVE_BUG(
	    "Slay a Cave bug beneath Lumbridge Swamp.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 7)),
	TELEPORT_ESSENCE_MINE_SEDRIDOR(
	    "Have Sedridor teleport you to the Essence Mine.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.RUNE_MYSTERIES, QuestState.FINISHED)),
	CRAFT_WATER_RUNES(
	    "Craft some water runes from Essence.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 5)),
	LEARN_AGE_FROM_HANS(
	    "Learn your age from Hans in Lumbridge.",
	    AD_GROUP.LUMBRIDGE_EASY),
	PICKPOCKET_LUMBRIDGE_CITIZEN(
	    "Pickpocket a man or woman in Lumbridge.",
	    AD_GROUP.LUMBRIDGE_EASY),
	CHOP_BURN_OAK_LOGS(
	    "Chop and burn some oak logs in Lumbridge.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 15),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 15)),
	KILL_DRAYNOR_ZOMBIE(
	    "Kill a zombie in Draynor sewers.",
	    AD_GROUP.LUMBRIDGE_EASY),
	CATCH_AL_KHARID_ANCHOVIES(
	    "Catch some Anchovies in Al Kharid.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 15)),
	BAKE_BREAD_LUMBRIDGE(
	    "Bake some Bread on the Lumbridge kitchen range.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.COOKS_ASSISTANT, QuestState.FINISHED)),
	MINE_AL_KHARID_IRON(
	    "Mine some Iron ore at the Al Kharid mine.",
	    AD_GROUP.LUMBRIDGE_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 15)),
	ENTER_HAM_HIDEOUT(
	    "Enter the H.A.M. hideout.",
	    AD_GROUP.LUMBRIDGE_EASY),

    // MEDIUM
	COMPLETE_AL_KHARID_AGILITY(
	    "Complete a lap of the Al Kharid agility course.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 20)),
	GRAPPLE_RIVER_LUM(
	    "Grapple across the River Lum.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 8),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 19),
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 37)),
	PURCHASE_AVA_UPGRADE(
	    "Purchase an upgraded device from Ava.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 50),
	    new AD_QUEST_REQUIREMENT(Quest.ANIMAL_MAGNETISM, QuestState.FINISHED)),
	TRAVEL_WIZARDS_TOWER_FAIRY_RING(
	    "Travel to the Wizards' Tower by Fairy ring.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS)),
	TELEPORT_LUMBRIDGE(
	    "Cast the teleport to Lumbridge spell.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 31)),
	CATCH_LUMBRIDGE_SALMON(
	    "Catch some Salmon in Lumbridge.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 30)),
	CRAFT_COIF(
	    "Craft a coif in the Lumbridge cow pen.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 38)),
	CHOP_DRAYNOR_WILLOW_LOGS(
	    "Chop some willow logs in Draynor Village.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 30)),
	PICKPOCKET_MARTIN(
	    "Pickpocket Martin the Master Gardener.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 38)),
	GET_CHAELDAR_SLAYER_TASK(
	    "Get a slayer task from Chaeldar.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_COMBAT_LEVEL_REQUIREMENT(70),
	    new AD_QUEST_REQUIREMENT(Quest.LOST_CITY, QuestState.FINISHED)),
	CATCH_PURO_PURO_IMPLING(
	    "Catch an Essence or Eclectic impling in Puro-Puro.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 42),
	    new AD_QUEST_REQUIREMENT(Quest.LOST_CITY, QuestState.FINISHED)),
	CRAFT_LAVA_RUNES(
	    "Craft some Lava runes at the fire altar in Al Kharid.",
	    AD_GROUP.LUMBRIDGE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 23)),

    // HARD
	CAST_BONES_TO_PEACHES(
	    "Cast Bones to Peaches in Al Kharid palace.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 60)),
	SQUEEZE_COSMIC_ALTAR_WALL(
	    "Squeeze past the jutting wall on your way to the cosmic altar.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 46),
	    new AD_QUEST_REQUIREMENT(Quest.LOST_CITY, QuestState.FINISHED)),
	CRAFT_56_COSMIC_RUNES(
	    "Craft 56 Cosmic runes simultaneously from Essence without the use of Extracts.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 59),
	    new AD_QUEST_REQUIREMENT(Quest.LOST_CITY, QuestState.FINISHED)),
	TRAVEL_WAKA_CANOE(
	    "Travel from Lumbridge to Edgeville on a Waka Canoe.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 57)),
	COLLECT_TEARS_OF_GUTHIX(
	    "Collect at least 100 Tears of Guthix in one visit.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.TEARS_OF_GUTHIX, QuestState.FINISHED)),
	TAKE_DORGESH_KAAN_TRAIN(
	    "Take the train from Dorgesh-Kaan to Keldagrim.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.ANOTHER_SLICE_OF_HAM, QuestState.FINISHED)),
	PURCHASE_BARROWS_GLOVES(
	    "Purchase some Barrows gloves from the Lumbridge bank chest.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.RECIPE_FOR_DISASTER, QuestState.FINISHED)),
	PICK_DRAYNOR_BELLADONNA(
	    "Pick some Belladonna from the farming patch at Draynor Manor.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 63)),
	LIGHT_MINING_HELMET(
	    "Light your mining helmet in the Lumbridge castle basement.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 65)),
	RECHARGE_PRAYER_SMITE(
	    "Recharge your prayer at the Emir's Arena with Smite activated.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.PRAYER, 52)),
	CRAFT_AMULET_OF_POWER(
	    "Craft, string and enchant an Amulet of Power in Lumbridge.",
	    AD_GROUP.LUMBRIDGE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 70),
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 57)),

    // ELITE
	STEAL_DORGESH_KAAN_CHEST(
	    "Steal from a Dorgesh-Kaan rich chest.",
	    AD_GROUP.LUMBRIDGE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 78),
	    new AD_QUEST_REQUIREMENT(Quest.DEATH_TO_THE_DORGESHUUN, QuestState.FINISHED)),
	GRAPPLE_DORGESH_KAAN_PYLON(
	    "Grapple across a pylon on the Dorgesh-Kaan Agility Course.",
	    AD_GROUP.LUMBRIDGE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 70),
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 70),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 70),
	    new AD_QUEST_REQUIREMENT(Quest.DEATH_TO_THE_DORGESHUUN, QuestState.FINISHED)),
	CHOP_MAGE_TRAINING_MAGIC_LOGS(
	    "Chop some magic logs at the Mage Training Arena.",
	    AD_GROUP.LUMBRIDGE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 75)),
	SMITH_DRAYNOR_ADAMANT_PLATEBODY(
	    "Smith an Adamant platebody down Draynor sewer.",
	    AD_GROUP.LUMBRIDGE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 88)),
	CRAFT_140_WATER_RUNES(
	    "Craft 140 or more Water runes simultaneously from Essence without the use of Extracts.",
	    AD_GROUP.LUMBRIDGE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 76)),
	PERFORM_QUEST_CAPE_EMOTE(
	    "Perform the Quest Cape emote in the Wise Old Man's house.",
	    AD_GROUP.LUMBRIDGE_ELITE);

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_LUMBRIDGE_TASK(
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
