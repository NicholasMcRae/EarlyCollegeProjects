/**
 * Program Name:PasswordGenerator.java
 * Program Purpose: To generate a password
 * Coder: Nick McRae, 0612749
 * Program: CPA
 * Course: INFO1150
 * Description: This program will generate a password of variable length while meeting several requirements
 * Date: Nov 15, 2011
 */

import java.util.Scanner;
public class N_McRae_PasswordGenerator
{

	public static void main(String[] args)
	{
		/*
		 * PSEUDOCODE
		 * 1) Display output describing the program
		 * 2) Prompt user to enter the length of their password between 6-16
		 * 3) Store printable ASCII characters in array
		 * 4) Populate a new password array using user prompted length and ASCII array
		 * 5) Create several nested loop and if statements to validate the created password
		 * 6) Print out the password if validation is correct
		 */
		
		//introduce user to the application and describe what it will do
		System.out.println("Welcome to Nick's Password Generator Program\n");
		
		System.out.println("This app will randomly generate a high strength password"
				                + " that consists of letters, digits, and other characters\n");
		
		
		//prompt user to input the length of the password and assign to a variable to be used to populate password array. Also
		//set up a while loop to validate the input. 
		
		boolean userInput = true;
		int passwordLength = 0;
		
		while (userInput)
		{
		Scanner input = new Scanner(System.in);
		System.out.print("How many chracters would you like in your password? (minimum is 6, maximum is 16)\n");
		passwordLength = input.nextInt();
		
		if (passwordLength >= 6 && passwordLength <=16)
		{
			userInput = false;
		}
		else
		{
			System.out.println("Sorry, your entry was incorrect: please enter a number from 6 to 16.");
		}
		}
		
		
		//create array consisting of the printable ASCII characters. This array withholds the unwanted characters so any
		//characters that populate the password array will be valid.
		char [] asciiCharactersArray = {'a', '$', '&', '*', '-', '.', '1', '2', '3', '4', '5', '6',  
				                              '7', '8', '9', '0', '?', 'A', 'a', 'B', 'b', 'C', 'c',
				                              'D', 'd', 'E', 'e', 'F', 'f', 'G', 'g', 'H', 'h', 'I',
				                              'i', 'J', 'j', 'K', 'k', 'L','M', 'm', 'N', 'n', 'o', 
				                               'P', 'p', 'Q', 'q', 'R', 'r', 'S', 's', 'T', 't', 'U',
				                               'u', 'V', 'v', 'W', 'w', 'X', 'x', 'Y', 'y', 'Z', 'z'};
		
		
		//create boolean to control the password generating while loop and iterationAttemps to 
		//describe how many attempts were made to populate the password array correctly
		boolean isValid = true;
		int iterationAttempts = 0;
		
		
		//initialize the array which will hold the password
		char passwordArray [] = new char [passwordLength];
		
	
		
		while(isValid)
		{
			/*
			 * Here we populate passwordArray, that is the size of the prompted user input, with characters from asciiCharactersArray 
		   * using a for loop and math.random. I am using a while loop to simultaneously populate and 
		   * validate the password. In the immediately lower block the password will be populated and iteration attempts will be incremented.
		   * Below this block we will begin to validate the characters within the password to ensure that they are correct. If
		   * the validation check fails the password will be re-populated, the iteration counter will be incremented, and
		   * the new password will undergo further validation.
			 */
			iterationAttempts += 1;
			
			//populating the password
			for (int i = 0; i < passwordLength; i++)
			{
				passwordArray [i] = asciiCharactersArray [(int)(Math.random() * 66 + 1)];
			}
			
			
			if (Character.isLetter(passwordArray[0])) //in this line we validate that the first password character is a letter
							
				for (int i = 0; i < passwordArray.length; i++) //setting up a for loop to test for upper case letters
				{
					
					if (Character.isUpperCase(passwordArray[i])) //testing if an upper case letter exists in the password
					
						
						for (int j = 0; j < passwordArray.length; j++)//setting up a for loop to test lower case letters
						{
							
							if (Character.isLowerCase(passwordArray[j]))//testing if a lower case letter exists in the password
							
															
								for (int k = 0; k < passwordArray.length; k++)//setting up a for loop to test for digits
								{
									
									if (Character.isDigit(passwordArray[k]))//testing if a digit exists in the password
										
																												
										for (int l = 0; l < passwordArray.length; l++)//setting up a for loop to test for non-digits/letters using not operator
										{
											
											if (!Character.isDigit(passwordArray[l]) && !Character.isLetter(passwordArray[l]))//testing for non-digit/letter characters
											{
													
											  //if validation has made it this far we end the while loop and the current for loop and print the password	
												isValid = false;
												break;
											}
											
										}
											
									}
									
							
						}
													
					}
							
								
					}
		
		// Here the iteration attempts and password output are printed
		
		String password = new String(passwordArray);
		
		System.out.println("Your " + passwordLength + " character password is 11 " + password);
		
		System.out.print("\nIt took " + iterationAttempts + " attempts to validate your password");
	
	
				}//end main
			}//end class