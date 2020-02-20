// Nick McRae
// Jan. 31, 2012
// Vectors and Lists

//two types of list, double ended list and single ended list. . first list has data and address of the next list
//limited to go to top to bottom if you have to traverse
#include <vector>
#include <iostream>
#include <string>
#include <list>
#include <set>
#include <algorithm>
using namespace std;


int main()
{
	vector<string> vecS;
	vecS.push_back("This");
	vecS.push_back("INFO1156");
	vecS.push_back("class");
	vecS.push_back("is");
	vecS.push_back("fun");
	
	for(size_t i = 0; i < vecS.size(); ++i)
	{
		cout << vecS[i] << " ";
	}

	cout << endl;

	list <string> listS;
	vector<string>::iterator it = max_element(vecS.begin(),vecS.end());

	cout << "Biggest string value is:" << *it << endl;

	listS.push_back("This");
	listS.push_back("INFO1156");
	listS.push_back("class");
	listS.push_back("is");
	listS.push_back("fun");
	
	for(list<string>::iterator it = listS.begin(); it != listS.end(); ++it)
	{
		cout << *it << " ";
	}

	cout << endl;

	// the only way to get items out of a list is to use an iterator, because there is not random access

	string s = "This INFO1156 class is fun";
	
	set <char> setC;

	for(vector<string>::iterator it=vecS.begin(); it != vecS.end(); ++it)
	{
		s = *it;
		
		for (unsigned int i = 0; i < s.size(); ++i)
		{
			setC.insert(s[i]);
		}
	}

	for(set<char>::iterator it=setC.begin(); it!= setC.end(); ++it)
	{
		cout << *it;
	}

	cout << endl;


	for(set<char>::iterator it=setC.begin(); it!= setC.end(); ++it)
	{
		if (*it == 'c')
		{
			cout << "Good" << endl;
		}

	}

	if(s.find("c") != string::npos)
		cout << "Letter c found" << endl;


	// using find algorithm to find contents of a set
	// if she teaches us an algorithm for one container it should be the same for all containers
	set<char>::iterator it2 = find(setC.begin(), setC.end(), 'c');

	if(it2 == setC.end())
		cout << "No letter c found";
	else 
	{
		cout << "Letter c found\n";
	}

	
	return 0;
}