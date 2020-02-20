/**
 * Program Name:
 * Program Purpose: a subclass of Animal. It will implement the reproduce method
 * 									here.
 * Coder: Nick McRae, 0612749
 * Date: Feb 22, 2012
 */

public class Mammal extends Animal
{
	//data member
	private String mammalType;
	
	//constructor
	Mammal(String type)
	{
		super("Mammal");
		this.mammalType = type;//examples human, bear, whale, or a platypus
	}
	
	//getter
	public String getMammalType()
	{
		return this.mammalType;
	}
	
	//IMPLEMENT the abstract method here
	public String reproduce()
	{
		return("This " + this.mammalType + " gives live birth.");
	}
	
	
}//end class