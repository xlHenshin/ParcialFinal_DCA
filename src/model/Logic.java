package model;

import java.util.ArrayList;

import exception.Lose;
import exception.Win;
import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private String [] file;
	private ArrayList<Car> car;
	private Character character;
	
	private int end;
	private boolean gameOver;
	
	public Logic (PApplet app) {
		
		this.app=app;
		file = app.loadStrings("../Resources/file.txt");
		car= new ArrayList<Car>();
		
		end=0;
		gameOver=false;
		
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
			
			dir=(int) app.random(1,3);
			posX= (int) app.random(50,750);
			
			car.add(new Car(dir, posX, 100, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(-3,-1);
			posX= (int) app.random(50,750);
			
			car.add(new Car(dir, posX, 200, app));
		}
		
		for (int i = 0; i < 3; i++) {
			
			dir=(int) app.random(-3,-1);
			posX= (int) app.random(50,750);
			
			car.add(new Car(dir, posX, 300, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(1,3);
			posX= (int) app.random(50,750);
			
			car.add(new Car(dir, posX, 400, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(-3,-1);
			posX= (int) app.random(50,750);
			
			car.add(new Car(dir, posX, 500, app));
		}
		
		for (int i = 0; i < 5; i++) {
			
			dir=(int) app.random(1,3);
			posX= (int) app.random(50,750);

			car.add(new Car(dir, posX, 600, app));
		}
	}
	
	public void paintCharacter() {
		
		character.paintObject();
		
		try {
			win();
		} catch (Win e) {
			// TODO Auto-generated catch block
			System.out.println("You Win");
			gameOver=true;
			end=1;
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

	public void paintCar() {
		
		for (int i = 0; i < car.size(); i++) {
			
			car.get(i).paintObject();
			Thread newCar = new Thread(car.get(i));
			newCar.start();
		}
		
		try {
			colition();
		} catch (Lose e) {
			// TODO Auto-generated catch block
			System.out.println("Game Over");
			gameOver=true;
			end=2;
			
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
	
	public void colition() throws Lose {
		
		for (int i = 0; i < car.size(); i++) {
			
			int posX1=car.get(i).getPosX();
			int posY1=car.get(i).getPosY();
			int posX2=character.getPosX();
			int posY2=character.getPosY();
			int size=50;
			
			if (PApplet.dist(posX1, posY1, posX2, posY2) < size) {
				
				throw new Lose("You Lose");
				//System.out.println("Game Over");
			}
		}
	}
	
	public void win() throws Win {
		
		if (character.getPosY()==650) {
			
			throw new Win ("You Win");
		}
	}
	
	public void ending() {
		
		switch (end) {
		case 1:
			
			app.fill(255);
			app.rect(400, 400, 800, 800);
			app.fill(0);
			app.textSize(40);
			app.text("You Win", 400, 400);
			app.text("Press R to reset", 400, 450);
			
			break;
			
		case 2:
			
			app.fill(255);
			app.rect(400, 400, 800, 800);
			app.fill(0);
			app.textSize(40);
			app.text("You Lose", 400, 400);
			app.text("Press R to reset", 400, 450);
			break;

		default:
			break;
		}
	}
	
	public void keyPressed(char key) {
		
		if (gameOver==true) {
			if (key =='r') {
				
				if (car.size()==0) {
					
					car.clear();
					end=0;
					gameOver=false;
					readTxt();
					createCars();
					
					
				} else {
					
					car.clear();
					end=0;
					gameOver=false;
					readTxt();
					createCars();
				}
			}
		}
	}
	
}
