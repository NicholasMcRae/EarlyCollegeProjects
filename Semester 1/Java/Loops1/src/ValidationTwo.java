/**
 * Program Name:ValidationOne.java
 * Program Purpose: shows the use of a while loop to act as a data validation routine, this time using a NOT operator and a different name for the boolean flag variable, 
 * requiring us to adjust a few things
 * Coder: Nick McRae, 0612749
 * Date: Oct 19, 2011
 */

import java.util.Scanner;
public class ValidationTwo
{

	public static void main(String[] args)
	{
		// create scanner
		
		Scanner input = new Scanner(System.in); 
		
		//flag
		//in class in validation one I was supposed to use notValid, and here we were supposed to change to isValid
		boolean isValid = false;
		int userInput;
		//ask user to enter an even integer value
		// do this inside a while loop tha tkeeps the user in the loop until they enter a valid value
		
		while(!isValid) //very commonly seen code to see a not operator
		{
			System.out.print("Enter an even integer value...");
			//read buffer
			userInput = input.nextInt();
			
			//evaluate the input using modulus division and an if
			
			if(userInput%2 ==0)
			{
				System.out.println("Your entry of " + userInput + " is an even number. Thank you!");
				
				//change the value of flat notValid to false to exit the loop
				isValid = true;
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