import java.util.ArrayList;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Expression> array = new ArrayList<Expression>();

		//array.add(e); // dafuck... Check laterz
		

		for (int i = 0 ; i < array.size(); i++){
			for (int j = i ; j < array.size(); j++){
				if (array.get(i).equals(array.get(j)) == 0)
					System.out.print("array[" + i + "]: " + array.get(i).toString() + " is equal to array[" + i + "]: " + array.get(j).toString());
			}

		}
	}

}
