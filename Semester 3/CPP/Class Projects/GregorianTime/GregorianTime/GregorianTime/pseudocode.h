//Things I need to do:
//1) write two new functions that involve a conversion from a different calendar to jdn, and then jdn back to that calendar
//2) perhaps write these in another header file and change the names of each of thee header files to better organize the program
//3) write the rest of the operator overloads for all of the other shit and include the leap year thing if necessary
//4) write boost test cases to test the stuff

//Extended pseudocode
// extend the gregorian class to handle time of day, so I will need to add more private variables for the time of day and also add a new constructor that initializes all of the variables - done
// check out the link below for julian day number to figure out how to implement time, a fractional part of the jdn represents time, so I need some logic to handle this
// presumably I need to add an hour, minutes, and seconds variable, and I am going to use those variables to calculate the fractional JD
// so I will create a constructor that intakes all of the time inputs and outputs the fractional JD, then I will need to copy the JDN to Gregorian function and add some functionality for time, so my input needs to be the JD
// once I have all of this worked out I need to create all of my operator overload stuff to account for adding hours, minutes, seconds, an weeks
// boost tests

//1) extend variables in the gregorian class
//2) write constructor that implements the time
//3) write methods that manipulate the time of day into a jd

//Notes
//***** read previous projects to read into comments (note about default constructor and not initializing it to the current date)
//make sure our operator overloading is above the boost tests
//keep boost tests in one file
//she's showing us where an algorithm is on julian day number, under julian day wikipedia page "finding julian date given julian day number and time of day
//if you need the day of the week write mod 7
//lots of minuses in the specs so make sure you do a lot of boost tests
//time: hours minutes seconds
//implementing years: the trick with years
//thoughts: do logic in the overload operator?

//Due Oct. 12th 
//Project Description
//extend the gregorian class developed in class to handle time of day (call it GregorianTime)
//Time will be represented internally as the fractional part of a julian day number see (http://en.wikipedia.org/wiki/Julian_day_nummber
//you should handle time input and output in hours, minutes, seconds, and fractions of a second (real number)
//Remember that a julian day number with a fractional part of .0 refers to noon of that day
//your class should have a minimum of:
//1) default constructor (initializes to now)
// it looks like we already have a default constructor included
//2) GregorianTime date constructor (no time part)
// looks like we already have this
//3) gregoriantime date constructor (with time initialization as well
// need to figure out how this works
//4) all six relational operators (==, !=, <, <=, >, >=
//not entirely sure what this means, but I think this is what I include in the boost tests?
//5) difference operator
// what the fuck, have this explanation somewhere in my code
//6) Methods/operators for adding days, minutes, seconds
//have to figure out the logic for all of these including seconds
//a) + (week, day, hour, minute, second)
//b) + year (if you add years, the month and the day should be exactly the same as the original month and day. The exception is starting date on Feb 29th on a leap year and the ending date is a non-leap year. In this case you would use the largest day in that month
//c) + (month) if you hadd a month the day should be exactly the same as the original day. The exception is if the day in the starting month is greater than the day in the ending month. In this case you would use the largest day in that month (January 31, 2012, plus one month is February 29 2012
//d) - (week, day, hour, minute, second)
//e) - (year)
//f) - (month)
//7) A 'to_string method that returns a string containing the gregorian date and 12 hour time of day (i.e. Thursday, September 27 2012, 11:05:03 am)
//will look at this later
//8) Several supporting functions will help with the above functionality. They may include the following functioons: is_leap_year(), days_in_month(), jdn_to_time_of_day(), month_to_name()
//9) Create a julian class equivalent to the gregoriantime class you have just created
// she has instantiated a julian day number class
//10) create another class that will work on another calendar system. You could choose any other calendar
//11) extent the boost unit test to cover the new operations. Note that all functions will be deducted if there is no boost unit test to cover the operations

// Functional Requirements
// Class diagram
//default gregoriantime constructor
//custom gregoriantime constructor that includes hour, minutes, seconds
//relational operators
//difference operator
//addition operators (week, day, hour, minutes, seconds)
//addition operator (year)
//addition operator (month)
//subtraction operator (week, day, hour, minutes, seconds)
//subtraction operator (year)
//subtraction operator (month)
// to_string() method
//implement all above using the julian calendar
//implement all the above using a different calendar 

