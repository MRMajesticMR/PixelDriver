package ru.pocketgames.pixeldriver.activities;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.handler.IUpdateHandler;
import org.andengine.engine.options.EngineOptions;
import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.BaseGameActivity;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.andengine.DefaultOptions;
import ru.pocketgames.pixeldriver.andengine.DefaultScene;
import ru.pocketgames.pixeldriver.controls.DebugPlayerCarController;
import ru.pocketgames.pixeldriver.view.objects.player.PlayerCar;
import ru.pocketgames.pixeldriver.view.resources.impl.ResourceManager;
import android.view.KeyEvent;

public class GameActivity extends BaseGameActivity implements IUpdateHandler  {
	
	private Camera camera = new DefaultCamera();		
	
	private PlayerCar playerCar;
	
	private DebugPlayerCarController debugPlayerCarController;
	
	@Override
	public EngineOptions onCreateEngineOptions() {
		return new DefaultOptions(camera);
	}

	@Override
	public void onCreateResources(OnCreateResourcesCallback pOnCreateResourcesCallback) throws Exception {
		ResourceManager.getInstance().init(this, getEngine());
		ResourceManager.getInstance().loadResources();
		
		playerCar = new PlayerCar(getEngine());
		
		debugPlayerCarController = new DebugPlayerCarController(0, 0, DefaultCamera.CAMERA_WIDTH, DefaultCamera.CAMERA_HEIGHT, getEngine().getVertexBufferObjectManager());
		debugPlayerCarController.setControlableObject(playerCar);
		
		pOnCreateResourcesCallback.onCreateResourcesFinished();
	}

	@Override
	public void onCreateScene(OnCreateSceneCallback pOnCreateSceneCallback) throws Exception {
		final Scene scene = new DefaultScene();
		scene.registerUpdateHandler(this);
		
		pOnCreateSceneCallback.onCreateSceneFinished(scene);
	}

	@Override
	public void onPopulateScene(Scene pScene, OnPopulateSceneCallback pOnPopulateSceneCallback) throws Exception {		
		
		pScene.attachChild(playerCar.getView());	
		
		pScene.registerTouchArea(debugPlayerCarController);
		pScene.attachChild(debugPlayerCarController);
		
		pOnPopulateSceneCallback.onPopulateSceneFinished();
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		return super.onKeyDown(keyCode, event);
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		ResourceManager.getInstance().unloadResources();
	}

	@Override
	public void onUpdate(float pSecondsElapsed) {
		playerCar.update();		
	}

	@Override
	public void reset() {
		//.
	}
}
