package Counseling;

public class Student
{
	private String name;
	private String preference[];
	private String assigned;

	Student(String name, String preference[])
	{
		this.name = name;
		this.preference=preference;
		this.assigned = "";
	}
	
	public String getAssigned()
	{
		return assigned;
	}
	
	public void setAssigned(String assigned)
	{
		this.assigned = assigned;
	}
	
	public String getName()
	{
		return name;
	}

	public String getPreference(int index)
	{
		return preference[index];
	}
}
