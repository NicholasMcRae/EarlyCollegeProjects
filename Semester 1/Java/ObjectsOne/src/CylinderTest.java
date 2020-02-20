/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Jan 25, 2012
 */

public class CylinderTest
{

	public static void main(String[] args)
	{
		Cylinder myCylinder = new Cylinder();
		
		System.out.println("The height is " + myCylinder.getHeight());
		System.out.println("The radius is " + myCylinder.getRadius());
		
		Cylinder yourCylinder = new Cylinder(6.0, 4.0, "black");
		
		System.out.println("The height is " + yourCylinder.getHeight());
		System.out.println("The radius is " + yourCylinder.getRadius());
		
		yourCylinder.setRadius(5.0);
		
		System.out.println("The surface area of the cylinder is " + yourCylinder.calculateSurfaceArea());
		System.out.println("The surface area of the cylinder is " + yourCylinder.calculateVolume());

	}
}//end main}
//end class