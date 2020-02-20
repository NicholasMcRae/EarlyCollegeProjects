/**
 * Program Name: TwoDArrayExample1.java
 * Program Purpose: shows creation of a regular 2d array and how to assign values to each element, shows the use of a nested
 * for loop to fill the array with random integer values
 * Coder: Nick McRae, 0612749
 * Date: Nov 14, 2011
 */

public class TwoDArrayExample2
{

	public static void main(String[] args)
	{
		// create some constants for the rows and columns
		final int NUMBER_OF_ROWS = 2;
		final int NUMBER_OF_COLUMNS = 3;
		
		//create a 2d array of 2 rows and 3 columns
		
		int[][] tableArray = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		
		//use a nested for loop to fill the array  with values
		//the outer for loop cycles through the rows, and the inner loop cycles through the columns
		
		for(int rowNum = 0; rowNum < tableArray.length; rowNum++)
		{
		  for(int colNum = 0; colNum < tableArray[rowNum].length; colNum++)	
		  {
		  	//generate some numbers from 1 to 49 and put them into each element of the table
		  	
		  	tableArray[rowNum][colNum] = (int)(Math.random() * 49 + 1));
		  	
		  }//end inner for loop
			
			
			
			
		}

	}
}//end main}
//end class