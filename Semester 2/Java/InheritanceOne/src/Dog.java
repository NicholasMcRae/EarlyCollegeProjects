/**
 * Program Name: Dog.java
 * Program Purpose: a subclass that is extended from the Animal class. It will inherit any public methods or
 * 									data attributes from the Animal class. 
 * Coder: Nick McRae, 0612749
 * Date: Jan 31, 2012
 */

public class Dog extends Animal
{
	//data members
	private String breed;//i.e. Collie, Spaniel, etc.
	private String dogName; //i.e. Rover, Chuck, Max
	
	//one-arg Constructor 
	Dog (String name)
	{
		//must make an EXPLICIT CALL to the super class constructor
		super("Dog");
		//This call to the super class constructor MUST be the very first line in a subclass constructor method
		this.breed = "mongrel";
		this.dogName = name;
	}
	
	//2-arg constructor
	Dog(String name, String breed)
	{
		super("Dog");		
		
		this.dogName = name;
		this.breed = breed;
	}
	
	
}//end class