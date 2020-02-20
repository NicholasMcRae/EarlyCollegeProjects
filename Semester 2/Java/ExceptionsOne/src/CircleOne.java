/**
 * Program Name:
 * Program Purpose: a class to create CircleOne objects. It will throw an invalidRadiusException if the constructor
 * 									receives a negative value for the radius argument. 
 * Coder: Nick McRae, 0612749
 * Date: Mar 7, 2012
 */

public class CircleOne
{
	public double getRadius()
	{
		return radius;
	}

	public void setRadius(double radius)
	{
		this.radius = radius;
	}

	//data member
	private double radius;
	
	//constructor
	CircleOne(double r)throws InvalidRadiusException
	{
		if(r < 0)
		{
			throw new InvalidRadiusException(r);
		}
		else
		{
			this.radius = r;
		}
	}
	
}//end class