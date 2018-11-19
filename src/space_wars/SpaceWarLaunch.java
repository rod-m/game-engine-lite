package space_wars;

import game_engine.Launcher;
import processing.core.PApplet;

public class SpaceWarLaunch extends Launcher {
	Player player;
	public SpaceWarLaunch(PApplet p) {
		super(p);
		StartGame();
	}

	@Override
	public void keyPressed(char key, int keyCode) {
		player.keyPressed(key, keyCode);

	}

	@Override
	public void keyReleased(char key, int keyCode) {
		// TODO Auto-generated method stub
		player.keyReleased(key, keyCode);
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
	public void StartGame() {
		player = new Player(parent, parent.width / 2, parent.height/2, 20,20);
		this.gameManager.addObject(player);
	}

}
