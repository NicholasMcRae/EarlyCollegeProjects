//Nick McRae
//Jan. 5th / 2011

//factorial with recursion
long calcFactorial(long n)
{
	if(n == 0)
	{
		return 1;
	}
	else
	{
		return n*calcFactorial(N-1);
	}
}

// factorial without recursion
long calcFactorialNew(long N)
{
	long f = 1;
	for(unsigned i = N; i > 1; i--)
	{
		f = f*i;
	}
	return f;
}
