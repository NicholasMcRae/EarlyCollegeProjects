/**
 * Program Name: Rectangle.java
 * Program Purpose: to model a rectangle objects
 * Coder: Nick McRae, 0612749
 * Date: Jan 18, 2012
 */

public class Rectangle
{
	private double length;
	private double width;
	private String color;
	
	//constructors
	//zero-arg
	
	
	Rectangle()
	{
		length = 1.0;
		width = 1.0;
		color = "red";
	}
	
	Rectangle(double len, double wid, String c)
	{
		length = len;
		width = wid;
		color = c;
	}

	public double getLength()
	{
		return length;
	}

	public void setLength(double length)
	{
		this.length = length;
	}
	
	//getters and setters
	
	
	
	
}//end main}
//end class