
public class TesterClass
{

	public static void main(String[] args)
	{
		
		SuperClass someStuff = new SuperClass(2, 3);
		
		someStuff.setHeight(4);
		int someHeight = someStuff.getHeight();
		someStuff.setWidth(3);
		int someWidth = someStuff.getWidth();
		
		double area = someStuff.findArea(someHeight, someWidth);
		
		System.out.println(area);

	}
}//end main}
//end class