package game_engine;

import java.util.ArrayList;

import processing.core.PApplet;

public class GameManager {
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();
	private ArrayList<GameObject> playerGameObjects; // player list for attaching interactions like key press

	public PApplet parent; // The parent PApplet that we will render ourselves onto
    
    public GameManager(PApplet p){
        parent = p;
    }
    public void addObject(GameObject g) {
		gameObjects.add(g);
	}
    public void StartAll() {
    	for (int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			g.start();

		}
    }
    public void UpdateAll() {
    	for (int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			g.update();
			g.render();

		}
    }
    public void keyPressed(char key, int keyCode) {

		for (int i = 0; i < playerGameObjects.size(); i++) {
			// send key press to player
			GameObject g = playerGameObjects.get(i);
			g.keyPressed(key, keyCode);
		}

	}

	public void keyReleased(char key, int keyCode) {
		for (int i = 0; i < playerGameObjects.size(); i++) {
			// send key press to player
			GameObject g = playerGameObjects.get(i);
			g.keyReleased(key, keyCode);
		}

	}

	public void mousePressed() {
		for (int i = 0; i < playerGameObjects.size(); i++) {
			// send key press to player
			GameObject g = playerGameObjects.get(i);
			g.mousePressed();
		}
	}

	public void mouseClicked(int mouseX, int mouseY, int mouseButton) {
		for (int i = 0; i < playerGameObjects.size(); i++) {
			// send key press to player
			GameObject g = playerGameObjects.get(i);
			g.mouseClicked(mouseX,mouseY,mouseButton);
		}
	}
}
