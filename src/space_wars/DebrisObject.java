package space_wars;

import game_engine.GameObject;
import processing.core.PApplet;
import processing.core.PVector;

public class DebrisObject extends GameObject {
	public PVector size;
	public PVector velocity = new PVector(0, -1);
	public float speed = 1.1f;
	public DebrisObject(PApplet p) {
		super(p);
		this.size = new PVector(20,20);
		this.start();
	}

	@Override
	public void start() {
		this.hitAble = true;
		this.position = new PVector(parent.random(parent.width), parent.random(parent.height));
		this.velocity.rotate(parent.random(PApplet.TWO_PI));
		this.velocity.setMag(this.speed);
	}

	@Override
	public void update() {
		this.position.add(this.velocity);
		if(this.position.x < -this.size.x ) {
			this.position.x = parent.width;
		}
		if(this.position.x >( parent.width +this.size.x)) {
			this.position.x = 0f;
		}
		if(this.position.y < -this.size.y  ) {
			this.position.y = parent.height;
			this.velocity.rotate(parent.random(PApplet.TWO_PI));
		}
		if(this.position.y > ( parent.height + this.size.y)) {
			this.position.y = 0f;
		}
	}

	@Override
	public void render() {
		parent.pushMatrix();
		parent.translate(this.position.x, this.position.y);
		parent.fill(255);
		parent.ellipse(0, 0, this.size.x, this.size.y);
		parent.popMatrix();
	}

}
