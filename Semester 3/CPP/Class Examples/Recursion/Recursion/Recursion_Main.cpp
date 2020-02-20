//Nick McRae

#include <iostream>
#include <iomanip>//for fibonacci sequence

using namespace std;

typedef unsigned long long fact_type; // 64 bit unsigned
//factorial : 3! = 3*2*1
// writing my factorial recursion

fact_type factorial(fact_type n)
{
	if(n = 0)
	{
		return 1;
	}
	else
	{
		n*factorial(n-1)
	}
}