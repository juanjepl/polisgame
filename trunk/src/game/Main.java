package game;

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
				polisGameTextInterface.showCurrentStateOfTheGame(polis_game);
				
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
						polisGameTextInterface.getMenu().setAutoExecutable(true);
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
				new EndTurnCheckBattles(polis_game);
				
				//if both player has passed turn, the round finalize and start the next
				theEndOfTheRound = polis_game.getAthensPlayer().getHasPassedTurn() == true && polis_game.getSpartaPlayer().getHasPassedTurn() == true;
				
			}
			
			polis_game.getAthensPlayer().setHasPassedTurn(false);
			polis_game.getSpartaPlayer().setHasPassedTurn(false);
			
			//Check End Round methods and prepare next round
			new EndRoundManager(polis_game);
			
			new EndGameCheckNoPrestige(polis_game, polis_game.getWhoHasTheTurn());
			new EndGameCheckCapitals(polis_game, polis_game.getWhoHasTheTurn());
			
			System.out.println("Llegados a este punto se llevarian a cabo los calculos necesarios para los fines de ronda");
			System.exit(0);
			//Show message for new Round created in EndRoundInitializeNextRound();
			//polisGameTextInterface.showChangeOfRound(polis_game.getRound());
			
		}

		new EndGameCheckNoPrestige(polis_game, polis_game.getWhoHasTheTurn());
		new EndGameCheckCapitals(polis_game, polis_game.getWhoHasTheTurn());
		new EndGameCheckStandardEndGame(polis_game, polis_game.getWhoHasTheTurn());

		//TODO Show ressume list of players and show the winner
		
	}
}

