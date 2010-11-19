package game;

/** This class contains methods for check available player's possible actions */
public class AvailableActionsManager {

	/** This method returns the possible actions to do for player p */
	public AvailableActionsManager(){}
		
	public static Boolean checkCreatorAction(Game g,Player p){
		return checkCreateHopliteAction(g,p)||checkCreateTrirremeAction(g,p)||checkCreateTradeBoatAction(g,p)||checkCreateProxenusAction(g,p);
	}
	public static Boolean checkMilitaryAction(Game g,Player p){
		return checkMoveHopliteAction(g,p)||checkMoveTrirremeAction(g,p)||checkSiegePolisAction(g,p)||checkPlunderTerritoryAction(g,p);
	}
	public static Boolean checkPoliticAction(Game g,Player p){
		return checkStartProjectAction(g,p)||checkTradeAction(g,p)||checkMoveProxenusAction(g,p)||checkCivilWarAction(g,p);
	}
	
	/** Sub methods */
	
	public static Boolean checkCreateHopliteAction(Game g,Player p){
		Boolean available = false;
		//TODO returns the polis availables to create hoplites?
		
		// Checks if player have resources to pay the action
		Boolean condition_haveResources = p.getMetal()>= 2 || p.getSilver()>= 2;
		if(condition_haveResources){
			for(Polis city : p.getPlayerPolis()){
				Boolean condition_enoughPopulation = city.getActualPopulation() > 1;
				Boolean condition_hasParentTerritory = city.getPolisParentTerritory() != null;
				Boolean condition_notSieged = city.getSieged();
				Boolean condition_TerritoryWithSlot = false;
				for(Unit u : city.getPolisParentTerritory().getUnits()){
					Integer ownUnits = 0;
					if(u.getOwner().equals(p)){
						ownUnits += 1;
					}
					if(g.getRound().getMaximumPositionSlotsForThisRound() > ownUnits){ // > , not >=
						condition_TerritoryWithSlot = true;
					}
					
				}
				
				if(condition_enoughPopulation && condition_hasParentTerritory && condition_notSieged && condition_TerritoryWithSlot){
					available = true;
					break;
				}
			}
			
		}else{
			//Do nothing, available still false
		}
		return available;
	}
	public static Boolean checkCreateTrirremeAction(Game g,Player p){
		Boolean available = false;
		return available;
		//TODO
	}
	public static Boolean checkCreateTradeBoatAction(Game g,Player p){
		Boolean available = false;
		return available;
		//TODO
	}
	public static Boolean checkCreateProxenusAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	
	public static Boolean checkMoveHopliteAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkMoveTrirremeAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkSiegePolisAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkPlunderTerritoryAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}

	public static Boolean checkStartProjectAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkTradeAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkMoveProxenusAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	public static Boolean checkCivilWarAction(Game g,Player p){
		Boolean available = false;
		//TODO
		return available;
	}
	
}