import java.util.Random;


public class BoardingMethod {

	int numSeats = 150;
	int numSeatsPerRow = 6;
	int numRows = 26;
	int numFirstClass = 12;
	Passenger[] passengers = new Passenger[numSeats];
	int method;
	int numPriority;
	int numDisabled;
	int numMilitary;
	
	BoardingMethod(int m){
		
		arrangeFirstClass();
	
		method = m;
		//back to front
		if(method == 0){
			backToFront();
		}
		// random
		if(method == 1){
			random();
		}
		
		if(method == 2){
			outideIn();
		}
		
		if(method == 3){
			altOutsideIn();
		}
		
		if(method == 4){
			modOutsideInSmall();
		}
		
		if(method == 5){
			modOutsideInBig();
		}
		
		if(method == 6){
			blocksBTFBig();
		}
		
		if(method == 7){
			blocksBTFSmall();
		}
		
		if(method == 8){
			blocksAltBig();
		}
		
		if(method == 9){
			blocksAltSmall();
		}
		
		if(method == 10){
			reversePyramid();
		}
		
		if(method == 11){
			modRevPyrBig();
		}
		
		if(method == 12){
			modRevPyrSmall();
		}
		
		if(method == 13){
			steffen13();
		}
		
		if(method ==14){
			steffen25();
		}
		
		if(method == 15){
			steffen13Alt();
		}
		
		if(method == 16){
			steffen25Alt();
		}
		
		if(method == 17){
			Steffen7Groups();
		}
		
		if(method == 18){
			modOutsideIn19();
		}
		
		pullPriorityPassengers();
		pullDisabled();
		pullMilitary();

	}
	
