import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class OutsideInApplet extends JApplet{

	 public void init() {
		 final PlaneEngine engine = new PlaneEngine(5);
		 getContentPane().add(engine, BorderLayout.CENTER);
	     engine.requestFocusInWindow();
	     /* Create a timer, which "ticks" like a clock. */
	     final int millisecs = 50;
	     final Timer timer = new Timer(millisecs,engine);
	     /* Start the timer, which starts the game. Here's how it works:
	      * Every millisecs milliseconds, timer calls engine.actionPerformed(), 
	      * which updates the game state and re-paints/renders the scene.
	      */
	     timer.start();
	    }
	 
	
}