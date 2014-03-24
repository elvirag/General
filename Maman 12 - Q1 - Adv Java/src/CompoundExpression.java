
public abstract class CompoundExpression extends Expression {

	protected Expression _exp1;
	protected Expression _exp2;

	public CompoundExpression(Expression exp1, Expression exp2) {
		_exp1 = exp1;
		_exp2 = exp2;
	}

	
	/**
	 * @return the _exp1
	 */
	public Expression getExp1() {
		return _exp1;
	}

	public Expression getExp2() {
		return _exp2;
	}



}
