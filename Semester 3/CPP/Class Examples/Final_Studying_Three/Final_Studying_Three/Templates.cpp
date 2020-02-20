// Lianne Wong
// April 3, 2012
// Review of asserts and exceptions
#include <cassert>
#include <iostream>
#include <cmath>
#include <string>
#include <vector>
#include <fstream>
#include <map>

using namespace std;

//write a program named practice1 where you would run the program as practice1.exe
//filename. This program will take in the first argument as the input file to read
//Your program should open the file and do a character count of all the letters in the file.
//Your output should be in the following format: (the output is the symbol--number of times the
//symbol occurs in your file. At the end of your output, tell the user what the most frequent character
//found in the file was


int main(int argc, char* argv[])
{

	string fileName = argv[1];

	ifstream instream;

	instream.open(fileName);

	vector<char> testVector;
	int testCount = 0;

	while(!instream.eof())
	{
		char testChar;
		instream.get(testChar);
		testVector.push_back(testChar);
		testCount++;
	}

	map <char, int> testMap;

	for(unsigned int i=0; i < testVector.size(); ++i)
	{
		testMap[testVector[i]] += 1;
	}

	int containerVariableOne;
	int containerVariableTwo = 0;
	char containerChar;

	for (map<char, int>::iterator it=testMap.begin(); it != testMap.end(); ++it)
	{
		cout << "Char Value: " << it->first << "  Count: "<< it->second << endl;
		containerVariableOne = it->second;

		if(containerVariableOne >= containerVariableTwo)
		{
			containerVariableTwo = containerVariableOne;
			containerChar = it->first;
		}

	}

	cout << "The greatest char was: " << containerChar << " The number found was: " << containerVariableTwo;

	/*for (map<char, int>::iterator it=testMap.begin(); it == testMap.begin(); ++it)
	{
		cout << "Biggest Character was: " << it->first << "  Count: "<< it->second << endl;
	}*/

	
	
	return 0;
}