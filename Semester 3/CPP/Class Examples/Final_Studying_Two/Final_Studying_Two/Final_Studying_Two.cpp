//Final Studying Two

#include <list>
#include <vector>
#include <map>
#include <sstream>
#include <iostream>

using namespace std;

//in this program I am going to populate a vector with people and determine whether or not they are Nick Hiebert. I am then going to sort them by name and print out the results
//I will need: predicate function to sort, cout function. . will start there


class NickHiebert
{
public:
	int iAge_;
	string sName_;
	string isNickHiebert;
	bool bIsNickHiebert;

	NickHiebert(string n, int a, string s): sName_(n), iAge_(a), isNickHiebert(s) {}

};

ostream& operator << (ostream& out, NickHiebert& NH)
{
	out << NH.sName_ << " : " << NH.iAge_ << " : " << NH.isNickHiebert << endl;
	return out;
}

int main()
{

	string line;
	vector<NickHiebert> storageVector;
	NickHiebert NH("NickHiebert", 19, "");
	cout << "Enter a name, and age. Enter troll to exit." << endl;
	string isNickHiebert = "";

	while(getline(cin, line))
	{
	istringstream is(line);
	is >> NH.sName_ >> NH.iAge_;
	NH.bIsNickHiebert = false;

	if(NH.sName_ == "troll")
	{
		break;
	}

	if(NH.sName_ == "NickHiebert" && NH.iAge_ == 23)
	{
		NH.bIsNickHiebert = true;
	}

	if(NH.bIsNickHiebert == true)
	{
		NH.isNickHiebert = "This is Nick Hiebert";
	}
	else
	{
		NH.isNickHiebert = "This is not Nick Hiebert";
	}

	storageVector.push_back(NickHiebert(NH.sName_, NH.iAge_, NH.isNickHiebert));
	cout << "Enter a name, and age. Enter troll to exit." << endl;
	}

	for(vector<NickHiebert>::iterator it=storageVector.begin(); it != storageVector.end(); ++it)
	{
		cout << *it << endl;
	}


	return 0;
}