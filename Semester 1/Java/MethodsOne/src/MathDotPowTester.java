/**
 * Program Name: MathDotPowTester.java
 * Program Purpose: shows use of the Math.pow(double base, double exponent) method of the Math class
 * Coder: Nick McRae, 0612749
 * Date: Nov 25, 2011
 */

public class MathDotPowTester
{

	public static void main(String[] args)
	{
		// calculate some powers of 10
		
		double base = 10.0;
		double exponent = 2.0;
		
		double result = Math.pow(base, exponent);
		System.out.println("The result of " + base + " to the power of " + exponent + " is " + result);

	}
}//end main}
//end class