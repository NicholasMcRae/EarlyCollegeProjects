//Program name: rgrep.exe
//Program purpose: to parse through directories to find search terms, and to print out entries and summarize everything that's found
//Coder: Nick McRae
//Date: Apr. 12th / 2012
//*******************NOTE: The majority of this project was done before the new switch procedure was implemented.

#include <iostream>
#include <fstream>
#include <vector>
#include <map>
#include <string>
#include <regex>
#include <ctime>
#include <io.h>
#include <cstdlib>
#include <utility>
#include <sstream>
#include <algorithm>
#include <iomanip>

//Program outline and index
//Line 54: sortVectorSize function - overloaded sort function that sorts a vector of vectors
//Line 64: grep function - searches files for search term and produces a vector to populate an outer vector
//         that will output search term lines, also returns an int value to be used in the scan functions
//Line 145: quietScan function - scans directories but doesn't pass in a container vector for verbose output
//Line 223: scan function - produces verbose output and sorts results with sortVector function
//Line 288: defaultRecursiveScan - recurses, doesn't sort, verbose
//Line 369: nonRecursiveScan - non-recursive, sorts Vector, verbose
//Line 442: defaultNonRecursiveScan - non-recursive, doesn't sort
//Line 509: main - associates switches with booleans and produces if statements for all combinations of switches

//PROGRAM DESCRIPTION
//*******************
//The grep function searches for the search term in each file, tabulating the results
//to be returned to an integer variable. Each time it is called, if it finds a search term, it will also
//populate a vector by reference with lines containing the search term. The end goal of populating this vector is to create a vector of vectors
//for the verbose results, which can be sorted appropriately.

//The grep function is nested inside each of the different scan functions. The findings of the grep inside the
//scan functions will allow us to populate an occurrences map by reference. These maps will be used to produce the summary
//table for each combination of switches.

//The different scan functions allow us to account for the different switch combinations, and keep all the code easily
//recognizable and distinct.








using namespace std;

//Function Name: sortVectorSize
//Accepts: two vectors
//Returns: boolean
//Purpose: boolean sort function which will sort vector of vectors based on vector size

bool sortVectorSize(vector<string>& i, vector<string>& j)
{
	return i.size() < j.size();
}

//Function Name: grep
//Accepts: folder name to search, search term, and vector by reference to populate
//Returns: int, total number of occurrences of search term found in file
//Purpose: this function serves two purposes, the first is to tabulate the number of search terms found in each file, the second purpose is to
//         populate a vector with lines where a search term was found, and then populate an outer vector with these vectors.

int grep(string fileName, string search, vector <vector<string>> &vectorContainer)
{
string inFile = fileName;
int searchCounter = 0;
ifstream inStream;
inStream.open(inFile);
int lineNumber = 0;
string containerString = "";
vector <string> containerVec;
vector <string> containerVecTwo;

//while the file is open search it
while(!inStream.eof())
{ 	
	string x = "";
	getline(inStream, x, '\n');
	lineNumber++;
	int found = 0;
	int counterContainer = 0;
	int counter = 0;
	
		//performing multi-search in each line so we can get the number of terms in each line, as well as tabulate the total on the file
		for(found = x.find(search, 0); found != string::npos; found = x.find(search, found))
		{
		searchCounter++;
		found++;
		counterContainer++;
			//if a term is found set counter to found so we can use it to ensure we are populating our vector only with lines that contain a search term
			if(found != string::npos)
			{
				counter = counterContainer;
			}//end inner if
		}//end for

		//if a line contains a search term put it in containerVecTwo, once we fill containerVecTwo we are going to put it in containerVec
		if(counter > 0)
		{
			containerString = x;
			stringstream z;
			z << lineNumber << ": "<< "[" << (counter) << "]: " << containerString; 
			containerVecTwo.push_back(z.str());
		}
			
}//end while loop 

		//if any search terms have been found in the file we are going to populate containerVec with the filename in the first element, and containerVecTwo in the
		//remaining elements
		if(searchCounter > 0)
		{
		stringstream a;
		a << inFile << ": " << searchCounter;
		//used to creating spacing
		containerVec.push_back("");
		//file title plus total occurrences
		containerVec.push_back(a.str());

			//populate the rest of the vector with all of the lines containing search terms
			for(unsigned int i=0; i < containerVecTwo.size(); ++i)
			{
			containerVec.push_back(containerVecTwo[i]);
			}
		
		//push back containerVec into a vector that will store all of the vectors
		vectorContainer.push_back(containerVec);
		}

//close the instream
inStream.close();

return searchCounter;

}//end grep function



