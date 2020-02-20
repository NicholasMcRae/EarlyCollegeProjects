// Nick McRae
// Jan. 24th, 2012
// Learning more vector algorithms

#include <algorithm>
#include <vector>
#include <iostream>

using namespace std;

void printVector( vector<int> v);
void printVectorIt( vector<int> v);

int main()
{
	vector<int> vec;

	for(int i = 3; i <= 15; i += 3)
	{
		vec.push_back(i);

	}

	printVector(vec);
	

	//reverse(vec.begin(), vec.end());
	//reverse the first two items in the vector
	reverse(vec.begin(),vec.begin()+2);

	printVector(vec);

	//sort algorithm

	sort(vec.begin(), vec.end());
	printVectorIt(vec);

	//find algorithm arg = starting point, 2nd = ending point, 3rd = value to find
	// find algorithm returns an iterator to the item found otherwise if not found will point to the end of container
	vector<int>::iterator it = find(vec.begin(),vec.end(), 17);

	if(it == vec.end())
	{
		cout << "Could not find 17\n";
	}
	else
	{
		cout << "Found " << *it << " at offset " << (it-vec.begin() ) << endl;
	}

	//visual studio came out with auto data type, knows that it will be a vector int, iterator
	auto it1 = find(vec.begin(),vec.end(), 17);

	if(it1 == vec.end())
	{
		cout << "Could not find 17\n";
	}
	else
	{
		cout << "Found " << *it1 << " at offset " << (it1-vec.begin() ) << endl;
	}

	return 0;
}

//need to use a different variable name

void printVector( vector<int> v)
{
	for(size_t i=0; i < v.size(); ++i)
	{
		cout << "v[" << i << "]=" << v[i] << endl;
	}

}


void printVectorIt( vector<int> v)
{

	//using an interator to go through the array using memory addresses?
	for(vector<int>::iterator it=v.begin(); it != v.end(); ++it)
	{
		cout << "v[]=" << *it << endl;
	}

}

// Function name: countBigNum
// Arguments: vector<int>
// Return: int (total number of elements > 10)
// Purpose: This function will count how many elements are greater then 10 and return the count
int countBigNum(vector<int> v)
{

	int iCount = 0;

	for(size_t i=0; i<v.size(); ++i)
	{
		if(v[i] > 10)
		{
			iCount++;
		}

		return iCount;
	}

}

int countBigNumTwo(vector<int> v)
{
	int iCount=0;

	for (vector<int>::iterator it=v.begin(); it != v.end(); ++it)
	{
		if(*it > 10)
			iCount++;
	}

	return iCount;
}

// replace all elements in vector > 10 with value of 100, must pass by reference


void modifyVec(vector<int>& v)
{
	for (vector<int>::iterator it=v.begin(); it != v.end(); ++it)
	{
		if(*it > 10)
			*it = 100;
	}
	//splat is the * thing

}

//lists have no random access so you can't user an iterator

