import java.util.ArrayList;

public class Hand {

	private static final int ACE_ONE = 10; // the subtraction from the Ace so it can serve as value = 1
	private int _handValue;
	private ArrayList<Card> _hand;
	private boolean gotAce = false; // checking if player/house have an ace

	public Hand(){
		_hand = new ArrayList<Card>();
		_handValue = 0;
	}

	public void addCard(Card newCard){
		_handValue += newCard.getCardValue();
		_hand.add(newCard);
	}

	public int getHandValue() {
		if (!gotAce)
			for (int i = 0 ; i < _hand.size() ; i++)
				if (_hand.get(i).getCardValue() == 11)
					gotAce = true;
		if (gotAce && _handValue > 20){
			_handValue -= ACE_ONE;
		}
		return _handValue;
	}

	public String showHand(){ // it's like the toString() of Hand.
		String str = "";
		for (int i = 0 ; i < _hand.size() - 1 ; i++)
			str += _hand.get(i).toString() + ", ";
		str += _hand.get(_hand.size() - 1).toString() + ".\nHand value is: " + getHandValue() + ".\n";
		return str;
	}
}
