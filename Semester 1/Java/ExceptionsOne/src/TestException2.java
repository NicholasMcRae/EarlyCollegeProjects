/**
 * Program Name:TestException2.java
 * Purpose: shows the creation of a simple unchecked runtime exception
 *          and shows how it is thrown by the Java Virtual Machine.
 *          
 *          This version also shows the use of a try and catch block 
 *          structure that will allow us to "catch" the exception when
 *          it is thrown, and by catching it, our program will not
 *          crash, but will continue on.
 *          
 *          This program also shows the use of a "finally" block. 
 *          Any code that is placed inside a finally block is 
 *          guaranteed to run, even if your program starts to crash.
 * Coder: Bill Pulling
 * Date: Feb 22, 2012
 */

public class TestException2
{

	public static void main(String[] args)
	{
		// some int and double variables
		int num1 = 3; 
		int num2 = 1;
		double num3 = 3.0;
		double num4 = 0.0;
		
		//do some division
		System.out.println("Result of " + num3 + " divided by " + num4 +
				               " is " + num3/num4);
		
		//put the code that is capable of causing a problem inside 
		//a try block
		
		try
		{
			System.out.println("Result of " + num1 + " divided by " + num2 +
        " is " + num1/num2);
		}//end try
		//a try block must be followed IMMEDIATELY by either a 'catch'
		//block or a 'finally' block
		catch(ArithmeticException ex)
		{
			//put some error handling code in here so that the user is 
			//told what happened. 
			System.out.println("An ArithmeticException has occured...");
			//print out the exception object's message.
			System.out.println("Message is " + ex.getMessage());
		}//end catch
		
		//put in a finally block just to show what it looks like and
		// to show what it does.
		//NOTE: the code inside the finally block ALWAYS RUNS NO MATTER WHAT.
		finally
		{
			System.out.println("stub: Inside finally block...this code always runs.");
		}
		
		System.out.println("stub: End of program...");
		
	}	//end main 
}//end class