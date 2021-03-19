package Counseling;

public class StudentQueue
{
	private Student[] students;
	private int rear = 0;
	private int front = 0;
	private int size;

	StudentQueue(int size)
	{
		this.size = size;
		this.students = new Student[size];
	}

	public void enQueue(Student student)
	{
		if (rear < size)
		{
			this.students[rear++] = student;
		}
	}

	
	public int getSize()
	{
		return size;
	}

	
	public Student deQueue()
	{

		if (front <= rear)
		{
			return students[front++];
		}
		return null;
	}
}
