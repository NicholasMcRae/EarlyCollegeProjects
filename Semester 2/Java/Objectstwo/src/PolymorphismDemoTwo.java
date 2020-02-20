/**
 * Program Name:
 * Program Purpose: shows how polymorphic behavior can be useful when dealing with a collection of objects in a 
 * 									data structure
 * Coder: Nick McRae, 0612749
 * Date: Feb 8, 2012
 */

public class PolymorphismDemoTwo
{

	public static void main(String[] args)
	{
	// create three different Animals but use the superClass Animal to set the type
		//of their reference variable names.
		
		Animal creatureOne = new Dog("Collie", "Lassie");
		Animal creatureTwo = new Cat("Persian", "Jinx");
		Animal creatureThree = new Duck("Mallard", "Daffy");
		
		//create an array  of type Animal with three elements
		
		Animal [] zooArray = new Animal[3];
		
		//now, put the three different objects into the array
		
		zooArray[0] = creatureOne;
		zooArray[1] = creatureTwo;
		zooArray[2] = creatureThree;
		
		//process the array using a for loop
		
		for(int i = 0; i < zooArray.length; i++)
		{
			System.out.println("Creater in element #: " + i + " says " + zooArray[i].makeSound());
		}
		
		//try to create an object of the animal class

	}
}//end main}
//end class