public class MyNode
{
    private MyNode next;
    private int value;
    public MyNode(int value)
    {
        this.value=value;
    }

    public MyNode getNext()
    {
        return next;
    }

    public void setNext(MyNode next)
    {
        this.next = next;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}