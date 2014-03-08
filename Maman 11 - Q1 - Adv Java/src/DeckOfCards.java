import java.util.Random;


public class DeckOfCards {

	private Card[] _deck;
	private int _currentCard;
	private static final int NUMBER_OF_CARDS = 52; //constant number of cards
	
	private static final Random randomNumbers = new Random();
	
	public DeckOfCards(){
		String[] faces = {"ACE", "Deuce", "Three", "Four", "Five", "Six", "Seven",
				"Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
		
		String[] suites = {"Hearts", "Diamonds", "Clubs", "Spades"};
		
		_deck = new Card[NUMBER_OF_CARDS];
		_currentCard = 0;
		
		for (int count = 0; count < _deck.length ; count++)
			_deck[count] = new Card(faces[count % 13], suites[count/13]);
	}
	
	public void shuffle(){
		_currentCard = 0;
		
		for ( int first = 0; first < _deck.length; first++){
			
			int second = randomNumbers.nextInt(NUMBER_OF_CARDS);
			
			Card temp = _deck[first];
			_deck[first] = _deck[second];
			_deck[second] = temp;
		} // end for loop
	} // end method shuffle
	
	public Card dealCard(){
		if (_currentCard < _deck.length)
			return _deck[_currentCard++];
		else
			return null;
	} //end method dealCard
	
}
