package com.gielinor_sessions;

import net.runelite.client.config.Config;
import net.runelite.client.config.ConfigGroup;
import net.runelite.client.config.ConfigItem;

@ConfigGroup("gielinor_sessions")
public interface GielinorSessionsConfig extends Config
{
	@ConfigItem(keyName = "greeting", name = "Welcome Greeting", description = "The message to show to the user when they login")
	default String greeting()
	{
		return "Hello, Gielinor games awates you!";
	}
}
