import javax.swing.JOptionPane;

public class GameLogic{


	private static final int FIRST_DEAL = 2;
	private static final int MAX_HAND_VALUE = 18;
	private static final int BLACKJACK = 21;
	private Hand _playerHand;
	private Hand _houseHand;
	private DeckOfCards _gameDeck; 	//The Game Deck
	private GameLogic _newGame;
	public JOptionPane _pane = new JOptionPane();

	public GameLogic(){
		_gameDeck = new DeckOfCards();
		_gameDeck.shuffle(); // shuffle deck before starting to deal.
		_playerHand = new Hand();
		_houseHand = new Hand();
	}

	public void beginPlay(){
		JOptionPane.showMessageDialog(_pane, "Welcome to BlackJack!");
		beginDeal();
		hitHouse();
		hitPlayer();
	}

	//deal two cards to both players
	private void beginDeal(){
		for (int i = 0; i < FIRST_DEAL; i++){
			_playerHand.addCard(_gameDeck.dealCard());
			_houseHand.addCard(_gameDeck.dealCard());
		}
	}

	private void hitHouse(){
		while (_houseHand.getHandValue() < MAX_HAND_VALUE){
			_houseHand.addCard(_gameDeck.dealCard());
		}
	}

	public int showCards(){ // only shows the cards of the player
		int input = JOptionPane.showConfirmDialog(null, _playerHand.showHand() +
				"Would you like to draw another?", "Draw another card?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return input;
	}

	private void hitPlayer() {
		while (showCards() == JOptionPane.YES_OPTION) {
			_playerHand.addCard(_gameDeck.dealCard());
		}
		newGame(determineWinLose());
	}

	public void newGame(int input) {
		if (input == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Thank you for playing!\nBye Bye!","Game Over", JOptionPane.PLAIN_MESSAGE);
		}
		else if (input == JOptionPane.YES_OPTION){
			_newGame = new GameLogic();
			_newGame.beginPlay();
		}

	}

	public int determineWinLose(){ //when player is done taking cards, go here...

		String result;
		if (_playerHand.getHandValue() > _houseHand.getHandValue() && _playerHand.getHandValue() < BLACKJACK){ //win
			result = " *** You have won the game! *** (^_^)\n";
		}
		else if (_playerHand.getHandValue() < _houseHand.getHandValue() && _houseHand.getHandValue() < BLACKJACK){ //lose
			result = "You have lost. -_-\n";
		}
		else{ //tie
			result = "It's a tie... o_O\n";
		}
		int input = JOptionPane.showConfirmDialog(null, "House: " + _houseHand.showHand() + "\nYou: " + _playerHand.showHand() + "\n\nThe resulf of the game is:\n" + result + "\n\nWould you like to play again?", "***Game Result***", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);

		return input;
	}
	
}
