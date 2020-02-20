/**
 * Program Name: SalariedEmployee
 * Program Purpose: Specify details for salaried employees
 * Coder: Nick McRae, 0612749
 * Date: Feb 28, 2012
 */

public class SalariedEmployee extends Employee
{
	private double salary;
	
	//declaring constructor method
	SalariedEmployee(String firstName, String lastName, String sinNumber, double salary)
	{
		super("Nick", "McRae", "123 456 789");
		setFirstName(firstName);
		setLastName(lastName);
		setSinNumber(sinNumber);
		this.salary = salary;
	}

	public double getSalary()
	{
		return salary;
	}

	public void setSalary(double salary)
	{
		this.salary = salary;
	}
	
	//Method Name: getEmployeeDetails()
	//Method Purpose: print out the details of an employee
	//Parameters: none
	//Returns: String
	
	public String getEmployeeDetails()
	{
		String concatenatedInfo;
		concatenatedInfo = "Employee: 1\n";
		concatenatedInfo += getFirstName();
		concatenatedInfo += ", ";
		concatenatedInfo += getLastName();
		concatenatedInfo += "\n";
		concatenatedInfo += getSinNumber();
		concatenatedInfo += "\nThis is a salaried employee.\n";
		return concatenatedInfo;
	}
	
	//Method Name: getEarnings()
	//Method Purpose: Return the salary of a salaried employee
	//Parameters: None
	//Return: double salary
	
	public double getEarnings()
	{
		return getSalary();
	}
	
	
	
}//end class