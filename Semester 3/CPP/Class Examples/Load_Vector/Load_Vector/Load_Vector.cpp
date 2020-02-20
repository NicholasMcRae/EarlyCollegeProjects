//project stuff, 
//Nick McRae
//Feb. 3, 2012
//program will load a text file into your cpp file and load a vector with the contents of the file

//to run use load_vector.exe < test.txt to load vector with test.txt, or run using load_vector.exe and type in numbers to load vector. End with ctrl-z

#include <vector>
#include <iostream>

using namespace std;

int main()
{
	vector<int> v;
	int i;

	while(cin >> i)
	{
		v.push_back(i);
	}
	//print out vector to console
	//look up equations on standard deviation and stuff on wikipedia

	for(size_t n=0; n<v.size();++n)
	{
		cout << v[n] << endl;
	}


	return 0;
}