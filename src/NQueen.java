import java.util.Scanner;
public class NQueen 
{
	public static void main(String args[]) throws Exception
	{
		Scanner scanner =new Scanner(System.in);
		NQueen obj=new NQueen();
		System.out.println("Enter the dimension of matrix : ");
		int dimensionOfMatrix=scanner.nextInt();
		scanner.close();
		int result[][]=obj.createMatrixAndPlaceQueens(dimensionOfMatrix);
		NQueen.printResult(result);
	}
	
	/**
	 * @param dimensionOfMatrix
	 * @return solution of N queen in 2D array
	 * @throws Exception custom exception for n<=3
	 */
	public int[][] createMatrixAndPlaceQueens(int dimensionOfMatrix)
	{
		if(dimensionOfMatrix<=3)
		{
			throw new AssertionError("No Solution exist for N smaller than 3");
		}
		int board[][]=new int[dimensionOfMatrix][dimensionOfMatrix];
		
		Boolean result = nQueen(board , 0, dimensionOfMatrix);
		if(result==true)
		{
			return board;
		}
		else
		{
			throw new AssertionError("No sulution exist for provided dimensions");
		}
	}
	/**
	 * @param board
	 * Print the solution
	 */
	public static void printResult(int[][] board)
	{
		for(int loop_var=0;loop_var<board.length;loop_var++)
		{
			for( int inner_loop_var=0;inner_loop_var<board.length;inner_loop_var++)
			{
				System.out.print(board[loop_var][inner_loop_var]+" ");
			}
			System.out.println();
		}
	}
	/**
	 * @param board 
	 * @param row
	 * @param col
	 * @param dimensionOfMatrix
	 * @return return true if queen is safe to place
	 */
	boolean isSafe(int board[][], int row, int col, int dimensionOfMatrix)
    {
		int hl=row;
		int ud=row;
		int ld=row;
		while(col>=0)
		{
			if(board[hl][col]==1)
			{
				return false;
			}
			
			if(ud>=0)
			{
				if(board[ud][col]==0)
				{
					ud--;
				}
				else
				{
					return false;
				}
			}
			
			if(ld<dimensionOfMatrix)
			{
				if(board[ld][col]==0)
				{
					ld++;
				}
				else
				{
					return false;
				}
			}
			col--;
		}
		return true;
    }
	
	/**
	 * @param board 2D array representing position of queens
	 * @param startRow Row in which queen has to be placed
	 * @param dimensionOfMatrix
	 * @return return true if all queens can be placed
	 */
	Boolean  nQueen(int[][] board, int startRow, int dimensionOfMatrix)
	{
		//Only possible if all queens are placed
		if(startRow>=dimensionOfMatrix)
		{
			return true;
		}
		// Iterate in row
		for(int loop_var=0;loop_var<dimensionOfMatrix;loop_var++)
		{
			// Check for possible placement of queen in row
			if(isSafe(board, loop_var, startRow, dimensionOfMatrix))
			{
				// Placing queen
				board[loop_var][startRow]=1;
				if(nQueen(board, startRow+1, dimensionOfMatrix))
				{
					return true;
				}
				else
				{
					board[loop_var][startRow]=0; //If queen can't be placed safely
				}
			}
		}
		return false;
	}
}
