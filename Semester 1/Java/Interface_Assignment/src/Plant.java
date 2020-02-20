/**
 * Program Name: Plant.java
 * Program Purpose: implements plant features
 * Coder: Nick McRae, 0612749
 * Date: Mar 14, 2012
 */

public class Plant extends LivingThing
{
	//declaring variables
	private String plantType;
	
	//declaring constructor
	Plant(String plantType)
	{
		super ("plant");
		this.plantType = plantType; 
	}
	
	//Method Name: toString
	//Purpose: to allow us to describe what type of plant we have
	//Accepts: NOTHING, not even the truth
	//Returns: string
	public String toString()
	{
		return super.toString() + "\nThis plant is this a " + plantType;
	}
	
}//end class