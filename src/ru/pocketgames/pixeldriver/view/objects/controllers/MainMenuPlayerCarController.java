package ru.pocketgames.pixeldriver.view.objects.controllers;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.objects.IMoveableGameObject;
import ru.pocketgames.pixeldriver.view.objects.player.PlayerCar;

public class MainMenuPlayerCarController extends IMoveableObjectController {
	
	private static final float CAR_MOVE_FORWARD_SPEED = - 8.0f;
	
	private static final float CAR_MOVE_FORWARD_Y_POSITION = DefaultCamera.CAMERA_HEIGHT / 2 - 50;
	
	private static final float CAR_MOVE_BORDER_BOTTOM	 = DefaultCamera.CAMERA_HEIGHT / 2 - 100;
	private static final float CAR_MOVE_BORDER_TOP		 = DefaultCamera.CAMERA_HEIGHT / 2 + 100;
	private static final float CAR_MOVE_BORDER_LEFT		 = DefaultCamera.CAMERA_WIDTH / 2 - 100;
	private static final float CAR_MOVE_BORDER_RIGHT	 = DefaultCamera.CAMERA_WIDTH / 2 + 100 - PlayerCar.CAR_WIDTH;
	
	private boolean isOutOfMoveBorders;
	
	public MainMenuPlayerCarController(IMoveableGameObject object) {
		super(object);
		
		isOutOfMoveBorders = true;
	}

	@Override
	public void move() {
		if(isOutOfMoveBorders) {
			if(object.getY() < CAR_MOVE_FORWARD_Y_POSITION) {
				isOutOfMoveBorders = false;
//				object.turnLeft();
			}
			
			object.setY(object.getY() + CAR_MOVE_FORWARD_SPEED);			
		} else {			
			object.move();
			
//			switch(object.getRotationState()) {
//			case LEFT:				
//				if(object.getX() < CAR_MOVE_BORDER_LEFT)
//					object.turnRight();
//				break;
//			case RIGHT:				
//				if(object.getX() > CAR_MOVE_BORDER_RIGHT)
//					object.turnLeft();
//				break;			
//			}			
			
		}
	}

}
