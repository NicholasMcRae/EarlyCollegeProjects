
public class TesterClass
{

	public static void main(String[] args)
	{
		SuperClass classOne = new SuperClass(4, 4.0);
		
		int someVariable = classOne.getTestInt();
		
		System.out.println(someVariable);
		
		SubClass classTwo = new SubClass("blue", "something");
		
		String someVariableTwo = classTwo.getSomething();
		
		System.out.println(someVariableTwo);
		

	}
}
//end class