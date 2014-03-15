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
		//hitPlayer();
	}
	//deal two cards to both players
	private void beginDeal(){
		System.out.print("\nInside beginDeal...\n"); //TODO
		for (int i = 0; i < FIRST_DEAL; i++){
		_playerHand.addCard(_gameDeck.dealCard());
		_houseHand.addCard(_gameDeck.dealCard());
		}
	}
	
	private void hitHouse(){
		System.out.print("\nInside hitHouse...\n"); //TODO
		while (_houseHand.getHandValue() < MAX_HAND_VALUE){
			_houseHand.addCard(_gameDeck.dealCard());
			showCards(); // to make sure that the last card didn't make us go over board and also if there is an ace, to fix it.
		}
	}
	
	public int showCards(){
		int input = JOptionPane.showConfirmDialog(null, _playerHand.showHand() + "Would you like to draw another?", "Draw another card?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		return input;
	}
	
	private void hitPlayer() {
		if (showCards() == JOptionPane.YES_OPTION){
			if (_playerHand.getHandValue() >= BLACKJACK)
			{
				int input = JOptionPane.showConfirmDialog(null, "Sorry, you have lost.\n Player: " + _playerHand.showHand() + "\nHouse: " + _houseHand.showHand(), "House wins!\n Would you like another game?", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
				newGame(input);
			}
		}
	}
	
	public void newGame(int input) {
		System.out.print("input = " + input + " yes: " + JOptionPane.YES_OPTION + " no: " + JOptionPane.NO_OPTION + "\n");
		if (input == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Thank you for playing!\nBye Bye!","Game Over", JOptionPane.PLAIN_MESSAGE);
		}
		else if (input == JOptionPane.YES_OPTION){
			_newGame = new GameLogic();
			_newGame.beginPlay();
		}
		
	}

	public void displayCards(){
		//Don't think it's necessary. Maybe only to print it in a message.
	}
	
	//"hit the player" + decisions
	
	//display cards of both players
	
	//declare winner
	
	//decide whether to continue. 
	
	//when player decides to stop or passes 21, game is decided and a prompt appears.
	
	
}
