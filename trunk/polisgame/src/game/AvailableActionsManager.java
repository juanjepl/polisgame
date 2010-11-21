package game;

/** This class contains methods for check available player's possible actions */
public class AvailableActionsManager {

	public AvailableActionsManager(){}
		
	/** This method returns if is possible to do a creator action for player */
	public static Boolean checkCreatorAction(Game game,Player player){
		Boolean available = false;

		// checks if in one of all creator actions is affirmative.
		for(Polis p : game.getGamePolis().values()){ 
			if(checkCreateHopliteAction(player,p,game.getRound())){
				available = true;
				break;
			}
			
			if(checkCreateTrirremeAction(player,p,game.getRound())){ // if, not else if.
				available = true;
				break;
			}
			
			if(checkCreateTradeBoatAction(player,p,game.getRound())){ 
				available = true;
				break;
			}
			
			if(checkCreateProxenusAction(player,p,game.getRound())){ 
				available = true;
				break;
			}
		}
			
		return available;
	}
	
	/*
	public static Boolean checkMilitaryAction(Game g,Player p){
		return checkMoveHopliteAction(g,p)||checkMoveTrirremeAction(g,p)||checkSiegePolisAction(g,p)||checkPlunderTerritoryAction(g,p);
	}
	public static Boolean checkPoliticAction(Game g,Player p){
		return checkStartProjectAction(g,p)||checkTradeAction(g,p)||checkMoveProxenusAction(g,p)||checkCivilWarAction(g,p);
	}
	*/
	
	/** Sub methods */

	public static Boolean checkCreateHopliteAction(Player player, Polis polis, Round round){
		Boolean available = false;
		
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getMetal()>= 1 || player.getSilver()>= 1;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_hasParentTerritory = polis.getPolisParentTerritory() != null;
		Boolean condition_notSieged = polis.getSieged();
		Boolean condition_TerritoryWithSlot = polis.getPolisParentTerritory().getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
		
		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_hasParentTerritory && condition_notSieged && condition_TerritoryWithSlot;
		return available;
	}
	public static Boolean checkCreateTrirremeAction(Player player, Polis polis, Round round){
		Boolean available = false;
		
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getWood()>= 1 || player.getSilver()>= 1;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_notSieged = polis.getSieged();
		Boolean condition_polisHasSea = polis.getPolisSeas().isEmpty() == false;
		Boolean condition_SeaWithSlotA = false;
		Boolean condition_SeaWithSlotB = false;
		if(polis.getPolisSeas().isEmpty() == false){ // To avoid possible exceptions
			condition_SeaWithSlotA = polis.getPolisSeas().get(0).getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
			if(polis.getPolisSeas().size() == 2){ // To avoid more possible exceptions
			condition_SeaWithSlotB = polis.getPolisSeas().get(1).getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
			}
		}
		
		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_polisHasSea && condition_notSieged && (condition_SeaWithSlotA || condition_SeaWithSlotB);
		return available;
	}
	public static Boolean checkCreateTradeBoatAction(Player player, Polis polis, Round round){
		Boolean available = false;
		//TODO
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getWood()>= 1 || player.getSilver()>= 1;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_hasTradeDock = polis.getHasTradeDock();
		Boolean condition_notSieged = polis.getSieged();
		Boolean condition_TradeDockWithSlot = player.getPlayerTradeDock().getNumberOfFreeSlotsForAPlayer(player, round)>= 1;
		
		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_hasTradeDock && condition_notSieged && condition_TradeDockWithSlot;
		return available;
	}
	public static Boolean checkCreateProxenusAction(Player player, Polis polis, Round round){
		Boolean available = false;
		
		Boolean condition_imTheOwnerOfThePolis = player.getPlayerPolis().contains(polis);
		Boolean condition_haveResources = player.getSilver()>= 5;
		Boolean condition_enoughPopulation = polis.getActualPopulation() > 1;
		Boolean condition_notSieged = polis.getSieged();
		Boolean condition_notExistsAnotherProxenus = true;
		for(Polis p: player.getPlayerPolis()){
			for(Unit u: p.getUnits()){
				if(u instanceof Proxenus){ //FIXME test it...
					condition_notExistsAnotherProxenus = false;
					break;
				}
			}
			if(!condition_notExistsAnotherProxenus){
				break; //FIXME test it...
			}
		}
		available = condition_imTheOwnerOfThePolis && condition_haveResources && condition_enoughPopulation && condition_notSieged && condition_notExistsAnotherProxenus;
		return available;
	}
	
	
	/*
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
	*/
}