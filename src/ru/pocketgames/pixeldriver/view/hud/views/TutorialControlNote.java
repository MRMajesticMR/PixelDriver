package ru.pocketgames.pixeldriver.view.hud.views;

import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public abstract class TutorialControlNote extends Sprite {

	public enum Side{LEFT, RIGHT}
	
	public TutorialControlNote(Side side) {
		super(0, 0, DefaultCamera.CAMERA_WIDTH / 2, 
				DefaultCamera.CAMERA_HEIGHT, 
				ResourceManager.getInstance().getGameMenuHUDResources().getTutorialMenuSideBackgroundTextureRegion(), 
				ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
		
		setVisible(false);
		setAlpha(0.7f);
		
		if(side == Side.LEFT) {
			setX(0);
		} else {
			setX(DefaultCamera.CAMERA_WIDTH / 2);
		}
	}

}
