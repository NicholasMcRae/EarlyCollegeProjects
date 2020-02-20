// Nick McRae
// Jan. 10, 2012
// String demo, learn string streams

#include <iostream>
#include <string>
#include <sstream>
// special string characters
/* \n - control line feed
   \t - tab
   \\ - \
   \' - '
   you can use these characters to put these quotes into a string without reading the end of the string
   */

using namespace std;

int main()
{
	// print a string literal 
	cout << "Hello, string literal\n";

	// print a string c-array style (avoid)
	char sz[] = "Hello, old c-string:";
	cout << sz << endl;
	// cant change the size of the string, don't use

	// print a string c-pointer style (avoid)
	char* p = "Hello, old pointer to string";
	//even worse, don't use
	cout << p << endl;

	// strings, declare and print a C++ string object
	string s = "Hello C++ safe dynamic string object";
	cout << s << endl;
	// this string is dynamic

	// read a word from the keyboard into a string 
	cout << "Enter a string containing leading spaces and internal spaces";
	//cin >> s;
	//cout << "You entered: " << s << endl;
	// when we read in the console it reads spaces as delimiters, this method will only read the first word in ^^^^^^

	//this method will read the whole line in and doesn't store the newline
	// default to getling reads till a \n
	//getline(cin, s);
	//cout << "You entered: " << s << endl;

	// getline also reads in delimited text
	// what this does is it keeps everything that you typed in until the carriage return, and puts them exactly as typed into a string, which kind of stream are we using
	// is "cin" stream, use the getline command on cin, and read it into the variable s

	//can use a third parameter as the delimiter character
	getline(cin, s, ',');
	cout << "You entered(up to ,): " << s << endl;
	//can repeat this and it will cout after each delimiter


	// can use size() or length(), we prefer size()
	cout << "Length: " << s.length() << endl;

	// string concatenation
	s = "Hello";
	s = s + " ";
	s += "world";
	s += '\n'; 
	cout << s << endl;

	// there is an empty command
	if (s.empty())
		cout << "String s is empty" << endl;
	else
		cout << "String s contains characters" << endl;

	// can access strings by elements
	//signed and unsigned int, a for loop is only positive, unsigned is only positive
	for(unsigned int i = 0; i < s.size(); ++i)
		cout << s [i] << ',';

	//Custom constructor
	string line(42, '*');
	cout << line << endl;
	cout << string(42, '+') << endl;

	// read numbers from strings
	// string streams (our first lecture in string streams), if she ever had a number that was encased in quotes (back in the day) she would have to use a non-safe way
	//to convert things, however we came out with the string stream (last five years of C++), and what it does is act like your console, you can treat them like a cin and cout
	//in that way you can get a string stream, if you ever get a string and need to convert it to a number # include sstream
	string numberStr = "1234.56 234 *";
	double d;
	int i;
	char ch;
	istringstream iss(numberStr);
	iss >> d >> i >> ch;
	cout << d << " " << i << " " << ch << endl;
	//this is what youre going to be using to convert string to integers and doubles and stuff
	//remember that the spaces are delimiters
	return 0;
	//this constructor gives you 42 of whatever character you want in a line

	//opposite version, pushing the variables back into a string 
	ostringstream oss;
	oss << d << i << ch;
	cout << oss.str() << endl;

	// strings have relational operators
	if (s < numberStr)
		cout << "s comes first" << endl;
	s = "Hello";
	if (s == "Hello")
		cout << "It's a match << endl;
	if(s < "Hello")
		cout << s << " comes before \"Hello\"" << endl; //the slash allows you to put quotes in there as a literal character

	// searching strings
	s = "abc abc abd abc";
	cout << "Find \"abc\": " << s.find("abc") << endl;
	cout << "Find \"abc\": " << s.find("abc") << endl;
	// when you print this out, abc it returns 0 for the first character being a

	//when we do double colons it means we are using the string library, when you do searches on string, if string returns a no position it means you haven't found it
	if (s.find("abe") == string::npos)
		cout << "Substring not found" < endl;
	
	cout << "Find  \"abc\", 1: " <<s.find("abc",1) << endl;
	// using the 1 in here is going to skip the first abc and find the second abc, you want to increment it so it will find the next one, by remembering the position of the find and find the next one
	//intellisense when we use s. (the dot brings up a menu), if we were to choose say. . find. . intellisense would come up and give us four options 
	//s.find_first_of("cde",0)
	//s.rfind("abc") reverse find 
	// the reverse find gives you the beginning location of the first part found in the string 

	// sub-string
	cout << s.substr(8,3) << endl;
	// pushing a portion of the string out to the console 

	// replace substrings
	s.replace(0,3, "xyz ");
	cout << "s=" << s >> endl;

	//you can also replace that with a longer word, or in other words replace xyz with hello, or something like that





	return 0;
}