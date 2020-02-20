//Nick McRae
# include <iostream>
#include <string>
using namespace std;
int main()
{
	int integer = 0;
	string aString = "";
	
	cout << "Please enter an integer value and then a string";

	cin >> integer;

	if(cin.good())
		cout << "Entered the value correctly" << endl;
	else
	{
		"Did not enter a number"
			cin.clear(); //clear the failure from cin
		cin.sync(); // sync buffer with the controlled input sequence, discards anything in the buffer 
		//i.e. unread characters, sync is when you've typed 
	}

	cout << "Please enter a string";

	cin >> aString;
	if(cin.good())
		cout << "Entered string " << endl;
	else
		cout << "Did not enter a string\n";
	

}