public class BoardingMethodPrelim {

	int numSeats = 18;
	int numSeatsPerRow = 6;
	int numRows = numSeats/numSeatsPerRow;
	Passenger[] passengers = new Passenger[18];
	int method;
	
	BoardingMethodPrelim(int m){
		
	
		method = m;
		//back to front
		if(method == 0){
			int i = 0;
			for(int j = numRows-1; j>=0;j--){
				for(int k =1; k<=numSeatsPerRow; k++){
					passengers[i] = new Passenger(j,k);
					i++;	
					}
				}
		}
		// random
		if(method == 1){
			for(int i = 0; i<passengers.length;){
				boolean duplicate = false;
				int r = (int) (Math.random()*numRows);
				int c = (int) (Math.random()*7);	
				for(int j =0; j<i; j++){
					//System.out.print(s);
					//System.out.println(passengers[j].seat[0][0]);
					if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
						duplicate = true;
					//	System.out.println("DUPLICATE");
					}
				}
				if(duplicate == false && c!=3){
					passengers[i] = new Passenger(r,c);
					//System.out.print(r);System.out.println(c);
					i++;
				}
			}
			for(int k = 0; k<passengers.length;k++){
				System.out.print(passengers[k].seat[0][0]);
				System.out.println(passengers[k].seat[0][1]);
			}
		}
		
		if(method == 2){
			passengers[0] = new Passenger(2,0);
			passengers[1] = new Passenger(2,1);
			passengers[2] = new Passenger(2,2);
			passengers[3] = new Passenger(2,6);
			passengers[4] = new Passenger(2,4);
			passengers[5] = new Passenger(2,5);
		}
	}
	
	Passenger[] getPassengers(){
		return passengers;
	}
	

}
