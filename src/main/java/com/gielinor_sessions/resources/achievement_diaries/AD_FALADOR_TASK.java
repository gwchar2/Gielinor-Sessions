
package com.gielinor_sessions.resources.achievement_diaries;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Skill;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

import com.gielinor_sessions.resources.achievement_diaries.requirements.*;

@Getter
public enum AD_FALADOR_TASK implements AD_TASK
{
    // EASY
	FIND_FAMILY_CREST(
	    "Find out what your family crest is from Sir Renitee.",
	    AD_GROUP.FALADOR_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.CONSTRUCTION, 16)),
	CLIMB_FALADOR_WALL(
	    "Climb over the western Falador wall.",
	    AD_GROUP.FALADOR_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 5)),
	BROWSE_SARAH_FARM_SHOP(
	    "Browse Sarah's farm shop.",
	    AD_GROUP.FALADOR_EASY),
	GET_FALADOR_HAIRCUT(
	    "Get a haircut or a shave from the Falador hairdresser.",
	    AD_GROUP.FALADOR_EASY),
	FILL_FALADOR_PUMP_BUCKET(
	    "Fill a bucket from the pump north of Falador west bank.",
	    AD_GROUP.FALADOR_EASY),
	KILL_FALADOR_PARK_DUCK(
	    "Kill a duck in Falador park.",
	    AD_GROUP.FALADOR_EASY),
	MAKE_MIND_TIARA(
	    "Make a mind tiara.",
	    AD_GROUP.FALADOR_EASY),
	TAKE_BOAT_ENTRANA(
	    "Take the boat to Entrana.",
	    AD_GROUP.FALADOR_EASY),
	REPAIR_MOTHERLODE_STRUT(
	    "Repair a broken strut in the Motherlode Mine.",
	    AD_GROUP.FALADOR_EASY),
	CLAIM_SECURITY_BOOK(
	    "Claim a security book from the security guard at Port Sarim jail.",
	    AD_GROUP.FALADOR_EASY),
	SMITH_BLURITE_LIMBS(
	    "Smith some Blurite Limbs on Doric's Anvil.",
	    AD_GROUP.FALADOR_EASY,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 10),
	    new AD_SKILL_REQUIREMENT(Skill.SMITHING, 13),
	    new AD_QUEST_REQUIREMENT(Quest.THE_KNIGHTS_SWORD, QuestState.FINISHED),
	    new AD_QUEST_REQUIREMENT(Quest.DORICS_QUEST, QuestState.FINISHED)),

    // MEDIUM
	LIGHT_BULLSEYE_LANTERN(
	    "Light a Bullseye lantern at the Chemist's in Rimmington.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 49)),
	TELEGRAB_WINE_OF_ZAMORAK(
	    "Telegrab some Wine of Zamorak at the Chaos Temple by the Wilderness.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 33)),
	UNLOCK_TAVERLEY_CRYSTAL_CHEST(
	    "Unlock the crystal chest in Taverley",
	    AD_GROUP.FALADOR_MEDIUM),
	PLACE_SCARECROW(
	    "Place a Scarecrow in the Falador farming patch.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 23)),
	KILL_MOGRE(
	    "Kill a Mogre at Mudskipper Point.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 32),
	    new AD_QUEST_REQUIREMENT(Quest.SKIPPY_AND_THE_MOGRES, QuestState.FINISHED)),
	VISIT_PORT_SARIM_RAT_PITS(
	    "Visit the Port Sarim Rat Pits.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_QUEST_REQUIREMENT(Quest.RATCATCHERS, QuestState.IN_PROGRESS)),
	GRAPPLE_FALADOR_WALL(
	    "Grapple up and then jump off the north Falador wall.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 11),
	    new AD_SKILL_REQUIREMENT(Skill.STRENGTH, 37),
	    new AD_SKILL_REQUIREMENT(Skill.RANGED, 19)),
	PICKPOCKET_FALADOR_GUARD(
	    "Pickpocket a Falador guard.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 40)),
	PRAY_GUTHIX_ALTAR(
	    "Pray at the Altar of Guthix in Taverley whilst wearing full Initiate.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.PRAYER, 10),
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 20),
	    new AD_QUEST_REQUIREMENT(Quest.RECRUITMENT_DRIVE, QuestState.FINISHED)),
	MINE_CRAFTING_GUILD_GOLD(
	    "Mine some Gold ore at the Crafting Guild.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 40),
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 40)),
	SQUEEZE_DWARVEN_MINES_CREVICE(
	    "Squeeze through the crevice in the Dwarven mines.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 42)),
	CHOP_BURN_WILLOW_LOGS(
	    "Chop and burn some Willow logs in Taverley",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 30),
	    new AD_SKILL_REQUIREMENT(Skill.FIREMAKING, 30)),
	CRAFT_FRUIT_BASKET(
	    "Craft a fruit basket on the Falador Farm loom.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.CRAFTING, 36)),
	TELEPORT_FALADOR(
	    "Teleport to Falador.",
	    AD_GROUP.FALADOR_MEDIUM,
	    new AD_SKILL_REQUIREMENT(Skill.MAGIC, 37)),

    // HARD
	CRAFT_140_MIND_RUNES(
	    "Craft 140 Mind runes simultaneously from Essence without the use of Extracts.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 56)),
	CHANGE_FAMILY_CREST_SARADOMIN(
	    "Change your family crest to the Saradomin symbol.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.PRAYER, 70)),
	KILL_GIANT_MOLE(
	    "Kill the Giant Mole beneath Falador park.",
	    AD_GROUP.FALADOR_HARD),
	KILL_SKELETAL_WYVERN(
	    "Kill a Skeletal Wyvern in the Asgarnia Ice Dungeon.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.SLAYER, 72)),
	COMPLETE_FALADOR_ROOFTOP(
	    "Complete a lap of the Falador rooftop agility course.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 50)),
	ENTER_MINING_GUILD_PROSPECTOR(
	    "Enter the mining guild wearing a Prospector helmet.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.MINING, 60)),
	KILL_HEROES_GUILD_BLUE_DRAGON(
	    "Kill the Blue Dragon under the Heroes' Guild.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_QUEST_REQUIREMENT(Quest.HEROES_QUEST, QuestState.FINISHED)),
	CRACK_ROGUES_DEN_SAFE(
	    "Crack a wall safe within Rogues Den.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.THIEVING, 50)),
	RECHARGE_PRAYER_PROSELYTE(
	    "Recharge your prayer in the Port Sarim church while wearing full Proselyte.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 30),
	    new AD_QUEST_REQUIREMENT(Quest.THE_SLUG_MENACE, QuestState.FINISHED)),
	ENTER_WARRIORS_GUILD(
	    "Enter the Warriors' Guild.",
	    AD_GROUP.FALADOR_HARD),
	EQUIP_DWARVEN_HELMET(
	    "Equip a dwarven helmet within the dwarven mines.",
	    AD_GROUP.FALADOR_HARD,
	    new AD_SKILL_REQUIREMENT(Skill.DEFENCE, 50),
	    new AD_QUEST_REQUIREMENT(Quest.GRIM_TALES, QuestState.FINISHED)),

    // ELITE
	CRAFT_252_AIR_RUNES(
	    "Craft 252 Air Runes simultaneously from Essence without the use of Extracts.",
	    AD_GROUP.FALADOR_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.RUNECRAFT, 88)),
	PURCHASE_WHITE_2H_SWORD(
	    "Purchase a White 2h Sword from Sir Vyvin.",
	    AD_GROUP.FALADOR_ELITE,
	    new AD_QUEST_REQUIREMENT(Quest.WANTED, QuestState.FINISHED)),
	DIG_MAGIC_TREE_ROOTS(
	    "Find at least 3 magic roots at once when digging up your magic tree in Falador.",
	    AD_GROUP.FALADOR_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.FARMING, 91),
	    new AD_SKILL_REQUIREMENT(Skill.WOODCUTTING, 75)),
	PERFORM_CAPE_EMOTE_FALADOR_CASTLE(
	    "Perform a skillcape or quest cape emote at the top of Falador Castle.",
	    AD_GROUP.FALADOR_ELITE),
	JUMP_TAVERLEY_STRANGE_FLOOR(
	    "Jump over the strange floor in Taverley dungeon.",
	    AD_GROUP.FALADOR_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.AGILITY, 80)),
	MIX_SARADOMIN_BREW(
	    "Mix a Saradomin brew in Falador east bank.",
	    AD_GROUP.FALADOR_ELITE,
	    new AD_SKILL_REQUIREMENT(Skill.HERBLORE, 81));

	private final String description;
	private final AD_GROUP group;
	private Boolean completionStatus;
	private final List<AD_REQUIREMENT> requirements;

	AD_FALADOR_TASK(
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
