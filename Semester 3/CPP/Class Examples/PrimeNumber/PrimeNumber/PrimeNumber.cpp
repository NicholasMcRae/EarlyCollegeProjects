// Nick McRae
// Jan. 31, 2012
// Brute force prime number generator
#include <iostream>
#include <vector>
#include <iomanip> //formatting output
#include <locale>
#include <Windows.h> //for QueryPerformanceFrequency

using namespace std;

unsigned const MAX_TEST = 10;

//Function name: isPrime
	//Parameters: unsigned number - The number to test
	//Return: boolean - true if prime number, false if not
	// This method determines whether a number is a prime number

bool isPrime(unsigned number)
	{
		for (unsigned i=2; i < number/2; ++i)
		{
			if(i%number == 0)
			{
				return false;
			}
			else
			{
				return true;
			}

		}


	}

int main()
{
	//configure the output stream
	//going to need this for the next homework assignment
	//locale here tells the computer to figure out what region it is in
	//imbue will format output stream to current location

	locale here("");
	cout.imbue(here);

	cout << fixed << setprecision(16);
	//formatting the output

	// get timer frequency
	//doing it in C++ because we are concerned about performance
	LARGE_INTEGER timerFrequency;
	//__int64 timerFrequency;
	::QueryPerformanceFrequency(
		reinterpret_cast<LARGE_INTEGER*>(&timerFrequency) );
	//reinterpret is another type of casting which is not a normal straight casting
	cout << "Timer Frequency = " << timerFrequency.QuadPart << "\n\n";

	// set the start time and the stop time 
	LARGE_INTEGER timerStart, timerStop;
	::QueryPerformanceCounter(
		reinterpret_cast<LARGE_INTEGER*>(&timerStart));
	//put the code to time here

	//stop timer here
	::QueryPerformanceCounter(
		reinterpret_cast<LARGE_INTEGER*>(&timerStop));
	// display elapsed time
	cout << "Elapsed time: " << static_cast<double>(timerStop.QuadPart-timerStart.QuadPart)/timerFrequency.QuadPart
		<< " Seconds\n";

	vector<int> vecI;

	 
	//put the code to time here
	for(size_t i=2; i<=MAX_TEST; ++i)
	{
		if(isPrime(i))
		{
			vecI.push_back(i);
		}

	}


	
	return 0;
}

