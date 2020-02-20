/**
 * Program Name: ConversionMethods.java
 * Program Purpose: The purpose of this program is to create an interface that forces the tempconverter program
 * 									to implement certain methods
 * Coder: Nick McRae, 0612749
 * Date: Mar 30, 2012
 */

public interface ConversionMethods
{
	
	//Name: farToCel
	//Purpose: convert fahrenheit to celsius
	//Accepts: double fahrenheit value
	//Returns: double celsius value

	public double farToCel(double f);

	//Name: farToKel
	//Purpose: convert fahrenheit to kelvin
	//Accepts: double fahrenheit value
	//Returns: double kelvin value	
	
	public double farToKel (double f);

	//Name: celToFar
	//Purpose: convert celsius to fahrenheit
	//Accepts: double celsius value
	//Returns: double fahrenheit value
	
	public double celToFar (double c);
	
	//Name: celToKel
	//Purpose: convert celsius to kelvin
	//Accepts: double celsius value
	//Returns: double kelvin value
	
	public double celToKel (double c);

	//Name:  kelToFar
	//Purpose: convert kelvin to fahrenheit
	//Accepts: double kelvin value
	//Returns: double fahrenheit value
	
	public double kelToFar (double k);
	
	//Name: kelToCel
	//Purpose: converts kelvin to Celsius
	//Accepts: double kelvin value
	//Returns: double fahrenheit value
	
	public double kelToCel (double k);
	
	
}
//end class