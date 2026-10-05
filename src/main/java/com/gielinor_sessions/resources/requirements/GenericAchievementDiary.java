package com.gielinor_sessions.resources.requirements;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;
import net.runelite.api.Client;
import com.gielinor_sessions.resources.achievement_diary.AD_GROUP;

@Getter
public abstract class GenericAchievementDiary
{
	@Getter
	private final Set<DiaryRequirement> requirements = new HashSet<>();
	private AD_GROUP group;

	protected void add(String _task, int _varbitID, IRequirement... _requirements)
	{
		DiaryRequirement diaryRequirement = new DiaryRequirement(_task, _varbitID, _requirements);
		this.requirements.add(diaryRequirement);
	}

	protected void setGroup(AD_GROUP _group)
	{
		this.group = _group;
	}

	public boolean isCompleted(Client client)
	{
		return group.isCompleted(client);
	}

}