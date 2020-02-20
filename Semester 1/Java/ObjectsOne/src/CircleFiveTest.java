/**
 * Program Name:
 * Program Purpose: a test class to test methods of CircleFive class
 * Coder: Nick McRae, 0612749
 * Date: Jan 24, 2012
 */

public class CircleFiveTest
{

	public static void main(String[] args)
	{
		// create a CircleFive object
		CircleFive myCircle = new CircleFive(5.6, "turquoise");
		// test getters
		System.out.println("Radius of myCircle is " + myCircle.getRadius());
		System.out.println("Color of myCircle is " + myCircle.getColor());
		
		System.out.println("Value of PI for myCircle is " + myCircle.PI);
		//accessing the static variable through the class object
		
		//access it through className.memberName syntax
		System.out.println("Accessing value of PI statically, it is " + CircleFive.PI);

	}
}//end main}
//end class