package game;

/** This class contains methods to manage the final of the game, when all rounds have finished */
public class EndGameManager {

	private Player winner = null; // Player who wins the game. (null while game has not a winner)
	
	
	public EndGameManager(){}
	
	
	/** This method checks if any player has lost his capital */
	public Boolean checkCapitals(){ 
		Boolean lostCapital = false;
		
		//TODO this method checks no one player has lost his capital (game over)
		
		return lostCapital;
	}
	
	/** This method checks if any player has lost all prestige points */
	public Boolean checkNoPrestige(Player playerGamer){
		
		
		//TODO this method checks no one player has lost all his prestige (game over)
		
		return playerGamer.getPrestige() == 0;
	}
	
	/** This method checks the final "score" to decide a winner (following the game rules) */
	public void checkStandardEndGame(){
		
		//TODO this method tell us the winner of the game (is called standard because in the future, can be more types of endings)
		
	}
	
	public Player getWinner(){ // FIXME is it necessary?
		//TODO
		return winner;
	}
	
	/** This method ends the game */ //FIXME is also it necessary?
	public void endTheGame(){
		
		//TODO
		
	}
	
}
