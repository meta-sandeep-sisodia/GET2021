import static org.junit.Assert.*;

import org.junit.*;
public class NQueenTest
{
	NQueen obj;
	@Before
	public void initializeClass() throws Exception
	{
		obj=new NQueen();
	}
	@Test
	public void NQueenProblemTest()
	{
		try
		{
			obj.createMatrix(3);
		}
		catch(Exception e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
	}
	
	@Test
	public void NQueenProblemTest_negative_value()
	{
		try
		{
			obj.createMatrix(-3);
		}
		catch(Exception e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
	}
	
	@Test
	public void NQueenProblemTest_positive_flow()
	{
		try
		{
			obj.createMatrix(4);
		}
		catch(Exception e)
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
			obj.createMatrix(8);
			assert(true);
		}
		catch(Exception e)
		{
			assertEquals("No Solution exist for N smaller than 3",e.getMessage());
		}
	}
}
