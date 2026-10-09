
package com.gielinor_sessions.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;

import com.gielinor_sessions.player_state_domain.PlayerState;
import com.gielinor_sessions.resources.achievement_diaries.*;
import com.gielinor_sessions.resources.achievement_diaries.requirements.AD_REQUIREMENT;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AD_WIDGET_IDS;
import com.gielinor_sessions.resources.combat_achievements.CB_TASK;

import net.runelite.api.Client;
import net.runelite.api.widgets.Widget;

public final class DiaryService
{
	private final Client client;

	private static final List<AD_TASK> ALL_ACHIEVEMENT_DIARIES = Arrays.stream(new AD_TASK[][] {
	    AD_ARDOUGNE_TASK.values(),
	    AD_DESERT_TASK.values(),
	    AD_FALADOR_TASK.values(),
	    AD_FREMENNIK_TASK.values(),
	    AD_KANDARIN_TASK.values(),
	    AD_KARAMJA_TASK.values(),
	    AD_KOUREND_TASK.values(),
	    AD_LUMBRIDGE_TASK.values(),
	    AD_MORYTANIA_TASK.values(),
	    AD_VARROCK_TASK.values(),
	    AD_WESTERN_TASK.values(),
	    AD_WILDERNESS_TASK.values()
	})
	    .flatMap(Arrays::stream)
	    .collect(Collectors.toList());

	private static final List<CB_TASK> ALL_COMBAT_ACHIEVEMENTS = Arrays.asList(CB_TASK.values());

	@Inject
	public DiaryService(Client client)
	{
		this.client = client;
	}

	// --------------------------------------------------
	// INITIALIZATION
	// --------------------------------------------------

	public void populateIncompleteTasks(PlayerState playerState)
	{
		populateIncompleteAchievementDiaries(playerState);
		populateIncompleteCombatAchievements(playerState);
	}

	public void populateIncompleteAchievementDiaries(PlayerState playerState)
	{
		playerState.getIncompleteAchievementDiaries().clear();

		for (AD_TASK task : ALL_ACHIEVEMENT_DIARIES)
		{
			if (!isTaskCompleted(task, playerState))
			{
				playerState.getIncompleteAchievementDiaries().add(task);
			}
		}
	}

	public void populateIncompleteCombatAchievements(PlayerState playerState)
	{
		playerState.getIncompleteCombatAchievements().clear();

		for (CB_TASK task : ALL_COMBAT_ACHIEVEMENTS)
		{
			if (!isTaskCompleted(task))
			{
				playerState.getIncompleteCombatAchievements().add(task);
			}
		}
	}

	// --------------------------------------------------
	// COMPLETION STATUS
	// --------------------------------------------------

	public boolean isTaskCompleted(
	    AD_TASK task,
	    PlayerState playerState)
	{
		if (isGroupCompleted(task.getGroup()))
		{
			return true;
		}

		return Boolean.TRUE.equals(
		    playerState.getAchievementDiaryStatus().get(task));
	}

	public boolean isTaskCompleted(CB_TASK task)
	{
		return client.getVarbitValue(task.getCompletionVarbit()) == 1;
	}

	public boolean isGroupCompleted(AD_GROUP group)
	{
		return client.getVarbitValue(group.getCompletionVarbit()) == 1;
	}

	// --------------------------------------------------
	// ELIGIBILITY
	// --------------------------------------------------

	public boolean isEligible(
	    AD_TASK task,
	    PlayerState playerState)
	{
		for (AD_REQUIREMENT requirement : task.getRequirements())
		{
			if (!requirement.isSatisfied(playerState))
			{
				return false;
			}
		}

		return true;
	}

	// --------------------------------------------------
	// REMOVAL
	// --------------------------------------------------

	public void removeTask(
	    PlayerState playerState,
	    AD_TASK task)
	{
		playerState.getIncompleteAchievementDiaries().remove(task);
	}

	public void removeTask(
	    PlayerState playerState,
	    CB_TASK task)
	{
		playerState.getIncompleteCombatAchievements().remove(task);
	}

