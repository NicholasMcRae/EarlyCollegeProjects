/**
 * Program Name:BasicDoWhileLoopExample.java
 * Program Purpose: shows a basic while loop structure
 * Coder: Nick McRae, 0612749
 * Date: Oct 21, 2011
 * Note: this is a revision of the BasicWhileLoop where we substitute a do-while loop
 */

public class BasicDoWhileLoopExample
{

	public static void main(String[] args)
	{
		// variables
		int sum = 0;
		int num1 = 1;
		
		//set up a do-while loop
		do
		{
			sum = sum + num1;
			System.out.println("Inside loop on iteration#" + sum);
		}	while(sum<5); //note semicolon, end do while

	}
}//end main}
//end class