//Function Name: quietScan
//Accepts: filespec(extension), path to be searched, search term for grep, two pass by reference maps to be populated and printed out after function call
//Returns: nothing
//Purpose: scanning files and doesn't pass in a vectorContainer to print out grep results, only tabulates search term occurrences and number of file types

void quietScan(string filespec, string path, string searchTerm, map <string, int> &fileTypeMap, map <string, int> &occurrencesMap)
{
	string fileExtension;
	vector <vector<string>> vectorContainer;
	int files = 0;
	int occurrences = 0;
	intptr_t hFile;         // File handler
	struct _finddata_t fd;  // file data
	string str2 = "";
	string findPath = path + filespec;
	hFile = _findfirst( findPath.c_str()  , &fd );
	if(hFile == -1L)
	{
		cout << "No " << " *.* " << "files in the current dir\n";
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
					// recursively call scan
					// remember path always wants to end 
					string str = path + fd.name + "\\";
					//string str2 = path + fd.name + " \ ";
					quietScan(filespec, str, searchTerm, fileTypeMap, occurrencesMap);
				}
				else
				{
					
					//here I want to identify the file type and the number of occurrences
					//finding the file extension using the rfind function
					 string fileName = fd.name;
					 int found = fileName.rfind(".");
					 if(found != string::npos)
					 {
					 fileExtension = fileName.substr (found,10);
					 }
					 else
					 {
					 fileExtension = "No ext";
					 }
					 string innerSearchTerm;
					 str2 = path + fd.name;
					 int numberTerms = grep(str2, searchTerm, vectorContainer);

					 //populating two maps, fileTypeMap and occurrencesMap
					fileTypeMap[fileExtension] += 1;
					occurrencesMap[fileExtension] += numberTerms;
																				
				}//end innermost if
			// while _findnext finds a file
			}//end middle if
		} while(_findnext(hFile, & fd) == 0);
	
	}//end outer if
		
	_findclose(hFile);  // close the file handle

}//end function




//Function Name: scan
//Accepts: filespec(extension), path to be searched, search term for grep, two pass by reference maps to be populated and printed out after function call,
//		   pass by reference vector container
//Returns: nothing
//Purpose: scanning files, populating maps, and passes in a vectorContainer to print out grep results, only tabulates search term occurrences and number of file types

void scan(string filespec, string path, string searchTerm, map <string, int> &fileTypeMap, map <string, int> &occurrencesMap, vector <vector<string>> &vectorContainer)
{
	string fileExtension;
	int totalFileTypes = 0;
	int totalFiles = 0;
	int totalOccurrences = 0;
	string innerSearchTerm = searchTerm;
	intptr_t hFile;         // File handler
	struct _finddata_t fd;  // file data
	string str2 = "";
	string findPath = path + filespec;
	hFile = _findfirst( findPath.c_str()  , &fd );
	if(hFile == -1L)
	{
		cout << "No " << " *.* " << "files in the current dir\n";
	}
	else
	{
		do
		{
			if((fd.name != string(".")) && (fd.name != string("..")))
			{
				// if the fd found is a directory
				if(fd.attrib & _A_SUBDIR)
				{
					// recursively call scan
					string str = path + fd.name + "\\";
					scan(filespec, str, innerSearchTerm, fileTypeMap, occurrencesMap, vectorContainer);
				}
				else
				{
					
					//here I want to identify the file type and the number of occurrences
					
					 string fileName = fd.name;

					 int found = fileName.rfind(".");
					 if(found != string::npos)
					 {
					 fileExtension = fileName.substr (found,10);
					 }
					 else
					 {
					 fileExtension = "No ext";
					 }
					 string innerSearchTerm;
					 str2 = path + fd.name;
					 int numberTerms = grep(str2, searchTerm, vectorContainer);

					fileTypeMap[fileExtension] += 1;
					occurrencesMap[fileExtension] += numberTerms;
														
				}
			
			// while _findnext finds a file
			}
		} while(_findnext(hFile, & fd) == 0);
	}
		_findclose(hFile);  // close the file handle
	
		             sort(vectorContainer.begin(), vectorContainer.end(), sortVectorSize);
						 

}//end function

