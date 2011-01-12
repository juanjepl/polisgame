package game;

import java.util.List;

import cfg.GameConfigurations;
import ui.TextInterface;

/** Main class, where starts game main thread */
public class Main{

	public static void main(String []args) {
		
		// First of all, we create an object type ITextInterface (the user interface(in text mode) for the game)
		TextInterface polisGameTextInterface = new TextInterface();
		
		// First menu, the main menu.
		
		polisGameTextInterface.executeMenu();

		
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
						polisGameTextInterface.showFirstActionMessage();
						polisGameTextInterface.getMenu().execute();

					}
					
					if(!(polis_game.getWhoHasTheTurn().getHasPassedTurn())){
						// First GameAction
						polisGameTextInterface.showFirstActionMessage();
						polisGameTextInterface.getMenu().execute();

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
				EndTurnCheckBattles checkBattles = new EndTurnCheckBattles(polis_game);
				//check if only one player is doing more turns. For each turn used consume one unit of resource TODO
				//TODO
				//TODO falta descontar a un jugador una unidad de recurso a elegir por el cuando el otro jugador pasa turno y el sigue usando turnos
				//TODO
			}
			
			polis_game.getAthensPlayer().setHasPassedTurn(false);
			polis_game.getSpartaPlayer().setHasPassedTurn(false);
			
			//Check End Round methods and prepare next round
			new EndRoundCheckSieges(polis_game.getWhoHasTheTurn());
			new EndRoundCheckProjects(polis_game.getWhoHasTheTurn());
			new EndRoundCheckFeeding();
			new EndRoundCheckGrowth();
			new EndRoundCheckMegalopolis(polis_game.getWhoHasTheTurn());
			new EndRoundCheckGoodsAdjust(polis_game.getWhoHasTheTurn());
			new EndRoundCheckPhoros();
			new EndRoundInitializeNextRound();
			
		}
		//TODO-> EndGameManager methods...
		
		
		
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

