/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Feb 21, 2012
 */

public class TestQuantityOne implements ConversionMethods
{

	public static void main(String[] args)
	{
		
		double inchesLength = 39.37;
		double millimetreLength = 0.0;
		//must create an object of this class to access the method
		TestQuantityOne myObject = new TestQuantityOne();
		
		//call the method and pass in the argument
		millimetreLength = myObject.inchToMillimetre(inchesLength);
		

	}//end main
	
	//put method doc header on later
	public double inchToMillimetre(double inchesIn)
	{
		return inchesIn * ConversionFactors.INCH_TO_MM;
	}
	
}//end class