//Function Name: defaultRecursiveScan
//Accepts: filespec(extension), path to be searched, search term for grep, two pass by reference maps to be populated and printed out after function call
//Returns: nothing
//Purpose: scanning files and passes in a vectorContainer to print out grep results but doesn't sort it, also tabulates search term occurrences and number of file types

void defaultRecursiveScan(string filespec, string path, string searchTerm, map <string, int> &fileTypeMap, map <string, int> &occurrencesMap, vector <vector<string>> &vectorContainer)
{
	string fileExtension;
	int totalFileTypes = 0;
	int totalFiles = 0;
	int totalOccurrences = 0;
	string innerSearchTerm = searchTerm;
	intptr_t hFile;         // File handler
	struct _finddata_t fd;  // file data
	string str2 = "";
	string findPath = path + filespec;
	hFile = _findfirst( findPath.c_str()  , &fd );
	if(hFile == -1L)
	{
		cout << "No " << " *.* " << "files in the current dir\n";
	}
	else
	{
		do
		{
			if((fd.name != string(".")) && (fd.name != string("..")))
			{
			//if the fd found is a directory
			// if the fd found is a directory
				if(fd.attrib & _A_SUBDIR)
				{
					// recursively call scan
					// remember path always wants to end 
					string str = path + fd.name + "\\";
					//string str2 = path + fd.name + " \ ";
					scan(filespec, str, innerSearchTerm, fileTypeMap, occurrencesMap, vectorContainer);
					
				}
				else
				{
					
					//here I want to identify the file type and the number of occurrences
					
					 string fileName = fd.name;

					 int found = fileName.rfind(".");
					 if(found != string::npos)
					 {
					 fileExtension = fileName.substr (found,10);
					 }
					 else
					 {
					 fileExtension = "No ext";
					 }
					 string innerSearchTerm;
					 str2 = path + fd.name;
					 int numberTerms = grep(str2, searchTerm, vectorContainer);

					fileTypeMap[fileExtension] += 1;
					occurrencesMap[fileExtension] += numberTerms;

													
				}
			
			// while _findnext finds a file
			}
		} while(_findnext(hFile, & fd) == 0);
	}
		_findclose(hFile);  // close the file handle
	
		 

}//end function


//Function Name: nonRecursiveScan
//Accepts: filespec(extension), path to be searched, search term for grep, two pass by reference maps to be populated and printed out after function call
//Returns: nothing
//Purpose: scanning files and passes in a vectorContainer to print out grep results, also non-recursive, also tabulates search term occurrences and number of file types


void nonRecursiveScan(string filespec, string path, string searchTerm, map <string, int> &fileTypeMap, map <string, int> &occurrencesMap, vector <vector<string>> &vectorContainer)
{
	string fileExtension;
	int totalFileTypes = 0;
	int totalFiles = 0;
	int totalOccurrences = 0;
	string innerSearchTerm = searchTerm;
	intptr_t hFile;         // File handler
	struct _finddata_t fd;  // file data
	string str2 = "";
	string findPath = path + filespec;
	hFile = _findfirst( findPath.c_str()  , &fd );
	if(hFile == -1L)
	{
		cout << "No " << " *.* " << "files in the current dir\n";
	}
	else
	{
		do
		{
			if((fd.name != string(".")) && (fd.name != string("..")))
			{
			//if the fd found is a directory
			// if the fd found is a directory
				if(fd.attrib & _A_SUBDIR)
				{
					// recursively call scan
					// remember path always wants to end 
					string str = path + fd.name + "\\";
					//string str2 = path + fd.name + " \ ";
				}
				else
				{
					
					//here I want to identify the file type and the number of occurrences
					
					 string fileName = fd.name;

					 int found = fileName.rfind(".");
					 if(found != string::npos)
					 {
					 fileExtension = fileName.substr (found,10);
					 }
					 else
					 {
					 fileExtension = "No ext";
					 }
					 string innerSearchTerm;
					 str2 = path + fd.name;
					 int numberTerms = grep(str2, searchTerm, vectorContainer);

					fileTypeMap[fileExtension] += 1;
					occurrencesMap[fileExtension] += numberTerms;
													
				}
			
			// while _findnext finds a file
			}
		} while(_findnext(hFile, & fd) == 0);
	}
		_findclose(hFile);  // close the file handle
	

		             sort(vectorContainer.begin(), vectorContainer.end(), sortVectorSize);
										 

}//end function

