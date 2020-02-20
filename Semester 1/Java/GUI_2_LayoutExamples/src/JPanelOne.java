/**
 * Program Name:JPanelOne.java
 * Purpose: this class demonstrates the use of JPanels as sub-container
 *         objects within a JFrame. The JPanel thus is acting as a 
 *         container and a component at the same time.
 *         This also shows the common way of doing GUI construction
 *         by extending a class from JFrame and doing all of the 
 *         component placement inside the sub class constructor method.
 * Coder: Bill Pulling
 * Date: Mar 20, 2012
 */

import java.awt.*;
import javax.swing.*;

public class JPanelOne extends JFrame
{
	//constructor
	public JPanelOne()
	{
		//do all the GUI construction here
		
		//call super() and pass up the title bar text
		super("JPanel Demonstration Showing Use of JPanels as Sub Containers");
		
		//standard GUI boilerplate code...
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 300);
		this.setLocationRelativeTo(null);
		
		//set the Layout
		this.setLayout(new GridLayout(0,3) );//gives 3 columns
		
		//create and add three JPanels as sub containers
		JPanel panelOne = new JPanel();
		panelOne.setBackground(Color.GREEN);
		panelOne.setSize(30, 30);//NOTE: the layout manager will over-ride this setting
		this.add(panelOne);
		
		JPanel panelTwo = new JPanel();
		panelTwo.setBackground(Color.WHITE);
		panelTwo.setSize(30, 30);//NOTE: the layout manager will over-ride this setting
		this.add(panelTwo);
		
		JPanel panelThree = new JPanel();
		panelThree.setBackground(Color.RED);
		panelThree.setSize(30, 30);//NOTE: the layout manager will over-ride this setting
		this.add(panelThree);
		
		//make it visible
		this.setVisible(true);
		
		
	}//end constructor
	
}//end class