/**
 * Program Name:LogicalNOTExample.java
 * Program Purpose: Shows the use of the logical negation or 'NOT' operator
 * Coder: Nick McRae, 0612749
 * Date: Oct 17, 2011
 */

public class LogicalNOTExample
{

	public static void main(String[] args)
	{
		// create variables
		int temperature = 106;
		
		if(temperature > 100)
		{
			System.out.println("The temperature of " + temperature + " is greater than boiling point bitches.");
		}

		System.out.println("Stub: next line after the if statement");
		
		System.out.println("\n?Now doing it with a NOT operator");
		
		if(!(temperature > 100))
		{
			System.out.println("The temperature of " + temperature + " is lower than boiling point bitches.");
		}
		else
			System.out.println("The temperature of" + temperature + " is greater than boilint point bitches.");
	}
}//end main}
//end class