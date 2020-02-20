/**
 * Program Name: MarksAveragerUsingForLoop.java
 * Program Purpose: this is a variation on MarksAverager. This version will ask user how many test scores will be entered to
 * set the for loop iteration limit. We'll use a while loop newsted inside the for loop to do the data validation. We'll have the user enter 
 * the range of valid test scores as well to user in our range check. 
 * Coder: Nick McRae, 0612749
 * Date: Oct 31, 2011
 * 
 * the average of all marks entered is calculated and displayed. 
 */

import java.util.Scanner;
public class MarksAveragerUsingForLoop
{

	public static void main(String[] args)
	{
		// pseudo-code
		/*
		 * 1) create Scanner and necessary variables to accept test marks as double values. 
		 * 2) ask user what lowest possible score is
		 * 3) ask user what highest possible score is.
		 * 4) ask user how many test scores will be entered. 
		 * 5) loop
		 * - ask user to enter test score
		 * loop
		 * validate test score
		 * end loop
		 * add test score to runningTotal
		 * end loop
		 * 
		 * 
		 */

		//1) create Scanner and necessary variables to accept test marks as double values.
		
		Scanner input = new Scanner(System.in);
		double testScore = 0; //user as the variable to hold user input
		double runningTotal = 0;
		int numberOfTests = 0;
		double lowestPossibleScore = 0;
		double highestPossibleScore = 0;
		double average = 0;
		
		boolean isValid = false;
		
		//2) ask user what lowest possible score is
		System.out.println("Enter lowest possible score on the test: ");
		lowestPossibleScore = input.nextDouble();
		
		//3) ask user what highest possible score is
		System.out.println("Enter highest possible score on the test: ");
		highestPossibleScore = input.nextDouble();
		
		//4) ask user how many test scores will be eentered.
		System.out.println("Enter number of test scores to be entered: ");
		numberOfTests = input.nextInt();
		
		//5)set up the loops to validate and calculate
		//outer loop will be the for loop
		for (int i =1; i <= numberOfTests; i++)
		{
			//a) ask user to enter a value
			System.out.print("Enter test score #" + i);
			testScore = input.nextDouble();
			
			while(!isValid)
			{
				//b) validate the test score
				if(testScore < lowestPossibleScore || testScore > highestPossibleScore)
				{
					System.out.println("\nInvalid test score, please re-enter...");
					//read the keyboard
					testScore = input.nextDouble();
				}
				else
				{
				//must be a valid test score
					runningTotal += testScore;
			}
				//reser the flag for the inner while loop for the next iteration of the for loop
				isValid = false;
			}
				
		}
	}
}//end main}
//end class