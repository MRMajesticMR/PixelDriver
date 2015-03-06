package ru.pocketgames.pixeldriver.view.objects.player;

public interface IControlableObject {

	public enum TurnState {LEFT, RIGHT, RELEASED}
	
	public void setBreak		();
	public void releaseBreak	();
	
	public void setTurnLeft		();
	public void setTurnRight	();
	public void releaseTurn		();
	
}
