/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Apr 11, 2012
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.Event;
import java.awt.*;

public class Sketchframe4 extends JFrame
{
	//class scope variables here
	private JMenuBar menuBar = new JMenuBar();
	
	private JMenuItem newItem, openItem, closeItem, saveItem;
	private JMenuItem saveAsItem, printItem;
	
	private JRadioButtonMenuItem lineItem, rectangleItem;
	private JCheckBoxMenuItem redItem, greenItem, blueItem;
	
	//constructor 
	
	public Sketchframe4()
	{
		super("Examples of diffferent menu items in Java");
		this.setSize(500,400);
		this.setLayout(new FlowLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//add the menuBar 
		this.setJMenuBar(menuBar);
		
		//create File and element menus
		JMenu fileMenu = new JMenu("File");
		JMenu elementMenu = new JMenu("Element");
		
		menuBar.add(fileMenu);
		menuBar.add(elementMenu);
		
		//now add some menu items to the menu
		fileMenu.setMnemonic('F');
		elementMenu.setMnemonic('E');
		
		//build the fileMenu items
		newItem = fileMenu.add("New");
		openItem = fileMenu.add("Open");
		closeItem = fileMenu.add("Close");
		
		//add a separator bar 
		fileMenu.addSeparator();
		
		saveItem = fileMenu.add("Save");
		saveAsItem = fileMenu.add("Save as");
		fileMenu.addSeparator();
		printItem = fileMenu.add("Print");
		
		//add the short cut or accelerator key options
		
		newItem.setAccelerator(KeyStroke.getKeyStroke('N', Event.CTRL_MASK));
		
		this.setVisible(true);
		
		//create the menu element items
		lineItem = new JRadioButtonMenuItem("Line", false);//show it not pressed
		elementMenu.add(lineItem);
		
		//shortcut way...
		elementMenu.add(rectangleItem = new JRadioButtonMenuItem("Rectangle", false));
		
		//add one accelerator key for the lineItem
		lineItem.setAccelerator(KeyStroke.getKeyStroke('L',Event.CTRL_MASK));
		
		//add a Sub menu for the color check boxes
		JMenu colorMenu = new JMenu("Color");
		//add this as an item to the element menu
		elementMenu.add(colorMenu);
		
		redItem = new JCheckBoxMenuItem("Red", false);//box is unchecked when it appears
		colorMenu.add(redItem);
		
		greenItem = new JCheckBoxMenuItem("Green", false);//box is unchecked when it appears
		colorMenu.add(greenItem);
		
		blueItem = new JCheckBoxMenuItem("Blue", false);//box is unchecked when it appears
		colorMenu.add(blueItem);
		
	}

	public static void main(String[] args)
	{
		// create an anonymous object to run it

	}
}//end main}
//end class