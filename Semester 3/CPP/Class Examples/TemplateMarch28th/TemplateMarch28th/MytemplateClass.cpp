using namespace std;

#include <iostream>;
#include <array>;

class MyPair

{
	T values [2];
public:
	MyPair(T first, T second)
	{
		values[0] = first;
		values[1] = second;
	}

	void printArray()
{
	for(int i=0; i < values.size(); i++)
	{
		cout << v[i] << endl;
	}
}
};



int main()
{
	MyPair myObject(115,36);
	myObject.printArray();
	return 0;
}

