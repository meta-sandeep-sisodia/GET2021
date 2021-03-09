import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class HcfLcmTest
{
	HcfLcm obj;
	@Before
	public void initializeClass()
	{
		obj=new HcfLcm();
	}
	
	@Test
	public void testHcf_twoEvenNo()
	{
		assertEquals(2,obj.getHcf(8,14));
	}
	@Test
	public void testLcm_twoEvenNo()
	{
		assertEquals(56,obj.getLcm(8,14));
	}
	@Test
	public void testHcf_twoOddNo()
	{
		assertEquals(1,obj.getHcf(7,13));
	}
	@Test
	public void testLcm_twoOddNo()
	{
		assertEquals(91,obj.getLcm(7,13));
	}
	@Test
	public void testHcf_twoNegativeNo()
	{
		assertEquals(1,obj.getHcf(-8,-5));
	}
	@Test
	public void testLcm_twoNegativeNo()
	{
		assertEquals(40,obj.getLcm(-8,-5));
	}
	@Test
	public void testHcf_twoNoWithOneZeroEqualsValue()
	{
		assertEquals(8,obj.getHcf(0,8)); // Case handled
	}
	@Test
	public void testLcm_twoNoWithOneZeroEqualsValue()
	{
		assertEquals(0,obj.getLcm(0,8));
	}
}