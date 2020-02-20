/**
 * Program Name:BasicBreakExample.java
 * Program Purpose:shows the use of the break keyword to exit from an infinite loop.
 * Coder: Nick McRae, 0612749
 * Date: Oct 26, 2011
 */
import java.util.Scanner;
public class BasicBreakExample
{

	public static void main(String[] args)
	{
		// create Scanner
		Scanner input = new Scanner(System.in);
		
		//variables
		int runningTotal = 0;
		
		int userInput = 0;
		
		//prompt for data input inside an infinite while loop
		// and use -1 as the sentinel value
		
		while(true)
		{
			//prompt
			System.out.print("Enter a value, or -1 to exit: ");
			userInput = input.nextInt();
			
			//check for sentinel value
			if(userInput == -1)
			{
				break;//will terminate the loop
			}
			else
			{
				//add userInput to runningTotal
				runningTotal += userInput;
			}
			
		}//end while
		
		 //output the total
		System.out.println("Value in runningTotal is " + runningTotal);

	}
}//end main}
//end class