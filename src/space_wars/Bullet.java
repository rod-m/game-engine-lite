package space_wars;

import game_engine.GameObject;
import game_engine.ProjectileInterface;
import game_engine.ShooterInterface;
import processing.core.PApplet;
import processing.core.PVector;

public class Bullet extends GameObject implements ProjectileInterface {
	public float speed = 12f;
	
	public PVector velocity = new PVector(0, -1);
	int lifespan = 25;
	
	public Bullet(PApplet p) {
		super(p);
		this.size.x = 6;
		this.size.y = 6;
	}

	public void ShootIt(ShooterInterface shooter) {
		this.position = shooter.GetFrom();
		this.velocity = shooter.GetDir();
		this.velocity.setMag(this.speed);
	}
	@Override
	public void update() {
		// bullet moves in same direction as ship
		this.position.add(this.velocity);
		if (lifespan > 0) {
			lifespan--;
		} else {
			// this will also get destroyed ~ set to null
			this.gameManager.destroyGameObject(this);
		
		}
		collisionCheck();
		
	}
	 private void collisionCheck() {
	    	// update and render all game objects
	    	for (int i = 0; i < this.gameManager.getGameObjects().size(); i++) {
				GameObject g = this.gameManager.getGameObjects().get(i);
				if(g.hitAble) {
					
					float dist = this.position.dist(g.position);
					//parent.println("d= "+dist);
					if(dist < (this.size.x * 2f + g.size.x * 2f)) {
						this.gameManager.destroyGameObject(g);
					}
				}
				
			}
	    }
	@Override
	public void render() {
		parent.pushMatrix();
		parent.translate(this.position.x, this.position.y);
		parent.fill(0, 255, 0);
		parent.ellipse(0, 0, this.size.x, this.size.y);
		parent.popMatrix();
	}


	@Override
	public void start() {
		// TODO Auto-generated method stub
		
	}

}
