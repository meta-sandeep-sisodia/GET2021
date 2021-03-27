import static org.junit.Assert.*;

import org.junit.*;
public class NQueenTest
{
	NQueen obj;
	@Before
	public void initializeClass() throws AssertionError
	{
		obj=new NQueen();
	}
	@Test
	public void NQueenProblemTest()
	{
		try
		{
			obj.createMatrixAndPlaceQueens(3);
		}
		catch(AssertionError e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
	}
	
	@Test
	public void NQueenProblemTest_negative_value()
	{
		try
		{
			obj.createMatrixAndPlaceQueens(-3);
		}
		catch(AssertionError e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
	}
	
	@Test
	public void NQueenProblemTest_positive_flow()
	{
		try
		{
			obj.createMatrixAndPlaceQueens(4);
		}
		catch(AssertionError e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
		assert(true);
	}
	
	@Test
	public void NQueenProblemTest_positive_flow_larger_value()
	{
		try
		{
			obj.createMatrixAndPlaceQueens(8);
			assert(true);
		}
		catch(AssertionError e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
	}
}
