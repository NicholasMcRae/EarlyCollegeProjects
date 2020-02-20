/**
 * Program Name: SalPlusCommEmployee.java
 * Program Purpose: to simulate a salary plus commissioned employee
 * Coder: Nick McRae, 0612749
 * Date: Feb 28, 2012
 */

public class SalPlusCommEmployee extends CommissionEmployee
{
	private double baseSalary;
	
	SalPlusCommEmployee(String firstName, String lastName, String sinNumber, double salesMade, double commRate, double baseSalary)
	{
		super("Nick", "McRae", "123 456 789", 0.10, 100.0);
		setFirstName(firstName);
		setLastName(lastName);
		setSinNumber(sinNumber);
		setSalesMade(salesMade);
		setCommRate(commRate);
		this.baseSalary = baseSalary;
	}

	public double getBaseSalary()
	{
		return baseSalary;
	}

	public void setBaseSalary(double baseSalary)
	{
		this.baseSalary = baseSalary;
	}
	
	//Method Name: getEmployeeDetails()
	//Method Purpose: print out the details of an employee
	//Parameters: none
	//Returns: String
	
	public String getEmployeeDetails()
	{
		String concatenatedInfo;
		concatenatedInfo = "Employee: 3\n";
		concatenatedInfo += getFirstName();
		concatenatedInfo += ", ";
		concatenatedInfo += getLastName();
		concatenatedInfo += "\n";
		concatenatedInfo += getSinNumber();
		concatenatedInfo += "\nThis is a commmission employee who also gets a base salary.\n";
		return concatenatedInfo;
	}
	
	//Method Name: getEarnings()
	//Method Purpose: Return the salary of a salary plus commission employee
	//Parameters: None
	//Return: double salary
	
	public double getEarnings()
	{
		double commEarnings = (getSalesMade() * getCommRate()) + getBaseSalary();
		return commEarnings;
	}
	
}//end class