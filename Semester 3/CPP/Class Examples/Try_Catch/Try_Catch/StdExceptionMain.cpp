//Nick McRae
// April 3, 2012
//Introduction to exceptions

#include <iostream>
#include <exception>

using namespace std;
// This is the class that I will throw and catch in the try catch(CTest e)

class CTest
{
public:
	CTest() {};
	~CTest() {};
	const char *ShowReason() const
	{
		return "Exception in CTest class.";
	}

};
//constructor and destructor demo to see where construction and destruction happens
class CDtorDemo
{
public:
	CDtorDemo();
	~CDtorDemo();

};

CDtorDemo::CDtorDemo()
{
	cout << "Constructing CDtorDemo.\n";
}
CDtorDemo::~CDtorDemo()
{
	cout << "descruting CDtorDemo.\n";
}


//this function throws the exception, demoing throwing an int, string, CTest
void MyFunc()
{
	int i=10;
	cout << "In MyFunc(). Throwing exceptions here.\n";
	//throw i;
	//throw "string exception";
	throw CTest();
}

int main()
{
	CDtorDemo d;
	try
	{
	int * myArray = new int[1000];
	}
	catch(exception& e)
	{
		cout << "Standard exception: " << e.what() << endl;
	}
	
	catch( ... )//catch all, if it's not any of the previous exceptions do this
	{
		cout << "Unknown exception thrown: ";
	}

	try
	{
	MyFunc();
	}
	catch(int e)
	{
		cout << "Caught exception(int): " << e << endl;
	}
	catch (CTest e)
	{
		cout << "Caught CTest exception(CTest): " << e.ShowReason() << endl;
	}

	return 0;
}