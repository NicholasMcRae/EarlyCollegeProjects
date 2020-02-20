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


public class TempConverter_NMcRae extends JFrame
{
	
	//creating components to be included in the GUI Frame
	JLabel labelFarenheit;
	JLabel labelCelsius;
	JLabel labelKelvin;
	JTextField fieldFarenheit;
	JTextField fieldCelsius;
	JTextField fieldKelvin;
	JButton tempConverterButton, clearButton;
	public final int WIN_WIDTH = 380;
	public final int WIN_HEIGHT = 400;
	
	
	
	//constructor to build the frame
	public TempConverter_NMcRae() 
	{
		//Text to be included in the title bar of the frame
		super("Nicholas McRae's Temperature Converter");
		
		// setting properties of the frame
		this.setSize(WIN_WIDTH, WIN_HEIGHT);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//building panel in the frame
		JPanel westPanel = new JPanel();
		westPanel.setLayout(new GridLayout(4, 1, 1, 1));
		
		//building components to add to gridlayout of west panel in the frame
		this.labelFarenheit = new JLabel("Farenheit");
		this.labelCelsius = new JLabel("Celsius");
		this.labelKelvin = new JLabel("Kelvin");
		this.tempConverterButton = new JButton("Convert!");
				
		//adding components to the westpanel
		westPanel.add(labelFarenheit);
		westPanel.add(labelCelsius);
		westPanel.add(labelKelvin);
		westPanel.add(tempConverterButton);
		
		//adding the westPanel to the frame		
		this.add(westPanel, BorderLayout.WEST);
		
		//building the east panel where the fields and clear button will be held
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new GridLayout(4, 1, 5, 5));
		
		//creating objects of textfields in the constructor
		fieldFarenheit = new JTextField("", 20);
		fieldCelsius = new JTextField();
		fieldKelvin = new JTextField();
		this.clearButton = new JButton ("Clear!");
				
		//adding fields and button to the eastPanel
		eastPanel.add(fieldFarenheit);
		eastPanel.add(fieldCelsius);
		eastPanel.add(fieldKelvin);
		eastPanel.add(clearButton);
		//adding the eastPanel to the frame
		this.add(eastPanel, BorderLayout.EAST);
		
		
		
		//adding listeners to the buttons
		tempConverterButton.addActionListener(new ButtonHandler());
		clearButton.addActionListener(new ButtonHandler());
		
		//making the frame size non-resizeable
		this.setResizable(false);
		
		//making the frame visible
		this.setVisible(true);
		
	}
	
	
	

//main method where we are building and displaying the frame
public static void main(String[] args) throws InvalidTempException
{
	
	TempConverter_NMcRae tempGUIApplication = new TempConverter_NMcRae();
	
	

}//end main

//Name: ButtonHandler
//Purpose: to implement the actions performed when the buttons in the application are pressed

