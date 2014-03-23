
public abstract class CompoundExpression extends Expression {

	private Expression _exp1;
	private Expression _exp2;

	public CompoundExpression(Expression exp1, Expression exp2) {
		_exp1 = exp1;
		_exp2 = exp2;
	}

	@Override
	public abstract double calculate();

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
