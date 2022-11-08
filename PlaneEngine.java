import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class PlaneEngine extends JPanel implements ActionListener{
	private BoardingMethod b;
	private Passenger[] p;
	private Plane plane;
	int numSeats = 150;
	//boolean started;
	boolean boarded;
	
	public PlaneEngine(int i){
		b = new BoardingMethod(i);
		p = b.getPassengers();
		plane = new Plane(p,b);
		plane.arrangeGroups();
		plane.getBags();
		//plane.pullNoBagsUp();
		initGraphics();
		//started = boarded = false;
	}
	
	 private void initGraphics() {
		 setPreferredSize(new Dimension(400,560));
		 setFocusable(true); 
		// addKeyListener(plane);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(boarded) return;
		if(plane.isBoarded()){
			boarded = true;
			repaint();
			System.out.print("Boarded!");
			return;
		}
		//System.out.println(plane.boarded);
		plane.iterate();
		//plane.displayPositions();
		repaint();
	}
	
	/* Paints ("renders") the scene */
	  public void paintComponent(Graphics g) {
	    super.paintComponent(g); // magic incantation
	    // Paint the background
	    g.setColor(Color.white);
	    g.fillRect(0,0,300,580);     
	    // Otherwise, the game is still on, so render all the objects.
	    /*if (!started) {
	        g.setColor(Color.black);
	        g.drawString("Press SPACE to start", 130, 200);
	        return;
	      }*/ 
	    if(boarded){
	    	boarded = true;
	    }
	    renderDisplayPanel(g);
	    for(int i=0; i< numSeats; i++){
	    	plane.passengers[i].render(g);
	    }
	  }
	  
	  public void renderDisplayPanel(Graphics g) {
	    // render display panel
		  int i; 
		  g.setColor(Color.cyan);
		  g.fillRect(140,20, 30, 520);
		  g.setColor(Color.lightGray);
		  g.fillRect(50,20,30,60);
		  g.fillRect(230,20, 30, 60);
		  g.setColor(Color.black);
	    for(i =20 ; i< 550; i=i+20){
	    	g.drawLine(50,i,260,i);
	    	if(i>20){
	    	String s = Integer.toString((i-20)/20);
	    	g.drawString(s, 30, i);}
	    }
	    for(int j = 50; j<270;j=j+30){
	    	g.drawLine(j,20,j,540);
	    }
	    g.drawString("A", 60, 15);
	    g.drawString("B", 90, 15);
	    g.drawString("C", 120, 15);
	    g.drawString("D", 180, 15);
	    g.drawString("E", 210, 15);
	    g.drawString("F", 240, 15);
	    g.drawString("Boarded = "+ plane.getNumBoarded(), 50, 555);
	    g.drawString("Seated = "+ plane.getNumSeated(), 180, 555);
	    g.drawString("Time = "+ plane.time/60, 50, 575);
	  }

	public void startSim() {
		//started = true;
		
	}

}
