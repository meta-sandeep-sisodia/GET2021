import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest
{
	@Test
	public void removal_from_empty_queue()
	{
		try
		{
			Queue queue = new Queue(4);
			queue.removeFromQueue();
		}
		catch (AssertionError e)
		{
			assertEquals("Queue is Empty",e.getMessage());
		}
	}
	
	@Test
	public void add_to_full_queue()
	{
		try
		{
			Queue queue = new Queue(1);
			queue.addToQueue(0);
			queue.addToQueue(1);
		}
		catch (AssertionError e)
		{
			assertEquals("Queue is full",e.getMessage());
		}
	}
	
	@Test
	public void get_element_from_empty_queue()
	{
		try
		{
			Queue queue = new Queue(1);
			queue.addToQueue(0);
			queue.removeFromQueue();
			queue.getFront();
		}
		catch (AssertionError e)
		{
			assertEquals("Queue is Empty",e.getMessage());
		}
	}
	
	@Test
	public void getFront()
	{
		Queue queue = new Queue(10);
		queue.addToQueue(8);
		queue.addToQueue(2);
		queue.addToQueue(5);
		int outcome=queue.getFront();
		int expected=8;
		assertEquals(outcome,expected);
	}
	
	@Test
	public void emptyQueue()
	{
		Queue queue = new Queue(10);
		queue.addToQueue(8);
		queue.removeFromQueue();
		queue.addToQueue(5);
		queue.removeFromQueue();
		assertEquals(true,queue.isEmpty());
	}
	
}
