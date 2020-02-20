/**
 * Program Name: MyToolboxTester2.java
 * Program Purpose: to thest the printArrayContents() method of MyToolbox class
 * Coder: Nick McRae, 0612749
 * Date: Nov 21, 2011
 */

public class MyToolboxTester2
{

	public static void main(String[] args)
	{
		// create an array of type int of 100 elements and fill it with random values from 1 to 100
		
		int[] intArray = new int[100];
		
		//fill it with random numbers
		
		for(int i = 0; i < intArray.length; i++)
		{
			intArray[i] = (int)(Math.random() * 100 + 1);
		}//end for
		
		//call the method
		System.out.println("stub1: calling the printArrayContents() method");
		
		MyToolbox.printArrayContents(intArray);
		
		System.out.println("stub2: method has finished, control returned here");

	}
}//end main}
//end class