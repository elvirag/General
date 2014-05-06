import java.util.ArrayList;
import java.util.Random;


public class NumberPairs {

	private final int MAX_NUMBER = 1000;
	private final int MAX_ARRAY_SIZE = 100;
	private Random rand = new Random();
	private ArrayList<String> _numberPairs; //already saving as String because I don't need to do anything with them.
	
	
	public NumberPairs() throws IllegalPair{
		int size = rand.nextInt(MAX_ARRAY_SIZE);
		_numberPairs = new ArrayList<>(size);
		
		for (int i = 0; i < size; i++){
			_numberPairs.add(new SortedPair<Integer>(rand.nextInt(MAX_NUMBER), rand.nextInt(MAX_NUMBER)).toString());
		}
	}
	
	public void iterateArray(){
		for (String temp : _numberPairs) {
			System.out.println(temp);
		}
	}
	
	
}
