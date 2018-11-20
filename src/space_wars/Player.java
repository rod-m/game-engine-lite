package space_wars;

import processing.core.PApplet;
import game_engine.ProcessingInteractive;
import game_engine.ShooterInterface;
import processing.core.PVector;

public class Player extends Ship implements ProcessingInteractive, ShooterInterface {
	
	public float acceleration = 1.2f;
	public float friction = 0.85f;
	public float maxSpeed = 5f;
	float heading = PApplet.TWO_PI;
	private boolean upK = false;
	private boolean downK = false;
	private boolean leftK = false;
	private boolean rightK = false;

	public Player(PApplet p, float x, float y, float w, float h) {
		super(p);
		this.position = new PVector(x, y);
		this.size.x = w;
		this.size.y = h;
	}

	@Override
	public void start() {

	}

	@Override
	public void update() {
		this.forceDir = new PVector(0, 0);
		if (this.upK) {
			this.forceDir.y = -1f;
		} else if (this.downK) {
			this.forceDir.y = 1f;
		}
		if (this.leftK) {
			this.forceDir.x = -1f;
		} else if (this.rightK) {
			this.forceDir.x = 1f;
		}
		// keep speed uniform if on an angle
		this.forceDir.setMag(this.acceleration);

		if (this.velocity.mag() < this.maxSpeed) {
			this.velocity.add(this.forceDir);

		}
		this.position.add(this.velocity);
		this.velocity.mult(this.friction); // slow down rate
		this.heading = this.velocity.heading() + PApplet.HALF_PI;
	}

	/*
	 * using boolean vars for key pressed allows for multi key diagonal directions
	 */
	public void keyPressed(char key, int keyCode) {
		// parent.println("velocity "+ this.velocity.toString());
		// parent.println("forceDir "+ this.forceDir.toString());
		if (keyCode == PApplet.LEFT) {
			this.leftK = true;
		}
		if (keyCode == PApplet.RIGHT) {
			this.rightK = true;
		}
		if (keyCode == PApplet.UP) {
			this.upK = true;
		}
		if (keyCode == PApplet.DOWN) {
			this.downK = true;
		}
		if(key == ' ') {
			//parent.println("Fire ");
			Bullet bullet = new Bullet(parent);
			bullet.ShootIt(this);
			this.gameManager.addObject(bullet);
		}
	}

	public void keyReleased(char key, int keyCode) {
		/* boolean key down switched off when key released! */
		if (keyCode == PApplet.LEFT) {
			this.leftK = false;
		}
		if (keyCode == PApplet.RIGHT) {
			this.rightK = false;
		}
		if (keyCode == PApplet.UP) {
			this.upK = false;
		}
		if (keyCode == PApplet.DOWN) {
			this.downK = false;
		}

	}

	@Override
	public void render() {
		parent.pushMatrix();
		parent.translate(this.position.x, this.position.y);
		parent.rotate(this.heading);
		super.render();
		parent.popMatrix();
	}

	@Override
	public void mousePressed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PVector GetDir() {
		// returns direction player is facing
		PVector dir = new PVector(0,-1);
		dir.rotate(this.heading);
		return dir;
	}

	@Override
	public PVector GetFrom() {
		// returns player current position
		return this.position.copy();
	}
}
