import static org.junit.Assert.*;

import java.text.DecimalFormat;


import org.junit.Before;
import org.junit.Test;



public class TestOutsideIn {
	int N;

@Before
	public void setup(){
		N=1000;
	}

@Test
	public void OutsideIn(){
		double count = 0;
		BoardingMethod b = new BoardingMethod(3);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded);
			//System.out.println(plane.getNumSeated());
			count ++;
			//plane.displayPositions();
		}
		assertTrue(plane.numBoarded==plane.numSeated);
		//System.out.println(count);

	}
/*
@Test
public void nOutsideIn(){
	double[] time = new double[N];
	for(int i =0;i<N; i++){
		double count = 0;
		BoardingMethod b = new BoardingMethod(2);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded);
			//System.out.println(plane.getNumSeated());
			count ++;
		}
		assertTrue(plane.numBoarded==plane.numSeated);
		time[i]=count;
		//System.out.println(count);
	}
	double sum = 0;
	for(int j=0; j<N;j++){
		sum = sum + time[j];
		
	}
	
	double average = (sum/N/60);
	DecimalFormat twoDForm = new DecimalFormat("#.##");
	System.out.print("OutsideIn Average = ");	
	System.out.println(Double.valueOf(twoDForm.format(average)));
	
}


@Test
public void nAltOutsideIn(){
	double[] time = new double[N];
	for(int i =0;i<N; i++){
		double count = 0;
		BoardingMethod b = new BoardingMethod(3);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded);
			//System.out.println(plane.getNumSeated());
			count ++;
		}
		assertTrue(plane.numBoarded==plane.numSeated);
		time[i]=count;
		//System.out.println(count);
	}
	double sum = 0;
	for(int j=0; j<N;j++){
		sum = sum + time[j];
		
	}
	
	double average = (sum/N/60);
	DecimalFormat twoDForm = new DecimalFormat("#.##");
	System.out.print("AltOutsideIn Average = ");	
	System.out.println(Double.valueOf(twoDForm.format(average)));
	
}

@Test
public void nModOutsideInSmall(){
	double[] time = new double[N];
	for(int i =0;i<N; i++){
		double count = 0;
		BoardingMethod b = new BoardingMethod(4);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded);
			//System.out.println(plane.getNumSeated());
			count ++;
		}
		assertTrue(plane.numBoarded==plane.numSeated);
		time[i]=count;
		System.out.println(count);
	}
	double sum = 0;
	for(int j=0; j<N;j++){
		sum = sum + time[j];
		
	}
	
	double average = (sum/N/60);
	DecimalFormat twoDForm = new DecimalFormat("#.##");
	System.out.print("ModOutsideInSmall Average = ");	
	System.out.println(Double.valueOf(twoDForm.format(average)));
	
}
*/
@Test
public void nModOutsideInBig(){
	double[] time = new double[N];
	for(int i =0;i<N; i++){
		double count = 0;
		BoardingMethod b = new BoardingMethod(18);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded);
			//System.out.println(plane.getNumSeated());
			count ++;
		}
		assertTrue(plane.numBoarded==plane.numSeated);
		time[i]=count;
		System.out.println(count);
	}
	double sum = 0;
	for(int j=0; j<N;j++){
		sum = sum + time[j];
		
	}
	
	double average = (sum/N/60);
	DecimalFormat twoDForm = new DecimalFormat("#.##");
	System.out.print("ModOutsideInBig Average = ");	
	System.out.println(Double.valueOf(twoDForm.format(average)));
	
}
}