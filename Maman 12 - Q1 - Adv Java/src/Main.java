import java.util.ArrayList;
import java.util.Random;


public class Main {

	private static final int MIN_SIZE = 5;
	private static final int MAX_SIZE = 10;
	


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Expression> array = new ArrayList<Expression>();
		Random rand = new Random();

		int index = rand.nextInt(MAX_SIZE)+MIN_SIZE; //the number of elements in the Expression array

		for (int i = 0; i < index ;  i++){

			AtomicExpression atmExp = new AtomicExpression(rand.nextDouble()*20);
			AtomicExpression atmExp1 = new AtomicExpression(rand.nextDouble()*20);
			AdditionExpression addExp = new AdditionExpression(atmExp, atmExp1);
			SubtractionExpression subExp = new SubtractionExpression(atmExp, addExp);
			switch( i % 3){ //TODO get rid of magic numbers
			case 0:
				array.add(atmExp);
				break;
			case 1:
				array.add(addExp);
				break;
			case 2:
				array.add(subExp);
				break;
			default:
				System.exit(0); // isn't going to happen
			}

		}		
		//TODO remove the tests
		array.add(array.get(2));
		array.add(array.get(3));
		
		for (int i = 0 ; i < array.size(); i++){
			for (int j = i+1 ; j < array.size(); j++){
				if (array.get(i).equals(array.get(j)))
					System.out.print("array[" + i + "]: " + array.get(i).toString() + " is equal to array[" + j + "]: " + array.get(j).toString() + "\n");
			}

		}
	}

}
