/**
 * Program Name: MyToolBoxTester1.java
 * Program Purpose: this is a driver or tester class for some methods in the mytoolbox class
 * Coder: Nick McRae, 0612749
 * Date: Nov 18, 2011
 */

public class MyToolBoxTester1
{

	public static void main(String[] args)
	{
		// create two variables to pass to getMaxInt() method
		int numOne = 5;
		int numTwo = 12;
		
		//call the method and create a variable to hold the return value
		int larger = MyToolbox.getMaxInt(numOne, numTwo);
		
		//print out result
		System.out.println("The larger of " + numOne + " and " + numTwo + " is " + larger);
		
		

	}
}//end main}
//end class