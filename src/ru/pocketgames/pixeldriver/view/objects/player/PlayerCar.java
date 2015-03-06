package ru.pocketgames.pixeldriver.view.objects.player;

import org.andengine.engine.Engine;
import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.view.resources.impl.ResourceManager;

public class PlayerCar implements IControlableObject {

	private Sprite view;
	
	private float x;
	private float y;
	private float width;
	private float length;
	
	private float currentSpeed;	
	private float accelerationSpeed;
	private float breakSpeed;
	
	private float maxSpeed;
	private float minSpeed;
	
	private boolean isBreak;
	
	private TurnState turnState;
	private float currentTurnSpeed;
	private float turnAcceleration;
	
	private float maxTurnSpeed;
	
	public PlayerCar(Engine engine) {
		this.x 		= 0;
		this.y 		= 600;
		this.width 	= 60;
		this.length = 120;
		
		view = new Sprite(x, y, ResourceManager.getInstance().getPlayerCarRecources().getPlayerCarTextureRegion(), engine.getVertexBufferObjectManager());
		view.setWidth	(width);
		view.setHeight	(length);
		
		maxSpeed = 5.0f;
		minSpeed = 1.0f;
		
		currentSpeed 			= minSpeed;
		accelerationSpeed 		= 0.1f;
		breakSpeed 				= 0.4f;
		
		isBreak = false;
		
		turnState = TurnState.RELEASED;
		
		currentTurnSpeed 	= 0.0f;
		turnAcceleration 	= 0.3f;
		maxTurnSpeed		= 5.0f;
	}		
	
	public Entity getView() {
		return view;
	}
	
	public void update() {
		if(isBreak) {			
			this.currentSpeed -= breakSpeed;
			
			if(currentSpeed < minSpeed)
				currentSpeed = minSpeed;			
		} else {		
			this.currentSpeed += accelerationSpeed;
			
			if(currentSpeed > maxSpeed)			
				this.currentSpeed = maxSpeed;
		}
		
		if(turnState == TurnState.LEFT) {
			currentTurnSpeed -= turnAcceleration;
			if(currentTurnSpeed < -maxTurnSpeed)
				currentTurnSpeed = -maxTurnSpeed;
		}
		
		if(turnState == TurnState.RIGHT) {
			currentTurnSpeed += turnAcceleration;
			if(currentTurnSpeed > maxTurnSpeed)
				currentTurnSpeed = maxTurnSpeed;
		}
		
		if(turnState == TurnState.RELEASED) {
			if(currentTurnSpeed < 0) {
				currentTurnSpeed += turnAcceleration;
				if(currentTurnSpeed > 0)
					currentTurnSpeed = 0;
			}
			
			if(currentTurnSpeed > 0) {
				currentTurnSpeed -= turnAcceleration;
				if(currentTurnSpeed < 0)
					currentTurnSpeed = 0;
			}
		}
				
		
		y -= currentSpeed;
		x += currentTurnSpeed;
		
//		view.setY(y);
		view.setX(x);
		
		view.setRotation(translateTurnSpeedToRotation(currentTurnSpeed));
	}			
	
	private float translateTurnSpeedToRotation(float turnSpeed) {
		return turnSpeed;
	}
	
	@Override
	public void setBreak() {		
		isBreak = true;
	}
	
	@Override
	public void releaseBreak() {
		isBreak = false;
	}

	@Override
	public void setTurnLeft() {
		turnState = TurnState.LEFT;
	}

	@Override
	public void setTurnRight() {
		turnState = TurnState.RIGHT;		
	}

	@Override
	public void releaseTurn() {
		turnState = TurnState.RELEASED;
		
	}
	
}
