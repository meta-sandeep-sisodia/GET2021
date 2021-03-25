import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;
public class ArrOperationTest
{
    @Test
    public void getArray_nullarray()
    {
    	int [] test_array=new int[]{};
        try
        {
        	new ArrOperation(test_array);
        }
        catch (AssertionError e)
        {
        	assertEquals("Can not perform operations on null array",e.getMessage());
        }
    }
    @Test
    public void maxMirror()
    {
    	int [] test_array=new int[]{0,1,4,2,8,5,4,3,6,5,5};
        ArrOperation obj=new ArrOperation(test_array);
        assertEquals(obj.maxMirror(),2);
    }
    
    @Test
    public void maxMirror_no_max_mirror()
    {
    	int [] test_array=new int[]{0,1,2,3,4};
        ArrOperation obj=new ArrOperation(test_array);
        assertEquals(1,obj.maxMirror());
    }

    @Test
    public void countClumps()
    {
    	int [] test_array=new int[]{0,1,4,2,8,5,4,3,6,5,5};
        ArrOperation obj=new ArrOperation(test_array);
        assertEquals(obj.countClumps(),1);
    }
    
    @Test
    public void countClumps_no_culmps()
    {
    	int [] test_array=new int[]{0,1,2,4,5};
        ArrOperation obj=new ArrOperation(test_array);
        assertEquals(0,obj.countClumps());
    }

    @Test
    public void splitArray()
    {
    	int [] test_array=new int[]{1,2,3,4,5,5};
        ArrOperation obj=new ArrOperation(test_array);
        assertEquals(4,obj.splitArray());
    }
    
    @Test
    public void splitArray_cant_split()
    {
    	int [] test_array=new int[]{0,1,4,2};
        ArrOperation obj=new ArrOperation(test_array);
        assertEquals(obj.splitArray(),-1);
    }
    
    @Test
    public void fixXY_positive_case()
    {
    	int [] test_array=new int[]{1,2,3,2,1,3};
    	int [] expected = new int[]{1,2,3,3,1,2};
        ArrOperation obj=new ArrOperation(test_array);
        Assert.assertArrayEquals(obj.fixXY(1,2),expected);
    }
    
    @Test
    public void fixXY_negative_case()
    {
    	int [] test_array=new int[]{0,1,4,1};
    	int [] expected = new int[]{0,1,4,1};
        ArrOperation obj=new ArrOperation(test_array);
        Assert.assertArrayEquals(obj.fixXY(1,2),expected);
    }
    
}