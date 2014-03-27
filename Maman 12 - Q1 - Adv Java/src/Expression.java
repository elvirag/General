
public abstract class Expression {

	public abstract double calculate(); //the abstract method
	
	@Override
	public boolean equals(Object exp1){

		if (Expression.this.calculate() != ((Expression) exp1).calculate())
			return false;
		else
			return true;
	}
}
