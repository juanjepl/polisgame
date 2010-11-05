package game;

public class StandardStartInitializer { //TODO also needs initialize proyects and game events

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
		theGame.getSpartaPlayer().addPolis(theGame.getGamePolis().get("Esparta")); //TODO CASTING WILL BE NOT NECESARY IF I DIVIDE POSITIONS MAP IN GAME INTO TYPE'S MAPS
		theGame.getSpartaPlayer().addPolis(theGame.getGamePolis().get("Gition"));
		theGame.getSpartaPlayer().addPolis(theGame.getGamePolis().get("Pilos"));
		
		for(Polis p : theGame.getSpartaPlayer().getPlayerPolis()){
			if(p.getName().equals("Esparta")){
				p.setActualPopulation(4);
				break;
			}
		}	
		for(Polis p : theGame.getSpartaPlayer().getPlayerPolis()){	
			if(p.getName().equals("Gition")){
				p.setActualPopulation(1);
				break;
			}
		}	
		
		for(Polis p : theGame.getSpartaPlayer().getPlayerPolis()){	
			if(p.getName().equals("Pilos")){
				p.setActualPopulation(2);
				break;
			}
		}	
		
		
		// Units assignation
		theGame.getGameTerritories().get("Laconia").addUnit(new Hoplite(theGame.getSpartaPlayer())); // 3x Hoplites at Laconia
		theGame.getGameTerritories().get("Laconia").addUnit(new Hoplite(theGame.getSpartaPlayer()));
		theGame.getGameTerritories().get("Laconia").addUnit(new Hoplite(theGame.getSpartaPlayer()));
		theGame.getGameSeas().get("JonicoSea").addUnit(new Trirreme(theGame.getSpartaPlayer()));
		theGame.getGameSeas().get("MirtosSea").addUnit(new Trirreme(theGame.getSpartaPlayer()));
		theGame.getGameTradeDocks().get("SpartaDock").addUnit(new TradeBoat(theGame.getSpartaPlayer()));
		theGame.getGamePolis().get("Esparta").addUnit(new Proxenus(theGame.getSpartaPlayer()));
		
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
		theGame.getAthensPlayer().addPolis(theGame.getGamePolis().get("Atenas")); //TODO SAME AS SPARTA
		theGame.getAthensPlayer().addPolis(theGame.getGamePolis().get("Calcis"));
		theGame.getAthensPlayer().addPolis(theGame.getGamePolis().get("Quios"));
		
		for(Polis p : theGame.getAthensPlayer().getPlayerPolis()){
			if(p.getName().equals("Atenas")){
				p.setActualPopulation(5);
				break;
			}
		}
		for(Polis p : theGame.getAthensPlayer().getPlayerPolis()){
			if(p.getName().equals("Calcis")){
				p.setActualPopulation(1);
				break;
			}
		}
		for(Polis p : theGame.getAthensPlayer().getPlayerPolis()){
			if(p.getName().equals("Quios")){
				p.setActualPopulation(2);
				break;
			}
			
		}
	
		// Units assignation
		theGame.getGameTerritories().get("Atica").addUnit(new Hoplite(theGame.getAthensPlayer())); // 3x Hoplites at Atica
		theGame.getGameTerritories().get("Atica").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameTerritories().get("Atica").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameTerritories().get("Jonia").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameTerritories().get("Jonia").addUnit(new Hoplite(theGame.getAthensPlayer()));
		theGame.getGameSeas().get("CicladasSea").addUnit(new Trirreme(theGame.getAthensPlayer()));
		theGame.getGameSeas().get("CicladasSea").addUnit(new Trirreme(theGame.getAthensPlayer()));
		theGame.getGameSeas().get("EsporadasSea").addUnit(new Trirreme(theGame.getAthensPlayer()));
		theGame.getGameTradeDocks().get("AthensDock").addUnit(new TradeBoat(theGame.getAthensPlayer()));
		theGame.getGamePolis().get("Atenas").addUnit(new Proxenus(theGame.getAthensPlayer()));
		
	}
}
