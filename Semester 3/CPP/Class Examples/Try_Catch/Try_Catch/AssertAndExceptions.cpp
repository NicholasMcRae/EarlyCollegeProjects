#include <cassert>
#include <iostream>
#include <cmath>
#include <string>
#include <vector>

using namespace std;

class XDivideZero
{
public:
	int denominator_;
	//XDivideZero(int d){denominator_=d;}
	XDivideZero(int d):denominator_(d) {}
};

	double divideMe(int num, int den)
{
	
		assert(den != 0 && "Cannot divide by zero");

		if(den ==0)
		{
		//throw den;
		//throw static_cast<string>("Divide by zero");
			// throw XDivideZero class
			throw XDivideZero(den);
		}
	

	return num/den;
}

int main()
{
	int num=4, den = 0;
	try
	{
		divideMe(num,den);
	}
	catch(int e)
	{
		cout << "Caught exception (int): " << e << endl;
	}

	catch(string e)
	{
		cout << "Caught exception (string): " << e << endl;
	}

	catch(XDivideZero& e )
	{
		cout << "Caught exception (XDivideZero): " << e.denominator_ << endl;
	}
	


	return 0;
}