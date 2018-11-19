package game_engine;

public interface ProcessingInteractive {
	public void keyPressed(char key, int keyCode);
	public void keyReleased(char key, int keyCode);

	public void mousePressed();

	public void mouseClicked(int mouseX, int mouseY, int mouseButton);
}
