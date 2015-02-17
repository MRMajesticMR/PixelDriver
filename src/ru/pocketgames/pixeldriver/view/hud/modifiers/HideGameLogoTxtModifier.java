package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveYModifier;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;

public class HideGameLogoTxtModifier extends IHideSequenceEntityModifier {

	private static final float JUMP_DELTA = 70f;
	
	public HideGameLogoTxtModifier(Sprite modifiedSprite) {
		super(new MoveYModifier(0.15f, modifiedSprite.getY(), modifiedSprite.getY() + JUMP_DELTA), 
			  new MoveYModifier(0.8f, modifiedSprite.getY() + JUMP_DELTA, - modifiedSprite.getHeight()));
	}
		
}
