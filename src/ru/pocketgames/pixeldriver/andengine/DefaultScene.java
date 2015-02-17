package ru.pocketgames.pixeldriver.andengine;

import org.andengine.entity.scene.Scene;
import org.andengine.entity.scene.background.Background;

public class DefaultScene extends Scene {

   public DefaultScene() {
      super();      
      setTouchAreaBindingOnActionDownEnabled(true);
      
      //DEBUG CODE
      setBackgroundEnabled(true);
      setBackground(new Background(0f, 1f, 0f));
   }

}
