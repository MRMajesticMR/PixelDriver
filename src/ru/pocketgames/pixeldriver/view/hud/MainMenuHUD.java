package ru.pocketgames.pixeldriver.view.hud;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.sprite.ButtonSprite;
import org.andengine.entity.sprite.ButtonSprite.OnClickListener;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.controllers.hud.MainMenuController;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideGameLogoTxtModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.HideStartBtmModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowGameLogoTxtModifier;
import ru.pocketgames.pixeldriver.view.hud.modifiers.ShowStartBtnModifier;
import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.modifiers.IShowSequenceEntityModifier;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class MainMenuHUD extends IHUD implements OnClickListener {
	
	private static final int START_BTN_WIDTH 	= 200;
	private static final int START_BTN_HEIGHT	= 70;	
	
	private static final int LOGO_TITLE_WIDTH 	= 300;
	private static final int LOGO_TITLE_HEIGHT	= 70;
	
	//VIEWS
	private Sprite			titleTxt;
	private ButtonSprite	startGameBtn;
	
	//MODIFIERS
	private IShowSequenceEntityModifier startBtnShowModifier;
	private IShowSequenceEntityModifier	titleTxtShowModifier;
	
	private IHideSequenceEntityModifier	startBtnHideModifier;
	private IHideSequenceEntityModifier titleTxtHideModifier;
	
	//CONTROLLER
	private MainMenuController	mainMenuController;
	
	public MainMenuHUD(Scene scene) {
		super(scene);
		
		ResourceManager.getInstance().loadMainMenuHUDResources();
		
		initViews					();
		initViewsPositionsAndBounds	();
		initModifiers				();
		
		startGameBtn.setOnClickListener(this);
		
		attachChild(startGameBtn);
		attachChild(titleTxt);
	}
	
	private void initViews() {
		titleTxt		= new Sprite(0, 0, ResourceManager.getInstance().getMainMenuHUDResources().getGameTitleTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
		startGameBtn 	= new ButtonSprite(0, 0, ResourceManager.getInstance().getMainMenuHUDResources().getStartGameBtnTextureRegion(), ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
		
		titleTxt.setVisible(false);
		startGameBtn.setVisible(false);
		
		scene.registerTouchArea(startGameBtn);
	}
	
	private void initViewsPositionsAndBounds() {
		titleTxt.setWidth		(LOGO_TITLE_WIDTH);
		titleTxt.setHeight		(LOGO_TITLE_HEIGHT);
		titleTxt.setX			((DefaultCamera.CAMERA_WIDTH - titleTxt.getWidth()) / 2);
		titleTxt.setY			((int) (DefaultCamera.CAMERA_HEIGHT * 0.2));
		
		startGameBtn.setWidth	(START_BTN_WIDTH);
		startGameBtn.setHeight	(START_BTN_HEIGHT);
		startGameBtn.setX		((DefaultCamera.CAMERA_WIDTH - startGameBtn.getWidth()) / 2);
		startGameBtn.setY		((int) (DefaultCamera.CAMERA_HEIGHT * 0.7));
	}
	
	private void initModifiers() {
		titleTxtShowModifier 	= new ShowGameLogoTxtModifier(titleTxt);
		titleTxtHideModifier	= new HideGameLogoTxtModifier(titleTxt);
		
		startBtnShowModifier 	= new ShowStartBtnModifier(startGameBtn);
		startBtnHideModifier	= new HideStartBtmModifier(startGameBtn);
		
		startBtnHideModifier.addModifierListener(this);
	}		

	@Override
	public void setHUDController(IHUDController hudController) {
		this.mainMenuController = (MainMenuController) hudController;
	}

	@Override
	public void show() {
		titleTxtShowModifier.reset();
		startBtnShowModifier.reset();		
		
		titleTxt.registerEntityModifier(titleTxtShowModifier);
		startGameBtn.registerEntityModifier(startBtnShowModifier);
	}

	@Override
	public void hide() {
		titleTxtHideModifier.reset();
		startBtnHideModifier.reset();
		
		titleTxt.registerEntityModifier(titleTxtHideModifier);
		startGameBtn.registerEntityModifier(startBtnHideModifier);
	}
	
	@Override
	public void destroy() {
		ResourceManager.getInstance().unloadMainMenuHUDResources();
		
		scene.unregisterTouchArea(startGameBtn);
	}		

	@Override
	public void onClick(ButtonSprite pButtonSprite, float pTouchAreaLocalX, float pTouchAreaLocalY) {
		if(pButtonSprite.hashCode() == startGameBtn.hashCode()) {
			mainMenuController.onStartGameBtnClicked();
		}
	}
	
}
