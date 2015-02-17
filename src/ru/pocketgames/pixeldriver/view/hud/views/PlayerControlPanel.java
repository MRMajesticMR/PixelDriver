package ru.pocketgames.pixeldriver.view.hud.views;

import org.andengine.entity.sprite.Sprite;
import org.andengine.input.touch.TouchEvent;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.hud.views.PlayerControlPanel.OnControlChangedListener.State;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class PlayerControlPanel extends Sprite {		

	public interface OnControlChangedListener {
		
		public enum State{LEFT, RIGHT, RELEASED}
		
		public void onControlChanged(State state);		
	}
	
	private OnControlChangedListener onControlChangedListener;
	
	public PlayerControlPanel() {
		super(0, 0, DefaultCamera.CAMERA_WIDTH, DefaultCamera.CAMERA_HEIGHT, 
				ResourceManager.getInstance().getGameMenuHUDResources().getTutorialMenuSideBackgroundTextureRegion(), 
				ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
		
		setAlpha(0.0f);
	}
	
	public void setOnControlChangedListener(OnControlChangedListener onControlChangedListener) {
		this.onControlChangedListener = onControlChangedListener;
	}
	
	
	@Override
	public boolean onAreaTouched(final TouchEvent pSceneTouchEvent, final float pTouchAreaLocalX, final float pTouchAreaLocalY) {
		switch (pSceneTouchEvent.getAction()) {
		case TouchEvent.ACTION_DOWN:
			if(pTouchAreaLocalX < DefaultCamera.CAMERA_WIDTH / 2) {
				onControlChangedListener.onControlChanged(State.LEFT);
			} else {
				onControlChangedListener.onControlChanged(State.RIGHT);
			}
			break;
		case TouchEvent.ACTION_UP:
		case TouchEvent.ACTION_OUTSIDE:
			onControlChangedListener.onControlChanged(State.RELEASED);
			break;
		}
		return true;
	}
	
	

}
