/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	Design a class that perform following operations on Strings, without using Java APIs. Assume strings to be not null and case sensitive. 
	
	Compare two strings and return 1 if equals else 0. Take two string inputs, compare them and return values accordingly.
	Return the reverse of any string. 
	Receive a string as parameter and replace lowercase characters with uppercase and vice-versa. 
	Return the largest word of a string. If two words are of same length then return last word.
	
	Also write proper specification for each method created above
	
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/

import java.util.Scanner;
public class StringManipulate 
{
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) 
	{
		new StringManipulate();
	}
	
	StringManipulate()
	{
		driver();
	}
	
	private void driver()
	{
		/*
		 * Governor for navigating user input
		 * Uses helper functions to perform all task
		 */
		printMenu();
		String string_two="";
		String string_one="";
		int choice=getInput();
		if(choice<5)
		{
			string_one=getInput("one");
		}
		if(choice==1)
		{
			string_two=getInput("two");
		}
		switch(choice)
		{
			case 1: System.out.println(compareString(string_one,string_two));break;
			case 2: System.out.println(reverseString(string_one));break;
			case 3: System.out.println(toggleCase(string_one));break;
			case 4: System.out.println(findLargestWord(string_one));break;
			case 5: System.exit(-1);break;
			default: System.out.println("Invalid option");driver();
		}
	}

	private static int getInput()
	{
		/*
		 * Check for the user input to be a integer value only
		 */
		System.out.print("Please enter your choice : ");
		int choice;
		try
		{
			choice=scanner.nextInt();
		}
		catch(Exception e)
		{
			System.out.println("Enter only integer value");
			scanner.nextLine();
			choice=getInput();
		}
		scanner.nextLine();
		return choice;
	}
	private static String getInput(String value)
	{
		/*
		 * Returns the string input from the user
		 * Check the string for null or empty input before returning value
		 * Accepts string parameter from calling function to customize the print statement
		 */
		String string="";
		System.out.println("Please enter the string "+value+" : ");
		try
		{
			string=scanner.nextLine();
		}
		catch(NullPointerException e)
		{
			System.out.println("Please input a valid string");
			string=getInput(value);
		}
		return string;
	}
	
	
	
	private static void printMenu()
	{
		/*
		 * Print the user menu
		 */
		String options="1: Compare String\n2: Reverse String\n3: Toggle case\n4: Find largest word\n5: Exit";
		System.out.println(options);
	}

	public static String findLargestWord(String string)
	{
		/*
		 * Takes input as string and returns Sting data type
		 * stores the starting and ending index of largest word encountered
		 * Resulting string is formed by the use of helper subString function
		 */
		string+=" ";
		int start=0,end=0,max_start=0,max_end=0;
		int length=getLength(string);
		for(int loop_var=0;loop_var<length;loop_var++)
		{
			if(string.charAt(loop_var)==(int)' ')
			{
				start=end+1;
				end=loop_var;
				if(max_end-max_start<=end-start)
				{
					max_start=start;
					max_end=end;
				}
			}
		}
		if(max_end-max_start==0&&length!=0)
		{
			max_end=length;
		}
		return subString(max_start,max_end,string);
	}

	public static String subString(int max_start, int max_end, String string)
	{
		/*
		 * This function returns the substring of a type string for a string.
		 * The starting and ending point for substring are accepted as input.
		 * String is build by adding character from start to end location from main string.
		 * StringBuilder is used for reduction the number of immutable object creation
		 */
		StringBuilder sub_string=new StringBuilder();
		while(max_start<max_end)
		{
			sub_string.append(string.charAt(max_start));
			max_start++;
		}
		return sub_string.toString();
	}

	public static String toggleCase(String string)
	{
		/*
		 * Traverse through the array and pick up characters at the index position.
		 * Check for the ASCII value of character and append its toggled version to the result.
		 * 32 is the difference between integral value'A' and 'a', everything else goes unchanged like space symbols etc.
		 */
		StringBuilder toggled_string=new StringBuilder();
		for(int temp=0;temp<getLength(string);temp++)
		{
			char ch=string.charAt(temp);
			if(ch>='A'&&ch<='Z')
			{
				toggled_string.append((char)(ch+32));
			}
			else if(ch>='a'&&ch<='z')
			{
				toggled_string.append((char)(ch-32));
			}
			else
			{
				toggled_string.append(ch);
			}
		}
		return toggled_string.toString();
	}

	public static String reverseString(String string)
	{
		/*
		 * It takes string as input and break the characters starting from end of origin string and produce a reverse equivalent of original string
		 * String builder is used to reduce the creation of mutable objects
		 */
		StringBuilder reverse_string=new StringBuilder();
		for(int temp=getLength(string)-1;temp>=0;temp--)
		{
			reverse_string.append(string.charAt(temp));
		}
		return reverse_string.toString();
	}

	public static int compareString(String string_one,String string_two)
	{
		/*
		 * Two strings can be equal only of they have a equal length.
		 * Return 0 if String1 length is not equal to String2 length.
		 * Without using Api's string needs to be compared word by word.
		 * Return 1 if both the string are equals.
		 */
		// length is stored as for large string calculating length by custom method can increase time complexity
		int length = getLength(string_one);
		if(length==getLength(string_two))
		{
			for(int temp=0;temp<length;temp++)
			{
				if(string_one.charAt(temp)!=string_two.charAt(temp))
				{
					return 0;
				}
			}
		}
		else
		{
			return 0;
		}
		/*
		 * If reached here then both the strings are equals considering case also
		 */
		return 1;
	}
	public static int getLength(String string)
	{
		/*
		 * This function returns the length of the string for a passed string.
		 * It Traverse through the string until it reaches end of string and index out of bound exception is thrown by charAt function.
		 * length is used to traverse and record the no of characters traversed.
		 * No message is to be generated in catch block
		 */
		int length=0;
		try
		{
			while(true)
			{
				string.charAt(length);
				length++;
			}
		}
		catch(IndexOutOfBoundsException e)
		{
			/*
			 * Reached the end of the string.
			 */
		}
		return length;
	}
}
