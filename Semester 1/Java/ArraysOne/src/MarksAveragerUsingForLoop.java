/**
 * Program Name: MarksAveragerUsingArray.java
 * Program Purpose: this is a variation on MarksAverager. This version will ask user how many test scores will be entered to
 * set the for loop iteration limit. We'll use a while loop newsted inside the for loop to do the data validation. We'll have the user enter 
 * the range of valid test scores as well to user in our range check. 
 * 
 * Once the mark is validated it will be entered into an array for later processing
 * 
 * Coder: Nick McRae, 0612749
 * Date: Oct 31, 2011
 *      REVISIONS: Wed. Nov 9: added an array to store the marks.
 * the average of all marks entered is calculated and displayed. 
 */

import java.util.Arrays;
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
		 * 4) a) create an array of type double to store the marks
		 * 5) loop
		 * - ask user to enter test score
		 * loop
		 * validate test score
		 * end loop
		 * add valid test score to the array runningTotal
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
		
		//4) a) create an array of type double to store the marks
		double[] testScoresArray = new double [numberOfTests];
		
		//5)set up the loops to validate and calculate
		//outer loop will be the for loop
		for (int i =1; i < testScoresArray.length; i++)
		{
			//a) ask user to enter a value
			System.out.print("Enter test score #" + (i + 1));
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
				//must be a valid test score, add it to the array
					testScoresArray[i] = testScore;
			}
				//reser the flag for the inner while loop for the next iteration of the for loop
				isValid = false;
			}
			// 6) calculate average and display the results
			// use another for loop to process the testScoresArray
			
		}
			for (int i = 0; i < testScoresArray.length; i++)
			{
				runningTotal += testScoresArray[i];//add value to runningTotal
					
				//stub
				System.out.println("runningTotal is now " + runningTotal);
			}
			
			//average was calculated here
			
			//step 1: sort the array from low to high using Arrays.sort()
			Arrays.sort(testScoresArray);
			
			//calculate the median score
			//step 1: need to know if number of elements in array is odd or even
			
			if(testScoresArray.length % 2 != 0)
			{
				//if true, this means array has odd number of elements, calculate index number of middle element using integer
				//division
				
				int indexMiddleElement = testScoresArray.length / 2;
				
				//print out the median value
				
				System.out.println("Median value is " + testScoresArray[indexMiddleElement]);
			}
			else
			{
				//don't need to put another condition because it's either even or odd
				//need to calculate the index numbers of the two middle elements of the array
				
				//calculate the index of the upperMiddleElement by dividing by 2
				int upperMiddleIndex = testScoresArray.length / 2;
				
				// calculate index of lowerMiddleElement by subtracting 1 from upperMiddleIndex
				
				int lowerMiddleIndex = upperMiddleIndex - 1;
				
				//calculate average of the two middle elements and assign to a variable called median
				
				double median = (testScoresArray[upperMiddleIndex] + testScoresArray[lowerMiddleIndex]) / 2;
				
				//report the median!
				System.out.println("Median value is " + median);
			}
			
		
	}
}//end main}
//end class