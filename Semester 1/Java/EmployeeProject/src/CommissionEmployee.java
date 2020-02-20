/**
 * Program Name: CommissionEmployee.java
 * Program Purpose: to simulate a commissioned employee
 * Coder: Nick McRae, 0612749
 * Date: Feb 28, 2012
 */

public class CommissionEmployee extends Employee
{
	private double commRate;
	private double salesMade;
	
	//declaring constructor method
	CommissionEmployee(String firstName, String lastName, String sinNumber, double commRate, double salesMade)
	{
		super("Nick", "McRae", "123 456 789");
		setFirstName(firstName);
		setLastName(lastName);
		setSinNumber(sinNumber);
		this.commRate = commRate;
		this.salesMade = salesMade;
	}

	public double getCommRate()
	{
		return commRate;
	}

	public void setCommRate(double commRate)
	{
		this.commRate = commRate;
	}

	public double getSalesMade()
	{
		return salesMade;
	}

	public void setSalesMade(double salesMade)
	{
		this.salesMade = salesMade;
	}
	
	//Method Name: getEmployeeDetails()
	//Method Purpose: print out the details of an employee
	//Parameters: none
	//Returns: String
	
	public String getEmployeeDetails()
	{
		String concatenatedInfo;
		concatenatedInfo = "Employee: 2\n";
		concatenatedInfo += getFirstName();
		concatenatedInfo += ", ";
		concatenatedInfo += getLastName();
		concatenatedInfo += "\n";
		concatenatedInfo += getSinNumber();
		concatenatedInfo += "\nThis is a commission employee.\n";
		return concatenatedInfo;
	}
	
	//Method Name: getEarnings()
	//Method Purpose: Return the salary of a commission employee
	//Parameters: None
	//Return: double salary
	
	public double getEarnings()
	{
		double commEarnings = getSalesMade() * getCommRate();
		return commEarnings;
	}
	
}//end class