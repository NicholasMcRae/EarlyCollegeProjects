//Jan 12, 2012
//into to pointers

#include <iostream>
using namespace std; 
int main()
{
	int a = 50;
	cout << "The value of a is " << a << endl;
	cout << "The address of a is " << &a << endl;


	int *b;
	//b is a pointer to an int, it's a memory address, so how would b relate to a
	b = &a;

	//if we want b to point to a, b which is a memory address is an address of a, we use the ampersand. 

	*b = 100;
	// this says the contents of b is now set to 100, we are changing a to 100 from 50

	cout << "The value of using b is " << a << endl;

	int **c; // declare an integer pointer to a pointer
	// you're actually going to use this a heck of a lot
	c = &b;
	**c = 200;
	cout << "The value of a using **c is " << a << endl;
	cout << "The content of b is the address of a " <<  *c << endl;
	cout << "The address of b is c is " << c << endl;
	return 0;

	return 0;

}