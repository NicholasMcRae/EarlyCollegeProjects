/**
 * Program Name: VectorTest
 * Purpose: shows creation of an Vector object and how it will increase in
 *          capacity when full. Also shows creation of an iterator
 *          object and its use.
 * Coder: Bill Pulling
 * Date: Jan 8, 2012
 * 
 */
import java.util.ListIterator;
import java.util.Vector;

public class VectorTestTwo
{

	public static void main(String[] args)
	{
		// create a Vector object to store Integers using no-arg constructor
		// Will have a capacity of 10 and will double when full
		Vector<Integer> testVector = new Vector<Integer>();
		
		
		System.out.println("The current size of this vector object is " + testVector.size());
		System.out.println("The CAPACITY of this vector object is " + testVector.capacity() );
		
		System.out.println("Filling the vector with values 1 to 10...");
		
		for(int index = 0; index < testVector.capacity(); index++)
		{
			testVector.add(index);//Java will "auto-box" the int to an Integer
			                      //so that we do not have to do an explicit cast
			                      //from int to Integer
		}//end for
		
		//print out values using for:each
		for(Integer value: testVector)
		{
			System.out.print(value + ", ");
		}
		
		System.out.println("\nAfter filling, the current size of this vector object is " + testVector.size());
		System.out.println("\nThe current CAPACITY of this vector object is " + testVector.capacity() );
		
		System.out.println("\n\nAdding one more value of 10 to the filled vector...");
		testVector.add(10);//again auto-boxing occurs to convert it to an Integer
		
		System.out.println("\n Values in the vector are:");
		for(Integer value: testVector)
		{
			System.out.print(value + ", ");
		}
		
		System.out.println("\nAfter adding the value 10, the current size of this vector object is " + testVector.size());
		System.out.println("\nThe current CAPACITY of this vector object is " + testVector.capacity() );
		
		//creating an iterator object for this vector
		
		ListIterator<Integer> myIterator = testVector.listIterator();
		
		System.out.println("\nNow printing out contents using an iterator object...");
		//use it in a while loop
		while(myIterator.hasNext())
		{
			System.out.print(myIterator.next() + ",");//.next() method retrieves the value
		}
		
	}	//end main 
}//end class
