
public class Card {

	private int _face;
	private String _suite;

	public Card(String face, String suite){
		_face = initializeValueCard(face);
		set_suite(suite);
	}

	private int initializeValueCard(String face){
		int value = 0;
		
		switch(face){ //In JAVA 7 you can use String in switch-case :)
		case "Deuce":
			value = 2;
			break;
		case "Three":
			value = 3;
			break;
		case "Four":
			value = 4;
			break;
		case "Five":
			value = 5;
			break;
		case "Six":
			value = 6;
			break;
		case "Seven":
			value = 7;
			break;
		case "Eight":
			value = 8;
			break;
		case "Nine":
			value = 9;
			break;
		case "Ten":
			value = 10;
			break;
		case "Jack":
			value = 10;
			break;
		case "Queen":
			value = 10;
			break;
		case "King":
			value = 10;
			break;
		case "Ace":
			value = 11;
			break;
		default:
			System.out.println("The card inputted value is wrong. Card has been set to \"1\".");
			value = 1;
			break;
		}

		return value;
	}


	public int getCardValue(String face, String suite){
		return _face;
	}

	public String getSuite() {
		return _suite;
	}

	public void set_suite(String suite) {
		_suite = suite;
	}
}
