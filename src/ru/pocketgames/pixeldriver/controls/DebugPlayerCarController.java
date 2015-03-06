package ru.pocketgames.pixeldriver.controls;

import org.andengine.entity.primitive.Rectangle;
import org.andengine.input.touch.TouchEvent;
import org.andengine.opengl.vbo.VertexBufferObjectManager;

import ru.pocketgames.pixeldriver.view.objects.player.IControlableObject;

public class DebugPlayerCarController extends Rectangle implements IPlayerCarController {
	
	public DebugPlayerCarController(float pX, float pY, float pWidth, float pHeight, VertexBufferObjectManager pRectangleVertexBufferObject) {
		super(pX, pY, pWidth, pHeight, pRectangleVertexBufferObject);
		setAlpha(0.0f);
	}

	private IControlableObject controlableObject;
	
	@Override
	public void setControlableObject(IControlableObject controlableObject) {
		this.controlableObject = controlableObject;
	}

	@Override
    public boolean onAreaTouched(TouchEvent pSceneTouchEvent, float X, float Y) 
    {
		switch(pSceneTouchEvent.getAction()) {
		case TouchEvent.ACTION_DOWN:
		case TouchEvent.ACTION_MOVE:
			if(Y > getHeight() * 0.8f) {
				controlableObject.setBreak();
			} else {
				if(X < getWidth() / 2) {
					controlableObject.setTurnLeft();
				} else {
					controlableObject.setTurnRight();
				}
			}
			break;
		case TouchEvent.ACTION_UP:
		case TouchEvent.ACTION_OUTSIDE:
			if(Y > getHeight() * 0.8f) {
				controlableObject.releaseBreak();
			} else {
				controlableObject.releaseTurn();
			}
		}
		
        return true;
    };
}
