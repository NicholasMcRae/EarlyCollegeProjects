/**
 * Program Name:Validation3DoWhile.java
 * Program Purpose: same logic as validationOne example but this one uses a do-while loop instead of a while loop
 * Coder: Nick McRae, 0612749
 * Date: Oct 19, 2011
 */

import java.util.Scanner;
public class Validation3DoWhile
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
		
		do
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
		}while(isValid);
		System.out.print("End of program");
		

	}
}//end main}
//end class