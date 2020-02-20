/**
 * Program Name:ObjectClassMethodsDemo.java
 * Purpose: just shows the output of certain Object class methods
 *          such as toString(), hashCode(), and getClass()
 * Coder: Bill Pulling
 * Date: Feb 14, 2012
 */
import java.util.Scanner;
public class ObjectClassMethodsDemo
{

	public static void main(String[] args)
	{
		// create a String object and call some of the methods
		String nameOne = "AAA";
		//call the methods
		System.out.println("Output of nameOne calling toString() is: " +
		                    nameOne.toString());
		
		System.out.println("Output of nameOne calling hasCode() is: " +
        nameOne.hashCode());
		
		System.out.println("Output of nameOne calling getClass() is: " +
        nameOne.getClass());

		//create a Scanner object
		Scanner input = new Scanner(System.in);
		
		System.out.println("\nOutput of input calling toString() is: " +
        input.toString().toString());

		System.out.println("Output of input calling hasCode() is: " +
				input.hashCode());

		System.out.println("Output of input calling getClass() is: " +
				input.getClass());
		
		
	}
	//end main 
}
//end class