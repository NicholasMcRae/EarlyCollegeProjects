/**
 * Program Name:
 * Program Purpose: a generalized super class  that will hold an abstract method to calculate area. This will force
 * 									any subclass to implement a specific calculateArea() method for its particular shape. 
 * NOTE: because this class is abstract, the coder will not be able to directly or explicitly create an object of the shape
 * Coder: Nick McRae, 0612749
 * Date: Feb 7, 2012
 */

public abstract class Shape
{
	//data member
	private String shapeType;
	
	//1 arg constructor
	Shape(String shape)
	{
		this.shapeType = shape;
	}
	
	//getter for shapeType
	public String getShapeType()
	{
		
		return this.shapeType;
	}
	
	//utility method
	/*
	 * MethodName: calculateArea()
	 * Purpose: an abstract method to force every subclass to implement a version of this method
	 * accepts: nothing
	 * returns: nothing...but subclass versions will return a double that is the area of 
	 */
	
	public abstract double calculateArea();
	
}//end class