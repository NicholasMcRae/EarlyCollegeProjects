/**
 * Program Name: Cylinder.java
 * Program Purpose: to create a cylinder object and some methods and stuff
 * Coder: Nick McRae, 0612749
 * Date: Jan 25, 2012
 */

public class Cylinder
{
	private double height;
	private double radius;
	private String color;
	
	Cylinder()
	{
		height = 1.0;
		radius = 1.0;
		color = "black";
	}
	
	Cylinder (double h, double r, String c)
	{
		height = h;
		radius = r;
		color = c;
	}

	public double getHeight()
	{
		return height;
	}

	public void setHeight(double h)
	{
		this.height = h;
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}
	
	public double calculateSurfaceArea()
	{
		return ( ( 2*Math.PI*(radius*radius) ) + (2*Math.PI*radius*height) );
	}
	
	public double calculateVolume()
	{
		return (Math.PI * (radius*radius) * height );
	}
	
	
	
	
}
//end class