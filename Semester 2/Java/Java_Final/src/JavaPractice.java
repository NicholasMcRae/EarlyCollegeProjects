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

public class JavaPractice extends JFrame
{
	
	JButton calcButton, clearButton, multiply, divide, subtract, add;
	JPanel bottomPanel, topPanel;
	JTextField fieldOne, fieldTwo, resultField;
	JLabel labelOne, labelTwo, resultLabel;
	
	JavaPractice()
	{
		super("Samantha's Crazy Calculator");
		this.setSize(500, 500);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		topPanel = new JPanel();
		bottomPanel = new JPanel();
		
		bottomPanel.setLayout(new GridLayout(1,6,5,5));
		topPanel.setLayout(new GridLayout(3,2,5,5));
		
		clearButton = new JButton("Clear");
		multiply = new JButton("X");
		divide = new JButton("/");
		subtract = new JButton("-");
		add = new JButton("+");
		
		bottomPanel.add(clearButton);
		bottomPanel.add(multiply);
		bottomPanel.add(divide);
		bottomPanel.add(subtract);
		bottomPanel.add(add);
		
		labelOne = new JLabel("Number One");
		labelTwo = new JLabel("Number Two");
		resultLabel = new JLabel("Result");
		fieldOne = new JTextField();
		fieldTwo = new JTextField();
		resultField = new JTextField();
		
		topPanel.add(labelOne);
		topPanel.add(fieldOne);
		topPanel.add(labelTwo);
		topPanel.add(fieldTwo);
		topPanel.add(resultLabel);
		topPanel.add(resultField);
		
		this.add(bottomPanel, BorderLayout.SOUTH);
		this.add(topPanel, BorderLayout.CENTER);
		
		clearButton.addActionListener(new ButtonHandler());
		multiply.addActionListener(new ButtonHandler());
		divide.addActionListener(new ButtonHandler());
		subtract.addActionListener(new ButtonHandler());
		add.addActionListener(new ButtonHandler());
		
		this.setVisible(true);		
	}
	

	public static void main(String[] args)
	{
		JavaPractice showFrame = new JavaPractice();

	}//end main
	
	
	public class ButtonHandler implements ActionListener
	{
		
			
		//implement the abstract method of the ActionListener interface
		public void actionPerformed(ActionEvent e)
		{
			
			String firstEntry;
			String secondEntry;
			double firstDouble;
			double secondDouble;
			double result;
			String stringInput;
			
			if(e.getActionCommand().equals("X"))
			{
				firstEntry = fieldOne.getText();
				secondEntry = fieldTwo.getText();
				firstDouble = Double.parseDouble(firstEntry);
				secondDouble = Double.parseDouble(secondEntry);
				result = (double)firstDouble / secondDouble;
				stringInput = Double.toString(result);
				
				resultField.setText(stringInput);
				
							
				
			}
			if(e.getActionCommand().equals("/"))
			{
				firstEntry = fieldOne.getText();
				secondEntry = fieldTwo.getText();
				firstDouble = Double.parseDouble(firstEntry);
				secondDouble = Double.parseDouble(secondEntry);
				result = firstDouble * secondDouble;
				stringInput = Double.toString(result);
				
				resultField.setText(stringInput);
							
				
			}
			if(e.getActionCommand().equals("+"))
			{
				firstEntry = fieldOne.getText();
				secondEntry = fieldTwo.getText();
				firstDouble = Double.parseDouble(firstEntry);
				secondDouble = Double.parseDouble(secondEntry);
				result = firstDouble - secondDouble;
				stringInput = Double.toString(result);
				
				resultField.setText(stringInput);
							
				
			}
			if(e.getActionCommand().equals("-"))
			{
				firstEntry = fieldOne.getText();
				secondEntry = fieldTwo.getText();
				firstDouble = Double.parseDouble(firstEntry);
				secondDouble = Double.parseDouble(secondEntry);
				result = firstDouble + secondDouble;
				stringInput = Double.toString(result);
				
				resultField.setText(stringInput);
							
				
			}
			
			if(e.getSource().equals("Clear")) 
			{
				fieldOne.setText("");
				fieldTwo.setText("");
				resultField.setText("");
			}
			
			
			
		}
		
	}
	
	
}//end class