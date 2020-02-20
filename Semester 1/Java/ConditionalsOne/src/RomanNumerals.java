/**
 * Program Name: RomanNumerals.java
 * Program Purpose: Have program convert user number entry into a roman numeral.
 * Coder: Nick McRae, 0612749
 * Date: Oct 12, 2011
 */

import java.util.Scanner;
public class RomanNumerals
{

	public static void main(String[] args)
	{
		// PSEUDO-CODE
		
		/*
		 * 1) import scanner class to allow use of scanner
		 * 2) prompt user to enter in a number between 1 and 10 using print method
		 * 3) assign input to a variable
		 * 4) create if-else-if statement for each possibility
		 */
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Please enter a number between 1 and 10");
		
		int numberChoice = input.nextInt();
		
		if (numberChoice == 1)

		{
			System.out.print("The roman numeral equivalent is I.");
		}
		
		else if (numberChoice == 2)
			
		{
			System.out.print("The roman numeral equivalent is II.");
		}
	}
}//end main}
//end class