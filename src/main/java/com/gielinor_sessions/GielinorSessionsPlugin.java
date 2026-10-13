package com.gielinor_sessions;

import com.gielinor_sessions.persistence.JsonFileRepository;
import com.gielinor_sessions.player_state_domain.PlayerStateService;
import com.gielinor_sessions.resources.achievement_diaries.widgets.AD_WIDGET_IDS;
import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
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
	@Inject
	private JsonFileRepository jsonFileRepository;

	private boolean initializePlayerState;
	private boolean playerStateInitialized;
	private boolean persistenceReady;
	private String activeAccountName;

	@Override
	protected void startUp()
	{
		initializePlayerState = false;
		playerStateInitialized = false;
		persistenceReady = false;
		log.debug("Gielinor Sessions started!");
	}

	@Override
	protected void shutDown()
	{
		saveActivePlayer();
		clearActivePlayer();
		log.debug("Gielinor Sessions stopped!");
	}

	@Subscribe
	public void onGameStateChanged(GameStateChanged event)
	{
		if (event.getGameState() == GameState.LOGGED_IN)
		{
			// Check account identity on the next tick. A world hop must not reset state.
			initializePlayerState = true;
		}
		else if (event.getGameState() == GameState.LOGIN_SCREEN)
		{
			saveActivePlayer();
			clearActivePlayer();
		}
	}

	@Subscribe
	public void onGameTick(GameTick event)
	{
		if (!initializePlayerState || client.getGameState() != GameState.LOGGED_IN
		    || client.getLocalPlayer() == null || client.getLocalPlayer().getName() == null)
		{
			return;
		}

		String accountName = client.getLocalPlayer().getName();
		if (playerStateInitialized)
		{
			if (accountName != null && accountName.equals(activeAccountName))
			{
				initializePlayerState = false;
				return;
			}
			saveActivePlayer();
			clearActivePlayer();
		}
		playerService.init();
		activeAccountName = accountName;
		persistenceReady = jsonFileRepository.load(accountName, playerService.getPlayerState());
		playerStateInitialized = true;
		initializePlayerState = false;
	}

	@Subscribe
	public void onWidgetLoaded(WidgetLoaded event)
	{
		if (event.getGroupId() != AD_WIDGET_IDS.GROUP)
		{
			return;
		}
		clientThread.invokeLater(() -> {
			if (!playerStateInitialized || client.getGameState() != GameState.LOGGED_IN)
			{
				return;
			}
			playerService.updateAchievementDiaries();
		});
	}

	private void saveActivePlayer()
	{
		if (playerStateInitialized && persistenceReady && activeAccountName != null)
		{
			jsonFileRepository.save(activeAccountName, playerService.getPlayerState());
		}
	}

	private void clearActivePlayer()
	{
		initializePlayerState = false;
		playerStateInitialized = false;
		persistenceReady = false;
		activeAccountName = null;
	}

	@Provides
	GielinorSessionsConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(GielinorSessionsConfig.class);
	}
}
