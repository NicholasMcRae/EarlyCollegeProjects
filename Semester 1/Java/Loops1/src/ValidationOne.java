/**
 * Program Name:ValidationOne.java
 * Program Purpose: shows the use of a while loop to act as a data validation routine
 * Coder: Nick McRae, 0612749
 * Date: Oct 19, 2011
 */

import java.util.Scanner;
public class ValidationOne
{

	public static void main(String[] args)
	{
		// create scanner
		
		Scanner input = new Scanner(System.in); 
		
		//flag
		boolean isValid = true;
		int userInput;
		//ask user to enter an even integer value
		// do this inside a while loop tha tkeeps the user in the loop until they enter a valid value
		
		while(isValid)
		{
			System.out.print("Enter an even integer value...");
			//read buffer
			userInput = input.nextInt();
			
			//evaluate the input using modulus division and an if
			
			if(userInput%2 ==0)
			{
				System.out.println("Your entry of " + userInput + " is an even number. Thank you!");
				
				//change the value of flat notValid to false to exit the loop
				isValid = false;
			}
			else
			{
				System.out.println("Your entry of " + userInput + " is an odd number. Please re-enter an even number.");
			}
		}
		System.out.print("End of program");
		

	}
}//end main}
//end class