/**
 * Program Name:
 * Program Purpose: a class to test the various versions of the makeSound() method
 * NOTE: This program will demonstrate early binding, which is NOT polymorphic behaviour
 * Coder: Nick McRae, 0612749
 * Date: Feb 8, 2012
 */

public class SoundTest
{

	public static void main(String[] args)
	{
		// create objects of each subclass
		Dog dogOne = new Dog("Collie", "Lassie");
		Cat catOne = new Cat("Persian", "Jinx");
		Duck duckOne = new Duck("Mallard", "Daffy");
		
		//have each object call its makeSound method
		
		System.out.println("DogOne says " + dogOne.makeSound());
		System.out.println("CatOne says " + catOne.makeSound());
		System.out.println("DuckOne says " + duckOne.makeSound());

	}
}//end main}
//end class