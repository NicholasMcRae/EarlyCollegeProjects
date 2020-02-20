/**
 * Program Name:
 * Program Purpose: shows the use of multiple catch blocks after a try block
 * Coder: Nick McRae, 0612749
 * Date: Mar 7, 2012
 */

public class TestExceptionFive
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
		int[] intArray = {5, 2, 7, 0, 9};
		int numerator = 100;
		
		for(int counter = 0; counter < 6; counter++)
		{
			try
			{
				System.out.println("Inside the try block. . .");
				System.out.println("Dividing " + numerator + " by " + intArray[counter]);
				System.out.println("Result is " + numerator/intArray[counter]);
			}
			catch(ArithmeticException ex)
			{
				System.out.println("An arithmeticException has occurred. . .");
				System.out.println("Message is " + ex.getMessage());
			}
			catch(ArrayIndexOutOfBoundsException ex)
			{
				System.out.println("An out of bounds exception has occurred...");
				//print out the exception object's message
				System.out.println("Message is " + ex.getMessage());
			}
		}

	}
}//end main}
//end class