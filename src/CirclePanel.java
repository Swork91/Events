import java.awt.Graphics;
import javax.swing.*;

public class CirclePanel extends JPanel{
	private int radius = 5;
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawOval(getWidth()/2-radius, getHeight()/2-radius, 2*radius, 2*radius);
	}
}
