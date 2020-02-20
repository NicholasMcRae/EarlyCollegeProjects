//Nick McRae
// Learning the _findFirst and _findNext to parse a directory

#include <iostream>
#include <iomanip>
#include <ctime>
#include <string>
#include <io.h> //used for _findFirst and _findNext

using namespace std;

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
			
			}//end outer if
		}while(_findnext(hFile, & fd) == 0);
		
		_findclose(hFile);//close the file handle
	}

	}

	int main()
{

	scan("*.*", "C:\\CPlusPlus\\"); //remember you need to backslash in order to handle the literal backslash in the string
	return 0;
}