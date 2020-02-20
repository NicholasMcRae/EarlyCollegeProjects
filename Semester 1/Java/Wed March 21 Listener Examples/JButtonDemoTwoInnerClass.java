/**
 * Program Name:JButtonDemoTwoInnerClass.java
 * Purpose:shows how to respond to an ActionEvent object that is created
 *          when a JButton is pressed.
 *          In this example, we are going create custom event handler objects using
 *          an "inner class". This is the most common way that event handling is done. 
 *          
 * Coder: Bill Pulling
 * Date: Mar 21, 2012
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JButtonDemoTwoInnerClass extends JFrame
{
	
	private Container thisContentPane;//declare the variable in class scope so that it
	                                  //is visible to all methods and also the inner class
	                                  //and its actionPerformed() method.
																		//NOTE: this just creates the variable reference, it
	                                  //DOES NOT create any Container object. That happens
	                                  //down in the actionPerformed() method.
	
	//do the zero-arg constructor
	public JButtonDemoTwoInnerClass()
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
		//We will create an object of the ButtonHandler class and assign it to redButton
		
		ButtonHandler redButtonBabySitter = new ButtonHandler();
		redButton.addActionListener(redButtonBabySitter);
		
		//do the second one as an anonymous object of ButtonHandler class
		blueButton.addActionListener(new ButtonHandler(  ) );
		
		
		//last line
		this.setVisible(true);
		
	}//end constructor	

	public static void main(String[] args)
	{
		// create an object of the JButtonDemoOne class.
		JButtonDemoTwoInnerClass testObject = new JButtonDemoTwoInnerClass();

	}	//end main 
	
	
	private class ButtonHandler implements ActionListener
	{
	
		//implement the abstract method of the ActionListener interface
		public void actionPerformed(ActionEvent e)
		{
			//For variable scope reasons, we need to create a reference to the contentPane
			//object of the JFrame here inside this method.
			
			thisContentPane = getContentPane();//this actually creates the contentPane object
			
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
	}//end inner class
	
}//end class