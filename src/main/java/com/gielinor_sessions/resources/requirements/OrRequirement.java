package com.gielinor_sessions.resources.requirements;

import java.util.List;
import lombok.Getter;
import net.runelite.api.Client;

@Getter
public class OrRequirement implements IRequirement
{
	@Getter
	private final List<IRequirement> requirements;

	public OrRequirement(IRequirement... _reqs)
	{
		this.requirements = List.of(_reqs);
	}

	@Override
	public boolean satisfiesRequirement(Client client)
	{
		// Can be any requirement.
		for (IRequirement requirement : requirements)
		{
			if (requirement.satisfiesRequirement(client))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		return true;
	}

	@Override
	public boolean isCompleted(Client client)
	{
		// Can be any requirement.
		for (IRequirement requirement : requirements)
		{
			if (requirement.isCompleted(client))
			{
				return true;
			}
			else
			{
				return false;
			}
		}

		return true;
	}

	@Override
	public String toString(Client client)
	{
		StringBuilder output = new StringBuilder();

		for (IRequirement requirement : requirements)
		{
			output.append(requirement.toString() + "\n");
		}

		return output.toString();
	}

}
