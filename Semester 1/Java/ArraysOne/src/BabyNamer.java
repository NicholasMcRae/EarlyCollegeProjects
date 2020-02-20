/**
 * Program Name: BabyNamer.java
 * Program Purpose: an app to help prospective parents choose a name for their little bundle of joy. . .
 * Coder: Nick McRae, 0612749
 * Date: Nov 7, 2011
 */

import java.util.Scanner;
public class BabyNamer
{

	public static void main(String[] args)
	{
		// create three arrays of type String. One will hold boy names, one will hold girl names, and one will hold unisex names
		
		String [] boysArray = {"Richard", "Seth", "Michael"};
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter 1 for a boys name, 2 for a girls name, or 3 for a unisex name");
		
		int userChoice = input.nextInt();
		
		//each array has a different number of elements (im supposed to have written out three arrays)
		//when we generate a random number we need to make sure the number generated will give each element an equal chance
		//of being selected. So, we will need to use the length of the array selected as the multiplier for the Math.random method
		
		//use an if-else structure
		
		String babyName;
		int randomNumber;
		
		if(userChoice == 1)
		{
			//generate random number
			randomNumber = (int)(Math.random() * boysArray.length);
			
			//pick the name
			babyName = boysArray[randomNumber];
		}
		
		System.out.println("The name chosen was " + babyName);

	}
}//end main}
//end class