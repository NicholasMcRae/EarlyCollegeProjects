/**
 * Program Name:
 * Program Purpose: shows the steps in the basic bubble sort algorithm using a NESTED LOOP
 * 
 * enhancement: this version shows the ENHANCED bubble sort algorithm, where we reduce the number of comparisons made on each iteration
 * of the outer loop by 1
 * Coder: Nick McRae, 0612749
 * Date: Dec 2, 2011
 */

public class BubbleSortDemoFour
{

	public static void main(String[] args)
	{
		// create an array of 5 elements in reverse order
		int[] intArray = {25, 20, 15, 10, 5};
		
		//stub
		System.out.println("stub1: starting order of array is:");
		MyToolbox.printArrayContents(intArray);
		
		//do one pass through the array and compare adjacent elements
		//if left element is larger than right element value, swap.
		
		for(int j = 0; j < intArray.length - 1; j++)
		{
		//modify the lcc to reduce number of comparisons made
		for(int i = 0; i < intArray.length - (j + 1); i++)
		{
			if(intArray[i] > intArray[i+1])
			{
				//if true, swap the elements
				MyToolbox.swapArrayElements(intArray, i, i+1);
				//stub
				System.out.println("stub2: calling swap method...");
			}
			
			
		}//end for
		
		}//end outer for
		
	
		//print out contents again
		System.out.println("\nOrder of array is now:");
		MyToolbox.printArrayContents(intArray);

	}
}//end main}
//end class