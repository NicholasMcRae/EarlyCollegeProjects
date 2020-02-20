/**
 * Program Name: MagicDates.java
 * Program Purpose: Determine if a specific date is magic or not.
 * Coder: Nick McRae, 0612749
 * Date: Oct 12, 2011
 */

import javax.swing.JOptionPane;
public class MagicDates
{

	public static void main(String[] args)
	{
		// pseudo-code
		
		/*
		 * 1) import pane method
		 * 2) Create pane inputs for day, month, and year and set to variables
		 * 3) Create if-else statement based on magic number and display proper output
		 */
		
		String day = JOptionPane.showInputDialog("Enter a day of a month...");
		String month = JOptionPane.showInputDialog("Enter the number of a month...");
		String year = JOptionPane.showInputDialog("Enter the last two digits of a year...");
		
		int intDay = Integer.parseInt(day);
		int intMonth = Integer.parseInt(month);
		int intYear = Integer.parseInt(year);
		
		if (intDay*intMonth == intYear)
			
		{
			JOptionPane.showMessageDialog(null, "This date is most certainly magic");
		}
		
		else
			
		{
			JOptionPane.showMessageDialog(null, "This date is most certainly not magic");
		}

	}
}//end main}
//end class