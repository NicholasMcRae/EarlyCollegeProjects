// Nick McRae
// Jan. 26th 2012
//Vector with other datatypes and more vector algoorithms
#include <vector>
#include <iostream>
#include <algorithm>
#include <string>
#include <ctime> //for seedig the random number
#include <numeric> //for accumulate

using namespace std;

void printVector(vector<double> v);
void printVector(vector<char> v);

int main()
{
	srand(unsigned(time(NULL))); //seeding the random number to the current time

	vector <double> vecD;

	for(size_t i=0; i<11; ++i)
		vecD.push_back(i*1.1);

	printVector (vecD);

	vecD.at(3) = 42.2;
	vecD[3] = 42;
	//at takes a little longer


	//vector of chars
	string s("INFO1156 is a great class!");
	vector <char> v(s.begin(),s.end());
	printVector(v);

	vector<int> vInt(10);
	printVector(vInt);

	fill(vInt.begin(), v.begin()+5,5); //fill from begin, to the fifth position, with 5
	printVector(vInt);

	//generate function which uses the predicate function randomNumber to populate the vector

vector<int> vRand(8);
vector<int?::iterator it;
//randomNumber is the address of the function that tells the generate algorithm how to generate numbers to fill the vector. 
// Note: use function name without the () so it is the
//address of the function. 
generate(vRand.begin(), vRand.end(), randomNumber);
printVector(vRand);

vector<string> vStr;
vStr.push_back("The");
vStr.push_back("quick");
vStr.push_back("brown");
vStr.push_back("fox");
vStr.push_back("jumps");
vStr.push_back("over");
vStr.push_back("The");
vStr.push_back("lazy");
vStr.push_back("dog");

printReverseVector(vStr);

//test the sumVector function

cout << "Sum of vecD = " << sumVector(vecD) << endl;
double dSum = 0;
dSum = accumulate(vecD.begin(), vecD.end(), 0);//third thing tells you the initial starting value of the accumulation
cout << "Sum of vecD using accumulate = " << dSum << endl;


	return 0;
}

void printVector(vector<double> v)
{
	for(size_t i=0; i<v.size(); ++i)
	{
		cout << v[i] << "\t";
	}
	cout << endl;
}

void printVector(vector<char> v)
{
	for(size_t i=0; i<v.size(); ++i)
	{
		cout << v[i] << "\t";
	}
	cout << endl;
}

//function to generate random numbers between 0-99
//every time we call the random number function
int randomNumber() { return rand()%100; }


//using reverse_iterator from rbegin() to rend()
void printReverseVector (vector<string> v)
{
	for(vector<string>::reverse_iterator it=v.rbeing();it!=v.rend(); ++it)
	{
		cout << *it << " ";
	}
}

double sumVector(vector<double> v)
{
	double total = 0;
	//need to set this to zero or we would lose a half mark

	for(vector<double>::iterator it = v.begin(); it!= v.end(); ++it)
	{
		total += *it;
	}
}



