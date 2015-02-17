package ru.pocketgames.pixeldriver.view.resources;

import org.andengine.engine.Engine;

import ru.pocketgames.pixeldriver.view.resources.background.BackgroundResources;
import ru.pocketgames.pixeldriver.view.resources.hud.GameMenuHUDResources;
import ru.pocketgames.pixeldriver.view.resources.hud.MainMenuHUDResources;
import ru.pocketgames.pixeldriver.view.resources.objects.PlayerCarRecources;
import android.content.Context;
import android.util.Log;

public class ResourceManager {
	
	private static final String LOG_CAT_TAG = "RESOURCE_MANAGER";

	private static ResourceManager instance;
	
	private Engine 		engine;
	private Context 	context;
	
	private BackgroundResources			backgroundResources;
	private MainMenuHUDResources		mainMenuHUDResources;
	private PlayerCarRecources			playerCarRecources;
	private GameMenuHUDResources		gameMenuHUDResources;
	
	private ResourceManager() {
		
	}
	
	public static ResourceManager getInstance() {
		if(instance == null)
			instance = new ResourceManager();
		
		return instance;
	}
	
	public void init(Context context, Engine engine) {
		this.engine 	= engine;
		this.context 	= context;
	}
	
	//GETTERS
	public Engine getEngine() {
		return engine;
	}
	
	public BackgroundResources getBackgroundResources() {
		return backgroundResources;
	}

	public MainMenuHUDResources getMainMenuHUDResources() {
		return mainMenuHUDResources;
	}		
	
	public PlayerCarRecources getPlayerCarRecources() {
		return playerCarRecources;
	}		

	public GameMenuHUDResources getGameMenuHUDResources() {
		return gameMenuHUDResources;
	}		

	//LOAD METHODS		
	public void loadBackgroundResource() {
		if(backgroundResources == null)
			backgroundResources = new BackgroundResources(context, engine);
		else
			Log.e(LOG_CAT_TAG, "BackgroundResources already loaded. Double calling load.");
	}	

	public void loadMainMenuHUDResources() {
		if(mainMenuHUDResources == null) 
			mainMenuHUDResources = new MainMenuHUDResources(context, engine);
		else
			Log.e(LOG_CAT_TAG, "MainMenuHUDResources already loaded. Double calling load.");
	}
	
	public void loadPlayerCarResources() {
		if(playerCarRecources == null) 
			playerCarRecources = new PlayerCarRecources(context, engine);
		else
			Log.e(LOG_CAT_TAG, "PlayerCarRecources already loaded. Double calling load.");
	}
	
	public void loadGameMenuHUDResources() {
		if(gameMenuHUDResources == null) 
			gameMenuHUDResources = new GameMenuHUDResources(context, engine);
		else
			Log.e(LOG_CAT_TAG, "GameMenuHUDResources already loaded. Double calling load.");
	}
	
	//UNLOAD METHODS
	public void unloadAllResources() {
		unloadBackgroundResource		();
		unloadMainMenuHUDResources		();
		unloadPlayerCarResources		();
		unloadGameMenuHUDResources		();
	}
	
	public void unloadBackgroundResource() {
		if(backgroundResources != null) {
			backgroundResources.destroy();
			backgroundResources = null;
		} else {
			Log.e(LOG_CAT_TAG, "BackgroundResources has not been loaded. Excess calling unload.");
		}
	}
	
	public void unloadMainMenuHUDResources() {
		if(mainMenuHUDResources != null) {
			mainMenuHUDResources.destroy();
			mainMenuHUDResources = null;
		} else {
			Log.e(LOG_CAT_TAG, "MainMenuResources has not been loaded. Excess calling unload.");
		}
	}
	
	public void unloadPlayerCarResources() {
		if(playerCarRecources != null) {
			playerCarRecources.destroy();
			playerCarRecources = null;
		} else {
			Log.e(LOG_CAT_TAG, "PlayerCarRecources has not been loaded. Excess calling unload.");
		}
	}
	
	public void unloadGameMenuHUDResources() {
		if(gameMenuHUDResources != null) {
			gameMenuHUDResources.destroy();
			gameMenuHUDResources = null;
		} else {
			Log.e(LOG_CAT_TAG, "GameMenuHUDResources has not been loaded. Excess calling unload.");
		}
	}
	
}
