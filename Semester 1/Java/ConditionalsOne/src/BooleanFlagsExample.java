/**
 * Program Name: BooleanFlagsExample.java
 * Program Purpose: shows an example of boolean flag variables being evaluated in an if statement
 * Coder: Nick McRae, 0612749
 * Date: Oct 17, 2011
 */

public class BooleanFlagsExample
{

	public static void main(String[] args)
	{
		// variables
		boolean flag = true;
		
		if(flag == true)
		{
			System.out.println("The flag is up!");
		}
		else
		{
			System.out.println("The flag is down!");
		}

			//we can omit the flag == true
		
		if(flag)
		{
			System.out.println("The flag is up!");
		}
		else
		{
			System.out.println("The flag is down!");
		}
	}
}//end main}
//end class