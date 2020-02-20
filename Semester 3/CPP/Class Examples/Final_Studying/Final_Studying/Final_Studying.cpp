// find example
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
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
#include <list>
using namespace std;



	class cat{

	public:
		string sName_;
		string sBreed_;
		int iAge_;
		cat(string n, string b, int a):sName_(n),sBreed_(b), iAge_(a) {}
	};

	ostream& operator << (ostream& out, cat& c)
	{
		out << c.sName_ << ":" << c.sBreed_ << ":" << c.iAge_ << endl;
		return out;
	}


	void ageThisAnimal(list<cat>& cats, string name, int i)
	{
		for(list<cat>::iterator it = cats.begin(); it != cats.end(); ++it)
		{
			if(it->sName_ == name)
			{
				//age the cat by three years old
				(*it).iAge_ += i;
			}
		}
	}


	void printList(list<cat>& cats)
	{
		for(list<cat>::iterator it = cats.begin(); it != cats.end(); ++it)
		{
			cout << *it;
		}
	}


	bool operator < (cat const& lhs, cat const& rhs)
	{
		return lhs.sName_ < rhs.sName_;
	}


int main(int argc, char* argv[])
{

	string sline;
	cat c("Garfield", "Orange", 9);
	list<cat> cats;
	cout << "Enter name breed age(type exit) to exit" << endl;

	while(getline(cin, sline))
	{
		istringstream is(sline);
		is >> c.sName_ >> c.sBreed_ >> c.iAge_;
		if(c.sName_ == "exit")
		{
			break;
		}
		cats.push_back(cat(c.sName_,c.sBreed_,c.iAge_));
		cout << "Enter name breed age (type exit) to exit";
	}

	printList(cats);

	return 0;
}