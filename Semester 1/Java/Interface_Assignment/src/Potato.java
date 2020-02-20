/**
 * Program Name:
 * Program Purpose: class of a potato
 * Coder: Nick McRae, 0612749
 * Date: Mar 14, 2012
 */

public class Potato extends Plant implements Edible
{
	private String potatoVariety;
	
	Potato(String variety)
	{
		super ("potato");
		this.potatoVariety = variety;
	}
	
	//Method Name: toString
	//Purpose: to allow us to describe what type of plant we have
	//Accepts: NOTHING, not even the truth
	//Returns: string
	
	public String toString()
	{
		return super.toString() + ("\nIt is of the " + potatoVariety + "variety");
	}
	
	//Method Name: howToPrepare()
	//Purpose: tells how to prepare the animal
	//accepts: nothing
	//returns: string
	
	public String howToPrepare()
	{
		return "This Russet potato can be baked, boiled, or fried";
	}
	
	
}//end class