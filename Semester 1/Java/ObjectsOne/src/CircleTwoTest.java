/**
 * Program Name: CircleTwoTest
 * Program Purpose: tests creation of a CircleTwo object and it demonstrates the effect of making data members private
 * Coder: Nick McRae, 0612749
 * Date: Jan 17, 2012
 *  
 */

public class CircleTwoTest
{

	public static void main(String[] args)
	{
		// call constructor method using new
		CircleTwo myCircle = new CircleTwo();
		//wherever we change the variable we get error messages, because the variables are private 
		
		System.out.println("This myCircle object has a radius of " + myCircle.radius);
		
		System.out.println("This myCircle object has a color of " + myCircle.color);
		
		System.out.println("This myCircle object has an area of " + myCircle.calculateArea());
		
		System.out.println("This myCircle object has circumference of " + myCircle.calculateCircumference());
		
		//change the values of radius and color using assignment statements
		myCircle.radius = 7.0;
		myCircle.color = "turquoise";
		
		System.out.println("New radius value is " + myCircle.radius);
		System.out.println("New color value is " + myCircle.color);
		
		System.out.println("This myCircle object has an area of " + myCircle.calculateArea());
		
		System.out.println("This myCircle object has circumference of " + myCircle.calculateCircumference());

	}
}//end main}
//end class