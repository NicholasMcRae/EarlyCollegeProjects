/**
 * Program Name:MyToolbox.java
 * Program Purpose: This is a helper class which will hold a whole bunch of really useful methods that we will write over the next three
 * weeks
 * Coder: Nick McRae, 0612749
 * Date: Nov 18, 2011
 * 
 * Revision History:
 * Mon. Nov. 21: added a method to print out the contents of an array of type int. 
 *               -added a method to triple the value of the contents of an array of type int
 *               -overloaded the printArrayContents() method to also work with arrays of type double. 
 */

public class MyToolbox
{
//we cannot nest one method inside of another
	
	//MethodName: oddOrEven()
	//Purpose: prints out a line stating if the value passed in is odd or even
	//Accepts: one argument of type int
	//Returns: nothing. It is a void method.
	
	public static void calculateOddOrEven(int input)
	{
		if (input % 2 == 0)
		{
		  System.out.println("The variable is even");
		}
		else
		{
			System.out.println("The variable is odd");
		}
	}//end method
	
	
  //MethodName: calculateSum()
	//Purpose: calculates and returns the sum of two int arguments
	//Accepts: two arguments of type int
	//Returns: the sum of the two int arguments
	
	public static int calculateSum(int input, int input1)
	{
		System.out.println("Inside the method");
		//add the two values together
		int total = input + input1;
		
		//now return the value to the line that called it
		System.out.println("returning the result");
		return total;
	}
	
  //MethodName: getMaxInt()
	//Purpose: returns the larger of two int arguments
	//Accepts: two arguments of type int
	//Returns: the larger of two int args
	
	public static int getMaxInt(int a, int b)
	{
	//determine the larger number
		if (a > b)
		{
			return a;
		}
		else
		{
			return b;
		}
		
	}//end method getMaxInt()
		
		//MethodName: getMaxInt()
		//Purpose: returns the larger of two int arguments
		//Accepts: two arguments of type int
		//Returns: the larger of two int args
		
		public static int getMinInt(int a, int b)
		{
		//determine the larger number
			if (a < b)
			{
				return a;
			}
			else
			{
				return b;
			}
		
	}//end method getMinInt()
		
		//MethodName: printArrayContents()
		//Purpose: prints out the contents of an array of type int
		//Accepts: an array of type int
		//Returns: nothing. Void method that provides a service
		
		public static void printArrayContents(int [] array)
		{
			for (int i = 0; i < array.length; i++)
			{
				//want to print out 20 values per line then do a newline
				if(i % 20 == 0)
				{
					System.out.println();//for line spacing only
				}
				System.out.print(array[i] + " ");
				
				
			}//end for
			
			
		}//end method printArrayContents
		
		//MethodName: printArrayContents()
		//Purpose: prints out the contents of an array of type double
		//Accepts: an array of type double
		//Returns: nothing. Void method that provides a service
		
		public static void printArrayContents(double [] array)
		{
			for (int i = 0; i < array.length; i++)
			{
				//want to print out 20 values per line then do a newline
				if(i % 20 == 0)
				{
					System.out.println();//for line spacing only
				}
				System.out.print(array[i] + " ");
				
				
			}//end for
			
			
		}//end method printArrayContents
		
		//MethodName: tripleArrayContents()
		//Purpose: used to demonstrate pass by reference mechanism. This method will modify each value in the array that
		//is passed in by multiplying the value by 3 and then assigning it back to the array
		//Accepts: an array of type int
		//Returns: nothing. Void method that provides a service
		public static void tripleArrayContents(int [] array)
		{
			for (int i = 0; i < array.length; i++)
			{
				array[i] = array[i] * 3; //multiply each element by 3
				
				//alternate way of coding this using shortcut assignment 
				array[i]*= 3;
			}
		}
		
		//MethodName: truncateToTwoPlaces()
		//Purpose: takes a double value and truncates it to two decimals
		//Accepts: an argument of type double
		//Returns: the double value truncated to two decimals
		
		public static double truncateToTwoPlaces(double a)
		{
			//step 1: multiply value by 100 and store as double
			double tempDouble = a * 100;
			
			//step 2: cast this, store in a tempInt
			int tempInt = (int)tempDouble;
			
			//step 3: now divide tempInt by 100.0. Re-use the variable tempDouble to hold the answer
			
			tempDouble = tempInt / 100.0;//using 100.0 to avoid an integer division result
			
			//step 4: return the truncated value
			return tempDouble;//fix this before you finish!
		}
		
