package game;

import java.util.List;

import cfg.GameConfigurations;
import ui.TextInterface;

/** Main class, where starts game main thread */
public class Main{

	public static void main(String []args) {
		
		Game polis_game = null;
		// First of all, we create an object type ITextInterface (the user interface(in text mode) for the game)
		TextInterface polisGameTextInterface = new TextInterface(polis_game);
		
		// First menu, the main menu.
		
		polisGameTextInterface.executeMenu();

		
		ElementsInitializer gameElements = new ElementsInitializer();
		polis_game = gameElements.InitializeGameElements(); // Initializes all game elements
		
		StandardStartInitializer standardStartInitializer = new StandardStartInitializer();
		standardStartInitializer.standardStart(polis_game);

		while(polis_game.getWinner() == null)
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
						polisGameTextInterface.getMenu().setAutoExecutable(true);
						polisGameTextInterface.setGame(polis_game);
						polisGameTextInterface.executeMenu();

					}
					
					if(!(polis_game.getWhoHasTheTurn().getHasPassedTurn())){
						// First GameAction
						polisGameTextInterface.showSecondActionMessage();
						polisGameTextInterface.executeMenu();

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
				
				//if both player has passed turn, the round finalize and start the next
				theEndOfTheRound = polis_game.getAthensPlayer().getHasPassedTurn() && polis_game.getSpartaPlayer().getHasPassedTurn();
				
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
			
			new EndGameCheckNoPrestige(polis_game, polis_game.getWhoHasTheTurn());
			new EndGameCheckCapitals(polis_game, polis_game.getWhoHasTheTurn());
			
			//Show message for new Round created in EndRoundInitializeNextRound();
			polisGameTextInterface.showChangeOfRound(polis_game.getRound());
			
		}

		new EndGameCheckNoPrestige(polis_game, polis_game.getWhoHasTheTurn());
		new EndGameCheckCapitals(polis_game, polis_game.getWhoHasTheTurn());
		new EndGameCheckStandardEndGame(polis_game, polis_game.getWhoHasTheTurn());

		//TODO Show ressume list of players and show the winner
		
	}
}

