/**
 * Program Name:LayoutDemo.java
 * Purpose: demonstrates the various layout managers on several
 *          JTabbedPanes. 
 * Coder: Bill Pulling
 * Date: Mar 14, 2012
 */
import javax.swing.*;
public class LayoutDemo
{

	public static void main(String[] args)
	{
		// create a JFrame
		JFrame frame = new JFrame("Lewis and Loftus Layout Demo");
		
		//set size
		frame.setSize(600, 400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//create a JTabbedPane to use as a sub-container.
		JTabbedPane tabbedPane = new JTabbedPane();
		
		//ADD THE JTabbePane to the frame
		frame.add(tabbedPane);
		
		//add a FlowPanel object to the tabbedPane object
		tabbedPane.add("FlowLayout", new FlowPanel() );
		
		//add a BorderPanel object to the tabbedPane object
		tabbedPane.add("BorderLayout", new BorderPanel() );
		
		//add a GridPanel object to the tabbedPane object
		tabbedPane.add("GridLayout", new GridPanel() );
		
		//add a BoxPanel object to the tabbedPane object
		tabbedPane.add("BoxLayout", new BoxPanel() );
		
		
		//make it visible
		frame.setVisible(true);
		
	}	//end main 
}
//end class