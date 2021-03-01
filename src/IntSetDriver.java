
public class IntSetDriver {

	public static void main(String[] args)
	{
		int arr1[]=new int[]{1,2,5,6,7,8,9,4};
		int arr2[]=new int[]{5,6,7,8,9,15};
		IntSet s1=new IntSet(arr1);
		IntSet s2=new IntSet(arr2);
		System.out.println("A is member of B ="+s2.isMember(6));//Working
		System.out.println("A is subset of B ="+s1.isSubSet(s2));//Working
		System.out.println("A is Proper subset of B ="+s1.isProperSubSet(s2));//Working
		System.out.println("Size of A = "+s1.size());// Working
		System.out.println("Compliment of A = ");IntSet.printSet(s1.getComplement()); //Working
		System.out.print("\nUnion of A and B = ");IntSet.printSet(IntSet.union(s1,s2)); //Working
	}
}
