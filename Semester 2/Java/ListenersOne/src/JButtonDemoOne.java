/**
 * Program Name:
 * Program Purpose: shows how to respond to an ActionEvent object that is created when a JButton is pressed
 * 									In this example, we are going to have the host class object do double duty as the babysitter
 * 									or event handler or delegate object and listen for the actionevent object
 * Coder: Nick McRae, 0612749
 * Date: Mar 21, 2012
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class JButtonDemoOne extends JFrame implements ActionListener
{
	
	//do the constructor
	public JButtonDemoOne()
	{
		//call super and pass up title bar text
		super("JButtonDemoOne class showing how a Jbutton event is handled");
		
		//standard GUI boilerplate code...
		this.setSize(500,500);
		this.setLayout(new FlowLayout() );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//create and add JButtons
		//Step 1: create the JButtons
		JButton redButton = new JButton("Red");
		JButton blueButton = new JButton("blue");
		
		//step 2: add them to the container
		this.add(redButton);
		this.add(blueButton);
		
		//step 3: Register a listener for each button. This is also known as 
		//        assigning a babysitter to "listen" for the ActionEvent object. 
		//        we are using the object of the host class that is created in the main method
		//        as the listener object. It is doing "double duty".
		redButton.addActionListener(this);
		
		blueButton.addActionListener(this);
		
		//last line 
		this.setVisible(true);
		
	}//end constructor

	public static void main(String[] args)
	{
		// create an object of the JButtonDemoOne class. 
		JButtonDemoOne testObject = new JButtonDemoOne();

	}
	//implement the abstract method of the ActionListener interface
	public void actionPerformed(ActionEvent e)
	{
		//For variable scope reasons, we need to create a reference to the contentPane
		//object of the JFrame here inside this method.
		
		Container thisContentPane = this.getContentPane();
		
		//put in some code to change the background color of the contentPane object
		if(e.getActionCommand().equals("Red"))
		{
			//change the background color
			thisContentPane.setBackground(Color.RED);
		}
		else if(e.getActionCommand().equals("blue"))
		{
			thisContentPane.setBackground(Color.BLUE);
		}
		
		
	}//end method actionPerformed
	
	
}//end class