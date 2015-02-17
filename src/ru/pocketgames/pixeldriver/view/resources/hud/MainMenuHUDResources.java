package ru.pocketgames.pixeldriver.view.resources.hud;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.ITiledTextureRegion;
import org.andengine.opengl.texture.region.TextureRegion;

import ru.pocketgames.pixeldriver.view.resources.IResources;
import android.content.Context;

public class MainMenuHUDResources implements IResources{
	
	private BitmapTextureAtlas    mainMenuTextureAtlas;
	
	private TextureRegion			gameTitleTextureRegion;
	private ITiledTextureRegion   	startGameBtnTextureRegion;
	
	public MainMenuHUDResources(Context context, Engine engine) {
		
		final TextureManager textureMgr = engine.getTextureManager();
	      
	    mainMenuTextureAtlas = new BitmapTextureAtlas(textureMgr, 512, 512);

	    gameTitleTextureRegion 		= BitmapTextureAtlasTextureRegionFactory.createFromAsset(mainMenuTextureAtlas, context, "gfx/hud/main_menu/game_logo.png", 0, 49);
	    startGameBtnTextureRegion 	= BitmapTextureAtlasTextureRegionFactory.createTiledFromAsset(mainMenuTextureAtlas, context, "gfx/hud/main_menu/start_game_btn.png", 0, 0, 2, 1);
	      
	    mainMenuTextureAtlas.load();		
	}
	
	@Override
	public void destroy() {
		mainMenuTextureAtlas.unload();
	}	
	
	public TextureRegion getGameTitleTextureRegion() {
		return gameTitleTextureRegion;
	}

	public ITiledTextureRegion getStartGameBtnTextureRegion() {
		return startGameBtnTextureRegion;
	}

}
