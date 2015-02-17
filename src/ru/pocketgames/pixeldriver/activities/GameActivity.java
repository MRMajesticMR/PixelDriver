package ru.pocketgames.pixeldriver.activities;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.andengine.DefaultOptions;
import ru.pocketgames.pixeldriver.andengine.DefaultScene;
import ru.pocketgames.pixeldriver.controllers.hud.GameMenuController;
import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.controllers.hud.MainMenuController;
import ru.pocketgames.pixeldriver.view.background.DefaultBackground;
import ru.pocketgames.pixeldriver.view.hud.HUDManager;
import ru.pocketgames.pixeldriver.view.hud.HUDManager.HudType;
import ru.pocketgames.pixeldriver.view.objects.GameField;
import ru.pocketgames.pixeldriver.view.objects.GameField.State;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;
import android.view.KeyEvent;

public class GameActivity extends BaseGameActivity {
	
	private Camera camera = new DefaultCamera();		
	
	//VIEWS
	private HUDManager 			hudManager;
	private GameField			gameField;
	private DefaultBackground	background;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		return new DefaultOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
		ResourceManager.getInstance().init(this, getEngine());		
		
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {					
		pOnCreateSceneCallback.onCreateSceneFinished(new DefaultScene());
	}

	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {
		background	= new DefaultBackground();
		gameField	= new GameField();
		hudManager 	= new HUDManager(pScene);					
		
		pScene.attachChild(background);
		pScene.attachChild(gameField);
		hudManager.changeHUD(HudType.MAIN_MENU, mainMenuHUDController);
		gameField.changeState(State.MAIN_MENU);
		
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
			if (hudManager.getHudType() == HudType.GAME_MENU) {
				hudManager.changeHUD(HudType.MAIN_MENU, mainMenuHUDController);
				gameField.changeState(State.MAIN_MENU);
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.getInstance().unloadAllResources();
	}
	
	// CONTROLLERS
	private IHUDController mainMenuHUDController = new MainMenuController() {

		@Override
		public void onStartGameBtnClicked() {
			hudManager.changeHUD(HudType.GAME_MENU, gameMenuHUDController);
			gameField.changeState(State.TUTORIAL_MENU);
		}
	};
	
	private GameMenuController gameMenuHUDController = new GameMenuController() {

		@Override
		public void onMenuClosed() {
			hudManager.changeHUD(HudType.GAME_MENU, gameMenuHUDController);
			gameField.changeState(State.GAME);
		}
		
	};	

}
