package game_engine;

import processing.core.PApplet;
import processing.core.PVector;

public abstract class GameObject implements ProcessingInterface {
	public PApplet parent; // The parent PApplet that we will render ourselves onto
	public String name;
	public GameManager gameManager;
	public PVector position = new PVector(0,0);
	public PVector size = new PVector(0,0);
	public boolean hitAble = false;
	public abstract void start();
	public abstract void update();
	public abstract void render();
	
	
	
	public GameObject(PApplet p) {
		parent = p;
	}
	public String ToString() {
		return this.name;
	}
}
