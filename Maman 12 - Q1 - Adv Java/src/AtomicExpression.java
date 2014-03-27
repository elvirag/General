
public class AtomicExpression extends Expression {

	private double _number; //atomic expression - the number
	
	/**
	 * The constructor that initializes the expression
	 * @param number
	 */
	public AtomicExpression(double number){
		_number = number;
	}
	
	@Override
	public double calculate() {
		return _number;
	}
	
	public String toString(){
		return String.valueOf(_number);
	}

}
