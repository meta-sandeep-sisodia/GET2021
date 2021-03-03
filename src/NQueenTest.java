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
}
