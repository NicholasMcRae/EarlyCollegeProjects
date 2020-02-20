/**
 * Program Name: TwoDArrayExample1.java
 * Program Purpose: shows creation of a regular 2d array and how to assign values to each element
 * Coder: Nick McRae, 0612749
 * Date: Nov 11, 2011
 */

public class TwoDArrayExample1
{

	public static void main(String[] args)
	{
		// create some constants for the rows and columns
		final int NUMBER_OF_ROWS = 2;
		final int NUMBER_OF_COLUMNS = 3;
		
		//create a 2d array of 2 rows and 3 columns
		
		int[][] tableArray = new int[NUMBER_OF_ROWS][NUMBER_OF_COLUMNS];
		
		//assign some values to the elements
		
		tableArray[0][0] = 5;
		
		System.out.println("Value in element [0][0] is " + tableArray[0][0]);
		
		//Q. What is the length of this array?
		
		System.out.println("Length of table array is " + tableArray.length);
		
		// how do you find out the number of clumns in a 2d array? There's a trick. You need to ask for the number of columns
		//in a specific row of the 2d array
		
		System.out.println("Number of columns is " + tableArray[0].length);

	}
}//end main}
//end class