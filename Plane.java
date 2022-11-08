import java.util.Random;
import java.awt.event.*;

public class Plane extends KeyAdapter {
	Passenger[] passengers; // array of passengers in the plane
	Position[][] positions; // array of positions in the plane
	BoardingMethod method; // boarding method orders passengers
	PlaneEngine engine;
	int numBoarded;
	int numSeated;
	boolean boarded; // true is plane is fully boarded
	int seatsPerRow = 6;
	int numRows = 26;
	int numSeats = 150;
	int numFirstClass = 12;
	int aisle = 3; // position of aisle within plane
	int numBagsTotal = 0;
	int bagCapacity = 75;
	int time = 0;
	int initialWait = 0;

	// Constructor
	public Plane(Passenger[] p, BoardingMethod b) {
		passengers = p; // takes passenger array as input
		method = b; // takes boarding method as input
		positions = new Position[numRows][7]; // create position array
		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < 7; j++) {
				positions[i][j] = new Position(i, j);
			} // creates new position at each point in the plane configuration
		}
		numBoarded = 0; // no one boarded
		numSeated = 0; // no passenger seated
		boarded = false; // plane is not boarded

	}

	public void firstClassPassengers() {
		Passenger[] p1 = new Passenger[numSeats];
		int p = 0;
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i].seat[0][0] < 2) {
				p1[p] = passengers[i];
				passengers[i] = null;
				p++;
			}
		}
		int s = 0;
		while (p < p1.length) {
			if (passengers[s] != null) {
				p1[p] = passengers[s];
				p++;
			}
			s++;
		}
		passengers = p1;

	}

	public int getNumBoarded() {
		numBoarded = 0;
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i].isBoarded() == true) {
				numBoarded++;
			}
		}
		return numBoarded;
	}

	public int getNumSeated() {
		numSeated = 0;
		for (int i = 0; i < passengers.length; i++) {
			if (passengers[i].isSeated() == true) {
				numSeated++;
			}
		}
		return numSeated;
	}

	public boolean isBoarded() {
		boarded = false;
		if (getNumSeated() == passengers.length) {
			boarded = true;
			// engine.boarded = true;
		}
		return boarded;
	}

	public void passSits(int row) {
		Passenger pass = positions[row][aisle].p;
		int seat = pass.getSeat();
		pass.sit();
		pass.wait = 0;
		positions[row][seat].p = pass;
		positions[row][seat].occupied = true;
		positions[row][aisle].p = null;
		positions[row][aisle].occupied = false;
	}

	public void passMovesRowIn(int row, int col) {
		Passenger pass = positions[row][col].p;
		if(pass.wait == 0){
			pass.moveRowIn();
			if (pass.left && !positions[row][col - 1].occupied) {
				positions[row][col - 1].p = pass;
				positions[row][col - 1].occupied = true;
			} else if(pass.right && !positions[row][col+1].occupied){
				positions[row][col + 1].p = pass;
				positions[row][col + 1].occupied = true;
			}
			positions[row][col].p = null;
			positions[row][col].occupied = false;
			
			if (col == aisle && positions[row][col].second != null) {
				positions[row][col].p = positions[row][col].second;
				positions[row][col].second = positions[row][col].third;
				positions[row][col].third = null;
				positions[row][col].occupied = true;
			}
			
			if (pass.position[0][1] == pass.seat[0][1]){ pass.sit();}
			else{ pass.wait = getMoveWaitTime();}
		}
		else if(pass.wait>0) pass.wait--;
	}

	public void passMovesRowOut(int row, int col) {
		if (!positions[row][col].occupied)
			return;
		Passenger pass = positions[row][col].p;
		if(pass.wait == 0){
			pass.moveRowOut();
			pass.out = true;
			if (pass.left) {
				if (positions[row][col + 1].occupied && (col + 1) == aisle) {
					if (positions[row][col + 1].second == null){
						positions[row][col + 1].second = pass;}
					else{
						positions[row][col + 1].third = pass;}
					positions[row][col].p = null;
					positions[row][col].occupied = false;
				} 
				else if (!positions[row][col - 1].occupied){
					positions[row][col + 1].p = pass;
					positions[row][col + 1].occupied = true;
					positions[row][col].p = null;
					positions[row][col].occupied = false;
				}
				else if(positions[row][col +1].occupied){
					if(pass.wait>0) pass.wait --;}
			} else {
				if (positions[row][col - 1].occupied && (col - 1) == aisle) {
					if (positions[row][col - 1].second == null){
						positions[row][col - 1].second = pass;
						}
					else{
						positions[row][col - 1].third = pass;
						}
					positions[row][col].p = null;
					positions[row][col].occupied = false;
				} else if(!positions[row][col - 1].occupied){
					positions[row][col - 1].p = pass;
					positions[row][col - 1].occupied = true;
					positions[row][col].p = null;
					positions[row][col].occupied = false;
				}
				else if (positions[row][col - 1].occupied){
					if(pass.wait>0) pass.wait--;
				}
			}
			pass.wait = getMoveWaitTime();
		}
		else if(pass.wait>0) pass.wait--;
	}

	public void passMovesAisle(int row) {
		Passenger pass = positions[row][aisle].p;
		if(pass.wait == 0){
			pass.moveAisle();
			positions[row + 1][aisle].p = pass;
			positions[row + 1][aisle].occupied = true;
			positions[row][aisle].p = null;
			positions[row][aisle].occupied = false;
			pass.wait = getMoveWaitTime();
		}
		else if(pass.wait>0) pass.wait--;
	}

	public boolean boardNew() {
		if (numBoarded < passengers.length) {
			Passenger pass = passengers[numBoarded];
			if (pass.bag)
				numBagsTotal++;
			if (numBagsTotal < bagCapacity || !pass.bag) {
				numBoarded++;
				pass.board();
				positions[0][aisle].p = pass;
				positions[0][aisle].occupied = true;
			} 
			else{
				if(pass.bagWait == 0){
					pass.bag = false;
				}
				else{
					pass.bagWait--;
				}
			}
			if(numBagsTotal == 50){
				for(int x = numBoarded; x<numSeats; x++){
					passengers[x].bagWait = passengers[x].bagWait +5;
				}
			}
			if(numBagsTotal == bagCapacity-1){
				for(int x = numBoarded; x<numSeats; x++){
					passengers[x].bagWait = passengers[x].bagWait -5;
					if(passengers[x].bagWait<0) passengers[x].bagWait = 0;
				}
			}
				
			return true;
		} else
			return false;
	}

	public boolean isRowEmpty(int r, Passenger p) {
		if (p.left) {
			for (int i = 0; i < aisle; i++) {
				if (positions[r][i].occupied)
					return false;
			}
			return true;
		} else {
			for (int i = aisle + 1; i < 7; i++) {
				if (positions[r][i].occupied)
					return false;
			}
			return true;
		}
	}

	public void displayPositions() {
		for (int i = 0; i < numRows; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < 7; j++) {
				if (j == 3) {
					if (positions[i][j].third != null)
						System.out.print(3 + " ");
					else if (positions[i][j].second != null)
						System.out.print(2 + " ");
					else if (positions[i][j].p != null)
						System.out.print(1 + " ");
					else
						System.out.print(0 + " ");
				} else
					System.out.print(j + " " + positions[i][j].occupied + " ");
			}
			System.out.println();
		}
	}

	public void arrangeGroups() {
		Passenger[][] seats = new Passenger[numRows][seatsPerRow];

		int pGroup1 = 810;
		int pGroup2 = 931;
		int pGroup3 = 952;
		int pGroup4 = 979;
		int pGroup5 = 989;
		int pGroup6 = 1000;
		Random rand = new Random();

		for (int i = numFirstClass; i < numSeats; i++) {
			int r = passengers[i].seat[0][0];
			int c = passengers[i].seat[0][1];
			if (c > 3)
				c--;
			seats[r][c] = passengers[i];
		}
		Passenger[] passBySeats = new Passenger[numSeats - numFirstClass];
		int p = 0;
		for (int a = 3; a < numRows; a++) {
			for (int b = 0; b < seatsPerRow; b++) {
				passBySeats[p] = seats[a][b];
				p++;
			}
		}
		int sum = 0;
		for (int c = 0; c < (numSeats - numFirstClass);) {
			int n = rand.nextInt(1000);
			int groupNum = 0;
			if (n < pGroup1)
				groupNum = 1;
			else if (n < pGroup2)
				groupNum = 2;
			else if (n < pGroup3)
				groupNum = 3;
			else if (n < pGroup4)
				groupNum = 4;
			else if (n < pGroup5)
				groupNum = 5;
			else if (n < pGroup6)
				groupNum = 6;
			if ((groupNum + c) <= (numSeats - numFirstClass)) {
				sum = sum + groupNum;
				//System.out.println(passBySeats[c].seat[0][0] + "," + passBySeats[c].seat[0][1]);
				passBySeats[c].groupSize = groupNum;
				Passenger[] g = new Passenger[groupNum];
				g[0] = passBySeats[c];
				passBySeats[c].group = g;
				for (int d = 1; d < groupNum; d++) {
					passBySeats[c + d].groupSize = groupNum;
					g[d] = passBySeats[c + d];
					passBySeats[c + d].group = g;
				}
				c = c + groupNum;
			}
		}
		Passenger[] p1 = new Passenger[numSeats];
		int f;
		for (f = 0; f < numFirstClass; f++) {
			p1[f] = passengers[f];
			p1[f].groupSize = 1;
		}
		for (int g = numFirstClass; g < numSeats; f++) {
			Passenger current = passengers[f];
			int num = 0;
			if (!current.grouped) {
				num = current.groupSize;
				for (int h = 0; h < num; h++) {
					p1[g + h] = current.group[h];
					current.group[h].grouped = true;
				}
			}
			g = g + num;
		}
		passengers = p1;
	}
	
	public void arrangeBusinessGroups() {
		Passenger[][] seats = new Passenger[numRows][seatsPerRow];

		int pGroup1 = 950;
		int pGroup2 = 960;
		int pGroup3 = 970;
		int pGroup4 = 980;
		int pGroup5 = 990;
		int pGroup6 = 1000;
		Random rand = new Random();

		for (int i = numFirstClass; i < numSeats; i++) {
			int r = passengers[i].seat[0][0];
			int c = passengers[i].seat[0][1];
			if (c > 3)
				c--;
			seats[r][c] = passengers[i];
		}
		Passenger[] passBySeats = new Passenger[numSeats - numFirstClass];
		int p = 0;
		for (int a = 3; a < numRows; a++) {
			for (int b = 0; b < seatsPerRow; b++) {
				passBySeats[p] = seats[a][b];
				p++;
			}
		}
		int sum = 0;
		for (int c = 0; c < (numSeats - numFirstClass);) {
			int n = rand.nextInt(1000);
			int groupNum = 0;
			if (n < pGroup1)
				groupNum = 1;
			else if (n < pGroup2)
				groupNum = 2;
			else if (n < pGroup3)
				groupNum = 3;
			else if (n < pGroup4)
				groupNum = 4;
			else if (n < pGroup5)
				groupNum = 5;
			else if (n < pGroup6)
				groupNum = 6;
			if ((groupNum + c) <= (numSeats - numFirstClass)) {
				sum = sum + groupNum;
				//System.out.println(passBySeats[c].seat[0][0] + "," + passBySeats[c].seat[0][1]);
				passBySeats[c].groupSize = groupNum;
				Passenger[] g = new Passenger[groupNum];
				g[0] = passBySeats[c];
				passBySeats[c].group = g;
				for (int d = 1; d < groupNum; d++) {
					passBySeats[c + d].groupSize = groupNum;
					g[d] = passBySeats[c + d];
					passBySeats[c + d].group = g;
				}
				c = c + groupNum;
			}
		}
		Passenger[] p1 = new Passenger[numSeats];
		int f;
		for (f = 0; f < numFirstClass; f++) {
			p1[f] = passengers[f];
			p1[f].groupSize = 1;
		}
		for (int g = numFirstClass; g < numSeats; f++) {
			Passenger current = passengers[f];
			int num = 0;
			if (!current.grouped) {
				num = current.groupSize;
				for (int h = 0; h < num; h++) {
					p1[g + h] = current.group[h];
					current.group[h].grouped = true;
				}
			}
			g = g + num;
		}
		passengers = p1;
	}
	
	public void arrangeFamilyGroups() {
		Passenger[][] seats = new Passenger[numRows][seatsPerRow];

		int pGroup1 = 300;
		int pGroup2 = 500;
		int pGroup3 = 700;
		int pGroup4 = 800;
		int pGroup5 = 900;
		int pGroup6 = 1000;
		Random rand = new Random();

		for (int i = numFirstClass; i < numSeats; i++) {
			int r = passengers[i].seat[0][0];
			int c = passengers[i].seat[0][1];
			if (c > 3)
				c--;
			seats[r][c] = passengers[i];
		}
		Passenger[] passBySeats = new Passenger[numSeats - numFirstClass];
		int p = 0;
		for (int a = 3; a < numRows; a++) {
			for (int b = 0; b < seatsPerRow; b++) {
				passBySeats[p] = seats[a][b];
				p++;
			}
		}
		int sum = 0;
		for (int c = 0; c < (numSeats - numFirstClass);) {
			int n = rand.nextInt(1000);
			int groupNum = 0;
			if (n < pGroup1)
				groupNum = 1;
			else if (n < pGroup2)
				groupNum = 2;
			else if (n < pGroup3)
				groupNum = 3;
			else if (n < pGroup4)
				groupNum = 4;
			else if (n < pGroup5)
				groupNum = 5;
			else if (n < pGroup6)
				groupNum = 6;
			if ((groupNum + c) <= (numSeats - numFirstClass)) {
				sum = sum + groupNum;
				//System.out.println(passBySeats[c].seat[0][0] + "," + passBySeats[c].seat[0][1]);
				passBySeats[c].groupSize = groupNum;
				Passenger[] g = new Passenger[groupNum];
				g[0] = passBySeats[c];
				passBySeats[c].group = g;
				for (int d = 1; d < groupNum; d++) {
					passBySeats[c + d].groupSize = groupNum;
					g[d] = passBySeats[c + d];
					passBySeats[c + d].group = g;
				}
				c = c + groupNum;
			}
		}
		Passenger[] p1 = new Passenger[numSeats];
		int f;
		for (f = 0; f < numFirstClass; f++) {
			p1[f] = passengers[f];
			p1[f].groupSize = 1;
		}
		for (int g = numFirstClass; g < numSeats; f++) {
			Passenger current = passengers[f];
			int num = 0;
			if (!current.grouped) {
				num = current.groupSize;
				for (int h = 0; h < num; h++) {
					p1[g + h] = current.group[h];
					current.group[h].grouped = true;
				}
			}
			g = g + num;
		}
		passengers = p1;
	}
	public int getMoveWaitTime(){
		Random r = new Random();
		double mean = 2.04;
		double sd = 1.04;
		int wait = (int) (Math.round(r.nextGaussian()*sd + mean));
		if(wait<0) wait = 0;
		return wait;
	}
	
	public int getBagStowTime(){
		Random r = new Random();
		double mean = 11.67;
		double sd = 13.23;
		int wait = (int) (Math.round(r.nextGaussian()*sd + mean));
		if(wait<0) wait = 0;
		return wait;
	}

	public void getBags() {
		int pGroup1Bag0 = 20;
		int pGroup1Bag1 = 100;

		int pGroup2Bag0 = 17;
		int pGroup2Bag1 = 64;
		int pGroup2Bag2 = 100;

		int pGroup3Bag0 = 13;
		int pGroup3Bag1 = 59;
		int pGroup3Bag2 = 93;
		int pGroup3Bag3 = 100;

		int pGroup4Bag0 = 7;
		int pGroup4Bag1 = 38;
		int pGroup4Bag2 = 79;
		int pGroup4Bag3 = 94;
		int pGroup4Bag4 = 100;

		int pGroup5Bag0 = 5;
		int pGroup5Bag1 = 23;
		int pGroup5Bag2 = 50;
		int pGroup5Bag3 = 77;
		int pGroup5Bag4 = 95;
		int pGroup5Bag5 = 100;

		int pGroup6Bag1 = 25;
		int pGroup6Bag2 = 50;
		int pGroup6Bag3 = 75;
		int pGroup6Bag4 = 100;
		
		Random rand = new Random();

		for (int i = 0; i < passengers.length;) {
			Passenger current = passengers[i];
			int groupNum = current.groupSize;
			int numBags = 0;
			int n = rand.nextInt(100);
			if (groupNum == 1) {
				if (n < pGroup1Bag0)
					numBags = 0;
				else if (n < pGroup1Bag1)
					numBags = 1;
			} else if (groupNum == 2) {
				if (n < pGroup2Bag0)
					numBags = 0;
				else if (n < pGroup2Bag1)
					numBags = 1;
				else if (n < pGroup2Bag2)
					numBags = 2;

			} else if (groupNum == 3) {
				if (n < pGroup3Bag0)
					numBags = 0;
				else if (n < pGroup3Bag1)
					numBags = 1;
				else if (n < pGroup3Bag2)
					numBags = 2;
				else if (n < pGroup3Bag3)
					numBags = 3;
			} else if (groupNum == 4) {
				if (n < pGroup4Bag0)
					numBags = 0;
				else if (n < pGroup4Bag1)
					numBags = 1;
				else if (n < pGroup4Bag2)
					numBags = 2;
				else if (n < pGroup4Bag3)
					numBags = 3;
				else if (n < pGroup4Bag4)
					numBags = 4;
			} else if (groupNum == 5) {
				if (n < pGroup5Bag0)
					numBags = 0;
				else if (n < pGroup5Bag1)
					numBags = 1;
				else if (n < pGroup5Bag2)
					numBags = 2;
				else if (n < pGroup5Bag3)
					numBags = 3;
				else if (n < pGroup5Bag4)
					numBags = 4;
				else if (n < pGroup5Bag5)
					numBags = 5;
			} else if (groupNum == 6) {
				if (n < pGroup6Bag1)
					numBags = 1;
				else if (n < pGroup6Bag2)
					numBags = 2;
				else if (n < pGroup6Bag3)
					numBags = 3;
				else if (n < pGroup6Bag4)
					numBags = 4;
			}
			// System.out.println("Group Size = " + groupNum);
			// System.out.println("Num Bags = "+ numBags);
			for (int j = 0; j < numBags; j++) {
				passengers[i + j].bag = true;
				passengers[i + j].bagWait = getBagStowTime();
			}
			i = i + groupNum;
		}
		
		// pre boarding gate checking
		int x = rand.nextInt(7)+3;
		for(int y = 0; y<=x; y++){
			int s = rand.nextInt(numSeats);
			Passenger current = passengers[s];
			current.bag = false;
			current.bagWait = 0;
		}
		
	}
	
	public void pullNoBagsUp(){
		Passenger[] p1 = new Passenger[numSeats];
		int p = 0;
		for (int i = 0; i < passengers.length; i++) {
			if (!passengers[i].bag) {
				p1[p] = passengers[i];
				passengers[i] = null;
				p++;
			}
		}
		int s = 0;
		while (p < p1.length) {
			if (passengers[s] != null) {
				p1[p] = passengers[s];
				p++;
			}
			s++;
		}
		passengers = p1;

	}
		
	

	public void iterate() {
		if(initialWait ==0){
		if (boarded == false) { // plane is not boarded
			for (int row = numRows - 1; row >= 0; row--) { // for each row of
															// plane
				for (int i = 1; i < aisle; i++) {
					if (positions[row][i].occupied && i != aisle) {
						if (positions[row][i].p.in)
							passMovesRowIn(row, i);
					}
				}
				for (int i = 5; i > aisle; i--) {
					if (positions[row][i].occupied && i != aisle) {
						if (positions[row][i].p.in)
							passMovesRowIn(row, i);
					}
				}
				Position current = positions[row][aisle];
				if (current.occupied == true) {
					Passenger pass = current.p;
					if (pass.seat[0][0] == row) {
						if (pass.bag){
							if(pass.bagWait==0) pass.bag = false;
							else pass.bagWait --;
						}
						else if (isRowEmpty(row, pass))
							passMovesRowIn(row, aisle);
						else if (pass.seat[0][1] == 2)
							passMovesRowIn(row, aisle);
						else if (pass.seat[0][1] == 1 && !positions[row][2].isOccupied())
							passMovesRowIn(row, aisle);
						else if (pass.seat[0][1] == 4)
							passMovesRowIn(row, aisle);
						else if (pass.seat[0][1] == 5 && !positions[row][4].isOccupied())
							passMovesRowIn(row, aisle);
						else { // there is an seat interference
							if (pass.left) {
								passMovesRowOut(row, 2);
								passMovesRowOut(row, 1);
							} else {
								passMovesRowOut(row, 4);
								passMovesRowOut(row, 5);
							}
						}
					} else if (!positions[row + 1][aisle].occupied) {
						passMovesAisle(row); // with some probability
						// System.out.print("moving!");
					} // passenger moves
					// end if occupied
				}

			} // end for loop
			if (positions[0][aisle].occupied == false) {
				boardNew();
			}
		}// end if boarded
		time ++;
	} // end iterate()
		else initialWait--;
	}
	

}
