package ru.pocketgames.pixeldriver.view.resources.impl;

import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;

import ru.pocketgames.pixeldriver.view.resources.IResources;
import android.content.Context;

public class PlayerCarRecources implements IResources {
	
	private static final int TEXTURE_ATLAS_WIDTH 	= 256;
	private static final int TEXTURE_ATLAS_HEIGHT 	= 256;	
	
	private BitmapTextureAtlas    playerCarsTextureAtlas;	   
	private TextureRegion         redPlayerCarTextureRegion;
	
	public PlayerCarRecources(Context context, TextureManager textureManager) {
		playerCarsTextureAtlas 			= new BitmapTextureAtlas(textureManager, TEXTURE_ATLAS_WIDTH, TEXTURE_ATLAS_HEIGHT);
		redPlayerCarTextureRegion 		= BitmapTextureAtlasTextureRegionFactory.createFromAsset(playerCarsTextureAtlas, context, "gfx/player_cars/player_car_red.png", 0, 0);
	}

	@Override
	public void load() {		
		playerCarsTextureAtlas.load();		
	}
	
	@Override
	public void unload() {
		playerCarsTextureAtlas.unload();		
	}

	public TextureRegion getPlayerCarTextureRegion() {
		return redPlayerCarTextureRegion;
	}
	
}
