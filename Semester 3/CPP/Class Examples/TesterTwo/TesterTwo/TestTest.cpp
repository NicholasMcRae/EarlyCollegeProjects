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
using namespace std;



	class cat{

	public:
		string sName_;
		string sBreed_;
		int iAge_;
		Dog(string n, string b, int a):sName_(n),sBreed_(b), iAge_(a) {}
	};

	ostream& operator << (ostream& out, Cat& c)
	{
		out << c.sName_ << ":" << c.sBreed_ << ":" << c.iAge_ << endl;
		return out;
	}
	void ageThisAnimal(list<cat>& cats, string name, int i)
	{
		for(list<Cat>::iterator it = cats.begin(); it != cats.end(); ++it)
		{
			if(it->name == name)
			{
				//age the cat by three years old
				(*it).iAGe_ += i;
			}
		}
	}


	void printList(list<Cat>& cats)
	{
		for(list<Cat>::iterator it = cats.begin(); it != cats.end(); ++it)
		{
			cout << *it;
		}
	}

	bool operator < (Cat const& lhs, Cat const& rhs)
	{
		return lhs.sName_ < rhs.sName_;
	}


int main(int argc, char* argv[])
{

	string sline;

	while(getline(cin, sline))
	{
		istringstream is(sline);
		is >> name >> breed >> age;
		if(name == "exit")
			break;
		cats.push_back(Cat(name,breed,age));
		cout << "Enter name breed age (type exit) to exit)
	}

	return 0;
}