	// --------------------------------------------------
	// ACHIEVEMENT DIARY WIDGET READING
	// --------------------------------------------------

	public void updateAchievementDiaries(PlayerState playerState)
	{
		Widget title = client.getWidget(AD_WIDGET_IDS.TITLE);
		Widget textLayer = client.getWidget(AD_WIDGET_IDS.TEXT);

		if (title == null || textLayer == null)
		{
			return;
		}

		String titleText = normalize(title.getText());

		if (!titleText.contains("achievement diary"))
		{
			return;
		}

		List<DiaryLine> lines = new ArrayList<>();
		collectWidgetLines(textLayer, lines);

		if (lines.isEmpty())
		{
			return;
		}

		String region = null;
		AD_GROUP currentGroup = null;

		Map<AD_TASK, Boolean> observed = new HashMap<>();

		StringBuilder pendingDescription = new StringBuilder();
		boolean pendingCompleted = false;

		for (DiaryLine line : lines)
		{
			String text = line.text;

			// Identify the diary region.
			String detectedRegion = resolveDiaryRegion(text);

			if (detectedRegion != null)
			{
				region = detectedRegion;
				currentGroup = null;
				pendingDescription.setLength(0);
				pendingCompleted = false;
				continue;
			}

			if (region == null)
			{
				continue;
			}

			// Identify the diary tier.
			AD_GROUP detectedGroup = resolveDiaryGroup(region, text);

			if (detectedGroup != null)
			{
				currentGroup = detectedGroup;
				pendingDescription.setLength(0);
				pendingCompleted = false;
				continue;
			}

			if (currentGroup == null)
			{
				continue;
			}

			// Ignore requirement notes.
			if (text.startsWith("("))
			{
				continue;
			}

			// First attempt: match a complete description.
			AD_TASK directMatch = findTask(currentGroup, text);

			if (directMatch != null)
			{
				observed.put(directMatch, line.completed);

				pendingDescription.setLength(0);
				pendingCompleted = false;
				continue;
			}

			// Second attempt: combine wrapped descriptions.
			if (pendingDescription.length() > 0)
			{
				pendingDescription.append(' ');
			}

			pendingDescription.append(text);
			pendingCompleted |= line.completed;

			String combined = pendingDescription.toString();

			AD_TASK wrappedMatch = findTask(currentGroup, combined);

			if (wrappedMatch != null)
			{
				observed.put(wrappedMatch, pendingCompleted);

				pendingDescription.setLength(0);
				pendingCompleted = false;
				continue;
			}

			// Discard text that cannot start a known task.
			if (!isTaskPrefix(currentGroup, combined))
			{
				pendingDescription.setLength(0);
				pendingCompleted = false;

				if (isTaskPrefix(currentGroup, text))
				{
					pendingDescription.append(text);
					pendingCompleted = line.completed;
				}
			}
		}

		// Update only achievements explicitly observed.
		for (Map.Entry<AD_TASK, Boolean> entry : observed.entrySet())
		{
			AD_TASK task = entry.getKey();
			Boolean completed = entry.getValue();

			playerState.getAchievementDiaryStatus().put(
			    task,
			    completed);

			if (isTaskCompleted(task, playerState))
			{
				playerState.getIncompleteAchievementDiaries().remove(task);
			}
			else
			{
				playerState.getIncompleteAchievementDiaries().add(task);
			}
		}
	}

	// --------------------------------------------------
	// WIDGET TEXT EXTRACTION
	// --------------------------------------------------

