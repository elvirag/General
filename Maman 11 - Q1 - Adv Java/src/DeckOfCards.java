import java.util.Random;



/**
 * <h4><b>Class:</b></h4>
 * DeckOfCards<br>
 * Implements the Deck of Cards. Actions: form, shuffle and deal<br><br>
 * @author Elvira Gandelman
 *
 */
public class DeckOfCards {

	private Card[] _deck; //Array of cards
	
	private int _currentCard; // to know where in the deck we are
	private static final int NUMBER_OF_CARDS = 52; //constant number of cards in deck
	
	private static final Random randomNumbers = new Random(); //random for shuffling
	
	
	
	/**
	 * The constructor
	 * Takes all the permutations of suites & faces and feeds them into the card array.
	 */
	public DeckOfCards(){ 
		String[] faces = {"Deuce", "Three", "Four", "Five", "Six", "Seven",
				"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		
		String[] suites = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		_deck = new Card[NUMBER_OF_CARDS];
		_currentCard = 0;
		
		for (int count = 0; count < _deck.length ; count++)
			_deck[count] = new Card(faces[count % 13], suites[count/13]);
	}
	
	
	
	/**
	 * Shuffles the Deck, using the random number generator to switch cards.
	 * From Java Book.
	 */
	public void shuffle(){
		_currentCard = 0;
		
		for ( int first = 0; first < _deck.length; first++){ //goes over the whole deck
			
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			Card temp = _deck[first]; //switches places of cards that were in the place that was generated randomly
			_deck[first] = _deck[second];
			_deck[second] = temp;
		} // end for loop
	} // end method shuffle
	
	
	
	/**
	 * 
	 * @return a deck, or if fails, null (Not supposed to go over 52 cards anyway).
	 */
	public Card dealCard(){
		if (_currentCard < _deck.length)
			return _deck[_currentCard++];
		else
			return null;
	} //end method dealCard
	
}
