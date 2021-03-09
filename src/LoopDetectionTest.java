import static org.junit.Assert.*;

import org.junit.Test;

public class LoopDetectionTest
{
	MyLinkedList list;
	public LoopDetectionTest()
	{
		list=new MyLinkedList();
        list.addToFront(10);
        list.addToFront(15);
        list.addToFront(11);
        list.addToFront(8);
        list.addToFront(19);
        list.addToFront(0);
        list.addToFront(-10);
        list.addToFront(20);
	}
	@Test
	public void unloopedList()
	{
		assertEquals("Loop Not Found",list.detectLoop()?"Loop Found":"Loop Not Found");
	}
	
	@Test
	public void LoopedListTest()
	{
		list.head.getNext().getNext().getNext().setNext(list.head.getNext().getNext());
		assertEquals("Loop Found",list.detectLoop()?"Loop Found":"Loop Not Found");
	}
}
