package ru.pocketgames.pixeldriver.view.objects;

import org.andengine.entity.Entity;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.objects.controllers.IMoveableObjectController;
import ru.pocketgames.pixeldriver.view.objects.controllers.MainMenuPlayerCarController;
import ru.pocketgames.pixeldriver.view.objects.controllers.TutorialMenuPlayerCarController;
import ru.pocketgames.pixeldriver.view.objects.player.PlayerCar;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class GameField extends Entity {	
	
	public enum State {MAIN_MENU, TUTORIAL_MENU, GAME};
	
	private PlayerCar playerCarView;
	
	private State currentState;
	
	private IMoveableObjectController moveableObjectController;
	
	public GameField() {
		ResourceManager.getInstance().loadPlayerCarResources();
		
		playerCarView = new PlayerCar();		
		playerCarView.addToScene(this);		
		playerCarView.setX((DefaultCamera.CAMERA_WIDTH - playerCarView.getWidth()) / 2);
		playerCarView.setY(DefaultCamera.CAMERA_HEIGHT);		
	}
	
	public void changeState(State state) {
		this.currentState = state;
		
		switch(currentState) {
		case MAIN_MENU:		
			moveableObjectController = new MainMenuPlayerCarController(playerCarView);
			break;
		case TUTORIAL_MENU:
			moveableObjectController = new TutorialMenuPlayerCarController(playerCarView);
			break;
		case GAME:
			break;
		}
	}		
	
	@Override
	public void onManagedUpdate(final float pSecondsElapsed) {
		moveableObjectController.move();		
	}

}
