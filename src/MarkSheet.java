/*
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	Design a class MarkSheet, which reads in grades of n no of students. Assume n as a positive integer and grades will be between 0 and 100 both inclusive. It should support following methods 
	Return average of all grades. 
	Return maximum of all grades.
	Return minimum of all grades.
	Return percentage of students passed. (Assume grade >= 40 as Pass) 
	 
	Also write proper specification for each method created above. Assume that these methods may throw ArithmeticException.
	Note : Use the floating-point values upto 2 decimal places.
	
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
*/

import java.util.InputMismatchException;
import java.util.Scanner;
public class MarkSheet
{
	/*
	 * grades array stores grades inputed from user
	 * statistics array stores the computed data
	 * Scanner is used a global variable for helper function to access scanner without creating a reference of it
	 */
	private static Scanner scanner = new Scanner(System.in);
	private static float grades[];
	private static float statistics[]=new float[5];
	
	public static void main(String args[])
	{
		/*
		 * Invokes the functionality through constructor
		 * calls the unparameterized constructor
		 */
		new MarkSheet();	
	}
	
	MarkSheet(float value[])
	{
		/*
		 * Default parameterized constructor
		 * Used when grades value is passed by program accessing the MarkSheet class
		 */
		if(validateInput(value))
		{
			grades=value;
			computeGrades();
			printStatistics();
		}
		else
		{
			System.out.println("Invalid grade values are present in the passed array");
		}
	}
		
	MarkSheet()
	{
		/*
		 * Default unparameterized constructor
		 * Used when grades value are not passed
		 */
		grades=new float[getCount()];
		fetchDetails();
		computeGrades();
		printStatistics();
	}
	
	public boolean validateInput(float[] value)
	{
		/*
		 * validate the grades value and return true if array is valid.
		 * valid grades value are in range 0 to 100 both inclusive.
		 */
		for(int a=0;a<value.length;a++)
		{
			if(a>100||a<0)
			{
				return false;
			}
		}
		return true;
	}
	
	private static int getCount()
	{
		/*
		 * Used for Taking the student count as input from the user
		 * Takes count of students as input
		 * validation of input is performed for Mismatch data type
		 */
		int count=0;
		System.out.println("Enter no of students : ");
		try
		{
			count=scanner.nextInt();
			return count;
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter Integral value");
			scanner.nextLine();
			count=getCount();
		}
		return count;
	}

	private static void fetchDetails() 
	{
		/*
		 * Takes input from helper function and store the value of grade received in grades array.
		 * Validation of input is performed in helper function
		 */
		
		for(int temp=0;temp<grades.length;temp++)
		{
			grades[temp]=getGrade(temp);
		}
	}

	private static float getGrade(int n)
	{
		/*
		 * Helper function for fetchDetails
		 * Taking the input from the user
		 * Takes count of students as parameters
		 * validation of input is performed as grade can have values between 0 to 100 both inclusive.
		 * checking of input data type is also done.
		 */
		float grade=0f;
		try
		{
			System.out.print("Enter the grade for student "+(n+1)+" : ");
			grade=scanner.nextFloat();
			if(grade>=0&&grade<=100)
			{
				return grade;
			}
			else
			{
				System.out.println("Enter vaues in range 0 to 100");
				grade=getGrade(n);
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter numerical value only ");
			scanner.nextLine();
			grade=getGrade(n);
		}
		return grade;
	}

	private static void computeGrades()
	{
		/*
		 * Traverse throughout the grades array and calculate.
		 * calculate the number of students who achieve above or atleast 40% grade.
		 * initially minimum grade is set to be the maximum value a grade can have.
		 * initially maximum grade is set to be the minimum value a grade can have.
		 * Sum of grade is also calculated for calculation of Average later on.
		 * Working is used so the function don't have to fetch the value of a grade multiple times.
		 * 
		 */
		int pass_count=0;
		float max_grade=0;
		float min_grade=100;
		float grade_sum=0;
		float working;
		for(int temp=0;temp<grades.length;temp++)
		{
			working=grades[temp];
			grade_sum+=working;
			max_grade=max_grade<working?working:max_grade;
			min_grade=min_grade>working?working:min_grade;
			if(working>=40)
			{
				pass_count++;
			}
		}
		collectStatistics(max_grade,min_grade,pass_count,grade_sum);
	}
	
	private static void collectStatistics(float max_grade,float min_grade,int pass_count,float grade_sum)
	{
		/*
		 * Takes input from the compute grades and is set to private so that is can't be manipulated by other program.
		 * Store the grade related informations calculated by compute grade function in an array
		 */
		statistics[0]=max_grade;
		statistics[1]=min_grade;
		statistics[2]=pass_count;
		statistics[3]=grade_sum;
		statistics[4]=grades.length;
	}
	
	public static void printStatistics()
	{
		/*
		 * Print the various information calculated from the given inputs
		 * Helper functions are used to get the values so as to make code modular
		 * Can be used to get whole required statistics at one
		 * Each values can be extracted from helper functions also in case all values are not required
		 */
		System.out.println("Average Grade : "+getAverage());
		System.out.println("Maximum Grade : "+getMaximum());
		System.out.println("Minimum Grade : "+getMinimum());
		System.out.println("Pass Count : "+getPassCount());
		System.out.println("Pass Percentage : "+getPassPercentage());
	}
	
	public static float getAverage()
	{
		/*
		 * returns the average grade obtained by students in floating point
		 * average = sum of grades/no of students
		 * statistics[3] - sum of grades
		 * statistics[4] - number of students
		 */
		return statistics[3]/statistics[4];
	}

	public static float getMinimum()
	{
		/*
		 * Returns the minimum value of grade in floating point
		 * computeGrade method traverse the grade array and store the minimum grade encountered in statistics[1]
		 */
		return statistics[1];
	}
	
	public static float getMaximum()
	{
		/*
		 * Returns the maximum value of grade
		 * computeGrade method traverse the grade array and store the maximum grade encountered in statistics[0]
		 */
		return statistics[0];
	}

	public static float getPassPercentage()
	{
		/*
		 * Returns pass percentage in floating point
		 * statistics[2]==students who scored on or above 40%
		 * statistics[4]==Strength count of students
		 * pass percentage = (number of student who passed)/total student) x 100
		 */
		return (statistics[2]/statistics[4])*100;
	}
	
	public static int getPassCount()
	{
		/*
		 *  returns the count of total number of students who have grade above 40% or equal to 40%
		 *  Since the value is stored in floating points so trimmer is used. As student can't be in fractions 
		 */
		return (int)statistics[2];
	}
}
