/**
 * Program Name: StringComparisons.java
 * Program Purpose: shows how using the equality operator to test to see if two strings have the same characters
 * is dangerous and can cause logic erros
 * Coder: Nick McRae, 0612749
 * Date: Oct 7, 2011
 */

public class StringComparisons
{

	public static void main(String[] args)
	{
		// create two String variables that have the same text
		
		String name1 = "Nick";
		String name2 = "Nick";
		
		//test them for equality using == operator
		
		if (name1 == name2)
		{
			System.out.println("name1 holds " + name1 + " and name2 holds " + name2 + " so they are equal");
		}
		else
		{
			System.out.println("name1 holds " + name1 + "name2 holds " + name2 + " so they are not equal");
		}
		
		//create two more names using the full formal method of creating a String variable, using the
		//new operator
		
		String name3 = new String("McRae");
		String name4 = new String("McRae");
		
		if (name3 == name4)
		{
			System.out.println("name3 holds " + name3 + " and name4 holds " + name4 + " so they are equal");
		}
		else
		{
			System.out.println("name3 holds " + name3 + "name4 holds " + name4 + " so they are not equal");
		}
		
		//doesn't work at run time
		
		//now test for string equality using String class method
		//equals()
		
		System.out.println("\nNow testing for equality using the " + " String method equals()...");

		//test them for equality using method equals();
		
		if (name1.equals(name2))
		{
			System.out.println("name1 holds " + name1 + " and name2 holds " + name2 + " so they are equal");
		}
		else
		{
			System.out.println("name1 holds " + name1 + "name2 holds " + name2 + " so they are not equal");
		}
		
		
		if (name3.equals(name4))
		{
			System.out.println("name3 holds " + name3 + " and name4 holds " + name4 + " so they are equal");
		}
		else
		{
			System.out.println("name3 holds " + name3 + "name4 holds " + name4 + " so they are not equal");
		}
	}
}//end main}
//end class