public class MyLinkedList
{
    MyNode head;
    public void addToFront(int value)
    {
        MyNode node=new MyNode(value);
        node.setNext(head);
        head=node;
    }
    public MyLinkedList getSublist(int start, int end)
    {
        MyLinkedList sublist=new MyLinkedList();
        MyNode current=head;
        for(int loop_var=1;loop_var<=end;loop_var++)
        {
            int temp=current.getValue();
            current=current.getNext();
            if(loop_var>=start && loop_var<=end)
            {
                sublist.addToFront(temp);
            }
        }

        return sublist.reverse();
    }

    public MyLinkedList reverse()
    {
        MyLinkedList reverse_list=new MyLinkedList();
        MyNode current= head;
        for(int loop_var=1;loop_var<=size();loop_var++)
        {
            int temp=current.getValue();
            current=current.getNext();
            reverse_list.addToFront(temp);
        }
        return reverse_list;
    }
    public MyLinkedList rotateList(int degree)
    {
        MyNode current=head;
        for(int loop_var=0;loop_var<size()-degree;loop_var++)
        {
            current=current.getNext();
        }
        MyLinkedList rotated_list=new MyLinkedList();
        MyNode breakpoint=current;
        while (current!=null)
        {
            rotated_list.addToFront(current.getValue());
            current=current.getNext();
        }
        current=head;
        while(current!=breakpoint)
        {
            rotated_list.addToFront(current.getValue());
            current=current.getNext();
        }
        return rotated_list.reverse();
    }
    public MyLinkedList mergetoList(MyLinkedList list)
    {
        MyLinkedList merged_list=new MyLinkedList();
        MyNode head1=head;
        MyNode head2=list.head;
        MyNode tail = head1;
        while (tail != null)
        {
            if (tail.getNext() == null && head2 != null)
            {
                tail.setNext(head2);
                break;
            }
            tail = tail.getNext();
        }
        merged_list.head=head1;
        return merged_list;
    }

    public boolean detectLoop()
    {
        MyNode slow_pointer = head, fast_pointer = head;
        boolean loop_found=false;
        while (slow_pointer != null && fast_pointer != null && fast_pointer.getNext() != null)
        {
            slow_pointer = slow_pointer.getNext();
            fast_pointer = fast_pointer.getNext().getNext();
            if (slow_pointer == fast_pointer)
            {
                loop_found=true;
                break;
            }
        }
        return loop_found;
    }

    public void printList()
    {
        MyNode current=head;
        System.out.print("Head -> ");
        while(current!=null)
        {
            System.out.print(current.getValue()+" -> ");
            current=current.getNext();
        }
        System.out.println("Null");
    }
    public String getList()
    {
        MyNode current=head;
        String str="";
        str+="Head -> ";
        while(current!=null)
        {
            str+=(current.getValue()+" -> ");
            current=current.getNext();
        }
        str+=("Null");
        return str;
    }
    public int size()
    {
        MyNode current=head;
        int count=0;
        while(current!=null)
        {
            count++;
            current=current.getNext();
        }
        return count;
    }
    public boolean isEmpty()
    {
        return head == null;
    }

    public Integer removeFromFront()
    {
        if(head==null)
        {
            return null;
        }
        int value=head.getValue();
        head=head.getNext();
        return value;
    }
    public void removeAll()
    {
        head=null;
    }
}