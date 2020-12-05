package model;

import java.util.ArrayList;

import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private String [] file;
	private ArrayList<Car> car;
	private Character character;
	
	public Logic (PApplet app) {
		
		this.app=app;
		file = app.loadStrings("../Resources/file.txt");
		car= new ArrayList<Car>();
		readTxt();
	}
	
	public void readTxt() {
		
		for (int i = 0; i < file.length; i++) {
			
			String items = file[i];
			System.out.println(items);
			
			String [] data = file[i].split(",");
			
			String type = data[0]; 
			int dir = Integer.parseInt(data[1]);
			int posX = Integer.parseInt(data[2]);
			int posY = Integer.parseInt(data[3]);
			
			if (type.equals("personaje")) {
				
				character= new Character(dir, posX, posY, app);
			}
			
			if (type.equals("carro")) {
				
				car.add(new Car(dir, posX, posY, app));
			}
		}
		
		System.out.println(car.size());
	}
	
	public void createCars() {
		
		int random;
		
		for (int i = 0; i < 26; i++) {
			
			random = (int) app.random(1,6);
			
			
		}
	}
	
	public void paintCharacter() {
		
		character.paintObject();
	}
	
	public void pintar() {
		
		app.fill(255);
		app.rect(400, 400, 200, 200);
	}

	public void paintCar() {
		
		for (int i = 0; i < car.size(); i++) {
			
			car.get(i).paintObject();
		}
	}
	
	public void paintStreet() {
		
		
		for (int i = 0; i < 6; i++) {
			
			app.fill(255);
			app.rect(400, (i*100)+100, 800, 50);
		}
		
	}
	
	public void moveDown() {
		
		character.move();
	}
	
	public void moveLeft() {
		
		character.moveLeft();
	}
	
	public void moveRight() {
		
		character.moveRight();
	}
	
}
