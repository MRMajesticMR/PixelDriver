package ru.pocketgames.pixeldriver.view.resources.impl;

import org.andengine.engine.Engine;

import android.content.Context;

public class ResourceManager {

	private static ResourceManager instance;
			
	private PlayerCarRecources			playerCarRecources;
	
	private ResourceManager() {
		
	}
	
	public static ResourceManager getInstance() {
		if(instance == null)
			instance = new ResourceManager();
		
		return instance;
	}
	
	public void init(Context context, Engine engine) {
		playerCarRecources = new PlayerCarRecources(context, engine.getTextureManager());
	}					
	
	public void loadResources() {
		playerCarRecources.load();
	}
		
	public void unloadResources() {
		playerCarRecources.unload();
	}

	public PlayerCarRecources getPlayerCarRecources() {
		return playerCarRecources;
	}		
}
