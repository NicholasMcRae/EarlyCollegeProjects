/**
 * Program Name: FactorialOne.java
 * Program Purpose: shows how to calculate a factorial value using a recursive method
 * Coder: Nick McRae, 0612749
 * Date: Jan 3, 2012
 * 
 * Revisions: Jan. 4th, 2012
 * 1) added a line to output the number of calls made to the recursive method
 */
import java.util.Scanner;
public class FactorialOne
{

	//create a counter in class scope that can be accessed by any method in the class
	public static long counter = 0;
	
	/*
	 * MethodName: calcFactorial()
	 * Purpose: calculates the factorial of the argument n
	 * 					where n is a positive integer
	 * Accepts: a positive integer value 
	 * Returns: a long that is the factorial of n
	 */
	
	public static long calcFactorial(int n)
	{
		//increment the counter variable
		counter++;
		
		if(n == 0)
		{
			return 1;//stopping case
		}
		//else, we need to call the method again but decrease n by 1
		else
		{
			return n * calcFactorial(n-1);
		}
		
	}//end method calcFactorial()
	
	
	public static void main(String[] args)
	{
		// test
		int n = 5;
		long answer = calcFactorial(n);
		
		System.out.println("value of " + n + " factorial is " + answer);
		
		//how many calls were made?
		System.out.println("to calculate the value of " + n + " factorial, there were " + counter +
												" calls of the calcFactorial() method");

	}
}//end main}
//end class