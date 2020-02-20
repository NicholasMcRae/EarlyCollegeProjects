/**
 * Program Name: Circle.java
 * Program Purpose: this class will create Circle objects in memory
 * Coder: Nick McRae, 0612749
 * Date: Jan 11, 2012
 * 
 * REVISION: Jan. 17th: added a utility method to calculate the circumference of the circle object
 */

public class Circle
{
	//declare data members first
	double radius = 1.0;//default value of 1.0 unit
	String color = "red"; //default color
	
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