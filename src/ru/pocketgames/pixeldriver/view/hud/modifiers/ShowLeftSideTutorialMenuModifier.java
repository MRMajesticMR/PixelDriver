package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveXModifier;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;

public class ShowLeftSideTutorialMenuModifier extends IShowSequenceEntityModifier {

	public ShowLeftSideTutorialMenuModifier() {
		super(new MoveXModifier(0.5f, -DefaultCamera.CAMERA_WIDTH / 2, 0));
	}

}