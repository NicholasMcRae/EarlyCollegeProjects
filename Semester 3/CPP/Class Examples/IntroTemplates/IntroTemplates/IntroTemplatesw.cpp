//Nick McRae
//Introduction to templates

#include <iostream>
#include <string>

using namespace std;

//you may use typename or class
template <typename T>
//the idea behind templates is that the function will work with any data type
//have to redeclare template before every function in order for it to work

void swapInts(T& i, T& j)
	{
		T temp = i;
		i = j
		j = temp
	}

int main()
{

	int i=3, j=5;
	swapInts(i,j);
	cout << "i=" << i << "j=" << j << endl;


	return 0;
}