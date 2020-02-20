/**
 * Program Name:
 * Program Purpose:
 * Coder: Nick McRae, 0612749
 * Date: Apr 11, 2012
 */

public class SuperClass
{
	private int height;
	private int width;
	
	SuperClass(int h, int w)
	{
		h = height;
		w = width;
	}
	
	public double findArea(int h, int w)
	{
		double area = h * w;
		return area;
	}

	public int getHeight()
	{
		return height;
	}

	public void setHeight(int height)
	{
		this.height = height;
	}

	public int getWidth()
	{
		return width;
	}

	public void setWidth(int width)
	{
		this.width = width;
	}
	
	
	
}//end class