import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;



public class TestPrelim {
	int N;

@Before
	public void setup(){
		N=10000;
	}
@Test
	public void backToFront(){
		int count = 0;
		BoardingMethod b = new BoardingMethod(0);
		Passenger[] p = b.getPassengers();
		PlanePrelim plane = new PlanePrelim(p,b);
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded);
			//System.out.println(plane.getNumSeated());
			count ++;
		}
		assertTrue(plane.numBoarded==plane.numSeated);
		plane.displayPositions();
		//System.out.println(count);

	}
@Test
	public void random(){
		int count = 0;
		BoardingMethod b = new BoardingMethod(1);
		Passenger[] p = b.getPassengers();
		PlanePrelim plane = new PlanePrelim(p,b);
		while(plane.isBoarded()==false){
			plane.iterate();
			//System.out.print(plane.numBoarded);
			//System.out.println(plane.getNumSeated());
			count ++;
		}
		assertTrue(plane.numBoarded==plane.numSeated);
		//System.out.println(count);
}
@Test
	public void nBackToFront(){
		int[] time = new int[N];
		for(int i =0;i<N; i++){
			int count = 0;
			BoardingMethod b = new BoardingMethod(0);
			Passenger[] p = b.getPassengers();
			PlanePrelim plane = new PlanePrelim(p,b);
			while(plane.isBoarded()==false){
				plane.iterate();
				//System.out.print(plane.numBoarded);
				//System.out.println(plane.getNumSeated());
				count ++;
			}
			assertTrue(plane.numBoarded==plane.numSeated);
			time[i]=count;
		}
		int sum = 0;
		for(int j=0; j<N;j++){
			sum = sum + time[j];
		}
		System.out.print("Back-to-Front Average = ");
		System.out.println(sum/N);
	}

@Test
	public void nRandom(){
		int[] time = new int[N];
		for(int i =0;i<N; i++){
			int count = 0;
			BoardingMethod b = new BoardingMethod(1);
			Passenger[] p = b.getPassengers();
			PlanePrelim plane = new PlanePrelim(p,b);
			while(plane.isBoarded()==false){
				plane.iterate();
				//System.out.print(plane.numBoarded);
				//System.out.println(plane.getNumSeated());
				count ++;
			}
			assertTrue(plane.numBoarded==plane.numSeated);
			time[i]=count;
		}
		int sum = 0;
		for(int j=0; j<N;j++){
			sum = sum + time[j];
		}
		System.out.print("Random Average = ");
		System.out.println(sum/N);
	}
}