		//MethodName: roundToTwoPlaces()
		//Purpose: takes a double value and rounds it to two decimals
		//Accepts: an argument of type double
		//Returns: the double value rounded to two decimals
		
		public static double roundToTwoPlaces(double a)
		{
			//step 0: add 0.005 to the argument to assure proper rounding up
			
			a = a + 0.005;//doing this to ensure proper round up
			
			//step 1: multiply value by 100 and store as double
			double tempDouble = a * 100;
			
			//step 2: cast this, store in a tempInt
			int tempInt = (int)tempDouble;
			
			//step 3: now divide tempInt by 100.0. Re-use the variable tempDouble to hold the answer
			
			tempDouble = tempInt / 100.0;//using 100.0 to avoid an integer division result
			
			//step 4: return the truncated value
			return tempDouble;//fix this before you finish!
		}
		
		//MethodName: roundToAnyPlaces()
		//Purpose: takes a double value and rounds it to the number of decimal places specified by the user
		//Accepts: an argument of type double which is the value to be rounded, and an argument of type int which
						// indicates how many decimal places to keep
		//Returns: the double value rounded to the specified number of decimal places
		
		public static double roundToAnyPlaces(double a, int b)
		{
			//step 1: calculate the value of the addend
			
			//addend value is initialized to 0.5
			double addend = 0.5;//starting value
			
			System.out.println("stub1: addend starts at: " + addend);
			
			//calculate the adjuster vvalue for the addend by using Math.pow()
			double adjusterValue = Math.pow(10, b); //b is number of places argument
			System.out.println("stub2: adjusterValue is: " + adjusterValue);
			
			//now divide the addend by the adjusterValue and assign the answer back to the addend variable
			addend = addend / adjusterValue;
			System.out.println("stub 3: adjusted addend value is: ");
			
			//step 3: add the addend value to the value to be rounded, and assign the answer back to the value
			
			a = a + addend;
			System.out.println("stub4: Value after addend added is: " + a);
			
			//step 4: from here on, it's just like the truncate method
			//multiply the value to be rounded by the adjuster to move its decimal point to the right the required number of spaces
			
			double tempDouble = a * adjusterValue;
			System.out.println("stub5: value after multiplication is: " + tempDouble);
			
			//step 5: now cast it to an int to get rid of the excess places
			int tempInt = (int)tempDouble;
			System.out.println("stub6: value after casting is: " + tempInt);
			
			//step 6: last step...divide tempInt by the adjusterValue and assign result back to tempDouble
			tempDouble = tempInt / adjusterValue;
			System.out.println("stub7: value after division is: " + tempDouble);
			
			//return tempDouble
			return tempDouble;
			
		}//end method roundToAnyPlaces
		
		//get array average double
		
		public static double getarrayAverage(int[] array)
		{
			double runningTotal = 0;
			for(int i=0;i < array.length; i++)
			{
				runningTotal += array [i];
			}
			return (runningTotal / array.length);
		}
		
		
		//MethodName: getArrayMedian()
		//Purpose: takes a double value and rounds it to the number of decimal places specified by the user
		//Accepts: an argument of type double which is the value to be rounded, and an argument of type int which
						// indicates how many decimal places to keep
		//Returns: the double value that is the median of all values in the array
		
		public static double getArrayMedian (double [] a)
		{
			java.util.Arrays.sort(a);//sort the array first
			
			if (a.length % 2 == 0)
			{
				double median = 0;
				return median = ((a [a.length / 2 - 1] + a [a.length / 2]) /2);
			}
			else
			{
				double median = 0;
				return median = a [a.length / 2];
			}
		}
			
			//MethodName: getArrayMedian()
			//Purpose: takes a double value and rounds it to the number of decimal places specified by the user
			//Accepts: an argument of type double which is the value to be rounded, and an argument of type int which
			// indicates how many decimal places to keep
			//Returns: the double value that is the median of all values in the array
			
