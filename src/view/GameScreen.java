package view;

import controller.Controller;
import processing.core.PApplet;

public class GameScreen {

	private Controller controller;
	
	public GameScreen (PApplet app) {
		
		controller = new Controller(app);
	}
	
	public void pintar() {
		controller.pintar();
	}
}
