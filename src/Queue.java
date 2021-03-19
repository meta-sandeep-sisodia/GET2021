class Queue
{
    private  int front, rear, capacity;
    private  int queue[];

    Queue(int capacity)
    {
        front = rear = 0;
        this.capacity = capacity;
        queue = new int[this.capacity];
    }

    void addToQueue(int data)
    {
        if (isFull())
        {
            throw new AssertionError("Queue is full");
        }
        else
        {
            queue[rear] = data;
            rear++;
        }
    }

    void removeFromQueue()
    {
        if (isEmpty())
        {
            throw new AssertionError("Queue is Empty");
        }
        else
        {
            if (rear - 1 >= 0) System.arraycopy(queue, 1, queue, 0, rear - 1);
            if (rear < capacity)
            {
                queue[rear] = 0;
            }
            rear--;
        }
    }

    boolean isEmpty()
    {
        return front == rear;
    }

    boolean isFull()
    {
        return capacity == rear;
    }

    void printQueue()
    {
        if (isEmpty())
        {
            System.out.printf("%s < ","Null");
        }
        for (int loop_var = front; loop_var < rear; loop_var++)
        {
            System.out.printf("%d < ", queue[loop_var]);
        }
        System.out.println();
    }

    int getFront()
    {
        if (front == rear)
        {
            throw new AssertionError("Queue is Empty");
        }
        return queue[front];
    }
}

