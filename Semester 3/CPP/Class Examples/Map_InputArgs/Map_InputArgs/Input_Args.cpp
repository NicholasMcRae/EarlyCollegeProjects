// Lianne Wong 
// Feb. 16, 2012
// Map Review
#include <map>
#include <iostream>
#include <sstream>

using namespace std;

int main(int argc, char*argv[])
{
	if(argc == 1)
	{
		cout << "Need to run the program using input arguments, ie. MapInputArgs" << endl;
		return -1;
	}
	istringstream is(argv[1]);
	int iSize;

	is >> iSize;

	if(is)
		cout << "Please enter " << iSize << " numbers\n";
	else
	{
		cout << "Input not a valid int\n";
			return -1;
	}

	int j;
	map<int,int> m;

	for(int i=0; i<iSize; ++i)
	{
		cout << "Enter a number:";
		cin >> j;
		m[j]++;
		//maps only use iterators

	}

	//print out map
	for(map<int,int>::iterator it=m.begin(); it != m.end(); ++it)
	{
		cout << it->first << " : " << it->second << endl;
//		cout << (*it).first << " : " << (*it).second << endl;
	}

	return 0;
}