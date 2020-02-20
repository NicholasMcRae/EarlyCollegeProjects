/**
 * Program Name:CoinFlip.java
 * Program Purpose: shows use of an array to store the results of a number of simulated coin tosses. We'll then look
 * at the percentage of heads and tails in the trial
 * Coder: Nick McRae, 0612749
 * Date: Nov 4, 2011
 */

public class CoinFlip
{

	public static void main(String[] args)
	{
		// create some variables
		final int ARRAY_SIZE = 1000;
		
		int headsCount = 0;
		int tailsCount = 0;
		
		//create the array
		int [] coinFlipArray = new int [ARRAY_SIZE];
		
		//set up a loop to fill the array
		
		for(int i = 0; i < coinFlipArray.length; i++)
		{
			//use Math.random()to generate either 0 or 1
			//a zero will be heads, and a 1 will be tails
			//assign the random number to the current element of the array
			
			coinFlipArray[i] = (int)(Math.random() * 2);
						
			
		}// end for
		
		//set up another loop to see the results of the tosses
		for (int i = 0; i < coinFlipArray.length; i++)
		{
			//use if-else to increment the headCount and tailsCount
			if (coinFlipArray[i] == 0)
			{
				//increment the headsCount
				headsCount++;
			}
			else
			{
				tailsCount++;
			}
		}//end for
		
		//print out the results
		
		System.out.println("There were a total of " + ARRAY_SIZE + " tosses made.");
		System.out.println("Number of heads was " + headsCount);
		System.out.println("Number of tails was " + tailsCount);
		
		System.out.println("Percentage of heads was " + (((double)headsCount/ARRAY_SIZE)* 100));
		System.out.println("Percentage of tails was " + (((double)tailsCount/ARRAY_SIZE)* 100));

	}
}//end main}
//end class