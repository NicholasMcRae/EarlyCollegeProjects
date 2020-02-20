 BOOST_AUTO_TEST_CASE( introduction )
 {
	 cout << "\nDate Unit test." << endl;
	 cout << "Last compiled: " __TIMESTAMP__ << endl;
 }

 // Boost check the method to convert a Julian date to a julian day number (jdn)
 BOOST_AUTO_TEST_CASE( Julian_to_jdn_test )
 {
	 // Test for normal cases, upper and lower ranges and invalid data
	 // currently check to 0 but when implemented check the real value
	 // using  http://www.fourmilab.ch/documents/calendar/
	 // the real number is:  2456188
	 jdn_t jdn =Julian_to_jdn(-4813,11,24);
	 BOOST_CHECK( Julian_to_jdn(2012,9,18) == 2456188.5);
	 BOOST_CHECK( Julian_to_jdn(-4713,11,24) == -0.5);
	 BOOST_CHECK( Julian_to_jdn(-4813,11,24) == -36524.5);
	 BOOST_CHECK( Julian_to_jdn(50000,9,20) == 19983447.5);

 }

 BOOST_AUTO_TEST_CASE( days_in_month_test )
 {
	 // tests function days_of_month() and isLeapYear()
	 day_t d = days_of_month(2, 2000);
	 BOOST_CHECK( days_of_month(2, 2000) == 29);
	 BOOST_CHECK( days_of_month(2, 2011) == 28);
	 BOOST_CHECK( days_of_month(5, 2000) == 31);
	 BOOST_CHECK( days_of_month(12, 2000) == 31);
	 BOOST_CHECK( days_of_month(1, 2000) == 31);
	 BOOST_CHECK( days_of_month(6, 2000) == 30);
 }

 // Boost check the method to convert a Julian date to a julian day number (jdn)
 BOOST_AUTO_TEST_CASE( jdn_to_Julian_test )
 {
	 // Test for normal cases, upper and lower ranges and invalid data
	 // currently check to 0 but when implemented check the real value
	 // using  http://www.fourmilab.ch/documents/calendar/
	 // the real number is:  2456188
	 year_t y;
	 month_t m;
	 day_t d;
	 jdn_to_Julian(2456188.5,y,m,d);

	 BOOST_CHECK( 2012 == y);
	 BOOST_CHECK( 9 == m);
	 BOOST_CHECK( 18 == d);
	 
	 jdn_to_Julian(1721323.5,y,m,d);

	 BOOST_CHECK( 0 == y);
	 BOOST_CHECK( 9 == m);
	 BOOST_CHECK( 21 == d);

 }
 // test the default constructor
 BOOST_AUTO_TEST_CASE( Julian_ctor_test )
 {
	 // tests default constructor
	 JulianTime g = JulianTime();
	 // Note: you should not do this, because if you run it tomorrow or a year from now
	 // it won't work.   You should get the current month,day and year and compare it to
	 // those variables
	// BOOST_CHECK( g.getMonth() == Julian::September);
	 /*BOOST_CHECK( g.getYear() == 2012);
	 BOOST_CHECK( g.getDay() == 26);*/
 }
 // test the operator ==
 BOOST_AUTO_TEST_CASE( Julian_op_eq_test )
 {
	 // tests default constructor
	 JulianTime g = JulianTime(2012,9,25);
	 JulianTime g1 = JulianTime(2012,9,25);
	 JulianTime g2 = JulianTime(2012,9,26);

	 BOOST_CHECK( g == g1);
	 BOOST_CHECK( !(g == g2));
	 BOOST_CHECK( !(g1 == g2));
 }

 // test the operator overload of + and - for days
BOOST_AUTO_TEST_CASE( Julian_op_plus_minus_day_test )
 {
	 // tests default constructor
	 JulianTime g = JulianTime(2012,9,25);							
	 PackagedDay d = PackagedDay(1);  // 1 day							
	 PackagedDay d4 = PackagedDay(4); // 4 days						
	 PackagedDay d5 = PackagedDay(5); // 5 days						
	 JulianTime g2 = JulianTime(2012,9,26);							
	 JulianTime g3 = JulianTime(2012,9,30);	
	 JulianTime g4 = JulianTime(2012,9,30);
	 // testing operator +										
	 BOOST_CHECK( g2 == (g+d));
	 BOOST_CHECK( g3 == (g+d5));
	 BOOST_CHECK( g3 == (g2+d4));
	 BOOST_CHECK( g3 != (g+d));

	 //testing with other operators
	 BOOST_CHECK( g2 < g3);
	 BOOST_CHECK( g3 >= g4);
	 BOOST_CHECK( g4 > g2);
	 
	 // testing operator -
	 BOOST_CHECK( g == (g2-d));
	 BOOST_CHECK( g == (g3-d5));
	 BOOST_CHECK( g2 == (g3-d4));
 }

