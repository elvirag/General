
public class SubtractionExpression extends CompoundExpression {

	public SubtractionExpression(Expression exp1, Expression exp2) {
		super(exp1, exp2);
	}

	@Override
	public double calculate() {
		return _exp1.calculate() - _exp2.calculate();
	}

	public String toString(){
		return "( " + _exp1.toString() + " - " + _exp2.toString() + " )";
	}
}
