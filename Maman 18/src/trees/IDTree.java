package trees;

import elvira.michael.LibraryDB;

/**
 * IDTree.java
 * Purpose: Tree of customers (and books in their possession). 
 */
public class IDTree extends RBTree{

	private LibraryDB _libDB; //link to the main database
	
	/** Class Constructor (default) */
	public IDTree(LibraryDB libDB){
		super();
		_libDB = libDB;
		
	}
	
	/** 
	 * used in constructors to prevent Type hiding
	 * @return a new Node of appropriate Type (IDNode) 
	 */
	@Override
	protected Node createNode() {
		return createNode("");
	}
	
	/**
	 * used in constructors to prevent Type hiding
	 * @param id persons ID number of the created Node
	 * @return a new Node of this Type (as opposed to super type)
	 */
	@Override
	protected Node createNode(String id) {
		return new IDNode(id, "", _nil, _libDB);
	}
	
	/**
	 * remove the given book from the database (reflect in the console)
	 * @param id the id of the person to be removed
	 */
	public void remove(String id) {
		IDNode toRemove = search(id); //find the person to be removed
		
		//formated output
		System.out.println("The following person was removed (and returning all books, if any) : " + id + ", " + toRemove.getName() +  ".\n");
		
		toRemove.remove(toRemove); //invoke the remove of the Node (returns all loaned books, if any)
		delete(this, toRemove); //remove from tree
	}
	
	/**
	 * add the given person to the database (reflect in the console)
	 * @param idTree the tree from which a person to be removed
	 * @param id the ID of the person to be added
	 * @param name the name of the person to be removed (for output convenience)
	 */
	public void add(IDTree idTree, String id, String name){
		//formated output
		System.out.println("The following person was added: " + id + ", " + name +  ".\n");
		
		IDNode toAdd = new IDNode(id, name, null, _libDB);
		insert(this, toAdd);
		
	}
	
	/**
	 * Search for a person in this tree
	 * @param id the ID number of this person
	 * @return the IDNode containing this persons data (or nil[Tree] if not found)
	 */
	public IDNode search(String id) {
		IDNode curr = (IDNode) _root; //"index"
		
		while(curr != _nil){
			if(curr.getKey().equals(id)) //found the ID
				return curr;
			//lexicographic comparison (by ID number)
			else if(id.compareTo(curr.getKey())<0)
				curr =  (IDNode) curr._left;
			else
				curr =  (IDNode) curr._right;
			
		}
		return curr; //person was not found in loop. return nil[Tree]
	}
	
	/** @return the nil[Tree] */
	@Override
	public IDNode getNil() {
		return (IDNode) _nil;
	}

	/** @return the root[Tree] */
	@Override
	public IDNode getRoot() {
		return (IDNode) _root;
	}

	/**
	 * set a new root for this tree
	 * @param z the new root to be set
	 */
	public void setRoot(IDNode z) {
		_root = z;
	}
	
}
