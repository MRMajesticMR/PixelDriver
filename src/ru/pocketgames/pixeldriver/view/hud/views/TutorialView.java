package ru.pocketgames.pixeldriver.view.hud.views;

import org.andengine.entity.IEntity;
import org.andengine.entity.sprite.Sprite;
import org.andengine.util.modifier.IModifier;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideLeftSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideRightSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowLeftSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowRightSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class TutorialView extends Sprite implements IModifier.IModifierListener<IEntity> {

	
	//VIEWS
	private TutorialControlNote[] 		tutorialControlNotes = new TutorialControlNote[2];
	
	//MODIFIERS
	private IShowSequenceEntityModifier showLeftSideModifier;
	private IShowSequenceEntityModifier showRightSideModifier;	
	
	private IHideSequenceEntityModifier hideLeftSideModifier;
	private IHideSequenceEntityModifier hideRightSideModifier;
	
	//VARIABLES
	private boolean isVisible;
	
	
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
		
		hideLeftSideModifier.addModifierListener(this);
	}
	
	public void show() {
		isVisible = true;
		
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
	
	public boolean isTutorialVisible() {
		return isVisible;
	}

	@Override
	public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {		
	}

	@Override
	public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {
		isVisible = false;
	}
	
}
