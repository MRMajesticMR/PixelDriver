package ru.pocketgames.pixeldriver.andengine;

import org.andengine.engine.camera.Camera;

public class DefaultCamera extends Camera {

   public static final int CAMERA_WIDTH 		= 480;
   public static final int CAMERA_HEIGHT 		= 800;

   public static final int DEFAULT_X 			= 0;
   public static final int DEFAULT_Y 			= 0;

   public DefaultCamera() {
      super(DEFAULT_X, DEFAULT_Y, CAMERA_WIDTH, CAMERA_HEIGHT);      
   }      

}
