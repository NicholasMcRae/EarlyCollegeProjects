/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Jan 24, 2012
 */

public class CircleSixTest
{

	public static void main(String[] args)
	{
		// create a CircleSix object
		CircleSix myCircle = new CircleSix (89.0, "lavender");
		
		System.out.println("color of myCircle is " + myCircle.getColor());
		
		//create a second CircleSix object with a diferent color
		CircleSix yourCircle = new CircleSix(34.5, "green");
		
		System.out.println("color of yourCircle is " + yourCircle.getColor());
		
		//re-check the color of myCircle
		System.out.println("color of myCircle is " + myCircle.getColor());
		
		//changes the memory object, there is just one copy of a static variable, not in the object
		//this is useful if you want to change a whole bunch of things at the same time, because there is only one
		//memory location for static, if that changes, it changes all of the objects related to it, or something like that

	}
}//end main}
//end class