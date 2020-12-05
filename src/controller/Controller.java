package controller;

import model.Logic;
import processing.core.PApplet;

public class Controller {

	private Logic logic;
	
	public Controller(PApplet app) {
		
		logic= new Logic(app);
	}
	
	public void paintCharacter() {
		
		logic.paintCharacter();
	}

	public void paintCar() {
		
		logic.paintCar();
	}
	
	public void paintStreet() {
		
		logic.paintStreet();
	}
	
	public void moveDown() {
		
		logic.moveDown();
	}
	
	public void moveLeft() {
		
		logic.moveLeft();
	}
	
	public void moveRight() {
		
		logic.moveRight();
	}
	
	public void ending() {
		
		logic.ending();
	}
	
	public void sortList(char key) {
		
		logic.sortList(key);
	}
	
	public void keyPressed(char key) {
		
		logic.keyPressed(key);
	}
	
	public void paintTime() {
		
		logic.paintTime();
	}
	
	public void paintInformation() {
		
		logic.paintInformation();
	}

}