//Function Name: defaultNonRecursiveScan
//Accepts: filespec(extension), path to be searched, search term for grep, two pass by reference maps to be populated and printed out after function call
//Returns: nothing
//Purpose: scanning files and passes in a vectorContainer to print out grep results but doesn't sort it, also tabulates search term occurrences and number of file types

void defaultNonRecursiveScan(string filespec, string path, string searchTerm, map <string, int> &fileTypeMap, map <string, int> &occurrencesMap, vector <vector<string>> &vectorContainer)
{
	string fileExtension;
	int totalFileTypes = 0;
	int totalFiles = 0;
	int totalOccurrences = 0;
	string innerSearchTerm = searchTerm;
	intptr_t hFile;         // File handler
	struct _finddata_t fd;  // file data
	string str2 = "";
	string findPath = path + filespec;
	hFile = _findfirst( findPath.c_str()  , &fd );
	if(hFile == -1L)
	{
		cout << "No " << " *.* " << "files in the current dir\n";
	}
	else
	{
		do
		{
			if((fd.name != string(".")) && (fd.name != string("..")))
			{
			//if the fd found is a directory
			// if the fd found is a directory
				if(fd.attrib & _A_SUBDIR)
				{
					// remember path always wants to end 
					string str = path + fd.name + "\\";
										
				}
				else
				{
					
					//here I want to identify the file type and the number of occurrences
					
					 string fileName = fd.name;

					 int found = fileName.rfind(".");
					 if(found != string::npos)
					 {
					 fileExtension = fileName.substr (found,10);
					 }
					 else
					 {
					 fileExtension = "No ext";
					 }
					 string innerSearchTerm;
					 str2 = path + fd.name;
					 int numberTerms = grep(str2, searchTerm, vectorContainer);

					fileTypeMap[fileExtension] += 1;
					occurrencesMap[fileExtension] += numberTerms;

													
				}
			
			// while _findnext finds a file
			}
		} while(_findnext(hFile, & fd) == 0);
	}
		_findclose(hFile);  // close the file handle
	
		 

}//end function


int main(int argc, char* argv[])
{
//declaring some of the necessary variables for the program
//ints to tabulate the number of files, filetypes, and occurrences of the search term
//two maps to pass into the scanning functions and to output afterward
//vectors to be populated in order to print out the summary table
//strings to hold the data passed in from the command line
//booleans to verify that certain switches have been entered

int totalFiles = 0;
int totalOccurrences = 0;
int totalFileTypes = 0;
map <string, int> fileTypeMap;
map <string, int> occurrencesMap;
vector <vector<string>> vectorContainer;
vector <string> associationVectorOne;
vector <int> associationVectorTwo;
vector <int> associationVectorThree;
string folder = argv[argc-1];
string searchTerm = argv[argc-2];
string fileSpec = "*.*";
bool rSwitch = false;
bool oSwitch = false;
bool qSwitch = false;
bool theRSwitch = false;
string switchOne;
string switchTwo;
string switchThree;
string switchFour;


//assigning c-string variables to switch strings depending on the number of arguments
if(argc == 7)
{
switchOne = argv[argc - 3];
switchTwo = argv[argc - 4];
switchThree = argv[argc - 5];
switchFour = argv[argc - 6];
}
if(argc == 6)
{
switchOne = argv[argc - 3];
switchTwo = argv[argc - 4];
switchThree = argv[argc - 5];
}
if(argc == 5)
{
switchOne = argv[argc - 3];
switchTwo = argv[argc - 4];
}
if(argc == 4)
{
switchOne = argv[argc - 3];
}

//changing booleans to true if switches are found in the strings
for(int i=0; i < argc; ++i)
{
	if(switchOne == "-r" || switchTwo == "-r" || switchThree == "-r" || switchFour == "-r")
	{
	rSwitch = true;
	}

	if(switchOne == "-o" || switchTwo == "-o" || switchThree == "-o" || switchFour == "-o")
	{
	oSwitch = true;
	}

	if(switchOne == "-q" || switchTwo == "-q" || switchThree == "-q" || switchFour == "-q")
	{
	qSwitch = true;
	}

	if(switchOne == "-R" || switchTwo == "-R" || switchThree == "-R" || switchFour == "-R")
	{
	theRSwitch = true;
	}
}

//if all the switches are entered process this code


//if all switches are entered we process recursively and print out in quiet mode
if(rSwitch && oSwitch && qSwitch && theRSwitch)
{

//call quietScan function
quietScan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap);
	

	//populate two vectors with map values and tally the total occurrences of the search term for the summary table
	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	{
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	//populate 
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
	
return 0;
}

//if these three switches are pressed process this code
if(rSwitch && oSwitch && qSwitch)
{

quietScan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap);
	

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	{
		 associationVectorOne.push_back(it->first);
		associationVectorTwo.push_back(it->second);
		totalOccurrences += it->second;
	} 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	{
		 associationVectorThree.push_back(it->second);
		totalFiles += it->second;;
	}

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
	
return 0;

}

