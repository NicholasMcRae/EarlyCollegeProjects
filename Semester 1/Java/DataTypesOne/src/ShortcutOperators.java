/**
 * Program Name: ShortCutOperators.java
 * Program Purpose: shows the use of the shortcut or combined assignment operators
 * Coder: Nick McRae, 0612749
 * Date: Sep 26, 2011
 */

public class ShortcutOperators
{

	public static void main(String[] args)
	{
		// create variable and do some work on it
		int numOne = 5;
		System.out.println("Value of numOne is " + numOne);
		
		//apply the operators
		numOne += 6;
		System.out.println("Value of numOne is now " + numOne);
		
		//do a *=
		numOne *= 3;
		System.out.println("Value of numOne is now " + numOne);
		
		//do a /=
		numOne /= 11;
		System.out.println("Value of numOne is now " + numOne);

	}
}
//end main
//end class