/**
 * Program Name: MyFifthFrame.java
 * Program Purpose: shows how to create a simple JFrame object and position it on the screen.
 * 								also shows how to create and add some jbutton objects to the frame. Using grid layout
 * Coder: Nick McRae, 0612749
 * Date: Mar 13, 2012
 */
import java.awt.GridLayout;
import javax.swing.*;//gives us access to the entire swing package (*)
public class MyFifthFrameGridLayout
{

	public static void main(String[] args)
	{
		// create a JFrame of size 300 by 400 pixels
		
		JFrame frameOne = new JFrame("Nick's third frame using grid layout");//title bar text
		
		//set the size
		frameOne.setSize(600, 400);
		
		//centre the frame on the parent window
		frameOne.setLocationRelativeTo(null);//automatically centre it 
		
		//add a gridlayout manager object to the jframe
		
		//step two: assign it to the JFrame. add gridlayout object as an anonymous object
		frameOne.setLayout(new GridLayout(2,3,10,10));//horizontal and vertical gaps of 10
		
		
		
		//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button1 = new JButton("Button1");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button1);
		
	//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button2 = new JButton("button2");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button2);
		
	//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button3 = new JButton("button3");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button3);//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button4 = new JButton("button4");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button4);
		
	//create and add some JButtons to the JFrame
		//note: it is a two step process...
		//Step one: create the component
		JButton button5 = new JButton("button5");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button5);
		
	//Step one: create the component
		JButton button6 = new JButton("button6");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button6);
		
		//make it so user can not resize the frame
		frameOne.setResizable(false);
		
	//Q what happens if we try to add a 7th button to our 6 space grid?
	//Step one: create the component
		JButton button7 = new JButton("button7");//adds label 
		
		//Step Two: add the component to the frame
		frameOne.add(button7);
		
		
		
		
		//always include the following line to avoid memory leaks
		frameOne.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//releases the memory used by the frame back to the heap.
		
		//always put this method call last whenever creating a JFrame
		frameOne.setVisible(true);

	}
}//end main}
//end class