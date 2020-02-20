#include <iostream>
#include <vector>

using namespace std;
//find function

template <class T, class F>
bool find(vector<T> v, F f)
{
	for(size_t i=0; i < v.size(); ++i)
	{
		if(v[i] == f)
			return true;
	}

	return false;
}
int main()
{
	int rawData[] = {1,2,3,4,5,6,7,8,9,10,11}; //you can do this for an array but not a vector
	//quickly populate some vectors using the array
	vector<int> vInt(rawData, rawData+sizeof(rawData)/sizeof(rawData[0]);
	vector<double> vDouble(rawData, rawData+sizeof(rawData)/sizeof(rawData[0]);
	int iFind = 6;
	double dFind = 6.0;

	bool isFound = find(vInt, iFind);
	cout << "Is found: " << isFound << endl;

	isFound = find(vDouble, dFind);
	cout << "Is found: " << isFound << endl;

	isFound = find(vInt.begin(), vInt.end(),iFind);

	return 0;
}