/**
 * Program Name:JButtonDemoOne.java
 * Purpose:shows how to respond to an ActionEvent object that is created
 *          when a JButton is pressed.
 *          In this example, we are going to have the host class object
 *          do double duty as the "babysitter" or "event handler" 
 *          or "delegate object" and listen for the ActionEvent object. 
 * Coder: Bill Pulling
 * Date: Mar 21, 2012
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemoOne extends JFrame implements ActionListener
{
	
	//do the zero-arg constructor
	public JButtonDemoOne()
	{
		//call super() and pass up title bar text
		super("JButtonDemoOne class showing how a JButton event is handled.");
		
		//standard GUI boilerplate code...
		this.setSize(500,400);
		this.setLayout(new FlowLayout() );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//create and add JButtons
		//Step 1: create the JButtons
		JButton redButton = new JButton("Red");
		JButton blueButton = new JButton("Blue");
		
		//Step 2: add them to the container
		this.add(redButton);
		this.add(blueButton);
		
		//step 3: Register a listener for each button. This is also known as
		//         assigning a babysitter to "listen" for the ActionEvent object.
		//We are using the object of the host class that is created in the main method
		// as the listener object. It is doing "double duty".
		redButton.addActionListener(this);
		
		blueButton.addActionListener(this);
		
		
		//last line
		this.setVisible(true);
		
	}//end constructor	

	public static void main(String[] args)
	{
		// create an object of the JButtonDemoOne class.
		JButtonDemoOne testObject = new JButtonDemoOne();

	}	//end main 
	
	//implement the abstract method of the ActionListener interface
	public void actionPerformed(ActionEvent e)
	{
		//For variable scope reasons, we need to create a reference to the contentPane
		//object of the JFrame here inside this method.
		
		Container thisContentPane = this.getContentPane();
		
		//put in some code to change the background color of the contentPane object
		if(e.getActionCommand().equals("Red") )
		{
			//change the background color
			thisContentPane.setBackground(Color.RED);
		}
		else if(e.getActionCommand().equals("Blue") )
		{
		//change the background color
			thisContentPane.setBackground(Color.BLUE);
		}		
		
	}//end method actionPerformed	
	
}//end class