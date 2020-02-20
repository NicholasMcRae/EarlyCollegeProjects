/**
 * Program Name:SwitchWithChar.java
 * Purpose: Shows the use of a switch statement using char data types as the 
 *          values being tested in the switch.
 * Coder: Bill Pulling
 * Date: Oct 13, 2011
 */

import java.util.Scanner;
public class SwitchWithChar
{

	public static void main(String[] args)
	{
		// 1) create Scanner
		Scanner input = new Scanner(System.in);
		
		// 2) pose the question
		System.out.println("Which of the following takes up the most memory?");
		
		// 3) list the choices 
		System.out.println(" A: byte");
		System.out.println(" B: short");
		System.out.println(" C: int");
		System.out.println(" D: long");
		
		//4) next read the keyboard buffer for user choice
		// Scanner does not have a method for reading chars, so we read it as a String
		String userChoice = input.next();
		
		//4A) use String method toUpperCase() to make sure that the value
		// gets sent to the switch as an upper case character, which is what
		// what the switch is set up to test.
		
		userChoice = userChoice.toUpperCase();
		
		//5) convert this to a char data type in order to use a switch statement
		//NOTE: in Java 1.7 the switch statement can handle Strings, but it cannot 
		//in version 1.6, which is what our Eclipse is using.
		
		char choice = userChoice.charAt(0);
		
		//6) evaluate choice using a switch statement
		
		switch(choice)
		{
		case 'A': System.out.println("Incorrect...D was correct answer.");
		break;
		
		case 'B': System.out.println("Incorrect...D was correct answer.");
		break;
		
		case 'C': System.out.println("Incorrect...D was correct answer.");
		break;
		
		case 'D': System.out.println("Correct!");
		break;
		
		default:System.out.println("Please choose A,B,C,or D...");
		
		
		}//end switch
		
		
		//stub
		System.out.println("End of program.");
		

	}	//end main
}//end class




