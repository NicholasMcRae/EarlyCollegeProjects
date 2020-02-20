/**
 * Program Name:
 * Program Purpose: tests creation of a Circle object
 * Coder: Nick McRae, 0612749
 * Date: Jan 11, 2012
 * 
 * REVISION: Jan. 17th: demonstrated that the circle object's data values could be changed in this program. 
 */

public class CircleTest
{

	public static void main(String[] args)
	{
		// call constructor method using new
		Circle circleOne = new Circle();
		
		System.out.println("This circleOne object has a radius of " + circleOne.radius);
		
		System.out.println("This circleOne object has a color of " + circleOne.color);
		
		System.out.println("This circleOne object has an area of " + circleOne.calculateArea());
		
		System.out.println("This circleOne object has circumference of " + circleOne.calculateCircumference());
		
		//change the values of radius and color using assignment statements
		circleOne.radius = 7.0;
		circleOne.color = "turquoise";
		
		System.out.println("New radius value is " + circleOne.radius);
		System.out.println("New color value is " + circleOne.color);
		
		System.out.println("This circleOne object has an area of " + circleOne.calculateArea());
		
		System.out.println("This circleOne object has circumference of " + circleOne.calculateCircumference());

	}
}//end main}
//end class