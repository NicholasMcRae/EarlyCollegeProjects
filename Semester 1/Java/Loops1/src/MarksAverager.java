/**
 * Program Name: Marksaverager.java
 * Program Purpose: allows user to enter a series of marks ranging from 0 to 10. This version will employ some data validation
 * to make sure that no mark greater than 10 can be entered.
 * the only negative value allowed will be a sentinel value of -1, which will be used to end the data input. 
 * Coder: Nick McRae, 0612749
 * Date: Oct 24, 2011
 */

import java.util.Scanner; 
public class MarksAverager
{

	public static void main(String[] args)
	{
		// Pseudocode 
		
		/*
		 * 1) Explain to user what to enter, and how to end.
		 * 2) Create scanner object
		 * 3) create variables to hold runningTotal of test scores and the number of test scores entered. 
		 * 4) set up a sentinel controlled while loop that uses a boolean flag variable tied to the sentinel value of -1
		 * 
		 * 5) loop
		 *    a) ask user to enter the test mark or a -1 to exit
		 *    b) read the buffer for the value
		 *    c) IF
		 *        user has entered sentinel value change the flag to end the loop flag variable to exit. 
		 *       ELSE
		 *         validate the data using an outside the fence check
		 *         IF valid, then:
		 *        add the input mark to the running total AND increment the testCounter variable
		 *        ELSE
		 *          - tell the user the data is invalid and ask them to re-enter the data. 
		 *     END LOOP
		 *     
		 * 6) calculate the average and display the result. 
		 */
		System.out.println("welcome to the marks averager program.");
		System.out.println("Enter your marks from 0 to 10, or -1  to exit");
		
		//create Scanner object
		Scanner input = new Scanner(System.in); 
		
		//create variables to hold runningtotal of test scores
		
		int runningTotal = 0;
		int testCount = 0;//number of test marks entered
		int userInput = 0;
		
		//set up a sentinel controlled while loop that uses a boolean flag variable tied to the sentinel value of -1
		boolean isSentinelValue = false;
		
		while(!isSentinelValue)
		{
			System.out.println("Enter a mark from zero to ten, or -1 to exit");
			
			//read the buffer
			userInput = input.nextInt();
			
			//check for sentinel value
			if(userInput == -1)
			{
				//change value of isSentinel to true
				isSentinelValue = true;
			}//end if
			
			//validate the data
			else if(userInput < 0 || userInput > 10)
			{
				//tell them its invalid
				System.out.println("\nInvalid value: please re-enter.");
			}
			
			else //if we get here the data must be valid
			{
				//add to the runningTotal
				runningTotal += userInput;
				
				//increment the testCounter
				testCount ++;
			}
		}// end while
		double average = (double)runningTotal/testCount;
		
		//display
		System.out.println("The average of your tests is " + average);
	

	}
}//end main}
//end class