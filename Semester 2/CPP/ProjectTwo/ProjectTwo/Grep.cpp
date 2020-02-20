//Nick McRae
//Feb. 24th /2012
//Program name: grep.exe
//Program purpose: To simulate the grep command

#include <iostream>
#include <fstream>
#include <vector>
#include <string>

using namespace std;

int main(int argc, char* argv[])
{
//declaring some of the necessary variables for the program
//the vector will be used to contain each line of the input file in each element, search counter will count number of times search term appears
string search = argv[1];
vector <string> containerVec;
int searchCounter = 0;

//if we don't have an input file we run the program from the console and input to cout
if(argv[2] == NULL)
{
	//declaring string, prompting for input, and capturing input with getline
	string containerString = "";
	cout << "Enter a string ending with a comma" << endl;
	getline(cin, containerString, ',');

	//nested if statement, searching inputted string for search term and returning it if it is found
	int found;
	found = containerString.find(search);
    if(found!=string::npos)
	{
       cout << containerString << endl;
	}
	else
	{
		cout << "Search query not found" << endl;
	}

	return 0;
}
else
{
//if we have all of our arguments we are going to search the input file and output to the output file
string infile = argv[2];
string outfile = argv[3];

//declaring ifstream stream, breaking up the input file into individual strings, and putting them into a vector with a newline as a delimiter
ifstream inStream;
inStream.open(infile);
int found;
	while(!inStream.eof())
	{ 
	string x;
	getline(inStream, x, '\n');
	containerVec.push_back(x);
	}

ofstream outStream;
outStream.open(outfile);

//iterating through the vector 
	for(size_t i=0; i < containerVec.size();i++)
	{ 
	found = 0;

		//performing multi-search in each line so we can get the number 
		for(found = containerVec[i].find(search, 0); found != string::npos; found = containerVec[i].find(search, found))
		{
		searchCounter++;
		found++;
		}

	//nested if that outputs the line and line numbers to the output file and also to the console
	found = containerVec[i].find(search);
	if(found!=string::npos)
	{
	outStream << "line " << i+1 << ": " << containerVec[i] << endl;
	cout << "line " << i+1 << ": " << containerVec[i] << endl;
	}
}//end else 

//
outStream << "The search term appeared: " << searchCounter << " times." << endl;
cout << "The search term appeared: " << searchCounter << " times." << endl;

inStream.close();
outStream.close();
}

	return 0;
}