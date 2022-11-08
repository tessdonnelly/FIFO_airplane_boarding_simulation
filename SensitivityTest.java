import static org.junit.Assert.*;

import java.text.DecimalFormat;


import org.junit.Before;
import org.junit.Test;



public class SensitivityTest {
	int N;
	int bm = 4;

@Before
	public void setup(){
		N=3000;
	}

@Test
public void Average(){
	double[] time = new double[N];
	for(int i =0;i<N; i++){
		double count = 0;
		BoardingMethod b = new BoardingMethod(bm);
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
	System.out.print("Average = ");	
	System.out.println(Double.valueOf(twoDForm.format(average)));
	
}


@Test
	public void BusinessGroups(){
		double[] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(bm);
			Passenger[] p = b.getPassengers();
			Plane plane = new Plane(p,b);
			plane.arrangeBusinessGroups();
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
		System.out.print("Business = ");	
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}

@Test
	public void FamilyGroups(){
		double [] time = new double[N];
		for(int i =0;i<N; i++){
			double count = 0;
			BoardingMethod b = new BoardingMethod(bm);
			Passenger[] p = b.getPassengers();
			Plane plane = new Plane(p,b);
			plane.arrangeFamilyGroups();
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
			//System.out.println(time[j]);
		}
		double average = (sum/N/60);
		DecimalFormat twoDForm = new DecimalFormat("#.##");
		System.out.print("Family = ");
		System.out.println(Double.valueOf(twoDForm.format(average)));
		
	}
	
@Test
public void NoBags(){
	double[] time = new double[N];
	for(int i =0;i<N; i++){
		double count = 0;
		BoardingMethod b = new BoardingMethod(bm);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		//plane.getBags();
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
	System.out.print("No Bags = ");	
	System.out.println(Double.valueOf(twoDForm.format(average)));
	
}

@Test
public void NoBagsFirst(){
	double[] time = new double[N];
	for(int i =0;i<N; i++){
		double count = 0;
		BoardingMethod b = new BoardingMethod(bm);
		Passenger[] p = b.getPassengers();
		Plane plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		plane.pullNoBagsUp();
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
	System.out.print("No Bags First = ");	
	System.out.println(Double.valueOf(twoDForm.format(average)));
	
}

}
