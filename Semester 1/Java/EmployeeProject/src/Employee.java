/**
 * Program Name: Employee.java
 * Program Purpose: An Employee superclass that declares a few variables, getters/setters, and an abstract method
 * Coder: Nick McRae, 0612749
 * Date: Feb 28, 2012
 */

public abstract class Employee
{
	//declaring private String variables to identify employees
	private String firstName;
	private String lastName;
	private String sinNumber;
	
	//Declaring constructor method
	Employee(String firstName, String lastName, String sinNumber)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.sinNumber = sinNumber;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getSinNumber()
	{
		return sinNumber;
	}

	public void setSinNumber(String sinNumber)
	{
		this.sinNumber = sinNumber;
	}
	
	//Method Name: getEmployeeDetails()
	//Method Purpose: print out the details of an employee
	//Parameters: none
	//Returns: String
	
	public String getEmployeeDetails()
	{
		String concatenatedInfo = getFirstName();
		concatenatedInfo += ", ";
		concatenatedInfo += getLastName();
		concatenatedInfo += ", ";
		concatenatedInfo +=  getSinNumber();
		
		return concatenatedInfo;
	}
	
	//Method Name: getEarnings()
	//Method Purpose: Force subclasses to produce a getEarnings() method
	//Parameters: none
	//Returns: double
	
	public abstract double getEarnings();
	
}//end class