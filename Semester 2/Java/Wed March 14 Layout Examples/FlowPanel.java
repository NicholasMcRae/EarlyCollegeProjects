/**
 * Program Name:FlowPanel.java
 * Purpose: this is the JPanel in the LayoutDemo app that uses
 *          a FlowLayout manager.
 *          From: Lewis and Loftus, 4th edition
 * Coder: Bill Pulling
 * Date: Mar 14, 2012
 */
import java.awt.*;//imports FlowLayout class
import javax.swing.*; //imports the swing classes.

public class FlowPanel extends JPanel

{
	//constructor
	public FlowPanel()
	{
		//do an explicit call to super class zero-arg constructor
		super();
		
		//set the layout to FlowLayout using ANONYMOUS object
		this.setLayout(new FlowLayout() );
		
		//set the background color of the panel to green
		this.setBackground(Color.GREEN);
		
		//add some buttons
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		
		//now add them to the container
		
		this.add(b1);
		this.add(b2);
		this.add(b3);
		this.add(b4);
		this.add(b5);		
		
	}//end constructor
}//end class