//Nick McRae
//March 13, 2012
//Introduction to classes, overloaded operators, and predicate functions

#include <iostream>
#include <vector>
#include <algorithm>
#include <string>
#include <sstream>

using namespace std;

class Person
{
public:
	string sName_;
	double dHeightCM_;
	//Garth thing, _ means it belongs to a class
};

istream& operator >> (istream& in, Person& p)
{
	//eat whitespace
	in >> ws;

	getline(in, p.sName_, ',');
	in >> p.dHeightCM_;
	return in;
}

ostream& operator << (ostream& out, Person& p)
{
	out << p.sName_ << p.dHeightCM_
	return out;
}

bool operator <(Person& lhs, Person& rhs)
{
	return lhs.dHeightCM_ < rhs.dHeightCM_;
}

bool sortByName(Person& lhs, Person& rhs)
{
	return lhs.sName_ < rhs.sName_;
}

int main()
{
	//start off with this string
	//try to populate a vector<person> with this string
	string data = "John Doe, 183\n"
					"Sara Doe, 158\n"
					"Random Guy, 57\n"
					"Robert Wadlow, 272 \n";

	Person p;
	istringstream input(data);
	vector<Person> people;
	//first thing is need to define cin >> p
	//use the overloaded operator >> to know how to read 
	//a stream and put data into a person object

	while(input >> p)
	{
		people.push_back(p);		
	}
	// now sort the vector by height
//	sort(people.begin(), people.end());
	//now calling the predicate function to sort by name 
	sort(people.begin(), people.end(), sortByName)

	for(vector<Person>::iterator it=people.begin(); it != people.end(); ++it)
	{
		//using overloaded operator <<
		cout << *it;
	//	cout << it->sName_ << ", " << it->dHeightCM_ << endl;
	}

	

	return 0;
}