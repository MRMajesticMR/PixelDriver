package ru.pocketgames.pixeldriver.view.hud;

import org.andengine.entity.scene.Scene;

import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.controllers.hud.TutorialMenuController;
import ru.pocketgames.pixeldriver.view.hud.views.TutorialView;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class TutorialMenuHUD extends IHUD {
	
	private TutorialMenuController 	tutorialMenuController;
	
	private TutorialView			tutorialView;

	
	public TutorialMenuHUD(Scene scene) {
		super(scene);
		
		ResourceManager.getInstance().loadGameMenuHUDResources();
		
		tutorialView = new TutorialView();
		tutorialView.setModifierListener(this);
		
		scene.registerTouchArea(tutorialView);
		
		attachChild(tutorialView);
	}

	@Override
	public void show() {		
		tutorialView.show();
	}

	@Override
	public void hide() {
		tutorialView.hide();		
	}

	@Override
	public void destroy() {
		ResourceManager.getInstance().unloadGameMenuHUDResources();
		
		tutorialView.detachSelf();
		tutorialView.dispose();
		
		scene.unregisterTouchArea(tutorialView);
	}

	@Override
	public void setHUDController(IHUDController hudController) {
		this.tutorialMenuController = (TutorialMenuController) hudController;
		
		tutorialView.setTutorialMenuController(tutorialMenuController);
	}	

}
