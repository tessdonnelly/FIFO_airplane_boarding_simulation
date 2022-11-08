import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;



public class ReversePyramidTest {
	int N;

	@Before
		public void setup(){
			N=3000;
		}
	/*
	@Test
	public void nRevPyramid(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(10);
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
		System.out.print("ReversePyramid Average = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}	
		@Test
		public void nModRevPyrBig(){
			double[] time = new double[N];
			for(int i =0;i<N; i++){
				double count = 0;
				BoardingMethod b = new BoardingMethod(11);
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
			System.out.print("ModRevPyrBig Average = ");	
			System.out.println(Double.valueOf(twoDForm.format(average)));
			
		}
		
		*/
		@Test
		public void nModRevPyrSmall(){
			double[] time = new double[N];
			for(int i =0;i<N; i++){
				double count = 0;
				BoardingMethod b = new BoardingMethod(12);
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
			System.out.print("ModRevPyrSmall Average = ");	
			System.out.println(Double.valueOf(twoDForm.format(average)));
			
		}
	
}