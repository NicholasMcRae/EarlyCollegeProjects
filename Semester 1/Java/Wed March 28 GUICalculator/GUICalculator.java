/**
 * Program Name:GUICalculator.java
 * Purpose: a simple GUI app to do the four basic math functions on
 *          any two values passed in.
 * Coder: Bill Pulling
 * Date: Mar 28, 2012
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUICalculator extends JFrame
{
	//declare variables in class scope that need class wide scope
	JButton addButton, subtractButton, multiplyButton, divideButton, clearButton;
	JTextField firstValueField, secondValueField, resultField;
	
	//constructor
	public GUICalculator()
	{
		super("Simple GUI Calculator App");
		
		//standard boilerplate 
		this.setSize(400,300);
		this.setLayout(new BorderLayout() );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//create the subcontainers, 2 JPanels
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.BLUE);
		topPanel.setLayout(new GridLayout(3,2,10,10) );
		//add it to the JFrame center zone
		this.add(topPanel, BorderLayout.CENTER);
		
		//create bottomPanel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.RED);
		bottomPanel.setLayout(new FlowLayout() );
		//add it the JFrame south zone
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		//create buttons and add to bottom panel
		//NOTE:since the button variables were declared in class scope, you can use the
		// "this" keyword to pull them off the code assistant window instead of typing
		//the names in by yourself.
		
		this.addButton = new JButton("+");
		this.subtractButton = new JButton("-");
		this.multiplyButton = new JButton("*");
		this.divideButton = new JButton("/");
		this.clearButton = new JButton("Clear");
		
		//register listeners here (again, could use "this." in front of each variable name
		//as is shown in the first example
		this.addButton.addActionListener(new ButtonHandler() );
		subtractButton.addActionListener(new ButtonHandler() );
		multiplyButton.addActionListener(new ButtonHandler() );
		divideButton.addActionListener(new ButtonHandler() );
		clearButton.addActionListener(new ButtonHandler() );		
		
		//add buttons to container
		bottomPanel.add(addButton);
		bottomPanel.add(subtractButton);
		bottomPanel.add(multiplyButton);
		bottomPanel.add(divideButton);
		bottomPanel.add(clearButton);	
		
		//add components to top panel 
		
		//create the labels and textFields
		JLabel firstValueLabel = new JLabel("First Value");
		JLabel secondValueLabel = new JLabel("Second Value");
		JLabel resultLabel = new JLabel("Result");
		
		this.firstValueField = new JTextField();
		this.secondValueField = new JTextField();
		this.resultField = new JTextField();
		
		//add these to top panel in correct order
		topPanel.add(firstValueLabel);
		topPanel.add(firstValueField);
		topPanel.add(secondValueLabel);
		topPanel.add(secondValueField);
		topPanel.add(resultLabel);
		topPanel.add(resultField);		
		
		//last line
		//this.pack();
		this.setVisible(true);
		
	}//end constructor

	public static void main(String[] args)
	{
		// create the object
		GUICalculator appObject = new GUICalculator();
	}	//end main
	
	//inner class here
	private class ButtonHandler implements ActionListener
	{
		
		//implment the abstract method actionPerformed()
		public void actionPerformed(ActionEvent e)
		{
			
			//research the ActionEvent method getSource() and use it here
			
			//put some code in here that will: 
			//1) read the data from the two input text fields
			//2) determine what operation to do based on the button pushed 
			//3) write the answer to the resultsField.
			
		}//end method
		
	}//end inner class

	
	
}//end class