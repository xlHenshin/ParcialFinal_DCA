package model;

import processing.core.PApplet;

public class Character extends Object{

	public Character(int dir, int posX, int posY, PApplet app) {
		super(dir, posX, posY, app);
		// TODO Auto-generated constructor stub
	}

	
	public void paintObject() {
		
		app.fill(0,255,0);
		app.ellipse(posX, posY, 50, 50);
	}


	public void move() {
		
		posY+= 50;
	}
	
	public void moveLeft() {
		
		posX-= 50;
	}
	
	public void moveRight() {
		
		posX+= 50;
	}

}
