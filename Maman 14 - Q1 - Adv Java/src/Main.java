import java.util.ArrayList;
import java.util.Random;



public class Main {

	private static final int PPL_NUM = 6;


	public static int rand_gen(){

		Random rand = new Random();
		final int MAX_BIRTH_RANGE = 114; //The gap
		final int MIN_BIRTH_DATE = 1900; //THe oldest person

		return rand.nextInt(MAX_BIRTH_RANGE) + MIN_BIRTH_DATE;
	}

	public static <T extends Comparable<T>> SortedPair<T> minMax(ArrayList<SortedPair<T>> arrlist) throws IllegalPair{
		T max = arrlist.get(0).getSecond();
		T min = arrlist.get(0).getFirst();
		
		for ( SortedPair<T> temp : arrlist) {
//			if (max == null){
//				max = temp.getSecond();
//				min = temp.getFirst();
//			}
//			
			if (temp.getSecond().compareTo(max) > 0){
				max = temp.getSecond();
			}

			if (temp.getFirst().compareTo(min) < 0){
				min = temp.getFirst();
			}
		}		
		return new SortedPair<T>(min, max);
	}


	public static void main(String[] args) throws IllegalPair {
		// TODO Auto-generated method stub
		NumberPairs numberPairs = new NumberPairs();
		numberPairs.iterateArray();

		ArrayList<SortedPair<Person>> _peoplePairs = new ArrayList<SortedPair<Person>>();

		for (int i =0 ; i < PPL_NUM ; i++){
		try {
			_peoplePairs.add(new SortedPair<Person>(new Person(rand_gen()), new Person(rand_gen())));
			System.out.println(_peoplePairs.get(_peoplePairs.size()-1));
		}
		catch(IllegalPair ip){
			System.err.print("\nThis pair was found not compatible with the rules of a pair.\nIt wasn't printed.\n");
		}
		}
		
		System.out.println("\nThe pair we need is: " + minMax(_peoplePairs));
	}

}
