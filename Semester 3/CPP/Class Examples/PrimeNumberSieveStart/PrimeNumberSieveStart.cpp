// Lianne Wong
// Jan. 31, 2012
// Brute force prime number generator
#include <iostream>
#include <vector>
#include <iomanip>  // formatting output
#include <locale>
#include <Windows.h> // for QueryPerformanceFrequency
using namespace std;

unsigned const MAX_TEST = 200000;
// Function name: isPrime
// Parameters: unsigned number - The number to test
// Return: boolean - true if prime number, false if not
// This method determines whether a number is a prime number or not
bool isPrime(unsigned number)
{
	if(number == 2)
		return true;
	// MAX_TEST = 200000
	//for(unsigned i=2; i <= /*number/2*/sqrt((double)number); ++i)
	// i < number - 8.6 sec   17,984 primes found
	// i < (number/2) - 4.39 sec  
	// i < sqrt(number) - .26 sec  
	// i < sqrt(number) - .13 sec  // not checking even numbers
	// inside of isPrimes and outside in the main()
	for(unsigned i=3; i <= (unsigned)sqrt((double)number); i+=2)
	{
		if(number % i == 0)
			return false;
	}
	return true;
}

int main()
{
	// configure the output stream
	locale here("");
	cout.imbue(here);
	cout << fixed << setprecision(16);

	// create vector to hold prime numbers
	vector<unsigned> primes;

	// get timer frequency
	LARGE_INTEGER timerFrequency;
//	__int64 timerFrequency;
	::QueryPerformanceFrequency(&timerFrequency );
	cout << "Timer Frequency = " << timerFrequency.QuadPart << "\n\n";

	// set the start time and the stop time
	LARGE_INTEGER timerStart, timerStop;
	::QueryPerformanceCounter((&timerStart));
	LARGE_INTEGER startFill, endFill;
	::QueryPerformanceCounter((&startFill));
	// start off filling the primes with all numbers
	vector<unsigned> primes;
	for(unsigned i=2; i<MAX_TEST;++i)
	{
		primes.push_back(i);
	}
	::QueryPerformanceCounter((&endFill));
	LARGE_INTEGER startSieve, endSieve;
	::QueryPerformanceCounter((&startSieve));
	// find prime numbers using the Sieve of Eratosthenes
	for(size_t primePos=0; primePos < primes.size(); ++primePos)
	{
		unsigned primeValue = primes[primePos];

	}

	::QueryPerformanceCounter((&endSieve));
	// stop timer here
	::QueryPerformanceCounter((&timerStop));
	// display elapsed time
	cout << "Elapsed time: " << 
		static_cast<double>(timerStop.QuadPart-timerStart.QuadPart)/timerFrequency.QuadPart
		<< " Seconds\n";
	if(primes.size() < 100)
	{
		for(size_t i=0; i<primes.size();++i)
		{
			cout << primes[i] << ", ";
		}
	}
	cout << "Number of primes found:" << primes.size() << endl;
	return 0;
}