// Non-functional requirements
//cleanly compiles on four build models
//memory leaks detected
//failure to respect submission requirements
//other issues

 // tests default constructor
	 							// populating constructor with year, month, day, hour, minute second, need to be able to add and subtract hours, minutes seconds
	  // 1 day							from a struct and get the right result
	 // 4 days						so I will be testing as I know the right answer
	 					//so I am going to need to instantiate some classes with times and then I am going to need to be able to convert them properly with the
	 						// proper operator overloading so I will have to implement this correctly and output the right thing depending on the time inputs
	 							// the constructor can make a function call to populate the potential variables, so what I am going to need to do is pass in a gregorian
	 // testing operator +											//date and convert it to a jdn

//if I call a constructor like this it will instantiate the class variables acccordingly, so in this case we feed a jdn into a constructor and it outputs a new gregorian date
		//so when I am implementing the time I am going to have to create a new function that feeds a date and time into a function, and then makes a function call, theoretically I think I could
		//create two constructors, but I think I just need to create one. I need to write a new method that takes in a gregorian date, converts the gregorian to a jdn, then implements the time to create a jd
		//I then need to write a second method and constructor that converts a jd back to a gregorian. Then when I am writing my operator overloads I am going to need to create the operator overloading functions
		//that takes in the information and grabs the variables from the class and works on the logic of changing the date, and I am going to be returning the appropriate constructor to produce the date

//these are checking the overloaded operators by populating the packageday in different variables and testing them
// the equality operator is also overloaded


//Boost checks that I need to implement:
//boost checks that check the hour, minute, and seconds of the day
//need to write a second function that converts a second date to jdn, and then from jdn back to that date
//need to write structs for the rest of the time intervals (I assume down to seconds)
//going to need to write operator overloads for each type of time


//make sure our operator overloading is above the boost tests
//keep boost tests in one file
//she's showing us where an algorithm is on julian day number, under julian day wikipedia page "finding julian date given julian day number and time of day
//if you need the day of the week write mod 7
//lots of minuses in the specs so make sure you do a lot of boost tests
//time: hours minutes seconds
//implementing years: the trick with years
//thoughts: do logic in the overload operator?

//year using jdn function
/*	jdn_t days_in_year = 365 * y.nYears_;
	year_t years_to_add = y.nYears_;
	year_t yNow = g.getYear();
	if( g.getMonth() <= Gregorian::February)
	{
		while(years_to_add--)
		{
			if(isLeapYear(yNow++))
				days_in_year++;
		}
	}
	else
	{
		while(years_to_add--)
		{
			if(isLeapYear(++yNow))
				days_in_year++;
		}
	}
	return Gregorian(g.getJdn() + days_in_year);*/

//What do I want to do with this constructor?
		//This is a constructor that feeds in all of this stuff and populates the various variables, although what's happening inside is questionable and I want to figure it out right now
		//I have a gregorian to jdn function that populates j_
		//I can then use the j_ variable to populate the jd_ which includes time (so I have to write a new method in Date.cpp that takes in a jdn variable and outputs a jd, which gives me a fraction of a jdn
		//ok so I have got a fraction of a jdn, what do I need to do with it? I am going to use this new method in the operator overload functions
		//what I will do is calculate the jd_ with an intake of time of day, and then I will have to implement a way in my operator overloading functions to go back to a jdn, and then back to gregorian
		//using the gregorian jdn constructor
		//to summarize:
		//I need to make a method call that calculates a jdn from the gregorian date (in my operator overload function)
		//I then need to implement a new method that I will need to write from the wikipedia page that is going to convert the jdn to a jd
		//I will then need to do some logic in each of the operator overloaded functions that calculates the fractional part of a jdn represented by a given number of hours or seconds or whatever
		//then I need to add it or subtract it from the jd, convert back into a jdn, and then convert it back into a gregorian date
		//although this still leaves a fractional part left that I'll have to deal with somehow
		//handling weeks: mod 7
		//handling hours 
