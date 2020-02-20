/**
 * Program Name:Duck.java
 * Program Purpose: class of a duck
 * Coder: Nick McRae, 0612749
 * Date: Mar 14, 2012
 */

public class Duck extends Animal implements Edible
{
	private String breed;
	
	Duck(String breed)
	{
		super("Duck");
		this.breed = breed;
	}
	
	//Method Name: toString
	//Purpose: to allow us to describe what type of animal we have
	//Accepts: NOTHING, not even the truth
	//Returns: string
	public String toString()
	{
		return super.toString() + ("\nThis animal is a " + breed);
	}
	
	//Method Name: makeSound()
	//Purpose: animal sound
	//Accepts: Nothing
	//Returns: String
	
	public String makeSound()
	{
		return "Quack, quack";
	}
	
	//Method Name: howToPrepare()
	//Purpose: tells how to prepare the animal
	//accepts: nothing
	//returns: string
	
	public String howToPrepare()
	{
		return "Duck can be roasted or barbecued";
	}
	
}//end class