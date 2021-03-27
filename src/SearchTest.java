import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class SearchTest
{
	Search search;
	int arr[]={-10,-2,0,1,5,8,15};
	int to_search=5;
	@Before
	public void initializeClass()
	{
		search=new Search();
	}
	@Test
	public void linearTest_element_present()
	{
		assertEquals(4,search.linearSearch(arr,to_search));
	}
	@Test
	public void binaryTest_element_present()
	{
		assertEquals(2,search.binarySearch(arr,0));
	}
	@Test
	public void linearTest_element_not_present()
	{
		assertEquals(-1,search.linearSearch(arr,4));
	}
	@Test
	public void binaryTest_element_not_present()
	{
		assertEquals(-1,search.binarySearch(arr,4));
	}
	@Test
	public void compareTest()
	{
		assertEquals(search.linearSearch(arr,5),search.binarySearch(arr,to_search)); //testing overloaded method also
	}
}