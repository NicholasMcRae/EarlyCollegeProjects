/**
 * Program Name:ToiletCheck3.java
 * Purpose:shows use of a "buffer flush" to get rid of the  
 *          the EOL character left behind by a nextInt() call and allow
 *          the nextLine() methods to work as intended
 * Coder: Bill Pulling
 * Date: Sep 19, 2011
 */
import java.util.Scanner;
public class ToiletCheck3
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
		
		//HERE WE CALL THE nextLine() method TO DO A "BUFFER FLUSH"
		//TO GET RID OF THAT eol CHARACTER LEFT IN THE BUFFER
		input.nextLine();
		
		//now we can ask for names separately using nextLine()
		
		System.out.print("Enter your first name...");
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