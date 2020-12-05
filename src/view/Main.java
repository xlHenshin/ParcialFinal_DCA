package view;

import processing.core.PApplet;

public class Main extends PApplet{

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PApplet.main("view.Main");
	}
	
	private GameScreen gameScreen;
	private GameOver gameOver;
	private Sort sortScreen;
	
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
		gameScreen.pintar();
	}
}
