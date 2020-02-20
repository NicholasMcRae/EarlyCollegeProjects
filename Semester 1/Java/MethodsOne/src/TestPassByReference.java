/**
 * Program Name: TestPassByReference.java
 * Program Purpose: shows the pass by reference mechanism in action.
 *                  java uses pass by reference for all object data types.
 *                  Here, an array object is passed to a method in the MyToolbox class and gets its values modified by
 *                  the method.
 * Coder: Nick McRae, 0612749
 * Date: Nov 21, 2011
 */

public class TestPassByReference
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
		
		System.out.println("stub1: contents of the array are: ");
		
		MyToolbox.printArrayContents(intArray);
		
		System.out.println("stub2: calling method tripleArrayContents():");
		
		MyToolbox.tripleArrayContents(intArray);
		
		//now call print method again to see the changed values
		
		System.out.println("stub3: contents of array are now: ");
		
		MyToolbox.printArrayContents(intArray);

	}
}//end main}
//end class