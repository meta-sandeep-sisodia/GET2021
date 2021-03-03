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
	public void linearTest()
	{
		assertEquals(4,search.linearSearch(arr,to_search));
	}
	@Test
	public void binaryTest()
	{
		assertEquals(4,search.binarySearch(arr,0,arr.length,to_search));
	}
	@Test
	public void compareTest()
	{
		assertEquals(search.linearSearch(arr,5),search.binarySearch(arr,0,arr.length,to_search));
	}
}