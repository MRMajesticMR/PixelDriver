package ru.pocketgames.pixeldriver.view.resources.background;

import org.andengine.engine.Engine;
import org.andengine.opengl.texture.TextureManager;
import org.andengine.opengl.texture.TextureOptions;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlas;
import org.andengine.opengl.texture.atlas.bitmap.BitmapTextureAtlasTextureRegionFactory;
import org.andengine.opengl.texture.region.TextureRegion;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.resources.IResources;
import android.content.Context;

public class BackgroundResources implements IResources {
	
	private static final int TEXTURE_ATLAS_WIDTH 	= 512;
	private static final int TEXTURE_ATLAS_HEIGHT 	= 256;	
	
	private BitmapTextureAtlas    backgroundTextureAtlas;
	   
	private TextureRegion         backgroundTextureRegion;
	
	public BackgroundResources(Context context, Engine engine) {
		final TextureManager textureMgr 	= engine.getTextureManager();
	      
	    backgroundTextureAtlas        		= new BitmapTextureAtlas(textureMgr, TEXTURE_ATLAS_WIDTH, TEXTURE_ATLAS_HEIGHT, TextureOptions.REPEATING_BILINEAR);
	      
	    backgroundTextureRegion       		= BitmapTextureAtlasTextureRegionFactory.createFromAsset(backgroundTextureAtlas, context, "gfx/background/road_bed.png", 0, 0);
	      
	    backgroundTextureRegion.setTextureWidth(DefaultCamera.CAMERA_WIDTH);
	    backgroundTextureRegion.setTextureHeight(DefaultCamera.CAMERA_HEIGHT * 2.2f);
	      
	    backgroundTextureAtlas.load();
	}

	@Override
	public void destroy() {
		backgroundTextureAtlas.unload();		
	}

	public TextureRegion getBackgroundTextureRegion() {
		return backgroundTextureRegion;
	}	
	
}
