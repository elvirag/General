
public class SortedPair<T extends Comparable<T>>{

	private T _element1;
	private T _element2;

	public SortedPair(T element1, T element2) throws IllegalPair{
		int result = 0;
		result = element1.compareTo(element2);


		if (result < 0){
			_element1 = element1;
			_element2 = element2;
		}
		else if (result > 0){
			_element1 = element2;
			_element2 = element1;
		}
		else
			try{
				throw new IllegalPair();
			}
		catch(IllegalPair ip){
			throw new IllegalPair();
		}
	}

	public T getFirst(){
		return _element1;
	}

	public T getSecond(){
		return _element2;
	}

	@Override
	public String toString(){
		return "< " + _element1 + ", " + _element2 + " >";
	}

}
