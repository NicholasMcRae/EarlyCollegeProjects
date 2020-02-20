/**
 * Program Name: InputExampleOne.java
 * Program Purpose: use of a Scanner object to read the keyboard buffer
 * Coder: Nick McRae, 0612749
 * Date: Sep 16, 2011
 */
import java.util.Scanner; 
public class InputExampleOne
{

	public static void main(String[] args)
	{
		// create a Scanner object
		Scanner input = new Scanner(System.in);
		
		//create two variables to hold user name and age
		String userName;
		int age; 
		
		//prompt user to enter data
		System.out.print("Please enter your whole name and press enter");
		
		//use Scanner object to read the keyboard and assign the contents of the buffer back to 
		// variable userAge
		userName = input.next();
		
		//get user age
		System.out.print("\nEnter your age and press enter");
		age = input.nextInt();
		
		//output results
		System.out.println("\n\n Hello there, " + userName);
		
		System.out.println("Your age is " + age);
		
	}

//end main
}
//end class