import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class SparseMatrixTest
{
    @Test
	public void null_matrix_passed_expecting_error()
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
	public void transpose_valid_matrix_expecting_transposed_matrix()
	{
		int[][] matrix0=new int[][]{{0,0,0,1},{0,2,0,0},{0,0,3,0}};
		SparseMatrix mat1=new SparseMatrix(matrix0);
		int [][] expected={{1,1,2},{2,2,3},{3,0,1}};
		Assert.assertArrayEquals(expected,mat1.transpose);
	}
	
	@Test
	public void add_two_matrix_with_difference_dimensions_expecting_error()
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
	public void add_two_matrix_expecting_addition_matrix()
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
	public void isSymmetrical_symmetric_matrix_passed_expecting_true()
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
	public void isSymmetrical_passing_non_symmentric_matrix_expected_false()
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
	public void multiplyMatrix_two_same_dimension_matrix_expected_multiplied_matrix()
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
	public void multiplyMatrix_different_dimensions_matrix_expecting_error()
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
