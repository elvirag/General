/**
 * The first class that is not abstract.<br>
 * It's a simple number of the double type.<br>
 */
public class AtomicExpression extends Expression {

	private double _number;
	
	/**
	 * The constructor that initializes the expression
	 * @param number
	 */
	public AtomicExpression(double number){
		_number = number;
	}
	
	
	/**
	 * Implementation of the calculation.
	 * @return _number - a double
	 */
	@Override
	public double calculate() {
		return _number;
	}
	
	
	/**
	 * The only toString that is implemented for the atomic expression
	 */
	public String toString(){
		return String.valueOf(_number);
	}
}