public class ButtonHandler implements ActionListener, ConversionMethods 
{
	public void actionPerformed(ActionEvent e)  
	{
		
	//declaring variables that are going to be used to retrieve and output data to and from the text fields
	String farenheitInput;
	String celsiusInput;
	String kelvinInput;
	
	//variables to hold the parsed string values in the text fields to do math with
	double parsedFarenheit;
	double parsedCelsius;
	double parsedKelvin;
	double convertedFar;
	double convertedCel;
	double convertedKel;
	
	
	//if the convert button is pressed and there is something in the Kelvin field do the math and populate
	//the other fields
	if(e.getActionCommand().equals("Convert!") && fieldFarenheit.getText().trim().length() == 0 
		&& fieldCelsius.getText().trim().length() == 0)
	{
		kelvinInput = fieldKelvin.getText();
		parsedKelvin = Double.parseDouble(kelvinInput);
		
		convertedCel = kelToCel(parsedKelvin);
		convertedFar = kelToFar(parsedKelvin);
	
		farenheitInput = Double.toString(convertedFar);
		celsiusInput = Double.toString(convertedCel);
		
		if(parsedKelvin < 0)
		{
			fieldFarenheit.setText("Incorrect kelvin value");
			fieldCelsius.setText("Incorrect kelvin value");
		}		
		else
		{
		fieldFarenheit.setText(farenheitInput);
		fieldCelsius.setText(celsiusInput);
		}
			
	}
	
	//if the convert buttion is pressed and there is something in the farenheit field then populate the other
	//fields
	if(e.getActionCommand().equals("Convert!") && fieldKelvin.getText().trim().length() == 0 
			&& fieldCelsius.getText().trim().length() == 0)
		{
			farenheitInput = fieldFarenheit.getText();
			parsedFarenheit = Double.parseDouble(farenheitInput);
			convertedCel = farToCel(parsedFarenheit);
			convertedKel = farToKel(parsedFarenheit);
		
			kelvinInput = Double.toString(convertedKel);
			celsiusInput = Double.toString(convertedCel);
			
			
			if(parsedFarenheit < -459.66999999999996)
			{
				fieldKelvin.setText("Incorrect farenheit value");
				fieldCelsius.setText("Incorrect farenheit value");		
			}
			else
			{
			fieldKelvin.setText(kelvinInput);
			fieldCelsius.setText(celsiusInput);
			}
		}
	
	//if there is something in the celsius field and the convert buttion is pressed populate the other fields
	if(e.getActionCommand().equals("Convert!") && fieldKelvin.getText().trim().length() == 0 
			&& fieldFarenheit.getText().trim().length() == 0)
		{
			celsiusInput = fieldCelsius.getText();
			parsedCelsius = Double.parseDouble(celsiusInput);
			
			convertedFar = celToFar(parsedCelsius);
			convertedKel = celToKel(parsedCelsius);
		
			farenheitInput = Double.toString(convertedFar);
			kelvinInput = Double.toString(convertedKel);
			
			
			if(parsedCelsius < -273.15)
			{
				fieldFarenheit.setText("Incorrect celsius value");
				fieldKelvin.setText("Incorrect celsius value");
			}
			else
			{
			fieldFarenheit.setText(farenheitInput);
			fieldKelvin.setText(kelvinInput);
			}
				
		}
	
		
	//if the clear button is pressed clear the data from all of the fields
	if(e.getActionCommand().equals("Clear!"))
	{
		fieldFarenheit.setText("");
		fieldKelvin.setText("");
		fieldCelsius.setText("");
	}
		
		
	}// end actionPerformed
	
	
	//Name: farToCel
	//Purpose: convert fahrenheit to celsius
	//Accepts: double fahrenheit value
	//Returns: double celsius value
	
	public double farToCel(double f)
	{
		return (double)5/9 *(f -32);
	}
	
	//Name: farToKel
	//Purpose: convert fahrenheit to kelvin
	//Accepts: double fahrenheit value
	//Returns: double kelvin value
	
	public double farToKel (double f)
	{
		return (((double)5/9) * (f - 32) + 273 );
	}
	
	//Name: celToFar
	//Purpose: convert celsius to fahrenheit
	//Accepts: double celsius value
	//Returns: double fahrenheit value
	
	public double celToFar (double c)
	{
		return c * ((double)9/5) + 32;
	}
	
	//Name: celToKel
	//Purpose: convert celsius to kelvin
	//Accepts: double celsius value
	//Returns: double kelvin value
	
	public double celToKel (double c)
	{
		return c + 273.15;
	}
	
	//Name:  kelToFar
	//Purpose: convert kelvin to fahrenheit
	//Accepts: double kelvin value
	//Returns: double fahrenheit value
	
	public double kelToFar (double k)
	{
		return ((k - 273) * 1.8 ) + 32;
	}
	
	//Name: kelToCel
	//Purpose: converts kelvin to Celsius
	//Accepts: double kelvin value
	//Returns: double fahrenheit value 
	
	public double kelToCel (double k)
	{
		return k - 273.15;
	}
	
}// end ButtonHandler

}//end class