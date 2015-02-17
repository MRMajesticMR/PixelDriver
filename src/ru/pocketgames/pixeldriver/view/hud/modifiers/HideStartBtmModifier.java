package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;

public class HideStartBtmModifier extends IHideSequenceEntityModifier {
	   
	   private static final float JUMP_DELTA = 70f;

	   public HideStartBtmModifier(Sprite modifiedSprite) {
	      super(new MoveYModifier(0.15f,   modifiedSprite.getY(),               modifiedSprite.getY() - JUMP_DELTA),
	            new MoveYModifier(0.8f,    modifiedSprite.getY() - JUMP_DELTA,  DefaultCamera.CAMERA_HEIGHT * 2));
	   }
	   
	}
