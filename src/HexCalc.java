/*
	Design a class HexCalc that supports following methods for hexadecimal arithmetic. You can assume that this class will be working with only positive integers.
	
	Methods to add, subtract, multiply and divide two hexadecimal numbers. Each of the methods will receive hexadecimal numbers as strings, and will return the computed value as hexadecimal string.
	The strategy that can be followed by each of the methods is to convert the strings into numbers, perform the computation, and reconvert the result back into hexadecimal representation.
	Methods to compare two hexadecimal numbers for ==, > and <. Each of these methods will return a boolean value. Implement these methods without converting the arguments to decimal numbers for comparison.
	Return the decimal representation of hexadecimal number.
	Return the hexadecimal representation of decimal number.
	
	How would you generalise this to support arithmetic in any base?

 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class HexCalc
{
	/*
	 * hex_key denotes how integer value is represented in base 16 i.e Hexadecimal notation
	 */
	final static String hex_key="0123456789ABCDEF";
	static Scanner scanner=new Scanner(System.in);
	public static void main(String args[])
	{
		new HexCalc();
	}
	HexCalc()
	{
		navigate();
	}
	private static void navigate()
	{
		/*
		 * Takes care of choices and which function to call
		 * Perform Input operations with help of helper functions
		 */
		printMenu();
		int choice=getChoice();
		if(choice==0)
		{
			System.exit(-1);
		}
		else if(choice>=1&&choice<=6)
		{
			String one=getInput("Hexadecimal value").toUpperCase();
			String two=getInput("Hexadecimal value").toUpperCase();
			switch(choice)
			{
			case 1:System.out.println(add(one,two));break;
			case 2:System.out.println(subtract(one,two));break;
			case 3:System.out.println(multiply(one,two));break;
			case 4:System.out.println(divide(one,two));break;
			case 5:System.out.println(equals(one,two));break;
			case 6:System.out.println(smaller(one,two));break;
			case 7:System.out.println(greater(one,two));break;
			}
		}
		else if(choice==8)
		{
			System.out.println("Hexadecimal value : "+toHexaDecimala(Integer.parseInt(getInput("Decimal Value"))));
		}
		else if(choice==9)
		{
			System.out.println("Decimal value : "+toDecimal(getInput("Decimal Value").toUpperCase()));
		}
	}
	private static int getChoice()
	{
		/*
		 * Takes input from the user
		 * Ensures that only Integer value is accepted
		 * Ensures that values are in range 0 to 9
		 */
		int choice;
		System.out.println("Enter your choice : ");
		try
		{
			choice=scanner.nextInt();
			if(choice>=1&&choice<=9)
				{
					return choice;
				}
			else if(choice==0)
			{
				System.exit(-1);
			}
			else
			{
				System.out.println("Enter between 1 to 9");
				choice=getChoice();
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter Integral value");
			scanner.nextLine();
			choice=getChoice();
		}
		scanner.nextLine();
		return choice;
	}
	
	private static String getInput(String str)
	{
		/*
		 * Takes String input from user
		 */
		String input="";
		try
		{
			System.out.println("Enter the "+str);
			input=scanner.nextLine();
			if(input.isEmpty())
			{
				input=scanner.nextLine();
			}
			else
			{
				return input;
			}
		}
		catch(Exception e)
		{
			System.out.println("Please enter "+str+" value");
			scanner.nextLine();
			input=getInput(str);
		}
		return input;
	}
	
	public static void printMenu()
	{
		/*
		 * Print user menu to access various functions
		 */
		System.out.println("1: Add Hexadecimal");
		System.out.println("2: Subtract Hexadecimal -- Will return absolute value");
		System.out.println("3: Multiply Hexadecimal");
		System.out.println("4: Divide Hexadecimal");
		System.out.println("5: check if two hexadecimals are equal");
		System.out.println("6: check if hexadecimals one is smaller than Hexadecimal two");
		System.out.println("7: check if hexadecimals one is greater than Hexadecimal two");
		System.out.println("8: Decimal to Hexadecimal");
		System.out.println("9: Hexadecimal to Decimal");
		System.out.println("0: Exit");
	}
	public static String add(String one,String two)
	{
		/*
		 * Takes two Hexadecimal String as input and return first plus second in Hexadecimal notation
		 * make use of helper functions toDecimal to convert it into base 10
		 * then perform the add operation by helper function add 
		 */
		return toHexaDecimala(add(toDecimal(one),toDecimal(two)));
	}
	public static int add(int a,int b)
	{
		/*
		 * Takes two integer as input and return first plus second Integral value
		 */
		return a+b;
	}
	public static String subtract(String one,String two)
	{
		/*
		 * Takes two Hexadecimal String as input
		 * Return Absolute value in Hexadecimal notation
		 * make use of helper functions toDecimal to convert it into base 10
		 * then perform the subtract operation by helper function subtract 
		 */
		return toHexaDecimala(Math.abs(subtract(toDecimal(one),toDecimal(two))));
	}
	public static int subtract(int a,int b)
	{
		/*
		 * Takes two integer as input and return first minus(-) second Integral value
		 */
		return (a-b);
	}
	public static String multiply(String one,String two)
	{
		/*
		 * Takes two Hexadecimal String as input and return first multiply by second in Hexadecimal notation
		 * make use of helper functions toDecimal to convert it into base 10
		 * then perform the multiply operation by helper function multiply 
		 */
		return toHexaDecimala(multiply(toDecimal(one),toDecimal(two)));
	}
	public static int multiply(int a,int b)
	{
		/*
		 * Takes two integer as input and return first multiply second Integral value
		 */
		return a*b;
	}
	public static String divide(String one,String two)
	{
		/*
		 * Takes two Hexadecimal String as input and return first divide by second in Hexadecimal notation
		 * make use of helper functions toDecimal to convert it into base 10
		 * then perform the divide operation by helper function divide 
		 */
		return toHexaDecimala(divide(toDecimal(one),toDecimal(two)));
	}
	public static int divide(int a,int b)
	{
		/*
		 * Takes two integer as input and return first divide by second Integral value
		 * Divide by zero exception is checked and 0 is produced instead of Infinity
		 */
		try
		{
			return a/b;
		}
		catch(ArithmeticException e)
		{
			return 0;
		}
	}
	public static int toDecimal(String str)
	{
		/*
		 * This function takes input as hexadecimal value in String Format and return the Integer with base 10
		 * This function make use of hexa_key to decode Hexadecimal notation.
		 */
		int result=0;
		str=str.toUpperCase();
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			int d=hex_key.indexOf(c);
			result=(result*16)+d;
		}
		return result;
	}
	public static String toHexaDecimala(int num)
	{
		/*
		 * This function takes input as Integer with base 10 and return the hexadecimal value in String Format
		 * This function make use of hexa_key which determine symbols used in base 16 notation.
		 */
		String hexavalue="";
		int temp;
		while(num>0)
		{
			temp=num%16;
			hexavalue=hex_key.charAt(temp)+hexavalue;
			num=num/16;
		}
		return hexavalue.isEmpty()?"0":hexavalue;
	}
	public static boolean equals(String one,String two)
	{
		/*
		 * Takes two hexadecimal number in string format
		 * The function will return true if number one is smaller than number two
		 */
		return one.equalsIgnoreCase(two);
	}
	public static boolean smaller(String one,String two)
	{
		/*
		 * Takes two hexadecimal number in string format and return boolean value
		 * Compares the hexadecimal number first by its length then element wise
		 * The function will return true if number one is smaller than number two
		 */
		if(one.length()==two.length())
		{
			int i=0;
			while(i<one.length())
			{
				if(one.charAt(i)<two.charAt(i))
				{
					i++;
				}
				else return one.charAt(i)<two.charAt(i);
			}	
		}
		else
		{
			return one.length()<two.length();
		}
		return false;
	}
	public static boolean greater(String one,String two)
	{
		/*
		 * Takes two hexadecimal number in string format
		 * Compares the hexadecimal number first by its length
		 * The function will return true if number one is greater than number two
		 */
		if(one.length()==two.length())
		{
			int i=0;
			while(i<one.length())
			{
				if(one.charAt(i)>two.charAt(i))
				{
					i++;
				}
				else return one.charAt(i)>two.charAt(i);
			}	
		}
		else
		{
			return one.length()>two.length();
		}
		return false;
	}
}
				
