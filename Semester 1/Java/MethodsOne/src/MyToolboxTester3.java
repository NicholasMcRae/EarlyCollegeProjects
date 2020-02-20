/**
 * Program Name: MyToolboxTester2.java
 * Program Purpose: this version will test the overloaded version of the printArrayContents() method for arrays of type double
 * Coder: Nick McRae, 0612749
 * Date: Nov 21, 2011
 */

public class MyToolboxTester3
{

	public static void main(String[] args)
	{
		// create an array of type int of 100 elements and fill it with random values from 1 to 100
		
		double[] doubleArray = new double[30];
		
		//fill it with random numbers
		
		for(int i = 0; i < doubleArray.length; i++)
		{
			doubleArray[i] = (Math.random() * 100 + 1);
		}//end for
		
		//call the method
		System.out.println("stub1: calling the printArrayContents() method");
		
		MyToolbox.printArrayContents(doubleArray);
		
		System.out.println("stub2: method has finished, control returned here");

	}
}//end main}
//end class