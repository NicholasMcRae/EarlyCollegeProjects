/**
 * Program Name:TempConverter_NMcRae.java
 * Program Purpose: The purpose of this program is to create a GUI temp converter application
 * Coder: Nick McRae, 0612749
 * Date: Mar 30, 2012
 */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class SamProgram extends JFrame, JRadioButton
{
	
	//creating components to be included in the GUI Frame
	JLabel nameLabel;
	JLabel radioButtonLabel;
	JLabel sliderLabel;
	JTextField nameEntry;
	

  //Register a listener for the radio buttons.
  
  
  public SamProgram()
  {
  	super("Are you Samantha Desirea Hope Hanz?");
  	
  	public final int WIN_WIDTH = 380;
  	public final int WIN_HEIGHT = 400;
  	
 // setting properties of the frame
		this.setSize(WIN_WIDTH, WIN_HEIGHT);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
	//In initialization code:
	  //Create the radio buttons.
	  JRadioButton birdButton = new JRadioButton("Vampires");
	  birdButton.setActionCommand("Vampires");
	  
	  JRadioButton catButton = new JRadioButton("Candles");
	  catButton.setActionCommand("Candles");

	  JRadioButton dogButton = new JRadioButton("Licorice");
	  dogButton.setActionCommand("Licorice");

	  JRadioButton rabbitButton = new JRadioButton("Seafood");
	  rabbitButton.setActionCommand("Seafood");
	  
	  JRadioButton pigButton = new JRadioButton("Mitzi");
	  pigButton.setActionCommand("Mitzi");
	  
	  birdButton.addActionListener(new ButtonHandler());
	  catButton.addActionListener(new ButtonHandler());
	  dogButton.addActionListener(new ButtonHandler());
	  rabbitButton.addActionListener(new ButtonHandler());
	  pigButton.addActionListener(new ButtonHandler());

	  //Group the radio buttons.
	  ButtonGroup group = new ButtonGroup();
	  group.add(birdButton);
	  group.add(catButton);
	  group.add(dogButton);
	  group.add(rabbitButton);
	  group.add(pigButton);
	  
	//making the frame size non-resizeable
		this.setResizable(false);
		
		//making the frame visible
		this.setVisible(true);
  }
	
	
	
	
	
	
		
	

//main method where we are building and displaying the frame
public static void main(String[] args) 
{
	
	SamProgram samsProgram = new SamProgram();
	
}//end main

//Name: ButtonHandler
//Purpose: to implement the actions performed when the buttons in the application are pressed

public class ButtonHandler implements ActionListener
{
	public void actionPerformed(ActionEvent e)  
	{
		

			
	}
	
	
		
	
	
				
		
	
		
	
		
		
	}// end actionPerformed
	
	
	
}// end ButtonHandler

}//end class