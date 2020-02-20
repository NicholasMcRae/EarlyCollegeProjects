#include <iostream>
#include <string>
#include <fstream>
#
using namespace std;

int main()
{
	// showing reading in file with a while(!cin.eof())
	/*
	while(!cin.eof())
	{
		char ch;
					// first attempt
	//	cin >> ch; //skips leading white-space, tab and return
		cin.get(ch); //works but the !cin.eof() runs past so get two of the last characters
		cout << ch;
	}*/
	//since above doesn't work quite well trying getline
	
	/*
	string s;
	while(getline(cin, s, "\n"))
	{
		cout << s << endl;
	}
	*/

	//now writing a generic streaming demo
	ifstream in("Stream_demo.cpp");
	/*
	if(!in)
	{
		cout << "Could not open input file" << endl;
	}

	ofstream out("out.txt");
	if(!out)
	{
		cout << "Could not open the output file" << endl;
		return -1;
	}
	*/
	istringstream in("This is a test to see if it works");

	char ch;
	while(in.get(ch)/*.good()*/)
	{
		cout.put(ch);
	}

	return 0;
}