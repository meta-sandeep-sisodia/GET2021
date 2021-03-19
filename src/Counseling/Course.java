package Counseling;

public class Course
{
	private String name;
	private int capacity;

	Course(String name, int capacity)
	{
		this.name = name;
		this.capacity = capacity;
	}

	public int getCapacity()
	{
		return capacity;
	}

	public String getName()
	{
		return name;
	}

	public void setCapacity(int capacity)
	{
		this.capacity = capacity;
	}
}
