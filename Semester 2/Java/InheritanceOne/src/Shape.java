/**
 * Program Name:Shape.java
 * Program Purpose:a super class to demonstrate EXPLICIT constructor calls from a subclass
 * Coder: Nick McRae, 0612749
 * Date: Feb 1, 2012
 */

public class Shape
{
	//data member
	private double area;
	
	//getter
	public double getArea()
	{
		return this.area;
	}
	
	public void setArea(double area)
	{
		this.area = area;
	}
	//wants us to get in the habit of using "this", it causes the area's that are the same to be color coded in blue
	
	
}//end class