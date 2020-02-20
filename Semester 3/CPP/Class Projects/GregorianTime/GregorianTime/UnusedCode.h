//•	We need to implement a Julian calendar which we find on Wikipedia using a new class
//•	We don’t need to extend the Gregorian class using inheritance, we just need the one Gregorian header file and class with the appropriate constructors
//•	The entire “time” of day is a in a single struct and works as a package. So we should have a method of adding an entire time. . . hours, minutes, seconds. . .as a package to an instantiation of a Gregorian using the boost tests. However, there are other ways to put together the program that lianne would accept.
//•	The to_string method I am not clear on but it seems like it’s “outside” of the other functionality of the program and exists on its own


//STUFF TO DO
//1)Write two operator overloads for - and + using the struct as a whole and the jdn function, this logic shouldn't be too hard, just copy the operator overloads that I used before -- check

//2)implement the julian calendar: the julian calendar drifts 3 days every four centuries so I should implement some feature that adds 3 days whenever there is an increment of 400 years

//so I may need to re-work the already present methods a little. Every 400 years creates 3 days so I can use that logic to turn the decimal of 3 days into a time

//3) change the gregorian class to be gregoriantime

//4) implement the difference operator
//5) write new boost tests
//6) to-string method: returns a string with the day of the week, date, and time of day, I can write this using stringstreaming within the gregorian class
//7) new boost tests



//bool operator ==(Gregorian& g1, Gregorian& g2)
//{
//	if(g1.getJdn() == g2.getJdn())
//	{
//		if(g1.getHour() == g2.getHour())
//		{
//			if(g1.getMinute() == g2.getMinute())
//			{
//				if(g1.getSecond() == g2.getSecond())
//				{
//					return true;
//				}
//				else
//				{
//					return false;
//				}
//			}
//		}
//	}
//		
//}//end == operator

//bool operator == (Gregorian& lhs, Gregorian& rhs)
//{
//	return lhs == rhs;
//}

//overloading operators
//here we are going to implement all of the necessary overloaded operators
//I implemented the program incorrectly at first by adding each part of the time individually, however I am going to leave that code in and test it appropriately
//and I am also going to implement the code correctly, which I will specify here

//Gregorian operator +(Gregorian& g, PackagedTime& t)
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
//	return Gregorian(year, month, day, h, min, sec);
//	
//}//end packaged day + operator

//implementing the negative operator overload
//Gregorian operator -(Gregorian& g, PackagedTime& t)
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
//	return Gregorian(year, month, day, h, min, sec);
//	
//}//end packaged day + operator


//Gregorian operator +(Gregorian& g, PackagedTime& t)
//{
//	/*t.nDays_ = 100;
//	t.nHours_ = 100;
//	t.nMinutes_ = 100;
//	t.nSeconds_ = 100;
//	t.nWeeks_ = 100;*/
//
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
//	return Gregorian(year, month, day, h, min, sec);
//	
//}//end packaged day + operator


//BOOST_AUTO_TEST_CASE( gregoriantime_op_plus_minus_PackagedTime_test)
//{
//GregorianTime g = GregorianTime(2012,10,10,2,2,2);
//GregorianTime g2 = GregorianTime(2012,10,10,2,2,2);
//GregorianTime g3 = GregorianTime(2012,10,10,2,2,2);
//GregorianTime g4 = GregorianTime(2012,10,10,1,1,1);
//GregorianTime g5 = GregorianTime(2012,10,11,3,2,2);
//GregorianTime g6 = GregorianTime(2012,10,11,2,2,2);
//GregorianTime g7 = GregorianTime(2012,10,17,2,2,2);
//PackagedTime t = PackagedTime (0,0,1,1,1);
//PackagedTime incrementDayWithHour = PackagedTime (0,0,25,0,0);
//PackagedTime incrementDayWithMinute = PackagedTime (0,0,0,1500,0);
//PackagedTime incrementDayWithSecond = PackagedTime (0,0,0,0,90000);
//PackagedTime incrementDayWithDay = PackagedTime (0,1,0,0,0);
//PackagedTime incrementDayWithWeek = PackagedTime(1,0,0,0,0);
//
//BOOST_CHECK(g2 == g);
//BOOST_CHECK(g4 == (g3-t));
////these three tests show that the hour, minute, second logic flow works, as once a day is incremented we use the jdn function
//BOOST_CHECK(g5 == (g + incrementDayWithHour));
//BOOST_CHECK(g5 == (g + incrementDayWithMinute));
//BOOST_CHECK(g5 == (g + incrementDayWithSecond));
////these two tests show that the week and day increment work properly, which will extend to any number of tests
//BOOST_CHECK(g6 == (g + incrementDayWithDay));
//BOOST_CHECK(g7 == (g + incrementDayWithWeek));
//
//
//
//}
//incrementing the weeks gives an error
//incrementing the days gives an error
//hour doesn't give an error when altered
//no error when minutes are altered
//second doesn't give an error when altered

