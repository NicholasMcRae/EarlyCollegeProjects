/**
 * Program Name: MySecondFrame.java
 * Program Purpose: shows how to create a simple JFrame object and position it on the screen.
 * 								also shows how to create and add some jbutton objects to the frame
 * Coder: Nick McRae, 0612749
 * Date: Mar 13, 2012
 */
import javax.swing.*;//gives us access to the entire swing package (*)
public class MySecondFrame
{

	public static void main(String[] args)
	{
		// create a JFrame of size 300 by 400 pixels
		
		JFrame frameOne = new JFrame("Samantha Desirea Hope Hanz");//title bar text
		
		//set the size
		frameOne.setSize(300, 400);
		
		//centre the frame on the parent window
		frameOne.setLocationRelativeTo(null);//automatically centre it 
		
		//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button1 = new JButton("Don't push Samantha's buttons button!");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button1);
		
		
		
		
		
		//always include the following line to avoid memory leaks
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//releases the memory used by the frame back to the heap.
		
		//always put this method call last whenever creating a JFrame
		frameOne.setVisible(true);

	}
}//end main}
//end class