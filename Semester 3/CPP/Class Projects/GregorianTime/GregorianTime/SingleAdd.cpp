#include <iostream>
#include <string>
#include <cassert>
#include <array>
#include <ctime>
#include "C:\Users\Nicholas\Desktop\Courses\C++\Date-Sept27\Date.h"
using namespace std;




//I have to write some operator overloading for adding weeks
Gregorian operator +(Gregorian& g, PackagedWeek& w)
{
	//I have to calculate the number of days that come from the number of weeks to be added and then walk through the logic
	day_t d = w.nWeeks_ * 7;
	return Gregorian(g.getJdn() + d);
}

Gregorian operator -(Gregorian& g, PackagedWeek& w)
{
	//I have to calculate the number of days that come from the number of weeks to be added and then walk through the logic
	day_t d = w.nWeeks_ * 7;
	return Gregorian(g.getJdn() - d);
}


//I have to write some operator overloading for adding hours
Gregorian operator +(Gregorian& g, PackagedHour& h)
{
	long long year = 0;
	int month = 0;
	long day = 0;
	double j;
	hour_t h_ = 0;

	day_t d = h.nHours_ / 24;
	j = g.getJdn() + d;
	jdn_to_gregorian(j, year, month, day);

	if(((h.nHours_  % 24) + g.getHour()) < 24)
	{
	hour_t h_ = (h.nHours_ % 24) + g.getHour();
	}
	else
	{
	hour_t h_ = ((h.nHours_ % 24) + g.getHour()) - 24;
	++day;
	}
	

	return Gregorian(year, month, day, h_ , g.getMinute(), g.getSecond());

	//number of hours is a bit different because I'm going to need to check the entire time
}

Gregorian operator -(Gregorian& g, PackagedHour& h)
{
	long long year = 0;
	int month = 0;
	long day = 0;
	double j;
	hour_t h_ = 0;

	day_t d = h.nHours_ / 24;

	j = g.getJdn() - d;
	jdn_to_gregorian(j, year, month, day);

	if((g.getHour() - (h.nHours_  % 24)) < 0)
	{
	hour_t h_ = (g.getHour() - (h.nHours_ % 24)) + 24;
	--day;
	}
	else
	{
	hour_t h_ = (g.getHour() - (h.nHours_ % 24));
	}
	

	return Gregorian(year, month, day, h_ , g.getMinute(), g.getSecond());

	//number of hours is a bit different because I'm going to need to check the entire time
}


//I have to write some operator overloading for adding minutes
Gregorian operator +(Gregorian& g, PackagedMinute& m)
{
	long long year;
	int month;
	long day;
	double j;
	hour_t h_ = 0;

	//extracting the number of days from the number of minutes
	day_t d = m.nMinutes_ / 1440;

	//extracting the number of hours from the mod days
	hour_t h = (m.nMinutes_ % 1440) / 60;

	//extracting the number of minutes left from the mod hours
	minute_t min = (m.nMinutes_ % 1440) % 60;

	//ok what I need to do now is calculate the new jdn in order to get the new date
	j = g.getJdn() + d;
	jdn_to_gregorian(j, year, month, day);

	//now I need to update the hours
	if((h + g.getHour()) < 24)
	{
	hour_t h_ = h + g.getHour();
	}
	else
	{
	hour_t h_ = (h + g.getHour()) - 24;
	++day;
	}

	//now I need to update the minutes
	if((min + g.getMinute()) < 59)
	{
	min = min + g.getMinute();
	}
	else
	{
	min = (min + g.getMinute()) - 59;
	++h_;
	}
	
	return Gregorian(year, month, day, h_ , min, g.getSecond());
}

