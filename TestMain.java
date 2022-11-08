import static org.junit.Assert.*;

import java.text.DecimalFormat;


import org.junit.Before;
import org.junit.Test;



public class TestMain {
	int N;

@Before
	public void setup(){
		N=3000;
	}

@Test
	public void backToFront(){
		double count = 0;
		BoardingMethod b = new BoardingMethod(0);
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
		//System.out.println("Back-to-front = " + count/60);

	}
	
@Test
	public void random(){
		double count = 0;
		BoardingMethod b = new BoardingMethod(1);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		//System.out.println("TEST");
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded + " ");
			//System.out.println(plane.getNumSeated());
			count ++;
			//plane.displayPositions();
		}
		assertEquals(plane.numBoarded, plane.numSeated);
		//System.out.println("Random = " + count/60);
		
}

@Test
	public void nBackToFront(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(0);
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
		System.out.print("Back-to-Front Average = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}

@Test
	public void nRandom(){
		double [] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(1);
			Passenger[] p = b.getPassengers();
			Plane plane = new Plane(p,b);
			plane.arrangeGroups();
		plane.getBags();
			//plane.pullNoBagsUp();
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
			//System.out.println(time[j]);
		}
		double average = (sum/N/60);
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		System.out.print("Random Average = ");
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}



}