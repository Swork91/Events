import javax.swing.*;
import java.awt.*;

public class ControlCircle extends JFrame{
	private JButton jbtEnlarge = new JButton("Enlarge");
	private JButton jbtShrink = new JButton("Shrink");
	private CirclePanel canvas = new CirclePanel();
	
	public ControlCircle() {
		JPanel panel = new JPanel();
		panel.add(jbtEnlarge);
		panel.add(jbtShrink);
		
		this.add(canvas, BorderLayout.CENTER);
		this.add(panel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		ControlCircle frame = new ControlCircle();
		frame.setTitle("ControlCircle1");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
