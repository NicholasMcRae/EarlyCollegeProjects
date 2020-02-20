// Nicholas McRae
// Sept. 29, 2012
// Date header file
// This file includes the GregorianTime and JulianTime classes as well as helper functions that will be unit tested
#ifndef DATE_H
#define DATE_H

#include <string>
typedef double jdn_t;
typedef long long year_t;
typedef long month_t;
typedef int week_t;
typedef long day_t;
typedef long hour_t;
typedef long minute_t;
typedef long second_t;
typedef double jdnd_t;
//consider changing the data type of the hour, minute, second variables



// base gregorian conversion functions
jdn_t gregorian_to_jdn_decimal(year_t y_,month_t m_,day_t d_,hour_t h_,minute_t min_,second_t s_);// this is the function we are using to return a jdn with time so I am able to compare my constructors with time added
jdn_t gregorian_to_jdn(year_t year, month_t month, day_t day);//I am using this function as a part of my time struct overload algorithm. This function helps convert the base date to the new date
void jdn_to_gregorian(jdn_t jdn, year_t & year, month_t& month, day_t & day);//I am using this function as a part of my time struct overload algorithm. This function is responsible for returning a new date, time is then tacked on in the return statement.

//base julian conversion functions (accomplish the same thing as the gregorian functions
jdn_t Julian_to_jdn_decimal(year_t y_,month_t m_,day_t d_,hour_t h_,minute_t min_,second_t s_);
jdn_t Julian_to_jdn(year_t year, month_t month, day_t day);
void jdn_to_Julian(jdn_t jdn, year_t & year, month_t& month, day_t & day);


// helper functions
day_t days_of_month(month_t month, year_t year);
bool isLeapYear(year_t year);
day_t days_of_month_julian(month_t month, year_t year);
bool isLeapYearJulian(year_t year);

//enum
enum month_type{January=1,February,March,April,May,June,July,August,September,October
			,November,December};

//day_of_week and to_string functions for Gregorian class
std::string dayOfWeek(year_t y_, month_t m_, day_t d_);
std::string to_string();

//dayOfWeek and to_string functions for Julian class
std::string to_string_julian();
std::string dayOfWeekJulian(year_t y_, month_t m_, day_t d_);


//GregorianTime class completes all of the Gregorian calendar functions with a default, date, and date/time constructor
//An additional Gregorian to Jdn method was created to compare Jdn number with time included for the date/time comparisons
//In the event that a GregorianTime without time is compared we revert to the original gregorian to jdn method without time included
//This explains how we incorporated and allowed time to be compared: the jdn without time was only used in the date calculation, and a further algorithm allowed us to calculate time and tack it on separately
//The method that combined date/time in a jdn was only used for comparison purposes and not included in the calculation algorithm
	class GregorianTime
	{
	private:
		year_t y_;
		month_t m_;
		week_t w_;
		day_t d_;
		hour_t h_;
		minute_t min_;
		second_t s_;
		jdn_t j_; //this variable is populated by gregorian constructors to allow us to compare the constructors in our boost tests
		jdnd_t jd_; //this variable is returned by the gregorian_to_jdn method (without time), this variable was used to recalculate the date alone within the addition and subtraction operators
	public:
		GregorianTime();  // initialize to current date and time, done in Date.cpp
			
		// this constructor takes in a jdn and calls the jdn_to_gregorian function which populates and returns the date using the jdn. It doesn't appear this constructor has been used yet
		GregorianTime(jdn_t j)
		{
			j_ = j;
			jdn_to_gregorian(j,y_,m_,d_);
		}

		//this constructor takes in the year, month, and day and populates the class variables and uses a function to populate the jdn_ j_ variable, which is used as a comparison in our boost tests
		GregorianTime(year_t y, month_t m, day_t d) :y_(y), m_(m), d_(d) 
		{
			j_ =gregorian_to_jdn(y_,m_,d_);
		}

		//I haven't quite figured out why this is useful yet so I wrote some other code in Date.cpp to replace what I thought it would do, in my to_string methods
		enum month_type{January=1,February,March,April,May,June,July,August,September,October
			,November,December};

		//explanations below, these variables are updated by our time operators, and an object of this type is returned by the same operators
		GregorianTime(year_t y, month_t m, day_t d, hour_t h, minute_t min, second_t s) :y_(y), m_(m), d_(d), h_(h), min_(min), s_(s)
		{
			//this call is necessary to use the equality operator while implementing time into the equation
			j_ = gregorian_to_jdn_decimal(y_,m_,d_,h_,min_,s_);

			//this call is necessary to use in the chosen algorithm for adding a time struct
			jd_ = gregorian_to_jdn(y_,m_,d_);
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



// structs to represent year, month, day, weeks, and time
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

//some operator overloads
bool operator ==(GregorianTime& lhs, GregorianTime& rhs);
bool operator !=(GregorianTime& lhs, GregorianTime& rhs);
bool operator >=(GregorianTime& lhs, GregorianTime& rhs);
bool operator <=(GregorianTime& lhs, GregorianTime& rhs);
bool operator > (GregorianTime& lhs, GregorianTime& rhs);
bool operator < (GregorianTime& lhs, GregorianTime& rhs);

//more operator overloads for manipulating GregorianTime objects
GregorianTime operator -(GregorianTime& g1, GregorianTime& g2);
GregorianTime operator +(GregorianTime& g, PackagedDay& d);
GregorianTime operator -(GregorianTime& g, PackagedDay& d);
GregorianTime operator +(GregorianTime& g, PackagedYear& y);
GregorianTime operator -(GregorianTime& g, PackagedYear& y);
GregorianTime operator +(GregorianTime& g, PackagedMonth& m);
GregorianTime operator -(GregorianTime& g, PackagedMonth& m);
GregorianTime operator +(GregorianTime& g, PackagedWeek& w);
GregorianTime operator -(GregorianTime& g, PackagedWeek& w);
GregorianTime operator +(GregorianTime& g, PackagedTime& t);
GregorianTime operator -(GregorianTime& g, PackagedTime& t);












//I created the JulianTime class in the same file as GregorianTime because it appeared like my unit-test file could only include one header file. Initially I attempted to separate the classes which suggests
//a misunderstanding of how software design works in C++. Putting both classes in the same file seems to do the trick, though, so that's what I've done. This class should be identical to my gregorian class
//but with some tweaked algorithms, notably in the jdn functions.
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




// operator overloads
bool operator ==(JulianTime& lhs, JulianTime& rhs);
bool operator !=(JulianTime& lhs, JulianTime& rhs);
bool operator >=(JulianTime& lhs, JulianTime& rhs);
bool operator <=(JulianTime& lhs, JulianTime& rhs);
bool operator > (JulianTime& lhs, JulianTime& rhs);
bool operator < (JulianTime& lhs, JulianTime& rhs);

//more operator overloads
JulianTime operator -(JulianTime& j1, JulianTime& j2);
JulianTime operator +(JulianTime& j, PackagedDay& d);
JulianTime operator -(JulianTime& j, PackagedDay& d);
JulianTime operator +(JulianTime& j, PackagedYear& y);
JulianTime operator -(JulianTime& j, PackagedYear& y);
JulianTime operator +(JulianTime& j, PackagedMonth& m);
JulianTime operator -(JulianTime& j, PackagedMonth& m);
JulianTime operator +(JulianTime& j, PackagedWeek& w);
JulianTime operator -(JulianTime& j, PackagedWeek& w);
JulianTime operator +(JulianTime& j, PackagedTime& t);
JulianTime operator -(JulianTime& j, PackagedTime& t);


#endif