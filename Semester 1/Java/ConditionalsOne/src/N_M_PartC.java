/**
 * Program Name: N_M_PartC.java
 * Program Purpose: This program is a trip calculator. It determines whether it is feasible to make a trip in a specified time
 * Coder: Nick McRae, 0612749
 * Date: Oct 14, 2011
 */
import java.util.Scanner;
public class N_M_PartC
{

	public static void main(String[] args)
	{
		// PSEUDOCODE
		
		/*
		 * 1) Import scanner class
		 * 2) Print line that reads "**This is Nick McRae's Trip Evaluator!**"
		 * 3) Use escape sequence to next line and write: "This program will test if a given trip is possible
		 * 4) Create Scanner object
		 * 5) Create following variables: int distance (in km), int speed (km/hr), double hours (time available)
		 *    and initialize them with user input from scanner class. Flush buffer when necessary.
		 * 6) Create actualTime variable using the distance and speed variables, create as double
		 * 5) Compare available time and actual time in an if statement and print out proper output.
		 * 
		 * PROGRAM EXPLANATION: In this program we are determining whether a trip can be made in the time available to the 
		 * 											person making the trip. We are asking the user how far they are going in km, the average speed
		 * 											that they are traveling at in km/hr, and the time they have available (h). The program divides
		 * 											distance by speed to calculate the actual time the trip will take. We then compare this
		 * 											actual time to the available time that the user has entered, and decide if they can make the trip
		 * 											in a timely fashion. 
		 */
		
	//printing program header and program purpose
		System.out.println("**This is Nick McRae's Trip Evaluator!**");
		System.out.println("\nThis program will test to see if a given trip is possible.");
		
	// create Scanner object
		Scanner input = new Scanner(System.in);
		
	//create distance variable, prompt user input, and assign input to the distance variable
		int distance;
		System.out.print("\nEnter the distance of your trip (km):");
		distance = input.nextInt();
		
	//create a speed variable, prompt user input, and assign input to the speed variable
		int speed;
		System.out.print("Enter your average speed (km/h):"); 
		speed = input.nextInt();
		
	//create an available time variable, prompt user input, and assign input to the variable
		double availableTime;
		System.out.print("Enter the available time (h):");
		availableTime = input.nextDouble();
		
	//create an actual time variable using double, which will be used to compare to available time in an if statement
		double actualTime = (double)distance/speed;
		
	//create an if-else statement that compares availableTime to actualTime, compares output and display proper message to user
		if (availableTime >= actualTime)
		{
			System.out.print("\nThis trip can be completed in " + actualTime + " hours, which doesn't exceed the available time of " 
					             + availableTime + " hours.");
		}
		
		else
		{
			System.out.print("\nThis trip can't be completed in the available time of " + availableTime + " hours. The actual " +
					"time required is " + actualTime + " hours.");
		}
			

	}//end main
}//end class