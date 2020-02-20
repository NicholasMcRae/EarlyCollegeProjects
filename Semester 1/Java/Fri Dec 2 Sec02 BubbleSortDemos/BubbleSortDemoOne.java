/**
 * Program Name:BubbleSortDemoOne.java
 * Purpose: shows the steps in the basic bubble sort algorithm
 * Coder: Bill Pulling
 * Date: Dec 2, 2011
 */

public class BubbleSortDemoOne
{

	public static void main(String[] args)
	{
		// create an array of 5 elements in reverse order
		int[] intArray = {25,20,15,10,5};
		
		//stub
		System.out.println("stub1: starting order of array is:");
		MyToolbox.printArrayContents(intArray);
		System.out.println();//for spacing only
		
		//do one pass through the array and compare adjacent elements
		//If left element value is larger than right element value, swap.
		
		for(int i = 0; i < intArray.length - 1; i ++)
		{
			//compare adjacent element values
			if(intArray[i] > intArray[i + 1])
			{
				//if true, swap the elements
				MyToolbox.swapArrayElements(intArray, i, i + 1);
				//STUB
				System.out.println("stub2: calling swap method...");
				
			}//end if			
			
		}//end for
		
		//print out contents again
		System.out.println("\nOrder of array is now:");
		MyToolbox.printArrayContents(intArray);
		System.out.println();//for spacing only
		
		//second pass
		for(int i = 0; i < intArray.length - 1; i ++)
		{
			//compare adjacent element values
			if(intArray[i] > intArray[i + 1])
			{
				//if true, swap the elements
				MyToolbox.swapArrayElements(intArray, i, i + 1);
				//STUB
				System.out.println("stub2: calling swap method...");
				
			}//end if			
			
		}//end for
		
		//print out contents again
		System.out.println("\nOrder of array is now:");
		MyToolbox.printArrayContents(intArray);
		System.out.println();//for spacing only
		
		//third pass
		for(int i = 0; i < intArray.length - 1; i ++)
		{
			//compare adjacent element values
			if(intArray[i] > intArray[i + 1])
			{
				//if true, swap the elements
				MyToolbox.swapArrayElements(intArray, i, i + 1);
				//STUB
				System.out.println("stub2: calling swap method...");
				
			}//end if			
			
		}//end for
		
		//print out contents again
		System.out.println("\nOrder of array is now:");
		MyToolbox.printArrayContents(intArray);
		System.out.println();//for spacing only
		
		//fourth pass
		for(int i = 0; i < intArray.length - 1; i ++)
		{
			//compare adjacent element values
			if(intArray[i] > intArray[i + 1])
			{
				//if true, swap the elements
				MyToolbox.swapArrayElements(intArray, i, i + 1);
				//STUB
				System.out.println("stub2: calling swap method...");
				
			}//end if			
			
		}//end for
		
		//print out contents again
		System.out.println("\nOrder of array is now:");
		MyToolbox.printArrayContents(intArray);
		System.out.println();//for spacing only

	}	//end main
}//end class



