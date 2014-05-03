@SuppressWarnings("serial")
public class IllegalPair extends Exception {

	public IllegalPair(){
		System.out.println("Both elements are equal.\n"
				+ "You can't use equal numbers here.\n"
				+ "Pair not saved.");
	}
}