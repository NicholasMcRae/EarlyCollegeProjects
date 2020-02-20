/**
 * Program Name:BasicMethodOne.java
 * Program Purpose: shows the creation of a void method that takes an integer value as an argument and prints whether it is odd
 *                  or even
 * Coder: Nick McRae, 0612749
 * Date: Nov 16, 2011
 */

public class BasicMethodOne
{

	public static void main(String[] args)
	{
		// create a variable of type int
		
		int numOne = 6;
		
		//pass this to the method oddOrEven() to see if it is odd or even
		
		BasicMethodOne.calculateOddOrEven(numOne);
		
		System.out.println("Now after the method call. . . ");
		
		

	}//end main

//we cannot nest one method inside of another
	
	//MethodName: oddOrEven()
	//Purpose: prints out a line stating if the value passed in is odd or even
	//Accepts: one argument of type int
	//Returns: nothing. It is a void method.
	
	public static void calculateOddOrEven(int input)
	{
		if (input % 2 == 0)
		{
		  System.out.println("The variable is even");
		}
		else
		{
			System.out.println("The variable is odd");
		}
	}//end method


}
//end class