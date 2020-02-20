/**
 * Program Name:
 * Program Purpose: a subclass of Animal. We will be forced to implement the makeSound() method in this class
 * Coder: Nick McRae, 0612749
 * Date: Feb 8, 2012
 */

public class Cat extends Animal
{
	//data members
	private String breed;
	private String name;
	
	//1-arg constructor takes only name 
	
	Cat(String name)
	{
		//explicit call to super class one-arg constructor
		super("cat");
		this.name = name;
		this.breed = "mongrel";
	}
	
	//2-arg constructor
	Cat(String breed, String name)
	{
		super("cat");
		this.breed = breed;
		this.name = name;
	}

	public String getBreed()
	{
		return breed;
	}

	public String getName()
	{
		return name;
	}
	
//abstract makeSound() method
	/*
	 * Method Name: makeSound()
	 * Purpose: method to ensure all subclasses implement it
	 * Accepts: nothing
	 * Returns: a String representing the sound the specific animal makes
	 */
	
	public String makeSound()
	{
		return "Mrow";
	}
	
}//end main}
//end class