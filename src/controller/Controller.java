package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {

	private Logic logic;
	
	public Controller(PApplet app) {
		
		logic= new Logic(app);
	}
	
	public void pintar() {
		
		logic.pintar();
	}

}
