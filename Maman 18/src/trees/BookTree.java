package trees;

/**
 * BookTree.java
 * Purpose: A red Black Tree of currently Loaned books
 * Note: The tree is sorted by book codes 
 * 		 (6 characters: 2 capital letters followed by 4 integers)
 */
public class BookTree extends RBTree{

	/** Class Constructor (default) */
	public BookTree(){
		super();
	}
	
	/** 
	 * used in constructors to prevent Type hiding
	 * @return a new Node of appropriate Type (BookNode) 
	 */
	@Override
	protected Node createNode() {
		return createNode("");
	}
	
	/**
	 * used in constructors to prevent Type hiding
	 * @param id book code of the created Node
	 * @return a new Node of this Type (as opposed to super type)
	 */
	@Override
	protected Node createNode(String id) {
		return new BookNode(id, _nil, this, null);
	}
	
	/**
	 * finds the person currently holding this book
	 * @param bookCode the code of the book in question
	 * @return the details of the person that holding this book
	 */
	public String getPerson(String bookCode) {
		IDNode person = search(bookCode).getPerson();
		return person.getDetails();
	}

	/**
	 * remove the given book from the database (reflect in the console)
	 * @param book the book code of the book to be removed
	 */
	public void remove(String book) {
		BookNode toRemove = search(book); //find the book
		
		//formated output
		System.out.println("Book " + book + " was returned by " + toRemove.getPerson().getKey() + ", " + toRemove.getPerson().getName() +  ".\n");
		
		toRemove.getPerson().returnBook(book); //invoke the returnBook() method for the person database
		delete(this, toRemove); //remove from this tree
	}
	
	/**
	 * add the given book to the database (reflect in the console)
	 * @param book the book code of the book to be added
	 * @param node a reference to the person loaning this book
	 */
	public void add(String book, IDNode node) {
		BookNode toAdd = new BookNode(book, null, this, node);
		
		//formated output
		System.out.println("Book " + book + " was borrowed by " + node.getKey() + ", " + node.getName() +  ".\n");
		
		toAdd.getPerson().loanBook(book); //invoke the loanBook() method for the person database
		insert(this, toAdd); //insert to this tree
	}
	
	/**
	 * Search for a book in this tree
	 * @param book the book code of this book
	 * @return the BookNode containing this book (or nil[Tree] if not found)
	 */
	public BookNode search(String book) {
		BookNode curr = (BookNode) _root; //"index"
		
		//binary tree search
		while(curr != _nil){
			if(curr.getKey().equals(book))//found the book code
				return curr;
			//lexicographic comparison (by book codes)
			else if(book.compareTo(curr.getKey())<0)
				curr =  (BookNode) curr._left;
			else
				curr =  (BookNode) curr._right;
			
		}
		return curr; //book was not found in loop. return nil[Tree]
	}

	/** @return the nil[Tree] */
	@Override
	public BookNode getNil() {
		return (BookNode)_nil;
	}

	/** @return the root[Tree] */
	@Override
	public BookNode getRoot() {
		return (BookNode)_root;
	}

}
