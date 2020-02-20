/**
 * Program Name: BasicNestedForLoops.java
 * Program Purpose: shows how one for loop can be nested inside of another for loop. This is a very common arrangement when
 * working with arrays/ When you nest for loops, you need to pay attention to the names of the loop counter variables due to
 * variable scope issues.
 * Coder: Nick McRae, 0612749
 * Date: Oct 31, 2011
 */

public class BasicNestedForLoopsThreeLevel
{

	public static void main(String[] args)
	{
		// set up outer loop
		
		for (int i = 0; i < 3; i++)
		{
			//stub
			System.out.println("stub1: Inside outer loop, value of i is. . . " + i);
			
			//set up middle loop
			for( int j = 0; j < 4; j++)
			{
				System.out.println("stub2: Inside middle loop value of j is. . . " + j);
				
				//set up inner loop
				for(int k = 0; k < 4; k++)
				{
					//stub
					System.out.println("stub2: Inside inner loop value of k is. . . " + k);
					
				}//end inner loop
				
				
			}//end middle for loop
			
			//stub
			System.out.println("\nstub3: Past middle loop, still inside outer loop. " + i);
			
			
			
		}//end outer for loop
		
		//stub
		System.out.println("stub4: all done!");

	}//end main
}//end class