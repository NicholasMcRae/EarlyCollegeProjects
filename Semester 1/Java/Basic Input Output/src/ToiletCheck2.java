/**
 * Program Name:ToiletCheck2.java
 * Purpose:to see if the nextLine() method will be affected by 
 *          the EOL character left behind by a nextInt() call.
 * Coder: Bill Pulling
 * Date: Sep 19, 2011
 */
import java.util.Scanner;
public class ToiletCheck2
{

	public static void main(String[] args)
	{
		// create Scanner
		Scanner input = new Scanner(System.in);
		String firstName = "blank";
		String lastName = "blank2";
		int age;
		
		//ask for age first to leave an EOL character behind
		System.out.print("Enter your age...");
		age = input.nextInt();
		
		//now ask for names separately using nextLine()
		System.out.print("Enter your first name...");
		//use the nextLine() method here, not next()
		firstName = input.nextLine();
		System.out.print("\nNow enter your last name...");
		lastName = input.nextLine();
		
		//print results
		System.out.println("Hello there, " + firstName + " " +
		                    lastName + ", your age is " + age);
		
		/*
		 * Result here shows that the next() method does not fire immediately, 
		 * even with the EOL character sitting in the buffer.It waits until there
		 * is at least one other character in the buffer.
		 * 
		 */ 

	}	//end main
}//end class