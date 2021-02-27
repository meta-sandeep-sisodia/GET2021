import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;

/*
	Implement the immutable class intSet using an array to represent a set of integers in the range 1-1000.
	It should support public methods like - 
	
	isMember(int x) - check whether x is a member of the set and return a boolean value
	
	size() - return the size of the set
	
	isSubSet(intSet s) - check whether s is a subset of the set
	
	getComplement()  - return the complement set, you can assume that 1..1000 is the universal set
	
	union(intSet s1, intSet s2) - return the union of s1 and s2
	
	You may use private helper methods. 
*/

public final class IntSet 
{
	private int set[];
	public static void main(String[] args)
	{
		int arr1[]=new int[]{2,4,6,8,10};
		int arr2[]=new int[]{5,6,7,8,9};
		IntSet s1=new IntSet(arr1);
		IntSet s2=new IntSet(arr2);
		//System.out.println("A is member of B ="+s2.isMember(6));//Working
		//System.out.println("A is subset of B ="+s1.isSubSet(s2));//Working
		//System.out.println("A is Proper subset of B ="+s1.isProperSubSet(s2));//Working
		//System.out.println("Size of A = "+s1.size());// Working
		System.out.println("Compliment of A = ");printSet(s1.getComplement());
		//System.out.print("\nUnion of A and B = ");printSet(s1.union(s1,s2));
	}
	
	IntSet(int[] arr)
	{
		if(validateInput(arr)==true)
		{
			set=new int[arr.length];
			set=arr;
		}
		else
		{
			System.out.println("Invalid value for a set");
			System.exit(-1);
		}
	}
	public boolean validateInput(int[] arr)
	{
		if(arr.length>1000)
		{
			return false;
		}
		for(int value:arr)
		{
			if(value>1000||value<1)
			{
				return false;
			}
		}
		return !containDuplicateElements(arr);
	}
	
	private boolean containDuplicateElements(int[] arr)
	{
		for(int loop_var=0;loop_var<arr.length;loop_var++)
		{
			for(int inner_loop_var=loop_var+1;inner_loop_var<arr.length;inner_loop_var++)
			{
				if(arr[inner_loop_var]==arr[loop_var])
				{
					return true;
				}
			}
		}
		return false;
	}
	/*
	private void driver()
	{
		
	}
	private void printMenu()
	{
		
	}
	private void getInput()
	{
		int input=0;
		System.out.println("Enter the value of element in set : "+str+" of ");
		try
		{
			input=scanner..nextInt();
			if(isMember())
			{
				return input;
			}
			else
			{
				input=getInput(str);
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Please enter Double value");
			scanner.nextLine();
			input=getInput(str);
		}
		return input;
	}
	*/
	public boolean isMember(int x)
	{
		for(int value:set)
		{
			if(value==x)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void printSet(IntSet s)
	{
		for(int value:s.set)
		{
			System.out.print(value+", ");
		}
	}

	public int size()
	{
		return set.length;
	}
	
	public boolean isSubSet(IntSet s)
	{
		int set_length=this.set.length;
		int subset_length=s.set.length;
		int count=0;
		if(subset_length>set_length)
		{
			return false;
		}
		else
		{
			for(int loop_var=0;loop_var<subset_length;loop_var++)
			{
				int to_search=s.set[loop_var];
				for(int inner_loop_var=0;inner_loop_var<set_length;inner_loop_var++)
				{
					
					if(to_search==this.set[inner_loop_var])
					{
						count++;
					}
				}
			}
		}
		return count>0?true:false;
	}
	
	public boolean isProperSubSet(IntSet s)
	{
		int set_length=this.set.length;
		int subset_length=s.set.length;
		if(subset_length>set_length)
		{
			return false;
		}
		else
		{
			for(int loop_var=0;loop_var<subset_length;loop_var++)
			{
				boolean flag=false;
				int to_search=s.set[loop_var];
				for(int inner_loop_var=0;inner_loop_var<set_length;inner_loop_var++)
				{
					if(to_search==this.set[inner_loop_var])
					{
						flag=true;
					}
				}
				if(flag==false)
				{
					return false;
				}
			}
		}
		return true;
	}

	public IntSet getComplement()
	{
		int loop_var=0, range=20;
		ArrayList <Integer> working_set=new ArrayList<Integer>();
		
		for(loop_var=1;loop_var<=range;loop_var++)
		{
			working_set.add(loop_var);
		}
		for(loop_var=0;loop_var<set.length;loop_var++)
		{
			if(working_set.contains(set[loop_var]))
			{
				working_set.remove(working_set.indexOf(set[loop_var]));
			}
		}
		return new IntSet(toArray(working_set));
	}

	public IntSet union(IntSet s1, IntSet s2)
	{
		ArrayList <Integer> result=new ArrayList<Integer>();
		result=merge(s1.set,result);
		result=merge(s2.set,result);
		return new IntSet(toArray(result));
	}
	private ArrayList<Integer> merge(int to_merge[],ArrayList<Integer> merge_into)
	{
		int set_length=to_merge.length;
		for(int loop_var=0;loop_var<set_length;loop_var++)
		{
			boolean flag=false;
			int to_search=to_merge[loop_var];
			for(int value:merge_into)
			{
				if(value==to_search)
				{
					flag=true;
				}
			}
			if(flag==false)
			{
				merge_into.add(to_search);
			}
		}
		return merge_into;
	}
	private int[] toArray(ArrayList<Integer> input)
	{
		Collections.sort(input);
		int temp=0;
		int arr[]=new int[input.size()];
		for(int value:input)
		{
			arr[temp++]=value;
		}
		return arr;
	}

}
