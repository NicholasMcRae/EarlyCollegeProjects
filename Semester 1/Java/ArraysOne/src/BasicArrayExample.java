/**
 * Program Name: BasicArrayExample.java
 * Program Purpose: shows how to instantiate an array and then assign data to their elements and then retrieve data
 * from their elements
 * Coder: Nick McRae, 0612749
 * Date: Nov 4, 2011
 */

public class BasicArrayExample
{

	public static void main(String[] args)
	{
		// making an array of int data type with 3 elements. 
		int [] intArray = new int[3];//coding style, use Array in the variable name 
		
		//assign some values to each box.
		
		intArray[0] = 5;
		intArray[1] = 13;
		intArray[2] = 465;
		
		//access each element and print it out
		
		System.out.println("Value in element 0 is " + intArray[0]);
		
		//use a for loop to access the array
		
		for(int i = 0; i < 3; i++)
		{
			System.out.println("Value in element " + i + " is " + intArray[i]);	
		}
		
		//create an array to hold Strings
		
		String [] namesArray = new String[5];
		
		//put some values in it
		namesArray [0] = "Nick!!!";
		namesArray [1] = "John";
		namesArray [2] = "Jane";
		namesArray [3] = "Larry";
		namesArray [4] = "Moe";
		
		System.out.println("\nstub2: doing the namesArray.");
		
		//use a for loop to print it out, and put the "safety" in place so that you don't run past the end of the array
		
		for(int i = 0; i < namesArray.length; i++)
		{
			System.out.println("Value in element " + i + " is " + namesArray[i]);	
		}
		
		//creating an array without using new through direct instantiation.
		
		String [] surnameArray = {"Pulling", "Smith", "Jones"};

	}
}//end main}
//end class