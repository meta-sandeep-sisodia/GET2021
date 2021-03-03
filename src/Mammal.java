package inheritance;

public class Mammal extends Animal
{
	String animal_category="MAMMAL";
	Mammal(String animal_name, String animal_voice, int animal_id, int animal_weight, int animal_age)
	{
		super(animal_name, animal_voice, animal_id, animal_weight, animal_age);
	}
}
