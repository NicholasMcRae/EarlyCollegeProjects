/**
 * Program Name:ToiletCheck.java
 * Purpose:to see if the next() method will flush the buffer
 *         of the EOL character
 * Coder: Bill Pulling
 * Date: Sep 19, 2011
 */
import java.util.Scanner;
public class ToiletCheck
{

	public static void main(String[] args)
	{
		// create Scanner
		Scanner input = new Scanner(System.in);
		String firstName = "blank";
		String lastName = "blank2";
		int age;
		
		System.out.print("enter your age...");
		age = input.nextInt();
		
		System.out.print("Enter your first name...");
		firstName = input.next();
		System.out.print("\nNow enter your last name...");
		lastName = input.next();
		
		//print results
		System.out.println("Hello there, " + firstName + " " +
		                    lastName + ", your age is " + age);
		
		/*
		 * Result shows that the next() method does not fire immediately, 
		 * even with the EOL character sitting in the buffer.It waits until there
		 * is at least one other character in the buffer.
		 * 
		 */ 
		

	}	//end main
}//end class