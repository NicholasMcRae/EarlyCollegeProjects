/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Mar 31, 2012
 */

public class InvalidTempException extends Throwable
{
	
	// data member
	private static final long serialVersionUID = 1L;
	private double temp;
	
	// constructor for the exception object
	InvalidTempException(double t)
	{
		// call super class constructor and pass up error message
		super("Invalid kelvin value of " + t + " was entered");
		this.temp = t;
	}
			
}//end class