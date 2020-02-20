/**
 * Program Name: TemperatureConverter.java
 * Program Purpose: ask user to input a double value that changes Farenheit to Celsius
 * Coder: Nick McRae, 0612749
 * Date: Sep 21, 2011
 */
import java.util.Scanner;
public class TemperatureConverter
{

	public static void main(String[] args)
	{
		/*
		 * Pseudocode
		 * 1) Create a Scanner object
		 * 2) Create two variables, one for Celsius and one for Farenheit
		 * 3)Ask user to enter the Farenheit temp
		 * 4) Read the keyboard buffer and assign value to Farenheit
		 * 5) do the calculation
		 * 6) output the result
		 * huge dividend payoff by doing pseudocode first instead of screwing up in code
		 */
		
		//create a scanner object
		Scanner input = new Scanner(System.in);
		
		//create two variables
		double celsiusTemp = 0.0;
		double farenTemp = 0.0;
		
		//ask user to enter farenheit temperature
		System.out.print("Please enter a temperature in Farenheit");
		
		//read the keyboard buffer and assign value to farenTemp variable
		farenTemp = input.nextDouble();
		
		//do the calculation
		celsiusTemp = 5.0/9 * (farenTemp - 32);
		
		//output result
		System.out.println("The Celsius temperature is " + celsiusTemp);
	}
}
//end main
//end class