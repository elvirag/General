import javax.swing.JOptionPane;

/**
 * <h4><b>Class:</b></h4>
 * GameLogic<br>
 * The total logic of the game. The heart of the game.<br><br>
 *@author Elvira Gandelman
 *
 */


public class GameLogic{


	private static final int FIRST_DEAL = 2; // How many cards to deal at first. (Rules of BlackJack)
	private static final int MAX_HAND_VALUE = 17; //By researching, house usually holds if it's 17 or more (Rules of BlackJack)
	private static final int BLACKJACK = 21; //The number that represents BlackJack (Rules of BlackJack)
	private Hand _playerHand; //the hand of the player.
	private Hand _houseHand; //the hand of the house
	private DeckOfCards _gameDeck; 	//The Game Deck
	private GameLogic _newGame; //an instance of the game
	public JOptionPane _pane = new JOptionPane(); //our lovely GUI pane :)


	/**
	 * The Constructor
	 * Does what is needed to initialize the game:<br> Gets a deck, shuffles it and initializes the two hands - <b>house</b> and <b>player</b>.
	 */
	public GameLogic(){
		_gameDeck = new DeckOfCards(); //setting up a new deck
		_gameDeck.shuffle(); // shuffle deck before starting to deal.
		_playerHand = new Hand(); //setting up a hand for the player
		_houseHand = new Hand(); //setting up a hand for the House/Dealer.
	} // end of Constructor

	
	/**
	 * The only public method. Begins the game.
	 */
	public void beginPlay(){
		JOptionPane.showMessageDialog(_pane, "Welcome to BlackJack!"); // shows a panel welcoming us
		beginDeal(); //begins deal
		hitHouse(); //deals the house till bust or holds.
		hitPlayer();//deals the player  + input
	} //end of beginPlay

	
	
	/**
	 * Deals two cards to both players
	 */
	private void beginDeal(){
		for (int i = 0; i < FIRST_DEAL; i++){
			_playerHand.addCard(_gameDeck.dealCard());
			_houseHand.addCard(_gameDeck.dealCard());
		}
	}

	
	/**
	 * Deals the house till it has 17 or more (bust or hold)
	 */
	private void hitHouse(){
		while (_houseHand.getHandValue() < MAX_HAND_VALUE){
			_houseHand.addCard(_gameDeck.dealCard());
		}
	}

	
	/**
	 * Displays a dialogue that shows the player the cards he has in hand and asks if the player wants to add a card to his hand
	 * @return An answer if the player wants to draw another card or to hold
	 */
	private int drawCards(){
		int input = JOptionPane.showConfirmDialog(null, _playerHand.showHand() +
				"Would you like to draw another card?\n", "Draw another card?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return input;
	}// end showCards method

	
	/**
	 * While the player wants to draw cards, draws.<br>
	 * If player busts, displays a message that stops the game and displays the results.
	 */
	private void hitPlayer() {
		while (drawCards() == JOptionPane.YES_OPTION) { // till the player doesn't want another card
			_playerHand.addCard(_gameDeck.dealCard()); //take another card
			if (_playerHand.getHandValue() >= BLACKJACK) { //if bust, show dialog with "BUST" and stop drawing.
				JOptionPane.showMessageDialog(null, "Sorry, your hand value is higher than " + BLACKJACK + "\nLet's see how the house did...\n\nClick \"OK\" to see the results.\n", "Your Hand is over 21...", JOptionPane.PLAIN_MESSAGE);
				break; //stops the dialog from showing, so the player can't draw more cards.
			}
		}
		determineWinLose(); //check who won or lost
		newGame(); //ask about starting a new game
	}
	

	/**
	 * Has Strings to display in message of results.
	 * <br>Displays the hands of both players and their values.
	 * <br><br>
	 * Determines the result of the game relatively to the player.
	 * <br><br>
	 * <h3><b>Rules:</b></h3>
	 *<b>Tie:</b> Both house & player have over 21. Also, when both of them have below 21 but same values, it's a tie.</br >
	 *<b>Win:</b> Both under 21 but player is closer to 21. Also, when house is over 21 and player isn't.</br >
	 *<b>Lose:</b> Both are less that 21 but house is closer to 21 than player. Also, when player is over 21 but house isn't.</br >
	 * */
	private void determineWinLose(){ //when player is done taking cards, go here...

		String win = " *** You have won the game! ***\n      (^_^)      \n";
		String lose = "You have lost\n          -_-  \n";
		String tie = "It's a tie...\n  o_O  \n";

		String result = "";

		int player = _playerHand.getHandValue();
		int house = _houseHand.getHandValue();

		if ( (player >= BLACKJACK && house >= BLACKJACK ) || (player == house) )
			result = tie;
		else if ( player >= BLACKJACK && house < BLACKJACK)
			result = lose;
		else if ( ( (house < BLACKJACK) && (player < BLACKJACK) ) && (house > player) )
			result = lose;
		else if (house >= BLACKJACK && player < BLACKJACK)
			result = win;
		else if ( ( (house < BLACKJACK) && (player < BLACKJACK) ) && (house < player) )
			result = win;
		//no else here, isn't supposed to happen, was here only for debugging purposes
		//
		JOptionPane.showMessageDialog(null, "House: " + _houseHand.showHand() + "\nYou: " + _playerHand.showHand() + "\n\nThe resulf of the game is:\n" + result + "\n", "***Game Result***", JOptionPane.PLAIN_MESSAGE);
	}

	
	/**
	 * Asks the player if he wants to play again.<br><br>
	 * <b>Yes:</b> Initializes a new Game and sets the constructor.<br>
	 * <b>No:</b> Displays a message and exits.
	 */
	private void newGame() {
		int input = JOptionPane.showConfirmDialog(null, "Would you like to play again?\n","Game has ended",JOptionPane.YES_NO_OPTION);
		if (input == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Thank you for playing!\nBye Bye!","Game Over", JOptionPane.PLAIN_MESSAGE);
			System.exit(0);
		}
		else if (input == JOptionPane.YES_OPTION){
			_newGame = new GameLogic();
			_newGame.beginPlay();
		}
	}

}
