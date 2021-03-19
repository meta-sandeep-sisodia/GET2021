import static org.junit.Assert.*;

import org.junit.Test;

public class InfixExpressionTest
{
	@Test
	public void nullTest()
	{
		try
		{
			InfixExpression exp = new InfixExpression();
			exp.evaluate(null);
		}
		catch (AssertionError e)
		{
			assertEquals("Null String passed",e.getMessage());
		}
	}
	
	@Test
	public void divideByZero()
	{
		try
		{
			String infixExpression = "2*5+(8/0)";
			InfixExpression exp = new InfixExpression();
			exp.evaluate(infixExpression);
		}
		catch (AssertionError e)
		{
			assertEquals("Cannot divide by zero",e.getMessage());
		}
	}
	
	@Test
	public void positiveTest()
	{
		String infixExpression = "2*5+(8/1)";
		InfixExpression exp = new InfixExpression();
		int result=(exp.evaluate(infixExpression));
		int expected=18;
		assertEquals(result,expected);
	}
	
	@Test
	public void improperExpression()
	{
		try
		{
			String infixExpression = "2++5+(8/1)";
			InfixExpression exp = new InfixExpression();
			exp.evaluate(infixExpression);
		}
		catch(AssertionError e)
		{
			assertEquals("Underflow Stack",e.getMessage());
		}
	}
	
}