Gregorian operator -(Gregorian& g, PackagedMinute& m)
{
	long long year = 0;
	int month = 0;
	long day = 0;
	double j;
	hour_t h_ = 0;

	//extracting the number of days from the number of minutes
	day_t d = m.nMinutes_ / 1440;

	//extracting the number of hours from the mod days
	hour_t h = (m.nMinutes_ % 1440) / 60;

	//extracting the number of minutes left from the mod hours
	minute_t min = (m.nMinutes_ % 1440) % 60;

	//ok what I need to do now is calculate the new jdn in order to get the new date
	j = g.getJdn() - d;
	jdn_to_gregorian(j, year, month, day);

	//now I need to update the hours
	if((g.getHour() - h) < 0)
	{
	hour_t h_ = (g.getHour() - h) + 24;
	--day;
	}
	else
	{
	hour_t h_ = (g.getHour() - h);
	}

	//now I need to update the minutes
	if((g.getMinute() - min) < 0)
	{
	min = (g.getMinute() - min) + 59;
	--h_;
	}
	else
	{
	min = g.getMinute() - min;
	}
	
	return Gregorian(year, month, day, h_ , min, g.getSecond());
}

//I have to write some operator overloading for adding seconds

Gregorian operator +(Gregorian& g, PackagedSecond& s)
{
	long long year = 0;
	int month = 0;
	long day = 0;
	double j;
	hour_t h_ = 0;

	//extracting the number of days from the number of minutes
	day_t d = s.nSeconds_ / 86400;

	//extracting the number of hours from the mod days
	hour_t h = (s.nSeconds_ % 86400) / 3600;

	//extracting the number of minutes left from the mod hours
	minute_t min = (((s.nSeconds_ % 86400) % 3600) / 60);

	second_t sec = (((s.nSeconds_ % 86400) % 3600) % 60);

	//ok what I need to do now is calculate the new jdn in order to get the new date
	j = g.getJdn() + d;
	jdn_to_gregorian(j, year, month, day);

	//now I need to update the hours
	if((h + g.getHour()) < 24)
	{
	hour_t h_ = h + g.getHour();
	}
	else
	{
	hour_t h_ = (h + g.getHour()) - 24;
	++day;
	}

	//now I need to update the minutes
	if((min + g.getMinute()) < 59)
	{
	min = min + g.getMinute();
	}
	else
	{
	min = (min + g.getMinute()) - 60;
	++h_;
	}

	//now I need to update the seconds
	if((sec + g.getSecond()) < 60)
	{
	sec = sec + g.getSecond();
	}
	else
	{
	sec = (sec + g.getSecond()) - 60;
	++min;
	}
	
	return Gregorian(year, month, day, h_ , min, sec);
}

Gregorian operator -(Gregorian& g, PackagedSecond& s)
{
	long long year = 0;
	int month = 0;
	long d = 0;
	double j;
	hour_t h_ = 0;

	//extracting the number of days from the number of minutes
	long day = s.nSeconds_ / 86400;

	//extracting the number of hours from the mod days
	hour_t h = (s.nSeconds_ % 86400) / 3600;

	//extracting the number of minutes left from the mod hours
	minute_t min = (((s.nSeconds_ % 86400) % 3600) / 60);

	second_t sec = (((s.nSeconds_ % 86400) % 3600) % 60);

	//ok what I need to do now is calculate the new jdn in order to get the new date
	//now I need to update the hours
	if((g.getHour() - h) > 0)
	{
	hour_t h_ = g.getHour() - h;
	}
	else
	{
	hour_t h_ = (g.getHour() - h) + 24;
	--day;
	}
	j = g.getJdn() - day;
	jdn_to_gregorian(j, year, month, d);

	//now I need to update the minutes
	if((g.getMinute() - min) < 0)
	{
	min = (g.getMinute() - min) + 60;
	--h_;
	}
	else
	{
	min = g.getMinute() - min;
	}

	//now I need to update the seconds
	if((g.getSecond() - sec) < 0)
	{
	sec = (sec + g.getSecond() + 60);
	--min;
	}
	else
	{
	sec = (g.getSecond()) - 60;
	}
	
	return Gregorian(year, month, d, h_ , min, sec);
}

//I have to some how figure how the fraction of a second part. . and I think this will occur when I use the equation and get the seconds as a double, so I will need to declare the seconds as a double