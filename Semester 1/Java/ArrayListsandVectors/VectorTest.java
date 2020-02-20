/**
 * Program Name: VectorTest
 * Purpose: shows creation of an Vector object and some of its methods
 *          for inserting and deleting values. Also shows use of the
 *          enhanced for loop, or "for:each" loop
 * Coder: Bill Pulling
 * Date: Jan 8, 2012
 * 
 */
import java.util.Vector;

public class VectorTest
{

	public static void main(String[] args)
	{
		// create an Vector object using no-arg constructor
		//Will have a capacity of 10
		Vector<String> groupList = new Vector<String>();
		
		
		System.out.println("The current size of this vector object is " + groupList.size());
		System.out.println("The CAPACITY of this vector object is " + groupList.capacity() );
		
		//insert the fab four
		groupList.add("John");
		groupList.add("Pete");//Pete Best, the original drummer
		groupList.add("George");
		groupList.add("Paul");
		
		System.out.println("After the inserts, the size of this vector object is " + groupList.size());
		
    System.out.println("\nContents of the vector are: ");
		for(int index = 0; index < groupList.size(); index++)
		{
			System.out.println("Value in element index " + index + " is " + groupList.get(index));
		}//end for
		
		//now remove Pete
		
		groupList.remove(1);
		
		System.out.println("\nAfter removing Pete...");
		
		for(int index = 0; index < groupList.size(); index++)
		{
			System.out.println("Value in element index " + index + " is " + groupList.get(index));
		}//end for
		
		
		//now insert Ringo at index 2
		System.out.println("\nAdding Ringo at index position 2...");
		groupList.add(2,"Ringo");
		
		for(int index = 0; index < groupList.size(); index++)
		{
			System.out.println("Value in element index " + index + " is " + groupList.get(index));
		}//end for
		
		
		//show use of the inhanced for loop
		
		System.out.println("\nNow using the enhanced for loop to print out the contents...");
		for(String name: groupList)
		{
			System.out.println(name);
		}//end for
		
		
		
	}	//end main 
}//end class
