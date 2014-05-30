/**
 * the class that allows us to create all sorts of sorted pairs.
 * Gets two objects of the same type and returns the pair sorted.
 * @param <T> - the type of object the pair orders.
 */
public class SortedPair<T extends Comparable<T>>{

	private T _element1; //one of the elements
	private T _element2; //the second element

	/**
	 * The constructor. It sorts the pair.
	 * @param element1 - the first element in the pair (from user)
	 * @param element2 - the second element in the pair (from user)
	 * @throws IllegalPair
	 */
	public SortedPair(T element1, T element2) throws IllegalPair{
		int result = 0; //an int to compare the elements
		result = element1.compareTo(element2); //the result of the compare


		if (result < 0){ // if the first is smaller that the second, it is the first indeed.
			_element1 = element1; //putting the first as the first.
			_element2 = element2; //putting the second as the second.
		}
		else if (result > 0){ // if the first is smaller that the second, it is the second.
			_element1 = element2; //putting the first as the second.
			_element2 = element1; //putting the second as the first.
		}
		else
			throw new IllegalPair(); //if not, throws the exception
	}

	//GETTERS
	public T getFirst(){return _element1;} //returns the first element
	public T getSecond(){return _element2;} //returns the second element

	/**
	 * The toString of the class. Returns the pair as needed.
	 */
	@Override
	public String toString(){
		return "< " + _element1 + ", " + _element2 + " >";
	}

}
