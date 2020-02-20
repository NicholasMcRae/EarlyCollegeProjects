/**
 * Program Name:
 * Program Purpose: Abstract super class holding the abstract method reproduce(). This will be used to demonstrate
 * 								multiple inheritance in some classes using an interface.
 * Coder: Nick McRae, 0612749
 * Date: Feb 22, 2012
 */

public abstract class Animal
{
	private String type;//type is animal, bird, fish, reptile, amphibian
	
	//constructor
	Animal(String type)
	{
		this.type = type;
	}
	
	//getter
	public String getType()
	{
	return this.type;
	}
	
	//abstract method to reproduce
	
	public abstract String reproduce();
	
}//end class