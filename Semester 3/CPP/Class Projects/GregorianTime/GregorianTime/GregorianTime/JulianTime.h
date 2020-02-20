// Nicholas McRae
// Sept. 29, 2012
// Date header file
// This file includes the Date class and all the helper functions needed
#ifndef __JulianTime_H__
#define __JulianTime_H__

#include <string>
typedef double jdn_t;
typedef long long year_t;
typedef int month_t;
typedef int week_t;
typedef long day_t;
typedef long hour_t;
typedef long minute_t;
typedef long second_t;
typedef double jdnd_t;
//consider changing the data type of the hour, minute, second variables

// base conversion functions
jdn_t Julian_to_jdn_decimal(year_t y_,month_t m_,day_t d_,hour_t h_,minute_t min_,second_t s_);
jdn_t Julian_to_jdn(year_t year, month_t month, day_t day);
void jdn_to_Julian(jdn_t jdn, year_t & year, month_t& month, day_t & day);
//string dayOfWeek(JulianTime g);
//potentially adding a function to handle fractions of a second
//jd_t jdn_to_jd(jdn_

// helper functions
day_t days_of_month_julian(month_t month, year_t year);
bool isLeapYearJulian(year_t year);

	
	class JulianTime
	{
	private:
		year_t y_;
		month_t m_;
		week_t w_;
		day_t d_;
		hour_t h_;
		minute_t min_;
		second_t s_;
		jdn_t j_;
		jdnd_t jd_;
		//jd_t jd_;
		//fraction_t f_;
	public:
		JulianTime();  // initialize to current date and time, done in Date.cpp
			
		// this constructor takes in a jdn and calls the jdn_to_Julian function which populates and returns the date using the jdn. It doesn't appear this constructor has been used yet
		JulianTime(jdn_t j)
		{
			j_ = j;
			jdn_to_Julian(j,y_,m_,d_);
		}

		//this constructor takes in the year, month, and day and populates the class variables and uses a function to populate the jdn_
		JulianTime(year_t y, month_t m, day_t d) :y_(y), m_(m), d_(d) 
		{
			j_ =Julian_to_jdn(y_,m_,d_);
		}

		enum month_type{January=1,February,March,April,May,June,July,August,September,October
			,November,December};

		
		JulianTime(year_t y, month_t m, day_t d, hour_t h, minute_t min, second_t s) :y_(y), m_(m), d_(d), h_(h), min_(min), s_(s)
		{
			//this call is necessary to use the equality operator while implementing time into the equation
			j_ = Julian_to_jdn_decimal(y_,m_,d_,h_,min_,s_);

			//this call is necessary to use in the chosen algorithm for adding a time struct
			jd_ = Julian_to_jdn(y_,m_,d_);
		}

		// getter functions for private variables
		month_t getMonth()	{ return m_; }
		year_t getYear()	{ return y_; }
		day_t getDay()		{ return d_; }
		hour_t getHour()	{ return h_; }
		minute_t getMinute(){ return min_; }
		second_t getSecond(){ return s_; }
		jdn_t getJdn()  	{ return j_; }
		jdnd_t getJdn2()    { return jd_; }
	};



// structs to represent Year,Month,Day
struct PackagedYear
{
	year_t nYears_;
	PackagedYear(year_t y):nYears_(y) {}
};
struct PackagedMonth
{
	month_t nMonths_;
	PackagedMonth(month_t m):nMonths_(m) {}
};
// to create one use PackagedDay(1)
struct PackagedDay
{
	day_t nDays_;
	PackagedDay(day_t d):nDays_(d) {}
};

struct PackagedWeek
{
	week_t nWeeks_;
	PackagedWeek(hour_t h):nWeeks_(h) {}
};

struct PackagedTime
{
	week_t nWeeks_;
	day_t nDays_;
	hour_t nHours_;
	minute_t nMinutes_;
	second_t nSeconds_;
	PackagedTime(week_t w, day_t d, hour_t h, minute_t min, second_t sec):nWeeks_(w), nDays_(d), nHours_(h), nMinutes_(min), nSeconds_(sec)  {}
};

// operator overloads
bool operator ==(JulianTime& lhs, JulianTime& rhs);
bool operator !=(JulianTime& lhs, JulianTime& rhs);
bool operator >=(JulianTime& lhs, JulianTime& rhs);
bool operator <=(JulianTime& lhs, JulianTime& rhs);
bool operator > (JulianTime& lhs, JulianTime& rhs);
bool operator < (JulianTime& lhs, JulianTime& rhs);

//bool operator ==(Julian& g1, Julian& g2);
JulianTime operator -(JulianTime& g1, JulianTime& g2);
JulianTime operator +(JulianTime& g, PackagedDay& d);
JulianTime operator -(JulianTime& g, PackagedDay& d);
JulianTime operator +(JulianTime& g, PackagedYear& y);
JulianTime operator -(JulianTime& g, PackagedYear& y);
JulianTime operator +(JulianTime& g, PackagedMonth& m);
JulianTime operator -(JulianTime& g, PackagedMonth& m);
JulianTime operator +(JulianTime& g, PackagedWeek& w);
JulianTime operator -(JulianTime& g, PackagedWeek& w);
JulianTime operator +(JulianTime& g, PackagedTime& t);
JulianTime operator -(JulianTime& g, PackagedTime& t);


#endif