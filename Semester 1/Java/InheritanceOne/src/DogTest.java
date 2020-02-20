/**
 * Program Name:DogTest.java
 * Program Purpose: tests the Dog class
 * Coder: Nick McRae, 0612749
 * Date: Jan 31, 2012
 */

public class DogTest
{

	public static void main(String[] args)
	{
		// create a Dog object
		Dog starDog = new Dog("Lassie", "Collie");
		
		//call the toString() method
		//the dog object can call this method because it INHERITED access to this method from the Animal class
		System.out.println(starDog.toString());

	}
}//end main}
//end class