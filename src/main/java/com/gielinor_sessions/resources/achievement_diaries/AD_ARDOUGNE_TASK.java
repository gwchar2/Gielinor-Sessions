package com.gielinor_sessions.resources.achievement_diaries;

import com.gielinor_sessions.resources.achievement_diaries.requirements.AD_REQUIREMENT;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.Getter;

@Getter
public enum AD_ARDOUGNE_TASK implements AD_TASK
{
	/*
	 * Keep your existing Ardougne entries here.
	 *
	 * Example shape:
	 *
	 * SOME_TASK(
	 * "Task description",
	 * AD_GROUP.ARDOUGNE_EASY,
	 * new AD_SKILL_REQUIREMENT(Skill.AGILITY, 20),
	 * new AD_QUEST_REQUIREMENT(Quest.SOME_QUEST)),
	 */

	;

	private final String name;
	private final AD_GROUP group;
	private final List<AD_REQUIREMENT> requirements;

	AD_ARDOUGNE_TASK(
	    String name,
	    AD_GROUP group,
	    AD_REQUIREMENT... requirements)
	{
		this.name = name;
		this.group = group;

		List<AD_REQUIREMENT> copy = new ArrayList<>();

		Collections.addAll(copy, requirements);

		this.requirements = Collections.unmodifiableList(copy);
	}
}