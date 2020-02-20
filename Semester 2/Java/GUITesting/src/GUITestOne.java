/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Mar 27, 2012
 */

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class GUITestOne extends JFrame
{
	final private int WIN_HEIGHT = 400;
	final private int WIN_WIDTH = 400;
	
	public GUITestOne()
	{
		
		setTitle("Nick's Realm of Windowness");
		setSize(WIN_WIDTH, WIN_HEIGHT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GridLayout layoutManager = new GridLayout (2,3,50,50);
		
		setLayout(layoutManager);
		
		JButton button1 = new JButton("Sup" );
		
		add(button1);
		
		JButton button2 = new JButton("nothin");
		
		add(button2);
		
		JButton button3 = new JButton("oh, that's boring");
		
		add(button3);
		
		JButton button4 = new JButton("sorry");
		
		add(button4);
		
		setLocationRelativeTo(null);
		
			//step two: assign it to the JFrame.
	
		
		setVisible(true);
		
	}
	
	
	
}//end class