package inheritance;

import java.util.ArrayList;
import java.util.List;

public class Cage
{
	private String animal_category;
	private int cage_limit;
	private List<Animal> animal;
	Cage(String animal_category, int cage_limit)
	{
		this.animal_category=animal_category;
		this.cage_limit=cage_limit;
		animal=new ArrayList<Animal>();
	}
	int addAnimalToCage(Animal animal)
	{
		if(this.animal.size()<cage_limit)
		{
			this.animal.add(animal);
			return -1;
		}
		else
		{
			return 0;
		}
	}
	public void display()
	{
		for(Animal animal:animal)
		{
			System.out.print("Animal name = "+animal.animal_name);
			System.out.print("Animal id = "+animal.animal_id);
			System.out.print("Animal voice = "+animal.animal_voice);
			System.out.print("Animal age = "+animal.animal_age);
			System.out.print("Animal weight = "+animal.animal_weight);
		}
	}
	public void removeAnimal(int animal_id)
	{
		animal.remove(animal_id);
	}
	public int searchAnimalInCage(int animal_id)
	{
		for(Animal animal:animal)
		{
			if(animal.getAnimal_id()==animal_id)
			{
				return this.animal.indexOf(animal);
			}
		}
		return -1;
	}
	public String getAnimal_category()
	{
		return animal_category;
	}
	public int getCage_limit()
	{
		return cage_limit;
	}
}
