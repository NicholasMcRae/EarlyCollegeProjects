/**
 * Program Name: Circlefive.java
 * Program Purpose: shows the use of a static non-final data member to hold the color value.
 * Coder: Nick McRae, 0612749
 * Date: Jan 24, 2012
 */

public class CircleSix
{
	//data members
	private double radius;
	private static String color; //this sets color as a class variable, every circlesix object
	//will have the same color as the last one, that is created
	
	public static final double PI = 3.1415926;
	//static makes it a class variable
	
	//2-arg constructor
	CircleSix(double r, String c)
	{
		radius = r;
		color = c;
	}
	
	
	//CalculateArea method
	//Method Name: calculateArea()
	//Purpose: Calculates the area of a Circle5 object
	//accepts: nothing...users the Circle5 object's radius value
	//Returns: a value of type double that is the area of the circle
	
	public double calculateArea()
	{
		return PI * radius * radius;
	}


	public double getRadius()
	{
		return radius;
	}


	public void setRadius(double radius)
	{
		this.radius = radius;
	}


	public String getColor()
	{
		return color;
	}


	public void setColor(String color)
	{
		this.color = color;
	}
	
	
	
}//end main}
//end class