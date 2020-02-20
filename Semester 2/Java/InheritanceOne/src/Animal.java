/**
 * Program Name: Animal.java
 * Program Purpose: this will serve as a base class for some more detailed subclasses
 * Coder: Nick McRae, 0612749
 * Date: Jan 31, 2012
 */

public class Animal
{
	//data member
	private String animalType;//i.e. a Dog, a Cat, a Duck, etc. 
	
	//a 1-arg constructor 
	Animal(String type)
	{
		this.animalType = type;
	}
	
	//getter
	public String getAnimalType()
	{
		return this.animalType;
	}
	
	//do a toString() method that just returns a String stating what kind of animal this is
	public String toString()
	{
		return("This animal is a(n) " + this.animalType);
	}
	
}//end class