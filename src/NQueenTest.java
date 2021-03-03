package Recursion;

import static org.junit.Assert.*;
import org.junit.*;
public class NQueenTest
{
	@Test
	public void NQueenProblemTest()
	{
		try
		{
			NQueen.createMatrix(3);
		}
		catch(Exception e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
	}
}
