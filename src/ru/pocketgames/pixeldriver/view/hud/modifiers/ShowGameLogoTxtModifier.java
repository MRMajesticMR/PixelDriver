package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;

public class ShowGameLogoTxtModifier extends IShowSequenceEntityModifier {

	private static final float JUMP_DELTA = 70f;

	   public ShowGameLogoTxtModifier(Sprite modifiedSprite) {      
		   
	      super(new MoveYModifier(0.5f,   -DefaultCamera.CAMERA_HEIGHT,    -DefaultCamera.CAMERA_HEIGHT),
	    		new MoveYModifier(0.8f,   -DefaultCamera.CAMERA_HEIGHT,    modifiedSprite.getY() + JUMP_DELTA),
	            new MoveYModifier(0.15f, modifiedSprite.getY() + JUMP_DELTA, modifiedSprite.getY()));
	   }
	
}
