/**
 * Program Name: VotingAge.java
 * Program Purpose: demonstrates the use of a nested if structure to test if two conditions are true
 * this app determines if a voter is eligible to vote in the Ontario provincial election
 * Coder: Nick McRae, 0612749
 * Date: Oct 5, 2011
 */

import javax.swing.JOptionPane;
public class VotingAge
{

	public static void main(String[] args)
	{
		/*
		 * PSEUDO-CODE
		 * 1) Display a welcome dialogue message box
		 * 
		 * 2) Ask user if they are an Ontario citizen
		 * NESTED if
		 * 3) Outer if: if true that user is an Ontario citizen
		 * then ask user to enter their age
		 * if true that user is >=18 then tell them they can vote
		 * ELSE
		 * tell them they cannot vote
		 * 4) if user IS NOT Ontario citizen, tell them they cannot vote
		 */
		
		JOptionPane.showMessageDialog(null, "Welcome to the Voter Eligibility program. Answer the following questions");
		
		String isCitizen = JOptionPane.showInputDialog("Are you a Canadian citizen? Answer y or n...");
		
		//NESTED if: Outer if: if true  that user is an Ontario citizen, then ask user to enter their age
		
		if(isCitizen.equalsIgnoreCase("y"))
		{
			//ask user their age
			String ageString = JOptionPane.showInputDialog("Enter your age as a whole number");
			
			//parse ageString to an int
			
			int age = Integer.parseInt(ageString);
			
			//INNER if
			//if true that user is >=18 then tell them they can vote
			//ELSE tell them they are not old enough
			if (age >= 18)
			{
				JOptionPane.showMessageDialog(null, "Congratulations, you are eligible to vote!");
			}
			else //outer else associated with outer if
			{
				JOptionPane.showMessageDialog(null, "Sorry, you must be 18 to vote...");
			}
			
		}//end outer if
		
		else
		{
			JOptionPane.showMessageDialog(null,"Sorry, you must be a Ontario citizen...");
		}
			

	}
}//end main}
//end class