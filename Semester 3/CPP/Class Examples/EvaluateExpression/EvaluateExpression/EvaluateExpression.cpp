// Nick McRae
// Jan. 10, 2012
// Expression Evaluator. Takes in 2 numbers and + - * /
// i.e. 2 + 3
// Your program will output 2 + 3 = 5

#include <iostream>

using namespace std;

double evaluate(double lhs, char ex, double rhs)
{
	double result = 0.0;
		//we are going to do a switch statement because there are four things
		switch (ex)
	{
		case '+': result = lhs + rhs; break;
		case '-': result = lhs - rhs; break;
		case '*': result = lhs * rhs; break;
		case '/': result = lhs / rhs; break;
		default:
			cout << "Unknown operator <" << ex << ">\n";
			return -1;
	}
	
	return result;

}

//you would need to be able to code this from scratch, marks for #include, main structure, cin, and couts

int main()
{
	//prompt the user to enter an expression
	cout << "Enter a binary expression:";
	//mus tmake sure binary expression is delimited by spaces

	double lhsNum = 0.0;
	double rhsNum = 0.0;
	char binOperator = 0;

	//if (good) is pink it is a method and need brackets
	cin >> lhsNum;
	if(!cin.good() )
	{
		cout << "Bad left operand!\n";
		cout << "Numbers must be a sequence of digits";
		return -1;
	}

	// nowo read operator 
	cin >> binOperator;
	if(!cin.good() )
	{
		cout << "Bad left operand!\n";
		cout << "Numbers must be a +, /, *, -";
		return -1;
	}
	//now read in rhsNum
	cin >> rhsNum;
	if(!cin.good() )
	{
		cout << "Bad left operand!\n";
		cout << "Numbers must be a +, /, *, -";
		return -1;
	}

	double res = evaluate(lhsNum, binOperator, rhsNum);
	cout << lhsNum << binOperator << rhsNum << '=' << res << endl;
	return res;
}


