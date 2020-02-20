/**
 * Program Name: Lotto649.java
 * Program Purpose: shows use of an array to store six randomly generated values ranging from 1 to 49
 * Coder: Nick McRae, 0612749
 * Date: Nov 7, 2011
 */

import java.util.Arrays;
public class Lotto649
{

	public static void main(String[] args)
	{
		// 1) tell user what happens
		System.out.println("This app will pick your Lotto 649 lucky " + " numbers. Good luck!");
		
		//2) set up an array of type int to hold 6 values.
		int [] luckyNumbersArray = new int[6];
		
		//3) use a for loop to generate the six random numbers
		for(int i = 0; i < luckyNumbersArray.length; i++)
		{
			
			luckyNumbersArray[i] = (int)(Math.random() * 49 + 1);
			
		}//end for
		
		//sort the array using the Arrays.sort() class method
		
		Arrays.sort(luckyNumbersArray);
		
		//stub
		System.out.println("Here are your lucky numbers!!!!!!!!!!!!\n");
		//4) print out the results on one line
		for(int i = 0; i < luckyNumbersArray.length; i++)
		{
			
			System.out.print(luckyNumbersArray[i] + "\t");
			
		}//end for

	}
}//end main}
//end class