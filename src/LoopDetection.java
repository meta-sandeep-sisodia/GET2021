public class LoopDetection
{
    public static void main(String args[])
    {
        MyLinkedList list = new MyLinkedList();
        list.addToFront(10);
        list.addToFront(15);
        list.addToFront(11);
        list.addToFront(8);
        list.addToFront(19);
        list.addToFront(0);
        list.addToFront(-10);
        list.addToFront(20);

        // Simulating loop for testing
        // list.head.getNext().getNext().getNext().setNext(list.head.getNext().getNext());

        System.out.println(list.detectLoop()?"Loop Found":"Loop Not Found");
    }
}