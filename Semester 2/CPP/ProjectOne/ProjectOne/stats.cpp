#include <iostream>
#include <vector>
#include <algorithm>
#include <stdio.h>
#include <math.h>
#include <set>
#include <iomanip>
#include <map>

using namespace std;

//PSEUDOCODE
//1) write functions for different pieces of statistical data, individual pseudocode for each one where necessary
//2) Create output in main



//Function Name: numberOfVectorElements
//Function Purpose: Return the number of elements contained in the inputted vector
//Parameters: Vector of type integer
//Returns: Integer value describing number of elements in the inputted vector

int numberOfVectorElements (vector <int> vec)
{
return vec.size() +1;
}//end numberOfVectorElements


//Function Name: minimumValue
//Function Purpose: Calculate the minimum value of the vector
//Parameters: Vector of type integer
//Returns: Integer value describing the minimum value of the vector

double minimumValue (vector <int> vec)
{
sort(vec.begin(), vec.end());
return vec[0];

}//end minimumValue


//Function Name: maximumValue
//Function Purpose: Calculate the maximum value of the vector
//Parameters: Vector of type integer
//Returns: Integer value describing the maximum value of the vector

double maximumValue (vector <int> vec)
{
sort(vec.begin(), vec.end());

return vec[vec.size() - 1];

}//end maxmiumValue


//Function Name: medianValue
//Function Purpose: Calculate the median value of the vector
//Parameters: Vector of type integer
//Returns: Integer value describing the maximum value of the vector

double medianValue (vector <int> vec)
{
sort(vec.begin(), vec.end());

	if (vec.size() % 2 == 0)
	{
	double median = 0;
	return median = ((double)(vec [vec.size() / 2 - 1] + vec [vec.size() / 2]) /2);
	}
	else
	{
	double median = 0;
	return median = vec [vec.size() / 2];
	}
}//end medianValue


//Function Name:  meanValue
//Function Purpose: Calculate the mean of the vector
//Parameters: Vector of type integer
//Returns: Double value of mean of integers in the vector

double meanValue (vector <int> vec)
{
int addedVector = 0;
double mean = 0.0;

	for (size_t i=0; i < vec.size();++i)
	{
	addedVector += vec[i];
	}

mean = (double)addedVector / vec.size();

return mean;

}//end meanValue


//Function Name: standardDeviation
//Function Purpose: Calculate the standard deviation of the vector
//Parameters: Vector of type integer
//Returns: Double value of standard deviation of integers in the vector

double standardDeviation (vector <int> vec)
{
double mean = meanValue(vec);//using the mean function to calculate the mean for use in calculating standard deviation
double varied = 0;//holding the amount that each data point varies from the mean
double accumulation = 0;//accumulating all of the variable values

	for(unsigned int i = 0; i < vec.size(); ++i)
	{
	double varied = fabs(((double)mean - vec[i])*((double)mean - vec[i]));//using absolute value
	accumulation += varied;
	}

double deviation = 0.0;//initializing deviation variable
deviation = sqrt ((double)accumulation/vec.size());//standard deviation equation
return deviation;

}//end standardDeviation


//Function Name: standardVariance	
//Function Purpose: Calculate the standard variance of the vector
//Parameters: Vector of type integer
//Returns: Double value of standard variance of integers in the vector
//NOTE: This function works in the same manner as standard deviation except that the final equation does not contain a square root

double standardVariance (vector <int> vec)
{
double mean = meanValue(vec);
double varied = 0;
double accumulation = 0;

	for(unsigned int i = 0; i < vec.size(); ++i)
	{
	double varied = fabs(((double)mean - vec[i])*((double)mean - vec[i]));
	accumulation += varied;
	}

double variance = 0.0;
variance = (double)accumulation/vec.size();
return variance;

}//end standardVariance



//Function Name: vectorMode
//Function Purpose: Calculate the mode, or multiple modes of the vector, or determine if there is no mode
//Parameters: Vector of type integer
//Returns: Nothing. Prints out mode(s) to screen

