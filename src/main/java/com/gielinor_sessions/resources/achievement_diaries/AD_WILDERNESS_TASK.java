package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_WILDERNESS_TASK implements AD_TASK
{
    // EASY
	CAST_LOW_ALCHEMY_FOUNTAIN_OF_RUNE(
	    "Cast Low Alchemy at the Fountain of Rune.",
	    AD_GROUP.WILDERNESS_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 21)),
	KILL_EARTH_WARRIOR(
	    "Kill an Earth Warrior in the Wilderness beneath Edgeville.",
	    AD_GROUP.WILDERNESS_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 15)),
	MINE_WILDERNESS_IRON(
	    "Mine some Iron ore in the Wilderness.",
	    AD_GROUP.WILDERNESS_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 15)),
	TELEPORT_ABYSS_ZAMORAK_MAGE(
	    "Have the Mage of Zamorak teleport you to the Abyss.",
	    AD_GROUP.WILDERNESS_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.ENTER_THE_ABYSS, QuestState.FINISHED)),

    // MEDIUM
	MINE_WILDERNESS_MITHRIL(
	    "Mine some Mithril ore in the wilderness.",
	    AD_GROUP.WILDERNESS_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 55)),
	CHOP_FALLEN_ENT_YEW_LOGS(
	    "Chop some yew logs from a fallen Ent.",
	    AD_GROUP.WILDERNESS_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 61)),
	ENTER_WILDERNESS_GODWARS_DUNGEON(
	    "Enter the Wilderness Godwars Dungeon.",
	    AD_GROUP.WILDERNESS_MEDIUM,
	    new AD_OR_REQUIREMENT(
	        new AD_SKILL_REQUIREMENT(Skill.AGILITY, 60),
	        new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 60))),
	COMPLETE_WILDERNESS_AGILITY(
	    "Complete a lap of the Wilderness Agility course.",
	    AD_GROUP.WILDERNESS_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 52)),
	CHARGE_EARTH_ORB(
	    "Charge an Earth Orb.",
	    AD_GROUP.WILDERNESS_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 60)),
	KILL_WILDERNESS_BLOODVELD(
	    "Kill a Bloodveld in the Wilderness Godwars Dungeon.",
	    AD_GROUP.WILDERNESS_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 50)),
	SMITH_RESOURCE_AREA_GOLDEN_HELMET(
	    "Smith a Golden helmet in the Resource Area.",
	    AD_GROUP.WILDERNESS_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 50),
	    new AD_QUEST_REQUIREMENT(Quest.BETWEEN_A_ROCK, QuestState.IN_PROGRESS)),

    // HARD
	CAST_GOD_SPELL_WILDERNESS(
	    "Cast one of the 3 God spells against another player in the Wilderness.",
	    AD_GROUP.WILDERNESS_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 60),
	    new AD_QUEST_REQUIREMENT(Quest.MAGE_ARENA_I, QuestState.FINISHED)),
	CHARGE_AIR_ORB(
	    "Charge an Air Orb.",
	    AD_GROUP.WILDERNESS_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 66)),
	CATCH_BLACK_SALAMANDER(
	    "Catch a Black Salamander in the Wilderness.",
	    AD_GROUP.WILDERNESS_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 67)),
	SMITH_RESOURCE_AREA_ADAMANT_SCIMITAR(
	    "Smith an Adamant scimitar in the Resource Area.",
	    AD_GROUP.WILDERNESS_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 75)),
	USE_TROLLHEIM_WILDERNESS_SHORTCUT(
	    "Take the agility shortcut from Trollheim into the Wilderness.",
	    AD_GROUP.WILDERNESS_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 64),
	    new AD_QUEST_REQUIREMENT(Quest.DEATH_PLATEAU, QuestState.FINISHED)),
	KILL_WILDERNESS_SPIRITUAL_WARRIOR(
	    "Kill a Spiritual warrior in the Wilderness Godwars Dungeon.",
	    AD_GROUP.WILDERNESS_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 68)),
	FISH_WILDERNESS_LAVA_EEL(
	    "Fish some Raw Lava Eel in the Wilderness.",
	    AD_GROUP.WILDERNESS_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 53)),

    // ELITE
	TELEPORT_GHORROCK(
	    "Teleport to Ghorrock.",
	    AD_GROUP.WILDERNESS_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 96),
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.FINISHED)),
	FISH_COOK_RESOURCE_AREA_DARK_CRAB(
	    "Fish and Cook a Dark Crab in the Resource Area.",
	    AD_GROUP.WILDERNESS_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 85),
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 90)),
	SMITH_RESOURCE_AREA_RUNE_SCIMITAR(
	    "Smith a rune scimitar from scratch in the Resource Area.",
	    AD_GROUP.WILDERNESS_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 85),
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 90)),
	STEAL_ROGUES_CHEST(
	    "Steal from the Rogues' chest.",
	    AD_GROUP.WILDERNESS_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 84)),
	KILL_WILDERNESS_SPIRITUAL_MAGE(
	    "Slay a spiritual mage inside the wilderness Godwars Dungeon.",
	    AD_GROUP.WILDERNESS_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 83),
	    new AD_OR_REQUIREMENT(
	        new AD_SKILL_REQUIREMENT(Skill.AGILITY, 60),
	        new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 60))),
	CHOP_BURN_RESOURCE_AREA_MAGIC_LOGS(
	    "Cut and burn some magic logs in the Resource Area.",
	    AD_GROUP.WILDERNESS_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 75),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 75));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_WILDERNESS_TASK(
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