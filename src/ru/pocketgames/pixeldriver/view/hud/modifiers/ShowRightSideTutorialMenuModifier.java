package ru.pocketgames.pixeldriver.view.hud.modifiers;

import org.andengine.entity.modifier.MoveXModifier;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;

public class ShowRightSideTutorialMenuModifier extends IShowSequenceEntityModifier {

	public ShowRightSideTutorialMenuModifier() {
		super(new MoveXModifier(0.5f, DefaultCamera.CAMERA_WIDTH, DefaultCamera.CAMERA_WIDTH / 2));
	}

}
