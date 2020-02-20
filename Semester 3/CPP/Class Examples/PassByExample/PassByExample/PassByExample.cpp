// Nick McRae
// Jan. 5th / 2012
//Pass by reference and pass by value
#include <iostream>

using namespace std;

void changeMe(double d)
{

	d = d - 1;

}

void changeMeAgain(double& d)
{

	d = d - 1;

}

//the ampersand, &, is a way to pass by reference, kind of means memory address


int main()
{
	cout << "Please enter a double";
	double d = 0.0;
	cin >> d;
	changeMe(d);
	cout << "The value you entered is now:" << d << endl;
	return 0;
	//this is pass by value, not changing the value of the variable
	changeMeAgain(d);
	cout << "The value you entered is now:" << d << endl;
}