			public static double getArrayMedian (int [] a)
			{
				java.util.Arrays.sort(a);//sort the array first
				
				if (a.length % 2 == 0)
				{
					double median = 0.0;
					return median = ((a [a.length / 2 - 1] + a [a.length/2]) /2);
				}
				else
				{
					double median = 0;
					return median = a [a.length / 2];
				}
			
		
		}
		
		//MethodName: getArrayMinValue()
		//Purpose: returns the lowest of all values in an array
		//Accepts: an array of type int
		//Returns: the double value that is the median of all values in the array
		
		public static double getArrayMinValue (double [] a)
		{
			double minValue = a[0];
			
			for(int i = 0; i < a.length; i++)
			{
			if (a[i] < minValue)
			{
				minValue = a[i];
			}
			
			}
			
			return minValue;
		}
		
		public static int arrayMinValue (int [] a)
		{
			java.util.Arrays.sort(a);
			
			return a [0];			
			
		}
		
		
		//MethodName: getArrayMinValue()
		//Purpose: returns the lowest value in an array of type double
		//Accepts: an array of type double
		//Returns: the lowest value in the array
		
		public static int getArrayMinValue(int [] a)
		{
			int minValue = a[0];
			
			for(int i = 0; i < a.length; i++)
			{
			if (a[i] < minValue)
			{
				minValue = a[i];
			}
			
			}
			
			return minValue;
		}
		
		
		//MethodName: getArrayMaxValue()
		//Purpose: returns the highest value in an array of type double
		//Accepts: an array of type double
		//Returns: the lowest value in the array
		
		public static int getArrayMaxValue(int [] a)
		{
			int maxValue = a[0];
			
			for(int i = 0; i < a.length; i++)
			{
			if (a[i] > maxValue)
			{
				maxValue = a[i];
			}
			
			}
			
			return maxValue;
		}
		
		
		//MethodName: getArrayMaxValue()
		//Purpose: returns the highest value in an array of type int
		//Accepts: an array of type int
		//Returns: the lowest value in the array
		
		public static double getArrayMaxValue(double [] a)
		{
			double minValue = a[0];
			
			for(int i = 0; i < a.length; i++)
			{
			if (a[i] < minValue)
			{
				minValue = a[i];
			}
			
			}
			
			return minValue;
		}
		
		
		//MethodName: isPalindrome()
		//Purpose: determines if a String argument is a palindrome
		//Accepts: accepts an argument of type String
		//Returns: returns a boolean true if the argument is a palindrome, a boolean false if it is not
		
		public static boolean isPalindrome(String a)
		{
			//pseudocode
			//reverse the string using the reverse String method
			//populate two arrays with the two strings
			//somehow compare the two arrays to make sure they're opposites
			
			String reversedString = MyToolbox.reverseString(a);
			
			int length = a.length();
			char [] stringArray = a.toCharArray();
			char [] reverseArray = reversedString.toCharArray();
			
			int j = length;
			boolean isValid;
			for (int i = 0;i < length;i++)
			{
			j--;
			if (stringArray[i] != reverseArray[j])
			{
			return isValid = false;
			}
			}
			
			return isValid = true;
		}
		
		
		//MethodName: reverseString()
		//Purpose: reverses the order of letters in a String
		//Accepts: accepts an argument of type String
		//Returns: a String which has the reverse order of characters
		public static String reverseString(String a)
		{
			//pseudocode
			//1) initialize an array
			//2) populate array with a String
			//3) figure out how to reverse the array
			
			int length = a.length();
			char [] stringArray = a.toCharArray();
			char reverseArray [] = new char [length];
			
			
			
			int k = 0;
			for (int j = length - 1; j >= 0; j--)
			{
				reverseArray [k] = stringArray [j];
				k++;				
			}
			
			String reverseString = new String(reverseArray);
			
			return reverseString;
		}
		
	//MethodName: swapArrayElemeents()
		//Purpose: will swap the values of any two specified elements in an array
		//Accepts: an array of type int, and two int variables which represent the index numbers or subscripts of the two
		           //elements whose values are to be swapped
		//Returns: a String which has the reverse order of characters
		
		public static void swapArrayElements (int[] array, int indexA, int indexB)
		{
			int temp = array[indexA];
			array[indexA]= array[indexB];
			array[indexB]= temp;
		}
		
		
	
}//end main
//end class