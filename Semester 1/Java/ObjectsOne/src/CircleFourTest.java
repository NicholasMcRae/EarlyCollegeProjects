/**
 * Program Name: CircleFourTest.java
 * Program Purpose: a test class to test methods in the CircleFour class
 * Coder: Nick McRae, 0612749
 * Date: Jan 18, 2012
 */

public class CircleFourTest
{

	public static void main(String[] args)
	{
		// create a circlefour object using the one-arg constructor that accepts a radius argument
		
		CircleFour myCircle = new CircleFour(8.5);
		
		//check the values of each data member using the getters
		System.out.println("The value of myCircle radius is " + myCircle.getRadius());
		System.out.println("The value of myCircle radius is " + myCircle.getColor());
		
		//try creating an object using the default constructor
		CircleFour yourCircle = new CircleFour();
		
		System.out.println("The value of myCircle radius is " + yourCircle.getRadius());
		System.out.println("The value of myCircle radius is " + yourCircle.getColor());
		
		//using one-arg to set color
		CircleFour hisCircle = new CircleFour ("burgundy");
		
		System.out.println("The value of myCircle radius is " + hisCircle.getRadius());
		System.out.println("The value of myCircle radius is " + hisCircle.getColor());
		
		//using the two-arg constructor to set both radius and color
		CircleFour herCircle = new CircleFour(19.2, "Navy Blavk");
		
		System.out.println("The value of myCircle radius is " + herCircle.getRadius());
		System.out.println("The value of myCircle radius is " + herCircle.getColor());

	}//end main
}//end class