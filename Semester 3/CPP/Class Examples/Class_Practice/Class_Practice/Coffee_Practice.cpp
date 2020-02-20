#include <iostream>
#include <vector>
#include <map>
#include <string>
#include <algorithm>

using namespace std;
//reviewing classes, operator overloading, and predicate functions


class Coffee
{
public:
	double dPrice_;
	int iSize_;
	string sBlend_;
	
	
}

int main()
{
	Coffee potHouse;
	//create a pot of house blend coffee starting at 64oz
	potHouse.iSize_ = 64;
	potHouse.sBlend_ = "HouseBlend";
	potHouse.dPrice_ = 4.00;

	map <string, int> mSize;

	msize.insert(pair<string,int>("small",8));
	mSize["medium"] = 12;
	mSize["large"] = 16;


	
	int iMilk_;
	int iSugar_;
	// simulate pouring a small cup of coffee
	int iAmtLeft = potHouse - 8;
	if(iAmtLeft == -1)
		cout << "No coffee served, not enough left"
		//now use the map so that small could be evaluated 

		//Now creating two more pots, "Pike Place" and "Blonde"
		Coffee pikePlace;
	pikePlace.sBlend_ = "Pike Place";
	pikePlace.iSize_ = 64;
	pikePlace.dPrice_ = 3.90;
	Coffee blonde;
	blonde.iSize_ = 64;
	blonde.sBlend_ = "Blonde";
	blonde.dPrice_ = 4.10;


	int bAmtLeft = blonde - 12;
	// put all the cups of coffee onto a vector
	vector <Coffee> pots;
	pots.push_back(potHouse);
	pots.push_back(pikePlace);
	pots.push_back(blonde);

	//if we named the predicate function we could use it as the third parameter, however since we don't name a function it uses the less than as a default
	sort(pots.begin(), pots.end())

		for(size_t i = 0; i < pots.size(); ++i)
		{
			cout << pots[i];
		}


	return 0
}

int operator - (Coffee& c, int i)
{
	//takes off ioz from the pot size
	if(fi.isize_ >= i)
	{
	c.iSize_ -= i;
	return c.iSize_; //returns the 
	}
	else
	{
		cout << "Not enough coffee left in the pot";
		return -1
	}

bool operator < (Coffee& lhs, Coffee& rhs)
{
	return lhs.iSize_ < rhs.iSize_;
}

ostream& operator <<(ostream& out, Coffee& c)
{
	out << "blend: " << c.sBlend_ << " Size: " << c.iSize_ << c.dPrice_ << endl;
	return out;
}