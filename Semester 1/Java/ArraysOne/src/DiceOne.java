/**
 * Program Name:DiceOne.java
 * Program Purpose: this app simulates the rolling of a pair of dice. We will record the results of each roll in an array that is
 * sized to 13 elements. We size it to 13 so that we can increment the value in the elements with indexes from 2 to 12. If we
 * roll a 7, the value in element seven will be incremented. If we roll a 10, the value in element 10 will be incremented etc
 * Coder: Nick McRae, 0612749
 * Date: Nov 7, 2011
 */

public class DiceOne
{

	public static void main(String[] args)
	{
		// PSEUDO-CODE
		/*
		 * 1) create an array of type int of 13 elements
		 * 2) create a constant to control the number of rolls made
		 * 3) create variables for the value of each die and their total
		 * 4) LOOP
		 *     generate two random numbers from 1 to 6 and add them
		 *     whatever the total is, increment the counter in the element with the same index number as the total
		 *    END LOOP
		 * 5) Print out the results using another flor loop
		 */
		
		//1) create an array of type int of 13 elements
		int [] diceArray = new int[13];
		
		//2 create a constant to control the number of rolls made
		final int NUM_ROLLS = 100;
		
		//3) create variables for the value of each die and their total
		int dieOne;
		int dieTwo;
		int diceTotal;
		
		//4) LOOP - generate two random numbers from 1 to 6 and add them together
		
		for (int i = 0; i < NUM_ROLLS; i++)
		{
			dieOne = (int)(Math.random() * 6 + 1);
			dieTwo = (int)(Math.random() * 6 + 1);
			
			diceTotal = dieOne + dieTwo;
			
			//increment the counter in the element with the same index number as the total
			
			diceArray[diceTotal] ++;
			
		}//end for
		
		//print out the results using another for loop, we only need to access elements 2 through 12
		
		System.out.println("\nTotal number of rolls was: " + NUM_ROLLS);
		
		for(int i = 2; i < diceArray.length; i++)
		{
			System.out.println("Number of " + i + "'s was " + diceArray[i]);
			
		}

	}
}//end main}
//end class