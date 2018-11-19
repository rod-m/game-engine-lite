package space_wars;

import game_engine.GameObject;
import processing.core.PApplet;
import processing.core.PVector;

public class Bullet extends GameObject {
	public float speed = 12f;
	public PVector velocity = new PVector(0, -1);
	int lifespan = 25;
	
	public Bullet(PApplet p) {
		super(p);
	}


	@Override
	public void update() {
		// bullet moves in same direction as ship
		this.position.add(this.velocity);
		if (lifespan > 0) {
			lifespan--;
		} else {
			// this only removes it from the gamemanager
			// 
			this.gameManager.destroyGameObject(this);
		
		}

	}

	@Override
	public void render() {
		parent.pushMatrix();
		parent.translate(this.position.x, this.position.y);
		parent.fill(0, 255, 0);
		parent.ellipse(0, 0, 6, 6);
		parent.popMatrix();
	}


	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

}
