
package com.gielinor_sessions;

import com.google.inject.Provides;
import javax.inject.Inject;

import lombok.extern.slf4j.Slf4j;

import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;

import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.GameTick;
import net.runelite.api.events.WidgetLoaded;

import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

import com.gielinor_sessions.player_state_domain.PlayerStateService;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AD_WIDGET_IDS;

@Slf4j
@PluginDescriptor(name = "Gielinor Sessions")
public class GielinorSessionsPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private GielinorSessionsConfig config;

	@Inject
	private PlayerStateService playerService;

	private boolean initializePlayerState;
	private boolean playerStateInitialized;

	// --------------------------------------------------
	// LIFECYCLE
	// --------------------------------------------------

	@Override
	protected void startUp() throws Exception
	{
		log.debug("Gielinor Sessions started!");
	}

	@Override
	protected void shutDown() throws Exception
	{
		initializePlayerState = false;
		playerStateInitialized = false;

		log.debug("Gielinor Sessions stopped!");
	}

	// --------------------------------------------------
	// GAME STATE
	// --------------------------------------------------

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			client.addChatMessage(
			    ChatMessageType.GAMEMESSAGE,
			    "",
			    "Gielinor Sessions says " + config.greeting(),
			    null);

			initializePlayerState = true;
			playerStateInitialized = false;
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			initializePlayerState = false;
			playerStateInitialized = false;
		}
	}

	// --------------------------------------------------
	// PLAYER INITIALIZATION
	// --------------------------------------------------

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!initializePlayerState)
		{
			return;
		}

		playerService.init();

		initializePlayerState = false;
		playerStateInitialized = true;
	}

	// --------------------------------------------------
	// ACHIEVEMENT DIARY WIDGET
	// --------------------------------------------------

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != AD_WIDGET_IDS.GROUP)
		{
			return;
		}

		clientThread.invokeLater(() -> {
			if (!playerStateInitialized
			    || client.getGameState() != GameState.LOGGED_IN)
			{
				return;
			}

			playerService.updateAchievementDiaries();
		});
	}

	// --------------------------------------------------
	// CONFIGURATION
	// --------------------------------------------------

	@Provides
	GielinorSessionsConfig provideConfig(
	    ConfigManager configManager)
	{
		return configManager.getConfig(
		    GielinorSessionsConfig.class);
	}
}
