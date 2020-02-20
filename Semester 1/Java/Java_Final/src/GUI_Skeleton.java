/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Apr 18, 2012
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI_Skeleton
{
	
	JavaPractice()
	{
		super("Samantha's Crazy Calculator");
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
					
		this.setVisible(true);		
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}//end main
	
	
	public class ButtonHandler implements ActionListener
	{
		
			
		//implement the abstract method of the ActionListener interface
		public void actionPerformed(ActionEvent e)
		{
			
			if(e.getActionCommand().equals("X"))
			{
											
				
			}
			if(e.getActionCommand().equals("/"))
			{
										
				
			}
			if(e.getActionCommand().equals("+"))
			{
										
				
			}
			if(e.getActionCommand().equals("-"))
			{
									
				
			}
			
			if(e.getSource().equals("Clear")) 
			{
				
			}
			
			
			
		}//end actionevent method
		
	}//end inner class
	
}//end outer class