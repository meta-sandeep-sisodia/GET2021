public class Main
{
    public static void main(String[] args) throws Exception
    {
        Queue queue = new Queue(4);
        queue.printQueue();

        // inserting elements in the queue
        queue.addToQueue(20);
        queue.addToQueue(30);
        queue.addToQueue(40);
        queue.addToQueue(50);

        // print Queue elements
        queue.printQueue();

        // insert element in the queue
        //q.addToQueue(60);

        // print Queue elements
        queue.printQueue();

        queue.removeFromQueue();
        queue.removeFromQueue();
        System.out.printf("\n\nafter two node deletion\n\n");

        // print Queue elements
        queue.printQueue();

        // print front of the queue
        System.out.println(queue.getFront());
    }
}
