package trees;

/**
 * BookNode.java
 * Purpose: represent a book in the database (that is currently on loan)
 */
public class BookNode extends Node {

	private IDNode _idPtr;// points to the person that has loaned this book
	
	/**
	 * Class Constructor 
	 * @param key the book code
	 * @param parent the parent of this BookNode in a tree
	 * @param tree the tree to which this BookNode is related
	 * @param person the person who loaned this book
	 */
	public BookNode(String key, Node parent, BookTree tree, IDNode person) {
		super(key);
		_idPtr = person; 
	}
	
	/**
	 * Copy the "satellite" data from another book item, to this one
	 * @param other the book item to be copied from
	 */
	@Override
	public void copyData(Node other){
		super.copyData(other);
		BookNode temp = (BookNode) other; //casting to reach the fields extended from Node class
		_idPtr = temp.getPerson();
	}

	/** @return the person that is currently in possession of this book */
	public IDNode getPerson(){
		return _idPtr;
	}

}
