// Nick McRae
// Feb. 16, 2012
// Populate a vector with the input arguments

#include <iostream>
#include <sstream>
#include <vector>

using namespace std;

void printVector(vector<int> v)
	{
		for(size_t i=0; i<v.size();++i)
		{
			cout << v[i] << endl;
		}
	}

int main(int argc, char* argv[])
{
	istringstream is(argv[1]);
	//first argument is your program name, first argument is always first argument
	int iStart;
	is >> iStart;
	if(is)
		cout << "Number is good = " << iStart << endl;
	is.clear();
	is.str(argv[2]);

	int iEnd;
	is >> iEnd;
	if(is)
		cout << "Number is good = " << iEnd << endl;


	vector<int> vInt;
	//now populate the vector
	for(int ii=iStart; ii <= iEnd; ++ii)
	{
		vInt.push_back(ii);
	}

	printVector(vInt);

	

	return 0;
}