/**
 * The abstract class Expression.<br>
 * Only implements equals (overrides it).<br>
 * Has one abstract methods so that<br>
 * the sub-classes have to implement it.
 */
public abstract class Expression {

	/**
	 * the abstract method
	 * @return a double, but not from this class.
	 */
	public abstract double calculate();
	
	/**
	 * The overriding of equals.<br> Checks equality.
	 */
	@Override
	public boolean equals(Object exp1){

		if (Expression.this.calculate() != ((Expression) exp1).calculate())
			return false;
		else
			return true;
	}
}
