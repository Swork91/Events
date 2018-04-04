import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		
		jbtEnlarge.addActionListener(new EnlargeListener());
		jbtShrink.addActionListener(new ShrinkListener());
	}

	public static void main(String[] args) {
		ControlCircle frame = new ControlCircle();
		frame.setTitle("ControlCircle1+2");
		frame.setSize(300, 300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);

	}
	
	//inner class
	class CirclePanel extends JPanel{
		private int radius = 5;
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawOval(getWidth()/2-radius, getHeight()/2-radius, 2*radius, 2*radius);
		}
		
		public void enlarge() {
			radius+=2;
			repaint();
		}
		
		public void shrink() {
			if (radius<=2) {
				radius=0;
			}
			else {
				radius-=2;
			}
			repaint();
		}
	}
	
	//inner class
	class EnlargeListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			canvas.enlarge();
		}
	}
	
	// ????
	class ShrinkListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			canvas.shrink();
			
		}
		
	}
}