if(rSwitch && oSwitch && theRSwitch)
{
scan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

reverse(vectorContainer.begin(), vectorContainer.end());

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}

	}

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}


//if these three switches are entered
if(rSwitch && qSwitch && theRSwitch)
{
quietScan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap);

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}//end if


if(oSwitch && qSwitch && theRSwitch)
{
nonRecursiveScan(fileSpec, folder,searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}//end if

//if two switches are pressed
if(oSwitch && qSwitch)
{
nonRecursiveScan(fileSpec, folder,searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}//end if

if(oSwitch && rSwitch)
{
scan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}

	}

	 for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}

if(oSwitch && theRSwitch)
{
nonRecursiveScan(fileSpec, folder,searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

reverse(vectorContainer.begin(), vectorContainer.end());

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}

	}

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
return 0;
}

if(qSwitch && rSwitch)
{
quietScan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap);
	

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
return 0;
}

if(qSwitch && theRSwitch)
{
nonRecursiveScan(fileSpec, folder,searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
return 0;
}

if(rSwitch && theRSwitch)
{
scan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

reverse(vectorContainer.begin(), vectorContainer.end());

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}

	}

	 for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}

//if only one switch is pressed

if(rSwitch)
{
defaultRecursiveScan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}

	}

	 for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
return 0;
}

if(theRSwitch)
{
defaultNonRecursiveScan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

reverse(vectorContainer.begin(), vectorContainer.end());

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}

	}

	 for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}

if(qSwitch)
{
nonRecursiveScan(fileSpec, folder,searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
return 0;
}

if(oSwitch)
{
nonRecursiveScan(fileSpec, folder, searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}

	}

	 for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;

return 0;
}

if(!(rSwitch && oSwitch && qSwitch && theRSwitch))
{
	defaultNonRecursiveScan(fileSpec, folder,searchTerm, fileTypeMap, occurrencesMap, vectorContainer);

	for(unsigned int i = 0; i < vectorContainer.size(); ++i)
	{
		for(unsigned int j = 0; j < vectorContainer[i].size(); ++j)
		{
			cout << vectorContainer[i][j] << endl;
		}
	}


	 for(map<string, int>::iterator it = occurrencesMap.begin(); it != occurrencesMap.end(); ++it)
	 {
		 associationVectorOne.push_back(it->first);
		 associationVectorTwo.push_back(it->second);
		 totalOccurrences += it->second;
	 } 
	
	for(map<string, int>::iterator it = fileTypeMap.begin(); it != fileTypeMap.end(); ++it)
	 {
		 associationVectorThree.push_back(it->second);
		 totalFiles += it->second;;
	 }

cout << "File   || Number || Occurrences" << endl;
cout << "===============================" << endl;

	for(unsigned int i=0; i < fileTypeMap.size(); i++)
	{
		cout << setw(7) << associationVectorOne[i] << setw(9) << associationVectorThree[i] << setw(12) << associationVectorTwo[i] << endl;
	}
	
cout << "===============================" << endl;
cout << setw(7) << fileTypeMap.size() << setw(9) << totalFiles << setw(12) << totalOccurrences;
return 0;	
}



	return 0;
}

