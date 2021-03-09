import static org.junit.Assert.*;

import org.junit.Test;

public class RotateSublistTest
{
    MyLinkedList firstList;
    RotateSubList rotate;
    RotateSubList list;
    

    //Constructor
    public RotateSublistTest()
    {
    	firstList=new MyLinkedList();
        firstList.addToFront(2);
        firstList.addToFront(3);
        firstList.addToFront(4);
        firstList.addToFront(5);
        firstList.addToFront(6);
        firstList.addToFront(7);
    }
    
    
    // Positive Test Case
    @Test
    public void test_rotate_sub_list()
    {
    	list=new RotateSubList(firstList,2,5,2);
        assertEquals("Head -> 7 -> 4 -> 3 -> 6 -> 5 -> 2 -> Null",list.getResult());
    }    
}