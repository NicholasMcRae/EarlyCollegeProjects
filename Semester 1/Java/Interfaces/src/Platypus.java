/**
 * Program Name:
 * Program Purpose: a subclass of the mammal class. However, it lays eggs, so the inherited reproduce method
 * 									is not suitable for this class. We will have it inherit an abstract layeggs() method from an
 * 									interface called layable
 * Coder: Nick McRae, 0612749
 * Date: Feb 22, 2012
 */

public class Platypus extends Mammal implements Layable
{
	//data member
	private String platypusName; //i.e. Peter or Perry or Paul
	
	//constructor
	Platypus(String name)
	{
		super("Platypus");
		this.platypusName = name;
	}
	
	//getter
	public String getPlatypusName()
	{
		return this.platypusName;
	}
	
	//implement the layEggs() method
	public String layEggs()
	{
		return ("this " + this.getMammalType() + " lays eggs.");
	}
	
	//override the reproduce method and have it call layEggs()
	public String reproduce()
	{
		//make a sub call to the layEggs() method
		return layEggs();
	}
	
	
}
//end class