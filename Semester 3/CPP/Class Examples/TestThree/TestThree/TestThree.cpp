#include <iostream>
#include <string>
#include <regex>
using namespace std;


int main()
{
	string const content = "Jump, jump, jump!";
	auto start = content.cbegin();
	auto end = content.cend();
	unsigned matches = 0;
	match_results<string::const_iterator> matchResults;
	while( regex_search( start, end, matchResults, regex("(J|j)ump") ) )
	{
		++matches;
		start = matchResults[0].second;
	}

	cout << matches << endl;

}