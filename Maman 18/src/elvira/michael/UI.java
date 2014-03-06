package elvira.michael;

/**
 * UI.java
 * Purpose: Determine the type of the current input line 
 *          and pass the correct order to the database (LibraryDB).
 */
public class UI {
	
	private LibraryDB _libDB; //the main database
	
	//the length of strings ID and Book Code (assumed from the maman requirements)
	private final int ID_LENGTH = 9, BOOK_LENGTH = 6; 
	
	//the types of the input line (empty line/message/question/error)
	private enum Types{EMPTY_LN , MSG , QUESTION, ERROR};
	
	//the start of the item (that stated in variable name) from the end of a legal input line
	private final int BOOK_START = 8, NAME_START = 10,
					  ID_START1 = 19, ID_START2 = 10; //version 1 and 2 for different input types
	
	
	/** Class Constructor (default) */
	public UI(){
		_libDB = new LibraryDB();
	}

	/**
	 * Determine what type of line is the currently read line
	 * @param inputLine the currently analyzed line of input
	 */
	public void analyzeLine(String inputLine) {
		Types type = findType(inputLine);
 
		//the line is empty or contains any type of error
		if(type==Types.EMPTY_LN || type==Types.ERROR)
			return;
		
		if(type == Types.MSG){//found a message in this line
			determineMsg(inputLine);
			return;
		}
		
		if(type == Types.QUESTION){//found a question in this line
			determineQuestion(inputLine);
			return;
		}
	}
	
	/* Determine the type of a given line, by identifying characters*/
	private Types findType(String input){
		if(input.equals("") || input.equals("\n") || input.equals(" "))
			return Types.EMPTY_LN; //Note: only empty lines can start with a " " (space)
		
		//line starts with a character or '+'/'-' sign
		if( (input.charAt(0)>='a' && input.charAt(0)<='z') ||
				 (input.charAt(0)>='A' && input.charAt(0)<='Z') ||
				 (input.charAt(0)=='+' || input.charAt(0)=='-') )
			return Types.MSG;
		
		//line starts with a '?" (question mark)
		if(input.charAt(0)=='?')
			return Types.QUESTION;

		return Types.ERROR; //no suitable type was found (for example: no line should start with a number)
	}
	
	/* determines the type of the question being asked and act accordingly */
	private void determineQuestion(String input){
		//reflect the input, back to the user through Console
		System.out.println("Input is: " + input);
		System.out.print("Output: ");
		
		char second = input.charAt(1); //get the second character of the input (after '?' identifier)
		String str = input.substring(1); //get the rest of the input (this is the significant part of the request)
		
		if(second>='0' && second<='9'){ // what books does this person have  - sheilta
			if(str.length()!=ID_LENGTH){
				System.out.println("illegal ID in line number ");
				return;
			}
			_libDB.printBooks(str);
		}
		
		else if(second=='!'){ //checking what IDs have maximum number of book - sheilta
			_libDB.printMaxBooks();
		}
		
		else{ //checking who has this book - sheilta
			if(str.length()!=BOOK_LENGTH){
				System.out.println("illegal book code in line number ");
				return;
			}
			_libDB.hasBook(str);	
		}
		
		System.out.println();
	}
	
	/* determines the type of the message being sent and act accordingly */
	private void determineMsg(String input){
		//reflect the input, back to the user through Console
		System.out.println("Input is: " + input);
		System.out.print("Output: ");
		
		boolean add = true; // add/remove the item in this message
		boolean isBook = true; //item is a book if true, or a person otherwise
		
		String book; //will contain the book code
		
		if(input.charAt(0) == '-' || input.charAt(input.length()-1) == '-')
			add = false;
		
		
		if(input.charAt(0) == '-' || input.charAt(0) == '+'){ // adding/removing a person
			isBook = false;
			_libDB.IDAction(findID(input, isBook), add, findName(input));
		}
		else{ // adding/removing a book
			book = findBook(input);
			_libDB.bookAction(book, add, findID(input, isBook));
		}
		
	}

	/* return the book code in the input line */ 
	private String findBook(String input) {
		int bookStart = input.length() - BOOK_START;
		
		return input.substring(bookStart, bookStart+BOOK_LENGTH);
	}

	/* return the person ID in the input line */ 
	private String findID(String input, boolean isBook) {
		/* Different message types:
		 * when loaning/returning a book; and when adding/removing a person */
		int idStart = isBook ?  input.length()-ID_START1 : input.length()-ID_START2;
		
		return input.substring(idStart+1, idStart+ID_LENGTH+1);
	}
	
	/* return the person name in the input line */ 
	private String findName(String input) {
		return input.substring(2, input.length()-NAME_START);
	}
	
}
