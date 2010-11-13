package game;

/** Main class, where starts game main thread */
public class Main {

	public static void main(String[] args) {
		
		Game polis_game = ElementsInitializer.InitializeGameElements(); // Initializes all game elements
		StandardStartInitializer.standardStart(polis_game); // Initializes the game standard start position
		
		
		//TODO game main loop.
		
		/*
		Round gameRound = polis_game.getRound();
		
		Boolean gameEndCondition = false;
		while(gameEndCondition == false){
			
			Boolean endOfRound = false;
			while(endOfRound == false){
				
				//TODO
				//TODO
				//TODO
				
				gameRound.startRound();		
			}
		}
		 */	
		
		
		
		
	}
}
