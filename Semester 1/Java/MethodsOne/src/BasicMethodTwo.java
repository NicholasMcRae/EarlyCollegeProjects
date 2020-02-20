/**
 * Program Name: BasicMethodTwo.java
 * Program Purpose: this program shows the creationa nd use of a method that returns the sum of two integers passed into it
 * Coder: Nick McRae, 0612749
 * Date: Nov 16, 2011
 */

public class BasicMethodTwo
{

	public static void main(String[] args)
	{
		// create two int variables
		int numOne = 5;
		int numTwo = 7;
		
		int total;
		
		//stub 
		System.out.println("calling the method");
		total = BasicMethodTwo.calculateSum(numOne, numTwo);
		System.out.println("Value of total is " + total);
		
		//send these to the method and store the return value in a variable called total

	}
	
  //MethodName: calculateSum()
	//Purpose: calculates and returns the sum of two int arguments
	//Accepts: two arguments of type int
	//Returns: the sum of the two int arguments
	
	public static int calculateSum(int input, int input1)
	{
		System.out.println("Inside the method");
		//add the two values together
		int total = input + input1;
		
		//now return the value to the line that called it
		System.out.println("returning the result");
		return total;
	}
	
}//end main}
//end class