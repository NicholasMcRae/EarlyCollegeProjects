//purpose: to test the truncate to two places method
//program: MyToolboxTester4.java

public class MyToolboxTester4
{

	public static void main(String[] args)
	{
		// test value to be sent to method
		double numOne = 23.6742;
		
		System.out.println("Sending this value: " + numOne + " to the truncate to the truncateToTwoPlaces() method");
		
		double truncatedNum = MyToolbox.truncateToTwoPlaces(numOne);
		
		System.out.println("Value of truncatedNum is " + truncatedNum);

	}
}//end main}
//end class