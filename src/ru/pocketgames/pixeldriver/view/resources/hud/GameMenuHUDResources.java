package ru.pocketgames.pixeldriver.view.resources.hud;

import org.andengine.engine.Engine;
import org.andengine.opengl.font.Font;
import org.andengine.opengl.font.FontFactory;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.bitmap.BitmapTextureFormat;
import org.andengine.opengl.texture.region.TextureRegion;

import ru.pocketgames.pixeldriver.view.resources.IResources;
import android.content.Context;
import android.graphics.Color;

public class GameMenuHUDResources implements IResources{
	
	private static final float SCORE_FONT_SIZE = 32f;
	
	private BitmapTextureAtlas    	tutorialMenuBackgroundTextureAtlas;
	private BitmapTextureAtlas    	fontsTextureAtlas;
	
	private TextureRegion			tutorialMenuSideBackgroundTextureRegion;		
	
	private Font					scoreFont;
	
	
	public GameMenuHUDResources(Context context, Engine engine) {
		
		final TextureManager textureMgr = engine.getTextureManager();
	      
		tutorialMenuBackgroundTextureAtlas 	= new BitmapTextureAtlas(textureMgr, 2, 2, BitmapTextureFormat.A_8, TextureOptions.REPEATING_NEAREST);
		fontsTextureAtlas 					= new BitmapTextureAtlas(textureMgr, 512, 512);

	    tutorialMenuSideBackgroundTextureRegion 		= BitmapTextureAtlasTextureRegionFactory.createFromAsset(tutorialMenuBackgroundTextureAtlas, context, "gfx/hud/game_menu/empty.png", 0, 0);
	    scoreFont 										= FontFactory.createFromAsset(engine.getFontManager(), fontsTextureAtlas, context.getAssets(), "gfx/hud/game_menu/fonts/score.ttf", SCORE_FONT_SIZE, true, Color.WHITE);

	    engine.getFontManager().loadFont(scoreFont);
	    
	    tutorialMenuBackgroundTextureAtlas.load();
		fontsTextureAtlas.load();
	}
	
	@Override
	public void destroy() {
		tutorialMenuBackgroundTextureAtlas.unload();
		fontsTextureAtlas.unload();
	}

	public TextureRegion getTutorialMenuSideBackgroundTextureRegion() {
		return tutorialMenuSideBackgroundTextureRegion;
	}
	
	public Font getScoreFont() {
		return scoreFont;
	}
}