BOOST_AUTO_TEST_CASE( Julian_op_plus_minus_month_test)
{
	JulianTime g = JulianTime(2012,9,30);
	PackagedMonth m = PackagedMonth(1); 
	PackagedMonth m5 = PackagedMonth(5);
	PackagedMonth m17 = PackagedMonth(17);
	JulianTime g2 = JulianTime(2012,10,30);
	JulianTime g3 = JulianTime(2013,2,28);
	JulianTime g4 = JulianTime(2014,2,28);

	BOOST_CHECK(g2 == (g+m));
	BOOST_CHECK(g == (g2-m));
	BOOST_CHECK(g3 == (g+m5));
	BOOST_CHECK(g4 == (g+m17));
}

BOOST_AUTO_TEST_CASE( Juliantime_op_plus_minus_PackagedTime_test)
{
JulianTime g = JulianTime(2012,10,10,2,2,2);
JulianTime g2 = JulianTime(2012,10,10,2,2,2);
JulianTime g3 = JulianTime(2012,10,10,2,2,2);
JulianTime g4 = JulianTime(2012,10,10,1,1,1);
JulianTime g5 = JulianTime(2012,10,11,3,2,2);
JulianTime g6 = JulianTime(2012,10,11,2,2,2);
JulianTime g7 = JulianTime(2012,10,17,2,2,2);
JulianTime g8 = JulianTime(2012,10,10,12,2,2);
PackagedTime t = PackagedTime (0,0,1,1,1);
PackagedTime incrementDayWithHour = PackagedTime (0,0,25,0,0);
PackagedTime incrementDayWithMinute = PackagedTime (0,0,0,1500,0);
PackagedTime incrementDayWithSecond = PackagedTime (0,0,0,0,90000);
PackagedTime incrementDayWithDay = PackagedTime (0,1,0,0,0);
PackagedTime incrementDayWithWeek = PackagedTime(1,0,0,0,0);
PackagedTime incrementHourWithoutIncrementingDay = PackagedTime (0,0,10,0,0);
PackagedTime incrementMinuteWithoutIncrementingDay = PackagedTime (0,0,0,600,0);
PackagedTime incrementSecondWithoutIncrementingDay = PackagedTime (0,0,0,0,36000);

//initial tests to verify I'm on the right track
BOOST_CHECK(g2 == g);
BOOST_CHECK(g4 == (g3-t));
//these three tests show that the hour, minute, second logic flow works, as once a day is incremented we use the jdn_to_Julian function, which has already been tested successfully
BOOST_CHECK(g5 == (g + incrementDayWithHour));
BOOST_CHECK(g5 == (g + incrementDayWithMinute));
BOOST_CHECK(g5 == (g + incrementDayWithSecond));
//these two tests show that the week and day increment work properly, which will extend to any number of tests
BOOST_CHECK(g6 == (g + incrementDayWithDay));
BOOST_CHECK(g7 == (g + incrementDayWithWeek));
//now going to test the subtraction operator
BOOST_CHECK(g == (g5 - incrementDayWithHour));
BOOST_CHECK(g == (g5 - incrementDayWithMinute));
BOOST_CHECK(g == (g5 - incrementDayWithSecond));
//now going to test the week and day with the subtraction operator
BOOST_CHECK(g == (g6 - incrementDayWithDay));
BOOST_CHECK(g == (g7 - incrementDayWithWeek));
//now going to test the algorithms without a day increment, adding 10 hours using hours, minutes, and seconds
BOOST_CHECK(g == (g8 - incrementHourWithoutIncrementingDay));
BOOST_CHECK(g == (g8 - incrementMinuteWithoutIncrementingDay));
BOOST_CHECK(g == (g8 - incrementSecondWithoutIncrementingDay));



}

BOOST_AUTO_TEST_CASE( Juliantime_op_difference_test)
{
	JulianTime g = JulianTime (3,2,2,2,2,2);
	JulianTime g2 = JulianTime (2,1,1,1,1,1);
	JulianTime g3 = JulianTime (1,1,1,1,1,1);
	JulianTime g4 = JulianTime (2,2,2,2,2,2);
	JulianTime g5 = JulianTime (1,12,31,23,59,59);

	//test of the difference operator
	BOOST_CHECK ((g-g2) == g3);
	BOOST_CHECK ((g-g4) == g5);
}