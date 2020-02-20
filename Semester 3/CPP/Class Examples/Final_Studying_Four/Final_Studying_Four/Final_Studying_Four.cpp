//Nick McRae
//# 6


#include <iostream>
#include <algorithm>
#include <vector>
#include <map>
#include <regex>
#include <fstream>
#include <array>
#include <sstream>
#include <string>
#include <set>
#include <sstream>
#include <string>
#include <ctime>
#include <io.h>

//Write a program named library.exe. Your program will store books.
//	a) you will have a book class who has attributes of(title, author(lastname, firstname, ISBN)
//	b) create a string stream with 5 books using commas to separate the attributes. Populate a vector of books using the 
//	string stream
//	c) Sort all the books by last name of the author and if authors have the same last name sort by first name
//	d) display to console all the books in your library
//	e) prompt the user to enter a book to search for(title)
//	f) reply to the user if the book is in your library

using namespace std;


class books
{
public:
	string title;
	string lastname;
	string firstname;
	int ISBN;


	books(string t, string l, string f, int i):title(t), lastname(l), firstname(f), ISBN(i) {}
};

ostream& operator << (ostream& out, books& b)
{
	out << b.lastname << " : " << b.firstname << " : " << b.title << " : " << b.ISBN << endl;

	return out;
}

bool sortbyName(books& lhs, books& rhs)
{
	return lhs.lastname < rhs.lastname;
}

int main()
{
	books book("War", "McRae", "Nicholas", 1234);

	istringstream is;
	string containerString;
	vector<books> containerVector;
	vector<string> bookTitle;
	string line = "";

	cout << "Enter a book title, author last name, author first name, and isbn number. Enter stupid to exit" << endl;

	while(getline(cin, line))
	{
		string someString;
		istringstream is(line);
		is >> book.title >> book.lastname >> book.firstname >> book.ISBN;

		if(book.title == "stupid")
		{
			break;
		}

		someString = book.title;
		bookTitle.push_back(someString);

		containerVector.push_back(books(book.title, book.lastname, book.firstname, book.ISBN));
		
		cout << "Enter a book title, author last name, author first name, and isbn number. Enter stupid to exit" << endl;
	}

	sort(containerVector.begin(), containerVector.end(), sortbyName);

	for(vector<books>::iterator it = containerVector.begin(); it != containerVector.end(); ++it)
	{
		cout << *it << endl;
	}


	return 0;
}