import java.util.ArrayList;
import java.util.Collections;

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
	private final int set[];
	public static void main(String[] args)
	{
		getHelp();
	}
	
	
	public static void getHelp()
	{
		System.out.println("IntSet Operation Avaliable");
		System.out.println("1. IntSet s = s.isMember(int x) - check whether x is a member of the set and return a boolean value");
		System.out.println("2. IntSet s = s.size() - return the size of the set");
		System.out.println("3. IntSet s = s.isSubSet(intSet s2) - check whether s is a subset of the set");
		System.out.println("4. IntSet s = s.getComplement()  - return the complement set, 1..1000 is the universal set");
		System.out.println("5. IntSet.union(intSet s1, intSet s2) - (Static method), return the union of s1 and s2");
		System.out.println("6. IntSet.printSet(IntSet s) - print the set");
	}
	
	
	IntSet(int[] arr)
	{
		if(validateInput(arr)==true)
		{
			this.set=arr;
		}
		else
		{
			System.out.println("Invalid value for a set\n-> Duplicate item maybe present\n\tor\n-> Element out of Universal set are present\n   Universal set(1-1000)");
			this.set=null;
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

	public static IntSet union(IntSet s1, IntSet s2)
	{
		ArrayList <Integer> result=new ArrayList<Integer>();
		result=merge(s1.set,result);
		result=merge(s2.set,result);
		return new IntSet(toArray(result));
	}
	private static ArrayList<Integer> merge(int to_merge[],ArrayList<Integer> merge_into)
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
	private static int[] toArray(ArrayList<Integer> input)
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
