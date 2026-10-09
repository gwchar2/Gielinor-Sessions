
package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_ARDOUGNE_TASK implements AD_TASK
{
    // EASY
	ESS_MINE(
	    "Have Wizard Cromperty teleport you to the Rune Essence mine.",
	    AD_GROUP.ARDOUGNE_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.RUNE_MYSTERIES, QuestState.IN_PROGRESS)),
	STEAL_CAKE(
	    "Steal a cake from the Ardougne market stalls.",
	    AD_GROUP.ARDOUGNE_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 5)),
	SELL_SILK(
	    "Sell silk to Silk Trader in Ardougne for 60 coins each.",
	    AD_GROUP.ARDOUGNE_EASY),
	USE_EAST_ARDOUGNE_ALTAR(
	    "Use the altar in East Ardougne's church.",
	    AD_GROUP.ARDOUGNE_EASY),
	GO_FISHING_TRAWLER(
	    "Go out fishing on the Fishing Trawler.",
	    AD_GROUP.ARDOUGNE_EASY),
	ENTER_COMBAT_TRAINING_CAMP(
	    "Enter the Combat Training Camp north of W. Ardougne.",
	    AD_GROUP.ARDOUGNE_EASY,
	    new AD_QUEST_REQUIREMENT(Quest.BIOHAZARD, QuestState.FINISHED)),
	IDENTIFY_RUSTED_SWORD(
	    "Have Tindel Marchant identify a rusted sword for you.",
	    AD_GROUP.ARDOUGNE_EASY),
	USE_ARDOUGNE_WILDERNESS_LEVER(
	    "Use the Ardougne lever to teleport to the Wilderness.",
	    AD_GROUP.ARDOUGNE_EASY),
	VIEW_ALECK_HUNTER_EMPORIUM(
	    "View Aleck's Hunter Emporium in Yanille.",
	    AD_GROUP.ARDOUGNE_EASY),
	CHECK_PROBITA_INSURED_PETS(
	    "Check what pets you have insured with Probita in Ardougne.",
	    AD_GROUP.ARDOUGNE_EASY),

    // MEDIUM
	ENTER_UNICORN_PEN(
	    "Enter the Unicorn pen in Ardougne zoo using Fairy rings.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS)),
	GRAPPLE_YANILLE_WALL(
	    "Grapple over Yanille's south wall.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 39),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 38),
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 21)),
	HARVEST_STRAWBERRIES(
	    "Harvest some strawberries from the Ardougne farming patch.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 31)),
	CAST_ARDOUGNE_TELEPORT(
	    "Cast the Ardougne Teleport spell.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 51),
	    new AD_QUEST_REQUIREMENT(Quest.PLAGUE_CITY, QuestState.FINISHED)),
	TRAVEL_CASTLE_WARS_BALLOON(
	    "Travel to Castlewars by Hot Air Balloon.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 50),
	    new AD_QUEST_REQUIREMENT(Quest.ENLIGHTENED_JOURNEY, QuestState.FINISHED)),
	CLAIM_BERT_SAND(
	    "Claim buckets of sand from Bert in Yanille.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 49),
	    new AD_QUEST_REQUIREMENT(Quest.THE_HAND_IN_THE_SAND, QuestState.FINISHED)),
	FISH_FISHING_PLATFORM(
	    "Catch any fish on the Fishing Platform.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.SEA_SLUG, QuestState.IN_PROGRESS)),
	PICKPOCKET_MASTER_FARMER(
	    "Pickpocket the master farmer north of Ardougne.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 38)),
	COLLECT_NIGHTSHADE(
	    "Collect some Nightshade from the Skavid Caves.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.WATCHTOWER, QuestState.IN_PROGRESS)),
	KILL_SWORDCHICK(
	    "Kill a swordchick in the Tower of Life.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.TOWER_OF_LIFE, QuestState.FINISHED)),
	EQUIP_IBAN_STAFF(
	    "Equip Iban's upgraded staff or upgrade an Iban staff.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 50),
	    new AD_SKILL_REQUIREMENT(Skill.ATTACK, 50),
	    new AD_QUEST_REQUIREMENT(Quest.UNDERGROUND_PASS, QuestState.FINISHED)),
	VISIT_NECROMANCER_ISLAND(
	    "Visit the Island East of the Necromancer's tower.",
	    AD_GROUP.ARDOUGNE_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.FAIRYTALE_II__CURE_A_QUEEN, QuestState.IN_PROGRESS)),

    // HARD
	RECHARGE_JEWELLERY_TOTEM(
	    "Recharge some Jewellery at the Totem in the Legends Guild.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.LEGENDS_QUEST, QuestState.FINISHED)),
	ENTER_MAGIC_GUILD(
	    "Enter the Magic Guild.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 66)),
	STEAL_ARDOUGNE_CASTLE_CHEST(
	    "Steal from a chest in Ardougne Castle.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 72)),
	ENTER_MONKEY_CAGE(
	    "Have a zookeeper put you in Ardougne Zoo's monkey cage.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.MONKEY_MADNESS_I, QuestState.IN_PROGRESS)),
	TELEPORT_WATCHTOWER(
	    "Teleport to the Watchtower.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 58),
	    new AD_QUEST_REQUIREMENT(Quest.WATCHTOWER, QuestState.FINISHED)),
	CATCH_RED_SALAMANDER(
	    "Catch a Red Salamander.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.HUNTER, 59)),
	CHECK_PALM_TREE(
	    "Check the health of a Palm tree near tree gnome village.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 68)),
	PICK_POISON_IVY(
	    "Pick some Poison Ivy berries from the patch south of Ardougne.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 70)),
	SMITH_MITHRIL_PLATEBODY(
	    "Smith a Mithril platebody near Ardougne.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 68)),
	ENTER_YANILLE_POH(
	    "Enter your POH from Yanille.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 50)),
	SMITH_DRAGON_SQ_SHIELD(
	    "Smith a Dragon sq shield in West Ardougne.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 60),
	    new AD_QUEST_REQUIREMENT(Quest.LEGENDS_QUEST, QuestState.FINISHED)),
	CRAFT_DEATH_RUNES(
	    "Craft some Death runes from Essence.",
	    AD_GROUP.ARDOUGNE_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 65),
	    new AD_QUEST_REQUIREMENT(Quest.MOURNINGS_END_PART_II, QuestState.FINISHED)),

    // ELITE
	CATCH_AND_COOK_MANTA_RAY(
	    "Catch a Manta ray in the Fishing Trawler and cook it in Port Khazard.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FISHING, 81),
	    new AD_SKILL_REQUIREMENT(Skill.COOKING, 91)),
	PICKLOCK_YANILLE_DUNGEON(
	    "Picklock the door to the basement of Yanille Agility Dungeon.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 82)),
	PICKPOCKET_HERO(
	    "Pickpocket a Hero.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 80)),
	MAKE_RUNE_CROSSBOW(
	    "Make a rune crossbow yourself from scratch within Witchaven or Yanille.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 10),
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 91),
	    new AD_SKILL_REQUIREMENT(Skill.FLETCHING, 69)),
	IMBUE_SALVE_AMULET(
	    "Imbue a Salve amulet at Nightmare Zone, or equip a Salve amulet that was imbued there.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_QUEST_REQUIREMENT(Quest.HAUNTED_MINE, QuestState.FINISHED)),
	HARVEST_TORSTOL(
	    "Pick some Torstol from the patch north of Ardougne.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 85)),
	COMPLETE_ARDOUGNE_ROOFTOP(
	    "Complete a lap of Ardougne's rooftop agility course.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 90)),
	CAST_ICE_BARRAGE_CASTLE_WARS(
	    "Cast Ice Barrage on another player within Castle Wars.",
	    AD_GROUP.ARDOUGNE_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 94),
	    new AD_QUEST_REQUIREMENT(Quest.DESERT_TREASURE_I, QuestState.FINISHED));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_ARDOUGNE_TASK(
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
