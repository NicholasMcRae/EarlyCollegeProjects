/**
 * Program Name:
 * Program Purpose: shows how to implement the ConversionFactors interface from another class and access its constants.
 * Coder: Nick McRae, 0612749
 * Date: Feb 21, 2012
 */

public class TestConverterOne implements ConversionFactors
{

	public static void main(String[] args)
	{
		// variables
		double inchesLength = 39.37;
		double ouncesWeight = 16.0;
		double horsePower = 400;
		double watts = 1000;
		
		//do one conversion
		double millimetreLength = inchesLength * ConversionFactors.INCH_TO_MM;
		
		//output 
		System.out.println(inchesLength + " inches is equal to " + millimetreLength + " millimetres.");

	}
}//end main}
//end class