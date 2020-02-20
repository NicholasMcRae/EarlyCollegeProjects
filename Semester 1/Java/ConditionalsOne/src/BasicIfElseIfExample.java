/**
 * Program Name: BasicIfElseExample.java
 * Program Purpose:Shows an if else if type of multiple selection structure
 * Coder: Nick McRae, 0612749
 * Date: Oct 3, 2011
 */

public class BasicIfElseIfExample
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
		
		else if(numOne < 4)
		{
			//this block statement runs if expression is false
			System.out.println("Value of numOne is " + numOne + " and is less than 4.");
		}
		
		else //can change this to an else if statement
		{
			System.out.println("Value of numOne is " + numOne + " and is equal to 4");
		}
		//next line of code
		System.out.println("This is the next line after the if");
	}
}
//end main}
//end class