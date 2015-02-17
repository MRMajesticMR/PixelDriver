package ru.pocketgames.pixeldriver.view.modifiers;

import org.andengine.entity.IEntity;
import org.andengine.entity.modifier.IEntityModifier;
import org.andengine.entity.modifier.SequenceEntityModifier;

public abstract class IShowSequenceEntityModifier extends SequenceEntityModifier {

   public IShowSequenceEntityModifier(final IEntityModifier... pEntityModifiers) {
      super(pEntityModifiers);
   }
   
   @Override
   protected void onModifierStarted(IEntity pItem) {
      super.onModifierStarted(pItem);
      pItem.setVisible(true);
   }

   @Override
   protected void onModifierFinished(IEntity pItem) {
      super.onModifierFinished(pItem);
   }
   
}
