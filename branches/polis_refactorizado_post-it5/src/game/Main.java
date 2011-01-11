package game;

import java.util.List;

import cfg.GameConfigurations;
import ui.TextInterface;

/** Main class, where starts game main thread */
public class Main{

	public static void main(String []args) {
		
		// First of all, we create an object type ITextInterface (the user interface(in text mode) for the game)
		TextInterface polisGameTextInterface = new TextInterface();
		
		// We show the "welcome message"
		polisGameTextInterface.showGameTitle();
		
		// First menu, the main menu.
		polisGameTextInterface.showMenuContents();
		
		polisGameTextInterface.requestPlayerNames();
		
		ElementsInitializer gameElements = new ElementsInitializer();
		Game polis_game = gameElements.InitializeGameElements(); // Initializes all game elements
		
		StandardStartInitializer standardStartInitializer = new StandardStartInitializer();
		standardStartInitializer.standardStart(polis_game);
		
		Boolean theEndOfTheGame = false;

		while(!theEndOfTheGame)
		{
			polisGameTextInterface.showNewRound(polis_game.getRound());
			
			Boolean theEndOfTheRound = false;
			while(!theEndOfTheRound){
								
				Turn actualTurn = new Turn();
				polis_game.getRound().addTurn(actualTurn);
				polisGameTextInterface.showRTAPMessage(polis_game.getWhoHasTheTurn(), polis_game.getRound().getCurrentTurn());
				
				Boolean theEndOfTheTurn = false;
				while(!theEndOfTheTurn){

					if(!(polis_game.getWhoHasTheTurn().getHasPassedTurn())){
						// First GameAction
						TextModeUi.showMessage("-- First Action from this turn --"); //FIXME rescue this from gametexts.
						TextModeUi.showAvailableActions(polis_game, polis_game.getWhoHasTheTurn());
						
						GameAction a1 = null; //FIXME
						actualTurn.addAction(a1);
					}
					
					
				}
				
			}
		}
		
		/**
		TextModeUi.creditsMessage();
		 // Initializes the game standard start position

		
		
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
						TextModeUi.showMessage("-- First Action from this turn --"); //FIXME rescue this from gametexts.
						TextModeUi.showAvailableActions(polis_game, polis_game.getWhoHasTheTurn());
						
						GameAction a1 = null; //FIXME
						actualTurn.addAction(a1);
					}
					
					if(!(polis_game.getWhoHasTheTurn().getHasPassedTurn())){
						// Second GameAction
						TextModeUi.showMessage("-- Second Action from this turn --"); //FIXME rescue this from gametexts.
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
		**/
	}
}

