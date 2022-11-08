import java.awt.Graphics;
import java.awt.*;


public class Passenger implements Animateable {
	int age;
	boolean bag;
	int[][] seat = new int[1][2];
	int[][] position = new int [1][2];
	boolean in;
	boolean out;
	boolean left;
	boolean right;
	int aisle = 3;
	int groupSize;
	Passenger[] group;
	boolean grouped;
	boolean boarded;
	int wait;
	int bagWait;
	
	// Constructor
	public Passenger(int row, int col){
		seat[0][0] = row;
		seat[0][1] = col;
		if(seat[0][1]<aisle) left = true;
		if(seat[0][1]>aisle) right = true;
		in = out = grouped = bag = boarded =false;
		position[0][0] = 100; 
		wait = 0;
		
	}
	
	public boolean isSeated(){
		if (seat[0][0] == position[0][0] && seat[0][1]==position[0][1]) return true;
		else return false;
	}
	
	public boolean isBoarded(){
		if(boarded) return true;
		else return false;
	}
	
	public int getSeat(){
		return seat[0][1];
	}
	
	public boolean board(){
		position[0][0]=0;
		position[0][1]=aisle;
		boarded = true;
		return true;
	}
	
	public boolean moveAisle(){
		position[0][0]++;
		return true;
	}
	
	public boolean moveRowIn(){
		out = false;
		in = true;
		if(left){
			position[0][1]--;
			return true;}
		else{
			position[0][1]++;
			return true;
		}
	}
	
	public boolean moveRowOut(){
		in = false;
		out = true;
		if(left){
			position[0][1]++;
			return true;}
		else{
			position[0][1]--;
			return true;
		}
	}
	
	public boolean sit(){
		in = false;
		wait = 0;
		return true;
	}


	@Override
	public void render(Graphics g) {
		if(position[0][0]!=100){
			int x = (position[0][0]*20)+23;
			int y = (position[0][1])*30+57;
			if(isSeated()) g.setColor(Color.green.darker());
			else if(out) g.setColor(Color.red);
			else g.setColor(Color.black);
			g.fillOval(y, x, 15, 15);
			if(bag){
				g.setColor(Color.white);
				g.fillOval(y+4, x+4, 7, 7);
			}
		}
	}
	
	
	
	
	

}
