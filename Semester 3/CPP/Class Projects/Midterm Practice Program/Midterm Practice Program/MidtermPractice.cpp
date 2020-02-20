#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

class testClass
	{
	public:
		int practiceVariable;
		vector <int> practiceVector;

	public:
		testClass(int variableOne, vector <int> vectorOne): practiceVector(vectorOne), practiceVariable(variableOne)
		{
		}

		testClass()
		{
		}
	};


bool operator < (testClass& rhs, testClass& lhs)
	{
		return rhs.practiceVariable < lhs.practiceVariable;
	}

bool someName(testClass& rhs, testClass& lhs)
{
	return rhs.practiceVariable < lhs.practiceVariable;
}

//sort by name I want to create an operator similar to this but instead of "operator <" I write the name of the sort method
//then I would create a people vector and go: sort(people.begin(), people.end(), sortName);

int main()
{
	
	
	//ranged for: you can provide a container to a loop and the loop will iterate over it

	vector <int> x;

	for(int i = 0; i < 20; ++i)
	{
		x.push_back(i);
	}

	for (int& i : x)
	{
		i += 2;
	}	
	
	for(vector<int>::iterator j = x.begin(); j != x.end(); ++j)
	{
		cout << *j << endl;
	}

	int isSum = 0;

	for_each(x.begin() , x.end() , [&isSum] (vector<int>::value_type i) 
	{cout << i << endl;
	isSum += i;} );

	cout << isSum;

	

	return 0;
}

