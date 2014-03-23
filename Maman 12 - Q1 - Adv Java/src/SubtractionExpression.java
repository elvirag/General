
public class SubtractionExpression extends CompoundExpression {

	private Expression _exp1;
	private Expression _exp2;
	
	public SubtractionExpression(Expression exp1, Expression exp2) {
		super(exp1, exp2);
	}

	@Override
	public double calculate() {
		return _exp1.calculate() - _exp2.calculate();
	}

}
