/**
 * Program Name: FibonacciOne.java
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Jan 10, 2012
 */

public class FibonacciOne
{
	static long counter = 0;
	//static makes it visible to any other method in the class

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		int index = 0;
		long answer = 0;
		
		//call method
		answer = calcFibonacci(index);
		
		//output
		System.out.println("The value of term number " + index + " in the series is " + answer);
		
		//report counter value
		System.out.println("The method was called " + counter  + " times.");

	}//end main
	
	/*
	 * MethodName: calcFibonacci()
	 * Purpose: calculates the value of any term in a fibonacci series
	 * Accepts: a positive integer value  that represents the index number of the term in the series
	 * Returns: a long that is the value of that term in the series
	 */
	
	public static long calcFibonacci(long index)
	{
		//increment call counter
		counter++;
		
		if(index == 0 || index == 1)
		{
			return index;
		}
		//else we do a recursive call...
		else
		{
			return calcFibonacci(index - 1) + calcFibonacci(index - 2);
		}
		
	}//end method
	
	
}//end class
