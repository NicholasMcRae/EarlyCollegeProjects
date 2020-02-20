/**
 * Program Name: NestedWhileLoop.java
 * Program Purpose: shows how one loop can be nested inside of another. Here we'll nest one while loop inside another while
 * loop
 * Coder: Nick McRae, 0612749
 * Date: Oct 24, 2011
 */

public class BestedWhileLoop
{

	public static void main(String[] args)
	{
		// set up counter variables for the outer and inner loop
		int outerCounter = 0;
		
		int innerCounter = 0;
		
		//set up nested while loop structure
		
		//outer while loop
		while(outerCounter < 3)
		{
		  //increment the outer counter
			outerCounter++;
			//stub
			System.out.println("Inside outer loop, outerCounter is " + outerCounter);
			
			//set up the inner while loop
			while(innerCounter < 4)
			{
				//increment the inner counter
				innerCounter++;
			//stub
				System.out.println("Inside outer loop, innerCounter is " + innerCounter);
			}//end inner while
			
			//stub
			System.out.println("\n"); //for spacing only
			
			//must reset inner loop counter to zero so that it runs next time through.
			innerCounter = 0;
			
		}//end outer while

	}// end main
}//end class
