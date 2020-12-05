package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;

import exception.Lose;
import exception.Win;
import processing.core.PApplet;

public class Logic {

	private PApplet app;
	
	private String [] file;
	private ArrayList<Car> car;
	private LinkedList<Information> information;
	private Character character;
	private SortTime sortTime;
	
	private int end;
	private boolean gameOver;
	private boolean win, lose;
	private boolean time;
	private boolean showRegister;
	private int seg,min;
	
	public Logic (PApplet app) {
		
		this.app=app;
		file = app.loadStrings("../Resources/file.txt");
		car= new ArrayList<Car>();
		information= new LinkedList<Information>();
		sortTime= new SortTime();
		
		end=0;
		gameOver=false;
		win=false;
		lose=false;
		time=true;
		showRegister=false;
		seg=0;
		min=0;
		
		try {
			readTxt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
		
		createCars();
	}
	
	public void readTxt() {
		
		for (int i = 0; i < file.length; i++) {
			
			String items = file[i];
			
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
		
		System.out.println("Autos= " + car.size());
	}
	
	public void paintCharacter() {
		
		character.paintObject();
		
		try {
			win();
		} catch (Win e) {
			// TODO Auto-generated catch block
			System.out.println("You Win");
			win=true;
			gameOver=true;
			end=1;
			time=false;
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
			lose=true;
			gameOver=true;
			end=2;
			time=false;
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
	
	public void paintTime() {
		
		if (time==true) {
			
			if (app.frameCount % 60 == 0) {
				seg += 1;
			}
			if (seg == 60) {
				seg = 0;
				min += 1;
			}
		}
		
		app.textSize(40);
		app.text("Time: "+ min + ":" + seg, 400, 750);
	}
	
	public void colition() throws Lose {
		
		for (int i = 0; i < car.size(); i++) {
			
			int posX1=car.get(i).getPosX();
			int posY1=car.get(i).getPosY();
			int posX2=character.getPosX();
			int posY2=character.getPosY();
			int size=50;
			
			if (PApplet.dist(posX1, posY1, posX2, posY2) < size) {
				
				if (lose==false && win==false) {
					
					String m= Integer.toString(min);
					String s= Integer.toString(seg);
					String time = m+":"+s;
					Date date = new Date();
					
					information.add(new Information(date, time, app));
					
					throw new Lose("You Lose");
				}
				
			}
		}
	}
	
	public void win() throws Win {
		
		if (character.getPosY()==650) {
		
			if (lose==false && win==false) {
				
				String m= Integer.toString(min);
				String s= Integer.toString(seg);
				String time = m+":"+s;
				Date date = new Date();

				information.add(new Information(date, time, app));
				
				throw new Win ("You Win");
			}
			
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
			app.text("Press O to view the records", 400, 500);
			
			break;
			
		case 2:
			
			app.fill(255);
			app.rect(400, 400, 800, 800);
			app.fill(0);
			app.textSize(40);
			app.text("You Lose", 400, 400);
			app.text("Press R to reset", 400, 450);
			app.text("Press O to view the records", 400, 500);
			break;

		default:
			break;
		}
	}
	
	public void paintInformation() {
		
		if (showRegister==true) {
			
			app.fill(255);
			app.rect(400, 400, 800, 800);
			
			
			for (int i = 0; i < information.size(); i++) {
				
				information.get(i).paintInformation(320, 150+(20*i));
			}
		}
		
	}
	
	public void sortList(char key) {
		
		if (showRegister==true) {
			
			switch (key) {
			case 'n':
				
				Collections.sort(information);
				
				break;
				
			case 'p':
				
				Collections.sort(information, sortTime);
				
				break;

			default:
				break;
			}
		}
	}
	
	public void keyPressed(char key) {
		
		if (gameOver==true) {
			if (key =='r') {
				
				car.clear();
				end=0;
				gameOver=false;
				
				try {
					readTxt();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					throw new RuntimeException();
				}
				
				createCars();
				win=false;
				lose=false;
				min=0;
				seg=0;
				time=true;
				showRegister=false;
			}
			
			if (key == 'o') {
				
				showRegister=true;
			}
			
			if (key == 'b') {
				
				showRegister=false;
			}
			
			
		}
	}

	public LinkedList<Information> getInformation() {
		return information;
	}

	public void setInformation(LinkedList<Information> information) {
		this.information = information;
	}
	
	
	
}
