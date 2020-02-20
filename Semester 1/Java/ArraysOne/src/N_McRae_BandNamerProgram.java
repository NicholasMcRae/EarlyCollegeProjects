/**
 * Program Name:N_McRae_BandNamerProgram.java
 * Program Purpose: The purpose of this program is to create a band name consisting of an adjective and a noun using two 
 *                  arrays.
 * Coder: Nick McRae, 0612749
 * Date: Nov 18, 2011
 */

public class N_McRae_BandNamerProgram
{

	public static void main(String[] args)
	{
		// PSEUDO-CODE
		// 1) Print out a line that describes the program
		// 2) create and initialize two String arrays and instantiate one with adjectives and the other with nouns
		// 3) create a third array that will be populated with the password using a for loop and math.random, multi-dimensional
		//    this multi-dimensional array will be eight elements long
		
		//describing the program
		System.out.println("This is Nicholas Alexander Dean McRae's Awesome Band-Naming Program!!\n"); 
		
		//create and initialize two arrays that instantiate adjectives and nouns
		//in these arrays rather than write a more complex bandNamesArray sequence I instead inserted a blank value for array
		//element zero. The bandNamesArray should only read the actual adjectives and verbs.
		String [] adjectiveArray = {"blank", "Honey-garlic", "High-tech", "Improper", "Creepy", "Fuzzy", "Terrible", "Naughty",
															  "Prickly", "Titanic", "Jumbo"};
		
		String [] nounArray = {" blank", " Cats", " Dogs", " Teachers", " Students", " Animals", " Peas", " Peppers", " Lemons", " Car Thieves",
													 " Hammers", " Foxes", " Metals"};
		
		//create a third array that will be used to hold the band names
		String [] bandNamesArray = new String [8];
		
		//create for loop that will populate the band names array 
		for (int i = 0; i < bandNamesArray.length; i++)
		{
			bandNamesArray [i] = adjectiveArray [(int)(Math.random() * 10) + 1] + nounArray [(int)(Math.random() * 12) + 1];		
		}
		//I might just be missing something here but although the noun array is set for 11 values in math.random, it is printing
		// out the tenth value, 
		
		//print out the values in bandNamesArray to the screen
		
		System.out.println("Nick's randomly generated band names are:\n");
		
		for (int j = 0; j < bandNamesArray.length; j++)
		{
			System.out.println(bandNamesArray [j]);
		}
		
				
		

		
		
		
	}//end main
}//end class
