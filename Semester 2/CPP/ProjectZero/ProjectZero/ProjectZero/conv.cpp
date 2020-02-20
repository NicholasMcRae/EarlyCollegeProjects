// Jan. 12th / 2012
// Nick McRae
// conv.cpp
// Program Purpose: The purpose of this program is to convert between different unit values given an input value


// Pseudo-code
// 1) write six methods that complete the specified conversions, and write one additional conversion that is unspecified
// 2) include instantiatiations at the top of the program so the program can read any of the functions at any time
// 3) write main method that asks for user input, where we will input a double and a string
// 4) write an if statement that compares the string to each unit value 


#include <iostream>
#include <string>

using namespace std;

double gramToOunce(double grams);
double ounceToGram(double ounces);
double kilogramToPound (double kilograms);
double poundToKilogram (double pounds);
double tonneToTon(double tonnes);
double tonToTonne (double tons);
double litreToPint (double litres);

int main ()
{
	
	bool x = false; //outer loop flag variable
	double changedUnit = 0.0;//where we will store the converted unit value
	double number = 0.0;//where we will store user number input
	string unit;//where we still store user unit input


	//setting an outer while loop which re-iterates prompting for user input if a bad unit has been entered
	while (x != true)
	{


	//ensuring that the inner while boolean condition is reset to false if the outer loop reiterates
	bool y = false;

		
	//inner while loop which will reiterate if a bad number is entered
	while (y != true)
	{

	//prompting for user input
	cout << "Welcome to the unit converter, please enter a decimal number, a space, and then gr, oz, lb, kg, tons, tonnes, or l \n";
	
	//putting number input in the number variable
	cin >> number;

	//checking input with an if statement, if number is good, unit is populated and inner while loop breaks
	if(cin.good())
		{
		cin >> unit;
		y = true;
		}
	else
		{
			//bad number and user is re-prompted for input
			cout << "You have entered a bad number.\n" ;
			cin.clear();
			cin.sync();
			continue;
		}

	
	}//end inner while


	//this is an outer if statement which verifies that the entered number is within a specified range
	if (number > 0.0 && number < 2000000000.0) 
	{
	
	//if the number is correct we will check for the proper unit with an inner if statement. If both the number and unit are correct the unit will be converted
	//if the unit is not correct the outer while loop will reiterate and the user will be prompted to input data once again
	if (unit == "gr")
	{
	changedUnit = gramToOunce(number);
	unit = "oz";
	cout << "Your unit has been changed to " << changedUnit << " " << unit << "." << endl;
	x = true;
	}
	else if (unit == "oz")
	{
	changedUnit = ounceToGram(number);
	unit = "gr";
	cout << "Your unit has been changed to " << changedUnit << " " << unit << "." << endl;
	x = true;
	}
	else if (unit == "kg")
	{
	changedUnit = kilogramToPound(number);
	unit = "lb";
	cout << "Your unit has been changed to " << changedUnit << " " << unit << "." << endl;
	x = true;
	}
	else if (unit == "lb")
	{
	changedUnit = poundToKilogram(number);
	unit = "kg";
	cout << "Your unit has been changed to " << changedUnit << " " << unit << "." << endl;
	x = true;
	}
	else if (unit == "tonne")
	{
	changedUnit = tonneToTon(number);
	unit = "ton";
	cout << "Your unit has been changed to " << changedUnit << " " << unit << "." << endl;
	x = true;
	}
	else if (unit == "ton")
	{
	changedUnit = tonToTonne(number);
	unit = "tonne";
	cout << "Your unit has been changed to " << changedUnit << " " << unit << "." << endl;
	x = true;
	}
	else if (unit == "l")
	{
	changedUnit = litreToPint(number);
	unit = "pt";
	cout << "Your unit has been changed to " << changedUnit << " " << unit << "." << endl;
	x = true;
	}
	else
	{
	//if a proper unit has not been entered none of the methods will run, the if statement will break, and the while loop will reiterate
	cout << "You have entered a bad unit.\n";

	cin.clear();
	cin.sync();
	}
	
	}//end outer if statement

	}//end while loop
	
	
	return 0;
}

/*
Methods Header
Purpose: All methods in this program take a unit parameter, convert it into another unit, and return the corresponding unit
Parameter: Respective unit
Return: Converted unit corresponding with parameter unit
*/

double gramToOunce(double grams)
	{
	double ounces = grams * 0.0353;
	return ounces;  
	}

double ounceToGram(double ounces)
	{
	double grams = ounces * 28.3495;
	return grams;
	}

double kilogramToPound (double kilograms)
	{
	double pounds = kilograms * 2.2046;
	return pounds;
	}

double poundToKilogram (double pounds)
	{
	double kilograms = pounds * 0.4535;
	return kilograms;
	}

double tonneToTon(double tonnes)
	{
	double tons = tonnes * 1.12;
	return tons;
	}

double tonToTonne (double tons)
	{
	double tonnes = tons * 0.892;
	return tonnes;
	}

double litreToPint (double litres)
	{
	double pints = litres * 2.113;
	return pints;
	}

