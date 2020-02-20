/**
 * Program Name:N_McRae_TriangleTest1
 * Program Purpose: To test the triangle class.
 * Coder: Nick McRae, 0612749
 * Date: Feb 1, 2012
 */

public class N_McRae_TriangleTest1
{

	public static void main(String[] args)
	{
		System.out.println("This program will test all of the methods of the Triangle class");
		
		N_McRae_Triangle triangle1 = new N_McRae_Triangle();
		
		System.out.println("For triangle1 length of base is..." + triangle1.getBase() );
		System.out.println("For triangle1 length of side2 is..." + triangle1.getSide2());
		System.out.println("For triangle1 length of side3 is..." + triangle1.getSide3());
		System.out.println("For triangle1 color is..." + triangle1.getColor());
		
		N_McRae_Triangle triangle2 = new N_McRae_Triangle(3.0, 4.0, 5.0, "red");
		
		System.out.println("\nFor triangle2 length of base is..." + triangle2.getBase() );
		System.out.println("For triangle2 length of side2 is..." + triangle2.getSide2());
		System.out.println("For triangle2 length of side3 is..." + triangle2.getSide3());
		System.out.println("For triangle2 color is..." + triangle2.getColor());
		
		triangle1.setBase(15.5);
		triangle1.setSide2(15.5);
		triangle1.setSide3(15.5);
		
		System.out.println("\nFor triangle1 length of base is..." + triangle1.getBase() );
		System.out.println("For triangle1 length of side2 is..." + triangle1.getSide2());
		System.out.println("For triangle1 length of side3 is..." + triangle1.getSide3());
		System.out.println("For triangle1 color is..." + triangle1.getColor());
		
		System.out.println("\nThe perimeter of triangle1 is..." + triangle1.calculatePerimeter());
		System.out.println("The perimeter of triangle2 is..." + triangle2.calculatePerimeter());

	}
}//end main}
//end class