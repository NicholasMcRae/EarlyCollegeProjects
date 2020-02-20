/**
 * Program Name:
 * Program Purpose: an interface which will just hold some constant values for converting between the metric and 
 * 									imperial measurement systems
 * Coder: Nick McRae, 0612749
 * Date: Feb 21, 2012
 */

public interface ConversionFactors
{
	//NOTE: all values declared here are by default public, static, and final
	double INCH_TO_MM = 25.4;
	double OUNCE_TO_GRAM = 28.349523;
	double POUND_TO_GRAM = 453.5924;
	double HP_TO_WATT = 745.7;
	double LITRES_TO_IMPERIAL_GALLONS = 4.536;
	double LITRES_TO_US_GALLONS = 3.78;

}//end interface