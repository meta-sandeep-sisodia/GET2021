package Recursion;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Search {
	static Scanner scanner=new Scanner(System.in);
	public static void main(String[] args)
	{
		System.out.println("Enter the size of array");
		int temp=getInput();
		if(temp<=0)
		{
			scanner.nextLine();
			temp=getInput();
		}
		int arr[]=new int[temp];
		for(int loop_var=0;loop_var<temp;loop_var++)
		{
			System.out.print("Enter element "+(loop_var+1)+" = ");
			arr[loop_var]=getInput();
		}
		System.out.println("Enter the element to search");
		int to_search=getInput();
		System.out.println("Index of "+to_search+" = "+Search.binarySearch(arr,0,arr.length,to_search)); //It will only work for sorted array
		System.out.println("Index of "+to_search+" = "+Search.linearSearch(arr, to_search));
	}
	static int getInput()
	{
		int temp = 0;
		try
		{
			temp=scanner.nextInt();
			return temp;
		}
		catch(InputMismatchException e)
		{
			System.out.println("Enter numeric value only");
			scanner.nextLine();
			return getInput();
		}
	}
	public static int binarySearch(int arr[], int left_index, int right_index, int value_to_search)
    { 
        if (right_index >= left_index) { 
            int mid = left_index + (right_index - left_index) / 2; 
            if (arr[mid] == value_to_search)
            {
                return mid;
            
            }
            if (arr[mid] > value_to_search)
            {
                return binarySearch(arr, left_index, mid - 1, value_to_search);
            }
            else
            {
            	return binarySearch(arr, mid + 1, right_index, value_to_search);
            }
        }
        return -1; 
    }
	public static int linearSearch(int arr[], int value_to_search) 
    {
		int index=0;
		for(int value:arr)
		{
			if(value==value_to_search)
			{
				return index;
			}
			index++;
		}
		return -1;
    }
}
