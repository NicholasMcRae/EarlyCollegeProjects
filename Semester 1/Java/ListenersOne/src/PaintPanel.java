/**
 * Program Name:PaintPanel.java
 * Purpose: shows how to respond to mouse motion events. This program is a 
 *          basic drawing program. When the mouse is dragged it leaves behind it
 *          a trail of points. 
 * Coder: Bill Pulling
 * Date: Apr 10, 2012
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PaintPanel extends JPanel
{
	//class wide variables
	private int pointCount;//keeps track of # of points drawn
	
	private Point[] pointsArray = new Point[10000];//limit of 10,000 points
	                                                // on the panel
	
	//constructor
	public PaintPanel()
	{
		super();//nothing to pass up, just a courtesy call. 
		
		//register a listener for this class object using an anonymous inner class
		this.addMouseMotionListener( new MouseMotionAdapter() 
			{
				//OVER-RIDE the MouseMotionAdapter class method mouseDragged here
				public void mouseDragged(MouseEvent e)
				{
					if(pointCount < pointsArray.length)//if true, we still have "ink"
					{
						//add the new point to the array
						pointsArray[pointCount] = e.getPoint();
						//increment the pointCount
						pointCount++;
						//repaint the screen
						repaint();
					}//end if					
				}//end method			
			}//end anonymous inner class				
				
		);//closing bracket for addMouseMotionListener parameter list		
		
	}//end constructor
	
	//put in the paintComponent() method
	//This method will cycle through the array each time and "draw" the point
	//locations to the screen.We'll use a filled oval as our "dot" that gets
	//drawn.We'll set its width and height to 4 pixels. For a heavier line you
	//can increase this. For a finer line, decrease it.
	
	public void paintComponent(Graphics g)
	{
		//clear the drawing area (erase the board)
		super.paintComponent(g);//call super to do this
		
		//use a loop to draw the array of points onto the panel
		for(int i = 0; i < pointCount; i++)
		{
			//call on g to paint a filled oval at the Point's x and y co-ordinates
			g.fillOval(pointsArray[i].x, pointsArray[i].y, 4, 4);
			
			this.repaint();//paint the oval on the panel
			
		}//end for
		
	}//end method paintComponent	

	public static void main(String[] args)
	{
		// create a JFrame here and add a PaintPanel object to it
		JFrame frame = new JFrame("A Simple Drawing Program");
		//usual boilerplate code
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		frame.setLayout(new BorderLayout() );
		
		//create an object of the PaintPanel class and add the panel to the frame
		PaintPanel panel = new PaintPanel();
		//add it
		frame.add(panel, BorderLayout.CENTER);
		
		//create an anonymous JLabel with instructions
		
		frame.add( new JLabel("Hold down left mouse button and drag to draw..."),
				       BorderLayout.SOUTH);
		
		//last line
		frame.setVisible(true);

	}	//end main 
}//end class