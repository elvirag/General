import java.util.Random;
/**
 * The class that generates all the expressions.<br>
 * The way how is explained inside class.
 */
public class Generator {

	private static final int EXP_TYPES = 10; //All types of expressions
	private Random rand = new Random(); // A random object, I need it for generating the switch and the numbers themselves

	/**
	 * In this function I generate all different kinds of expressions.<br>
	 * Because for an expression that constitutes of two more complex expressions<br>
	 * there are 8 (2^3) possibilities, I will cover them here by this order:<br><br>
	 * case 3: +++<br>
	 * case 4: ++-<br>
	 * case 5: +--<br>
	 * case 6: +-+<br>
	 * case 7: -++<br>
	 * case 8: -+-<br>
	 * case 9: --+<br>
	 * case 10: ---<br><br>
	 * @return the appropriate expression
	 */
	public Expression generate() {
		switch(rand.nextInt(EXP_TYPES)){
		case 0:
			//new regular atomic expression
			return new AtomicExpression(rand.nextDouble()*20);
		case 1:
			//new addition expression i.e. 5 + 3
			return new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20));
		case 2:
			//new subtraction expression i.e. 5 - 3
			return new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20));
		case 3:
			return new AdditionExpression(new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		case 4:
			return new AdditionExpression(new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		case 5:
			return new SubtractionExpression(new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		case 6:
			return new SubtractionExpression(new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		case 7:
			return new AdditionExpression(new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		case 8:
			return new AdditionExpression(new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		case 9:
			return new SubtractionExpression(new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new AdditionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		case 10:
			return new SubtractionExpression(new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)), new SubtractionExpression(new AtomicExpression(rand.nextDouble()*20), new AtomicExpression(rand.nextDouble()*20)));
		}
		return null; //not supposed to happen
	}
}
