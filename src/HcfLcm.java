import java.util.InputMismatchException;
import java.util.Scanner;

public class HcfLcm
{
	static Scanner scanner=new Scanner(System.in);
	static int value_one; //Number 1
	static int value_two; //Number 2
	public static void main(String args[])
	{
		HcfLcm obj=new HcfLcm();
		obj.getInput();
		obj.processInput(value_one,value_two);
	}
	/**
	 * @param one first number
	 * @param two second number
	 * @return true if first and second number is not eqals to zero
	 */
	private boolean validateInput(int one, int two)
	{
		return(one!=0 && two!=0);
	}
	/**
	 * @param one first number
	 * @param two second number
	 * Displays the HCF and LCM of number 1 and number 2
	 */
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
	/**
	 * Setting the value of number1 and number two inputed from user
	 * Checking for input mismatch type
	 */
	public void getInput()
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
	/**
	 * @param one first number
	 * @param two second number
	 * @return HCF of first and second number
	 */
	public int getHcf(int one, int two)
	{
		if(one==0)
		{
			return two;
		}
		return getHcf(two%one,one);
	}
	/**
	 * @param one first number
	 * @param two second number
	 * @return LCM of first and second number
	 */
	public int getLcm(int one, int two)
	{
		return (one*two)/getHcf(one,two);
	}
}
