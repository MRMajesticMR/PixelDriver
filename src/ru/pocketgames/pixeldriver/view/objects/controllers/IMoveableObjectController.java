package ru.pocketgames.pixeldriver.view.objects.controllers;

import ru.pocketgames.pixeldriver.view.objects.IMoveableGameObject;

public abstract class IMoveableObjectController {

	protected IMoveableGameObject object;
	
	public IMoveableObjectController(IMoveableGameObject object) {
		this.object = object;
	}
	
	public abstract void move();
	
}
