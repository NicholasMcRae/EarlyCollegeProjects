/**
 * Program Name:
 * Program Purpose: shows the lazy-coder's way of claiming or acknowledging or confessing to the jvm that your code
 * 									could throw a checked exception
 * Coder: Nick McRae, 0612749
 * Date: Mar 7, 2012
 */

import java.io.*;
public class FileBuilder
{

	public static void main(String[] args)throws IOException
	{
		// create  a file object
		File fileOne = new File("C:\\temp55");
		
		System.out.println("the canonical path to directory " + fileOne + " is " + fileOne.getCanonicalPath());

	}
}//end main}
//end class