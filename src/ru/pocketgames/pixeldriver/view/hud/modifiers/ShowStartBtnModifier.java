package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;

public class ShowStartBtnModifier extends IShowSequenceEntityModifier {

	private static final float JUMP_DELTA = 70f;

	   public ShowStartBtnModifier(Sprite modifiedSprite) {      
	      super(new MoveYModifier(1.45f,  DefaultCamera.CAMERA_HEIGHT * 2,  DefaultCamera.CAMERA_HEIGHT * 2),
	    		new MoveYModifier(0.8f,  DefaultCamera.CAMERA_HEIGHT * 2,    modifiedSprite.getY() - JUMP_DELTA),
	            new MoveYModifier(0.15f, modifiedSprite.getY() - JUMP_DELTA, modifiedSprite.getY()));
	   }
	
}
