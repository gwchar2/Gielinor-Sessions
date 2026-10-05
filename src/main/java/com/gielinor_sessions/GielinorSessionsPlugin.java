package com.gielinor_sessions;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;
import com.gielinor_sessions.player_state_domain.PlayerStateService;

@Slf4j
@PluginDescriptor(name = "Gielinor Sessions")
public class GielinorSessionsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private GielinorSessionsConfig config;

	private PlayerStateService playerService = new PlayerStateService();

	private boolean initializePlayerState;

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Gielinor Sessions started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		log.debug("Gielinor Sessions stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged gameStateChanged)
	{
		if (gameStateChanged.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(ChatMessageType.GAMEMESSAGE, "", "Gielinor Sessions says " + config.greeting(), null);
			initializePlayerState = true;
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!initializePlayerState)
		{
			return;
		}

		playerService.Init(client);
		initializePlayerState = false;
	}

	@Provides
	GielinorSessionsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GielinorSessionsConfig.class);
	}
}
