package game;

import ui.TextModeUi;

/** Main class, where starts game main thread */
public class Main{

	public static void main(String[] args) {
		
		TextModeUi.creditsMessage();
		ElementsInitializer gameElements = new ElementsInitializer();
		Game polis_game = gameElements.InitializeGameElements(); // Initializes all game elements
		
		StandardStartInitializer.standardStart(polis_game); // Initializes the game standard start position

		Boolean theEndOfTheGame = false;
		polis_game.getRound().startRound(polis_game); // Starts initial round
		
		while(!theEndOfTheGame){
			
			TextModeUi.showNewRound(polis_game);
			Boolean theEndOfTheRound = false;
			while(!theEndOfTheRound){
								
				Turn actualTurn = new Turn();
				TextModeUi.showPlayerTurn(polis_game);
				
				Boolean theEndOfTheTurn = false;
				while(!theEndOfTheTurn){
					
					if(!(polis_game.getWhoHasTheTurn().getHasPassedTurn())){
						// First GameAction
						TextModeUi.showAvailableActions(polis_game, polis_game.getWhoHasTheTurn());
						
						GameAction a1 = null; //FIXME
						actualTurn.addAction(a1);
					}
					
					if(!(polis_game.getWhoHasTheTurn().getHasPassedTurn())){
						// Second GameAction
						TextModeUi.showAvailableActions(polis_game, polis_game.getWhoHasTheTurn());
						
						GameAction a2 = null; //FIXME
						actualTurn.addAction(a2);
					}
					theEndOfTheTurn = true;	
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
				EndTurnManager.removePlundersUnitsFromTerritory();
				polis_game.getRound().addTurn(actualTurn);
			}
			//TODO-> EndRoundManager methods...
			polis_game.getAthensPlayer().setHasPassedTurn(false);
			polis_game.getSpartaPlayer().setHasPassedTurn(false);
		}
		//TODO-> EndGameManager methods...
		
	}
}

//TODO finish main loop

