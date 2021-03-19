package Counseling;

import java.io.FileNotFoundException;

public class CollegeCounselingDriver
{
	public static void main(String args[]) throws FileNotFoundException
	{
		try
		{
			CollegeCounseling.assignedProgram();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
