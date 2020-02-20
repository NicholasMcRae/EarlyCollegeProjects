/*
Program Name: InputExample1
Purpose: shows use of the scanner object to read the keyword buffer
Coder: Nick McRae
Date: September. 12th, 2011
*/
import java.util.Scanner;
public class InputExample1
{
	public static void main(String[] args)
	{
	//create a Scanner class object
	Scanner input = new Scanner(System.in);
	
	//prompt the user to enter their first name
	System.out.print("Type in your first name and press ENTER");
	
	//call the Scanner object's nextLine() method to read the
	//keyboard buffer and assign it to a variable
	
	String username = input.nextLine();
	
	//print out result
	System.out.println("Well, hello there " + username);
	
	}//end main method
}//end class