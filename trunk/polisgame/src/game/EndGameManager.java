package game;

public class EndGameManager {

	private Player winner;
	
	public EndGameManager(){}
	
	public Boolean checkCapitals(){ 
		Boolean losedCapital = false;
		//TODO this method checks no one player has losed his capital (game over)
		return losedCapital;
	}
	
	public Boolean checkNoPrestige(){
		Boolean playerWithNoPrestige = false;
		//TODO this method checks no one player has losed all his prestige (game over)
		return playerWithNoPrestige;
	}
	
	public void checkStandardEndGame(){
		//TODO this method tell us the winner of the game (is called standard because in the future, can be more types of endings)
	}
	
	public Player getWinner(){
		//TODO
		return winner;
	}
	
	public void endTheGame(){
		//TODO
	}
	
}
