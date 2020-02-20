/**
 * Program Name: Animal.java
 * Program Purpose: an abstract super class holding an abstract makeSound() method. Every subclass extended from this
 * 									super class will be forced to implement a version of the makeSound() method
 * Coder: Nick McRae, 0612749
 * Date: Feb 8, 2012
 */

public abstract class Animal
{
	//data members
	private String animalType;
	
	//1-arg constructor
	Animal(String type)
	{
		this.animalType = type;
	}
	
	//getter
	public String getAnimalType()
	{
		return this.animalType;
	}
	
	//abstract makeSound() method
	/*
	 * Method Name: makeSound()
	 * Purpose: abstract method to ensure all subclasses implement it
	 * Accepts: nothing
	 * Returns: a String representing the sound the specific animal makes
	 */
	
	public abstract String makeSound();
	
}//end main}
//end class