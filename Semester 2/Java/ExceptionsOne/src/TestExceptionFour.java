/**
 * Program Name:
 * Program Purpose: putting try-catch block OUTSIDE a loop body
 * Coder: Nick McRae, 0612749
 * Date: Mar 7, 2012
 */

public class TestExceptionFour
{

	public static void main(String[] args)
	{
		int numerator = 12;
		
		try
		{
		//use a for loop to do division using the loop counter
		for(int counter = 3; counter >=1; counter--)
		{
			
				System.out.println("Inside the try block...");
				System.out.println("Dividing " + numerator + " by " + counter);
				System.out.println("Results is " + numerator/counter);
			
		}
		}//end try
		
		catch(ArithmeticException ex)
		{
			//put some error handling code in here so that the user is told what happened.
			System.out.println("An arithmeticexception has occurred...");
			//print out the exception object's message
			System.out.println("Message is " + ex.getMessage());
		}
	}
}//end main}
//end class