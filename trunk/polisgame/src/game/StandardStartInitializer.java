package game;

import ui.TextModeUi;

public class StandardStartInitializer {

	public StandardStartInitializer(){}
	
	public static void standardStart(Game theGame){
	
	// Sparta	
		// Put start resources
		theGame.getSpartaPlayer().setPrestige(4);
		theGame.getSpartaPlayer().setMetal(4);
		theGame.getSpartaPlayer().setWood(4);
		theGame.getSpartaPlayer().setWine(4);
		theGame.getSpartaPlayer().setOil(4);
		theGame.getSpartaPlayer().setSilver(4);
		theGame.getSpartaPlayer().setWheat(0);
		
		// Polis assignation and polis initial population.
			//TODO
		
		// Units assignation
			//TODO
		
	// Athens	
		// Put start resources	
		theGame.getAthensPlayer().setPrestige(4);
		theGame.getAthensPlayer().setMetal(4);
		theGame.getAthensPlayer().setWood(4);
		theGame.getAthensPlayer().setWine(4);
		theGame.getAthensPlayer().setOil(4);
		theGame.getAthensPlayer().setSilver(0);
		theGame.getAthensPlayer().setWheat(4);
		
		// Polis assignation and polis initial population.
			//TODO
	
		// Units assignation
			//TODO
		
		TextModeUi.loadedStandardStartPosition(); // only screen info
		
	}
}
