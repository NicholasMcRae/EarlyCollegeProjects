/**
 * Program Name:BasicWhileLoopExample.java
 * Program Purpose: shows a basic while loop structure
 * Coder: Nick McRae, 0612749
 * Date: Oct 17, 2011
 */

public class BasicWhileLoopExample
{

	public static void main(String[] args)
	{
		// variables
		int sum = 0;
		int num1 = 1;
		
		//set up a while loop
		while(sum<5)
		{
			sum = sum + num1;
			System.out.println("Inside loop on iteration#" + sum);
		}

	}
}//end main}
//end class