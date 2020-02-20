/**
 * Program Name: ShuffleCards.java
 * Program Purpose: To shuffle a deck of cards by populating an array and then shuffling it. 
 * Coder: Nick McRae, 0612749
 * Date: Dec 9, 2011
 */

/*
 * PSEUDOCODE
 * 1) declare an array of the appropriate type to hold all the integers from 1 to 52
 * 2) use a loop to fill the array with each value from 1 to 52 in sequence
 * 3) call a print array method which will print all the elements in the array before they are shuffled
 * 4) randomize or shuffle the array elements
 * 5) Again print the array contents on the screen
 */

public class N_McRae_ShuffleCards
{

	public static void main(String[] args)
	{
		
		//Print out introduction to the program
		System.out.println("The Cards Shuffler\n");
		System.out.println("This program creates a deck of 52 cards.\n The cards are represented by the values" +
				" 1 to 52.\n It then 'shuffles' the cards\n");
		
		//Initialize the array
		int [] cardsArray = new int [52];
		
		
		//Populate the array
		for(int i = 0; i < cardsArray.length; i++)
		{
			cardsArray [i] = i + 1;
		}//end for loop
		
		
		//Calling my methods to print, shuffle, and then print again.
		System.out.println("The contents of the deck before shuffling...");
		
		//print array before shuffle
		N_McRae_ShuffleCards.printArrayContents(cardsArray);
		
		//spacing
		System.out.println("");
		
		//really ugly code to use method inside of a loop rather than putting the loop inside the method
		//this generates the parameters of the method to shuffle the deck
		for (int j = 0; j < cardsArray.length; j++)
		{
		//for each iteration of the for loop a new randomInt is generated to be used as an element to swap with i
			int randomInt = (int)((52-1)*Math.random() + 1);
			
			N_McRae_ShuffleCards.shuffleDeck(cardsArray, j, randomInt);
		}
		
		//printing out more stuff for the user
		System.out.println("\nThe contents of the deck after shuffling...");
		
		//printing out the array again
		N_McRae_ShuffleCards.printArrayContents(cardsArray);
		
	}//end main
	
	
	
	
	
	//MethodName: printArrayContents(int [] array)
	//Purpose: will print the contents of the array, creating a new line after every thirteenth element
	//Accepts: an array of type int
	//Returns: nothing
	
	public static void printArrayContents(int [] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			//want to print out 13 values per line then do a newline
			if(i % 13 == 0)
			{
				System.out.println();//for line spacing only
			}
			System.out.print(array[i] + " ");
		}//end for
	}//end method printArrayContents
	
	
	
	
	
	//MethodName: shuffleDeck(int [] a)
	//Purpose: will shuffle the deck of cards by swapping an incremented i variable with a randomly generated element number
	//Accepts: an array of type int
	//Returns: nothing
		
	public static void shuffleDeck (int [] a, int b, int c)
	{
		//if statement to avoid situations where an element is swapped with itself
			if (b != c)
			{
				int temp = a[b];
				a[b]= a[c];
				a[c]= temp;
			}
			
	}//end method shuffleDeck
	
}//end class