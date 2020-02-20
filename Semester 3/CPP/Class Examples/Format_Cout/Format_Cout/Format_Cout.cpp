//Nick McRae
// Feb. 16, 2012
// Formatting your cout, needed for Project 1 and 2
//Reference: go to thinking in C++ volume 2 chapter 4 page 186

#include <string>
#include <iostream>
#include <iomanip> //formatting the output

using namespace std;

int main()
{
	double num = 1234567.8901;
	//set the justification to left
	cout << setiosflags(ios::left);
	//to set the number of digits represented
	cout << setprecision(7) << num << endl;
	cout << setprecision(3) << num << endl;

	//set ios::fixed with the setprecision to set the amount of decimal places used 
	cout << fixed << setprecision(3) << num << endl;
	cout << setiosflags(ios:::fixed) << setprecision(4) << num << endl;
	// to output formatting use setw to set the width of your output
	const int max = 12;
	const int width = 6;
	for(int row=1; row<=max; ++row)
	{

	for(int row=1; row<=max; ++row)
	{
		cout << setw(width) << row*col;
	}
	cout << endl;

	}//end outer loop





	return 0;
}