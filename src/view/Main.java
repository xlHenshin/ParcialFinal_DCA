package view;

import processing.core.PApplet;

public class Main extends PApplet{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main("view.Main");
	}
	
	private GameScreen gameScreen;
	
	public void settings() {
		
		size(800, 800);
	}
	
	public void setup() {
		
		gameScreen = new GameScreen(this);
		//sortScreen = new Sort(this);
	}
	
	public void draw() {
		
		background(0);
		rectMode(CENTER);
		textAlign(CENTER);
		
		gameScreen.paintStreet();
		gameScreen.paintCharacter();
		gameScreen.paintCar();
		gameScreen.paintTime();
		gameScreen.ending();
		gameScreen.paintInformation();
	}
	
	public void keyPressed() {
		
		gameScreen.keyPressed(key);
		gameScreen.sortList(key);
		
		if(keyCode == RIGHT) {
			
			gameScreen.moveRight();
		}
		if(keyCode == LEFT) {
			
			gameScreen.moveLeft();
		}
		
		if(keyCode == DOWN) {
			
			gameScreen.moveDown();
		}
	}
}
