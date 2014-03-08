package elvira.michael;

import java.util.Scanner;

/**
 * Main.java
 * Purpose: The main class of the project. Receive input and pass to relevant Class (UI).
 *
 * @author Elvira Gandelman and Michael Kurtzer
 * @version 2014a
 */
public class Main {

	/**
	 * The main method of this project
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		UI ui = new UI();
		
		//line-by-line input reading
		while( scan.hasNext() ){
			ui.analyzeLine(scan.nextLine());
		}
		scan.close();
	}
}
