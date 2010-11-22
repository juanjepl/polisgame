package game;

/** This class is responsible to initialize the game start */
public class StandardStartInitializer {

	public StandardStartInitializer(){}
	
	/** Method responsible to initialize the game start */
	public static void standardStart(Game theGame){
	
//// For Sparta	
		// Put start resources
		theGame.getSpartaPlayer().setPrestige(4);
		theGame.getSpartaPlayer().setMetal(4);
		theGame.getSpartaPlayer().setWood(4);
		theGame.getSpartaPlayer().setWine(4);
		theGame.getSpartaPlayer().setOil(4);
		theGame.getSpartaPlayer().setSilver(4);
		theGame.getSpartaPlayer().setWheat(0);
		
		// TradeDock assignation
		theGame.getSpartaPlayer().setPlayerTradeDock(theGame.getGameTradeDocks().get("spartaTradeDock"));
		
		// Capital assignation
		theGame.getSpartaPlayer().setCapital(theGame.getGamePolis().get("sparta"));
		
		// Polis assignation and polis initial population.
		theGame.getSpartaPlayer().addPolis(theGame.getGamePolis().get("sparta"));
		theGame.getSpartaPlayer().addPolis(theGame.getGamePolis().get("gythion"));
		theGame.getSpartaPlayer().addPolis(theGame.getGamePolis().get("pylos"));
		
		// Searches the polis and assign it to the player's owns (same with 2 players) 
		for(Polis p : theGame.getSpartaPlayer().getPlayerPolis()){
			if(p.getSysName().equals("sparta")){
				p.setActualPopulation(4);
				break;
			}
		}	
		for(Polis p : theGame.getSpartaPlayer().getPlayerPolis()){	
			if(p.getSysName().equals("gythion")){
				p.setActualPopulation(1);
				break;
			}
		}	
		
		for(Polis p : theGame.getSpartaPlayer().getPlayerPolis()){	
			if(p.getSysName().equals("pylos")){
				p.setActualPopulation(2);
				break;
			}
		}	
		
		
		// Units assignation
		theGame.getGameTerritories().get("laconia").addUnit(new Hoplite(theGame.getSpartaPlayer())); // 3x Hoplites at Laconia
		theGame.getGameTerritories().get("laconia").addUnit(new Hoplite(theGame.getSpartaPlayer()));
		theGame.getGameTerritories().get("laconia").addUnit(new Hoplite(theGame.getSpartaPlayer()));
		theGame.getGameSeas().get("ionianSea").addUnit(new Trirreme(theGame.getSpartaPlayer())); // A trirreme at ionian sea
		theGame.getGameSeas().get("myrtoanSea").addUnit(new Trirreme(theGame.getSpartaPlayer())); // A trirreme at myrtoan sea
		theGame.getGameTradeDocks().get("spartaTradeDock").addUnit(new TradeBoat(theGame.getSpartaPlayer())); // A trade boat at sparta's dock 
		theGame.getGamePolis().get("sparta").addUnit(new Proxenus(theGame.getSpartaPlayer())); // The proxenus in Sparta
		
//// For Athens	
		// Put start resources	
		theGame.getAthensPlayer().setPrestige(4);
		theGame.getAthensPlayer().setMetal(4);
		theGame.getAthensPlayer().setWood(4);
		theGame.getAthensPlayer().setWine(4);
		theGame.getAthensPlayer().setOil(4);
		theGame.getAthensPlayer().setSilver(0);
		theGame.getAthensPlayer().setWheat(4);

		// TradeDock assignation
		theGame.getAthensPlayer().setPlayerTradeDock(theGame.getGameTradeDocks().get("athensTradeDock"));
		
		// Capital assignation
		theGame.getAthensPlayer().setCapital(theGame.getGamePolis().get("athens"));
		
		// Polis assignation and polis initial population.
		theGame.getAthensPlayer().addPolis(theGame.getGamePolis().get("athens"));
		theGame.getAthensPlayer().addPolis(theGame.getGamePolis().get("chalcis"));
		theGame.getAthensPlayer().addPolis(theGame.getGamePolis().get("chios"));

		for(Polis p : theGame.getAthensPlayer().getPlayerPolis()){
			if(p.getSysName().equals("athens")){
				p.setActualPopulation(5);
				break;
			}
		}
		for(Polis p : theGame.getAthensPlayer().getPlayerPolis()){
			if(p.getSysName().equals("chalcis")){
				p.setActualPopulation(1);
				break;
			}
		}
		for(Polis p : theGame.getAthensPlayer().getPlayerPolis()){
			if(p.getSysName().equals("chios")){
				p.setActualPopulation(2);
				break;
			}
			
		}
	
		// Units assignation
		theGame.getGameTerritories().get("attica").addUnit(new Hoplite(theGame.getAthensPlayer())); // 3x Hoplites at Attica (assignation mode like Sparta)
		theGame.getGameTerritories().get("attica").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameTerritories().get("attica").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameTerritories().get("ionia").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameTerritories().get("ionia").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameSeas().get("cycladesIslands").addUnit(new Trirreme(theGame.getAthensPlayer()));
		theGame.getGameSeas().get("cycladesIslands").addUnit(new Trirreme(theGame.getAthensPlayer()));
		theGame.getGameSeas().get("sporadesIslands").addUnit(new Trirreme(theGame.getAthensPlayer()));
		theGame.getGameTradeDocks().get("athensTradeDock").addUnit(new TradeBoat(theGame.getAthensPlayer()));
		theGame.getGamePolis().get("athens").addUnit(new Proxenus(theGame.getAthensPlayer()));
		
	}
}
