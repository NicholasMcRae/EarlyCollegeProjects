/**
 * Program Name: WhatAPane2.java
 * Program Purpose: shows conversion of a String that looks like a double into an actual double
 * data type
 * Coder: Nick McRae, 0612749
 * Date: Sep 30, 2011
 */

import javax.swing.JOptionPane;
public class WhatAPane2
{

	public static void main(String[] args)
	{
		// pseudocode
		// 1) ask user to enter price of their purchase using an input dialog box
		// 2) Parse the input into a double data type using Double.praseDouble()
		// 3) Calculate what the HST payable on the purchase is. Use a constant to hold the value
		//    of the HST tax rate
		// 4) Calculate the total amount owing for the purchase (price + tax)
		// 5) Display total owing without truncating it to two decimals using an output dialog box
		// 6) Truncate the total owing to two decimals using casting. 
		// 70 Output the truncated total owing

		String priceString = JOptionPane.showInputDialog("Please enter the price");
		
		//parse the input into a double data type
		
		double price = Double.parseDouble(priceString);
		
		// calculate HST payable on purchase is using constant
		
		final double HST_RATE = 0.13;
		
		double hstPayable = price * HST_RATE;
		
		// calculate total amount owing
		
		double totalOwing = price + hstPayable;
		
		// display total owing without truncating it to two decimals
		
		JOptionPane.showMessageDialog(null, "Amount owing is " + totalOwing);
		
		// truncate the total owing to two decimals using casting
		
		// truncating to two deciaml... the steps
		// a) multiple the value to be truncated by 100 and store it in a temporary
		//    variable
		// b) cast this temporary variable to an int to truncate excess decimals
		// c) divide this by 100 to get it back to the value with just two decimals
		
		double tempDouble = totalOwing * 100;
		int tempInt = (int)tempDouble; //truncates or cuts off excess decimals
		
		// re-use the totalOwing variable to hold the truncated price
		
		totalOwing = tempInt / 100.0; //use 100.0 to avoid integer division
		
		//Output truncated totalOwing
		
		JOptionPane.showMessageDialog(null,"Truncated total owing is " + totalOwing);
		
		//clean up code to release memory used by the dialog boxes
		System.exit(0); //gives the janitor a chance to clean up all the objects
		
		
	}
}
//end main}
//end class