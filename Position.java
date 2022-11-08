
public class Position {
	int row;
	int col;
	Passenger p;
	Passenger second;
	Passenger third;
	boolean occupied;
	boolean seat;
	boolean aisle;
	
	// CONSTRUCTOR
	public Position(int row, int col){
		occupied = false;
		if (col == 4){
			aisle = true;
			seat = false;
		}
		else {
			aisle = false;
			seat = true;
		}
		p = second = third = null;
		
	}
	
	public boolean isSeat(){
		if (seat == true) return true;
		else return false;
	}
	
	public boolean isAisle(){
		if (aisle == true) return true;
		else return false;
	}
	
	public boolean isOccupied(){
		if (occupied == true) return true;
		else return false;
	}
	
	public Passenger getPassenger(){
		return p;
	}

}
