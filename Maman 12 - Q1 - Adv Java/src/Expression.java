
public abstract class Expression {

	public abstract double calculate();
	
	public int equals(Expression exp1){
		if (Expression.this.calculate() > exp1.calculate())
			return 1;
		else if (Expression.this.calculate() < exp1.calculate())
			return -1;
		else
			return 0;
	}
}
