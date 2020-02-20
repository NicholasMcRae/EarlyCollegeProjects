/**
 * Program Name: BasicIfElseExample.java
 * Program Purpose:To show an if else statement
 * Coder: Nick McRae, 0612749
 * Date: Oct 3, 2011
 */

public class BasicIfElseExample
{

	public static void main(String[] args)
	{
		// variable
		int numOne = 3;
		
		//test value of numOne using an if
		if(numOne > 4)
		{
			//block statement will only run if expression evaluates to true
			System.out.println("Value of numOne is " + numOne + " and is greater than 4.");
		}
		
		else
		{
			//this block statement runs if expression is false
			System.out.println("Value of numOne is " + numOne + " and is less than 4.");
		}
		//next line of code
		System.out.println("This is the next line after the if");
	}
}
//end main}
//end class