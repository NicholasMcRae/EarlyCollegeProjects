/**
 * Program Name:IncrementOperatorsExample.java
 * Program Purpose:To show a loop where each variable increments by one, and also decrement operators
 * Coder: Nick McRae, 0612749
 * Date: Oct 17, 2011
 */

public class IncrementOperatorsExample
{

	public static void main(String[] args)
	{
		// variables
		int numOne = 15;
		System.out.println("Value of numOne is " + numOne);
		
		
		//apply increment operator
		numOne++;
		System.out.println("Value of numOne is " + numOne);
		
		//do it inside a println statement
		System.out.println("Value of numOne is " + numOne++);
		System.out.println("Value of numOne is " + numOne);
		
		//when we increment again inside a println statement, the println stays the same, however value increases for next print
		
		/*
		 * prefix and postfix
		 * this is a postfix, the increment operator is a postfix, doesn't apply until next use
		 */
		
		//example using prefix operation
		
		int numTwo = 33;
		
		System.out.println("The value of numTwo is " + numTwo);
		
		//use it in prefix mode
		System.out.println("Value of numTwo is " + ++numTwo);
		
		//famous line of code handed in by one of Bill's students
		//in 1999
		
		int numThree = 15;
		
		System.out.println(numThree++ + ++numThree);
		
	}
}//end main}
//end class