/**
 * Program Name: DataTypesTwo.java
 * Program Purpose:shows the declaration and initialization of various primitive data type variables
 * Coder: Nick McRae, 0612749
 * Date: Sep 21, 2011
 */

public class DataTypesTwo
{

	public static void main(String[] args)
	{
		// create some variables
		byte smallnumber = 127;
		
		System.out.println("value of smallnumber is " + smallnumber);
		
		//add one to it. . . this will cause a compile error
		//smallnumber = smallnumber + 1;
		
		smallnumber ++;//Note: the ++ increment operator just adds one to the value stored in smallnumber
		
		System.out.println("value of smallnumber is " + smallnumber);
		
		//this is an example of executive overflow, or just plain overflow.
		//The value "wraps around" to the other end
		
		//create a variable of type long
		
		long bigNumber = 1000000000000L;
		// java always interprets integer literals as type int giving error on long so write L at end
		
		//declaring floats and doubles
		
		double smallValue = 2;// poor coding style to initialize a double with an integer
		
		System.out.println("The value of smallValue is " + smallValue);
		
		double smallgradePoint = 2.0; // always initialize the decimal part , even  if it is zero
		
		//do a float type
		float testMark = 87.5;//java always assumes and floating point literal is of type double
		                      //so use a capital F to identify a float
		
		

	}
}
//end main
//end class