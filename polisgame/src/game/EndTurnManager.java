package game;

import cfg.GameConfigurations;

/** This class manages, the operations to do, when a turn finishes */
public class EndTurnManager {

	public EndTurnManager(){}
	
	/** This method checks for any battles ( */
	public static void checkBattles(Game game){
		
		for(Territory terr : game.getGameTerritories().values()){
			if (terr.getUnits().size()>= GameConfigurations.getMinNumberToBattle()){ // 8 by default
				//TODO call to BattleManager
			}
			else{
				// Do nothing
			}
		}
		
		for(Sea sea : game.getGameSeas().values()){
			if(sea.getUnits().size() >= GameConfigurations.getMinNumberToBattle()){
				//TODO call to BattleManager
			}
			else{
				// Do nothing
			}
		}
	}
	
	public static void removePlundersUnitsFromTerritory()
	{
		//TODO
	}
}