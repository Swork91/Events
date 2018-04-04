package anonymousListenerTest;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnonymousListenerDemo extends JFrame{
	public AnonymousListenerDemo() {
		JButton jbtnew = new JButton("New");
		JButton jbtopen = new JButton("Open");
		JButton jbtsave = new JButton("Save");
		JButton jbtprint = new JButton("Print");
		
		JPanel panel = new JPanel();
		panel.add(jbtnew);
		panel.add(jbtopen);
		panel.add(jbtsave);
		panel.add(jbtprint);
		
		add(panel);
		
		jbtnew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("new pressed");
			}
		});
		
		jbtopen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("open pressed");
				
			}
			
		});
		
		jbtsave.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("save pressed");
				
			}
			
		});
		
		jbtprint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent a) {
				System.out.println("print pressed");
			}
		});
	}

	public static void main(String[] args) {
		AnonymousListenerDemo frame = new AnonymousListenerDemo();
		frame.setTitle("AnonymousListenerDemo");
		//frame.setSize(300, 100);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);

	}

}
