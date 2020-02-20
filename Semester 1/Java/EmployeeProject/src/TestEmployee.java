/**
 * Program Name: TestEmployee.java
 * Program Purpose: To test the classes that we have created
 * Coder: Nick McRae, 0612749
 * Date: Feb 28, 2012
 */

public class TestEmployee
{

	public static void main(String[] args)
	{
		//initializing array
		Employee employeeArray [];
		employeeArray = new Employee[3];
		
		//initializing objects within the array		
		employeeArray[0] =  new SalariedEmployee("Andrea", "Doroshenko", "111-111-111", 2400);
		employeeArray[1] =  new CommissionEmployee("Nick", "McRae", "222-222-222", 0.10, 50000);
		employeeArray[2] =  new SalPlusCommEmployee("Dan", "Mills", "333-333-333", 0, 0.05, 500);
		
		//calling getEmployeeDetails() method from each object
		for(int i = 0; i < 3; ++i)
		{
			System.out.println(employeeArray[i].getEmployeeDetails());
		}
		
		//calling getLastName and getEarnings from each object
		for(int i = 0; i < 3; ++i)
		{
			System.out.println("For employee " + employeeArray[i].getLastName() + " earnings are " + employeeArray[i].getEarnings());
		}
		
		//declaring three new objects from each subclass
		SalariedEmployee doroshenko =  new SalariedEmployee("Andrea", "Doroshenko", "111-111-111", 2400);
		CommissionEmployee mcrae =  new CommissionEmployee("Nick", "McRae", "222-222-222", 0.10, 50000);
		SalPlusCommEmployee mills =  new SalPlusCommEmployee("Dan", "Mills", "333-333-333", 0, 0.05, 500);
		
		//using setters to change information about each employee
		doroshenko.setSalary(3700);
		doroshenko.setLastName("Saint-Doroshenko");
		mcrae.setSalesMade(100000);
		mcrae.setCommRate(0.15);
		mcrae.setSinNumber("777-777-777");
		mills.setSalesMade(30000);
		mills.setBaseSalary(200);
		
		//calling the get earnings methods again
		System.out.println("\nUpdating Employee Information..\n");
		System.out.println("For employee " + doroshenko.getLastName() + " earnings are " + doroshenko.getEarnings());
		System.out.println("For employee " + mcrae.getLastName() + " earnings are " + mcrae.getEarnings());
		System.out.println("For employee " + mills.getLastName() + " earnings are " + mills.getEarnings() + "\n");
		
		//calling the getEmployeeDetails() method from the new objects
		System.out.println(doroshenko.getEmployeeDetails());
		System.out.println(mcrae.getEmployeeDetails());
		System.out.println(mills.getEmployeeDetails());
	}//end main
	
	
}//end class