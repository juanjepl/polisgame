package game;

/** Main class, where starts game main thread */
public class Main{

	public static void main(String[] args) {
		
		ElementsInitializer gameElements = new ElementsInitializer();
		Game polis_game = gameElements.InitializeGameElements(); // Initializes all game elements
		
		StandardStartInitializer.standardStart(polis_game); // Initializes the game standard start position
		
		Boolean theEndOfTheGame = false;
		polis_game.getRound().startRound(); // Starts initial round
		
		while(!theEndOfTheGame){
			
			//TODO GAME LOOP
			Boolean theEndOfTheRound = false;
			
			while(!theEndOfTheRound){
				
				
				
			}
			//
		}
		
	}
}
