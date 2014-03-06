package elvira.michael;

/**
 * List.java
 * Purpose: Implementing a double-linked List
 *          Of type Link
 */
public class List {
	
	private Link _head; //first Link in the list
	
	/** Class Constructor (default) */
	public List(){
		_head = null;
	}
	
	/**
	 * Class Constructor (copy Constructor)
	 * @param head the Link to initialized as the start of this list
	 */
	public List(Link head){
		_head = new Link(head);
	}
	
	/**
	 * Set a head of this List
	 * @param head a node to become a new head
	 */
	public void setHead(Link head) {
		_head = new Link(head);
	}

	/**
	 * pg. 172
	 * Adds a link to the start of the list
	 * @param link a link to add
	 */
	public void listInsert(Link link) {
		link.setNext(_head);//make link point to the current head as it's next Link
		
		//if the list isn't empty, make current head point to the new link (as previous)
		if(_head != null)
			_head.setPrev(link);
		
		_head = link; //put link to be new head
		link.setPrev(null); //make sure head has no previous Link
		
	}

	/**
	 * pg.173
	 * Remove a link from this list
	 * @param ptrLink a link to be removed
	 */
	public void listDelete(Link ptrLink) {
		//make sure no other List holds ptrLink as it's next and previous. 
		//While maintaining the internal order of other Links 
		if(ptrLink.getPrev() != null)
			ptrLink.getPrev().setNext(ptrLink.getNext());
		else
			_head = ptrLink.getNext();
		if(ptrLink.getNext() != null)
			ptrLink.getNext().setPrev(ptrLink.getPrev());
		
	}
	
	/** @return true if this List is empty, and false otherwise */
	public boolean isEmpty() {
		if(_head == null)
			return true;
		
		return false;
	}
	
	/** @return A string representation of each Link in this List */
	@Override
	public String toString(){
		Link curr = _head; //"index" to iterate through the List
		String output=""; 
		
		//iterate through the list, while updating the "output" String
		while(curr!=null){
			output += curr;
			output += ";  "; //Separating between List items
			curr = curr.getNext();
		}
		
		return output;
	}
	
}
