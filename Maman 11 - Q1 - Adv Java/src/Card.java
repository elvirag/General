/**
 *<h4><b>Class:</b></h4>
 *Card<br>
 *Represents Cards
 *<br><br>
 *@author Elvira Gandelman
 */


public class Card {

	private int _face;
	private String _name;
	private String _suite;

	public Card(String face, String suite){
		_face = initializeValueCard(face);
		_suite = suite;
	}
	/**
	 * 
	 * @param face Gets the number on the card as a String and assigns each a value. <br>Could have used enum. <br>Didn't because had to do two things at once - assign a value and keep the string.<br><br>
	 * @return value of card
	 */
	private int initializeValueCard(String face){
		int value = 0;

		switch(face){ //In JAVA 7 you can use String in switch-case :)
		case "Deuce":
			value = 2;
			_name = "Deuce";
			break;
		case "Three":
			value = 3;
			_name = "Three";
			break;
		case "Four":
			value = 4;
			_name = "Four";
			break;
		case "Five":
			value = 5;
			_name = "Five";
			break;
		case "Six":
			value = 6;
			_name = "Six";
			break;
		case "Seven":
			value = 7;
			_name = "Seven";
			break;
		case "Eight":
			value = 8;
			_name = "Eight";
			break;
		case "Nine":
			value = 9;
			_name = "Nine";
			break;
		case "Ten":
			value = 10;
			_name = "Ten";
			break;
		case "Jack":
			value = 10;
			_name = "Jack";
			break;
		case "Queen":
			value = 10;
			_name = "Queen";
			break;
		case "King":
			value = 10;
			_name = "King";
			break;
		case "Ace":
			value = 11;
			_name = "Ace";
			break;
		default:
			System.out.println("The card inputted value is wrong. Card has been set to \"1\".");
			value = 1;
			break;
		}

		return value;
	}

	
/**
 * Gets Card value
 * @return the face of the card
 */
	public int getCardValue(){
		return _face;
	}

	/**
	 * toString() of the Class
	 * @return Name of Card as  a String
	 */
	public String toString(){
		return _name + " of " + _suite;
	}

}
