/**
 * Program Name:OddOrEven.java
 * Program Purpose:uses modulus division to determine if an input value is odd or even
 * Coder: Nick McRae, 0612749
 * Date: Sep 26, 2011
 */

import java.util.Scanner;
public class OddOrEven
{

	public static void main(String[] args)
	{
		// create Scanner object
		Scanner input = new Scanner(System.in);
		int inputValue;
		
		//prompt
		System.out.print("Enter an integer value. . .");
		//read buffer
		inputValue = input.nextInt();
		
		//evaluate the input using an if else statement
		if(inputValue % 2 == 0)
		{
			System.out.println("\n The Value " + inputValue + "is even.");
		}
		else
		{
			System.out.println("\n The Value " + inputValue + " is odd.");
		}

	}
}
//end main}
//end class