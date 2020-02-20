/**
 * Program Name:
 * Program Purpose: to test the reproduce() methods of some mammals.
 * Coder: Nick McRae, 0612749
 * Date: Feb 22, 2012
 */

public class PregnancyTest
{

	public static void main(String[] args)
	{
		// create some objects
		Mammal creature1 = new Mammal("Bear");
		
		//cal its methods
		System.out.println("This creatre1 is a " +creature1.getMammalType());
		System.out.println(creature1.reproduce());
		
		Platypus creature2 = new Platypus("Perry");
	//cal its methods
		System.out.println("This creature2 is a " +creature2.getMammalType());
		System.out.println(creature2.reproduce());

	}
}//end main}
//end class