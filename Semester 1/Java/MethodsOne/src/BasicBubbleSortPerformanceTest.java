/**
 * Program Name:BasicBubbleSortPerformanceTest.java
 * Purpose: will test how fast a basic bubble sort can sort
 *          an array of randomly generated values in the range 
 *          of zero to array.length -1.
 * Coder: Bill Pulling
 * Date: Dec 2, 2011
 */
import java.util.Date;
public class BasicBubbleSortPerformanceTest
{

	public static void main(String[] args)
	{
		// constant for array size
		final int ARRAY_SIZE = 10000;
		
		//create the array
		int[] intArray = new int[ARRAY_SIZE];
		
		//populate array with random ints in range of 0 to ARRAY_SIZE-1
		for(int i = 0; i < intArray.length; i++)
		{
			intArray[i] = (int)(Math.random() * ARRAY_SIZE);
		}//end for
		
		//create Date object to mark start time of sort
		long startTime;
		long stopTime;
		
		Date timerStart = new Date();//creates a Date object that records
		                             // its own "birth time"
		//ask date object for its birth time
		startTime = timerStart.getTime();
		
		//do the sort using basic bubble sort
		
	//outer loop controls number of passes
			for(int outerCount = 0; outerCount < intArray.length -1; outerCount++)
			{			
				//inner loop to handle comparisons
				
				for(int i = 0; i < intArray.length - 1; i ++)
				{
					//compare adjacent element values
					if(intArray[i] > intArray[i + 1])
					{
						//if true, swap the elements
						MyToolbox.swapArrayElements(intArray, i, i + 1);
					}//end if			
					
				}//end inner for
				
			}//end outer for loop
			
			//get stop time and calculate elapsed time in seconds
			
			Date timerStop  = new Date();//birth time is the stop time
			stopTime = timerStop.getTime();//ask object for its birth time
			
			double elapsedTime = (stopTime - startTime)/ 1000.0;
			//will convert milliseconds to seconds.
			
			//output
			System.out.println("Time taken to do basic bubble sort " +
			                   " on an array of " + ARRAY_SIZE + 
			                   " elements was " + elapsedTime + 
			                   " seconds.");
		
		
		
		
		
		

	}	//end main
}//end class