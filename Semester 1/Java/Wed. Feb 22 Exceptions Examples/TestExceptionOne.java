/**
 * Program Name:TestExceptionOne.java
 * Purpose: shows the creation of a simple unchecked runtime exception
 *          and shows how it is thrown by the Java Virtual Machine
 * Coder: Bill Pulling
 * Date: Feb 22, 2012
 */

public class TestExceptionOne
{

	public static void main(String[] args)
	{
		// some int and double variables
		int num1 = 3; 
		int num2 = 0;
		double num3 = 3.0;
		double num4 = 0.0;
		
		//do some division
		System.out.println("Result of " + num3 + " divided by " + num4 +
				               " is " + num3/num4);

		System.out.println("Result of " + num1 + " divided by " + num2 +
        " is " + num1/num2);
	}
	//end main 
}
//end class