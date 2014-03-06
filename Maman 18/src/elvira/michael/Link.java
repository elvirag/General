package elvira.michael;

/**
 * Link.java
 * Purpose: A single link in a double-linked list. Each node contains and ID and name of a person
 */
public class Link {
	
	private String _id, _name;
	private Link _next, _prev;
	
	/**
	 * Class Constructor
	 * @param id the ID number of a person
	 * @param name the name of a person
	 */
	public Link(String id, String name){
		_id=id;
		_name = name;
		_next = null;
		_prev = null;
	}
	
	/**
	 * Class Constructor (copy Constructor)
	 * @param other the Link object to be copied from
	 */
	public Link(Link other) {
		_id=other.getId();
		_name = other.getName();
		_next=_prev=null;
	}


	//GETTERS
	/** @return this persons ID number */
	public String getId() {
		return _id;
	}
	
	/** @return this persons name */
	public String getName(){
		return _name;
	}

	/** @return the node that is next to this one */
	public Link getNext() {
		return _next;
	}

	/** @return the node that is previous to this one */
	public Link getPrev() {
		return _prev;
	}

	//SETTERS
	/**
	 * Changes/initializes the ID number of this person
	 * @param id the new ID number
	 */
	public void setId(String id) {
		_id = id;
	}

	/**
	 * Changes/initializes the next Node (after this person)
	 * @param next the node to be linked after this node
	 */
	public void setNext(Link next) {
		_next = next;
	}

	/**
	 * Changes/initializes the previous Node (before this person)
	 * @param prev the node to be before after this node
	 */
	public void setPrev(Link prev) {
		_prev = prev;
	}
	
	/** @return a string containing this persons data (ID number, name) */
	@Override
	public String toString(){
		return _id+", "+_name;
	}
	
	
	
}
