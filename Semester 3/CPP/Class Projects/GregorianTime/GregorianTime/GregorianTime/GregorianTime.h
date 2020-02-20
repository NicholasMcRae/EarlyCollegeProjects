//// Nicholas McRae
//// Sept. 29, 2012
//// Date header file
//// This file includes the Date class and all the helper functions needed
//#ifndef __GregorianTime_H__
//#define __GregorianTime_H__
//
//#include <string>
//typedef double jdn_t;
//typedef double jdnd_t;
//typedef long long year_t;
//typedef int month_t;
//typedef int week_t;
//typedef long day_t;
//typedef long hour_t;
//typedef long minute_t;
//typedef long second_t;
//typedef double fraction_t;
//
//// base conversion functions
//jdn_t gregorian_to_jdn(year_t year, month_t month, day_t day);
//void jdn_to_gregorian(jdn_t jdn, year_t & year, month_t& month, day_t & day);
////jdn_t gregorian_to_jdn_decimal(year_t y_,month_t m_,day_t d_,hour_t h_,minute_t min_,second_t s_);
//
//class GregorianTime
//	{
//	private:
//		year_t y_;
//		month_t m_;
//		week_t w_;
//		day_t d_;
//		hour_t h_;
//		minute_t min_;
//		second_t s_;
//		jdn_t j_;
//		jdnd_t jd_;
//	public:
//		// this constructor takes in a jdn and calls the jdn_to_gregorian function which populates and returns the date using the jdn. It doesn't appear this constructor has been used yet
//		GregorianTime(jdn_t j)
//		{
//			j_ = j;
//			jdn_to_gregorian(j,y_,m_,d_);
//		}
//
//		//this constructor takes in the year, month, and day and populates the class variables and uses a function to populate the jdn_
//		GregorianTime(year_t y, month_t m, day_t d) :y_(y), m_(m), d_(d) 
//		{
//			j_ =gregorian_to_jdn(y_,m_,d_);
//		}
//
//		enum month_type{January=1,February,March,April,May,June,July,August,September,October
//			,November,December};
//
//		
//		/*GregorianTime(year_t y, month_t m, day_t d, hour_t h, minute_t min, second_t s) :y_(y), m_(m), d_(d), h_(h), min_(min), s_(s)
//		{
//			jd_ = gregorian_to_jdn(y_,m_,d_);
//			j_ = gregorian_to_jdn_decimal(y_,m_,d_,h_,min_,s_);
//		}*/
//
//		// getter functions for private variables
//		month_t getMonth()	{ return m_; }
//		year_t getYear()	{ return y_; }
//		day_t getDay()		{ return d_; }
//		hour_t getHour()	{ return h_; }
//		minute_t getMinute(){ return min_; }
//		second_t getSecond(){ return s_; }
//		jdn_t getJdn()  	{ return j_; }
//
//	};
//
//struct PackagedTime
//{
//	week_t nWeeks_;
//	day_t nDays_;
//	hour_t nHours_;
//	minute_t nMinutes_;
//	second_t nSeconds_;
//	PackagedTime(week_t w, day_t d, hour_t h, minute_t min, second_t sec):nWeeks_(w), nDays_(d), nHours_(h), nMinutes_(min), nSeconds_(sec)  {}
//};
//
//bool operator == (GregorianTime& g1, GregorianTime& g2);
//bool operator != (GregorianTime& g1, GregorianTime& g2);
//bool operator >= (GregorianTime& g1, GregorianTime& g2);
//bool operator <= (GregorianTime& g1, GregorianTime& g2);
//bool operator > (GregorianTime& g1, GregorianTime& g2);
//bool operator < (GregorianTime& g1, GregorianTime& g2);
//
//GregorianTime operator +(GregorianTime& g, PackagedTime& t);
//GregorianTime operator -(GregorianTime& g, PackagedTime& t);
//
//#endif