/**
 * Program Name:
 * Program Purpose:a subclass extended from the abstract Shape superclass. This demonstrates that coder must
 * implement the abstract calculateShape() method in this subclass
 * Coder: Nick McRae, 0612749
 * Date: Feb 7, 2012
 */

public class Circle extends Shape
{
	//data member
	private double radius;
	
	//1-arg constructor
	Circle(double radius)
	{
		//must make an explicit call to super class constructor and pass up a String that says what type of shape we are making here
		super("Circle");
		this.radius = radius;
	}
	
	public double getRadius()
	{
		return this.radius;
	}
	

	//utility method
	/*
	 * MethodName: calculateArea()
	 * Purpose: an abstract method to force every subclass to implement a version of this method
	 * accepts: nothing
	 * returns: nothing...but subclass versions will return a double that is the area of 
	 */
	public double calculateArea()
	{
		return Math.PI * radius * radius;
	}
}
//end class