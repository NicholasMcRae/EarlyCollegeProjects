////Nick mcRae
////Sample program how to launch apps and how to time how long the apps are open
//
//#include <string>
//#include <iostream>
//#include <Windows.h>
//
//using namespace std;
//
//int main()
//{
//
//	string s = "cmd.exe";
//	system(s.c_str());//system calls the system command and what it does is whatever you put in there, once you open the command window you can open a program from there
//	//if I want to open notepad with a file you would actually type in the file name after the command, your extension will automatically launch word
//	//the only thing your app won't know how to do is open a .txt with notepad, so you have to use the notepad.exe and the file you want to open
//	s = "notepad.exe test.txt";
//	//how to time stuff
//	unsigned long long start = ::GetTickCount64();//this will set the start value to whatever the count is before you launch the app
//	//the reason you need you need to do the c_str  is I missed it
//	system(s.c_str);
//	//this launches the file name
//	unsigned long long stop = ::GetTickCount64();//stops once the file is closed
//	double elapsedTime = (stop - start)/1000.0; //because your answer is in milliseconds
//
//	//
//
//	//now we have to know how to time something
//
//
//	return 0;
//}