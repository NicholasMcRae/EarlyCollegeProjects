/**
 * Program Name: SwapArrayElementsTester.java
 * Program Purpose: tests the swapArrayEllements() method of MyToolbox class
 * Coder: Nick McRae, 0612749
 * Date: Nov 30, 2011
 */

public class SwapArrayElementsTester
{

	public static void main(String[] args)
	{
		// need an array of type int
		int [] testArray = {5, 14};
		
		System.out.println("Contents of testArray are: ");
		
		MyToolbox.printArrayContents(testArray);
		
		//now call the swap method and just pass in 0 and 1 as the indices of the two elements
		MyToolbox.swapArrayElements(testArray, 0, 1);
		
		//call the printArrayContents method again
		System.out.println("Contents of testArray are now: ");
		MyToolbox.printArrayContents(testArray);

	}
}//end main}
//end class