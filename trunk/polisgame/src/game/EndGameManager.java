package game;

/** This class contains methods to manage the final of the game, when all rounds have finished */
public class EndGameManager {

	private Player winner = null; // Player who wins the game. (null while game has not a winner)
	
	
	public EndGameManager(){}
	
	
	/** This method checks if any player has losed his capital */
	public Boolean checkCapitals(){ 
		Boolean losedCapital = false;
		
		//TODO this method checks no one player has losed his capital (game over)
		
		return losedCapital;
	}
	
	/** This method cecks if any player has losed all prestige points */
	public Boolean checkNoPrestige(){
		Boolean playerWithNoPrestige = false;
		
		//TODO this method checks no one player has losed all his prestige (game over)
		
		return playerWithNoPrestige;
	}
	
	/** This method checks the final "score" to decide a winner (following the game rules) */
	public void checkStandardEndGame(){
		
		//TODO this method tell us the winner of the game (is called standard because in the future, can be more types of endings)
		
	}
	
	public Player getWinner(){
		//TODO
		return winner;
	}
	
	/** This method ends the game */
	public void endTheGame(){
		
		//TODO
		
	}
	
}
