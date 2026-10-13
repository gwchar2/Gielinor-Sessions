package com.gielinor_sessions.resources.achievement_diaries.widgets;

import com.gielinor_sessions.resources.achievement_diaries.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.inject.Singleton;
import net.runelite.api.widgets.Widget;
import net.runelite.client.util.Text;

/**
 * Parses diary journal widgets; has no persistence or PlayerState dependency.
 */
@Singleton
public final class AchievementDiaryParser
{
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
	}).flatMap(Arrays::stream).collect(Collectors.toList());

	private static final Map<AD_GROUP, Map<String, AD_TASK>> TASK_LOOKUP = buildTaskLookup();

	private static Map<AD_GROUP, Map<String, AD_TASK>> buildTaskLookup()
	{
		Map<AD_GROUP, Map<String, AD_TASK>> lookup = new HashMap<>();
		for (AD_TASK task : ALL_ACHIEVEMENT_DIARIES)
		{
			lookup.computeIfAbsent(task.getGroup(), group -> new LinkedHashMap<>())
			    .putIfAbsent(normalize(task.getDescription()), task);
		}
		return lookup;
	}

	public Map<AD_TASK, Boolean> parse(Widget title, Widget textLayer)
	{
		Map<AD_TASK, Boolean> observed = new HashMap<>();
		if (title == null || textLayer == null ||
		    !normalize(title.getText()).contains("achievement diary"))
		{
			return observed;
		}

		List<DiaryLine> lines = new ArrayList<>();
		collectWidgetLines(textLayer, lines);
		if (lines.isEmpty())
		{
			return observed;
		}

		String region = null;
		AD_GROUP currentGroup = null;
		StringBuilder pendingDescription = new StringBuilder();
		boolean pendingCompleted = false;

		for (DiaryLine line : lines)
		{
			String text = line.text;
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

			AD_GROUP detectedGroup = resolveDiaryGroup(region, text);
			if (detectedGroup != null)
			{
				currentGroup = detectedGroup;
				pendingDescription.setLength(0);
				pendingCompleted = false;
				continue;
			}

			if (currentGroup == null || text.startsWith("("))
			{
				// Requirement-only lines must never change completion status.
				continue;
			}

			AD_TASK directMatch = findTask(currentGroup, text);
			if (directMatch != null)
			{
				observed.put(directMatch, line.completed);
				pendingDescription.setLength(0);
				pendingCompleted = false;
				continue;
			}

			// A task description may span multiple widget lines.
			// Its completion comes from its FIRST line, not an OR of all lines.
			if (pendingDescription.length() == 0)
			{
				pendingCompleted = line.completed;
			}
			else
			{
				pendingDescription.append(' ');
			}
			pendingDescription.append(text);

			String combined = pendingDescription.toString();
			AD_TASK wrappedMatch = findTask(currentGroup, combined);
			if (wrappedMatch != null)
			{
				observed.put(wrappedMatch, pendingCompleted);
				pendingDescription.setLength(0);
				pendingCompleted = false;
				continue;
			}

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

		return observed;
	}

	// WIDGET TEXT EXTRACTION
	private void collectWidgetLines(Widget widget, List<DiaryLine> lines)
	{
		if (widget == null || widget.isHidden())
		{
			return;
		}

		String raw = widget.getText();
		if (raw != null && !raw.isEmpty())
		{
			boolean struck = false;
			for (String part : raw.split("(?i)<br\\s*/?>"))
			{
				// Inspect the formatting at the FIRST visible character.
				// A <str> inside the requirements does not complete the task.
				Boolean descriptionStruck = null;
				int position = 0;
				while (position < part.length())
				{
					if (part.charAt(position) == '<')
					{
						int end = part.indexOf('>', position);
						if (end >= 0)
						{
							String tag = part.substring(position + 1, end)
							    .trim().toLowerCase(Locale.ROOT);
							if ("str".equals(tag))
							{
								struck = true;
							}
							else if ("/str".equals(tag))
							{
								struck = false;
							}
							position = end + 1;
							continue;
						}
					}

					if (descriptionStruck == null
					    && !Character.isWhitespace(part.charAt(position)))
					{
						descriptionStruck = struck;
					}
					position++;
				}

				String text = normalize(part);
				if (!text.isEmpty())
				{
					lines.add(new DiaryLine(text, Boolean.TRUE.equals(descriptionStruck)));
				}
			}
		}

		collectChildren(widget.getStaticChildren(), lines);
		collectChildren(widget.getDynamicChildren(), lines);
		collectChildren(widget.getNestedChildren(), lines);
	}

	private void collectChildren(Widget[] children, List<DiaryLine> lines)
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

	// TASK MATCHING
	private AD_TASK findTask(AD_GROUP group, String description)
	{
		Map<String, AD_TASK> tasks = TASK_LOOKUP.get(group);
		return tasks == null ? null : tasks.get(normalize(description));
	}

	private boolean isTaskPrefix(AD_GROUP group, String description)
	{
		Map<String, AD_TASK> tasks = TASK_LOOKUP.get(group);
		if (tasks == null)
		{
			return false;
		}

		String prefix = normalize(description);
		for (String candidate : tasks.keySet())
		{
			if (candidate.startsWith(prefix))
			{
				return true;
			}
		}
		return false;
	}

	// REGION RESOLUTION
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

	// TIER RESOLUTION
	private static AD_GROUP resolveDiaryGroup(String region, String header)
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

	// NORMALIZATION
	private static String normalize(String text)
	{
		if (text == null)
		{
			return "";
		}
		return Text.standardize(text)
		    .replaceAll("\\s*\\([^()]*\\)\\s*$", "")
		    .replaceAll("\\s+", " ")
		    .trim();
	}

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
