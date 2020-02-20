/**
 * Program Name: SubClass1.java
 * Program Purpose: a subclass of SuperClass1. Will show the order of calls to constructor methods of classes related
 * 									by inheritance. 
 * Coder: Nick McRae, 0612749
 * Date: Feb 1, 2012
 */

public class SubClass1 extends SuperClass1
{
	//zero-arg constructor
	SubClass1()
	{
		//demonstration of EXPLICIT call to a super class zero-arg constructor
		super(); //calls super class zero-arg constructor
		
		//stub
		System.out.println("Inside the SubClass1 zero-arg constructor.");
		System.out.println("This method is called AFTER Java calls the SuperClass1 constructor.");
	}
	//java implicitly called the superclass constructor because there is a superclass constructor that took zero
	//arguments 
	//bills comments: since the superlcass1 has a zero-arg constructor, java will IMPLICITLY (by itself) call the
	//zero-arg constructor of the super class.
	//NOTE: you can Explicitly call the super class no-arg constructor if you wish, in fact this is often considered
	//good coding practice
	//it would look like this.... super();
}
//end class