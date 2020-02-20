//Nick McRae
// Feb. 14, 2012
//map example

#include <string>
#include <iostream>
#include <map>

using namespace std;

int main()
{
	map<string,string> strMap;
	strMap["INFO1156"] = "Object Oriented Programming in C++";
	strMap["INFO9532"] = "Game Development Skills";
	strMap.insert(pair<string,string>("INFO3061","Object Oriented Programming in Java"));

	for(map<string,string>::iterator it=strMap.begin();
		it != strMap.end(), ++it)
	{
		cout << it->first << ":" << it->second << endl;
	}

	string name = "INFO1156";
	if(strMap.find(name) != strMap.end())
		cout << "Found " << name << " is " << strMap[Name] << endl;
	else
		cout << "Sorrt not in map: " << name << endl;

	map<int,int> iMap;
	iMap[5]=1;
	iMap[7]=1;
	++iMap[5];
	++iMap[5];
	++iMap[7];

	return 0;

}