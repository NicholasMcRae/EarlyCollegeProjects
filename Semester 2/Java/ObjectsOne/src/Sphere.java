/**
 * Program Name: Sphere.java
 * Program Purpose: To implement the sphere object, extending the ThreeDObject
 * Coder: Nick McRae, 0612749
 * Date: Feb 15, 2012
 */

public class Sphere extends ThreeDObject
{
	
	private double radius;
	
	Sphere()
	{
	super();
	}
	
	Sphere (double r, String c)
	{
		radius = r;
		color = c;
	}

	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double r)
	{
		radius = r;
	}
	
	//Program Name: findSurfaceArea
	//Program Purpose: calculate surface area
	//Accepts: Nothing
	//Returns: Type Double
	
	public double findSurfaceArea()
	{
		double area;
		area = Math.PI * 4 * (radius*radius);
		return area;
	}
	
	//Program Name: findPerimeter
	//Program Purpose: calculate perimeter
	//Accepts: Nothing
	//Returns: Type Double
	
	public double findPerimeter ()
	{
		double perimeter;
		perimeter = 2 * Math.PI * radius;
		return perimeter;
	}
	
	//Program Name: findVolume
	//Program Purpose: calculate surface area
	//Accepts: Nothing
	//Returns: Type Double
	
	public double findVolume ()
	{
		double volume;
		volume = (4/3) * Math.PI * (radius*radius*radius);
	}
	
	
	
	
}//end class