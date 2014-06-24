import java.util.ArrayList;
import java.util.Random;

/**
 * This is the main class. all the magic happens here.
 * @author Elvira Gandelman
 * <b>ID:</b> 307032623
 *
 */
public class Main {

	private static final int PPL_NUM = 6; //number of people requested in the ArrayList

	/**
	 * Generating the people objects birth years
	 * @return the birth year
	 */
	public static int rand_gen(){
		Random rand = new Random(); //generating a new Random

		final int MAX_BIRTH_RANGE = 114; //The gap
		final int MIN_BIRTH_DATE = 1900; //THe oldest person
		//The birth date generated.
		return rand.nextInt(MAX_BIRTH_RANGE) + MIN_BIRTH_DATE;
	}
	
	
	/**
	 * The method we were requested to do in order to return the min-max pair.<br>
	 * Getting the minimal object and the max object and generating a pair that contains those elements.
	 * @param arrlist - gets an array list
	 * @return the pair requested.
	 * @throws IllegalPair
	 */
	public static <T extends Comparable<T>> SortedPair<T> minMax(ArrayList<SortedPair<T>> arrlist) throws IllegalPair{
		//get the initial values from the first pair
		T max = arrlist.get(0).getSecond();
		T min = arrlist.get(0).getFirst();
		//comparing each to the max and min values.
		for ( SortedPair<T> temp : arrlist) {
			if (temp.getSecond().compareTo(max) > 0)
				max = temp.getSecond();
			if (temp.getFirst().compareTo(min) < 0)
				min = temp.getFirst();
		}		
		return new SortedPair<T>(min, max); //return the pair.
	}


	public static void main(String[] args) throws IllegalPair {
		NumberPairs numberPairs = new NumberPairs(); //initializing a new object of numberPairs
		numberPairs.iterateArray(); //iterate it - print it out.
		//initializing the people's ArrayList
		ArrayList<SortedPair<Person>> _peoplePairs = new ArrayList<SortedPair<Person>>();

		for (int i = 0 ; i < PPL_NUM ; i++){
			try { //try adding the pair generated
				_peoplePairs.add(new SortedPair<Person>(new Person(rand_gen()), new Person(rand_gen())));
				System.out.println(_peoplePairs.get(_peoplePairs.size()-1)); //printing the people pairs.
			}
			catch(IllegalPair ip){ //handling the throw
				System.err.print("\nThis pair was found not compatible with the rules of a pair.\nIt wasn't printed.\n");
			}
		}
		//print out the minmax pair requested from the people ArrayList
		System.out.println("\nThe pair we need is: " + minMax(_peoplePairs));
	}
}
