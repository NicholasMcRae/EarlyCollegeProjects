/**
 * Program Name: Animal 
 * Program Purpose: implements animal features
 * Coder: Nick McRae, 0612749
 * Date: Mar 14, 2012
 */

public abstract class Animal extends LivingThing
{
	//declaring variable
	private String animalType;
	
	//declaring constructor
	Animal(String animalType)
	{
		super("animal");
		this.animalType = animalType;
	}
	
	//Method Name: toString
	//Purpose: to allow us to describe what type of animal we have
	//Accepts: NOTHING, not even the truth
	//Returns: string
	public String toString()
	{
		return super.toString() + "\nThis animal is an " + animalType;
	}
	
	//Method Name: makeSound
	//Purpose: This tells us what sound an animal will make
	//Accepts: Not a thing
	//Returns: String
	public abstract String makeSound();
	
	
}//end class