package ru.pocketgames.pixeldriver.view.hud;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.text.Text;

import android.util.Log;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.controllers.hud.GameMenuController;
import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideLeftSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideRightSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowLeftSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowRightSideTutorialMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowScoreGameMenuModifier;
import ru.pocketgames.pixeldriver.view.hud.views.LeftTutorialControlNote;
import ru.pocketgames.pixeldriver.view.hud.views.PlayerControlPanel;
import ru.pocketgames.pixeldriver.view.hud.views.PlayerControlPanel.OnControlChangedListener;
import ru.pocketgames.pixeldriver.view.hud.views.RightTutorialControlNote;
import ru.pocketgames.pixeldriver.view.hud.views.TutorialControlNote;
import ru.pocketgames.pixeldriver.view.hud.views.TutorialView;
import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class GameMenuHUD extends IHUD implements OnControlChangedListener {
	
	private static final String LOG_TAG = GameMenuHUD.class.getSimpleName();
	
	private GameMenuController gameMenuController;
	
	//VIEWS
	private TutorialView			tutorialView;	
	private Text 					scoreViewer;
	private PlayerControlPanel		playerControlPanel;
	
	//MODIFIERS	
	
	private IShowSequenceEntityModifier showScoreTxtModifier;
	
	public GameMenuHUD() {
		initViews();
		initModifiers();						
	}
	
	private void initViews() {
		ResourceManager.getInstance().loadGameMenuHUDResources();		
				
		tutorialView = new TutorialView();
		
		scoreViewer = new Text(0, 0, ResourceManager.getInstance().getGameMenuHUDResources().getScoreFont(), "000000", ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
		scoreViewer.setVisible(false);
		scoreViewer.setX((DefaultCamera.CAMERA_WIDTH - scoreViewer.getWidth()) / 2);
		
		playerControlPanel = new PlayerControlPanel();
		playerControlPanel.setOnControlChangedListener(this);
				
		attachChild(scoreViewer);
		attachChild(tutorialView);
		attachChild(playerControlPanel);
	}
	
	private void initModifiers() {				
		showScoreTxtModifier = new ShowScoreGameMenuModifier(scoreViewer);
	}

	@Override
	public void show() {		
		showScoreTxtModifier.reset();
				
		scoreViewer.registerEntityModifier(showScoreTxtModifier);
		
		tutorialView.show();
	}

	@Override
	public void hide() {
		if(tutorialView.isTutorialVisible()) {
			tutorialView.hide();
		}
	}

	@Override
	public void destroy() {		
		ResourceManager.getInstance().unloadGameMenuHUDResources();		
	}

	@Override
	public void registerTouchArea(Scene scene) {
		scene.registerTouchArea(playerControlPanel);
	}

	@Override
	public void setHUDController(IHUDController hudController) {
		gameMenuController = (GameMenuController) hudController;	
	}

	@Override
	public void onControlChanged(State state) {
		if(tutorialView.isVisible()) {
			tutorialView.hide();
		}
		
	}

}
