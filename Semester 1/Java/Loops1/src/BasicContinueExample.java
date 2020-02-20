/**
 * Program Name:BasicContinueExample.java
 * Program Purpose:shows the effect of the continue keyword when it is encountered inside a counter controlled while loop
 * Coder: Nick McRae, 0612749
 * Date: Oct 26, 2011
 */
import java.util.Scanner;
public class BasicContinueExample
{

	public static void main(String[] args)
	{
		// Scanner
		Scanner input = new Scanner(System.in);
		
		int loopCounter = 0;
		int runningTotal = 0;
		
		//set up to infinite while loop
		while(true)
		{//increment counter
			loopCounter++;
			//stub
			System.out.println("Loop counter is at: " + loopCounter);
			
			//if loop counter value is multiple of three, then trigger continue
			
			if(loopCounter % 3 == 0)
			{
				//stub2
				System.out.println("stub1: Loop counter value is " + loopCounter + " which is a multiple " + " of 3, a continue is executed");
				continue;
			}//end if
			
			//stub3
			System.out.println("stub3: This is the last stub, " + " and loop counter value is " + loopCounter);
			
			//exit condition
			if(loopCounter >= 7)
			{
				break; //exit loop
			}
			
		}//end while

		//stub
		System.out.println("stub4: after the loop");
	}
}//end main}
//end class