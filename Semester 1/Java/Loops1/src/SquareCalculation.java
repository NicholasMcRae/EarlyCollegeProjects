/**
 * Program Name:SquaresCalculation.java
 * Program Purpose: this app will ask the user to enter an integer, and it will then print out the squares of all the numbers
 * from 1 up to the user entered value.
 * Also uses the user entered value to set the number of iterations of the for loop.
 * Coder: Nick McRae, 0612749
 * Date: Oct 31, 2011
 */

import java.util.Scanner;
public class SquareCalculation
{

	public static void main(String[] args)
	{
		// PSEUDO-CODE
		/*
		 * 1) explain to user what will happen
		 * 2) prompt user to enter an integer value
		 * 3) set up a for loop using the input value as the upper limit for the iterations of the loop.
		 * LOOP
		 *  print value of loop counter and value of loop counter multiplied by itself to produce the square
		 * 4) Say good-bye
		 */
		//1) explain to user what will happen
		System.out.println("This program will calculate the squares of numbers from 1 up to the limit number entered" +
				" by you.");
		
		//1a) create scanner object
		Scanner input = new Scanner(System.in);
		
		//2) prompt user to enter an integer value
		System.out.print("Enter an integer number as the upper limit.");
		
		int upperLimit = input.nextInt();
		
		//put in column headings for the two numbers displayed
		System.out.println("\nNUMBER        Number SQUARED");
		System.out.println("_______________________________");
		
		//3) loop
		for(int i = 1; i <= upperLimit; i++)
		{
			//print out counter and its squared valuee
			System.out.println(i + "\t\t" + i*i);
			
		}//end for
		
		//4) Say good-bye
		System.out.println("\n Goodbye!");
	}
}//end main}
//end class