	private void modOutsideIn19() {
		int i;
		Random rand = new Random();
		//Group 2
		for(i = numFirstClass; i<20;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 18;
			int c = 6;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//Group 3
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 10;
			int c = 6;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 4 
		o = i;
		for(; i<o+7;){
			boolean duplicate = false;
			int r = rand.nextInt(7) + 3;
			int c = 6;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 5
		o = i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 18;
			int c = 0;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 6
		o=i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 10;
			int c = 0;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 7
		for(; i<o+7;){
			boolean duplicate = false;
			int r = rand.nextInt(7) + 3;
			int c = 0;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 8 
		o = i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 18;
			int c = 5;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 9
		o = i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 10;
			int c = 5;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 10
		o=i;
		for(; i<o+7;){
			boolean duplicate = false;
			int r = rand.nextInt(7) + 3;
			int c = 5;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 11
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 18;
			int c = 1;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
			//	System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 12 
		o = i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 10;
			int c = 1;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 13
		o = i;
		for(; i<o+7;){
			boolean duplicate = false;
			int r = rand.nextInt(7) + 3;
			int c = 1;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 14
		o=i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 18;
			int c = 4;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 15
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 10;
			int c = 4;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
			//	System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 16
		o = i;
		for(; i<o+7;){
			boolean duplicate = false;
			int r = rand.nextInt(7) + 3;
			int c = 4;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 17
		o = i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 18;
			int c = 2;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 18
		o=i;
		for(; i<o+8;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 10;
			int c = 2;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 19
		for(; i<o+7;){
			boolean duplicate = false;
			int r = rand.nextInt(7) + 3;
			int c = 2;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		
	}

	private void Steffen7Groups() {
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<35;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r;
			int c;
			if(x==0){
				c = 6;
				r = rand.nextInt(12)*2+3;
			}
			else{
				c = 0;
				r = rand.nextInt(11)*2+4;
			}
			
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+23;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r;
			int c;
			if(x==0){
				c = 0;
				r = rand.nextInt(12)*2+3;
			}
			else{
				c = 6;
				r = rand.nextInt(11)*2+4;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 4
		for(; i<o+23;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r;
			int c;
			if(x==0){
				c = 5;
				r = rand.nextInt(12)*2+3;
			}
			else{
				c = 1;
				r = rand.nextInt(11)*2+4;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 5
		for(; i<o+23;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r;
			int c;
			if(x==0){
				c = 1;
				r = rand.nextInt(12)*2+3;
			}
			else{
				c = 5;
				r = rand.nextInt(11)*2+4;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 6
		for(; i<o+23;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r;
			int c;
			if(x==0){
				c = 4;
				r = rand.nextInt(12)*2+3;
			}
			else{
				c = 2;
				r = rand.nextInt(11)*2+4;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 7 
		for(; i<o+23;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r;
			int c;
			if(x==0){
				c = 2;
				r = rand.nextInt(12)*2+3;
			}
			else{
				c = 4;
				r = rand.nextInt(11)*2+4;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		
	}

	private void steffen13Alt() {
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<24;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(i = o; i<o+11;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(11)*2+4;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 5
		for(; i<o+12;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(12)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 6
		for(i = o; i<o+12;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 7
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 8
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(11)*2+4;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 9
		for(; i<o+12;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(12)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 10
		for(i = o; i<o+12;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 11
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 12
		for(i = o; i<o+11;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(11)*2+4;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 13
		for(; i<o+12;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(12)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void steffen25Alt() {
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<18;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(6)*2+15;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(i = o; i<o+6;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(6)*2+15;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 5
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 6
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 7
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 8
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 9
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 10
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 11
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 12
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 13
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 14
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 15
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 16
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 17
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 18
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 19
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 20
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 21
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 22
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 23
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 24
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 25
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void steffen13() {
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<24;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(i = o; i<o+12;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 5
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 6
		for(i = o; i<o+12;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 7
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 8
		for(i = o; i<o+12;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 9
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 10
		for(i = o; i<o+12;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 11
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 12
		for(i = o; i<o+12;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(12)*2+3;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 13
		for(; i<o+11;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(11)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}
	
	private void steffen25(){
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<18;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(6)*2+15;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(i = o; i<o+6;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(6)*2+14;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 5
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 6;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 6
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 7
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 8
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 9
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 0;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 10
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 11
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 12
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 13
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 5;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 14
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 15
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 16
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 17
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 1;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 18
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 19
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 20
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 21
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 4;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 22
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(6)*2+15;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 23
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(6)*2+3;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 24
		for(; i<o+6;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(6)*2+14;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 25
		for(; i<o+5;){
			boolean duplicate = false;
			int c = 2;
			int r = rand.nextInt(5)*2+4;
			for(int j = o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		
	}

	private void modRevPyrSmall() {
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<32;){
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(5) + 21;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(3) + 23;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(2) + 24;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(2) + 24;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(3) + 23;
			}
			else{
				c = 6;
				r = rand.nextInt(5) + 21;
			}
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+30;){
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(5) + 16;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(5) + 18;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(5) + 19;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(5) + 19;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(5) + 18;
			}
			else{
				c = 6;
				r = rand.nextInt(5) + 16;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 4
		for(; i<o+30;){
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(5) + 11;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(5) + 13;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(5) + 14;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(5) + 14;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(5) + 13;
			}
			else{
				c = 6;
				r = rand.nextInt(5) + 11;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 5
		for(; i<o+24;){
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(4) + 7;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(4) + 9;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(4) + 10;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(4) + 10;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(4) + 9;
			}
			else{
				c = 6;
				r = rand.nextInt(4) + 7;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 6
		for(; i<numSeats;){
			
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(4) + 3;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(6) + 3;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(7) + 3;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(7) + 3;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(6) + 3;
			}
			else{
				c = 6;
				r = rand.nextInt(4) + 3;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void modRevPyrBig() {
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<50;){
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(8) + 18;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(6) + 20;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(5) + 21;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(5) + 21;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(6) + 20;
			}
			else{
				c = 6;
				r = rand.nextInt(8) + 18;
			}
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+48;){
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(8) + 10;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(8) + 12;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(8) + 13;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(8) + 13;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(8) + 12;
			}
			else{
				c = 6;
				r = rand.nextInt(8) + 10;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 4
		for(; i<o+52;){
			boolean duplicate = false;
			int x = rand.nextInt(6);
			int c;
			int r;
			if(x==0){
				c = 0;
				r = rand.nextInt(7) + 3;
			}
			else if(x==1){
				c=1;
				r = rand.nextInt(9) + 3;
			}
			else if(x==2){
				c=2;
				r = rand.nextInt(10) + 3;
			}
			else if(x==3){
				c=4;
				r = rand.nextInt(10) + 3;
			}
			else if(x==4){
				c=5;
				r = rand.nextInt(9) + 3;
			}
			else{
				c = 6;
				r = rand.nextInt(7) + 3;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void blocksAltSmall() {
		Random rand = new Random();
		int i;
		//Group 2
		for(i = numFirstClass; i<42;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 21;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//Group 3
		for(; i<o+24;){
			boolean duplicate = false;
			int r = rand.nextInt(4) + 3;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(; i<o+30;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 16;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 5
		for(; i<o+24;){
			boolean duplicate = false;
			int r = rand.nextInt(4) + 7;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 6
		for(; i<o+30;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 11;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void blocksAltBig() {
		Random rand = new Random();
		int i;
		//Group 2
		for(i = numFirstClass; i<54;){
			boolean duplicate = false;
			int r = rand.nextInt(7) + 19;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//Group 3
		for(; i<o+48;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 3;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(; i<o+48;){
			boolean duplicate = false;
			int r = rand.nextInt(8) + 11;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		
	}

	private void blocksBTFSmall() {
		int i;
		Random rand = new Random();
		//Group 2
		for(i = numFirstClass; i<42;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 21;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//Group 3
		for(; i<o+30;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 16;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(; i<o+30;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 11;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 5
		for(; i<o+24;){
			boolean duplicate = false;
			int r = rand.nextInt(4) + 7;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 6
		for(; i<o+24;){
			boolean duplicate = false;
			int r = rand.nextInt(4) + 3;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		
	}

	private void blocksBTFBig() {
		int i;
		Random rand = new Random();
		//Group 2
		for(i = numFirstClass; i<48;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 20;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//Group 3
		for(; i<o+36;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 14;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(; i<o+36;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 8;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//Group 5
		for(; i<o+30;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 3;
			int c = rand.nextInt(7);
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false && c!=3){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void modOutsideInBig() {
		int i;
		Random rand = new Random();
		//Group 2
		for(i = numFirstClass; i<24;){
			boolean duplicate = false;
			int r = rand.nextInt(12) + 14;
			int c = 6;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		
		for(; i<35;){
			boolean duplicate = false;
			int r = rand.nextInt(11) + 3;
			int c = 6;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 4
		for(; i<47;){
			boolean duplicate = false;
			int r = rand.nextInt(12) + 14;
			int c = 0;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 5
		for(; i<58;){
			boolean duplicate = false;
			int r = rand.nextInt(11) + 3;
			int c = 0;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 6
		o = i;
		for(; i<70;){
			boolean duplicate = false;
			int r = rand.nextInt(12) + 14;
			int c = 5;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		
		for(; i<81;){
			boolean duplicate = false;
			int r = rand.nextInt(11) + 3;
			int c = 5;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 8
		for(; i<93;){
			boolean duplicate = false;
			int r = rand.nextInt(12) + 14;
			int c = 1;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 9
		for(; i<104;){
			boolean duplicate = false;
			int r = rand.nextInt(11) + 3;
			int c = 1;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 10
		for(; i<116;){
			boolean duplicate = false;
			int r = rand.nextInt(12) + 14;
			int c = 4;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 11
		for(; i<127;){
			boolean duplicate = false;
			int r = rand.nextInt(11) + 3;
			int c = 4;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 12
		for(; i<139;){
			boolean duplicate = false;
			int r = rand.nextInt(12) + 14;
			int c = 2;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 13
		for(; i<150;){
			boolean duplicate = false;
			int r = rand.nextInt(11) + 3;
			int c = 2;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void modOutsideInSmall() {
		int i;
		Random rand = new Random();
		//Group 2
		for(i = numFirstClass; i<18;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 20;
			int c = 6;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//Group 3
		for(; i<24;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 14;
			int c = 6;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 4 
		o = i;
		for(; i<30;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 8;
			int c = 6;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 5
		o = i;
		for(; i<35;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 3;
			int c = 6;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 6
		o=i;
		for(; i<41;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 20;
			int c = 0;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 7
		for(; i<47;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 14;
			int c = 0;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 8 
		o = i;
		for(; i<53;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 8;
			int c = 0;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 9
		o = i;
		for(; i<58;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 3;
			int c = 0;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 10
		o=i;
		for(; i<64;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 20;
			int c = 5;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 11
		for(; i<70;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 14;
			int c = 5;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
			//	System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 12 
		o = i;
		for(; i<76;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 8;
			int c = 5;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 13
		o = i;
		for(; i<81;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 3;
			int c = 5;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 14
		o=i;
		for(; i<87;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 20;
			int c = 1;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 15
		for(; i<93;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 14;
			int c = 1;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
			//	System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 16
		o = i;
		for(; i<99;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 8;
			int c = 1;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 17
		o = i;
		for(; i<104;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 3;
			int c = 1;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 18
		o=i;
		for(; i<110;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 20;
			int c = 4;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 19
		for(; i<116;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 14;
			int c = 4;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 20 
		o = i;
		for(; i<122;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 8;
			int c = 4;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 21
		o = i;
		for(; i<127;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 3;
			int c = 4;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 22
		o=i;
		for(; i<133;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 20;
			int c = 2;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//Group 23
		for(; i<139;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 14;
			int c = 2;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 24 
		o = i;
		for(; i<145;){
			boolean duplicate = false;
			int r = rand.nextInt(6) + 8;
			int c = 2;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		//Group 25
		o = i;
		for(; i<150;){
			boolean duplicate = false;
			int r = rand.nextInt(5) + 3;
			int c = 2;
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void altOutsideIn() {
		// windows
		int i;
		Random rand = new Random();
		for(i = numFirstClass; i<35;){
			boolean duplicate = false;
	
			int r = rand.nextInt(23) + 3;
			int c = 0;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int n1 = i;
		for(; i<58;){
			boolean duplicate = false;
			
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c = 6;
			for(int j =n1; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int m = i;
		// middles
		for(;i<81;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c = 1;
			for(int j =m; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
					//System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}	
		int m2=i;
		for(;i<104;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c = 5;
			for(int j =m2; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
					//System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		// aisles
		int o = i;
		for(;i<127;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c = 2;
			for(int j= o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int p = i;
		for(;i<numSeats;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c =4;
			for(int j= p; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}

	private void reversePyramid() {
		int i;
		Random rand = new Random();
		//GROUP 2
		for(i = numFirstClass; i<28;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(8) + 18;
			int c;
			if(x==0) c = 0;
			else c = 6;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int o = i;
		//GROUP 3
		for(; i<o+32;){
			boolean duplicate = false;
			int x = rand.nextInt(4);
			int r;
			int c;
			if(x==0){
				c = 0;
				r = rand.nextInt(8) + 10;
			}
			else if(x==1){
				c = 1;
				r = rand.nextInt(8) + 18;
			}
			else if(x==2){
				c = 6;
				r = rand.nextInt(8) + 10;
			}
			else {
				c = 5;
				r = rand.nextInt(8) + 18;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 4
		for(; i<o+30;){
			boolean duplicate = false;
			int x = rand.nextInt(4);
			int r;
			int c;
			if(x==0){
				c = 0;
				r = rand.nextInt(7) + 3;
			}
			else if(x==1){
				c = 1;
				r = rand.nextInt(8) + 10;
			}
			else if(x==2){
				c = 6;
				r = rand.nextInt(7) + 3;
			}
			else {
				c = 5;
				r = rand.nextInt(8) + 10;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o = i;
		//GROUP 5
		for(; i<o+40;){
			boolean duplicate = false;
			int x = rand.nextInt(4);
			int r;
			int c;
			if(x==0){
				c = 1;
				r = rand.nextInt(7) + 3;
			}
			else if(x==1){
				c = 2;
				r = rand.nextInt(13) + 13;
			}
			else if(x==2){
				c = 5;
				r = rand.nextInt(7) + 3;
			}
			else {
				c = 4;
				r = rand.nextInt(13) + 13;
			}
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		o=i;
		//GROUP 6
		for(; i<o+20;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(10) + 3;
			int c;
			if(x==0) c = 2;
			else c = 4;
			
			for(int j =o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
	}


	private void outideIn() {
		// windows
		int i;
		Random rand = new Random();
		for(i = numFirstClass; i<(2*(numRows-3) + numFirstClass);){
			boolean duplicate = false;
			
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c;
			if(x==0) c = 0;
			else c = 6;
			for(int j =numFirstClass; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		int m = i;
		// middles
		for(i=m;i<104;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c;
			if(x==0) c = 1;
			else c = 5;
			for(int j =m; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
					//System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}	
		// aisles
		int o = i;
		for(i=o;i<numSeats;){
			boolean duplicate = false;
			int x = rand.nextInt(2);
			int r = rand.nextInt(23) + 3;
			int c;
			if(x==0) c = 2;
			else c = 4;
			for(int j= o; j<i; j++){
				//System.out.print(s);
				//System.out.println(passengers[j].seat[0][0]);
				if(passengers[j].seat[0][0] == r && passengers[j].seat[0][1] == c){
					duplicate = true;
				//	System.out.println("DUPLICATE");
				}
			}
			if(duplicate == false){
				passengers[i] = new Passenger(r,c);
				//System.out.println(i + ": " + r + "," + c);
				i++;
			}
		}
		
	}

	Passenger[] getPassengers(){
		return passengers;
	}
	
	public void arrangeFirstClass(){
		//generate first class
		for(int i = 0; i<numFirstClass;){
			boolean duplicate = false;
			int r = (int) (Math.random()*3);
			int c = (int) (Math.random()*5)+1;	
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
		//System.out.print("done!");
	}
	
	public void backToFront(){
		int i = numFirstClass;
		for(int j = numRows-1; j>=3;j--){
			if(i<passengers.length){
			int k = 0;
			Random r = new Random();
			while(k<6){
				boolean duplicate = false;
				int c = r.nextInt(7);
				for(int n = i-k; n<i; n++){
					if( passengers[n].seat[0][1] == c){
						duplicate = true;
					//	System.out.println("DUPLICATE");
					}
				}
				if(c != 3 && !duplicate){
					passengers[i] = new Passenger(j,c);
					i++;
					k++;
				}
			}
		}
		}
		//for(int k = 0; k<passengers.length;k++){
		//System.out.print(passengers[k].seat[0][0]);
		//System.out.println(passengers[k].seat[0][1]);
		//}
	}
	
	public void random(){
		for(int i = numFirstClass; i<passengers.length;){
			boolean duplicate = false;
			int r = (int) (Math.random()*(numRows-3))+3;
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
		/*for(int k = 0; k<passengers.length;k++){
			System.out.print(passengers[k].seat[0][0]);
			System.out.println(passengers[k].seat[0][1]);
			}
*/
	
	}
	
	public void pullPriorityPassengers(){
	
		int p0priority = 125; // occurs with 12.5% prob
		int p3priority = 398; // occurs with 26.8% prob
		int p6priority = 636; // occurs with 24.3% prob
		int p8priority = 778; // occurs with 14.2% prob
		int p11priority = 865; // occurs with 8.7% prob
		int p14priority = 918; // occurs with 5.3% prob
		int p17priority = 946; // occurs with 2.8% prob
		int p19priority = 968; // occurs with 2.2% prob
		int p22priority = 982; // occurs with 1.5% prob
		int p25priority = 990; // occurs with 0.7% prob
		int p28priority = 994; // occurs with 0.4% prob
		int p30priority = 998; // occurs with 0.4% prob
		int p33priority = 1000; // occurs with 0.2% prob
		
		Random r = new Random();
		int n = r.nextInt(1001);	// n is number between 0-1000
		
		if(n<p0priority) numPriority = 0;
		else if(n<p3priority) numPriority = 3;
		else if(n<p6priority) numPriority = 6;
		else if(n<p8priority) numPriority = 8;
		else if(n<p11priority) numPriority = 11;
		else if(n<p14priority) numPriority = 14;
		else if(n<p17priority) numPriority = 17;
		else if(n<p19priority) numPriority = 19;
		else if(n<p22priority) numPriority = 22;
		else if(n<p25priority) numPriority = 25;
		else if(n<p28priority) numPriority = 28;
		else if(n<p30priority) numPriority = 30;
		else if(n<p33priority) numPriority = 33;
		//System.out.println("Number Priority = " +numPriority);
		
		Passenger[] p1 = new Passenger[numSeats];
		int a;
		for(a = 0; a<numFirstClass; a++) p1[a]=passengers[a];
		for(int b = 0; b<numPriority;){
			int i = r.nextInt(numSeats-numFirstClass) + numFirstClass;
			if(passengers[i] != null) {
				p1[a] = passengers[i];
				passengers[i]=null;
				b++; a++;
			}
		}
		for(int c = numFirstClass; c < numSeats; c++){
			//System.out.println("a = " + a + " c = " +c);
			if(passengers[c]!= null ){
				p1[a] = passengers[c];
				a++;
				
			}
		}
		
		passengers = p1;	
		/*for(int k = 0; k<passengers.length;k++){
		System.out.print(passengers[k].seat[0][0] + ",");
		System.out.println(passengers[k].seat[0][1]);
		}*/
	}
	
	public void pullDisabled(){
		int p0disabled = 738; // occurs with 73.8% prob
		int p1disabled = 848; // occurs with 11.0% prob
		int p2disabled = 914; // occurs with 6.6% prob
		int p3disabled = 953; // occurs with 3.9% prob
		int p4disabled = 975; // occurs with 2.2% prob
		int p5disabled = 988; // occurs with 1.3% prob
		int p6disabled = 993; // occurs with 0.6% prob
		int p7disabled = 996; // occurs with 0.3% prob
		int p8disabled = 998; // occurs with 0.2% prob
		int p9disabled = 1000; // occurs with 0.1% prob
		
		
		Random r = new Random();
		int n = r.nextInt(1000);	// n is number between 0-1000
		
		if(n<p0disabled) numDisabled = 0;
		else if(n<p1disabled) numDisabled = 1;
		else if(n<p2disabled) numDisabled = 2;
		else if(n<p3disabled) numDisabled = 3;
		else if(n<p4disabled) numDisabled = 4;
		else if(n<p5disabled) numDisabled = 5;
		else if(n<p6disabled) numDisabled = 6;
		else if(n<p7disabled) numDisabled = 7;
		else if(n<p8disabled) numDisabled = 8;
		else if(n<p9disabled) numDisabled = 9;
		//System.out.println("Number disabled = " + numDisabled);
		
		Passenger[] p2 = new Passenger[numSeats];
		int a;
		for(a = 0; a<numFirstClass+numPriority; a++) p2[a]=passengers[a];
		for(int b = 0; b<numDisabled;){
			int i = r.nextInt(numSeats-numFirstClass-numPriority) + numFirstClass+numPriority;
			if(passengers[i] != null) {
				p2[a] = passengers[i];
				passengers[i]=null;
				b++; a++;
			}
		}
		for(int c = numFirstClass+numPriority; c < numSeats; c++){
			//System.out.println("a = " + a + " c = " +c);
			if(passengers[c]!= null ){
				p2[a] = passengers[c];
				a++;
				
			}
		}
		
		passengers = p2;
	}
	
	public void pullMilitary(){
		int p0military = 279; // occurs with 27.9% prob
		int p1military = 618; // occurs with 33.9% prob
		int p2military = 790; // occurs with 17.2% prob
		int p3military = 886; // occurs with 9.7% prob
		int p4military = 939; // occurs with 5.2% prob
		int p5military = 969; // occurs with 3.0% prob
		int p6military = 982; // occurs with 1.3% prob
		int p7military = 991; // occurs with 0.8% prob
		int p8military = 994; // occurs with 0.4% prob
		int p9military = 998; // occurs with 0.4% prob
		int p10military = 999; // occurs with 0.1% prob
		int p11military = 1000; // occurs with 0.1% prob
		
		Random r = new Random();
		int n = r.nextInt(1001);	// n is number between 0-1000
		
		if(n<p0military) numMilitary = 0;
		else if(n<p1military) numMilitary = 1;
		else if(n<p2military) numMilitary = 2;
		else if(n<p3military) numMilitary = 3;
		else if(n<p4military) numMilitary = 4;
		else if(n<p5military) numMilitary = 5;
		else if(n<p6military) numMilitary = 6;
		else if(n<p7military) numMilitary = 7;
		else if(n<p8military) numMilitary = 8;
		else if(n<p9military) numMilitary = 9;
		else if(n<p10military) numMilitary = 10;
		else if(n<p11military) numMilitary = 11;
		//System.out.println("Number military = " + numMilitary);
		
		Passenger[] p3 = new Passenger[numSeats];
		int a;
		for(a = 0; a<numFirstClass+numPriority+numDisabled; a++) p3[a]=passengers[a];
		for(int b = 0; b<numMilitary;){
			int i = r.nextInt(numSeats-numFirstClass-numPriority-numDisabled) + numFirstClass+numPriority+numDisabled;
			if(passengers[i] != null) {
				p3[a] = passengers[i];
				passengers[i]=null;
				b++; a++;
			}
		}
		for(int c = numFirstClass+numPriority + numDisabled; c < numSeats; c++){
			//System.out.println("a = " + a + " c = " +c);
			if(passengers[c]!= null ){
				p3[a] = passengers[c];
				a++;	
			}
		}
		passengers = p3;
	}
	

}
