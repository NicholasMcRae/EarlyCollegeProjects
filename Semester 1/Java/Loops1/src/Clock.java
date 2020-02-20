/**
 * Program Name:Clock.java
 * Program Purpose: from the textbook, pages 211-212. Shows the use of a three level nested for loop to simulate a digital
 * clock. Also shows use of the DecimalFormat class to format the decimal output.
 * Coder: Nick McRae, 0612749
 * Date: Oct 31, 2011
 */

import java.text.DecimalFormat;
public class Clock
{

	public static void main(String[] args)throws InterruptedException
	{
		// create a DecimalFormat object to use to format output
		DecimalFormat formatObject = new DecimalFormat("00");
		
		//create a three level nested for loop structure
		//outer loop will be hours, middle loop minutes, inner loop will be seconds
		
		//outer loop
		for(int hours = 1; hours <= 12; hours++)
		{
			//middle or minutes loop
			for(int minutes = 0; minutes <= 59; minutes++)
			{
				//set up inner seconds loop
				for(int seconds = 0; seconds <= 59; seconds++)
				{
					System.out.print(formatObject.format(hours) + ":");
					System.out.print(formatObject.format(minutes) + ":");
					System.out.println(formatObject.format(seconds));
					
					//introduce a one second delay after each iteration of the inner loop
					Thread.sleep(1000);
					
				}//end seconds 
			}//end minutes
		}//end hours loop

	}
}//end main}
//end class