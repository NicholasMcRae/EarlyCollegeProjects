/**
 * Program Name:OutsideTheFence.java
 * Purpose: shows the use of the OR operator to do what is called 
 *          an "outside the fence check". Here we check to see if 
 *          a value is outside the acceptable range of values.
 * Coder: Bill Pulling
 * Date: Oct 13, 2011
 */

import java.util.Scanner;

public class OutsideTheFence
{

	public static void main(String[] args)
	{
		// 1) create Scanner
		Scanner input = new Scanner(System.in);
		
		//2) Assume that an OK value is between 6.0 and 24.0 inclusive
		//Ask user to enter the value
		System.out.print("Enter the measurement as a decimal value: ");
		
		//3) read buffer
		double inputValue = input.nextDouble();
		
		//4) evaluate using an "outside the fence" check using OR
		
		if(inputValue < 6.0  || inputValue > 24.0)
		{
			System.out.println("Measurement is outside the acceptable range");
			
		}
		else
		{
			System.out.println("Measurement is within the acceptable range");
		}
		
		
		//alternative version done as an "inside the fence" check
		
		if(inputValue >= 6.0 && inputValue <= 24.0)
		{
			System.out.println(" 2:Measurement is within the acceptable range");
		}
		
		else
		{
			System.out.println("2:Measurement is outside the acceptable range");
		}
		
		//stub
		System.out.println("End of program.");
		
		//example of declaring multiple variables on one line
		int num1, num2, num3, num4;
		int num5 = 4, num6 = 7, num7, num8 = 9;
		
		

	}	//end main
}//end class