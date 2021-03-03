package invariantsInDesign;

public class SparseMatrix
{
	
	public final int[][] position; //For storing position of non zero elements
	private final int row;
	private final int column;
	public SparseMatrix(int[][] position, int row, int column)
	{
		this.position = position;
		this.row = row;
		this.column = column;
	}
	public static void main(String[] args)
	{
		
	}
}
