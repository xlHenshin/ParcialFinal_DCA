package model;

import processing.core.PApplet;

public class Car extends Object implements Runnable{

	public Car(int dir, int posX, int posY, PApplet app) {
		super(dir, posX, posY, app);
		// TODO Auto-generated constructor stub
	}


	public void paintObject() {
		
		app.fill(255,0,0);
		app.rect(posX, posY, 100, 50);
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
