
import java.awt.*;
import javax.swing.*;

// The SpaceInvaders game starts here
public class PlaneStandAlone {
  
    public static void main(String[] args) {
     // Create the game engine; supply a seed for the random number generator.
     // A GameEngine is a JPanel, which gets repainted every time the clock ticks.
     PlaneEngine engine = new PlaneEngine(0);
     
     // BELOW: CODE FOR STANDALONE APPLICATION
     JFrame frame = new JFrame("Plane Layout"); 
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setContentPane(engine); 
     frame.pack(); // some kind of magic
     frame.setVisible(true); // make it visible
     // ABOVE: CODE FOR STANDALONE APPLICATION
     
     // BELOW: CODE FOR APPLET
     // getContentPane().add(engine, BorderLayout.CENTER);
     // engine.requestFocusInWindow();
     // ABOVE: CODE FOR APPLET
     
     /* Create a timer, which "ticks" like a clock. */
     int millisecs = 15;
     Timer timer = new Timer(millisecs, engine);
     /* Start the timer, which starts the game. Here's how it works:
      * Every millisecs milliseconds, timer calls engine.actionPerformed(), 
      * which updates the game state and re-paints/renders the scene.
      */
     timer.start();
    }
}


