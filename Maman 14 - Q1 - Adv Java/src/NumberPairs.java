import java.util.ArrayList;
import java.util.Random;

/**
 * The number pairs class.
 * Creates a random length array of numbers and fills with random pairs.
 */
public class NumberPairs {

	private final int MAX_NUMBER = 1000; //Max number
	private final int MAX_ARRAY_SIZE = 100; //the max array size
	private Random rand = new Random(); //Random object
	private ArrayList<String> _numberPairs; //already saving as String because I don't need to do anything with them.
	
	/**
	 * The constructor. creates a random sized ArrayList and fills it with number pairs.
	 * @throws IllegalPair
	 */
	public NumberPairs() throws IllegalPair{
		int size = rand.nextInt(MAX_ARRAY_SIZE); //determining the size of the array
		_numberPairs = new ArrayList<>(size); //creating it.
		
		for (int i = 0; i < size; i++){ //filling it with number pairs.
			_numberPairs.add(new SortedPair<Integer>(rand.nextInt(MAX_NUMBER), rand.nextInt(MAX_NUMBER)).toString());
		}
	}
	
	/**
	 * Doesn't return anything.
	 * Iterates the array and prints it out.
	 */
	public void iterateArray(){
		for (String temp : _numberPairs) { //iterate
			System.out.println(temp); //print
		}
	}
}
