import javax.swing.JApplet;
import java.awt.Graphics;
 
public class hello extends JApplet {
    public void paintComponent(final Graphics g) {
        g.drawString("Hello, world!", 1, 1);
    }
}
