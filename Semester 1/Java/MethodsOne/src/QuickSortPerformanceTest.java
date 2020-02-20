/**
 * Program Name: QuickSortPerformanceTest.java
 * Program Purpose: will test how fast a tuned quick sort can sort an array of randomly generated values in the 
 *  								range of zero to array.length - 1
 * Coder: Nick McRae, 0612749
 * Date: Dec 5, 2011
 */

public class QuickSortPerformanceTest
{

	public static void main(String[] args)
	{
		// create test array
		int[] intArray = {25, 15, 10};
		
		System.out.println("Starting order of array is ");
		MyToolbox.printArrayContents(intArray);
		
		//create variables to hold the minimum value in the array and the index number of the minimum value
		
		int minValue; //lowest value in array
		int minIndex; //index number of minValue
		
		//nested for loop structure
		//Outer loop does passes 
		for(int leftElementIndex = 0; leftElementIndex < intArray.length; leftElementIndex++)
		{
			//for each iteration of the outer loop, assign the minValue to the left-most array element. Use the values
			//in element 0 as the starting values for minValue and minIndex
			minValue = intArray[leftElementIndex];
			minIndex = leftElementIndex;
			
			//inner loops job is to find the lowest value in the remaining elements. If it finds a value that is lower 
			//than the current value of minValue, then it writes that new value to the minValue and records its index
			//in the minIndex variable
			
			for(int innerIndex = leftElementIndex + 1; innerIndex < intArray.length; innerIndex++)
			{
				//test value of each element against minValue and overwrite minValue if a smaller value is found
				if(intArray[innerIndex] < minValue)
				{
					//if true, we found a smaller value, so overwrite minValue 
					minValue = intArray[innerIndex];
					//overwrite minIndex 
					minIndex = innerIndex;
					
				}//end if
			}//end inner for
			
			 //move value in the left most element up to where the 
			//newest minValue was found.
			intArray[minIndex] = intArray[leftElementIndex];
			
			 //now put the minValue into the left-most element  
			intArray[leftElementIndex] = minValue;
			                              
		}//end outer for
		
		System.out.println("Finish order of array is");
		MyToolbox.printArrayContents(intArray);

	}
}//end main}
//end class