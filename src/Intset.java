import java.util.ArrayList;
import java.util.Arrays;

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

public final class Intset 
{
	private final int set[];
	private final int length;
	public static void main(String[] args)
	{
		
	}
	IntSet(int[] arr)
	{
		set=new int[length];
		set=arr;
	}

	public boolean isMember(int x)
	{
		for(int value:set)
		{
			if(value==x)
			{
				return true
			}
		}
		reurn false;
	}

	public int size()
	{
		return length;
	}
	
	public boolean isSubSet(IntSet s)
	{
		int set_length=this.length;
		int subset_length=s.length;
		if(subset_length>set_length)
		{
			return false;
		}
		
	}

	public IntSet getComplement()
	{
		//Implement by arraylist
		int index=0, loop_var=0, range=1000;
		int result=new int[range];
		ArrayList <Integer> working_set=new ArrayList();
		
		for(loop_var=0;loop_var<this.len;loop_var++)
		{
			working_set.add(this.set[loop_var]);
		}
		for(loop_var=1;loop_var<range;loop_var++)
		{
			if(working_set.contains(loop_var)==false)
			{
				result[index++]=loop_var;
			}
		}
		return new IntSet(result);
	}

	public IntSet union(IntSet s1, IntSet s2)
	{
		ArrayList<Integer> set_one=new ArrayList<Integer>(Arrays.asList(s1));
		ArrayList<Integer> set_two=new ArrayList<Integer>(Arrays.asList(s2));
		set_one.addAll(set_two);
		return new IntSet(removeDuplicates(set_one));
	}
	private int[] removeDuplicates(ArrayList<Integer> set_one)
	{
		for(int value:set_one)
		{
			if(set_one.indexOf(value)==set_one.lastIndexOf(value))
			{
				set_one.remove(set_one.lastIndexOf(value));
			}
		}
		return result;
	}	

}
