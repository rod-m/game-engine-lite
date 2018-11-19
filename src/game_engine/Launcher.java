package game_engine;

import processing.core.PApplet;

public abstract class Launcher implements ProcessingInteractive{
	public PApplet parent; // The parent PApplet that we will render ourselves onto
	public GameManager gameManager;

	public Launcher(PApplet p) {
		parent = p;
		gameManager = new GameManager(parent);
	}

	public abstract void StartGame();

	public void UpdateAll() {
		gameManager.UpdateAll();
	}

	

	
}
