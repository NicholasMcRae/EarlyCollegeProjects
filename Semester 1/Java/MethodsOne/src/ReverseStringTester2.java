/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Dec 2, 2011
 */
public class ReverseStringTester2
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		
	//pseudocode
		//1) initialize an array
		//2) populate array with a String
		//3) figure out how to reverse the array
		String a = "super";
		
		int length = a.length();
		char [] stringArray = a.toCharArray();
		char reverseArray [] = new char [length];
		
		
		
		int k = 0;
		for (int j = length - 1; j >= 0; j--)
		{
			reverseArray [k] = stringArray [j];
			k++;				
		}
		
		String reverseString = new String(reverseArray);
		
		System.out.println(reverseString);
		
		

	}
}//end main}
//end class