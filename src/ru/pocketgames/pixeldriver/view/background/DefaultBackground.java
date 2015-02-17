package ru.pocketgames.pixeldriver.view.background;

import org.andengine.entity.Entity;
import org.andengine.entity.sprite.Sprite;

import ru.pocketgames.pixeldriver.andengine.DefaultCamera;
import ru.pocketgames.pixeldriver.view.resources.ResourceManager;

public class DefaultBackground extends Entity {	
	
	private static final float ROAD_SPEED = 3.0f;
	
	private Sprite[] roads = new Sprite[2];
	
	public DefaultBackground() {
		ResourceManager.getInstance().loadBackgroundResource();
		
		roads[0] = new Sprite(0, -DefaultCamera.CAMERA_HEIGHT, DefaultCamera.CAMERA_WIDTH, DefaultCamera.CAMERA_HEIGHT, 
	            ResourceManager.getInstance().getBackgroundResources().getBackgroundTextureRegion(), 
	            ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
	      
	    roads[1] = new Sprite(0, 0, DefaultCamera.CAMERA_WIDTH, DefaultCamera.CAMERA_HEIGHT, 
	            ResourceManager.getInstance().getBackgroundResources().getBackgroundTextureRegion(), 
	            ResourceManager.getInstance().getEngine().getVertexBufferObjectManager());
	      
	    attachChild(roads[0]);
	    attachChild(roads[1]);
	}
	
	public void update(float speed) {      
	      roads[0].setY(roads[0].getY() + speed);
	      roads[1].setY(roads[1].getY() + speed);
	      
	      if(roads[0].getY() > DefaultCamera.CAMERA_HEIGHT)
	         roads[0].setY(roads[1].getY() - DefaultCamera.CAMERA_HEIGHT);
	      
	      if(roads[1].getY() > DefaultCamera.CAMERA_HEIGHT)
	         roads[1].setY(roads[0].getY() - DefaultCamera.CAMERA_HEIGHT);     
	   }
	   
	   @Override
	   public void onManagedUpdate(final float pSecondsElapsed) {
	      super.onManagedUpdate(pSecondsElapsed);
	      
	      update(ROAD_SPEED);
	   }

}
