package view;

import controller.Controller;
import processing.core.PApplet;

public class GameScreen {

	private Controller controller;
	
	public GameScreen (PApplet app) {
		
		controller = new Controller(app);
	}
	
	public void paintCharacter() {
		controller.paintCharacter();
	}

	public void paintCar() {
		
		controller.paintCar();
	}
	
	public void paintStreet() {
		
		controller.paintStreet();
	}
	
	public void moveDown() {
		
		controller.moveDown();
	}
	
	public void moveLeft() {
		
		controller.moveLeft();
	}
	
	public void moveRight() {
		
		controller.moveRight();
	}
	
	public void ending() {
		
		controller.ending();
	}
	
	public void sortList(char key) {
		
		controller.sortList(key);
	}
	
	public void keyPressed(char key) {
		
		controller.keyPressed(key);
	}
	
	public void paintTime() {
		
		controller.paintTime();
	}
	
	public void paintInformation() {
		
		controller.paintInformation();
	}
}
