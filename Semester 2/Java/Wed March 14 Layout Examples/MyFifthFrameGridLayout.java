/**
 * Program Name:MyFifthFrameGridLayout.java
 * Purpose: shows how to create a simple JFrame object and position
 *          it on the screen.
 *          Also shows how to create and add some JButton objects
 *          to the frame.
 *          THIS version uses a GridLayout manager object to control to
 *          control the placement of the JButtons
 * Coder: Bill Pulling
 * Date: Mar 14, 2012
 */
import javax.swing.*;//gives us access to the entire swing package.
import java.awt.GridLayout;

public class MyFifthFrameGridLayout
{

	public static void main(String[] args)
	{
		// create a JFrame of size 00 by 400 pixels
		
		JFrame frameOne = new JFrame("Bill's Fifth Frame Using GridLayout");//title bar text
			
		//set the size
		frameOne.setSize(600, 400);
		
		//center the frame on the parent window 
		frameOne.setLocationRelativeTo(null);//automatically centres it
		
		//Add GridLayout object as an ANONYMOUS object
		frameOne.setLayout(new GridLayout(2,3,10,10) );//horizontal and vertical gaps of 10 pixels		
		
		
		//create and add some JButtons to the JFrame
		//NOTE: it is a two step process...
		//Step one: create the component
		JButton button1 = new JButton("Button 1");//adds label
		
		//Step two: add the component to the frame
		frameOne.add(button1);		
		//add a second button
		JButton button2 = new JButton("Button 2");
		frameOne.add(button2);
		
		JButton button3 = new JButton("Button 3");
		frameOne.add(button3);
		
		JButton button4 = new JButton("Button 4");
		frameOne.add(button4);
		
		JButton button5= new JButton("Button 5");
		frameOne.add(button5);
			
		JButton button6= new JButton("Button 6");
		frameOne.add(button6);
		
		//Q What happens if we try to add a 7th button to our 6 space grid?
		JButton button7= new JButton("Button 7");
		frameOne.add(button7);
		
		//make it so user cannot re-size the frame.
		frameOne.setResizable(false);
		
		//always include this line to avoid "memory leaks"
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//releases the memory used by the frame back to the heap.
		
		//always put this method call last whenever creating a JFrame
		frameOne.setVisible(true);	
		

	}	//end main 
}//end class