package space_wars;


import game_engine.GameObject;
import processing.core.PApplet;
import processing.core.PVector;

public class Ship extends GameObject {
	public PVector forceDir = new PVector(0, 0);
	public PVector velocity = new PVector(0, 0);

	public Ship(PApplet p) {
		super(p);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void render() {
		parent.stroke(255);
		parent.line(5, 10, 0, -10);
		parent.line(-5, 10, 0, -10);
		parent.line(5, 10, -5, +10);

	}

}
