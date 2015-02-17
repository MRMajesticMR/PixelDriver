package ru.pocketgames.pixeldriver.view.objects.controllers;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.objects.IMoveableGameObject;

public class TutorialMenuPlayerCarController extends IMoveableObjectController {

	private static final float DOWN_SPEED = 8.0f;
	private static final float SIDE_SPEED = 2.0f;
	
	private static final float CAR_POSITION = DefaultCamera.CAMERA_HEIGHT * 0.7f;
	
	private enum State {LEFT, RIGHT}
	
	private State beginState;
	
	public TutorialMenuPlayerCarController(IMoveableGameObject object) {
		super(object);				
		if(object.getX() < (DefaultCamera.CAMERA_WIDTH - object.getWidth()) / 2)
			beginState = State.LEFT;
		else
			beginState = State.RIGHT;
	}

	@Override
	public void move() {		
//		if(object.getRotationState() != RotationState.NONE)
//			object.releaseTurn();
		
		if(object.getY() < CAR_POSITION)
			object.setY(object.getY() + DOWN_SPEED);
		
		
		if(beginState == State.RIGHT) {
			if(object.getX() > (DefaultCamera.CAMERA_WIDTH - object.getWidth()) / 2) {
				object.setX(object.getX() - SIDE_SPEED);
			} else {
				object.setX((DefaultCamera.CAMERA_WIDTH - object.getWidth()) / 2);
			}
		}
		
		if(beginState == State.LEFT) {
			if(object.getX() < (DefaultCamera.CAMERA_WIDTH - object.getWidth()) / 2) {
				object.setX(object.getX() + SIDE_SPEED);
			} else {
				object.setX((DefaultCamera.CAMERA_WIDTH - object.getWidth()) / 2);
			}
		}
		
		object.move();
	}

}
