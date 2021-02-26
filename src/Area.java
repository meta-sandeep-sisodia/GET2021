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
	static String choices[] = new String[]{"Triangle","Rectrangle","Square","Circle","Exit"};
	static int choice=0;
	static double result;
	public static void main(String args[])
	{
		new Area();
	}
	Area()
	{
		printMenu();
		navigate();
	}
	
	private static void printMenu()
	{
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
				input=getInput(str);
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter Double value");
			scanner.nextLine();
			input=getInput(str);
		}
		return input;
	}
	private static int getChoice()
	{
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
		return 0.5*width*height;
	}
	public static double areaOfRectangle(double width, double height)
	{
		return width*height;
	}
	public static double areaOfSquare(double width)
	{
		return areaOfRectangle(width,width);
	}
	public static double areaoOfCircle(double radius)
	{
		return Math.PI*radius*radius;
	}
}
