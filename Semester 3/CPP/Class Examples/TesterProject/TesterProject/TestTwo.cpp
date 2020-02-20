// find example
#include <iostream>
#include <algorithm>
#include <vector>
#include <string>
#include <map>
#include <array>
#include <sstream>
using namespace std;

ostream& operator << (ostream& out, const pair<string , int>& rhs )
{
    out << rhs.first << ", " << rhs.second;
    return out;
}

bool sortByFiles( const pair<string, int>& i, const pair<string, int>& j )
{
    return j.second < i.second;
}

bool sortByOccurrences( const pair<int, int>& i, const pair<int, int>& j )
{
    return j.first < i.first;
}

int main () {
  
map <string, int> testMap;
map <string, int> testMapTwo;


testMap["cpp"] = 42;
testMap["hpp"] = 23;
testMap["txt"] = 30;

testMapTwo["cpp"] = 300;
testMapTwo["hpp"] = 200;
testMapTwo["txt"] = 100;

vector <pair<string, int>> testVector;

for(map<string, int>::iterator it = testMap.begin(); it != testMap.end(); ++it)
{
testVector.push_back(make_pair(it->first, it->second));
}

sort(testVector.begin(), testVector.end(), sortByFiles);

for(int i = 0; i < testVector.size(); ++i)
{
cout << testVector[i] << endl;
}

//sort(testVector.begin(),testVector.end(),sortByFiles);
//
//sort(testVector.begin(),testVector.end(),sortByOccurrences);
 	

  return 0;
}