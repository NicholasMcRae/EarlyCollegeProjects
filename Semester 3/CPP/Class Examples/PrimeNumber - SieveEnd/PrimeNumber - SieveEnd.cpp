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
//	vector<unsigned> primes;
	for(unsigned i=2; i<MAX_TEST;++i)
	{
		primes.push_back(i);
	}
	::QueryPerformanceCounter((&endFill));
	LARGE_INTEGER startSieve, endSieve;
	::QueryPerformanceCounter((&startSieve));
	unsigned const MARKED = 0;
	// find prime numbers using the Sieve of Eratosthenes
	for(size_t primePos=0; primePos < primes.size(); ++primePos)
	{
		unsigned primeValue = primes[primePos];
		if(primeValue == MARKED)
			continue;
		for(size_t multiPos=primePos+primeValue;multiPos < primes.size();
			multiPos += primeValue)
		{
			primes[multiPos]=MARKED;
		}

	}

	::QueryPerformanceCounter((&endSieve));
	// timing the compression of the vector
	// 17,984 prime numbers
	// sieve from begin to end 15 seconds
	// sieve from end to begin 2 seconds
	LARGE_INTEGER startCompress, endCompress;
	::QueryPerformanceCounter((&startCompress));
	// First try to erase from front to back
	/*	for(size_t i = 0; i < primes.size(); ++i)
	{
		if(primes[i] == MARKED)
			primes.erase(primes.begin() + i--);
	}*/
	// Second attempt to erase from back to front
	for(size_t i=primes.size()-1; i>0; --i)
	{
		if(primes[i] == MARKED)
			primes.erase(primes.begin() + i);
	}
	::QueryPerformanceCounter((&endCompress));
	// stop timer here
	::QueryPerformanceCounter((&timerStop));
	// display elapsed time
	cout << "Elapsed time: " << 
		static_cast<double>(timerStop.QuadPart-timerStart.QuadPart)/timerFrequency.QuadPart
		<< " Seconds\n";
	cout << "Fill time: " << 
		static_cast<double>(endFill.QuadPart-startFill.QuadPart)/timerFrequency.QuadPart
		<< " Seconds\n";
	cout << "Sieve time: " << 
		static_cast<double>(endSieve.QuadPart-startSieve.QuadPart)/timerFrequency.QuadPart
		<< " Seconds\n";
	cout << "Compress time: " << 
		static_cast<double>(endCompress.QuadPart-startCompress.QuadPart)/timerFrequency.QuadPart
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