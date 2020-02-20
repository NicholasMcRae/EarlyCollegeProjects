//Program name: grep.exe
//Program purpose: To simulate the grep command

#include <iostream>
#include <fstream>
#include <vector>
#include <string>
#include <ctime>
#include <io.h>

using namespace std;

//pseudocode

void scan(string filespec, string path)
{
	intptr_t hFile; //file handler, int pointer_t, that tells you stuff if you hover over it, integer pointer basically
	struct _finddata_t fd; // file data
	string findPath = path + filespec;
	hFile = _findfirst(  findPath.c_str()  , &fd);

	if(hFile == -1L)
	{
		cout << "no " << "*.*" << " files in the current dir\n";
	}
	else
	{
		do
		{
			
			if((fd.name != string(".")) && (fd.name != string("..")))
			{
			//if the fd found is a directory
			if(fd.attrib & _A_SUBDIR)
			{
				//recursively call scan
				//remember path always wants to end with a \\
				
				string str = path + fd.name + "\\";
				scan(filespec,str);
			}
			else
			{
				//if its a file we want to print out stuff, kind of
				cout << fd.name << endl; //after the fd.name she put in a ternary operator looking for read only, yes or no
			// while _findnext finds a different file
			}
			cout << fd.name << endl; //after the fd.name she put in a ternary operator looking for read only, yes or no
			// while _findnext finds a different file
			}//end outer if
		}while(_findnext(hFile, & fd) == 0);
		
		_findclose(hFile);//close the file handle
	}//end if-else

}//end function

int grep()
{
string infile;
string search;
int searchCounter;
ifstream inStream;
inStream.open(infile);
int found;
while(!inStream.eof())
{ 
string x;
getline(inStream, x, '\n');
	
	//performing multi-search in each line so we can get the number 
	for(found = x.find(search, 0); found != string::npos; found = x.find(search, found))
	{
	searchCounter++;
	found++;
	}
}//end while loop 

inStream.close();

return searchCounter;

}//end grep function



int main(int argc, char* argv[])
{
//declaring some of the necessary variables for the program
//the vector will be used to contain each line of the input file in each element, search counter will count number of times search term appears
string folder = argv[argc];
string searchTerm = argv[argc-1];

if(argc == 7)
{
string switchOne = argv[2];
string switchTwo = argv[3];
string switchThree = argv[4];
string switchFour = argv[5];
}

cout << argv[0] << endl;



	return 0;
}