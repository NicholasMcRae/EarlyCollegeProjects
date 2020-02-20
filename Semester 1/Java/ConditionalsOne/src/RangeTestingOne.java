/**
 * Program Name:RangeTestingOne.java
 * Purpose: shows the use of the AND operator to do "inside the fence"
 *          testing. 
 * Coder: Bill Pulling
 * Date: Oct 13, 2011
 */

import java.util.Scanner;
public class RangeTestingOne
{

	public static void main(String[] args)
	{
		// 1) create Scanner
		Scanner input = new Scanner(System.in);
		
		//2) tell user what program does.
		System.out.print("Enter a mark out of 100 and I'll give you the letter grade.");
		
		//3)//read the keyboard buffer;
		double inputMark = input.nextDouble();
		
		//4) evaluate using an if-else-if using AND operators to do range testing inside
		//the fence
		
		if(inputMark  < 50.0)
		{
			System.out.println("A mark of " + inputMark + " is an F.");
		}
		
		if(inputMark >=50.0 && inputMark < 55.0)
		{
			System.out.println("A mark of " + inputMark + " is a D.");
		}
		
		if(inputMark >=55.0 && inputMark < 60.0)
		{
			System.out.println("A mark of " + inputMark + " is a D+.");
		}
		
		if(inputMark >=60.0 && inputMark < 65.0)
		{
			System.out.println("A mark of " + inputMark + " is a C.");
		}
		
		if(inputMark >=65.0 && inputMark < 70.0)
		{
			System.out.println("A mark of " + inputMark + " is a C+.");
		}
		
		if(inputMark >=70.0 && inputMark < 75.0)
		{
			System.out.println("A mark of " + inputMark + " is a B.");
		}
		
		if(inputMark >=75.0 && inputMark < 80.0)
		{
			System.out.println("A mark of " + inputMark + " is a B+.");
		}
		
		if(inputMark >=80.0 && inputMark < 90.0)
		{
			System.out.println("A mark of " + inputMark + " is an A.");
		}
		
		if(inputMark >=90.0)
		{
			System.out.println("A mark of " + inputMark + " is an A+.");
		}
		
		//stub
		System.out.println("End of program.");

	}	//end main
}//end class






