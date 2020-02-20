/**
 * Program Name: CircleOneTest.java
 * Purpose: tests the methods of the CircleOne class to see if the custom exception of 
 * 					InvalidRadiusException is created
 * Coder: Andrea Doroshenko, 0440549
 * Date: Mar 7, 2012
 */

public class CircleOneTest
{

	public static void main(String[] args)throws InvalidRadiusException
	{
		// create a CircleOne object
		CircleOne myCircle = new CircleOne(5.0);
		System.out.println("myCircle has a radius of " + myCircle.getRadius());
		
		try
		{
			CircleOne negativeCircle = new CircleOne(-3.5);
		}
		catch(InvalidRadiusException ex)
		{
			System.out.println("An exception has occurred...");
			//System.out.println("Message is " ex.getMessage());
		}
		
		// check the radius value
		//System.out.println("negativeCircle has a radius of " + negativeCircle.getRadius());

		System.out.println("End of program");
		
	}//end main
}//end class