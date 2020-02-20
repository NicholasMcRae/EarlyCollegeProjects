/**
 * Program Name:WhatAPane.java
 * Program Purpose: shows use of a JOptionPane to get user input.
 * Coder: Nick McRae, 0612749
 * Date: Sep 26, 2011
 */
import javax.swing.JOptionPane;
public class WhataPane
{

	public static void main(String[] args)
	{
		// create a variable to store user name;
		String userName;
		
		//call up a JOptionPane dialog box to get the data
		userName = JOptionPane.showInputDialog("Enter your full name...");
		
		//output to console
		System.out.println("Your name is " + userName);
		
		//ask user to enter their age
		// note: JOptionPane always reads in data as a String
		//Line below will not compile due to data type mismatch
		//int age = JOptionPane.showInputDialog("Enter your age...");
		
		//what we need to do is change the above line to string
		
		String age = JOptionPane.showInputDialog("Enter your age...");
		
		System.out.println("Your age is " + age);
		
		//to do math on the age we need to PARSE the string variable
		//to do this we make use of the Integer class
		//this method can take a string that looks like an int and turn it into an int value
		
		int intage = Integer.parseInt(age); //parses the string to an int and assigns it to intAge
		
		//add ten to intAge
		//intAge += 10;
		//System.out.println("Your age plus ten years is actually " + intAge);

	}
}
//end main}
//end class