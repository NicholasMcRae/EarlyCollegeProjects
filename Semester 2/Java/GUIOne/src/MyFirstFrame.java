/**
 * Program Name: MyFirstFrame.java
 * Program Purpose: shows how to create a simple JFrame object and position it on the screen.
 * Coder: Nick McRae, 0612749
 * Date: Mar 13, 2012
 */
import javax.swing.*;//gives us access to the entire swing package (*)
public class MyFirstFrame
{

	public static void main(String[] args)
	{
		// create a JFrame of size 300 by 400 pixels
		
		JFrame frameOne = new JFrame("Bill's first Frame");//title bar text
		
		//set the size
		frameOne.setSize(300, 400);
		
		//set its location on the screen
		frameOne.setLocation(200, 200);
		
		//always include the following line to avoid memory leaks
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//releases the memory used by the frame back to the heap.
		
		//always put this method call last whenever creating a JFrame
		frameOne.setVisible(true);

	}
}//end main}
//end class