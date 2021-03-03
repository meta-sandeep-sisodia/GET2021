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
	public void testHcf1()
	{
		assertEquals(2,obj.getHcf(8,14));
	}
	@Test
	public void testLcm1()
	{
		assertEquals(56,obj.getLcm(8,14));
	}
	@Test
	public void testHcf2()
	{
		assertEquals(2,obj.getHcf(10,4));
	}
	@Test
	public void testLcm2()
	{
		assertEquals(20,obj.getLcm(10,4));
	}
	@Test
	public void testHcf3()
	{
		assertEquals(1,obj.getHcf(8,5));
	}
	@Test
	public void testLcm3()
	{
		assertEquals(40,obj.getLcm(8,5));
	}
	@Test
	public void testHcf4()
	{
		assertEquals(8,obj.getHcf(0,8)); // Case handled
	}
	@Test
	public void testLcm4()
	{
		assertEquals(0,obj.getLcm(0,8));
	}
}