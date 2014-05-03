import java.util.ArrayList;


public class Main {

	public static void main(String[] args) throws IllegalPair {
		// TODO Auto-generated method stub
		NumberPairs numberPairs = new NumberPairs();
		numberPairs.iterateArray();
	
		ArrayList<String> _peoplePairs = new ArrayList<String>();
		
		_peoplePairs.add(new SortedPair<Person>(new Person("Person 1", 1983), new Person("Person 2", 1984)).toString());
		System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
		_peoplePairs.add(new SortedPair<Person>(new Person("Person 2", 1983), new Person("Person 2", 1984)).toString());
		System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
		_peoplePairs.add(new SortedPair<Person>(new Person("Person 3", 1969), new Person("Person 4", 1900)).toString());
		System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
		_peoplePairs.add(new SortedPair<Person>(new Person("Person 5", 1971), new Person("Person 6", 2005)).toString());
		System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
		_peoplePairs.add(new SortedPair<Person>(new Person("Person 7", 1899), new Person("Person 8", 1984)).toString());
		System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
		_peoplePairs.add(new SortedPair<Person>(new Person("Person 9", 1913), new Person("Person 10", 1913)).toString());
		System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
		_peoplePairs.add(new SortedPair<Person>(new Person("Person 100", 1100), new Person("Person 200", 1200)).toString());
		System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
	}

}
