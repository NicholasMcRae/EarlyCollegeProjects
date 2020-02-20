/**
 * Program Name: Andrea_Mcrae_CellPhone.java
 * Purpose: this app simulate a cell phone using a borderLayout. It uses action listeners to display
 * 					the key functions to the JTextArea. 
 * Coding Team: Andrea Doroshenko, Nicholas McRae
 * Date: Mar 28, 2012
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Andrea_Mcrae_CellPhone extends JFrame
{
	JTextArea cellText;
	JButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonSend,
					buttonBlank, buttonEnd, buttonStar, buttonPound;
	
	// Constructor
	public Andrea_Mcrae_CellPhone()
	{
		super("Andrea McRae");
		
		// Standard boilerplate code
		this.setSize(225, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		

		
		// Create text area
		this.cellText = new JTextArea("\n\n\n------------------NO SERVICE------------------");
	
		this.add(cellText, BorderLayout.CENTER);
		
		// Create the bottom panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new GridLayout(5, 3, 1, 1));
		
		// Create buttons
		button1 = new JButton("1");
		button2 = new JButton("2");
		button3 = new JButton("3");
		button4 = new JButton("4");
		button5 = new JButton("5");
		button6 = new JButton("6");
		button7 = new JButton("7");
		button8 = new JButton("8");
		button9 = new JButton("9");
		buttonStar = new JButton("*");
		buttonPound = new JButton("#");
		button0 = new JButton("0");
		buttonSend = new JButton("SEND");
		buttonBlank = new JButton("");
		buttonEnd = new JButton("END");
		
		button1.addActionListener(new ButtonHandler());
		button2.addActionListener(new ButtonHandler());
		button3.addActionListener(new ButtonHandler());
		button4.addActionListener(new ButtonHandler());
		button5.addActionListener(new ButtonHandler());
		button6.addActionListener(new ButtonHandler());
		button7.addActionListener(new ButtonHandler());
		button8.addActionListener(new ButtonHandler());
		button9.addActionListener(new ButtonHandler());
		button0.addActionListener(new ButtonHandler());
		buttonPound.addActionListener(new ButtonHandler());
		buttonStar.addActionListener(new ButtonHandler());
		buttonSend.addActionListener(new ButtonHandler());
		buttonBlank.addActionListener(new ButtonHandler());
		buttonEnd.addActionListener(new ButtonHandler());
		
		
		// Add the buttons
		bottomPanel.add(button1);
		bottomPanel.add(button2);
		bottomPanel.add(button3);
		bottomPanel.add(button4);
		bottomPanel.add(button5);
		bottomPanel.add(button6);
		bottomPanel.add(button7);
		bottomPanel.add(button8);
		bottomPanel.add(button9);
		bottomPanel.add(buttonStar);
		bottomPanel.add(button0);
		bottomPanel.add(buttonPound);
		bottomPanel.add(buttonSend);
		bottomPanel.add(buttonBlank);
		bottomPanel.add(buttonEnd);
		
		// Add bottom panel to JFrame
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		
		this.setVisible(true);
	}

	public static void main(String[] args)
	{
		Andrea_Mcrae_CellPhone mc = new Andrea_Mcrae_CellPhone();

	}//end main
	

	private class ButtonHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			if(e.getActionCommand().equals("1") )
			{
				cellText.setText("");
				cellText.replaceSelection("1");
			}
			else if(e.getActionCommand().equals("2") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("2");
			}
			else if(e.getActionCommand().equals("3") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("3");
			}
			else if(e.getActionCommand().equals("4") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("4");
			}
			else if(e.getActionCommand().equals("5") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("5");
			}
			else if(e.getActionCommand().equals("6") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("6");
			}
			else if(e.getActionCommand().equals("7") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("7");
			}
			else if(e.getActionCommand().equals("8") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("8");
			}
			else if(e.getActionCommand().equals("9") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("9");
			}
			else if(e.getActionCommand().equals("0") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("0");
			}
			else if(e.getActionCommand().equals("*") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("*");
			}
			else if(e.getActionCommand().equals("#") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("#");
			}
			else if(e.getActionCommand().equals("SEND") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("\ndialing the number...");
			}
			else if(e.getActionCommand().equals("END") )
			{
				if(cellText.getText().equals("\n\n\n------------------NO SERVICE------------------"))
				{
					cellText.setText("");
				}
				cellText.replaceSelection("\ncall ended...");
			}
		}// end actionPerformed
		
	}// end ButtonHandler
	
	
}//end class