package ru.pocketgames.pixeldriver.view.hud;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.controllers.hud.GameMenuController;
import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowScoreGameMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.views.PlayerControlPanel;
import ru.pocketgames.pixeldriver.view.hud.views.PlayerControlPanel.OnControlChangedListener;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class GameMenuHUD extends IHUD implements OnControlChangedListener {
	
	private static final String LOG_TAG = GameMenuHUD.class.getSimpleName();
	
	private GameMenuController gameMenuController;
	
	//VIEWS	
	private Text 					scoreViewer;
	private PlayerControlPanel		playerControlPanel;
	
	//MODIFIERS	
	
	private IShowSequenceEntityModifier showScoreTxtModifier;
	
	public GameMenuHUD(Scene scene) {
		super(scene);
		
		initViews();
		initModifiers();						
	}
	
	private void initViews() {
		ResourceManager.getInstance().loadGameMenuHUDResources();		
		
		scoreViewer = new Text(0, 0, ResourceManager.getInstance().getGameMenuHUDResources().getScoreFont(), "000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
		scoreViewer.setVisible(false);
		scoreViewer.setX((DefaultCamera.CAMERA_WIDTH - scoreViewer.getWidth()) / 2);
		
		playerControlPanel = new PlayerControlPanel();
		playerControlPanel.setOnControlChangedListener(this);
				
		scene.registerTouchArea(playerControlPanel);
		
		attachChild(scoreViewer);		
		attachChild(playerControlPanel);
	}
	
	private void initModifiers() {				
		showScoreTxtModifier = new ShowScoreGameMenuModifier(scoreViewer);
	}

	@Override
	public void show() {		
		showScoreTxtModifier.reset();
				
		scoreViewer.registerEntityModifier(showScoreTxtModifier);				
	}

	@Override
	public void hide() {
		
	}

	@Override
	public void destroy() {		
		ResourceManager.getInstance().unloadGameMenuHUDResources();
		
		scene.unregisterTouchArea(playerControlPanel);
	}

	@Override
	public void setHUDController(IHUDController hudController) {
		gameMenuController = (GameMenuController) hudController;	
	}

	@Override
	public void onControlChanged(State state) {		
		
	}	

}
