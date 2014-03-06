package trees;

import elvira.michael.LibraryDB;
import elvira.michael.Link;

/**
 * IDNode.java
 * Purpose: represent a person (node) in people database (Red-Black-Tree)
 */
public class IDNode extends Node {
	
	final static int MAX_BOOKS= 10;
	
	private String[] _books; //an array of books that are currently loaned to this person
	private String _name; //the name of the person
	private Link _ptrLink; //pointer to a node in MaxArray
	private int _numOfBooks; //number of currently loaned books
	private LibraryDB _libDB; //a link to the main database
	
	/**
	 * Class Constructor
	 * @param key the ID number of the person
	 * @param name name of the person
	 * @param parent the parent Node of this node
	 * @param libDB the main database
	 */
	public IDNode(String key, String name, Node parent, LibraryDB libDB){
		//the parent @param is used in IDTree.createNode() to set the parent to nil[Tree]
		super(key);
		_libDB = libDB;
		_numOfBooks = 0;
		_name = name;
		_ptrLink = new Link(key, _name);
		initBooks();
	}
		
	/**
	 * copy the satellite data from another node 
	 * @param other the node to be copied from
	 * @param libDB a link to the main database
	 */
	public IDNode(IDNode other, LibraryDB libDB){
		super(other);
		_libDB = libDB;
		_numOfBooks = 0;
		_ptrLink = new Link(other.getKey(), other.getName());
		initBooks();
	}
	
	/*
	 * Used in IDTree to create IDNode (as opposed to Node)
	 */
	protected IDNode createNode(){
		return new IDNode("", "", null, _libDB);
	}
	
	/**
	 * Remove a person from the database (return all books in his , if any) 
	 * @param node the person to be removed from the database
	 */
	public void remove(IDNode node){
		
		if(node.getNumOfBooks()>0){//return all books (if any)
			int numOfBooks = node.getNumOfBooks();
			for(int i = 0; i< numOfBooks; i++)
				_libDB.bookAction(node.getBooks()[i], false, node.getKey());
		}
		
		_libDB.getMaxArr().remove(_ptrLink, _numOfBooks); //update the Maximum books array in main database

	}
	
	/**
	 * copy the satellite data from another IDNode 
	 * @param other the IDNode to be copied from
	 */
	@Override
	public void copyData(Node other){
		super.copyData(other);
		IDNode temp = (IDNode) other;
		_books = temp.getBooks();
		_name = temp.getName();
		_ptrLink = temp.getPtrLink(); 
		_numOfBooks = temp.getNumOfBooks(); 	
	}

	/**
	 * Loan a new book to this person
	 * @param book the book to be loaned
	 */
	public void loanBook(String book){
		if(_numOfBooks>=MAX_BOOKS)
			return;
		
		_books[_numOfBooks]=book;
		_numOfBooks++;
		//update the Maximum books array in main database if needed
		_libDB.getMaxArr().relocate(_ptrLink, _numOfBooks, _numOfBooks-1);
	}
	
	/**
	 * Return a book to the library
	 * @param book the book to be returned
	 */
	public void returnBook(String book){
		int index = findBook(book);
		if(_numOfBooks <= 0 || index < 0 ) //no books or the book is not in the array
			return;
		
		//swap the returned book with the last book and subtract 1 from number of books
		_books[index] = _books[_numOfBooks-1];
		_numOfBooks--;
		
		//update the Maximum books array in main database if needed
		_libDB.getMaxArr().relocate(_ptrLink, _numOfBooks, _numOfBooks+1);
	}

	//find the index of given book (if this person have it)
	private int findBook(String book) {
		int i=0;
		
		while(i<_numOfBooks){
			if(_books[i].equals(book))
				return i;
			i++;
		}
		
		return -1; //this person does'nt have this book
	}

	/** @return the books currently loaned to this person */
	public String printBooks(){
		String str="";
		
		//format the output string
		for(int i=0; i<_numOfBooks; i++){
			str+=_books[i];
			if(i < _numOfBooks-1)
				str+=", ";
		}
		str+= ".";
		return str;
	}
	
	//initialize the books array (to prevent "junk" values) 
	private void initBooks(){
		_books = new String[MAX_BOOKS];
		for(int i=0; i<MAX_BOOKS; i++)
			_books[i]="";
	}
	
	//GETTERS
	/** @return the array of books loaned to this person */
	public String[] getBooks() {
		return _books;
	}

	/** @return the link to the Max Books List */
	public Link getPtrLink() {
		return _ptrLink;
	}

	/** @return the number of books loaned to this person */
	public int getNumOfBooks() {
		return _numOfBooks;
	}
	
	/** @return the persons name */
	public String getName() {
		return _name;
	}

	/** @return a String representation of this person */
	public String getDetails() {
		return _key+", "+_name; 
	}

	//SETTERS
	/**
	 * set a new name for this person
	 * @param name the new name to be set
	 */
	public void setName(String name){
		_name = name;
	}
	
	/**
	 * set a new books array to this person
	 * @param books the new array of books
	 */
	public void setBooks(String[] books) {
		_books = books;
	}

	/**
	 * set a new link to the max books List
	 * @param ptrLink the new link to be set
	 */
	public void setPtrLink(Link ptrLink) {
		_ptrLink = ptrLink;
	}

	/**
	 * set a new number of books (in possession of this person)
	 * @param numOfBooks the new number of books to be set
	 */
	public void setNumOfBooks(int numOfBooks) {
		_numOfBooks = numOfBooks;
	}
}
