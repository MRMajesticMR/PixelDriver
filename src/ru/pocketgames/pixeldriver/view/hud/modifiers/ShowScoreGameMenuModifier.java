package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.text.Text;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;

public class ShowScoreGameMenuModifier extends IShowSequenceEntityModifier {

	private static final float JUMP_DELTA = 30f;

	   public ShowScoreGameMenuModifier(Text modifiedSprite) {      
	      super(new MoveYModifier(0.8f,  -DefaultCamera.CAMERA_HEIGHT,    JUMP_DELTA),
	            new MoveYModifier(0.1f, JUMP_DELTA, modifiedSprite.getY()));
	   }
	
}
