package ru.pocketgames.pixeldriver.view.hud;

import org.andengine.entity.Entity;
import org.andengine.entity.IEntity;
import org.andengine.entity.scene.Scene;
import org.andengine.util.modifier.IModifier;

import ru.pocketgames.pixeldriver.controllers.hud.IHUDController;
import ru.pocketgames.pixeldriver.view.modifiers.IHideSequenceEntityModifier;

public abstract class IHUD extends Entity implements IModifier.IModifierListener<IEntity>{
	
	public interface OnHUDHideListener {
		
		public void onHUDHide();
		
	}
	
	protected OnHUDHideListener onHUDHideListener;
	
	protected Scene scene;
	
	public IHUD(Scene scene) {
		this.scene = scene;
	}
	
	public void setOnHUDHideListener(OnHUDHideListener onHUDHideListener) {
		this.onHUDHideListener = onHUDHideListener;
	}
	
	public abstract void 		show					();
	public abstract void 		hide					();
	public abstract void 		destroy					();
	
//	public abstract void 		registerTouchArea		(Scene scene);
	public abstract void 		setHUDController		(IHUDController hudController);
	
	@Override
	public void onModifierFinished(IModifier<IEntity> pModifier, IEntity pItem) {		
		if (pModifier instanceof IHideSequenceEntityModifier) {
			onHUDHideListener.onHUDHide();
			return;
		}
	}
	
	@Override
	public void onModifierStarted(IModifier<IEntity> pModifier, IEntity pItem) {

	}
	
}
