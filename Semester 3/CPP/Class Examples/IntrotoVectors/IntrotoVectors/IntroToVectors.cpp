//Nick McRae
//Jan. 19 2012
//Intro to vectors

#include <vector>
#include <iostream>
#include <algorithm>
//all the tools for vectors are stored in algorithm
using namespace std;


 void printVector(vector<int> v)
	{

	for(size_t i = 0; i < v.size(); ++i)
		cout << "v[" << i << "]=" << v[i] << endl;

	}

int main()
{

	vector<int> v;

	for(int i = 0; i < 10; i++)
		v.push_back(i);
	
	for(size_t i = 0; i < v.size(); ++i)
		cout << "v[" << i << "]=" << v[i] << endl;

	v.resize( 30 );
	printVector(v);

	v.resize(8);
	reverse(v.begin(), v.end());
	//.begin is an address that points to the very start of the vector, and end points to the end of the vector
	//the reverse needs the addresses of the beginning and the end
	printVector(v);

	

	return 0;

	//when you create a vector you need to tell it what type of data its going to hold so it knows how big to make the table
	// the < > brackets mean its a templated function or a class, and that templating makes it the typesafe, allowed to store a primitive
	//what push back means is that you should add to the back

}

