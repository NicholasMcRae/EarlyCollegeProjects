
public class SubClass extends SuperClass
{
	private String color;
	private String something;
	
	SubClass(String c, String s)
	{
		super(6, 6.0);
		
		color = c;
		something = s;
	}

	public String getColor()
	{
		return color;
	}

	public void setColor(String color)
	{
		this.color = color;
	}

	public String getSomething()
	{
		return something;
	}

	public void setSomething(String something)
	{
		this.something = something;
	}
	
	
	
	
}//end class