void vectorMode(vector <int> vec)
{
/*
I recognize that I can do this function much more easily and efficiently with maps, but after writing such a long function before we learned maps 
I've decided to keep my original code
*/


//initializing function variables

int containerInt = 0;//used to hold the value contained in the element in the original, data vector that is being iterated in the outer for loop
int counter = 0;//used to count the number of times that the number contained in containerInt appears in the data vector
vector <int> counterVec;//a vector that holds the counts of each element in the data vector. Element numbers of the data vector and this vector will correspond
int modeCountValue = 0;//an integer used to hold the current highest count in the data vector. i.e. if we check 13 and see that it appears 4 times, more than any other element, modeCountValue
						//will hold 4.
set <double> setD;//this will hold all of the final modes that we find in the data vector


		
	for (unsigned int i = 0; i < vec.size(); ++i)//for each element of the vector we are going to compare to the rest of the vector to see how many of the number contained in that element
												//there are in the entire vector
	{

	containerInt = vec[i];//we have an integer that will hold whatever element of the vector we are comparing
	counter = 0;//resetting the counter

			
			for(unsigned int j = 0; j < vec.size(); ++j)//this for loop will iterate through the vector and compare our initial value to each value in the vector, if there is a match we increment
															//the counter by 1
			{
				
					if(containerInt == vec[j])//this if statement increments a counter by 1 for every time an equivalent value arises in the vector
					{
					counter += 1; 
					}//end if
				
			}//end inner for

			
	counterVec.push_back(counter);//inputting counter values into a new vector. These element numbers will correspond with the element numbers of the initial vector. This will allow us to find
								  //the elements with the highest count in the data vector

				

	if (counter > modeCountValue)//if the counter is greater than the modeCount value, we set the modeCountValue equal to the counter
	{
	modeCountValue = counter;
	}
				
	
	}//end outer for

	bool noMode = true;

	//we are checking to see if there is a mode here, if there is at least two different values in counterVec, there should be a mode
	for (unsigned int i = 0; i < counterVec.size(); ++i)
	{
		if(vec[0] != vec[i] && counterVec[0] != counterVec[i])
		{
			noMode = false;
			break;
		}
	}


	for (unsigned int i = 0; i < counterVec.size(); ++i)//iterating through the counterVector to find all of the modes, or elements with the highest count values
	{
			if(noMode)//if we have found that there is no mode, this will be true and we will break, if there is a mode we will insert values into a set
			{
			break;
			}
			else if (modeCountValue == counterVec[i] && modeCountValue > 1)//if we find a value in counterVec that is equal to the highest count we initially found, we will take that element number and use it to locate
												   //the same element in the data vector, which will be a mode. We will then put it in a set so we don't print duplicate modes	
			{
				setD.insert(vec[i]);
			}

	}//end for 

		
	
	if(setD.empty())//if we found no modes, print that there is no mode
	{
	
	cout << "There is no mode." << endl;
	}
	else if(setD.size() == 1)
	{
	cout << "The mode is: ";

		for(set<double>::iterator it=setD.begin(); it!= setD.end(); ++it)//iterate through the set and print the values
		{
		cout << setiosflags(ios::fixed) << setprecision(3) << *it;
		}
	}
	else
	{
	cout << "The modes are: ";

		for(set<double>::iterator it=setD.begin(); it!= setD.end(); ++it)//iterate through the set and print the values
		{
		 cout << setiosflags(ios::fixed) << setprecision(3) << *it << ", ";
		}

	}//end if


}//end vectorMode


//Function Name: frequencyDistribution
//Function Purpose: Finds the frequency distribution of the given data set and also produces a histogram.
//Parameters: Vector of type int
//Returns: Nothing. Prints off list of values within each increment, as well as a histogram of the data set

void frequencyDistribution(vector <int> vec)
{
sort(vec.begin(), vec.end());

//calculate the range and the size of each variable
double range = maximumValue(vec) - minimumValue(vec);
double rangeSlot = range / 10;
//declare counter variables that will be used to count each value that falls within each range
int counterNine = 0;
int counterEight = 0;
int counterSeven = 0;
int counterSix = 0;
int counterFive = 0;
int counterFour = 0;
int counterThree = 0;
int counterTwo = 0;
int counterOne = 0;
int counterZero = 0;


//iterate through the vector and increment the appropriate counter for each data point
	for(unsigned int i = 0; i < vec.size(); ++i)
	{
		if(vec[i] <= maximumValue(vec) && vec[i] > (maximumValue(vec) - rangeSlot))
		{
		counterNine += 1;
		}
		else if(vec[i] <= (maximumValue(vec) - rangeSlot) && vec[i] > (maximumValue(vec)-(2 * rangeSlot)))
		{
		counterEight += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (2 * rangeSlot)) && vec[i] > (maximumValue(vec)-(3 * rangeSlot)))
		{
		counterSeven += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (3 * rangeSlot)) && vec[i] > (maximumValue(vec)-(4 * rangeSlot)))
		{
		counterSix += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (4 * rangeSlot)) && vec[i] > (maximumValue(vec)-(5 * rangeSlot)))
		{
		counterFive += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (5 * rangeSlot)) && vec[i] > (maximumValue(vec)-(6 * rangeSlot)))
		{
		counterFour += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (6 * rangeSlot)) && vec[i] > (maximumValue(vec)-(7 * rangeSlot)))
		{
		counterThree += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (7 * rangeSlot)) && vec[i] > (maximumValue(vec)-(8 * rangeSlot)))
		{
		counterTwo += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (8 * rangeSlot)) && vec[i] > (maximumValue(vec)-(9 * rangeSlot)))
		{
		counterOne += 1;	
		}
		else if(vec[i] <= (maximumValue(vec) - (9 * rangeSlot)) && vec[i] >= (maximumValue(vec)-(10 * rangeSlot)))
		{
		counterZero += 1;	
		}

			
	}//end for loop

