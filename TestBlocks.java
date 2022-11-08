import static org.junit.Assert.assertTrue;

import java.text.DecimalFormat;

import org.junit.Before;
import org.junit.Test;



import static org.junit.Assert.*;

	public class TestBlocks {
		int N;

	@Before
		public void setup(){
			N=1000;
		}
/*
	@Test
	public void nBlocksBTFBig(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(6);
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
		System.out.print("BlocksBTFBig Average = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}
	
	@Test
	public void nBlocksBTFSmall(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(7);
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
		System.out.print("BlocksBTFSmall Average = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}
	*/
	@Test
	public void nBlocksAltBig(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(8);
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
		System.out.print("BlocksAltBig Average = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}
	@Test
	public void nBlocksAltSmall(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(9);
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
		System.out.print("BlocksAltSmall Average = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}
}
