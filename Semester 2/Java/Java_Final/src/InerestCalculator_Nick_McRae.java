import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;

/**
 * Program Name: InterestCalculator_Nick_McRae.java
 * Program Purpose: To simulate an interest calculator showing simple and compound interest calculations
 * Coder: Nick McRae, 0612749
 * Date: Apr 19, 2012
 */


//Have a nice summer Bill. I'll be using your chess strategy.

//PSEUDOCODE
//1) Need a border layout for the frame and two panels
//2) Label at the North of the border layout
//3) Two gridlayout panels that are centered in the GUI, principal first, FV second
//4) Need: 1 JTextField, 5 labels, 5 text fields, two buttons
//******************Implementing Actions***************************
//5) SIMPLE INTEREST: principle * interest
//6) COMPOUND INTEREST; principle + interest * interest percentage

public class InerestCalculator_Nick_McRae extends JFrame
{
	//declaring component variables
	JButton calcButton, clearButton;
	JPanel bottomPanel, topPanel, fullPanel;
	JTextField titleField, principalField, annualField, yearsField, simpleField, compoundField;
	JLabel principalLabel, yearsLabel, annualLabel, simpleLabel, compoundLabel;
	
	
	//declaring constructor method where we will build the frame to be shown in main
	InerestCalculator_Nick_McRae()
	{
		
		//setting size and layout of main frame
		super("INFO3061 S2011 Exam Nick_McRae");
		this.setSize(400, 300);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//full Panel sits in the frame container with a borderlayout, contains a gridlayout itself
		//top and bottom panel go in the full panel container with a grid layout
		fullPanel = new JPanel();
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		
		
		//setting layouts of the panels
		fullPanel.setLayout(new GridLayout(2, 1, 20, 20));
		bottomPanel.setLayout(new GridLayout(3,3,5,5));
		topPanel.setLayout(new GridLayout(3,3,5,5));
		
		//creating fields
		titleField = new JTextField("Comparison of Simple Versus Compound Interest");
		principalField = new JTextField();
		annualField = new JTextField();
		yearsField = new JTextField();
		simpleField = new JTextField();
		compoundField = new JTextField();
		
		//creating labels
		principalLabel = new JLabel("Principal Amount");
		yearsLabel = new JLabel("Years");
		annualLabel = new JLabel("Annual Interest Rate");
		simpleLabel = new JLabel("FV using simple interest");
		compoundLabel = new JLabel("FV using compound interest");
		
		//creating buttons
		clearButton = new JButton("Clear");
		calcButton = new JButton("Calculate");
		
		//adding stuff to the top panel
		topPanel.add(principalLabel);
		topPanel.add(principalField);
		topPanel.add(yearsLabel);
		topPanel.add(yearsField);
		topPanel.add(annualLabel);
		topPanel.add(annualField);
		
		//adding stuff to the bottom panel
		bottomPanel.add(simpleLabel);
		bottomPanel.add(simpleField);
		bottomPanel.add(compoundLabel);
		bottomPanel.add(compoundField);
		bottomPanel.add(calcButton);
		bottomPanel.add(clearButton);
		
		//adding full panel and title field to the JFrame container, adding inner panels to the 
		//full panel
		this.add(fullPanel, BorderLayout.CENTER);
		this.add(titleField, BorderLayout.NORTH);
		fullPanel.add(topPanel);
		fullPanel.add(bottomPanel);
		
		clearButton.addActionListener(new ButtonHandler());
		calcButton.addActionListener(new ButtonHandler());
					
		this.setVisible(true);		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		InerestCalculator_Nick_McRae showApp = new InerestCalculator_Nick_McRae();

	}//end main
	
	
	public class ButtonHandler implements ActionListener
	{
		
		String principalEntered;
		String yearsEntered;
		String interestRate;
		
		double doublePrincipal;
		double doubleYears;
		double doubleInterest;
		
		double simpleResult;
		double compoundResult;
		
		String stringSimple;
		String stringCompound;
		
			
		//implement the abstract method of the ActionListener interface
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getActionCommand().equals("Calculate"))
			{
					
				principalEntered = principalField.getText();
				yearsEntered = yearsField.getText();
				interestRate = annualField.getText();
				doublePrincipal = Double.parseDouble(principalEntered);
				doubleYears = Double.parseDouble(yearsEntered);
				doubleInterest = Double.parseDouble(interestRate);
				
				
				
				if(doublePrincipal <= 0)
				{
					JOptionPane.showMessageDialog(null, "Negative or Zero principal entered, please re-enter");
				}
				if(doubleYears <= 0)
				{
					JOptionPane.showMessageDialog(null, "Negative or Zero time-frame entered, please re-enter");
				}
				if(doubleInterest <= 0)
				{
					JOptionPane.showMessageDialog(null, "Negative or Zero Interest entered, please re-enter");
				}
				
				simpleResult = doublePrincipal * (1 + (((double)doubleInterest/100) * doubleYears));
				compoundResult = doublePrincipal * (Math.pow((1 + (double)doubleInterest/100), doubleYears));
				
							
				//handing the project in without fixing the decimal places because my time is better spent
				//studying for databases.
				/*simpleResult = simpleResult * 100;
				simpleResult = simpleResult / 100;
				simpleResult = (double)simpleResult/100;
				compoundResult = compoundResult * 100;
				compoundResult = compoundResult / 100;
				compoundResult = (double)compoundResult/100;*/
				
				stringSimple = Double.toString(simpleResult);
				stringCompound = Double.toString(compoundResult);
				
				simpleField.setText(stringSimple);
				compoundField.setText(stringCompound);
				
				
			}
			if(e.getActionCommand().equals("Clear"))
			{
				simpleField.setText("");
				compoundField.setText("");
				principalField.setText("");
				yearsField.setText("");
				annualField.setText("");
				
			}
			
			
			
		}//end actionevent method
		
	}//end inner class
	
}//end outer class