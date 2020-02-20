/**
 * Program Name: TesterClass.java
 * Program Purpose: to test out the rest of the classes and stuff
 * Coder: Nick McRae, 0612749
 * Date: Mar 14, 2012
 */

public class TesterClass
{

	public static void main(String[] args)
	{
		//declaring duck and potato objects
		Duck newDuck = new Duck("Mallard");
		Potato newPotato = new Potato("Russet");
		
		//returning duck string and howtoprepare method 
		System.out.println(newDuck.toString());
		System.out.println(newDuck.howToPrepare());
		
		//returning the potato string and howtoprepare method
		System.out.println(newPotato.toString());
		System.out.println(newPotato.howToPrepare());

		
		
	}//end main
}//end class