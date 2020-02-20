/**
 * Program Name: Circlefive.java
 * Program Purpose: shows the use of a static final data member to hold the value of PI
 * Coder: Nick McRae, 0612749
 * Date: Jan 24, 2012
 */

public class CircleFive
{
	//data members
	private double radius;
	private String color;
	
	public static final double PI = 3.1415926;
	//static makes it a class variable
	
	//2-arg constructor
	CircleFive(double r, String c)
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