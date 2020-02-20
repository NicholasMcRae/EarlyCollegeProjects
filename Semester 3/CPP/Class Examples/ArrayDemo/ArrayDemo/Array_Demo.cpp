//Nick McRae
// Jan. 17, 2012
//Intro to arrays in c==
#include <iostream>
#include <string>
//for memory leak checking
#define _CRTDBG_MAP_ALLOC
#include <crtdbg.h>

using namespace std;

int globalArray[100];
//global variable declared outside, in this case it can be seen by anybody, never use global variables unless you have to, the power is that the variable gets allocated in memory and it
//stays there as long as your program is open

int main()
{

#if defined(_DEBUG)
	int dbgFlags = ::_CRTSetDbgFlag(_CRTDBG_REPORT_FLAG);
	//bitwise or check block integrity on every memory call
	dbgFlags |= CRTDBG_CHECK_ALWAYS_DF;
	//don't always remove blocks on delete
	dbgFlags |= _CRTDBG_DELAY_FREE_MEM_DF;
	// check for memory leaks at process termination
	dbgFlags |= _CRTDBG_LEAK_CHECK_DF;
	_CRtSetDbgFlag(dbgFlags);

#endif
	//run whatever is in if and end if we are in debug mode

	int const x = 10;
	int localArray[x]; //only visible in main()
	int loaded[] = { 1, 2, 3, 4, 5, 6, 7};
	int partialLoaded[10] = { 1, 2, 3 }; //a vector does not load like this, can't do this on a test
	int zeroed[100] = { 0 };

	//print out array
	for(unsigned i = 0; i < 8; i++)
		cout << "loaded[" << i << "]=" << loaded[i] << endl;

	cout << "loaded is " << sizeof(loaded) << " bytes long\n";
	cout << "loaded has " << sizeof(loaded)/sizeof(loaded[0]) << elements\n";
		//figuring out the size of container and size of one element
		// can put this in a for loop so you always get that as the size of the array instead of hard coding the size

		loaded[4] = 100;
		loaded[20] = 23;
		//it will allow you to access over the length of the array, and it will change a memory location to that value
		//why c is powerful because you can do funny things like this

		// dynamic arrays
		int * ptr = nullptr;
		ptr = loaded;
		//pointer points to array of integers, pointer indicates the location of an int value
		// pointer points to the loaded array

		cout << ptr << ": " << *ptr << endl;

		// when we dereference a pointer by doing *ptr it points to whatever is contained in that memory location, when we just do ptr it declares the actual memory location
		// the pointer is decclared like it is done up there

		ptr = loaded + 2; //increment pointer by 2
		//cout bla bla

		*ptr = 42;
		//setting the third value of the array to 42
		//cout bla bla bla

		int size = 20;
		ptr = new int[size];
		for(int i = 0; i < size; i++)
			ptr[i]=i;
		// resize
		{
			int newSize = 30;
			int * newPtr = new int[newSize];
			for (int i=0; i < size; i++)
				newPtr[i] = ptr[i];
			for (int i=0; i < size; i++)
				newPtr[i] = 0;
			delete [] prt; // delete ptr of size 20
			size = newSize;
			ptr = newPtr;

			//print the latest prt to console
			for(int i = 0; i < size;)
				cout << "ptr[" << i << "]=" << ptr[i] << endl;
			delete [] ptr; // need to delete array when done or memory leak
			//does the memory leak checking 
			_CrtDumpMemoryLeaks();

				//huge memory leaks in here, when we say new we allocate memory and its stuck in memory until its gone

				_CrtDumpMemoryLeaks();

	


	return 0;
}