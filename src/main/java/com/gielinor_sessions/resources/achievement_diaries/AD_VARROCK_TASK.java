
package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_VARROCK_TASK implements AD_TASK
{
    // EASY
	BROWSE_THESSALIA_STORE(
	    "Browse Thessalia's store.",
	    AD_GROUP.VARROCK_EASY),
	TELEPORT_ESSENCE_MINE_AUBURY(
	    "Have Aubury teleport you to the Essence mine.",
	    AD_GROUP.VARROCK_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.RUNE_MYSTERIES, QuestState.FINISHED)),
	MINE_VARROCK_IRON(
	    "Mine some Iron in the south east mining patch near Varrock.",
	    AD_GROUP.VARROCK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 15)),
	MAKE_NORMAL_PLANK(
	    "Make a normal plank at the sawmill.",
	    AD_GROUP.VARROCK_EASY),
	ENTER_STRONGHOLD_SECOND_LEVEL(
	    "Enter the second level of the Stronghold of Security.",
	    AD_GROUP.VARROCK_EASY),
	JUMP_VARROCK_FENCE(
	    "Jump over the fence south of Varrock.",
	    AD_GROUP.VARROCK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 13)),
	CHOP_DYING_TREE(
	    "Chop down a dying tree in the Lumber Yard.",
	    AD_GROUP.VARROCK_EASY),
	BUY_NEWSPAPER(
	    "Buy a newspaper.",
	    AD_GROUP.VARROCK_EASY),
	GIVE_DOG_BONE(
	    "Give a dog a bone!",
	    AD_GROUP.VARROCK_EASY),
	CRAFT_BARBARIAN_VILLAGE_BOWL(
	    "Spin a bowl on the pottery wheel and fire it in the oven in Barb Village.",
	    AD_GROUP.VARROCK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 8)),
	SPEAK_HAIG_HALEN_50_KUDOS(
	    "Speak to Haig Halen after obtaining at least 50 Kudos.",
	    AD_GROUP.VARROCK_EASY),
	CRAFT_EARTH_RUNES(
	    "Craft some Earth runes from Essence.",
	    AD_GROUP.VARROCK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 9)),
	CATCH_BARBARIAN_VILLAGE_TROUT(
	    "Catch some trout in the River Lum at Barbarian Village.",
	    AD_GROUP.VARROCK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 20)),
	STEAL_VARROCK_TEA_STALL(
	    "Steal from the Tea stall in Varrock.",
	    AD_GROUP.VARROCK_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 5)),

    // MEDIUM
	APOTHECARY_STRENGTH_POTION(
	    "Have the Apothecary in Varrock make you a strength potion.",
	    AD_GROUP.VARROCK_MEDIUM),
	ENTER_CHAMPIONS_GUILD(
	    "Enter the Champions' Guild.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_QUEST_POINT_REQUIREMENT(32)),
	SELECT_KITTEN_COLOUR(
	    "Select a colour for your kitten.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.GARDEN_OF_TRANQUILLITY, QuestState.IN_PROGRESS),
	    new AD_QUEST_REQUIREMENT(Quest.GERTRUDES_CAT, QuestState.FINISHED)),
	USE_VARROCK_SPIRIT_TREE(
	    "Use the spirit tree north of Varrock.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.TREE_GNOME_VILLAGE, QuestState.FINISHED)),
	PERFORM_STRONGHOLD_EMOTES(
	    "Perform the 4 emotes from the Stronghold of Security.",
	    AD_GROUP.VARROCK_MEDIUM),
	ENTER_TOLNA_DUNGEON(
	    "Enter the Tolna dungeon after completing A Soul's Bane.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.A_SOULS_BANE, QuestState.FINISHED)),
	TELEPORT_DIGSITE_PENDANT(
	    "Teleport to the digsite using a Digsite pendant.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.THE_DIG_SITE, QuestState.FINISHED)),
	TELEPORT_VARROCK(
	    "Cast the teleport to Varrock spell.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 25)),
	GET_VANNAKA_SLAYER_TASK(
	    "Get a Slayer task from Vannaka.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_COMBAT_LEVEL_REQUIREMENT(40)),
	MAKE_20_MAHOGANY_PLANKS(
	    "Make 20 mahogany planks in one go.",
	    AD_GROUP.VARROCK_MEDIUM),
	PICK_WHITE_TREE_FRUIT(
	    "Pick a White tree fruit.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 25),
	    new AD_QUEST_REQUIREMENT(Quest.GARDEN_OF_TRANQUILLITY, QuestState.FINISHED)),
	TRAVEL_VARROCK_BALLOON(
	    "Use the balloon to travel from Varrock.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 40),
	    new AD_QUEST_REQUIREMENT(Quest.ENLIGHTENED_JOURNEY, QuestState.FINISHED)),
	COMPLETE_VARROCK_AGILITY(
	    "Complete a lap of the Varrock Agility course.",
	    AD_GROUP.VARROCK_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 30)),

    // HARD
	EQUIP_SPOTTIER_CAPE(
	    "Trade furs with the Fancy Dress Seller for a spottier cape and equip it.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 66)),
	SPEAK_ORLANDO_SMITH_153_KUDOS(
	    "Speak to Orlando Smith when you have achieved 153 Kudos.",
	    AD_GROUP.VARROCK_HARD),
	MAKE_EDGEVILLE_WAKA_CANOE(
	    "Make a Waka Canoe near Edgeville.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 57)),
	TELEPORT_PADDEWWA(
	    "Teleport to Paddewwa.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 54),
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.FINISHED)),
	TELEPORT_BARBARIAN_VILLAGE_SKULL_SCEPTRE(
	    "Teleport to Barbarian Village with a skull sceptre.",
	    AD_GROUP.VARROCK_HARD),
	CHOP_BURN_VARROCK_YEW_LOGS(
	    "Chop some yew logs in Varrock and burn them at the top of the Varrock church.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 60),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 60)),
	DECORATE_VARROCK_HOUSE_FANCY_STONE(
	    "Have the Varrock estate agent decorate your house with Fancy Stone.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 50)),
	COLLECT_VARROCK_YEW_ROOTS(
	    "Collect at least 2 yew roots from the Tree patch in Varrock Palace.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 60),
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 68)),
	PRAY_VARROCK_PALACE_SMITE(
	    "Pray at the altar in Varrock palace with Smite active.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.PRAYER, 52)),
	SQUEEZE_EDGEVILLE_DUNGEON_PIPE(
	    "Squeeze through an obstacle pipe in Edgeville dungeon.",
	    AD_GROUP.VARROCK_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 51)),

    // ELITE
	CREATE_SUPER_COMBAT_POTION(
	    "Create a super combat potion in Varrock west bank.",
	    AD_GROUP.VARROCK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 90),
	    new AD_QUEST_REQUIREMENT(Quest.DRUIDIC_RITUAL, QuestState.FINISHED)),
	MAKE_MAHOGANY_PLANKS_LUNAR(
	    "Use Lunar magic to make 20 mahogany planks at the Lumberyard.",
	    AD_GROUP.VARROCK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 86),
	    new AD_QUEST_REQUIREMENT(Quest.DREAM_MENTOR, QuestState.FINISHED)),
	BAKE_SUMMER_PIE(
	    "Bake a summer pie in the Cooking Guild.",
	    AD_GROUP.VARROCK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 95)),
	SMITH_FLETCH_RUNE_DARTS(
	    "Smith and fletch ten rune darts within Varrock.",
	    AD_GROUP.VARROCK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 89),
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 81),
	    new AD_QUEST_REQUIREMENT(Quest.THE_TOURIST_TRAP, QuestState.FINISHED)),
	CRAFT_100_EARTH_RUNES(
	    "Craft 100 or more earth runes simultaneously from Essence without the use of Extracts.",
	    AD_GROUP.VARROCK_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 78));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_VARROCK_TASK(
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
