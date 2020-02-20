/**
 * Program Name: CircleThreeTest.java
 * Program Purpose: shows use of a public getter and setter method of the Circle3 class to access and change the
 * radius value
 * Coder: Nick McRae, 0612749
 * Date: Jan 17, 2012
 */

public class CircleThreeTest
{

	public static void main(String[] args)
	{
		// create a Circle3 object
		CircleThree myCircle = new CircleThree();
		
		//find current value of radius using getter method 
		System.out.println("Current radius value is " + myCircle.getRadius());
		
		System.out.println("Changing the radius to 9.5..");
		
		myCircle.setRadius(9.5);
		
		//test to see if it changed
		System.out.println("Current radius value is " + myCircle.getRadius());

	}
}//end main}
//end class