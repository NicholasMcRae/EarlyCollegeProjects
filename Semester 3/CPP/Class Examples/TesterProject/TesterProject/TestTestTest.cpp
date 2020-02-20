// find example
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <array>
#include <sstream>
using namespace std;

int main () {
  

vector <int> testVector;
int i = 0;

cout << "Please enter 10 integers";

for(unsigned i = 0; i < testVector.size(); ++i)
{
	cin >> i;
	testVector.push_back(i);
}

for(unsigned i=0; i < testVector.size(); ++i)
{
	cout << testVector[i] << endl;
}

	

	
  	

  return 0;
}


