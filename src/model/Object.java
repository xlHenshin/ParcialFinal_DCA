package model;

import processing.core.PApplet;

public abstract class Object {

	protected PApplet app;
	protected int dir, posX, posY;
	
	public Object(int dir, int posX, int posY, PApplet app) {
		
		this.dir=dir;
		this.posX=posX;
		this.posY=posY;
		this.app=app;
	}
	
	public abstract void paintObject();
	
	public abstract void move();

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}
	
	
}
