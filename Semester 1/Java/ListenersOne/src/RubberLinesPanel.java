/**
Program Name: RubberLinesPanel.java
Purpose: an example showing use of the MouseListener interface and
         its two methods, mouseMoved() and mouseDragged
Coder: from Loftus and Lewis, Java Software Solutions, 4th ed
       Addison-Wesley
Date: Apr 6, 2011 Sec01
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class RubberLinesPanel extends JPanel
{
	private Point point1 = null, point2 = null;
	
	//constructor
	public RubberLinesPanel()
	{
		//create a mouse listener object of the inner class
		LineListener listener = new LineListener();
		this.addMouseListener(listener);
		this.addMouseMotionListener(listener);
		
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(400,200));		
		
	}//end constructor
	
	//do paint method here
	public void paintComponent(Graphics page)
	{
		//this method draws the line as a series of points
		//call super class version of method
		super.paintComponent(page);
		
		page.setColor(Color.YELLOW);
		//draw something as long as the point1 and point2 values
		//are not showing null.
		if(point1 != null && point2 != null)
		{
			page.drawLine(point1.x, point1.y, point2.x, point2.y);
		}		
		
		
	}//end paint method
	
	//do the main method here
	
	public static void main(String[]args)
	{
		//create a JFrame to hold the RubberLinesPanel object
		JFrame frame = new JFrame("Rubber Lines Demo");
		
		//create an object of RubberLinesPanel class
		RubberLinesPanel panel = new RubberLinesPanel();
		
		//add panel to the JFrame
		frame.add(panel);
		
		frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	//inner class to handle the mouse events
	
	private class LineListener implements MouseListener, MouseMotionListener
	{
		//capture the initial position on the panel using
		//mousePressed() event
		public void mousePressed(MouseEvent e)
		{
			point1 = e.getPoint();
		}//end method
		
		//get the current position of the mouse cursor as it is
		//dragged across the screen so we can draw the line
		
		public void mouseDragged(MouseEvent e)
		{
			point2 = e.getPoint();
			//repaint the line as you drag
			repaint();
		}
		
		//add the unimplemented methods to satisfy the JVM
		@Override
		public void mouseMoved(MouseEvent e)
		{
		}

		@Override
		public void mouseClicked(MouseEvent e)
		{
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
		}

		@Override
		public void mouseEntered(MouseEvent e)
		{
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
		}		
		
	}//end inner class	
	
}//end class








