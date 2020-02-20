// Nick McRae
// Sept. 18, 2012
// Date.cpp
//This file holds the gregorian methods and operator overloads that will be boost tested in the ut_Date.cpp file

#include <iostream>
#include <string>
#include <cassert>
#include <array>
#include <ctime>
#include <time.h>
#include <string>
#include <sstream>
#include <math.h>
#include "Date.h"

using namespace std;

// Gregorian default constructor using the current year, month and day, as well as populating the time
GregorianTime::GregorianTime()
{
	time_t nowTime = time(NULL);
	struct tm tmNow;
	gmtime_s(&tmNow, &nowTime);
	y_ = tmNow.tm_year + 1900;
	m_ = tmNow.tm_mon + 1;
	d_ = tmNow.tm_mday;
	h_ = tmNow.tm_hour;
	min_ = tmNow.tm_min;
	s_ = tmNow.tm_sec;
	j_ = gregorian_to_jdn(y_,m_,d_);
}//end Gregorian constructor


//to_string function that returns a string with the current date and time
std::string to_string()
	{
		//default constructor call
		GregorianTime g = GregorianTime();

		//populating the current day of week with the dayOfWeek function
		string weekDay = dayOfWeek(g.getYear(), g.getMonth(), g.getDay());
		//using the monthNumber to populate the month name
		int monthNumber = g.getMonth();
		//initializing the monthName string
		string monthName;

		if(monthNumber == 1)
			monthName = "January";

		if(monthNumber == 2)
			monthName = "February";

		if(monthNumber == 3)
			monthName = "March";

		if(monthNumber == 4)
			monthName = "April";

		if(monthNumber == 5)
			monthName = "May";

		if(monthNumber == 6)
			monthName = "June";

		if(monthNumber == 7)
			monthName = "July";

		if(monthNumber == 8)
			monthName = "August";

		if(monthNumber == 9)
			monthName = "September";

		if(monthNumber == 10)
			monthName = "October";

		if(monthNumber == 11)
			monthName = "November";

		if(monthNumber == 12)
			monthName = "December";

		//GregorianTime g = GregorianTime();
		std::stringstream s;

		//declaring AM or PM string
		string amOrPm;
		if(g.getHour() >= 12)
		{
			amOrPm = "pm";
		}
		else
		{
			amOrPm = "am";
		}
		 
		s << weekDay << ", " << monthName << " " << 
			g.getDay() << " " << g.getYear() << ", " << g.getHour() << ":" << g.getMinute() << ":" << g.getSecond() << " " << amOrPm << std::endl;
		std::string outputString;
		getline(s,outputString);
		return outputString;
	}


//creating dayOfWeek function that uses some crazy logic to mod a double and populate the weekDay variable
std::string dayOfWeek(year_t year, month_t month, day_t day)
{
	GregorianTime g = GregorianTime(year, month, day);

	string weekDay;

	jdn_t Jdn = g.getJdn();
	double result = (int)Jdn/7;
	double j = Jdn - (int)(result * 7);
	j -= 0.5;


	//double modIntoReal = mod * numberOne;

	if (j == 1.0)
	{
		weekDay = "Wednesday";
	}
	if (j == 2.0)
	{
		weekDay = "Thursday";
	}
	if (j == 3.0)
	{
		weekDay = "Friday";
	}
	if (j == 4.0)
	{
		weekDay = "Saturday";
	}
	if (j == 5.0)
	{
		weekDay = "Sunday";
	}
	if (j == 6.0)
	{
		weekDay = "Monday";
	}
	if (j == 0.0)
	{
		weekDay = "Tuesday";
	}

	return weekDay;
};

