//NICK MCRAE!!!! LOL!

#include <iostream>
#include <fstream>
#include <string>
#include <vector>

using namespace std;

int main(int argc, char* argv[])
{
	if(argc != 2)
	{
		cout << "Error: Incorrect number of arguments\n"
			"Usage: allwords filename.txt\n";
		return EXIT_FAILURE;
	}

	string inputFile = argv[1];
	ifstream infile(inputFile.c_str());
	if(!infile)
	{
		cout << "Error: failed to open " << inputFile << endl;
		return EXIT_FAILURE;
	}

	vector<string> words;
	string word;

	while(infile >> word)
	{
		words.push_back(word);
	}

	for(size_t i=0; i<words.size(); ++i)
	{
		cout << i << ":" << words[i] << endl;
	}

	return 0;
}