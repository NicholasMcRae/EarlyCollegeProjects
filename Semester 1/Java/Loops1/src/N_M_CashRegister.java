/**
 * Program Name:N_M_CashRegister
 * Program Purpose: The purpose of this program is to tabulate purchase prices, calculate taxes paid, and display total price
 * Coder: Nick McRae, 0612749
 * Date: Oct 28, 2011
 */
import java.util.Scanner;
public class N_M_CashRegister
{

	public static void main(String[] args)
	{
		// pseudocode
		/*
		 * 1) display output explaining program, and explain sentinel value
		 * 2) initialize loop variable to false, and initialize purchaseCounter, and initialize purchase
		 * 3) LOOP
		 *    set up IF statement to validate input
		 *    else sentinel value
		 * 4) calculate HST
		 */
		
		// create Scanner
		Scanner input = new Scanner(System.in);
		
		//initialize purchase input
		double userInput;
		double purchaseTotal = 0.0;
		
		//initialize boolean value
		boolean isSentinelValue = false;
		
		//set up while loop
		while (!isSentinelValue)
		{
		//prompt user to enter data
			System.out.print("Enter a purchase price between 1.00-5.00, or enter -1 to display output.");
			userInput = input.nextDouble();
			
				if (userInput >= 1 && userInput <= 5)
				{
					purchaseTotal += userInput;
				}
				else if (userInput == -1)
				{
					isSentinelValue = true;
				}
				else
				{
					System.out.println("Sorry, the price " + purchaseTotal + " is outside the acceptable range, please re-enter");
				}
							
		}// end while
		
	//Display purchase price and taxed price
		System.out.println("\nThe total price of your purchase without tax is: " + purchaseTotal);
		
	//Calculate and display taxed amount
		double taxPayable = purchaseTotal * 0.13;
		
		System.out.println("\nThe total hst payable is " + taxPayable);
		
	//calculate and display price of total purchase
		double taxedTotalPurchase = taxPayable + purchaseTotal;
		
		System.out.println("\nGrand total payable is " + taxedTotalPurchase);
		
	

	}//end main
}//end class
