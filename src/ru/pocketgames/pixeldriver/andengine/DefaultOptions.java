package ru.pocketgames.pixeldriver.andengine;

import org.andengine.engine.camera.Camera;
import org.andengine.engine.options.EngineOptions;
import org.andengine.engine.options.ScreenOrientation;
import org.andengine.engine.options.WakeLockOptions;
import org.andengine.engine.options.resolutionpolicy.FillResolutionPolicy;
import org.andengine.engine.options.resolutionpolicy.IResolutionPolicy;

public class DefaultOptions extends EngineOptions {

   private static final boolean FULL_SCREEN = true;
   
   private static final ScreenOrientation SCREEN_ORIENTATION = ScreenOrientation.PORTRAIT_FIXED;
   
   private static final IResolutionPolicy RESOLUTION_POLICY = new FillResolutionPolicy();

   public DefaultOptions(Camera camera) {
      super(FULL_SCREEN, SCREEN_ORIENTATION, RESOLUTION_POLICY, camera);
      setWakeLockOptions(WakeLockOptions.SCREEN_ON);
   }

}
