/**
 * Program Name: Casting Example
 * Program Purpose: shows some examples of IMPLICIT and EXPLICIT casting
 * Coder: Nick McRae, 0612749
 * Date: Sep 26, 2011
 */

public class CastingExample
{

	public static void main(String[] args)
	{
		// do an implicit cast and assign an int value to a double value
		int intNum1 = 5;
		double doubleNum2 = intNum1;//this is an IMPLICIT cast by Java
																// you can always put a smaller size data type into a larger size
																//container or type
		
		System.out.println("Value in doubleNum2 is " + doubleNum2);
		
		//another implicit example
		byte smallNum = 127;
		short shortNum = smallNum;
		
		//in the example he used println but I know what's going to happen
		
		//explicit example of casting. In this case, we are going to be putting a value in a larger 
		//container into a smaller container
		
		short short2 = 34;
		byte byte2 = (byte)short2;
		
		System.out.println("Value in short2 is " + short2);
		System.out.println("Value in byte2 is " + byte2);
		
		//this is called a narrowing conversion, must be done explicitly using casting operators
		
		//another explicit cast that could cause a potential logic error
		short short3 = 130;
		byte byte3 = (byte)short3;
		
		System.out.println("Value in short3 is " + short3);
		System.out.println("Value in byte3 is " + byte3);

	}
}
//end main
//end class