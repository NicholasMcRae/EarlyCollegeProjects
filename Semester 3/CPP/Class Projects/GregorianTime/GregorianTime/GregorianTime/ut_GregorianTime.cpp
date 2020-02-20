//// Lianne Wong
//// Sept. 18, 2012
//// unit test to test the Date class that we design
//// Note: If we are using the Boost test module, then make sure you don't have a main()
//#define BOOST_TEST_MODULE GregorianTimeUnitTest
//#include <boost\test\auto_unit_test.hpp>
//#include <iostream>
//#include <cassert>
//#include "GregorianTime.h"
//
//
//BOOST_AUTO_TEST_CASE( gregorian_op_plus_minus_PackagedTime_test)
//{
//GregorianTime g = GregorianTime(2012,10,10,2,2,2);
//GregorianTime g2 = GregorianTime(2012,10,28,100,100,100);
//GregorianTime g3 = GregorianTime(2012,10,10,2,2,2);
//GregorianTime g4 = GregorianTime(2012,10,10,1,1,1);
//PackagedTime t = PackagedTime (0,0,1,1,1);
//
//
//BOOST_CHECK(g2 == g);
//BOOST_CHECK(g4 == (g3-t));
//}