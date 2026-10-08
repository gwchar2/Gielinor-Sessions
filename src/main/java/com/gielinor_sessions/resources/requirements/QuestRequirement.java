package com.gielinor_sessions.resources.requirements;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import net.runelite.api.Client;
import net.runelite.api.Quest;
import net.runelite.api.QuestState;

@RequiredArgsConstructor
@Getter
public class QuestRequirement implements IRequirement
{
	private final Quest quest;
	private final QuestState requiredState;

	private final int IN_PROGRESS = 1;
	private final int COMPLETED = 2;

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		QuestState state = quest.getState(client);
		if (requiredState == QuestState.IN_PROGRESS)
		{
			return state == QuestState.IN_PROGRESS || state == QuestState.FINISHED;
		}
		return state == QuestState.FINISHED;
	}

	@Override
	public String toString(Client client)
	{
		if (requiredState == QuestState.IN_PROGRESS)
		{
			return "Start " + quest.getName();
		}
		else
		{
			return "Finish" + quest.getName();
		}
	}
}