	private void collectWidgetLines(
	    Widget widget,
	    List<DiaryLine> lines)
	{
		if (widget == null || widget.isHidden())
		{
			return;
		}

		String raw = widget.getText();

		if (raw != null && !raw.isEmpty())
		{
			boolean completed = false;

			for (String part : raw.split("(?i)<br\\s*/?>"))
			{
				String lower = part.toLowerCase(Locale.ROOT);

				if (lower.contains("<str>"))
				{
					completed = true;
				}

				String text = normalize(part);

				if (!text.isEmpty())
				{
					lines.add(new DiaryLine(text, completed));
				}

				if (lower.contains("</str>"))
				{
					completed = false;
				}
			}
		}

		Widget[] staticChildren = widget.getStaticChildren();
		Widget[] dynamicChildren = widget.getDynamicChildren();
		Widget[] nestedChildren = widget.getNestedChildren();

		collectChildren(staticChildren, lines);
		collectChildren(dynamicChildren, lines);
		collectChildren(nestedChildren, lines);
	}

	private void collectChildren(
	    Widget[] children,
	    List<DiaryLine> lines)
	{
		if (children == null)
		{
			return;
		}

		for (Widget child : children)
		{
			collectWidgetLines(child, lines);
		}
	}

	// --------------------------------------------------
	// TASK MATCHING
	// --------------------------------------------------

	private AD_TASK findTask(
	    AD_GROUP group,
	    String description)
	{
		String normalized = normalize(description);

		for (AD_TASK task : ALL_ACHIEVEMENT_DIARIES)
		{
			if (task.getGroup() == group
			    && normalize(task.getDescription()).equals(normalized))
			{
				return task;
			}
		}

		return null;
	}

	private boolean isTaskPrefix(
	    AD_GROUP group,
	    String description)
	{
		String normalized = normalize(description);

		for (AD_TASK task : ALL_ACHIEVEMENT_DIARIES)
		{
			if (task.getGroup() == group
			    && normalize(task.getDescription()).startsWith(normalized))
			{
				return true;
			}
		}

		return false;
	}

	// --------------------------------------------------
	// REGION RESOLUTION
	// --------------------------------------------------

	private static String resolveDiaryRegion(String title)
	{
		switch (title)
		{
			case "ardougne area tasks":
				return "ARDOUGNE";

			case "desert tasks":
				return "DESERT";

			case "falador area tasks":
				return "FALADOR";

			case "fremennik tasks":
				return "FREMENNIK";

			case "kandarin tasks":
				return "KANDARIN";

			case "karamja area tasks":
				return "KARAMJA";

			case "kourend & kebos tasks":
				return "KOUREND";

			case "lumbridge & draynor tasks":
				return "LUMBRIDGE";

			case "morytania tasks":
				return "MORYTANIA";

			case "varrock tasks":
				return "VARROCK";

			case "western area tasks":
				return "WESTERN";

			case "wilderness area tasks":
				return "WILDERNESS";

			default:
				return null;
		}
	}

	// --------------------------------------------------
	// TIER RESOLUTION
	// --------------------------------------------------

	private static AD_GROUP resolveDiaryGroup(
	    String region,
	    String header)
	{
		String tier;

		if (header.startsWith("easy"))
		{
			tier = "EASY";
		}
		else if (header.startsWith("medium"))
		{
			tier = "MEDIUM";
		}
		else if (header.startsWith("hard"))
		{
			tier = "HARD";
		}
		else if (header.startsWith("elite"))
		{
			tier = "ELITE";
		}
		else
		{
			return null;
		}

		try
		{
			return AD_GROUP.valueOf(region + "_" + tier);
		}
		catch (IllegalArgumentException ex)
		{
			return null;
		}
	}

	// --------------------------------------------------
	// NORMALIZATION
	// --------------------------------------------------

	private static String normalize(String text)
	{
		if (text == null)
		{
			return "";
		}

		return text
		    .replaceAll("<[^>]*>", "")
		    .replace('\u00A0', ' ')
		    .replaceAll("\\s+", " ")
		    .trim()
		    .toLowerCase(Locale.ROOT);
	}

	// --------------------------------------------------
	// INTERNAL DATA
	// --------------------------------------------------

	private static final class DiaryLine
	{
		private final String text;
		private final boolean completed;

		private DiaryLine(String text, boolean completed)
		{
			this.text = text;
			this.completed = completed;
		}
	}
}
