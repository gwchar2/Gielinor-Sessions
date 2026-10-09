
package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_DESERT_TASK implements AD_TASK
{
    // EASY
	CATCH_GOLDEN_WARBLER(
	    "Catch a Golden Warbler.",
	    AD_GROUP.DESERT_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 5)),
	MINE_CLAY(
	    "Mine 5 clay in the north-eastern desert.",
	    AD_GROUP.DESERT_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 5)),
	ENTER_KALPHITE_HIVE(
	    "Enter the Kalphite Hive.",
	    AD_GROUP.DESERT_EASY),
	ENTER_DESERT_ROBES(
	    "Enter the Desert with a set of desert robes equipped.",
	    AD_GROUP.DESERT_EASY),
	KILL_VULTURE(
	    "Kill a vulture.",
	    AD_GROUP.DESERT_EASY),
	CLEAN_HERB_NARDAH(
	    "Have the Nardah herbalist clean a herb for you.",
	    AD_GROUP.DESERT_EASY),
	COLLECT_POTATO_CACTUS(
	    "Collect 5 potato cactus from the Kalphite Hive.",
	    AD_GROUP.DESERT_EASY),
	SELL_ARTEFACTS_SIMON_TEMPLETON(
	    "Sell some artefacts to Simon Templeton.",
	    AD_GROUP.DESERT_EASY),
	OPEN_PYRAMID_PLUNDER_SARCOPHAGUS(
	    "Open the Sarcophagus in the first room of Pyramid Plunder.",
	    AD_GROUP.DESERT_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 21),
	    new AD_QUEST_REQUIREMENT(Quest.ICTHLARINS_LITTLE_HELPER, QuestState.IN_PROGRESS)),
	FILL_WATERSKIN_DESERT_CACTUS(
	    "Cut a desert cactus open to fill a waterskin.",
	    AD_GROUP.DESERT_EASY),
	TRAVEL_SHANTAY_POLLNIVNEACH_CARPET(
	    "Travel from the Shantay Pass to Pollnivneach by Magic Carpet.",
	    AD_GROUP.DESERT_EASY),

    // MEDIUM
	CLIMB_AGILITY_PYRAMID(
	    "Climb to the summit of the Agility Pyramid.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 30)),
	SLAY_DESERT_LIZARD(
	    "Slay a desert lizard.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 22)),
	CATCH_ORANGE_SALAMANDER(
	    "Catch an Orange Salamander.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 47)),
	STEAL_DESERT_PHOENIX_FEATHER(
	    "Steal a feather from the Desert Phoenix.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 25)),
	TRAVEL_UZER_MAGIC_CARPET(
	    "Travel to Uzer via Magic Carpet.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.THE_GOLEM, QuestState.FINISHED)),
	TRAVEL_DESERT_EAGLE(
	    "Travel to the Desert via Eagle.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.EAGLES_PEAK, QuestState.FINISHED)),
	PRAY_ELIDINIS_STATUETTE(
	    "Pray at the Elidinis statuette in Nardah.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.SPIRITS_OF_THE_ELID, QuestState.FINISHED)),
	CREATE_COMBAT_POTION(
	    "Create a combat potion in the desert.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 36)),
	TELEPORT_ENAKHRA_TEMPLE(
	    "Teleport to Enakhra's Temple with the Camulet.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.ENAKHRAS_LAMENT, QuestState.FINISHED)),
	VISIT_GENIE(
	    "Visit the Genie.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.SPIRITS_OF_THE_ELID, QuestState.FINISHED)),
	TELEPORT_POLLNIVNEACH(
	    "Teleport to Pollnivneach with a redirected teleport to house tablet.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 20)),
	CHOP_TEAK_LOGS(
	    "Chop some Teak logs near Uzer.",
	    AD_GROUP.DESERT_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 35)),

    // HARD
	PICKPOCKET_MENAPHITE_THUG(
	    "Knock out and pickpocket a Menaphite Thug.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 65),
	    new AD_QUEST_REQUIREMENT(Quest.THE_FEUD, QuestState.FINISHED)),
	MINE_GRANITE(
	    "Mine some Granite.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 45)),
	REFILL_WATERSKINS_LUNAR(
	    "Refill your waterskins in the Desert using Lunar magic.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 68),
	    new AD_QUEST_REQUIREMENT(Quest.DREAM_MENTOR, QuestState.FINISHED)),
	KILL_KALPHITE_QUEEN(
	    "Kill the Kalphite Queen.",
	    AD_GROUP.DESERT_HARD),
	COMPLETE_POLLNIVNEACH_AGILITY(
	    "Complete a lap of the Pollnivneach agility course.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 70)),
	SLAY_DUST_DEVIL(
	    "Slay a Dust Devil in the desert cave with a Slayer helmet equipped.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 65),
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 10),
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 55),
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.IN_PROGRESS)),
	ACTIVATE_ANCIENT_MAGICKS(
	    "Activate Ancient Magicks at the altar in the Jaldraocht Pyramid.",
	    AD_GROUP.DESERT_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.FINISHED)),
	DEFEAT_LOCUST_RIDER(
	    "Defeat a Locust Rider with Keris.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.ATTACK, 50),
	    new AD_QUEST_REQUIREMENT(Quest.CONTACT, QuestState.FINISHED)),
	BURN_YEW_LOGS(
	    "Burn some yew logs on the Nardah Mayor's balcony.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 60)),
	SMITH_MITHRIL_PLATEBODY_NARDAH(
	    "Create a Mithril Platebody in Nardah.",
	    AD_GROUP.DESERT_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 68)),

    // ELITE
	BAKE_WILD_PIE(
	    "Bake a wild pie at the Nardah Clay Oven.",
	    AD_GROUP.DESERT_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 85)),
	CAST_ICE_BARRAGE_DESERT(
	    "Cast Ice Barrage against a foe in the Desert.",
	    AD_GROUP.DESERT_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 94),
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.FINISHED)),
	FLETCH_DRAGON_DARTS(
	    "Fletch some Dragon darts at the Bedabin Camp.",
	    AD_GROUP.DESERT_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 95),
	    new AD_QUEST_REQUIREMENT(Quest.THE_TOURIST_TRAP, QuestState.FINISHED)),
	SPEAK_KQ_HEAD(
	    "Speak to the KQ head in your POH.",
	    AD_GROUP.DESERT_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 78),
	    new AD_QUEST_REQUIREMENT(Quest.PRIEST_IN_PERIL, QuestState.FINISHED)),
	STEAL_GRAND_GOLD_CHEST(
	    "Steal from the Grand Gold Chest in the final room of Pyramid Plunder.",
	    AD_GROUP.DESERT_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 91),
	    new AD_QUEST_REQUIREMENT(Quest.ICTHLARINS_LITTLE_HELPER, QuestState.IN_PROGRESS)),
	RESTORE_PRAYER_SOPHANEM(
	    "Restore at least 85 Prayer points when praying at the Altar in Sophanem.",
	    AD_GROUP.DESERT_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.PRAYER, 85),
	    new AD_QUEST_REQUIREMENT(Quest.ICTHLARINS_LITTLE_HELPER, QuestState.IN_PROGRESS));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_DESERT_TASK(
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
