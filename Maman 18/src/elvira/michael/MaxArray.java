package elvira.michael;

/**
 * MaxArray.java
 * Purpose: Organizing the people by the amount of books they have
 */
public class MaxArray {
	
	private final static int MAX_BOOKS=10; //a maximum amount of books per person (as stated in the requirements)

	private List[] _maxList; //array of Lists
	
	/** Class Constructor (default) */
	public MaxArray(){
		_maxList = new List[MAX_BOOKS+1]; //adding 1 to include the possibility of 0 books
		initMaxList(); //initialize the maxList to blank lists (instead of "junk")
	}

	/**
	 * Adding a person to the list (a new costumer. has 0 books)
	 * @param link the person to be added
	 */
	public void add(Link link) {
		_maxList[0].listInsert(link);
	}

	/**
	 * removing a person from the list (a leaving costumer)
	 * @param link the person to be removed
	 * @param numOfBooks the number of books currently loaned to this person (all returned)
	 */
	public void remove(Link link, int numOfBooks){
		_maxList[numOfBooks].listDelete(link);
	}
	
	/**
	 * Moves a person to a correct position (when loans/returns a book)
	 * @param ptrLink the person to be moved
	 * @param numOfBooks the current amount of books loaned
	 * @param oldValue the amount of books loaned before this loan/return
	 */
	public void relocate(Link ptrLink, int numOfBooks, int oldValue) {
		//remove from old place in the array and add to the new place
		_maxList[oldValue].listDelete(ptrLink);
		_maxList[numOfBooks].listInsert(ptrLink);
	}
	
	/** Print (to the console) all of the people that currently hold the most books */
	public void printMaxIDs(){
		int maxBooks = findMaximum(); //find the current maximum
		
		if(maxBooks == -1){//no customers in the library
			System.out.println("The library is empty");
			return;
		}
		
		//create a String formated for output
		String str = "The following people hold the highest amount of books ("+maxBooks+") : ";
			   str += _maxList[maxBooks].toString();
		
		System.out.println(str);	
	}
	
	/* Find the current maximum number of books loaned to a person */
	private int findMaximum(){
		//iterate through all the array (from top), return the first index with non empty List
		for(int i=MAX_BOOKS; i>=0; i--){
			if(!_maxList[i].isEmpty())
				return i;
		}
		
		return -1; //Library is empty (all lists are null)
	}
	
	/* initialize the _maxList array to eliminate "junk" */
	private void initMaxList() {
		for(int i=0; i<_maxList.length ; i++){
			_maxList[i] = new List();
		}
	}
}
