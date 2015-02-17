package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveXModifier;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;

public class HideLeftSideTutorialMenuModifier extends IHideSequenceEntityModifier {

	public HideLeftSideTutorialMenuModifier() {
		super(new MoveXModifier(0.5f, 0, -DefaultCamera.CAMERA_WIDTH / 2));
	}

}
