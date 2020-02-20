/**
 * Program Name: Your_NM_PizzaParty.java
 * Program Purpose: The purpose of this program is to calculate how many, and which sizes of pizza we need to feed a certain
 * amount of people. We will also be calculating prices/costs and so on. 
 * Coder: Nick McRae, 0612749
 * Date: Oct 24, 2011
 */

//Pseudocode
/*1) import scanner class
 *2) display title that includes my first name
 *3) create integer input for: number of people who want pizza and number of slices per person
 *4) create a variable for the total slices needed
 *5) create variables needed for if statements
 *6) create if statements to calculate number of pizzas
 *7) calculate the total slices purchased, slices left, and price of pizzas and set to variables+
 *8) create output to display necessary information
 * HOT VERSION
 * 1) calculate price per person amounts
 * 2) calculate extra money collected 
 * 3) create variables to be used in if statements
 * 4) calculate number of pizzas using extra money collected with if statements
 * 5) display results
 */
import java.util.Scanner;
public class Your_NM_PizzaParty
{
	public static void main(String[] args)
	{
		//2) display title that includes first name
		System.out.println("Nick's Pizza Party Planner Program" +	"\n****************************************");
		
		
	  // create Scanner object
		Scanner input = new Scanner(System.in);
		
		
		//3)create integer input for: number of people who want pizza, number of slices per person
		int numberPeople;
		System.out.print("\nEnter the number of people who want pizza!");
		numberPeople = input.nextInt();
				
		int slicesPerPerson;
		System.out.print("Enter the number of slices per person!");
		slicesPerPerson = input.nextInt();
		
		
		//4) calculate the total number of slices that are necessary
		int totalSlices = numberPeople * slicesPerPerson;
		
		
		//5) create variables to be used in if statements
		int largePizzas = 0;
		int leftAfterLarge = 0; //number of slices remaining after large pizzas are calculated
		int mediumPizzas = 0;
		int leftAfterMedium = 0; //number of slices remaining after medium pizzas are calculated
		int smallPizzas = 0;
		
		
		//6) create if statements to calculate the total number of pizzas
		//creating an if else statement to calculate the number of large pizzas and remaining slices
		if (totalSlices >= 12 )
		{
			largePizzas = totalSlices / 12;
			leftAfterLarge = totalSlices % 12;			
		}
		else if (totalSlices < 12)
		{
			//if the total number of slices needed is smaller than a large pizza, we set the slices left to totalSlices
			leftAfterLarge = totalSlices;
		}
		
		
		//creating an if else statement to calculate the number of medium pizzas and remaining slices
		if (leftAfterLarge >= 6)
		{
			mediumPizzas = leftAfterLarge / 6;
			leftAfterMedium = leftAfterLarge % 6;
		}
		else if (leftAfterLarge < 6)
		{
			//if the total number of slices needed is smaller than a medium pizza we set slices left to leftAfterLarge
			leftAfterMedium = leftAfterLarge;
		}
		
		
		//creating an if else statement to calculate the total number of small pizzas needed
		if (leftAfterMedium == 5)
		{
			smallPizzas = 2;
		}
		else if(leftAfterMedium < 5 && leftAfterMedium > 0)
		{
			smallPizzas = 1;
		}
		else if (leftAfterMedium == 0)
		{
			smallPizzas = 0;
		}
		
		
	//7) calculating slices purchased, slices left over, and price of the pizzas
	//calculating total slices purchased and set to a variable
		int slicesPurchased = (largePizzas * 12) + (mediumPizzas * 6) + (smallPizzas * 4);
		
	//calculating slices left over
		int slicesLeft = slicesPurchased - totalSlices;
			
	//calculating the total price of the pizzas
		double totalPrice = ((double)largePizzas * 19.35) + ((double)mediumPizzas * 11.55) + ((double)smallPizzas * 7.95);
		
		
	//8)display necessary output
		System.out.println("\nThe total number of slices required is: " + totalSlices);
		System.out.println("\nYour pizza order should include...");
		
	//deciding whether to display large pizza output
		if (largePizzas > 0)
		{
		System.out.println("\t" + largePizzas + " large pizza(s) at $19.35/pizza.");
		}
		
	//deciding whether to display medium pizza output	
		if (mediumPizzas > 0)
		{
		System.out.println("\t" + mediumPizzas + " medium pizza(s) at $11.55/pizza.");
		}
		
	//deciding whether to display small pizza output	
		if (smallPizzas > 0)
		{
		System.out.println("\t" + smallPizzas + " small pizza(s) at $7.95/pizza.");
		}
		
		System.out.println("\nThis order includes " + slicesPurchased + " slices which means there will be "
				               + slicesLeft + " extra slice(s).");
		System.out.println("\nYour order comes to $" + totalPrice);
		
		
		
		
	//HOT VERSION
	//******************************************************************
	//1) calculating price/person 
	//calculating total price per person 		
	double pricePerPerson = (double)totalPrice / numberPeople;
			
	//displaying price/person and rounded amount
	System.out.println("\nEach person owes $" + pricePerPerson + " which rounds up to $" + Math.ceil(pricePerPerson));
		
	
	//2) calculating extra money after rounding and additional pizzas
	double extraMoney = 0.0;
	extraMoney = (Math.ceil(pricePerPerson) - (double)pricePerPerson) * numberPeople;
	
	
	//3)initializing variables to be used in if statements
		double extraLarge = 0.0;
		double extraMedium = 0.0;
		double extraSmall = 0.0;
		double moneyAfterLarge = 0.0;
		double moneyAfterMedium = 0.0;
			
		
		//4) calculating number of extra pizzas with if statements
		if (extraMoney >= 19.35)
		{
		extraLarge = extraMoney / 19.35;
		extraLarge = (int)extraLarge * 1;
		moneyAfterLarge = extraMoney - (19.35 * extraLarge);
		}
		else if (extraMoney < 19.35)
		{
		moneyAfterLarge = extraMoney;
		}
		
		if (moneyAfterLarge >= 11.55)
		{
			extraMedium = moneyAfterLarge / 11.55;
			extraMedium = (int)extraMedium * 1;
			moneyAfterMedium = moneyAfterLarge - (11.55 * extraMedium);
		}
		else if (moneyAfterLarge < 11.55)
		{
			moneyAfterMedium = moneyAfterLarge;
		}
		
		if(moneyAfterMedium >= 7.95)
		{
			extraSmall = moneyAfterMedium / 7.95;
			extraSmall = (int)extraSmall * 1;
		}
			
		//5)displaying pizza output
		//displaying extra money collected by rounding to the next dollar
		if (extraLarge == 0 && extraMedium == 0 && extraSmall == 0)
		{
			System.out.println("\nWith the extra $" + extraMoney + " collected no additional pizzas may be ordered.");
		}
		else
		{
			System.out.println("\nWith the extra $" + extraMoney + " the following pizzas can be ordered.");
		}
		
		if (extraLarge > 0)
		{
		System.out.println("\t" + extraLarge + " pizza(s) at $19.35 each");
		}
		
		if (extraMedium > 0)
		{
		System.out.println("\t" + extraMedium + " pizza(s) at $11.55 each");
		}
		
		if (extraSmall > 0)
		{
		System.out.println("\t" + extraSmall + " pizza(s) at $7.95 each");
		}
			
		

	}//end main
}//end class