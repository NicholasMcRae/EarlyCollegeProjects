//Lianne Wong
//Jan 19, 2012
//Introduction to regex
# include <iostream>
#include <string>
#include <regex>
using namespace std;

int main()
{

	regex reg("Hello, world!");
	//its a class that contains strings, the power of this class is. . . 
	if (regex_match("Hello, world!", reg))
		cout << "Found a match!" << endl;

	regex reg_or("gray|grey");
	//or function, create an object where the value of the regex object is the english or the american spelling

	if(regex_match("gray",reg_or))
		cout << "Found a match for gray\n";
	if(regex_match("grey",reg_or))
		cout << "Found a match for grey";
	//learning the difference between one dash or two dashes for an or, only one is a bitwise or, the other is a logical or. Bitwise, one just checks the first case, the other
	//checks both

	regex reg_por("gr(a|e)y");
	if(regex_match("gray",reg_por))
		cout << "Found a match for gray\n";
	if(regex_match("grey",reg_por))
		cout << "Found a match for grey\n";

	//the second letter can be an a or an e and it will work

	regex reg_question("colou?r");
	if(regex_match("colour",req_question))
		cout << "Found a match for colour\n";
	if( ! regex_match("coloUr", reg_question))
		cout << "Didn't find a match for coloUr\n";
	if(regex_match("color",reg_question))
		cout << "Found a match for color\n";

	//the question mark means you can leave out the u, but if you want it to be several you can bracket it 

	regex reg_splat("ab*c");
	if(regex_match("abc",req_splat))
		cout << "Found a match for abc\n";
	if( ! regex_match("ac", reg_splat))
		cout << "Did find a match for abc\n";
	if(regex_match("abbbbbc",reg_splat))
		cout << "Found a match for abc\n";

	//* means that you need 0 to many of the preceding letter
	//could use this stuff to evaluate stuff for our homework assignment

	regex reg_plus("ab+c");
	if(regex_match("abc",req_plus))
		cout << "Found a match for abc\n";
	if( ! regex_match("ac", reg_plus))
		cout << "Did find a match for abc\n";
	if(regex_match("abbbbbc",reg_plus))
		cout << "Found a match for abc\n";

	//plus operator, same as splat but needs at least 1 of the letters, doesn't find ac

	//icase
	regex color_expression("(colo)(u)(r)",regex::icase);
	string colors = "Colour, colours, color, colorize, colounizer";
	cout << "Original colors:" << colors << endl;

	colors = regex_replace(colors, color_expression,string("$1$3"));
	cout << "Replaced colors:" << colors << endl;
	//icase means case insensitive, and regex_replace
	//what the brackets (three brackets) mean, 
	//where it finds the first bracket and the last bracket, it will put the middle bracket in between, I guess 

	//(useful for other homework assignments)
	string filename;
	regex extensions("\\.(cpp|c|hpp)$"); //check the dot there. . if it sees a .cpp it is a c++ file etc. $ is the end of the string
	filename = "one.cpp";
	if(regex_search(filename, extensions))
		cout << filename << "is a c++ file\n";
	else
		cout << filename << " is not a c++ file\n";



	return 0;
}