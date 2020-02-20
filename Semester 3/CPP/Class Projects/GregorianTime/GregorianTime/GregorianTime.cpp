//// Lianne Wong
//// Sept. 18, 2012
//// Date.cpp
////This file holds the methods and operator overloads that will be boost tested in the ut_Date.cpp file
////methods include:**************************************DO THIS***************************************
//
//#include <iostream>
//#include <string>
//#include <cassert>
//#include <array>
//#include <ctime>
////#include "Date.h"
//#include "GregorianTime.h"
//using namespace std;
//
//bool operator ==(GregorianTime& g1, GregorianTime& g2)
//{
//	if(g1.getJdn() == g2.getJdn() && g1.getHour() == g2.getHour() && g1.getMinute() == g2.getMinute() && g1.getSecond() == g2.getSecond())
//	{
//		return true;
//	}
//	else
//	{
//		return false;
//	}
//		
//}//end == operator
//
//bool operator !=(GregorianTime& g1, GregorianTime& g2)
//{
//	if(g1.getJdn() == g2.getJdn() && g1.getHour() == g2.getHour() && g1.getMinute() == g2.getMinute() && g1.getSecond() == g2.getSecond())
//	{
//		return false;
//	}
//	else
//	{
//		return true;
//	}
//		
//}//end != operator
//
//bool operator <(GregorianTime& g1, GregorianTime& g2)
//{
//	if(g1.getJdn() < g2.getJdn())
//	{
//		return true;
//	}
//	else if (g1.getJdn() > g2.getJdn())
//	{
//		return false;
//	}
//	else if(g1.getHour() < g2.getHour())
//	{
//		return true;
//	}
//	else if(g1.getHour() > g2.getHour())
//	{
//		return false;
//	}
//	else if(g1.getMinute() < g2.getMinute())
//	{
//		return true;
//	}
//	else if(g1.getMinute() > g2.getMinute())
//	{
//		return false;
//	}
//	else if(g1.getSecond() < g2.getSecond())
//	{
//		return true;
//	}
//	else if(g1.getSecond() > g2.getSecond())
//	{
//		return false;
//	}
//	else
//	{
//		return false;
//	}
//		
//}//end < operator
//
//bool operator >(GregorianTime& g1, GregorianTime& g2)
//{
//	if(g1.getJdn() > g2.getJdn())
//	{
//		return true;
//	}
//	else if (g1.getJdn() < g2.getJdn())
//	{
//		return false;
//	}
//	else if(g1.getHour() > g2.getHour())
//	{
//		return true;
//	}
//	else if(g1.getHour() < g2.getHour())
//	{
//		return false;
//	}
//	else if(g1.getMinute() > g2.getMinute())
//	{
//		return true;
//	}
//	else if(g1.getMinute() < g2.getMinute())
//	{
//		return false;
//	}
//	else if(g1.getSecond() > g2.getSecond())
//	{
//		return true;
//	}
//	else if(g1.getSecond() < g2.getSecond())
//	{
//		return false;
//	}
//	else
//	{
//		return false;
//	}
//}// end > operator
//
//bool operator <= (GregorianTime& g1, GregorianTime& g2)
//{
//	if(g1.getJdn() > g2.getJdn())
//	{
//		return false;
//	}
//	if(g1.getHour() > g2.getHour())
//	{
//		return false;
//	}
//	if(g1.getMinute() > g2.getMinute())
//	{
//		return false;
//	}
//	if(g1.getSecond() > g2.getSecond())
//	{
//		return false;
//	}
//	else
//	{
//		return true;
//	}
//			
//}//end <= operator
//
//bool operator >= (GregorianTime& g1, GregorianTime& g2)
//{
//	if(g1.getJdn() < g2.getJdn())
//	{
//		return false;
//	}
//	if(g1.getHour() < g2.getHour())
//	{
//		return false;
//	}
//	if(g1.getMinute() < g2.getMinute())
//	{
//		return false;
//	}
//	if(g1.getSecond() < g2.getSecond())
//	{
//		return false;
//	}
//	else
//	{
//		return true;
//	}
//			
//}//end >= operator
//
//
//GregorianTime operator +(GregorianTime& g, PackagedTime& t)
//{
//	//declaring variables that will hold the date populated by a gregorian constructor call
//	double j = 0.0;
//	year_t year;
//	month_t month;
//	day_t day;
//
//	//figuring out how the number of seconds will effect the rest of the package and declaring time variables
//	day_t d = t.nSeconds_ / 86400;
//	hour_t h = (t.nSeconds_ % 86400) / 3600;
//	minute_t min = ((t.nSeconds_ % 86400) % 3600) / 60;
//	second_t sec = ((t.nSeconds_ % 86400) % 3600) % 60;
//
//	//figuring out how the number of minutes will effect the rest of the package
//	d += t.nMinutes_ / 1440;
//	h += (t.nMinutes_ % 1440) / 60;
//	min += (t.nMinutes_ % 1440) % 60;
//
//	//figuring out how the number of hours will effect the rest of the package
//	d += t.nHours_ / 24;
//	h += t.nHours_ % 24;
//
//	//adding the number of days to days
//
//	d += t.nDays_;
//
//	//figuring out how the number of weeks will effect the rest of the package
//	d += (t.nWeeks_ * 7);
//
//	//now we have to figure out if the mod seconds, minutes, and hours will increment their superior times at all
//
//	//increment the minutes based on the change in time due to total seconds accumulated
//
//	if((sec + g.getSecond()) <= 59)
//	{
//	sec = sec + g.getSecond();
//	}
//	else
//	{
//	int j = (sec + g.getSecond()) / 60;
//
//	sec = ((sec % 60) + g.getSecond()) - 60;
//	
//		for(int i = 0; i < j; ++i)
//		{
//		++min;
//		}
//
//	}//end else
//
//	//incrementing the hour based on the change in time due to total minutes accumulated
//	if((min + g.getMinute()) <= 59)
//	{
//	min = min + g.getMinute();
//	}
//	else
//	{
//	min = ((min % 60) + g.getMinute()) - 60;
//
//	int j = (min + g.getMinute()) / 60;
//
//		for(int i = 0; i < j; ++i)
//		{
//		++h;
//		}	
//	}//end else
//
//	//incrementing the day based on the change in time due to total hours accumulated
//	if(((h) + g.getHour()) < 24)
//	{
//	h += g.getHour();
//	}//end if
//	else
//	{
//	h = ((h % 24) + g.getHour()) - 24;
//	
//	int j = (h + g.getHour()) / 24;
//
//		for(int i=0; i < j; ++i)
//		{
//			++d;
//		}//end for
//
//	}//end else
//
//	//adding the number of days we've found to the jdn and then returning the year month day
//	j = g.getJdn() + d;
//	jdn_to_gregorian(j, year, month, day);
//	
//	return GregorianTime(year, month, day, h, min, sec);
//	
//}//end packaged day + operator
//
////implementing the negative operator overload
//GregorianTime operator -(GregorianTime& g, PackagedTime& t)
//{
//	//figuring out how the number of seconds will effect the rest of the package
//	double j = 0.0;
//	year_t year;
//	month_t month;
//	day_t day;
//	day_t d = t.nSeconds_ / 86400;
//	hour_t h = (t.nSeconds_ % 86400) / 3600;
//	minute_t min = ((t.nSeconds_ % 86400) % 3600) / 60;
//	second_t sec = ((t.nSeconds_ % 86400) % 3600) % 60;
//
//	//figuring out how the number of minutes will effect the rest of the package
//	d += t.nMinutes_ / 1440;
//	h += (t.nMinutes_ % 1440) / 60;
//	min += (t.nMinutes_ % 1440) % 60;
//
//	//figuring out how the number of hours will effect the rest of the package
//	d += t.nHours_ / 24;
//	h += t.nHours_ % 24;
//
//	//adding the number of days to days
//
//	d += t.nDays_;
//
//	//figuring out how the number of weeks will effect the rest of the package
//	d += (t.nWeeks_ * 7);
//
//	//now we have to figure out if the mod seconds, minutes, and hours will increment their superior times at all
//
//	//increment the minutes based on the change in time due to total seconds accumulated
//
//	if((g.getSecond() - sec) > 0)
//	{
//	sec = g.getSecond() - sec;
//	}
//	else
//	{
//	sec = (g.getSecond() - (sec % 60)) + 60;
//
//	int j = (sec - g.getSecond()) / 60;
//
//		for(int i = 0; i < j; ++i)
//		{
//		--min;
//		}
//
//	}//end else
//
//	//incrementing the hour based on the change in time due to total minutes accumulated
//	if((g.getMinute() - min) > 0)
//	{
//	min = g.getMinute() - min;
//	}
//	else
//	{
//	min = (g.getMinute() - (min % 60)) + 60;
//
//	int j = (min - g.getMinute()) / 60;
//
//		for(int i = 0; i < j; ++i)
//		{
//		--h;
//		}	
//	}//end else
//
//	//incrementing the day based on the change in time due to total hours accumulated
//	if((g.getHour() - h) > 0)
//	{
//	h = g.getHour() - h;
//	}//end if
//	else
//	{
//	h = (g.getHour() - (h%24)) + 24;
//	
//	int j = (h - g.getHour()) / 24;
//
//		for(int i=0; i < j; ++i)
//		{
//			--d;
//		}//end for
//
//	}//end else
//
//	//adding the number of days we've found to the jdn and then returning the year month day
//	j = g.getJdn() - d;
//	jdn_to_gregorian(j, year, month, day);
//	
//	return GregorianTime(year, month, day, h, min, sec);
//	
//}//end packaged day + operator
//
//GregorianTime operator -(GregorianTime& g1, GregorianTime& g2)
//{
//	year_t year;
//	month_t month;
//	day_t day;
//	hour_t hour;
//	minute_t min;
//	second_t sec;
//	jdn_t j;
//
//	j = g1.getJdn() - g2.getJdn();
//	jdn_to_gregorian(j, year, month, day);
//
//
//	if((g1.getHour() - g2.getHour()) < 0)
//	{
//	hour = (g1.getHour() - g2.getHour()) + 24;
//	}
//	else
//	{
//	hour = g1.getHour() - g2.getHour();
//	}
//
//	if((g1.getMinute() - g2.getMinute()) < 0)
//	{
//	min = ((g1.getMinute() - g2.getMinute()) + 60);
//	}
//	else
//	{
//	min = g1.getMinute() - g2.getMinute();
//	}
//
//	if((g1.getSecond() - g2.getSecond()) < 0)
//	{
//	sec = (g1.getSecond() - g2.getSecond()) + 60;
//	}
//	else
//	{
//	sec = (g1.getSecond() - g2.getSecond());
//	}
//	return GregorianTime(year, month, day, hour, min, sec);
//}