//BOOST_AUTO_TEST_CASE( gregorian_op_plus_minus_PackagedTime_test)
//{
//Gregorian g = Gregorian(2012,10,10,2,2,2);
//Gregorian g2 = Gregorian(2012,10,28,100,100,100);
//Gregorian g3 = Gregorian(2012,10,10,2,2,2);
//Gregorian g4 = Gregorian(2012,10,10,1,1,1);
//PackagedTime t = PackagedTime (0,0,1,1,1);
//
//
//BOOST_CHECK(g2 == g);
//BOOST_CHECK(g4 == (g3-t));
//}


















////I have to write some operator overloading for adding weeks
//BOOST_AUTO_TEST_CASE( gregorian_op_plus_minus_week_test)
//{
//Gregorian g = Gregorian(2012,9,30);
//PackagedWeek w = PackagedWeek(1);
//Gregorian g2 = Gregorian(2012,10,7);
//Gregorian g3 = Gregorian(2012,9,23);
//
////testing for subtraction and addition of weeks
//BOOST_CHECK(g2 == (g+w));
//BOOST_CHECK(g3 == (g-w));
//
//}
//
////I have to write some operator overloading for adding hours
////to check hours I am going to have to initialize a time with a constructor, and then make it ==
////to another constructor plus that amount of time, so I will have something like:
////BOOST_CHECK(g2 == (g+h));
////so I am going to need a constructor that populates all of the variables
//BOOST_AUTO_TEST_CASE( gregorian_op_plus_minus_hour_test)
//{
//Gregorian g = Gregorian(2012,10,01,11,30,30);
//PackagedHour h = PackagedHour(24);
//PackagedHour h2 = PackagedHour(25);
//Gregorian g2 = Gregorian(2012,10,02,11,30,30);
//Gregorian g3 = Gregorian(2012,10,02,12,30,30);
//Gregorian g4 = Gregorian(2012,9,30,12,30,30);
//Gregorian g5 = Gregorian(2012,9,30,11,30,30);
//
//BOOST_CHECK(g2 == (g+h));
//BOOST_CHECK(g3 == (g+h2));
//BOOST_CHECK(g4 ==(g-h));
//BOOST_CHECK(g5 ==(g-h2));
//
//}
//
//
////I have to write some operator overloading for adding minutes
//
//BOOST_AUTO_TEST_CASE( gregorian_op_plus_minus_minute_test)
//{
//Gregorian g = Gregorian(2012,10,01,11,30,30);
//PackagedMinute m = PackagedMinute(60);
//PackagedMinute m2 = PackagedMinute(70);
//Gregorian g2 = Gregorian(2012,10,01,12,30,30);
//Gregorian g3 = Gregorian(2012,10,01,12,40,30);
//Gregorian g4 = Gregorian(2012,10,01,10,30,30);
//Gregorian g5 = Gregorian(2012,10,01,9,20,20);
//
//BOOST_CHECK(g2 == (g+m));
//BOOST_CHECK(g3 == (g+m2));
//BOOST_CHECK(g4 == (g-m));
//BOOST_CHECK(g5 == (g-m2));
//}
//
////I have to write some operator overloading for adding seconds
//
//BOOST_AUTO_TEST_CASE( gregorian_op_plus_minus_second_test)
//{
//Gregorian g = Gregorian(2012,10,01,11,30,30);
//Gregorian gg = Gregorian(2012,10,01,11,20,10);
//PackagedSecond s = PackagedSecond(30); //testing for no minute increment
//PackagedSecond s2 = PackagedSecond(60); //testing for minute being incremented and second staying the same
//PackagedSecond s3 = PackagedSecond(70); //testing for minute being incremented and second changing
//PackagedSecond s4 = PackagedSecond(3600);//testing for hour being incremented and second staying the same
//PackagedSecond s5 = PackagedSecond(3700);//testing for hour being incremented and second changing
//PackagedSecond s6 = PackagedSecond(86400);//testing for a day being incremented with seconds
//
//Gregorian g2 = Gregorian(2012,10,01,11,30,40);
//Gregorian g3 = Gregorian(2012,10,01,11,31,30);
//Gregorian g4 = Gregorian(2012,10,01,11,31,40);
//Gregorian g5 = Gregorian(2012,10,01,11,29,30);
//Gregorian g6 = Gregorian(2012,10,01,11,29,20);
//Gregorian g7 = Gregorian(2012,10,01,12,30,30);
//Gregorian g8 = Gregorian(2012,10,01,10,30,30);
//Gregorian g9 = Gregorian(2012,10,01,10,32,10);
//Gregorian g10 = Gregorian(2012,10,01,10,28,50);
//Gregorian g11 = Gregorian(2012,10,02,11,30,30);
//Gregorian g12 = Gregorian(2012,9,30,11,30,30);
//
//BOOST_CHECK(g2 == (gg+s));
//BOOST_CHECK(g3 == (g+s2));
//BOOST_CHECK(g4 == (g+s3));
//BOOST_CHECK(g5 == (g-s2));
//BOOST_CHECK(g6 == (g-s3));
//BOOST_CHECK(g7 == (g+s4));
//BOOST_CHECK(g8 == (g-s4));
//BOOST_CHECK(g9 == (g+s5));
//BOOST_CHECK(g10 == (g-s5));
//BOOST_CHECK(g11 == (g + s6));
//BOOST_CHECK(g12 == (g - s6));
//
//}