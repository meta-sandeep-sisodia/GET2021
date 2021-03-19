import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class SparseMatrixTest
{
    @Test
	public void null_matrix()
	{
    	try
    	{
    		new SparseMatrix(null);
    	}
    	catch(AssertionError e)
    	{
    		assertEquals("Null array passed",e.getMessage());
    	}
	}
    
	@Test
	public void transpose_test()
	{
		int[][] matrix0=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0}};
		SparseMatrix mat1=new SparseMatrix(matrix0);
		int [][] expected={{1,1,2},{2,2,3},{3,0,1}};
		Assert.assertArrayEquals(expected,mat1.transpose);
	}
	
	@Test
	public void add_dimention_difference()
	{
		try
    	{
			int[][] matrix0=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0}};
			int[][] matrix2=new int[][]{{0,0},{0,1},{0,2},{1,0}};
    		SparseMatrix mat=new SparseMatrix(matrix0);
    		mat.addMatrix(matrix2);
    	}
    	catch(AssertionError e)
    	{
    		assertEquals("Can not add two matrix with different dimensions",e.getMessage());
    	}
	}
	
	@Test
	public void add_positive()
	{
		try
    	{
			int[][] matrix0=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0}};
			int[][] matrix1=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0}};
			SparseMatrix mat=new SparseMatrix(matrix0);
			int [][] expected={{0,3,2},{1,1,4},{2,2,6}};
			int result[][]=mat.addMatrix(matrix1);
			Assert.assertArrayEquals(expected,result);
    	}
		catch (Exception e)
		{
			
		}
	}
	
	@Test
	public void isSymmetrical_positive()
	{
		try
    	{
			int[][] matrix0=new int[][]{{0,0,0,1},{0,1,0,0},{0,0,1,0},{1,0,0,0}};
			SparseMatrix mat=new SparseMatrix(matrix0);
			assertEquals(true,mat.isSymmetric());
    	}
		catch (Exception e)
		{
			
		}
	}
	
	@Test
	public void isSymmetrical_negative()
	{
		try
    	{
			int[][] matrix0=new int[][]{{0,2,0,1},{0,1,0,0},{0,0,1,0},{1,0,0,0}};
			SparseMatrix mat=new SparseMatrix(matrix0);
			assertEquals(false,mat.isSymmetric());
    	}
		catch (Exception e)
		{
			
		}
	}
	
	@Test
	public void multiplyMatrix_positive()
	{
		try
    	{
			int[][] matrix0=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0},{0,0,0,1}};
			int[][] matrix1=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0},{1,0,0,0}};
			SparseMatrix mat=new SparseMatrix(matrix0);
			int [][] expected={{1,0,0,0},{0,4,0,0},{0,0,9,0},{1,0,0,0}};
			int result[][]=mat.multiplySparseMatrix(matrix1);
			Assert.assertArrayEquals(expected,result);
    	}
		catch (Exception e)
		{
			
		}
	}
	@Test
	public void multiplyMatrix_negative()
	{
		try
    	{
			int[][] matrix0=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0},{0,0,0,1}};
			int[][] matrix1=new int[][]{{0,0,1},{0,2,0},{0,3,0}};
			SparseMatrix mat=new SparseMatrix(matrix0);
    	}
		catch(AssertionError e)
    	{
    		assertEquals("Mat1 row is not equal Mat2 col",e.getMessage());
    	}
	}
}
