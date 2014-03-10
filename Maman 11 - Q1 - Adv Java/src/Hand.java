import java.util.ArrayList;

public class Hand {

	private int _handValue;
	private ArrayList<Card> _hand;

	public Hand(){
		_hand = new ArrayList<Card>();
		_handValue = 0;
	}

	public void addCard(Card newCard){
		_handValue += newCard.getCardValue();
		_hand.add(newCard);
	}

	public int getHandValue() {
		return _handValue;
	}

	public String toString(){
		String str = null;

		for (int i = 0; i < _hand.size() ;i++){
			if (i < _hand.size()-1){
				str += _hand.get(i).toString() + ", ";
			}
			else str += _hand.get(i).toString() + ". Hand value is: " + getHandValue() + ".";
		}
		return str;
	}
}
