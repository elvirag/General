/**
 * The person class.
 * Each person has a name and a birth year.
 * It sets the dates, checks if birth year is legal, and sets the person.
 */
public class Person implements Comparable<Person>{

	private String _name; //the name of person
	private Integer _birthYear; //the birth year
	final int MAX_BIRTH_RANGE = 114; //The gap
	final int MIN_BIRTH_DATE = 1900; //The oldest person
	private String name = "Person "; //The name of the person
	private static int number = 1; //The counter applied to name people...

	/**
	 * The constructor. Generates the person object, with an unique name
	 * @param birthYear is the birth year of the person
	 */
	public Person(Integer birthYear){
		_name = name + number; //name is created and set
		number++; //number of people is incremented
		setBirthYear(birthYear); //birth year is set
	}

	private void setBirthYear(Integer birthYear) { //sets birth year after verification
		if (birthYear < MIN_BIRTH_DATE){ //if birth year is not, resetting to minimal year
			System.out.println("The person \"" + _name + "\" is too old. Resetting to " + MIN_BIRTH_DATE + ".");
			_birthYear = MIN_BIRTH_DATE;
		}

		else if (birthYear > MIN_BIRTH_DATE + MAX_BIRTH_RANGE){ //if birth year is too advanced (we don't have anyone born in 2015 yet.)
			System.out.println("The year you have written doesn't exist yet. Resetting to " + (MIN_BIRTH_DATE + MAX_BIRTH_RANGE) + ".");
			_birthYear = MIN_BIRTH_DATE + MAX_BIRTH_RANGE; //set to maximum year.
		}

		else _birthYear = birthYear; //or just set the legal one
	}

	/**
	 * Gets the birth year
	 * @return birth year
	 */
	public Integer getBirthYear(){
		return _birthYear;
	}

	/**
	 * Compares people by birth dates
	 */
	@Override
	public int compareTo(Person person) {
		if (this.getBirthYear() < person.getBirthYear())
			return -1;
		else if (this.getBirthYear() > person.getBirthYear())
			return 1;
		else
			return 0;
	}
	
	/**
	 * The toString method.
	 * Return the name and birth year of a person
	 */
	@Override
	public String toString(){
		return "( " +_name + "; " + _birthYear + " )";
	}
}