/**
 * Program Name: N_McRae_Triangle.java
 * Program Purpose: to model a triangle object
 * Coder: Nick McRae, 0612749
 * Date: Feb 1, 2012
 */

public class N_McRae_Triangle
{
	private double base;
	private double side2;
	private double side3;
	private static String color;
	
	N_McRae_Triangle()
	{
		base = 1.0;
		side2 = 1.0;
		side3 = 1.0;
		color = "black";
	}
	
	N_McRae_Triangle(double b, double s2, double s3, String c)
	{
		base = b;
		side2 = s2;
		side3 = s3;
		color = c;
	}

	public double getBase()
	{
		return base;
	}

	public void setBase(double base)
	{
		this.base = base;
	}

	public double getSide2()
	{
		return side2;
	}

	public void setSide2(double side2)
	{
		this.side2 = side2;
	}

	public double getSide3()
	{
		return side3;
	}

	public void setSide3(double side3)
	{
		this.side3 = side3;
	}

	public String getColor()
	{
		return color;
	}
	
	public double calculatePerimeter()
	{
		double perimeter = base + side2 + side3;
		return perimeter;
	}
	
	
}//end class