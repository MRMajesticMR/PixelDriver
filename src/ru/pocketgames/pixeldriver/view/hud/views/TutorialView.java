package ru.pocketgames.pixeldriver.view.hud.views;

import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;
import org.andengine.util.modifier.IModifier;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.controllers.hud.TutorialMenuController;
import ru.pocketgames.pixeldriver.debug.logger.DebugLogger;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideLeftSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideRightSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowLeftSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowRightSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class TutorialView extends Sprite {

	private static final String LOG_TAG = TutorialView.class.getSimpleName();
	
	//VIEWS
	private TutorialControlNote[] 		tutorialControlNotes = new TutorialControlNote[2];
	
	//MODIFIERS
	private IShowSequenceEntityModifier showLeftSideModifier;
	private IShowSequenceEntityModifier showRightSideModifier;	
	
	private IHideSequenceEntityModifier hideLeftSideModifier;
	private IHideSequenceEntityModifier hideRightSideModifier;
	
	//VARIABLES
	private TutorialMenuController	tutorialMenuController;
	
	
	public TutorialView() {
		super(0, 0, DefaultCamera.CAMERA_WIDTH, 
				DefaultCamera.CAMERA_HEIGHT, 
				ResourceManager.getInstance().getGameMenuHUDResources().getTutorialMenuSideBackgroundTextureRegion(), 
				ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());	
		
		setAlpha(0.0f);
		
		tutorialControlNotes[0] = new LeftTutorialControlNote	();
		tutorialControlNotes[1] = new RightTutorialControlNote	();
		
		attachChild(tutorialControlNotes[0]);
		attachChild(tutorialControlNotes[1]);
		
		showLeftSideModifier 	= new ShowLeftSideTutorialMenuModifier		();
		showRightSideModifier 	= new ShowRightSideTutorialMenuModifier		();
		
		hideLeftSideModifier 	= new HideLeftSideTutorialMenuModifier		();
		hideRightSideModifier	= new HideRightSideTutorialMenuModifier		();
	}
	
	public void setModifierListener(IModifier.IModifierListener<IEntity> listener) {
		hideLeftSideModifier.addModifierListener(listener);
	}
	
	public void setTutorialMenuController(TutorialMenuController tutorialMenuController) {
		this.tutorialMenuController = tutorialMenuController;
	}

	public void show() {
		showLeftSideModifier.reset						();
		showRightSideModifier.reset						();
		
		tutorialControlNotes[0].registerEntityModifier	(showLeftSideModifier);
		tutorialControlNotes[1].registerEntityModifier	(showRightSideModifier);
	}
	
	public void hide() {
		hideLeftSideModifier.reset						();
		hideRightSideModifier.reset						();				

		tutorialControlNotes[0].registerEntityModifier	(hideLeftSideModifier);
		tutorialControlNotes[1].registerEntityModifier	(hideRightSideModifier);
	}
	
	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
		switch (pSceneTouchEvent.getAction()) {
		case TouchEvent.ACTION_UP:					
		case TouchEvent.ACTION_OUTSIDE:
			DebugLogger.logDebugI(LOG_TAG, "Tutorial screen clicked");
			
			tutorialMenuController.onTutorialScreenClicked();
			break;
		}
		return true;
	}
	
}
