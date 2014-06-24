/**
 * The exception class. thrown wherever both elements in pair are identical.
 */
public class IllegalPair extends Exception {

	private static final long serialVersionUID = 2922799982337908495L; //some generated serial
	/*
	 * The exception text thrown
	 */
	public IllegalPair(){
		System.out.println("Both elements are equal.\n"
				+ "You can't use equal numbers here.\n"
				+ "Pair not saved.");
	}
}