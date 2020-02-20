/**
 * Program Name:MouseListenerExample.java
 * Purpose: 
 * Coder: Bill Pulling
 * Date: Apr 4, 2012
 */
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


public class MouseListenerExample extends JFrame
{
	
	//declare some variables in class scope so they can be seen in inner class
	private JLabel[] labelArray;
	
	//constructor
	public MouseListenerExample()
	{
		//super call
		super("Mouse Listener Example");
		
		//boilerplate code
		this.setSize(500,400);
		this.setLayout(new GridLayout(6,1,10,10) );
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		
		//create the array for the JLabels and fill it
		labelArray = new JLabel[6];
		labelArray[0] = new JLabel("Mouse Clicked", SwingConstants.CENTER);
		labelArray[1] = new JLabel("Mouse Entered", SwingConstants.CENTER);
		labelArray[2] = new JLabel("Mouse Exited", SwingConstants.CENTER);
		labelArray[3] = new JLabel("Mouse Pressed", SwingConstants.CENTER);
		labelArray[4] = new JLabel("Mouse Released", SwingConstants.CENTER);
		labelArray[5] = new JLabel(" ", SwingConstants.CENTER);
		
		//add the labels to the JFrame using a loop
		for(int i = 0; i < labelArray.length; i++)
		{
			labelArray[i].setForeground(Color.GRAY);
			this.add(labelArray[i]);
		}
		
		//register a listener for the mouse
		this.addMouseListener(new MouseHandler() );
		
		
		//last line
		this.setVisible(true);
	}//end constructor
	
	
	//inner class to handle mouse events
	
	private class MouseHandler implements MouseListener
	{

		@Override
		public void mouseClicked(MouseEvent e)
		{
			// use a loop to cycle through the labels and do what has to be done
			for(int i = 0; i < labelArray.length; i++)
			{
				if(i == 0)
				{
					labelArray[i].setForeground(Color.GREEN);
				}
				else
				{
					labelArray[i].setForeground(Color.GRAY);
				}
			}//end for
			
			//print out x,y location of the mouse when the event occurred
			labelArray[5].setText("[" + e.getX() + "," + e.getY() + "]");
			
		}//end method
		
		@Override
		public void mouseEntered(MouseEvent e)
		{
		// use a loop to cycle through the labels and do what has to be done
					for(int i = 0; i < labelArray.length; i++)
					{
						if(i == 1)
						{
							labelArray[i].setForeground(Color.GREEN);
						}
						else
						{
							labelArray[i].setForeground(Color.GRAY);
						}
					}//end for
					
					//print out x,y location of the mouse when the event occurred
					labelArray[5].setText("[" + e.getX() + "," + e.getY() + "]");
			
		}

		@Override
		public void mouseExited(MouseEvent e)
		{
		// use a loop to cycle through the labels and do what has to be done
					for(int i = 0; i < labelArray.length; i++)
					{
						if(i == 2)
						{
							labelArray[i].setForeground(Color.RED);
						}
						else
						{
							labelArray[i].setForeground(Color.GRAY);
						}
					}//end for
					
					//print out x,y location of the mouse when the event occurred
					labelArray[5].setText("[" + e.getX() + "," + e.getY() + "]");
			
		}

		@Override
		public void mousePressed(MouseEvent e)
		{
			// use a loop to cycle through the labels and do what has to be done
			for(int i = 0; i < labelArray.length; i++)
			{
				if(i == 3)
				{
					labelArray[i].setForeground(Color.BLUE);
				}
				else
				{
					labelArray[i].setForeground(Color.GRAY);
				}
			}//end for
			
			//print out x,y location of the mouse when the event occurred
			labelArray[5].setText("[" + e.getX() + "," + e.getY() + "]");
			
		}

		@Override
		public void mouseReleased(MouseEvent e)
		{
		// use a loop to cycle through the labels and do what has to be done
					for(int i = 0; i < labelArray.length; i++)
					{
						if(i == 4)
						{
							labelArray[i].setForeground(Color.ORANGE);
						}
						else
						{
							labelArray[i].setForeground(Color.GRAY);
						}
					}//end for
					
					//print out x,y location of the mouse when the event occurred
					labelArray[5].setText("[" + e.getX() + "," + e.getY() + "]");
			
		}

		
		
	}
	

	public static void main(String[] args)
	{
		// create the object here
		MouseListenerExample object = new MouseListenerExample();

	}	//end main 
}
//end class