package elvira.michael;

import trees.BookTree;
import trees.IDNode;
import trees.IDTree;

/**
 * LibraryDB.java
 * Purpose: The general implementation of the main database.
 *          Controls the lower databases
 */
public class LibraryDB {
	
	private IDTree _idTree;    //Red Black Tree of people 
	private BookTree _books;   //Red Black Tree of books 
	private MaxArray _idArray; //An array of lists. Containing the names, IDs and sorted by amount of books
	
	/** Class Constructor (default) */
	public LibraryDB(){
		//initialize the instance variables
		_idArray = new MaxArray();
		_idTree = new IDTree(this);
		_books = new BookTree();
		
	}
	
	/**
	 * Printing (to console), the list of books in someone's possession 
	 * @param ID the parameter by which a person is searched
	 */
	public void printBooks(String ID) {
		IDNode person = _idTree.search(ID);
		System.out.println("This person (" + person.getDetails() +  ") has loaned the following books:\n" + person.printBooks());
	}
	
	/**
	 * Printing the list of people that are currently in possession of the highest amount of books 
	 */
	public void printMaxBooks(){
		_idArray.printMaxIDs();
	}

	/**
	 * Printing the details of the person, that holds a specific book
	 * @param bookCode the parameter by which a book is searched
	 */
	public void hasBook(String bookCode) {
		System.out.println("This book ("+bookCode+") is loaned to: "+ _books.getPerson(bookCode));	
	}

	/**
	 * Performs an action on a specified person (actions are: Add/Remove)
	 * @param id the person to added/removed
	 * @param add The person will be added if true, or removed otherwise
	 * @param name The name of the person
	 */
	public void IDAction(String id, boolean add, String name) {
		
		if(add){
			_idTree.add(_idTree, id, name);
		}
		else
			_idTree.remove(id);

	}

	/**
	 * Performs an action on a specified person (actions are: Loan to a person and Return to the library)
	 * @param book the book to be loaned/returned
	 * @param add the book will be Loaned when true, or returned otherwise
	 * @param id the person that loans/returns the book
	 */
	public void bookAction(String book, boolean add, String id) {
		
		if(add){
			IDNode person = _idTree.search(id); //assuming input is correct (there exists such an id)
			_books.add(book, person);
		}
		else{
			_books.remove(book);
		}
	}
	
	/**
	 * @return the array of Lists, sorted by books that a person has
	 */
	public MaxArray getMaxArr(){
		return _idArray; //allowing aliasing for internal use (by the program)
	}
	

}
