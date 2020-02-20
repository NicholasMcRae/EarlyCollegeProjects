/**
 * Program Name:BubbleSortDemoFour.java
 * Purpose: shows the steps in the basic bubble sort algorithm.
 *          This version uses the nested for loop structure. 
 *          The outer loop controls the number of passes done.
 *          The inner loop handles the comparisons and swaps.
 *          
 *          Enhancement: this version shows the ENHANCED bubble sort
 *          algorithm, where we reduce the number of comparisons made
 *          by one on each iteration of the outer loop.
 *          
 *          ENHANCEMENT #2: this version also shows the 
 *          "short-circuit" enhancement. If the number of swaps
 *          on any iteration of the inner loop is zero, that means
 *          the array is completely sorted, and you can break out
 *          of the outer loop. No more passes are needed.
 *          
 * Coder: Bill Pulling
 * Date: Dec 2, 2011 Sec02
 */

public class BubbleSortDemoFour
{

	public static void main(String[] args)
	{
		// create an array of 5 elements in reverse order
		int[] intArray = {5,10,20,25,15};
		
		//add comparisons counter
		int numComparisons = 0;
		
		
		//stub
		System.out.println("stub1: starting order of array is:");
		MyToolbox.printArrayContents(intArray);
		System.out.println();//for spacing only
		
		//outer loop controls number of passes
		for(int outerCount = 0; outerCount < intArray.length -1; outerCount++)
		{					
			//add a swaps counter
			int swapCount = 0;			
			
			//inner loop to handle comparisons
			//MODIFY the LCC to reduce number of comparisons made
			for(int i = 0; i < intArray.length - (outerCount +1); i ++)
			{
				numComparisons++;//increment counter
				//compare adjacent element values
				if(intArray[i] > intArray[i + 1])
				{
					swapCount++;
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
			
			System.out.println("stub3: Swap count is " + swapCount);
			
			if(swapCount == 0)
			{
				System.out.println("Swapcount is zero, breaking out of outer loop");
			  break;
			}
			
			
		}//end outer for loop
		
		System.out.println("Enhanced bubble sort: number of comparisons "
        + " was " + numComparisons);

		
	}	//end main
}//end class



