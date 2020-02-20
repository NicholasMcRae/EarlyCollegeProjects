/**
 * Program Name:BorderPanel.java
 * Purpose: this is the JPanel in the LayoutDemo app that uses
 *          a BorderLayout manager.
 *          From: Lewis and Loftus, 4th edition
 * Coder: Bill Pulling
 * Date: Mar 20, 2012
 */
import java.awt.*;//imports FlowLayout class
import javax.swing.*; //imports the swing classes.

public class BorderPanel extends JPanel

{
	//constructor
	public BorderPanel()
	{
		//do an explicit call to super class zero-arg constructor
		super();
		
		//set the layout to BorderLayout using ANONYMOUS object
		this.setLayout(new BorderLayout() );
		
		//set the background color of the panel to green
		this.setBackground(Color.BLUE);
		
		//add some buttons
		JButton b1 = new JButton("Button 1");
		JButton b2 = new JButton("Button 2");
		JButton b3 = new JButton("Button 3");
		JButton b4 = new JButton("Button 4");
		JButton b5 = new JButton("Button 5");
		
		//now add them to the container and specify which zone
		
		this.add(b1,BorderLayout.CENTER);
		this.add(b2,BorderLayout.NORTH);
		this.add(b3,BorderLayout.SOUTH);
		this.add(b4,BorderLayout.EAST);
		this.add(b5,BorderLayout.WEST);		
		
	}//end constructor
}//end class