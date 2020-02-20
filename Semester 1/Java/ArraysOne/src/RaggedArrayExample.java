/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Nov 14, 2011
 */

public class RaggedArrayExample
{

	public static void main(String[] args)
	{
		// create a ragged array using direct instantiation
		
		int[][] raggedArray = {
				{6, 29, 43, 4, 5},
				{7, 14},
				{3,19,-24},
				{4},
				{5,6,33,11,4}//no comma after last row
				//easily recognizable what you're doing when you use this style
													};
	
		System.out.println("Value in [0][4] is " + raggedArray[0][4]);
		
		
		
		

	}
}//end main}
//end class