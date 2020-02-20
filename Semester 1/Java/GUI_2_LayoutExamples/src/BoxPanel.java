/**
 * Program Name:BoxPanel.java
 * Purpose: this is the JPanel in the LayoutDemo app that uses
 *          a BoxLayout manager.
 *          From: Lewis and Loftus, 4th edition
 * Coder: Bill Pulling
 * Date: Mar 21, 2012
 */
import java.awt.*;//imports FlowLayout class
import javax.swing.*; //imports the swing classes.

public class BoxPanel extends JPanel

{
	//constructor
	public BoxPanel()
	{
		//do an explicit call to super class zero-arg constructor
		super();
		
		//set the layout to BoxLayout using ANONYMOUS object
		this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS) );
		
		//set the background color of the panel to green
		this.setBackground(Color.MAGENTA);
		
		//Step 1: create some buttons
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		
		//Step 2: now add them to the box layout 
		
		this.add(b1);
		
		//add a 10 pixel space before the next button using a "RigidArea"
		this.add(Box.createRigidArea(new Dimension(10,10) ) );
		
		this.add(b2);
		//put in a "vertical glue area"
		this.add(Box.createVerticalGlue() );//creates an expanding and
		                                    //contracting "cushion" between components
		
		this.add(b3);
		this.add(b4);
		//throw in another rigid area, but make it 40 pixels high
		this.add(Box.createRigidArea(new Dimension(10,40) ) );
		
		this.add(b5);		
		
	}//end constructor
}//end class