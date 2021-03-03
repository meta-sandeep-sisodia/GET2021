package Recursion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class HcfLcm
{
	static Scanner scanner=new Scanner(System.in);
	static int value_one;
	static int value_two;
	public static void main(String args[])
	{
		new HcfLcm();
	}
	HcfLcm(int one,int two)
	{
		value_one=one;
		value_two=two;
		processInput(value_one,value_two);
	}
	HcfLcm()
	{
		getInput();
		processInput(value_one,value_two);
	}
	private boolean validateInput(int one, int two)
	{
		return(one!=0 && two!=0);
	}
	private void processInput(int one,int two)
	{
		if(validateInput(one, two))
		{
			System.out.println("HCF of "+one+" and "+two+" = "+getHcf(one,two));
			System.out.println("LCM of "+one+" and "+two+" = "+getLcm(one,two));
		}
		else
		{
			System.out.println("HCF of "+one+" and "+two+" = "+"Undefined");
			System.out.println("LCM of "+one+" and "+two+" = "+"Undefined");
		}
	}
	private void getInput()
	{
		try
		{
			System.out.print("Enter first number  : ");
			value_one=scanner.nextInt();
			System.out.print("Enter second number : ");
			value_two=scanner.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Not a valid input : Enter integer only");
			scanner.nextLine();
			getInput();
		}
	}
	public int getHcf(int one, int two)
	{
		if(one==0)
		{
			return two;
		}
		return getHcf(two%one,one);
	}
	public int getLcm(int one, int two)
	{
		return (one*two)/getHcf(one,two);
	}
}
