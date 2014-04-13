/**
 * The class that builds the sub classes - has two elements in it's constructor.<br>
 * Still it's an abstract class.
 */
public abstract class CompoundExpression extends Expression {

	protected Expression _exp1;
	protected Expression _exp2;

	/**
	 * The constructor.<br>
	 * Gets two parameters - expressions.<br>
	 * Has two sub-classes to implement the calculate() method.<br>
	 * @param exp1
	 * @param exp2
	 */
	public CompoundExpression(Expression exp1, Expression exp2) {
		_exp1 = exp1;
		_exp2 = exp2;
	}

	
	/**
	 * @return _exp1
	 */
	public Expression getExp1() {
		return _exp1;
	}

	/**
	 * @return _exp2
	 */
	public Expression getExp2() {
		return _exp2;
	}
}
