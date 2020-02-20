/**
 * Program Name:WashingMachine.java
 * Purpose: shows use of a switch structure to make a selection based
 *          on user input.
 * Coder: Bill Pulling
 * Date: Oct 11, 2011
 */
import java.util.Scanner;
public class WashingMachine
{

	public static void main(String[] args)
	{
		// 1) create Scanner object
		Scanner input = new Scanner(System.in);
		
		//2) Explain to user what is going on
		System.out.println("Welcome to the laundromat!");
		System.out.println("Select which type of wash you want to do...");
		System.out.println("\nChoose 1 for cold water..." +
											"\nChoose 2 for warm water..."  +
											"\nChoose 3 for hot water..."   +
											"\nChoose 4 for hot water with bleach...");
		
		//3) get user choice
		System.out.print("\nEnter your selection...");
		int userChoice = input.nextInt();
		
		//4) evaluate using a switch statement
		
		switch(userChoice)
		{
			//list the cases
			case 1:System.out.println("You chose 1 for cold water.");
			break;
			
			case 2: System.out.println("You chose 2 for warm water.");
			break;
			
			case 3: System.out.println("You chose 3 for hot water.");
			break;
			
			case 4: System.out.println("You chose 4 for hot water with bleach.");
			break;
			
			//default case
			default: System.out.println("You must enter 1,2,3 or 4...try again.");		
		
		
		}//end switch
		
		//stub
		System.out.println("After switch, end of program...");

	}	//end main 
}//end class