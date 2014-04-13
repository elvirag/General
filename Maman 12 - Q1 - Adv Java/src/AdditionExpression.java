/**
 * The class that handles the subtraction expression<br>
 * (exp - exp)
 */
public class AdditionExpression extends CompoundExpression {

	/**
	 * The constructor. Gets two other expressions
	 * @param exp1
	 * @param exp2
	 */
	public AdditionExpression(Expression exp1, Expression exp2) {
		super(exp1, exp2);
	}

	/**
	 * Calculates the subtraction of expressions
	 */
	@Override
	public double calculate() {
		return _exp1.calculate() + _exp2.calculate();
	}
	
	
	/**
	 * The toString method
	 */
	public String toString(){
		return "( " + _exp1.toString() + " + " + _exp2.toString() + " )";
	}
}
