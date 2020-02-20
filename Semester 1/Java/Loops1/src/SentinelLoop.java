/**
 * Program Name: SentinelLoop.java
 * Program Purpose:shows the use of a sentinel controlled while loop. User enters values that are added to an ACCUMUlATOR
 * variable (a fancy name for a runningTotal). To end the data entry here, the user will enter a value of -1 as the sentinel 
 * value. 
 * Coder: Nick McRae, 0612749
 * Date: Oct 24, 2011
 */

import java.util.Scanner;
public class SentinelLoop
{

	public static void main(String[] args)
	{
		// create Scanner
		Scanner input = new Scanner(System.in);
		
		int userInput;
		
		//create an accumulator variable to hold a running total
		int runningTotal = 0;
		
		boolean isSentinelValue = false;
		
		// set up while loop to user the isSentinelValue flag
		
		while(!isSentinelValue)
		{
			//prompt
			System.out.print("Enter a positive integer value, or -1 to exit...");
			userInput = input.nextInt();
			
			//evaluate the user input to see if it is the sentinel value
			
			if(userInput == -1)
			{
				//change the value of the flag variable
				isSentinelValue = true;
			}
			else
			{
				//add the inputValue to the runningTotal
				
				runningTotal += userInput;
			}
			
			
		}// end while
		
		//stub
		System.out.println("Finished the loop");
		System.out.println("Value in runningtotal is " + runningTotal);
	}
}//end main}
//end class