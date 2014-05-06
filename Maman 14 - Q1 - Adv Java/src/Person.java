
public class Person implements Comparable<Person>{

	private String _name;
	private Integer _birthYear;
	final int MAX_BIRTH_RANGE = 114; //The gap
	final int MIN_BIRTH_DATE = 1900; //THe oldest person

	public Person(String name, Integer birthYear){
		_name = name;
		setBirthYear(birthYear);
	}

	private void setBirthYear(Integer birthYear) {
		if (birthYear < MIN_BIRTH_DATE){
			System.out.println("The person is too old. Resetting to " + MIN_BIRTH_DATE + ".");
			_birthYear = birthYear;
		}

		if (birthYear > MIN_BIRTH_DATE + MAX_BIRTH_RANGE){
			System.out.println("The year you have written doesn't exist yet. Resetting to " + (MIN_BIRTH_DATE + MAX_BIRTH_RANGE) + ".");
			_birthYear = MIN_BIRTH_DATE + MAX_BIRTH_RANGE;
		}

		else _birthYear = birthYear;
	}
	
	public Integer getBirthYear(){
		return _birthYear;
	}
	
	@Override
	public String toString(){
		return "( " +_name + "; " + _birthYear + " )";
	}

	@Override
	public int compareTo(Person person) {
		if (this.getBirthYear() < person.getBirthYear())
			return -1;
		else if (this.getBirthYear() > person.getBirthYear())
			return 1;
		else
			return 0;
	}
}
