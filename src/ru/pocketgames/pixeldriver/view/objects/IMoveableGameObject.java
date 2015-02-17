package ru.pocketgames.pixeldriver.view.objects;


public abstract class IMoveableGameObject extends IGameObject {

	public enum RotationState {LEFT, RIGHT, NONE}
	
	protected RotationState rotationState;
	
	private float speed;
	private float rotationVelocity;
	private float rotationAcceleration;
	
	private float maxRotationVelocity;
	
	public IMoveableGameObject() {				
		super();
		rotationState = RotationState.NONE;
	}
	
	private RotationState getRotationState() {
		return rotationState;
	}
	
	public void setRotationState(RotationState rotationState) {
		this.rotationState = rotationState;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public void setRotationVelocity(float rotationVelocity) {
		this.rotationVelocity = rotationVelocity;
	}		
	
	protected float getRotationVelocity() {
		return rotationVelocity;
	}
	
	protected void recalculateRotationVelocity() {
		switch(getRotationState()) {
		case LEFT: 
		case RIGHT:
			increaseRotationVelocityIfPossible();
			break;
		case NONE:
			decreaseRotationVelocityIfPossible();			
			break;
		}
	}
	
	private void increaseRotationVelocityIfPossible() {
		if(getRotationVelocity() < getMaxRotationVelocity())			
			setRotationVelocity(getRotationVelocity() - getRotationAcceleration());
		else
			setRotationVelocity(getMaxRotationVelocity());
	}
	
	private void decreaseRotationVelocityIfPossible() {
		if(getRotationVelocity() > 0)
			setRotationVelocity(getRotationVelocity() + getRotationAcceleration());
		else
			setRotationVelocity(0);
	}	

	public void setRotationAcceleration(float rotationAcceleration) {
		this.rotationAcceleration = rotationAcceleration;
	}
	
	private float getRotationAcceleration() {
		return rotationAcceleration;
	}
	
	protected void setMaxRotationVelocity(float maxRotationVelocity) {
		this.maxRotationVelocity = maxRotationVelocity;
	}
	
	private float getMaxRotationVelocity() {
		return maxRotationVelocity;
	}
	
	public abstract void move();
	
	
}
