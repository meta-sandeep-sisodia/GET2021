package inheritance;

public class Animal
{
	String animal_name;
	String animal_voice;
	int animal_id=0;;
	int animal_weight;
	int animal_age;
	Animal(String animal_name, String animal_voice, int animal_id, int animal_weight, int animal_age)
	{
		this.animal_name=animal_name;
		this.animal_voice=animal_voice;
		this.animal_id=animal_id++;
		this.animal_weight=animal_weight;
		this.animal_age=animal_age;
	}
}
