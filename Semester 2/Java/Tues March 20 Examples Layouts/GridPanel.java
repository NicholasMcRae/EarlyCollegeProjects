/**
 * Program Name:GridPanel.java
 * Purpose: this is the JPanel in the LayoutDemo app that uses
 *          a GridLayout manager.
 *          From: Lewis and Loftus, 4th edition
 * Coder: Bill Pulling
 * Date: Mar 20, 2012
 */
import java.awt.*;//imports FlowLayout class
import javax.swing.*; //imports the swing classes.

public class GridPanel extends JPanel

{
	//constructor
	public GridPanel()
	{
		//do an explicit call to super class zero-arg constructor
		super();
		
		//set the layout to GridLayout using ANONYMOUS object
		//NOTE: set it to 2 rows and 3 columns with hGap and vGap of 10 pixelx
		this.setLayout(new GridLayout(2,3,10,10) );
		
		//set the background color of the panel to green
		this.setBackground(Color.YELLOW);
		
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