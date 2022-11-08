import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Test;



public class NewMethodTest {
	int N=3000;

	@Test
	public void newOI(){
		double count = 0;
		BoardingMethod b = new BoardingMethod(17);
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
		System.out.println("New = " + count/60);

	}
	
	@Test
	public void nSteffonBig(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(17);
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
		System.out.print("New Average = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}	
}
