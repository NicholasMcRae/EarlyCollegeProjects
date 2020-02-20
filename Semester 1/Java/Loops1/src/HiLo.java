/**
 * Program Name:HiLo.java
 * Program Purpose: a simpel game program that asks a user to guess a randomly selected number from 1 to 128. The program
 * will keep track of how many guesses the user takes and will report this at end of game. Program will also tell user if
 * their guess is high, low, or is correct.
 * Coder: Nick McRae, 0612749
 * Date: Oct 21, 2011
 */

import java.util.Scanner;
public class HiLo
{

	public static void main(String[] args)
	{
		/*
		 * 1) tell user how to play the game
		 * 2) create Scanner object
		 * 3) generate a random number from 1-128 using Math.random()
		 *
		 * 4) LOOP
		 *    a) prompt user to enter guess
		 *    b) increment the guess counter
		 *    c) evaluate guess as high, low, or correct
		 *       IF
		 *         guess is high, tell them too high!
		 *       Else
		 *         guess is low, tell them too low!
		 *       Else
		 *         guess is correct, tell them correct!
		 *       End Loop
		 * 5) tell user how many guesses it took.
		 */
		
		//tell user how to play the game
		System.out.println("Hi, welcome to the HiLo game");
		System.out.println("I've picked a number from 1 to 128.");
		System.out.println("Try to guess what it is!");
		
		//create Scanner object
		Scanner input = new Scanner(System.in);
		
		//generate a random number
		int randomNumber = (int)(Math.random() * 128 + 1);
		
		//loop
		//set up flag variable
		
		boolean isCorrect = false; 
		int userGuess = 0;
		int guessCount = 0;
		
		//while loop using negation operator on the flag
		while (!isCorrect)
		{
			//prompt user to enter guess
			System.out.println("Dear User, I would most appreciate it if you would enter a guess from 1-128");
			
			//read buffer
			userGuess = input.nextInt();
			
			//increment the guess counter
			guessCount++; 
			
			//evaluate guess as high, low, or correct
			
			if(userGuess == randomNumber)
			{
				System.out.println("Well done! You got it!");
				
				//adjust loop flag to exit the loop
				isCorrect = true;
			}
			else if(userGuess > randomNumber)
			{	
				System.out.println("Your number is too high bitch");
			}
			else if(userGuess < randomNumber)
			{
				System.out.println("Your number is too low dude");
			}
			
			//
		
		}//end while
		
		System.out.println("It took you " + guessCount + " guesses.");

	}
}//end main}
//end class