import processing.core.PApplet;
import space_wars.SpaceWarLaunch;

public class Main extends PApplet {
	SpaceWarLaunch launcher;

	public static void main(String[] args) {
		PApplet.main("Main");
		
	}
	public void settings() {
		size(640, 480);
		launcher = new SpaceWarLaunch(this);
	}
	public void draw() {
		background(0);
		launcher.UpdateAll();
	}
	public void keyPressed() {
		launcher.keyPressed(key, keyCode);
	}

	public void keyReleased() {
		launcher.keyReleased(key, keyCode);
	}

	public void mousePressed() {
		launcher.mousePressed();
	}

}
