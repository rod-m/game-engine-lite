package game_engine;

import java.util.ArrayList;

import processing.core.PApplet;

public class GameManager {
	private ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

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
    	// update and render all game objects
    	for (int i = 0; i < gameObjects.size(); i++) {
			GameObject g = gameObjects.get(i);
			g.update();
			g.render();
		}
    }
  
}
