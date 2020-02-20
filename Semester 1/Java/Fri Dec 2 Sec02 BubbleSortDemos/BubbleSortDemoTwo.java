/**
 * Program Name:BubbleSortDemoTwo.java
 * Purpose: shows the steps in the basic bubble sort algorithm.
 *          This version uses the nested for loop structure. 
 *          The outer loop controls the number of passes done.
 *          The inner loop handles the comparisons and swaps.
 * Coder: Bill Pulling
 * Date: Dec 2, 2011 Sec02
 */

public class BubbleSortDemoTwo
{

	public static void main(String[] args)
	{
		// create an array of 5 elements in reverse order
		int[] intArray = {15,20,25,10,5};
		
		//create a variable to record number of comparisons done
		int numComparisons = 0;
		
		
		//stub
		System.out.println("stub1: starting order of array is:");
		MyToolbox.printArrayContents(intArray);
		System.out.println();//for spacing only
		
		//outer loop controls number of passes
		for(int outerCount = 0; outerCount < intArray.length -1; outerCount++)
		{			
			//inner loop to handle comparisons
			
			for(int i = 0; i < intArray.length - 1; i ++)
			{
				//increment numComparisons
				numComparisons++;
				//compare adjacent element values
				if(intArray[i] > intArray[i + 1])
				{
					//if true, swap the elements
					MyToolbox.swapArrayElements(intArray, i, i + 1);
					//STUB
					System.out.println("stub2: calling swap method...");					
				}//end if			
				
			}//end inner for
			
			//print out contents again
			System.out.println("\nOrder of array is now:");
			MyToolbox.printArrayContents(intArray);
			System.out.println();//for spacing only
		}//end outer for loop
		
		System.out.println("Basic bubble sort: number of comparisons "
		                    + " was " + numComparisons);
		
	}	//end main
}//end class



