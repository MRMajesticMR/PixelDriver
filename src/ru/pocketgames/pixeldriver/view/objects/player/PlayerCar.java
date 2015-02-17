package ru.pocketgames.pixeldriver.view.objects.player;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.view.objects.IAndEngineObject;
import ru.pocketgames.pixeldriver.view.objects.IMoveableGameObject;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class PlayerCar extends IMoveableGameObject implements IAndEngineObject {
	
	public static final float 	CAR_WIDTH 	= 70;
	private static final float 	CAR_HEIGHT 	= 120;
	
	private static final float CAR_SPEED 					= 3.0f;
	private static final float MAX_ROTATION_VELOCITY 		= 3.0f;
	private static final float ROTATION_ACCELERATION 		= 0.1f;
	
	private Sprite playerCarView;

	public PlayerCar() {
		playerCarView = new Sprite(0, 0, 
				ResourceManager.getInstance().getPlayerCarRecources().getRedPlayerCarTextureRegion(), 
				ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
		
		setX					(0);
		setY					(0);
		setWidth				(CAR_WIDTH);
		setHeight				(CAR_HEIGHT);
		setSpeed				(CAR_SPEED);		
		setRotationAcceleration	(ROTATION_ACCELERATION);
		setMaxRotationVelocity	(MAX_ROTATION_VELOCITY);
		
		playerCarView.setRotationCenter(getWidth() / 2, getHeight() / 2);
	}

	@Override
	public void move() {
		recalculateRotationVelocity();		
		rotateView();
		updateViewPosition();
	}		

	@Override
	public void setX(float x) {
		playerCarView.setX(x);
	}

	@Override
	public float getX() {
		return playerCarView.getX();
	}

	@Override
	public void setY(float y) {
		playerCarView.setY(y);
	}

	@Override
	public float getY() {
		return playerCarView.getY();
	}

	@Override
	public void setWidth(float width) {
		playerCarView.setWidth(width);
	}

	@Override
	public float getWidth() {
		return playerCarView.getWidth();
	}

	@Override
	public void setHeight(float height) {
		playerCarView.setHeight(height);
	}

	@Override
	public float getHeight() {
		return playerCarView.getHeight();
	}
	
	//ANDENGINE OBJECT
	@Override
	public void addToScene(Entity entity) {
		entity.attachChild(playerCarView);
	}
	
	//PRIVATE METHODS
	private void rotateView() {
		playerCarView.setRotation(getRotationVelocity() * 3.0f);
	}
	
	private void updateViewPosition() {
		setX(getX() + getRotationVelocity());
	}	

}
