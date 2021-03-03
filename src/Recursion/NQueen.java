package Recursion;

import java.util.Scanner;

public class NQueen 
{
	public NQueen() throws Exception
	{
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter the dimension of matrix : ");
		int dimensionOfMatrix=scanner.nextInt();
		scanner.close();
		int result[][]=createMatrix(dimensionOfMatrix);
		printResult(result);
	}
	public static void main(String args[]) throws Exception
	{
		new NQueen();
	}
	
	public static int[][] createMatrix(int dimensionOfMatrix)throws Exception
	{
		if(dimensionOfMatrix<=3)
		{
			throw new Exception("No Solution exist for N smaller than 3");
		}
		int board[][]=new int[dimensionOfMatrix][dimensionOfMatrix];
		for(int loop_var=0;loop_var<dimensionOfMatrix;loop_var++)
		{
			for( int inner_loop_var=0;inner_loop_var<dimensionOfMatrix;inner_loop_var++)
			{
				board[loop_var][inner_loop_var]=0;
			}
		}
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
	public static void printResult(int[][] board)
	{
		for(int loop_var=0;loop_var<board.length;loop_var++)
		{
			for( int inner_loop_var=0;inner_loop_var<board.length;inner_loop_var++)
			{
				System.out.print(board[loop_var][inner_loop_var]);
			}
			System.out.println();
		}
	}
	static boolean isSafe(int board[][], int row, int col, int dimensionOfMatrix)
    {
        int i, j;
        // Horizontal checking for other queens
        for (i = 0; i < col; i++)
            {
        		if (board[row][i] == 1)
        		{
        			return false;
        		}
        	}
        // Vertical checking for other queens
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            {
        		if (board[i][j] == 1)
        		{
        			return false;
        		}
            }
        
        // Diagonal checking for other queens
        for (i = row, j = col; j >= 0 && i < dimensionOfMatrix; i++, j--)
            {
        		if (board[i][j] == 1)
        		{
        			return false;
        		}
            }
 
        return true;
    }
	static Boolean  nQueen(int[][] board, int startRow, int dimensionOfMatrix)
	{
		if(startRow>=dimensionOfMatrix)
		{
			return true;
		}
		for(int loop_var=0;loop_var<dimensionOfMatrix;loop_var++)
		{
			if(isSafe(board, loop_var, startRow, dimensionOfMatrix))
			{
				board[loop_var][startRow]=1;
				if(nQueen(board, startRow+1, dimensionOfMatrix))
				{
					return true;
				}
				else
				{
					board[loop_var][startRow]=0;
				}
			}
		}
		return false;
	}
}
