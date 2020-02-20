/**
 * Program Name:CompareToExample.java
 * Purpose: shows how the String method compareTo() works
 *         when used to do a LEXICOGRAPHICAL comparison of
 *         two string objects.
 * Coder: Bill Pulling
 * Date: Oct 11, 2011
 */

public class CompareToExample
{

	public static void main(String[] args)
	{
		// Create some short Strings and compare them.
		
		String string1 = "D";
		String string2 = "C";
		
		//now compare them using compareTo() method
		System.out.println("string1 value is " + string1 +
				               " and string2 value is " + string2 + 
				               " and the difference using compareTo() is " +
				               string1.compareTo(string2) ) ;
		
		//do strings with multiple characters
		String string3 = "Bill";
		String string4 = "John";
		
		//now compare them using compareTo() method
		System.out.println("string3 value is " + string3 +
				               " and string4 value is " + string4 + 
				               " and the difference using compareTo() is " +
				               string3.compareTo(string4) ) ;
		
		String string5 = "BILL";
		String string6 = "bill";
		
		//now compare them using compareToIgnoreCase() method
		System.out.println("string5 value is " + string5 +
				               " and string6 value is " + string6 + 
				               " and the difference using compareTo() is " +
				               string5.compareToIgnoreCase(string6) ) ;

	}	//end main 
}//end class





