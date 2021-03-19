public class NumberStack
{
    int top = -1;
    LinkedList list = new LinkedList(); // Backed by LinkedList

    public void push(int element)
    {
        if(top >= list.size())
        {
            throw new AssertionError("Overflow stack");
        }
        top++;
        list.addToFront(element);
    }

    public int pop()
    {
        if(top == -1)
        {
        	throw new AssertionError("Underflow Stack");
        }
        int element = list.removeFromFront();
        top--;
        return element;
    }
    public int peek()
    {
        return list.getHead();
    }
    public boolean isEmpty()
    {
        return top == -1;
    }
}