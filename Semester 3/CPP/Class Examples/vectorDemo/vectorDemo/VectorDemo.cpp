// Lianne Wong
// Jan. 24, 2012
// Vector demo
#include <vector>
#include <iostream>
using namespace std;

int main()
{
	int a[] = {1, 2, 3, 4, 5, 6, 7, 8};
	vector<int> v(a, a+sizeof(a)/sizeof(a[0]));

	for(size_t i=0; i < v.size(); ++i)

		cout << "v[" << i << "]=" << v[i] << endl;

	return 0;
}

//use const_iterator if only reading the container