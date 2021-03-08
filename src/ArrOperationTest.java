import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
public class ArrOperationTest
{
    public int test_array[];
    ArrOperation obj;

    @Before
    public void setUp()
    {
        test_array=new int[]{0,1,4,2,8,5,4,3,6,5,5};
        obj=new ArrOperation(test_array);
    }

    @Test
    public void getArray()
    {
        assertNotNull(obj.getArray());
    }

    @Test
    public void maxMirror()
    {
        assertEquals(obj.maxMirror(),2);
    }

    @Test
    public void countClumps()
    {
        assertEquals(obj.countClumps(),1);
    }

    @Test
    public void splitArray()
    {
        assertEquals(obj.splitArray(),-1);
    }
}