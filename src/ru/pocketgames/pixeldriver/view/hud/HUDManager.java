package ru.pocketgames.pixeldriver.view.hud;

import org.andengine.entity.scene.Scene;

import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.debug.logger.DebugLogger;
import ru.pocketgames.pixeldriver.view.hud.IHUD.OnHUDHideListener;

public class HUDManager implements OnHUDHideListener {
	
	private static final String LOG_TAG = HUDManager.class.getSimpleName();
	
	public enum HudType {MAIN_MENU, TUTORIAL_MENU, GAME_MENU};
	
	private Scene 	scene;
	private IHUD 	currentHUD;
	
	private HudType			selectedHudType;
	private IHUDController	controllerForSelectedHUD;
	
	public HUDManager(Scene scene) {
		this.scene = scene;
	}
	
	public void changeHUD(HudType hudType, IHUDController hudController) {
		this.selectedHudType 			= hudType;
		this.controllerForSelectedHUD 	= hudController;
		
		if(currentHUD != null)
			currentHUD.hide();						
		else 
			showSelectedHUD();				
	}

	@Override
	public void onHUDHide() {
		DebugLogger.logDebugI(LOG_TAG, "HUD hided. Destroy it.");
		
		scene.detachChild(currentHUD);
		currentHUD.destroy();
		currentHUD.dispose();
		
		showSelectedHUD();
	}
	
	private void showSelectedHUD() {
		switch(selectedHudType) {
		case MAIN_MENU:
			currentHUD = new MainMenuHUD		(scene);
			break;
		case TUTORIAL_MENU:
			currentHUD = new TutorialMenuHUD	(scene);
			break;
		case GAME_MENU:
			currentHUD = new GameMenuHUD		(scene);
			break;		
		}
				
		scene.attachChild(currentHUD);
		currentHUD.setOnHUDHideListener(this);
		currentHUD.setHUDController(controllerForSelectedHUD);
		currentHUD.show();
	}
	
	public HudType getSelectedHudType() {
		return selectedHudType;
	}

}