// Convert a gregorian calendar date to a julian day number
// pass in the year, month and day
jdn_t gregorian_to_jdn(year_t year, month_t month, day_t day)
{
	assert( month <= 12 && "Max month is December=12");
	assert( month >= 1 && "Min month is January=1");
	assert( day >= 1 && "Min day is 1");
	assert( day <= 31 && "Max day is 31");
	// to do: implement the conversion from gregorian to jdn
	// use http://en.wikipedia.org/wiki/Julian_day
	long long a = (14 - month)/12;
	long long y = year + 4800 - a;
	long long m = month + 12*a - 3;
	jdn_t jdn = day + (153 * m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045 - 0.5;
	return jdn;
}//end gregorian_to_jdn

//this is a new function that adds the time to the jdn which allows us to compare gregorian date/time constructors
jdn_t gregorian_to_jdn_decimal(year_t year, month_t month, day_t day, hour_t hour, minute_t min, second_t sec)
{
	assert( month <= 12 && "Max month is December=12");
	assert( month >= 1 && "Min month is January=1");
	assert( day >= 1 && "Min day is 1");
	assert( day <= 31 && "Max day is 31");
	// to do: implement the conversion from gregorian to jdn
	// use http://en.wikipedia.org/wiki/Julian_day
	long long a = (14 - month)/12;
	long long y = year + 4800 - a;
	long long m = month + 12*a - 3;
	jdn_t jdn = day + (153 * m + 2)/5 + 365*y + y/4 - y/100 + y/400 - 32045 - 0.5;

	double decimalHour = (double) hour / 24;
	double decimalMin = (double) min / 1440;
	double decimalSec = (double) sec / 86400;
	double decimalTime = decimalHour + decimalMin + decimalSec;
	return jdn + decimalTime;
}//end gregorian_to_jdn


// function returns the days in the month,
// year is needed to account for leap year
day_t days_of_month(month_t month, year_t year)
{
	//figure out the days in the month
	static std::array<day_t,13> daysInMonth = { 0,31,28,31,30,31,30,31,31,30,31,30,31 };
	// if the month is feb and a leap year then readjust days to account for that
	day_t d = daysInMonth[month];
	return daysInMonth[month] + ((isLeapYear(year)&&(month ==2))?1:0);
}//end days_of_month


// function returns true if it is a leap year
// function returns false if the year is not a leap year
bool isLeapYear(year_t year)
{
	// algorithm determined by wikipedia
	return (year%4 == 0) && (year%100 != 0) || (year%400 == 0);
}//end isLeapYear


// function converts a jdn value and returns the gregorian year, month and day
void jdn_to_gregorian(jdn_t jdn,year_t & year, month_t& month, day_t & day)
{
	long long j = static_cast<long long>(jdn + 0.5) + 32044;
	long long g = j / 146097;
	long long dg = j % 146097;
	long long c = (dg / 36524 + 1) * 3 / 4;
	long long dc = dg - c * 36524;
	long long b = dc / 1461;
	long long db = dc % 1461;
	long long a = (db / 365 + 1) *3 / 4;
	long long da = db - a * 365;
	long long y = g * 400 + c * 100 + b * 4 + a;
	long long m = (da * 5 + 308) / 153 - 2;
	long long d = da - (m+4) * 153 / 5 + 122;
	year = y - 4800 + (m + 2) / 12;
	month = (m + 2) % 12 + 1;
	day = static_cast<day_t>(d + 1);
}//end jdn_to_gregorian



// operator overloads for comparison operators
bool operator ==(GregorianTime& lhs, GregorianTime& rhs)
{
	return lhs.getJdn() == rhs.getJdn();
	
}//end == operator

bool operator !=(GregorianTime& lhs, GregorianTime& rhs)
{
	return lhs.getJdn() != rhs.getJdn();
}

bool operator >=(GregorianTime& lhs, GregorianTime& rhs)
{
	return lhs.getJdn() >= rhs.getJdn();
}

bool operator <=(GregorianTime& lhs, GregorianTime& rhs)
{
	return lhs.getJdn() <= rhs.getJdn();
}

bool operator >(GregorianTime& lhs, GregorianTime& rhs)
{
	return lhs.getJdn() > rhs.getJdn();
}

bool operator <(GregorianTime& lhs, GregorianTime& rhs)
{
	return lhs.getJdn() < rhs.getJdn();
}





//Difference operator that creates two j_ with time variables and compares them in boost tests to make sure they are correct. The function itself 
//subtracts one date from another and also takes into account the potential th
GregorianTime operator -(GregorianTime& g1, GregorianTime& g2)
{
	year_t year;
	month_t month;
	day_t day;
	hour_t hour;
	minute_t min;
	second_t sec;
	
	year = g1.getYear() - g2.getYear();

	if((g1.getMonth() - g2.getMonth()) <= 0)
	{
	month = (g1.getMonth() - g2.getMonth() - 1) + 13;
	}
	else
	{
	month = g1.getMonth() - g2.getMonth();
	}

	int daysOfMonth = days_of_month(month, year);

	if ((g1.getDay() - g2.getDay() - 1) < 0)
	{
	day = (g1.getDay() - g2.getDay()) + daysOfMonth;
	}
	else
	{
	day = g1.getDay() - g2.getDay();
	}
		
	if((g1.getHour() - g2.getHour()) <= 0)
	{
	hour = (g1.getHour() - g2.getHour() -1) + 24;
	}
	else
	{
	hour = g1.getHour() - g2.getHour();
	}

	if((g1.getMinute() - g2.getMinute()) <= 0)
	{
	min = ((g1.getMinute() - g2.getMinute() -1) + 60);
	}
	else
	{
	min = g1.getMinute() - g2.getMinute();
	}

	if((g1.getSecond() - g2.getSecond()) <= 0)
	{
	sec = (g1.getSecond() - g2.getSecond() -1) + 60;
	}
	else
	{
	sec = (g1.getSecond() - g2.getSecond());
	}

	return GregorianTime(year, month, day, hour, min, sec);
}






//adding a packaged day to a jdn
GregorianTime operator +(GregorianTime& g, PackagedDay& d)
{
	 return GregorianTime(g.getJdn() + d.nDays_);
}




//subtraction operator for packaged day
GregorianTime operator -(GregorianTime& g, PackagedDay& d)
{
	 return GregorianTime(g.getJdn() - d.nDays_);
}




//addition operator for packagedyear
GregorianTime operator +(GregorianTime& g, PackagedYear& y)
{
	// need to determine how many days in the year
	day_t days_in_year = 0;
	year_t yNew = g.getYear() + y.nYears_;
	month_t m = g.getMonth();
	day_t d = g.getDay();
	// only day we need to worry about is Feb 29, if destination
	// is not a leap year then go to Feb 28
	if((m == GregorianTime::February && d == 29) && !isLeapYear(yNew))
		d = 28;
	return GregorianTime(yNew,m,d);//new gregorian call
	// using the jdn to determine years
}





//subtraction operator for packagedyear
GregorianTime operator -(GregorianTime& g, PackagedYear& y)
{
	// need to determine how many days in the year
	day_t days_in_year = 0;
	year_t yNew = g.getYear() - y.nYears_;
	month_t m = g.getMonth();
	day_t d = g.getDay();
	// only day we need to worry about is Feb 29, if destination
	// is not a leap year then go to Feb 28
	if((m == GregorianTime::February && d == 29) && !isLeapYear(yNew))
		d = 28;
	return GregorianTime(yNew,m,d);//new gregorian call
	// using the jdn to determine years
}





//addition operator for packagedmonth
GregorianTime operator +(GregorianTime& g, PackagedMonth& m)
{
	year_t yearsToAdd = m.nMonths_ / 12;
	month_t monthsToAdd = m.nMonths_ % 12;
	year_t y = g.getYear() + yearsToAdd;
	month_t newMonth = g.getMonth() + monthsToAdd;
	if( newMonth > 12)
	{
		y++;
		newMonth -= 12;
	}
	day_t newDay = std::min(g.getDay(), days_of_month (newMonth, y));
	return GregorianTime(y, newMonth, newDay);
}





//subtraction operator for packagedmonth
GregorianTime operator -(GregorianTime& g, PackagedMonth& m)
{
	year_t yearsToSubtract = m.nMonths_ / 12;
	month_t monthsToSubtract = m.nMonths_ % 12;
	year_t y = g.getYear() - yearsToSubtract;
	month_t newMonth = g.getMonth() - monthsToSubtract;
	if( newMonth < 0)
	{
		y--;
		newMonth += 12;
	}
	day_t newDay = std::min(g.getDay(), days_of_month (newMonth, y));
	return GregorianTime(y, newMonth, newDay);
}






//addition operator for packaged time which can take in any size number for each variable fitting within the variables data size constraints
GregorianTime operator +(GregorianTime& g, PackagedTime& t)
{
	//declaring variables that will hold the date populated by a gregorian constructor call
	double j = 0.0;
	year_t year;
	month_t month;
	day_t day;

	//figuring out how the number of seconds will effect the rest of the package and declaring time variables
	day_t d = t.nSeconds_ / 86400;
	hour_t h = (t.nSeconds_ % 86400) / 3600;
	minute_t min = ((t.nSeconds_ % 86400) % 3600) / 60;
	second_t sec = ((t.nSeconds_ % 86400) % 3600) % 60;

	//figuring out how the number of minutes will effect the rest of the package
	d += t.nMinutes_ / 1440;
	h += (t.nMinutes_ % 1440) / 60;
	min += (t.nMinutes_ % 1440) % 60;

	//figuring out how the number of hours will effect the rest of the package
	d += t.nHours_ / 24;
	h += t.nHours_ % 24;

	//adding the number of days to days
	d += t.nDays_;

	//figuring out how the number of weeks will effect the rest of the package
	d += (t.nWeeks_ * 7);

	//now we have to figure out if the mod seconds, minutes, and hours will increment their superior times at all

	//increment the minutes based on the change in time due to total seconds accumulated

	if((sec + g.getSecond()) <= 59)
	{
	sec = sec + g.getSecond();
	}
	else
	{
	int j = (sec + g.getSecond()) / 60;

	sec = ((sec % 60) + g.getSecond()) - 60;
	
		for(int i = 0; i < j; ++i)
		{
		++min;
		}

	}//end else

	//incrementing the hour based on the change in time due to total minutes accumulated
	if((min + g.getMinute()) <= 59)
	{
	min = min + g.getMinute();
	}
	else
	{
	min = ((min % 60) + g.getMinute()) - 60;

	int j = (min + g.getMinute()) / 60;

		for(int i = 0; i < j; ++i)
		{
		++h;
		}	
	}//end else

	//incrementing the day based on the change in time due to total hours accumulated
	if(((h) + g.getHour()) < 24)
	{
	h += g.getHour();
	}//end if
	else
	{
	h = ((h % 24) + g.getHour()) - 24;
	
	int j = (h + g.getHour()) / 24;

		for(int i=0; i < j; ++i)
		{
			++d;
		}//end for

	}//end else

	//adding the number of days we've found to the jdn and then returning the year month day
	j = g.getJdn2() + d;
	jdn_to_gregorian(j, year, month, day);
	
	//returning new date calculated by the jdn and the new time as calculated with our algorithm
	return GregorianTime(year, month, day, h, min, sec);
	
}//end packaged day + operator






//implementing the negative operator overload, same as positive operator but subtracts
GregorianTime operator -(GregorianTime& g, PackagedTime& t)
{
	//figuring out how the number of seconds will effect the rest of the package
	double j = 0.0;
	year_t year;
	month_t month;
	day_t day;
	day_t d = t.nSeconds_ / 86400;
	hour_t h = (t.nSeconds_ % 86400) / 3600;
	minute_t min = ((t.nSeconds_ % 86400) % 3600) / 60;
	second_t sec = ((t.nSeconds_ % 86400) % 3600) % 60;

	//figuring out how the number of minutes will effect the rest of the package
	d += t.nMinutes_ / 1440;
	h += (t.nMinutes_ % 1440) / 60;
	min += (t.nMinutes_ % 1440) % 60;

	//figuring out how the number of hours will effect the rest of the package
	d += t.nHours_ / 24;
	h += t.nHours_ % 24;

	//adding the number of days to days

	d += t.nDays_;

	//figuring out how the number of weeks will effect the rest of the package
	d += (t.nWeeks_ * 7);

	//now we have to figure out if the mod seconds, minutes, and hours will increment their superior times at all

	//increment the minutes based on the change in time due to total seconds accumulated

	if((g.getSecond() - sec) > 0)
	{
	sec = g.getSecond() - sec;
	}
	else
	{
	sec = (g.getSecond() - (sec % 60)) + 60;

	int j = (sec - g.getSecond()) / 60;

		for(int i = 0; i < j; ++i)
		{
		--min;
		}

	}//end else

	//incrementing the hour based on the change in time due to total minutes accumulated
	if((g.getMinute() - min) > 0)
	{
	min = g.getMinute() - min;
	}
	else
	{
	min = (g.getMinute() - (min % 60)) + 60;

	int j = (min - g.getMinute()) / 60;

		for(int i = 0; i < j; ++i)
		{
		--h;
		}	
	}//end else

	//incrementing the day based on the change in time due to total hours accumulated
	if((g.getHour() - h) > 0)
	{
	h = g.getHour() - h;
	}//end if
	else
	{
	h = (g.getHour() - (h%24)) + 24;
	
	int j = (h - g.getHour()) / 24;

		for(int i=0; i < j; ++i)
		{
			--d;
		}//end for

	}//end else

	//adding the number of days we've found to the jdn and then returning the year month day
	j = g.getJdn2() - d;
	jdn_to_gregorian(j, year, month, day);
	
	return GregorianTime(year, month, day, h, min, sec);
	
}//end packaged day + operator

