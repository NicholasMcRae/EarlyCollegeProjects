/**
 * Program Name: BasicNestedForLoops.java
 * Program Purpose: shows how one for loop can be nested inside of another for loop. This is a very common arrangement when
 * working with arrays/ When you nest for loops, you need to pay attention to the names of the loop counter variables due to
 * variable scope issues.
 * Coder: Nick McRae, 0612749
 * Date: Oct 31, 2011
 */

public class BasicNestedForLoops
{

	public static void main(String[] args)
	{
		// set up a nested for loop with outer and inner loops
		
		for (int i = 0; i < 3; i++)
		{
			//stub
			System.out.println("stub1: Inside outer loop, value of i is. . . " + i);
			
			//set up inner loop
			for( int j = 0; j < 4; j++)
			{
				System.out.println("stub2: Inside inner loop value of j is. . . " + j);
			}//end inner for loop
			
			//stub
			System.out.println("\nstub3: Past inner loop, still inside outer loop. " + i);
			
			
			
		}//end outer for loop
		
		//stub
		System.out.println("stub4: all done!");

	}//end main
}//end class