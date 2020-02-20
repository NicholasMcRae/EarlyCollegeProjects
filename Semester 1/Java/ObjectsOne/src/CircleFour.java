/**
 * Program Name: CircleFour.java
 * Program Purpose: this class will create CircleFour objects in memory. This version has the data members visibility set to private
 * so that their values can only be accessed from inside this class. 
 * BUT... we are going to provide a public accessor(getter) and a public mutator(setter) method to allow outside
 * access to the radius attribute
 * Coder: Nick McRae, 0612749
 * Date: Jan 18, 2012
 * 
 * This version also has a one argument and a two argument constructor which allow the user of the class to "customize"
 * their CircleFour object in terms of size of radius and color
 * 
 */

public class CircleFour
{
	//declare data members first and set them to private
	private double radius = 1.0;//default value of 1.0 unit
	private String color = "red"; //default color
	
	//methods 
	
	//one-arg constructor that lets user set radius size
	CircleFour(double r)
	{
		radius = r;
	}
	
	//now that we've written a one-arg constructor, the default zero-arg constructor provided by Java is no
	//longer available. If we want a zero-arg constructor, we have to write one
	
	//zero-arg constructor
	CircleFour()
	{
		// we don't need any code in here because the variables were 
		//declared above with default values
	}
	
	CircleFour(String c)
	{
		color = c;
	}
	
	CircleFour(double r, String c)
	{
		radius = r;
		color = c;
	}
	
	
	
	//getter method by convention starts with the term get, so we don't need a method documentation header
	
	public double getRadius()
	{
		return radius;
	}
	
	//creating a mutator, or setter method, one that we can use to change the radius 
	
	public void setRadius(double newRadius)
	{
		radius = newRadius;
	}
	
	public String getColor()
	{
		return color;
	}
	
	public void setColor(String newColor)
	{
		color = newColor;
	}
	
	
	
	
	
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