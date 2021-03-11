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
		int result[][]=obj.createMatrix(dimensionOfMatrix);
		NQueen.printResult(result);
	}
	
	/**
	 * @param dimensionOfMatrix
	 * @return solution of N queen in 2D array
	 * @throws Exception custom exception for n<=3
	 */
	public int[][] createMatrix(int dimensionOfMatrix)throws Exception
	{
		if(dimensionOfMatrix<=3)
		{
			throw new Exception("No Solution exist for N smaller than 3");
		}
		int board[][]=new int[dimensionOfMatrix][dimensionOfMatrix];
		
		Boolean result = nQueen(board , 0, dimensionOfMatrix);
		if(result==true)
		{
			return board;
		}
		else
		{
			System.out.println("No sulution exist for provided dimensions");
			System.exit(-1);
		}
		return null;
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
	boolean isSafe(int board[][], int col, int row, int dimensionOfMatrix)
    {
        int i, j;
        // Vertical checking for other queens above only
        for (i = 0; i < row; i++)
            {
        		if (board[col][i] == 1)
        		{
        			return false;
        		}
        	}
        // Left Diagonal checking for other queens above only
        for (i = col, j = row; i >= 0 && j >= 0; i--, j--)
            {
        		if (board[i][j] == 1)
        		{
        			return false;
        		}
            }
        
        // Right Diagonal checking for other queens above only
        for (i = col, j = row;i < dimensionOfMatrix && j >= 0 ; i++, j--)
            {
        		if (board[i][j] == 1)
        		{
        			return false;
        		}
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
