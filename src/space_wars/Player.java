package space_wars;

import processing.core.PApplet;
import game_engine.ProcessingInteractive;
import processing.core.PVector;

public class Player extends Ship implements ProcessingInteractive {
	public PVector size;
	public float speed = 5f;
	float speedDiagonal = 5f;
	private boolean upK = false;
	private boolean downK = false;
	private boolean leftK = false;
	private boolean rightK = false;
	public Player(PApplet p, float x, float y, float w, float h) {
		super(p);
		this.position = new PVector(x, y);
		this.size = new PVector(w, h);
		this.speedDiagonal = speed / 1.4f;
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		if( this.upK && this.rightK) {
			this.position.x += this.speedDiagonal;
			this.position.y += this.speedDiagonal;
		}else if (this.upK) {
			this.position.y -= speed;
		}else if (this.downK) {
			this.position.y += speed;
		} else if(this.leftK) {
			this.position.x -= speed;
		} else if(this.rightK) {
			this.position.x += speed;
		}
	}

	public void keyPressed(char key, int keyCode) {

		if (key == 'a' || key == 'A') {
			this.leftK = true;
		}
		if (key == 'd' || key == 'D') {
			this.rightK = true;
		}
		if (key == 'w' || key == 'W') {
			this.upK = true;
		}
		if (key == 's' || key == 'S') {
			this.downK = true;
		}

	}
	public void keyReleased(char key, int keyCode) {

		if (key == 'a' || key == 'A') {
			this.leftK = false;
		}
		if (key == 'd' || key == 'D') {
			this.rightK = false;
		}
		if (key == 'w' || key == 'W') {
			this.upK = false;
		}
		if (key == 's' || key == 'S') {
			this.downK = false;
		}

	}

	@Override
	public void render() {
		parent.pushMatrix();
		parent.translate(this.position.x, this.position.y);
		parent.rect(0, 0, this.size.x, this.size.y);
		parent.popMatrix();
	}
}
