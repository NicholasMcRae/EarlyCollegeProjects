/**
 * Program Name: MountieRecruiter.java
 * Program Purpose: shows use of boolean flag variables and some logical
 * operators to determine if a person qualifies for the mounted police
 * Coder: Nick McRae, 0612749
 * Date: Oct 7, 2011
 */
import javax.swing.JOptionPane;
public class MountieRecruiter
{

	public static void main(String[] args)
	{
		// pseudo-code
		
		/* Pseudo code
		 * To qualify for recruitment, person must have a minimum height of 150 cm and a minimum 
		 * weight of 50 kg
		 * 1) welcome user to the recruitment app
		 * 2) ask user to enter height and store in a variable
		 * 3) Ask user to enter weight and store it
		 * 4) Parse weight and height to numerics
		 * 5) Create boolean flag variables for height and weight
		 * 6) assign values to flags based on conditions
		 * 7) evaluate user qualifications using boolean AND operator and advise user if they qualify
		 */
		
		//welcome user
		JOptionPane.showMessageDialog(null, "Welcome to the program bitch");
		
		//ask user to enter height and weight and store them in variables
		
		String heightString = JOptionPane.showInputDialog("Enter your height in centimetres");
		
		String weightString = JOptionPane.showInputDialog("Enter your mass in kilograms");
		
		//parse height and weight to numerics
		double height = Double.parseDouble(heightString);
		double weight = Double.parseDouble(weightString);
		
		//create boolean flag variables for height and weight and initialize each one to false
		// initialized variables so default is false, don't need an else statement
		
		boolean isTallEnough = false;
		boolean isHeavyEnough = false;
		
		//assign values to flags based on qualification conditions
		
		if (height >= 150.0)
		{
			isTallEnough = true;
		}
		
		if (weight >= 50.0)
		{
			isHeavyEnough = true;
		}

		//evaluate user qualifications using boolean AND operator
		if(isTallEnough && isHeavyEnough)
		{
			//if both are true run this
			JOptionPane.showMessageDialog(null, "Congratulations, kid, you qualify! Good luck!");
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Sorry you lose");
		}
		
		//tell user why they failed
		if(isTallEnough == false && isHeavyEnough == false)
		{
			JOptionPane.showMessageDialog(null, "You are too short and too light :(");
		}
	}
}//end main}
//end class