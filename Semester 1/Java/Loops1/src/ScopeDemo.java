/**
 * Program Name:ScopeDemo.java
 * Program Purpose: demonstrates the concept of variable scope. This concept can be summed up like this: a variable is visible in
 * side the curly braces in which it is declared. Statements outside this scope cannot see a variable that is declared inside
 * an inner scope
 * Coder: Nick McRae, 0612749
 * Date: Nov 4, 2011
 */

public class ScopeDemo
{

	public static void main(String[] args)
	{
		// outer scope area will be the entire main method
		
		int outerInt = 1;//variable is in outer scope area
		
		//try referencing all three variables from outer scope area
		System.out.println(outerInt);
		System.out.println(middleInt);
		System.out.println(innerInt);
		
		//middle scope area starts here
		{
			int middleInt = 2;
			
			//inner scope area
			{
				int innerInt = 3;
				System.out.println(outerInt);
				System.out.println(middleInt);
			}//end of inner scope area
			
			
			
		}//end of middle scope area

	}
}//end main and outer sccope area
//end class