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
    public void test_rotate_sub_list_normal() 
    {
    	list=new RotateSubList(firstList,2,5,2);
        assertEquals("Head -> 7 -> 4 -> 3 -> 6 -> 5 -> 2 -> Null",list.getResult());
    }   
    
 // Positive Test Case
    @Test
    public void test_rotate_sub_list_rotation_too_high() 
    {
    	list=new RotateSubList(firstList,2,5,120);
        assertEquals("Head -> 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> Null",list.getResult());
    }   
    
    // Negative Test Case start greater than end
    @Test
    public void test_rotate_sub_list_start_greater_end() 
    {
    	try
    	{
    		list=new RotateSubList(firstList,5,2,2);
    	}
    	catch (AssertionError e)
    	{
    		assertEquals("Starting index for sublist can't be greater than end",e.getMessage());
    	}
    }   
    // Negative Test Case invalid start and end
    @Test
    public void test_rotate_sub_list_invalid_start_end() 
    {
    	try
    	{
    		list=new RotateSubList(firstList,-1,12,2);
    	}
    	catch (AssertionError e)
    	{
    		assertEquals("Invalid Start or End values",e.getMessage());
    	}
    }   
    // Negative Test Case NULL list
    @Test
    public void test_rotate_sub_list_null_list() 
    {
    	try
    	{
    		list=new RotateSubList(null,5,2,2);
    	}
    	catch (AssertionError e)
    	{
    		assertEquals("Null List Passed",e.getMessage());
    	}
    }   
    // Negative Test Case Rotation in negative
    @Test
    public void test_rotate_sub_list_negative_rotation() 
    {
    	try
    	{
    		list=new RotateSubList(firstList,2,5,-3);
    	}
    	catch (AssertionError e)
    	{
    		assertEquals("Rotation cant be in negative",e.getMessage());
    	}
    }   
}