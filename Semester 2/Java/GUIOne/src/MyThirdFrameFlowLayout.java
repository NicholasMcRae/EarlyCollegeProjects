/**
 * Program Name: MySecondFrame.java
 * Program Purpose: shows how to create a simple JFrame object and position it on the screen.
 * 								also shows how to create and add some jbutton objects to the frame. Using flow layout
 * Coder: Nick McRae, 0612749
 * Date: Mar 13, 2012
 */
import java.awt.FlowLayout;
import javax.swing.*;//gives us access to the entire swing package (*)
public class MyThirdFrameFlowLayout
{

	public static void main(String[] args)
	{
		// create a JFrame of size 300 by 400 pixels
		
		JFrame frameOne = new JFrame("Nick's third frame using flow layout");//title bar text
		
		//set the size
		frameOne.setSize(600, 400);
		
		//centre the frame on the parent window
		frameOne.setLocationRelativeTo(null);//automatically centre it 
		
		//add a flowlayout manager object to the jframe
		//"old-fashioned way" create object then add it to the frame
		FlowLayout layoutManager = new FlowLayout();//creates the object
		//step two: assign it to the JFrame.
		frameOne.setLayout(layoutManager);
		
		
		
		//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button1 = new JButton("Don't push Samantha's buttons button!");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button1);
		
	//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button2 = new JButton("button!");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button2);
		
	//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button3 = new JButton("button!");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button3);//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button4 = new JButton("button!");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button4);
		
	//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button5 = new JButton("button!");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button5);
		
		
		
		
		
		//always include the following line to avoid memory leaks
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//releases the memory used by the frame back to the heap.
		
		//always put this method call last whenever creating a JFrame
		frameOne.setVisible(true);

	}
}//end main}
//end class