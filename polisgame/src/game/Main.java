package game;

/** Main class, where starts game main thread */
public class Main{

	public static void main(String[] args) {
		
		ElementsInitializer gameElements = new ElementsInitializer();
		Game polis_game = gameElements.InitializeGameElements(); // Initializes all game elements
		
		StandardStartInitializer.standardStart(polis_game); // Initializes the game standard start position

		/*
		Boolean theEndOfTheGame = false;
		polis_game.getRound().startRound(); // Starts initial round
		
		while(!theEndOfTheGame){
			
			Boolean theEndOfTheRound = false;
			while(!theEndOfTheRound){
				
				//TODO-> Create the turn
				
				Boolean theEndOfTheTurn = false;
				while(!theEndOfTheTurn){
					
					//TODO: game.whoHasTheTurn(), after the other one.
					
					//TODO-> call to User interface "select action" method, this checks available methods and manages player decision.
					//TODO-> add action to the current turn
					
					//TODO-> 2nd action (the same with the conditions...)
					//TODO-> add action to the current turn (2th)
					
					EndTurnManager.checkBattles(polis_game);
					
					//TODO-> change who has the Turn
				}

				//TODO-> add turn to the turnList in Round
				
			}
			
		}
		
	*/}
}

//TODO finish main loop