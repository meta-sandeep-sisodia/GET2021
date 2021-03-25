import java.util.InputMismatchException;
import java.util.Scanner;

public class RotateSubList
{
    MyLinkedList list=new MyLinkedList();
    int start;
    int end;
    int no_of_rotation;
    Scanner scanner=new Scanner(System.in);
    public RotateSubList() //Constructor
    {
        takeInputFromUser();
    }
    public RotateSubList(MyLinkedList list,int start,int end,int no_of_rotation)
    {
	    this.list=list;
	    this.start=start;
	    this.end=end;
	    this.no_of_rotation=no_of_rotation;
    	if(validate())
    	System.out.println(getResult());
    }
    
    public String getResult()
    {
	        MyLinkedList rotated_list=rotate(start,end,no_of_rotation%(end-start+1));
	        MyLinkedList sublist_left=list.getSublist(0,start-1); //getting sublist to merge
	        MyLinkedList sublist_right=list.getSublist(end+1,list.size());
	        // Merging
	        rotated_list=sublist_left.mergetoList(rotated_list);
	        rotated_list=rotated_list.mergetoList(sublist_right);
	        String result=rotated_list.getList();
			return result;
    }
    
    public boolean validate()
    {
		if(list==null)
		{
			throw new AssertionError("Null List Passed");
		}
		else if(start>end)
		{
			throw new AssertionError( "Starting index for sublist can't be greater than end");
		}
		else if(start<0||end<0||start>=list.size()||end>list.size()||end-start<0)
		{
			throw new AssertionError("Invalid Start or End values");
		}
		else if(no_of_rotation<0)
		{
			throw new AssertionError( "Rotation cant be in negative");
		}
		return true;
	}
    
	private void takeInputFromUser()
    {
    	System.out.println("Enter the number of items in list : ");
        int count=getInput();
        if(count<=0)
        {
        	System.out.println("Operations can't be performed on Null list");
        	System.exit(-1);
        }
        while (count>0)
        {
            System.out.println("Enter the value for node : ");
            list.addToFront(getInput());
            count--;
        }
        list.printList();
        System.out.println("Enter starting position of sublist : ");
        int start=getInput();
        System.out.println("Enter ending position of sublist : ");
        int end=getInput();
        int no_of_rotation;
        if((start<=0||start>list.size()||end<=0||end>list.size())&&start>=end) //check for invalid sublist values L
        {
            System.out.println("Invalid values for sublist from a list of size "+list.size());
            System.exit(-2);
        }
        else
        {
        	System.out.println("Enter no of rotation to be performed");
        	no_of_rotation=getInput(); // Assign
        	new RotateSubList(list,start,end,no_of_rotation);
        }
    	
    }

    private MyLinkedList rotate(int start, int end, int no_of_rotation)
    {
        MyLinkedList sublist=list.getSublist(start,end);
        sublist=sublist.rotateList(no_of_rotation);
        return sublist;
    }


    private int getInput()
    {
        try
        {
            return scanner.nextInt();
        }
        catch (InputMismatchException e)
        {
            System.out.println("Please enter integer value only");
            scanner.next();
            return getInput();
        }
    }

    public static void main(String[] args)
    {
        new RotateSubList();
    }
}