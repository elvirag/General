public class GameLogic{

	
	private Hand _playerHand;
	private Hand _houseHand;
	//The Game Deck
	DeckOfCards _gameDeck;
	
	public GameLogic(){
		_gameDeck = new DeckOfCards();
		//shuffle it
		_gameDeck.shuffle();
		_playerHand = new Hand();
		_houseHand = new Hand();
	}
	//deal two cards to both players
	private void beginDeal(){
		
	}

	
	//"hit the house" - don't show cards. House draws till close to 21 by 3, or 21 itself (22 is too much).
	
	//"hit the player" + decisions
	
	//display cards of both players
	
	//declare winner
	
	//decide whether to continue. 
	
	//when player decides to stop or passes 21, game is decided and a prompt appears.
	
	
}
