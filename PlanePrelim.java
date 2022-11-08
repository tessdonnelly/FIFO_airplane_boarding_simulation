
public class PlanePrelim {
	Passenger[] passengers;	//array of passengers in the plane
	Position[][] positions;	// array of positions in the plane
	BoardingMethod method;	// boarding method orders passengers
	int numBoarded;
	int numSeated;
	boolean boarded;		// true is plane is fully boarded
	int seatsPerRow = 2;
	int numRows = 26;
	int aisle = 4;		// position of aisle within plane
	
	// Constructor
	public PlanePrelim(Passenger[] p, BoardingMethod b){
		passengers = p;			// takes passenger array as input
		method = b;				// takes boarding method as input
		positions = new Position[numRows][7]; //create position array
		for(int i =0; i<numRows;i++){	
			for(int j = 0; j<7; j++){
				positions[i][j]= new Position(i,j);
			} // creates new position at each point in the plane configuration
		}
		numBoarded = 0;		// no one boarded
		numSeated = 0;		// no passenger seated
		boarded = false;	// plane is not boarded
	}
	
	public int getNumBoarded(){
		numBoarded = 0;
		for(int i = 0;i<passengers.length;i++){
			if (passengers[i].isBoarded()==true){
				numBoarded ++;
			}
		}
		return numBoarded;
	}
	
	public int getNumSeated(){
		numSeated = 0;
		for(int i = 0;i<passengers.length;i++){
			if (passengers[i].isSeated()==true){
				numSeated ++;
			}
		}
		return numSeated;
	}
	
	public boolean isBoarded(){
		boarded = false;
		if(getNumSeated()==passengers.length){
			boarded = true;
		}
		return boarded;
	}
	
	public void passSits(int row){
		Passenger pass = positions[row][aisle].p;
		int seat = pass.getSeat();
		pass.sit();
		positions[row][seat].p= pass;
		positions[row][seat].occupied = true;
		positions[row][aisle].p = null;
		positions[row][aisle].occupied = false;
	}
	
	public void passMoves(int row){
		Passenger pass = positions[row][aisle].p;
		pass.moveRowIn();
		positions[row+1][aisle].p= pass;
		positions[row+1][aisle].occupied = true;
		positions[row][aisle].p = null;
		positions[row][aisle].occupied = false;
	}
	
	public boolean boardNew(){
		if(numBoarded < passengers.length){
			numBoarded++;
			Passenger pass = passengers[numBoarded-1];
			pass.board();
			positions[0][aisle].p = pass;
			positions[0][aisle].occupied = true;
			//System.out.print("BOARDING!!");
			return true;
		}
		else return false;
	}
	
	public void displayPositions(){
		for(int i = 0; i< numRows; i++){
			System.out.print(i+1 + " ");
			for(int j = 0; j<7;j++){
				System.out.print(positions[i][j].occupied + " ");
			}
			System.out.println();
		}
	}
	
	public void iterate(){
		if(boarded == false){ 		//plane is not boarded
			 for(int row=numRows-1; row>=0; row--){		// for each row of plane
				 Position current = positions[row][aisle];
				if(current.occupied == true){
					
					Passenger pass = current.p;
					if(pass.seat[0][0] == row){
						passSits(row);		// with some probability
						//System.out.print("SITTING!!");
					}	// passenger seated
					else {
						passMoves(row);		// with some probability
						//System.out.print("moving!");
					}	// passenger moves			
				}	// end if occupied
			 } // end for loop
			 if(positions[0][4].occupied==false){
				 boardNew();
			 }
		}// end if boarded
	}	// end iterate()
	
}
