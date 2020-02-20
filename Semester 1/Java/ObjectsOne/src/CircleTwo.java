/**
 * Program Name: CircleTwo.java
 * Program Purpose: this class will create CircleTwo objects in memory. This version has the data members visibility set to private
 * so that their values can only be accessed from inside this class. 
 * Coder: Nick McRae, 0612749
 * Date: Jan 17, 2012
 * 
 */

public class CircleTwo
{
	//declare data members first and set them to private
	private double radius = 1.0;//default value of 1.0 unit
	private String color = "red"; //default color
	
	//methods 
	/*
	 * Method Name: calculateArea()
	 * Purpose: calculates the area of a circle object
	 * Accepts: nothing...uses the Circle object's radius value 
	 * Returns: a value of type double that is the area of the circle
	 */
	
	public double calculateArea()
	{
		
		return Math.PI * radius * radius;
		
	}//end method
	
	
	/*
	 * Method Name: calculateCircumference()
	 * Purpose: calculates the circumference of a circle object
	 * Accepts: nothing...uses the Circle object's radius value 
	 * Returns: a value of type double that is the area of the circle
	 */
	
	public double calculateCircumference()
	{
		
		return 2*Math.PI * radius;
		
	}//end method
	
	
	
}//end class