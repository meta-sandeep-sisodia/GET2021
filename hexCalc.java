import java.util.Scanner;

public class hexCalc
{
	static String hex_key="0123456789ABCDEF";
	public static void main(String args[])
	{
		startProgram();
	}
	public static void startProgram()
	{
		Scanner scanner=new Scanner(System.in);
		printMenu();
		System.out.println("Enter the choice");
		int choice=scanner.nextInt();
		if(choice==0)
		{
			System.exit(-1);
		}
		else if(choice>=1&&choice<=6)
		{
			System.out.println("Enter the Hexadecimal value");
			String one=scanner.next().toUpperCase();
			System.out.println("Enter the Hexadecimal value");
			String two=scanner.next().toUpperCase();
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
			System.out.println("Enter the decimal value");
			int value=scanner.nextInt();
			System.out.println("Hexadecimal value : "+toHexa(value));
		}
		else if(choice==9)
		{
			System.out.println("Enter the Hexadecimal value");
			String value=scanner.next().toUpperCase();
			System.out.println("Decimal value : "+toDec(value));
		}
		else
		{
			System.out.println("Wromg choice");
			printMenu();
		}
		scanner.close();
	}
	public static void printMenu()
	{
		System.out.println("1: Add Hexadecimal");
		System.out.println("2: Subtract Hexadecimal");
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
		return toHexa(add(toDec(one),toDec(two)));
	}
	public static int add(int a,int b)
	{
		return a+b;
	}
	public static String subtract(String one,String two)
	{
		return toHexa(subtract(toDec(one),toDec(two)));
	}
	public static int subtract(int a,int b)
	{
		return a-b;
	}
	public static String multiply(String one,String two)
	{
		return toHexa(multiply(toDec(one),toDec(two)));
	}
	public static int multiply(int a,int b)
	{
		return a*b;
	}
	public static String divide(String one,String two)
	{
		return toHexa(divide(toDec(one),toDec(two)));
	}
	public static int divide(int a,int b)
	{
		return a/b;
	}
	public static int toDec(String str)
	{
		int result=0;
		for(int i=0;i<str.length();i++)
		{
			char c=str.charAt(i);
			int d=hex_key.indexOf(c);
			result=(result*16)+d;
		}
		return result;
	}
	public static String toHexa(int num)
	{
		StringBuilder result=new StringBuilder();
		int temp;
		while(num>0)
		{
			temp=num%16;
			result.insert(0,hex_key.charAt(temp));
			num=num/16;
		}
		return result.toString();
	}
	public static boolean equals(String one,String two)
	{
		return one.equalsIgnoreCase(two);
	}
	public static boolean smaller(String one,String two)
	{
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
				