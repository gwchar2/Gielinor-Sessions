package com.gielinor_sessions;

import com.gielinor_sessions.GielinorSessionsPlugin;
import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class GielinorSessionsPluginTest
{
	@SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(GielinorSessionsPlugin.class);
		RuneLite.main(args);
	}
}