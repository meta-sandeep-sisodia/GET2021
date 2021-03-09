import java.util.InputMismatchException;
import java.util.Scanner;

public class HcfLcm
{
	static Scanner scanner=new Scanner(System.in);
	static int value_first_number; //Number 1
	static int value_second_number; //Number 2
	public static void main(String args[])
	{
		HcfLcm obj=new HcfLcm();
		obj.getInput();
		obj.processInput(value_first_number,value_second_number);
	}
	/**
	 * @param first_number first number
	 * @param second_number second number
	 * @return true if first and second number is not equals to zero
	 */
	private boolean validateInput(int first_number, int second_number)
	{
		return(first_number!=0 && second_number!=0);
	}
	/**
	 * @param first_number first number
	 * @param second_number second number
	 * Displays the HCF and LCM of number 1 and number 2
	 */
	private void processInput(int first_number,int second_number)
	{
		if(validateInput(first_number, second_number))
		{
			System.out.println("HCF of "+first_number+" and "+second_number+" = "+getHcf(first_number,second_number));
			System.out.println("LCM of "+first_number+" and "+second_number+" = "+getLcm(first_number,second_number));
		}
		else
		{
			System.out.println("HCF of "+first_number+" and "+second_number+" = "+"Undefined");
			System.out.println("LCM of "+first_number+" and "+second_number+" = "+"Undefined");
		}
	}
	/**
	 * Setting the value of number1 and number second_number inputed from user
	 * Checking for input mismatch type
	 */
	public void getInput()
	{
		try
		{
			System.out.print("Enter first number  : ");
			value_first_number=scanner.nextInt();
			System.out.print("Enter second number : ");
			value_second_number=scanner.nextInt();
		}
		catch(InputMismatchException e)
		{
			System.out.println("Not a valid input : Enter integer only");
			scanner.nextLine();
			getInput();
		}
	}
	/**
	 * @param first_number first number
	 * @param second_number second number
	 * @return HCF of first and second number
	 */
	public int getHcf(int first_number, int second_number)
	{
		if(first_number==0)
		{
			return second_number;
		}
		return getHcf(second_number%first_number,first_number);
	}
	/**
	 * @param first_number first number
	 * @param second_number second number
	 * @return LCM of first and second number
	 */
	public int getLcm(int first_number, int second_number)
	{
		return (first_number*second_number)/getHcf(first_number,second_number);
	}
}
