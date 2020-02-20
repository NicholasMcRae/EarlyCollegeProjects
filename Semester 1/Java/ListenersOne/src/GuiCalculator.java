/**
 * Program Name:
 * Program Purpose: a simple GUI app to do the four basic math functions on any two values passed in
 * Coder: Nick McRae, 0612749
 * Date: Mar 28, 2012
 */
import java.awt.*;
import java.awt.event.*;import javax.swing.*;

public class GuiCalculator extends JFrame
{

	//declare variables in class scope that need class wide scope
	JButton addButton, subtractButton, multiplyButton, divideButton, clearButton;
	JTextField firstValueField, secondValueField, resultField;
	//constructor
	public GuiCalculator()
	{
		super("Simple GUI Calculator App");
		this.setSize(400,300);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		//last line
		//this.pack();
		
		//create the subcontainers, 2 JPanels
		JPanel topPanel = new JPanel();
		topPanel.setBackground(Color.BLUE);
		topPanel.setLayout(new GridLayout(3,2,10,10));
		
		//add it to the JFrame
		this.add(topPanel, BorderLayout.CENTER);
		
		//create bottomPanel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(Color.RED);
		bottomPanel.setLayout(new FlowLayout());
		
		
		//add it to the JFrame south zone
		this.add(bottomPanel, BorderLayout.SOUTH);
		
		//create buttons and add to bottom panel
		
		//create buttons and add to bottom panel
		
		addButton = new JButton("+");
		subtractButton = new JButton("-");
		multiplyButton = new JButton("x");
		divideButton = new JButton("/");
		
		bottomPanel.add(addButton);
		bottomPanel.add(subtractButton);
		bottomPanel.add(multiplyButton);
		bottomPanel.add(divideButton);
		
		//add components to top panel
		
		//create the labels and textFields
		JLabel firstValueLabel = new JLabel("First Value");
		JLabel secondValueLabel = new JLabel ("Second Value");
		JLabel resultLabel = new JLabel("Result");
		
		this.firstValueField = new JTextField();
		this.secondValueField = new JTextField();
		this.resultField = new JTextField();
		
		//add these to top panel in correct order
		topPanel.add(firstValueLabel);
		topPanel.add(firstValueField);
		topPanel.add(secondValueLabel);
		topPanel.add(secondValueField);
		topPanel.add(resultLabel);
		topPanel.add(resultField);
		
		this.setVisible(true);
		
		//standard boilerplate code
		
	}
	
	public static void main(String[] args)
	{
		GuiCalculator appObject = new GuiCalculator();

	}
}//end main}
//end class