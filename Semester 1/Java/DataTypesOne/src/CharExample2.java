/**
 * Program Name:
 * Program Purpose: shows how to read in a String value and store it in a char variable
 * Coder: Nick McRae, 0612749
 * Date: Sep 28, 2011
 */

import java.util.Scanner;
public class CharExample2
{

	public static void main(String[] args)
	{
		// create Scanner object
		Scanner input = new Scanner(System.in);
		
		char inputValue;
		
		//prompt user
		System.out.print("Enter a single character and press Enter...");
		
		//read the buffer
		//note we cannot use next method because it returns a string, cannot change string to char
		//inputValue = (cast**)input.next();
		
		//NOTE : we will have to use the String class method charAt(int index)
		//to get the value typed into the buffer as a char
		
		//create a String variable to hold the input
		String inputString = input.next();
		
		//now have inputString call the toChar() method
		inputValue = inputString.charAt(0);
		
		//output
		System.out.println("You entered the character. . . " + inputValue);
		
		//buffer flush
		input.nextLine();
		
		//some other String methods...
		
		System.out.println("Enter your full name...");
		String userName = input.nextLine();
		
		//report on length of the string 
		System.out.println("The name " + userName + "has " + userName.length() + "characters.");

	}
}
//end main}
//end class