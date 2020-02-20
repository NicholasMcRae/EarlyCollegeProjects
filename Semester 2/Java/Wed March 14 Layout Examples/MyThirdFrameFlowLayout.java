/**
 * Program Name:MyThirdFrameFlowLayout.java
 * Purpose: shows how to create a simple JFrame object and position
 *          it on the screen.
 *          Also shows how to create and add some JButton objects
 *          to the frame.
 *          THIS version uses a FlowLayout manager object to control to
 *          control the placement of the JButtons
 * Coder: Bill Pulling
 * Date: Mar 14, 2012
 */
import javax.swing.*;//gives us access to the entire swing package.
import java.awt.FlowLayout;

public class MyThirdFrameFlowLayout
{

	public static void main(String[] args)
	{
		// create a JFrame of size 00 by 400 pixels
		
		JFrame frameOne = new JFrame("Bill's Third Frame Using FlowLayout");//title bar text
			
		//set the size
		frameOne.setSize(600, 400);
		
		//center the frame on the parent window 
		frameOne.setLocationRelativeTo(null);//automatically centres it
		
		//add a FlowLayout manager object to the JFrame.
		//"Old-fashioned way" create object then add it to the frame
		FlowLayout layoutManager = new FlowLayout();//creates the object
		//step two: assign it to the JFrame.
		frameOne.setLayout(layoutManager);		
		
		
		//create and add some JButtons to the JFrame
		//NOTE: it is a two step process...
		//Step one: create the component
		JButton button1 = new JButton("Button 1: push me!");//adds label
		
		//Step two: add the component to the frame
		frameOne.add(button1);		
		//add a second button
		JButton button2 = new JButton("Button 2: No, push me!");
		frameOne.add(button2);
		
		JButton button3 = new JButton("Button 3");
		frameOne.add(button3);
		
		JButton button4 = new JButton("Button 4");
		frameOne.add(button4);
		
		JButton button5= new JButton("Button 5");
		frameOne.add(button5);
			
		
		//always include this line to avoid "memory leaks"
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//releases the memory used by the frame back to the heap.
		
		//always put this method call last whenever creating a JFrame
		frameOne.setVisible(true);	
		

	}	//end main 
}//end class