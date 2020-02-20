/**
 * Program Name: TestPassByValue.java
 * Program Purpose: this program shows how Java will pass a primitive value to a method by usings its "pass-by-value" mechanism.
 *  The original variable value is copied, and the copy is passed to the method. The original variable value never gets
 *  touched or changed by the method
 * Coder: Nick McRae, 0612749
 * Date: Nov 21, 2011
 */

public class TestPassByValue
{

	public static void main(String[] args)
	{
		// create a variable of type int to be passed to a method
		int counter = 3;
		
		System.out.println("stub1: value of counter before method call " + " is " + counter);
		System.out.println("stub2: calling method, passing it counter...");
		
		//because method is in the same class as the main, we can call it just using the method name. We can omit the class name
		//and the dot operator
		
		printNumberOfTimes(counter);
		
		System.out.println("stub3: back in the main " + " and value of counter is " + counter);

	}//end main
	
	//methodname: printNumberofTimes()
	//purpose: uses the argument passed in to run a while loop a certain number of times
	//accepts: an argument of type int
	//returns: nothing. It is a void method that provides a service
	public static void printNumberOfTimes(int counter)
	{
		//while loop
		while (counter > 0)
		{
			System.out.println("Inside method on iteration #" + counter);
			
			//decrement counter
			counter--;
		}//end while
		
	}//end method printNumberOfTimes
	
	
}//end class
