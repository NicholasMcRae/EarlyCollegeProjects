/**
 * Program Name: LivingThing
 * Program Purpose: To implement the properties of a living thing!
 * Coder: Nick McRae, 0612749
 * Date: Mar 14, 2012
 */

public class LivingThing
{
	//declaring some variables
	private String organismType;
	private boolean isAlive;
	
	//constructor
	LivingThing(String organismType)
	{
	this.organismType = organismType;
	isAlive = true;
	}
	
	//Method Name: toString
	//Purpose: to allow us to describe whether something is an animal or a plant
	//Accepts: NOTHING, not even the truth
	//Returns: string
	public String toString()
	{
		return "This living thing is a(n)" + organismType;
	}

	public boolean isAlive()
	{
		return isAlive;
	}

	public void setAlive(boolean isAlive)
	{
		this.isAlive = isAlive;
	}
	
		
	
}//end class