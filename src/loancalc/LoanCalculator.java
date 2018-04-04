package loancalc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoanCalculator extends JFrame{
	private JTextField jtfAnnualInterestRate = new JTextField();
	private JTextField jtfNumberOfYears = new JTextField();
	private JTextField jtfLoanAmmount = new JTextField();
	private JTextField jtfMonthlyPayment = new JTextField();
	private JTextField jtfTotalPayment = new JTextField();
	private JButton compute = new JButton("Compute Loan");
	
	public LoanCalculator() {
		JPanel p1 = new JPanel(new GridLayout(5,2,0,0)); //5 labels, 5 entry fields in grid layout, 2 columns, 5 rows. 
		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // one button light aligned to compute total. 
		
		p1.add(new JLabel("Annual Interest Rate: "));
		p1.add(jtfAnnualInterestRate);
		p1.add(new JLabel("Number Of Years: "));
		p1.add(jtfNumberOfYears);
		p1.add(new JLabel("Loan Ammount: "));
		p1.add(jtfLoanAmmount);
		p1.add(new JLabel("Monthly Payment: "));
		p1.add(jtfMonthlyPayment);
		p1.add(new JLabel("Total Payment: "));
		p1.add(jtfTotalPayment);
		
		p2.add(compute);
		
		add(p1, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);
		
		compute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double interest = Double.parseDouble(jtfAnnualInterestRate.getText());
				int year = Integer.parseInt(jtfNumberOfYears.getText());
				double loanAmmount = Double.parseDouble(jtfLoanAmmount.getText());
				
				//I didn't make a Loan class so I just do it manually in the anonymous inner class heeeeere!
				/** TODO make Loan class */
				double monthlyPayment = loanAmmount*(interest/1200)/(1-(Math.pow(1/(1+(interest/1200)), 12*year)));
				double tPayment = monthlyPayment*year*12;
				
				jtfMonthlyPayment.setText(String.format("%.2f", monthlyPayment));
				jtfTotalPayment.setText(String.format("%.2f", tPayment));
			}
		});
	}
	
	public static void main(String[] args) {
		LoanCalculator frame = new LoanCalculator();
		frame.setTitle("Loan Calculator");
		frame.setLocationRelativeTo(null);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
