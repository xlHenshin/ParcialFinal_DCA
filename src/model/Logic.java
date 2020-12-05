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
		createCars();
		System.out.println("Autos= " + car.size());
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
		
		System.out.println("Autos creados con el txt= " + car.size());
	}
	
	public void createCars() {
		
		int dir;
		int posX;
		
		for (int i = 0; i < 3; i++) {
			
			dir=(int) app.random(-3,3);
			posX= (int) app.random(50,750);
			
			if(dir==0) {
				dir+=1;
			}
			
			car.add(new Car(dir, posX, 100, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(-3,3);
			posX= (int) app.random(50,750);
			
			if(dir==0) {
				dir+=1;
			}
			
			car.add(new Car(dir, posX, 200, app));
		}
		
		for (int i = 0; i < 3; i++) {
			
			dir=(int) app.random(-3,3);
			posX= (int) app.random(50,750);
			
			if(dir==0) {
				dir+=1;
			}
			
			car.add(new Car(dir, posX, 300, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(-3,3);
			posX= (int) app.random(50,750);
			
			if(dir==0) {
				dir+=1;
			}
			
			car.add(new Car(dir, posX, 400, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(-3,3);
			posX= (int) app.random(50,750);
			
			if(dir==0) {
				dir+=1;
			}
			
			car.add(new Car(dir, posX, 500, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(-3,3);
			posX= (int) app.random(50,750);
			
			if(dir==0) {
				dir+=1;
			}
			
			car.add(new Car(dir, posX, 600, app));
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
			Thread newCar = new Thread(car.get(i));
			newCar.start();
		}
		
		moveCar();
	}
	
	public void moveCar() {
		
		for (int i = 0; i < car.size(); i++) {
			
			car.get(i).move();
		}
	}
	
	public void paintStreet() {
		
		
		for (int i = 0; i < 6; i++) {
			
			app.fill(255);
			app.rect(400, (i*100)+100, 800, 50);
		}
		
		app.fill(0,0,255);
		app.rect(400, 650, 800, 50);
		
	}
	
	public void colition() {
		
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
