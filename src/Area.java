import java.util.InputMismatchException;
import java.util.Scanner;

/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

Design a class Area to calculate areas for different shapes. It should support following methods
Method to return area of a Triangle. Method will receive width and height as double and return computed value as double.
Method to return area of a Rectangle. Method will receive width and height as double and return computed value as double.
Method to return area of a Square. Method will receive width as double and return computed value as double.
Method to return area of a Circle. Method will receive radius as double and return computed value as double.
 
Assuming that height, width and radius will be greater than zero write proper specification for each method created above.
Also assume that these methods may throw ArithmeticException.

+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/

public class Area
{
	static Scanner scanner = new Scanner(System.in);
	private static String choices[] = new String[]{"Triangle","Rectrangle","Square","Circle","Exit"};
	private static int choice=0;
	private static double result;
	public static void main(String args[])
	{
		new Area();
	}
	Area()
	{
		/*
		 * Prints the available options through helper function
		 * Invokes the operation functions as per choice shown
		 */
		printMenu();
		navigate();
	}
	
	private static void printMenu()
	{
		/*
		 * Prints the operations available for user to perform
		 */
		String message="Calculate area of ";
		System.out.println(message);
		for(String value:choices)
		{
			System.out.println(++choice +" - "+value);
		}
		choice=getChoice();
	}
	private static void navigate()
	{
		/*
		 * Takes input from golbal variable choice and invokes the function of choice
		 * Outputs the area of choice in decimal form with percision of 2 decimal points
		 */
		switch(choice)
		{
			case 1: result=areaOfTriangle(getInput("Base"),getInput("Height"));break;
			case 2: result=areaOfRectangle(getInput("Width"),getInput("Height"));break;
			case 3: result=areaOfSquare(getInput("Width"));break;
			case 4: result=areaoOfCircle(getInput("Radius"));break;
			case 5: System.exit(-1);break;
			default: System.out.println("Un-expected error");
		}
		System.out.printf("%s%.2f","Area of "+choices[choice-1]+" = ",result);
	}
	private static double getInput(String str)
	{
		/*
		 * Takes the input from the user
		 * Returns double value
		 * Discard other intergral and string values
		 */
		double input=0;
		System.out.println("Enter the  : "+str+" of "+choices[choice-1]);
		try
		{
			input=scanner.nextDouble();
			if(input>0)
			{
				return input;
			}
			else
			{
				System.out.println("Enter a positive number only");
				scanner.nextLine();
				input=getInput(str);
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter a Double positive value only");
			scanner.nextLine();
			input=getInput(str);
		}
		return input;
	}
	private static int getChoice()
	{
		/*
		 * Takes the input from the user
		 * In range 1 to 5
		 * Returns integer value
		 * Discard other floating point and string values
		 */
		System.out.println("Enter your choice : ");
		try
		{
			choice=scanner.nextInt();
			if(choice>=1&&choice<=5)
			{
				return choice;
			}
			else
			{
				System.out.println("Enter between 1 to"+choices.length);
				choice=getChoice();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter Integral value");
			scanner.nextLine();
			choice=getChoice();
		}
		return choice;
	}
	public static double areaOfTriangle(double width, double height)
	{
		/*
		 * return double 1/2 X width X height
		 */
		return 0.5*width*height;
	}
	public static double areaOfRectangle(double width, double height)
	{
		/*
		 * return double width x height
		 */
		return width*height;
	}
	public static double areaOfSquare(double width)
	{
		/*
		 * return double width x width
		 */
		return areaOfRectangle(width,width);
	}
	public static double areaoOfCircle(double radius)
	{
		/*
		 * Returns the double value pie x radius square
		 */
		return Math.PI*radius*radius;
	}
}
