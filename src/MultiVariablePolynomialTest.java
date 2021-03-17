import static org.junit.Assert.*;

import org.junit.Test;

public class MultiVariablePolynomialTest
{
	@Test
	public void test_poly_complex_multi_variable_poly()
	{
		String polynomial="3x2y4-5z5+x-y+20";
        MultiVariablePolynomial poly =new MultiVariablePolynomial(polynomial);
        assertEquals(6,poly.calculateMaxDegree());
	}
	@Test
	public void test_poly_single_term()
	{
		String polynomial="9x4";
        MultiVariablePolynomial poly =new MultiVariablePolynomial(polynomial);
        assertEquals(4,poly.calculateMaxDegree());
	}
	@Test
	public void test_poly_without_power()
	{
		String polynomial="9x-4+2x";
        MultiVariablePolynomial poly =new MultiVariablePolynomial(polynomial);
        assertEquals(1,poly.calculateMaxDegree());
	}
}
