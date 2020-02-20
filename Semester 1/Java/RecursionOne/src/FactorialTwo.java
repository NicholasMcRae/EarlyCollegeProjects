/**
 * Program Name: FactorialTwo.java
 * Program Purpose: shows the use of factorials in calculating the number of combinations of size 'r' from a superset
 * of size n
 * Coder: Nick McRae, 0612749
 * Date: Jan 4, 2012
 */

import java.util.Scanner;
public class FactorialTwo
{

	public static void main(String[] args)
	{
		// create scanner
		Scanner input = new Scanner(System.in);
		
		//Explain to user what's happening
		System.out.println("This program will calculate how many combinations of a subset of size r can " +
				" be made from a superset of size n.");
		
		//get n and r from user
		int n = 0; //this is the size of the superset
		int r = 0; //this is the size of the subset
		
		System.out.print("Enter the size of the superset: ");
		n = input.nextInt();
		
		System.out.print("Enter the size of the subset: ");
		r = input.nextInt();
		
		//call the method calcCombinations() and pass in n and r
		
		double answer = calcCombinations(n,r);
		
		//output
		System.out.println("The number of combinations of size " + r + " from a superset of size " + n + " is "
				+ (int)answer);
		
		//do the permutations calculations
		answer = calcPermutations(n,r);
		
		System.out.println("The number of permutations of size " + r + " from a superset of size " + n + " is "
				+ (int)answer);

	}
	
	/*
	 * MethodName: calcFactorial()
	 * Purpose: calculates the factorial of the argument n
	 * 					where n is a positive integer
	 * Accepts: a positive integer value 
	 * Returns: a double that is the factorial of n
	 * NOTE: changed return type to double to enable method to handle values larger than 20! without overflow problems
	 */
	
	public static double calcFactorial(int n)
	{

		
		if(n == 0)
		{
			return 1;//stopping case
		}
		//else, we need to call the method again but decrease n by 1
		else
		{
			return n * calcFactorial(n-1);
		}
		
	}//end method calcFactorial()
	
	
	/*
	 * MethodName: calcCombinations()
	 * Purpose: calculates the number of combinations of a subset of size r from a superset of size n
	 * Accepts: two int arguments. First arg will be the superset size 'n', and second arg will be the subset size r 
	 * Returns: a double that is the number of possible combinations of size 'r'
	 * 
	 */
	
	public static double calcCombinations(int n, int r)
	{
		
		return calcFactorial(n) / (calcFactorial(r) * calcFactorial(n-r));
	}//end method calcCombinations()
	
	/*
	 * MethodName: calcPermutations()
	 * Purpose: calculates the number of combinations of a subset of size r from a superset of size n
	 * Accepts: two int arguments. First arg will be the superset size 'n', and second arg will be the subset size r 
	 * Returns: a double that is the number of possible combinations of size 'r'
	 * 
	 */
	
	public static double calcPermutations(int n, int r)
	{
		
		return calcFactorial(n) / (calcFactorial(n-r));
	}//end method calcCombinations()
	
}//end main}
//end class