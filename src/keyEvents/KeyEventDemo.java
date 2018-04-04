package keyEvents;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class KeyEventDemo extends JFrame{
private KeyboardPanel keyboardPanel = new KeyboardPanel();

	public KeyEventDemo() {
		JPanel pane =  new JPanel();
		pane.setLayout(new GridLayout(0,2));
		
		pane.add(new MovingMessagePanel("----------"));
		pane.add(keyboardPanel);
		
		keyboardPanel.setFocusable(true);
		
		add(pane);
	}

	public static void main(String[] args) {
		KeyEventDemo frame = new KeyEventDemo();
		frame.setTitle("KeyEventDemo");
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.setSize(600, 600);
		//frame.pack();
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	static class KeyboardPanel extends JPanel{
		private int x = 100;
		private int y = 100;
		private char keyChar = 'A'; //default key
		
		public KeyboardPanel() {
			addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					switch (e.getKeyCode()) {
					case KeyEvent.VK_DOWN: y+=10; break;
					case KeyEvent.VK_UP: y-=10; break;
					case KeyEvent.VK_LEFT: x-=10; break;
					case KeyEvent.VK_RIGHT: x+=10; break;
					default: keyChar = e.getKeyChar();
					}
					repaint();
				}
			});
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setFont(new Font("TimesRoman", Font.PLAIN, 24));
			g.drawString(String.valueOf(keyChar), x, y);
		}
	}
	
	static class MovingMessagePanel extends JPanel{
		private String message = "Default Message";
		private int xcord = 0;
		private int ycord = 20;
		
		public MovingMessagePanel(String message) {
			this.message = message;
			
			Timer timer = new Timer(100, new TimerListener());
			timer.start();
		}
		
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if (xcord > getWidth()) {
				xcord = -20;
			}
			xcord+=5;
			g.drawString(message, xcord, ycord);
		}
		
		class TimerListener implements ActionListener{
			public void actionPerformed(ActionEvent e) {
				repaint();				
			}
		}
	}
}
