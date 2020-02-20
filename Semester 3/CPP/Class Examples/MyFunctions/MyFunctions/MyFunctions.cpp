// Nick McRae
// Jan. 5th, 2012
// Introductions to functions in C++

#include <iostream>
#include <cmath>
#include <iomanip>
#include <valarray>

using namespace std;
//if namespace is blue it is probably correct, if it is black it is probably incorrect
//std means standard library, contains cin cout and line and string and stuff
// function prototype
// this will allow the compiler to accept the function doubleReturn because it actually gets to the function
int doubleReturn(int);
//this is a function prototype
//two options when you write function, to define them in order or to define a prototype
//when you have a lot of functions and classes work together you need to use function prototyping

double nm_sqrt(double N)
{
//newton's method, by ten times of doing this method we are going to get a good method for this square root, which can be done easily with a loop structure

	double R = 10.0;

	//writing a for loop, exactly the same as java

	for(int i = 0; i < 10; i++)
	{
	
		R = R - (R*R - N) / (2*R);
	}

	return R;

	

}
// showing pass by value


int main()
{
	//if you're going to tell the person to write an integer value you are going to use the cout, the chevrons always point to the cout

	cout << "Please enter an integer:";

	//now we want to declare an integer variable
	int i = 0;
	//in C++ you have to initialize every variable

	cin >> i;
	
	// call the function doubleMe
	int iNew = doubleReturn(i);
	cout << "Your integer doubled is:" << iNew << endl; //remember the end line

	//she is showing us something that is specific to C++, C++ is a top down compiler, in compile time when she is going through compile it is going to start at the top and
	//compile downwards. This means that when it gets to the constructor of iNew we don't know what the doubleMe function is

	cout << "Standard Library square root = " << sqrt((double)i) << endl;
	//look up static casting
	cout << "The square root of R is" << nm_sqrt((double)i) << endl;

	return 0;
}

int doubleReturn(int a)
{

return a * 2;
}
