/**
 * Program Name: SuperClass1.java
 * Program Purpose: from textbook pages 141-142. This example shows how when you call a subclass constructor,
 * 									Java will first call the constructor method of the super class and build a super class object
 * 									first. Then it builds the subclass object by adding onto the super class object
 * Coder: Nick McRae, 0612749
 * Date: Feb 1, 2012
 */

public class SuperClass1
{
	//zero-arg constructor
	SuperClass1 ()
	{
		//stub
		System.out.println("Inside the SuperClass1, zero-arg constructor.");
	}
}
//end class