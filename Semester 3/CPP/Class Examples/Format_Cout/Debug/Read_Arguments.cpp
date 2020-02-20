// Nick McRae
// Feb. 16, 2012
// Reading in arguments from the command line

#include <iostream>
#include <string>
#include <sstream>

using namespace std;

int main(int argc, char* argv[])
{
	cout << "argc = " << argc << endl;
	//display all arguments to console
	for(int i=0; i < argc; ++i)
	{
		cout << "[" << i << "]" << argv << endl;

	}

	//let's look at the args
	string first = argv[1];
	string second = argv[2];

	if(first == second)
		cout << "The first two arguments are the same\n";
	else
		cout << "The first two arguments are different\n";

	if(argc >= 4)
	{
		istringstream issNumber(argv[3]);
		int i;
		issNumber >> i;
		if(issNumber)
			cout << "Number is good = " << i << endl;
		else
			cout << "Not a number\n";
	}

	return 0;
}