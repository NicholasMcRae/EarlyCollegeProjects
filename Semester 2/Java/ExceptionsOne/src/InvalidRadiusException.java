/**
 * Program Name: InvalidRadiusException.java
 * Purpose: a custom exception class for use with the CircleOne class. This class will create an exception
 * 					object if the user tries to create a CircleOne object with a negative radius value.
 * Coder: Andrea Doroshenko, 0440549
 * Date: Mar 7, 2012
 */

public class InvalidRadiusException extends Exception
{
	// data member
	private static final long serialVersionUID = 1L;
	private double radius;
	
	// constructor for the exception object
	InvalidRadiusException(double r)
	{
		// call super class constructor and pass up error message
		super("Invalid radius value of " + r + " was entered");
		this.radius = r;
	}
	
	// getter
	public double getRadius()
	{
		return this.radius;
	}
	
	
	
}//end class