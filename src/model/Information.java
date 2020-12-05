package model;

import java.text.SimpleDateFormat;
import java.util.Date;

import processing.core.PApplet;

public class Information implements Comparable<Information>{

	private PApplet app;
	private Date date;
	private String time;
	private String date2;
	
	public Information(Date date, String time, PApplet app) {
	
		this.app=app;
		this.date=date;
		this.time=time;
		
		//date2 = date;
		SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		date2 = formato.format(date);
	}
	
	public void paintInformation(int x, int y) {
		
		app.fill(0);
		app.textSize(20);
		app.text("Press N to sort by date", 320, 20);
		app.text("Press P to sort by time", 320, 40);
		app.text("Press B to go back", 320, 60);
		app.text("Press R to restart", 320, 80);
		app.text("Date", 320, 120);
		app.text("Time", 520, 120);
		app.text(date2, x, y);
		app.text(time, x+ 50*4, y );
		
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate2() {
		return date2;
	}

	public void setDate2(String date2) {
		this.date2 = date2;
	}

	@Override
	public int compareTo(Information nextInfo) {
		// TODO Auto-generated method stub
		return this.date.compareTo(nextInfo.getDate());
		
	}
	
	
	
}
