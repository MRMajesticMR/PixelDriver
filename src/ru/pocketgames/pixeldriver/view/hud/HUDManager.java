package ru.pocketgames.pixeldriver.view.hud;

import org.andengine.entity.scene.Scene;

import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.view.hud.IHUD.OnHUDHideListener;

public class HUDManager implements OnHUDHideListener {
	
	public enum HudType {MAIN_MENU, GAME_MENU};
	
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
		scene.detachChild(currentHUD);
		currentHUD.destroy();
		
		showSelectedHUD();
	}
	
	private void showSelectedHUD() {
		switch(selectedHudType) {
		case MAIN_MENU:
			currentHUD = new MainMenuHUD();
			break;
		case GAME_MENU:
			currentHUD = new GameMenuHUD();
			break;		
		}
				
		scene.attachChild(currentHUD);
		currentHUD.registerTouchArea(scene);
		currentHUD.setOnHUDHideListener(this);
		currentHUD.setHUDController(controllerForSelectedHUD);
		currentHUD.show();
	}
	
	public HudType getHudType() {
		return selectedHudType;
	}

}
