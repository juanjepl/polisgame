package game;

import ui.TextModeUi;

/** Main class, where starts game main thread */
public class Main{

	public static void main(String[] args) {
		
		TextModeUi userInterface = new TextModeUi();
		ElementsInitializer gameElements = new ElementsInitializer();
		Game polis_game = gameElements.InitializeGameElements(); // Initializes all game elements
		
		StandardStartInitializer.standardStart(polis_game); // Initializes the game standard start position

		
		Boolean theEndOfTheGame = false;
		polis_game.getRound().startRound(polis_game); // Starts initial round
		
		while(!theEndOfTheGame){
			
			userInterface.showNewRound(polis_game);
			Boolean theEndOfTheRound = false;
			while(!theEndOfTheRound){
				
				
				Turn actualTurn = new Turn();
				userInterface.showPlayerTurn(polis_game);
				
				Boolean theEndOfTheTurn = false;
				while(!theEndOfTheTurn){
					
					//TODO: game.whoHasTheTurn(), after the other one.
					
					//TODO-> create first action
					//TODO-> call to User interface "select action" method, this checks available methods and manages player decision.
					//TODO-> add action to the current turn
					
					//TODO-> create second action
					//TODO-> 2nd action (the same with the conditions...)
					//TODO-> add action to the current turn (2th)

					//TODO-> theEndOfTheTurn = true;	
					
					break; //FIXME !!!!!!!!!!!!!!!!!!!!!!!! REMOVE IT! only for testing.
				}
				
				// Changes the player in turn
				if(polis_game.getWhoHasTheTurn().equals(polis_game.getSpartaPlayer())){
					polis_game.setWhoHasTheTurn(polis_game.getAthensPlayer());
				}
				else{
					polis_game.setWhoHasTheTurn(polis_game.getSpartaPlayer());
				}
				
				// Checks if exists battles in the end of this turn
				EndTurnManager.checkBattles(polis_game);
				polis_game.getRound().addTurn(actualTurn);				
			}
			//TODO-> EndRoundManager methods...
		}
		//TODO-> EndGameManager methods...
		
	}
}

//TODO finish main loop

