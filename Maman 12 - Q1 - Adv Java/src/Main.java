import java.util.ArrayList;

/**
 * The main class.<br>
 * Generates expressions by calling the generator class,<br>
 * puts them into an array and prints if numbers are equal.<br>
 * 
 * @author Elvira Gandelman<br>
 * ID: 307032623
 */
public class Main {

	private static final int ARR_SIZE = 1000;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Expression> array = new ArrayList<Expression>();
		Generator gen = new Generator();
		
		for (int i = 0 ; i < ARR_SIZE ; i++)
			array.add(gen.generate());
		
		System.out.println("This array has " + ARR_SIZE + " elements.\nThe elements are:\n"); //printing a title for the array
		for (int i = 0 ; i < array.size(); i++){
			for (int j = i+1 ; j < array.size(); j++){
				if (array.get(i).equals(array.get(j)))//checking if there is an equal element in the whole array.
													  //if so, printing it and stating the equality
					System.out.print("array[" + i + "]: " + array.get(i).toString() + " is equal to array[" + j + "]: " + array.get(j).toString() + "\n");
			}
		}
	}
}