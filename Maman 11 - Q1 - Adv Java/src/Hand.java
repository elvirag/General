import java.util.ArrayList;

/**
 * <h4><b>Class:</b></h4>
 * Hand<br>
 * A class that represents a hand (of a player or of the house)<br><br>
 * @author Elvira Gandelman
 *
 */

public class Hand {

	private static final int ACE_ONE = 10; // the subtraction from the Ace so it can serve as value = 1
	private static final int BLACKJACK = 22; //The number that represents bust in BlackJack (Rules of BlackJack)
	private int _handValue; //each hand has it's value so we can know who won
	private ArrayList<Card> _hand; //the cards in hand - used arraylist because it is dynamic.
	private int countAce = 0; // checking if player/house have an ace

	/**
	 * <h3>Constructor</h3>
	 * Creates a new Hand Object, sets it's value to zero and initializes the {@link ArrayList}.
	 */
	public Hand(){
		_hand = new ArrayList<Card>(); //initializing the hand
		_handValue = 0; //initialize tha value of the hand
	}

	
	
	/**
	 * Adding a Card to the Hand
	 * @param newCard adds the new Card. If need to, count number of aces to make hand "Hard"(BlackJack term) when needed.
	 */
	public void addCard(Card newCard){
		
		_handValue += newCard.getCardValue(); //adds to handValue
		_hand.add(newCard); // adds to relevant hand
		
		if (newCard.getCardValue() == 11) // if Card is an Ace,
			countAce++; //count the aces so you know how much to subtract
	}

	
	
	/**
	 * Gets hand value, if there is an ACE and hand is or over 21, the ace is being used as 1 and the hand is now "hard". Number of aces is subtracted so it can't be subtracted again.
	 * @return _handValue - the value of the hand.
	 */
	public int getHandValue() {
		if (countAce > 0 && _handValue > BLACKJACK){ //the problem of counting aces.
			_handValue -= ACE_ONE;
			countAce--; // we need to remember that we subtracted the ace already.
		}
		return _handValue;
	}

	
	
	/**
	 * The toString() of Cards.
	 * @return A string that represents the Cards in Hand
	 */
	public String showHand(){ // it's like the toString() of Hand.
		String str = "";
		for (int i = 0 ; i < _hand.size() - 1 ; i++)
			str += _hand.get(i).toString() + ", ";
		str += _hand.get(_hand.size() - 1).toString() + ".\nHand value is: " + _handValue + ".\n"; // the _handValue is inner and no one added cards so it can be exposed here without getting the value.
		return str;
	}
}
