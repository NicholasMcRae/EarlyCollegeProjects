/**
 * Program Name:
 * Program Purpose: shows an example of "LATE BINDING" or polymorphic behaviour
 * 									of objects representing a Dog, a Cat, and a Duck
 * Coder: Nick McRae, 0612749
 * Date: Feb 8, 2012
 */

public class PolyMorphismDemoOne
{

	public static void main(String[] args)
	{
		// create three different Animals but use the superClass Animal to set the type
		//of their reference variable names.
		
		Animal creatureOne = new Dog("Collie", "Lassie");
		Animal creatureTwo = new Cat("Persian", "Jinx");
		Animal creatureThree = new Duck("Mallard", "Daffy");
		
		//have each one call the makeSound() method
		System.out.println("CreatureOne says " + creatureOne.makeSound());
		System.out.println("CreatureTwo says " + creatureTwo.makeSound());
		System.out.println("CreatureThree says " + creatureThree.makeSound());
		
		//do another set of animals but do not use superClass reference variables.
		//just have each object use a reference variable of its own class
		//this will demonstrate the early binding again
	}
}//end main}
//end class