//store the exact transition points between ranges in variables to be used in the printed output
double zero = minimumValue(vec);
double one = maximumValue(vec)-(9 * rangeSlot);
double two = maximumValue(vec)-(8 * rangeSlot);
double three = maximumValue(vec)-(7 * rangeSlot);
double four = maximumValue(vec)-(6 * rangeSlot);
double five = maximumValue(vec)-(5 * rangeSlot);
double six = maximumValue(vec)-(4 * rangeSlot);
double seven = maximumValue(vec)-(3 * rangeSlot);
double eight = maximumValue(vec)-(2 * rangeSlot);
double nine = maximumValue(vec)-(1 * rangeSlot);
double ten = maximumValue(vec) + 0.02;

//store the ratios in variables to be used in the printed output
double ratioZero = (double)counterZero/vec.size();
double ratioOne = (double)counterOne/vec.size();
double ratioTwo = (double)counterTwo/vec.size();
double ratioThree = (double)counterThree/vec.size();
double ratioFour = (double)counterFour/vec.size();
double ratioFive = (double)counterFive/vec.size();
double ratioSix = (double)counterSix/vec.size();
double ratioSeven = (double)counterSeven/vec.size();
double ratioEight = (double)counterEight/vec.size();
double ratioNine = (double)counterNine/vec.size();
		
//frequency distribution output
cout << endl;
cout << "Frequency Distribution:" << endl;
cout << endl;

cout << setiosflags(ios::right) << setw(5) << zero << "..." << one << " = " << counterZero << " : " << ratioZero << endl;
cout << setiosflags(ios::right) << setw(5) << one << "..." << two << " = " << counterOne << " : " << ratioOne << endl;
cout << setiosflags(ios::right) << setw(5) << two << "..." << three << " = " << counterTwo << " : " << ratioTwo << endl;
cout << setiosflags(ios::right) << setw(5) << three << "..." << four << " = " << counterThree << " : " << ratioThree << endl;
cout << setiosflags(ios::right) << setw(5) << four << "..." << five << " = " << counterFour << " : " << ratioFour << endl;
cout << setiosflags(ios::right) << setw(5) << five << "..." << six << " = " << counterFive << " : " << ratioFive << endl;
cout << setiosflags(ios::right) << setw(5) << six << "..." << seven << " = " << counterSix << " : " << ratioSix << endl;
cout << setiosflags(ios::right) << setw(5) << seven << "..." << eight << " = " << counterSeven << " : " << ratioSeven << endl;
cout << setiosflags(ios::right) << setw(5) << eight << "..." << nine << " = " << counterEight << " : " << ratioEight << endl;
cout << setiosflags(ios::right) << setw(5) << nine << "..." << ten << " = " << counterNine << " : " << ratioNine << "\n" << endl;
	

int factor = 1; //declaring variable that will adjust the histogram depending on the vector size

//for every increment of 500 in the vector size the factor will increase by 5, so if the vector size is 500 each asterisk will have a value of 5, if 1000 asterisks will have a value of 10 etc.
if(vec.size() >= 500)
{
factor = ((vec.size() / 500)*5);
}
	
//outputting the histogram
cout << "A single asterisk = " << factor << " data points." << endl;
cout << "Histogram:" << endl;
cout << endl;


cout << right << setw(20) << zero << "..." << one << " = ";

for(int i=0; i < counterZero/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << one << "..." << two << " = ";

for(int i=0; i < counterOne/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << two << "..." << three << " = ";

for(int i=0; i < counterTwo/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << three << "..." << four << " = ";

for(int i=0; i < counterThree/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << four << "..." << five << " = ";

for(int i=0; i < counterFour/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << five << "..." << six << " = ";

for(int i=0; i < counterFive/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << six << "..." << seven << " = ";

for(int i=0; i < counterSix/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << seven << "..." << eight << " = ";

for(int i=0; i < counterSeven/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << eight << "..." << nine << " = ";

for(int i=0; i < counterEight/factor; ++i)
{
cout << "*";
}

cout << "\n" << right << setw(20) << nine << "..." << ten << " = ";

for(int i=0; i < counterNine/factor; ++i)
{
cout << "*";
}

}//end function
	


	

int main()
{

//declare our vector to store the values
vector<int> v;
int i;

//push text document into the vector
while(cin >> i)
{
v.push_back(i);
}

//print out output
cout << endl;
cout << "Results:" << endl;
cout << "N = " << numberOfVectorElements(v) << endl;
cout << setiosflags(ios::fixed) << setprecision(3) << "Min = " << minimumValue(v) << endl;
cout << "Max = " << maximumValue(v) << endl;
cout << "Arithmetic mean = " << meanValue(v) << endl;
cout << "Statistical median = " << medianValue(v) << endl;
cout << "Variance = " << standardVariance(v) << endl;
cout << "Standard deviation = " << standardDeviation(v) << endl;
vectorMode(v);
cout << setiosflags(ios::fixed) << setprecision(2);
cout << endl;
frequencyDistribution(v);



	return 0;
}