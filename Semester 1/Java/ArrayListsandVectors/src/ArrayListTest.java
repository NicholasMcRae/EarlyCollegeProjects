
/**
 * Program Name: ArrayListTest
 * Purpose: shows creation of an ArrayList object and some of its methods
 *          for inserting and deleting values. Also shows use of the
 *          enhanced for loop, or "for:each" loop
 * Coder: Bill Pulling
 * Date: Jan 8, 2012
 * 
 */import java.util.ArrayList;

public class ArrayListTest
{

	public static void main(String[] args)
	{
		// create an ArrayList object using no-arg constructor
		ArrayList<String> groupList = new ArrayList<String>(10);
		
		System.out.println("The size of this arrayList object is " + groupList.size());
		
		//insert the fab four
		groupList.add("John");
		groupList.add("Pete");
		groupList.add("George");
		groupList.add("Paul");
		
		System.out.println("After the inserts, the size of this arrayList object is " + groupList.size());
		
    System.out.println("\nContents of the arrayList are: ");
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
